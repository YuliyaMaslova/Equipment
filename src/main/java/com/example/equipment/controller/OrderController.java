package com.example.equipment.controller;

import com.example.equipment.entity.Order;
import com.example.equipment.service.OrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderServiceImpl orderService;

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
