package com.example.equipment.service;

import com.example.equipment.entity.Order;
import com.example.equipment.entity.User;
import com.example.equipment.repository.OrderRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll(LocalDateTime fromDate, LocalDateTime toDate) {
        Specification<Order> spec = OrderRepository.betweenOrderDate(fromDate, toDate);

        return orderRepository.findAll(spec);
    }

    @Override
    public List<Order> getOrdersByUser(int userId) {
        User user = new User();
        user.setId(userId);
        return orderRepository.findByUser(user);
    }
}
// created_date between 1 and 2 and author_id = 10
//        Specification<Order> and = spec.and();