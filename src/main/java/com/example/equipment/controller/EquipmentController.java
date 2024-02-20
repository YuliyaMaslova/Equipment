package com.example.equipment.controller;

import com.example.equipment.dto.EquipmentDTO;
import com.example.equipment.entity.Equipment;
import com.example.equipment.service.EquipmentServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
@AllArgsConstructor
public class EquipmentController {
    private static final Logger logger = LoggerFactory.getLogger(EquipmentController.class);
    private final EquipmentServiceImpl equipmentService;
    @GetMapping()
    public ModelAndView getAllEquipment() {
        logger.info("Getting all equipment");
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        ModelAndView modelAndView = new ModelAndView("equipment");
        modelAndView.addObject("equipmentList", equipmentList);
        return modelAndView;
    }



    @PostMapping
    public ResponseEntity<String> createEquipment(@RequestBody EquipmentDTO equipmentDTO) {
        logger.info("Creating new equipment: {}", equipmentDTO);
        try {
            equipmentService.saveEquipment(equipmentDTO);
            return new ResponseEntity<>("Equipment created successfully", HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEquipment(@PathVariable Long id) {
        try {
            equipmentService.deleteEquipment(id);

            return new ResponseEntity<>("Equipment deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}


