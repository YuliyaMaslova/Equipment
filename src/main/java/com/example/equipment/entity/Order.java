package com.example.equipment.entity;

import com.example.equipment.model.RequestStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private User user;
    private LocalDateTime orderDate;
    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "smallint")
    private RequestStatus status; // todo заменить на использование enum

    @ManyToMany
    @JoinTable(name = "order_equipment", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private List<Equipment> products;

}
