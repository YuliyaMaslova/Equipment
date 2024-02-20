package com.example.equipment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
