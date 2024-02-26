package com.example.equipment.model;


import com.example.equipment.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderFormResponseDTO {
    private List<Order> previousOrders;
}
