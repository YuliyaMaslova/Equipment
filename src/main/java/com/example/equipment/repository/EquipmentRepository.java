package com.example.equipment.repository;

import com.example.equipment.dto.EquipmentDTO;
import com.example.equipment.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {



}
