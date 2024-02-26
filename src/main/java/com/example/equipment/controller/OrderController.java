package com.example.equipment.controller;

import com.example.equipment.entity.Equipment;
import com.example.equipment.entity.Order;
import com.example.equipment.model.OrderFormResponseDTO;
import com.example.equipment.model.OrderRequestDTO;
import com.example.equipment.model.RequestStatus;
import com.example.equipment.service.EquipmentServiceImpl;
import com.example.equipment.service.OrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderServiceImpl orderService;
    private final EquipmentServiceImpl equipmentService;

    @PostMapping
    public ResponseEntity<String> submitOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        try {
            Order newOrder = new Order();
            List<Equipment> equipmentList = new ArrayList<>();
            for (Long equipmentId : orderRequestDTO.getEquipmentIds()) {
                Equipment equipment = equipmentService.getEquipmentById(equipmentId);
                equipmentList.add(equipment);
            }
            newOrder.setEquipmentList(equipmentList);
            newOrder.setComment(orderRequestDTO.getComment());
            newOrder.setStatus(RequestStatus.PENDING);

            orderService.saveOrder(newOrder);

            return ResponseEntity.ok("Order submitted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/order")
    public ResponseEntity<OrderFormResponseDTO> showOrderForm() {
        List<Order> previousOrders = orderService.getPreviousOrders();

        OrderFormResponseDTO responseDTO = new OrderFormResponseDTO();
        responseDTO.setPreviousOrders(previousOrders);

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public  List<Order> getAllOrders(@RequestParam("fromDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                         LocalDateTime fromDate,
                                   @RequestParam("toDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                   LocalDateTime toDate) {
        return orderService.findAll(fromDate, toDate);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable int userId) {
        return orderService.getOrdersByUser(userId);
    }
}
