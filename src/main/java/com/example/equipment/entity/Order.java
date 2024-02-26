package com.example.equipment.entity;

import com.example.equipment.model.RequestStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @Enumerated(EnumType.STRING)
    private RequestStatus status; // todo заменить на использование enum

    @ManyToMany
    @JoinTable(name = "order_equipment", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private List<Equipment> products;

    public void addEquipment(Equipment equipmentById) {

        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(equipmentById);

    }

    public void setComment(String comment) {

    }

    public void setEquipmentList(List<Equipment> equipmentList) {

    }
}
