package com.example.equipment.service;

import com.example.equipment.entity.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    List<Order> findAll(LocalDateTime fromDate, LocalDateTime toDate);

    List<Order> getOrdersByUser(int userId);

    void saveOrder(Order newOrder);
}
