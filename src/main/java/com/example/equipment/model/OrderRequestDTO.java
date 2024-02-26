package com.example.equipment.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {
    private List<Long> equipmentIds;
    private String comment;
}
