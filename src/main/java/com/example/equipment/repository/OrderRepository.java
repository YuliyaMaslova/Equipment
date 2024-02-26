package com.example.equipment.repository;

import com.example.equipment.entity.Order;
import com.example.equipment.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>, JpaSpecificationExecutor<Order> {

    static Specification<Order> betweenOrderDate(LocalDateTime orderDate, LocalDateTime toDate) {
        return (order, cq, cb) -> cb.between(order.get("orderDate"), orderDate, toDate);
    }

    List<Order> findByUser(User user);

    @Query("SELECT o FROM Order o WHERE o.orderDate < :currentDate")
    List<Order> findPreviousOrders(@Param("currentDate") LocalDateTime currentDate);

}
