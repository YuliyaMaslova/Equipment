package com.example.equipment.entity;

import com.example.equipment.model.RequestStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

//@Data
//@Entity
//@Table(name = "request")
//public class Request {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private LocalDateTime createdDateTime;
//    private String status;
//    @Enumerated(EnumType.STRING)
//    private RequestStatus requestStatus;
//
//
//    @ManyToOne
//    @JoinColumn(name = "equipment_id")
//    private Equipment equipment;
//
//
//}
