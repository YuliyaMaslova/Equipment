package com.example.equipment.service;

import com.example.equipment.dto.EquipmentDTO;
import com.example.equipment.entity.Equipment;

import java.util.List;

public interface EquipmentService {

    public void saveEquipment(EquipmentDTO equipmentDTO);
    public void deleteEquipment(Long id);

    public List<Equipment> getAllEquipment();


}
