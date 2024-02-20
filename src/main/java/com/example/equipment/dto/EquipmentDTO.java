package com.example.equipment.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EquipmentDTO {
    private String name;
    private String manufacturer;
    private String model;
    private String description;
    private LocalDate purchaseDate;
    private BigDecimal price;
    private String serialNumber;
    private String location;
    private String status;
}
