package com.example.equipment.component;

import com.example.equipment.dto.EquipmentDTO;
import com.example.equipment.entity.Equipment;
import org.springframework.stereotype.Component;

@Component
public class EquipmentMapper {
    public Equipment convertToEntity(EquipmentDTO equipmentDTO) {
        Equipment equipment = new Equipment();
        equipment.setName(equipmentDTO.getName());
        equipment.setManufacturer(equipmentDTO.getManufacturer());
        equipment.setModel(equipmentDTO.getModel());
        equipment.setDescription(equipmentDTO.getDescription());
        equipment.setPurchaseDate(equipmentDTO.getPurchaseDate());
        equipment.setPrice(equipmentDTO.getPrice());
        equipment.setSerialNumber(equipmentDTO.getSerialNumber());
        equipment.setLocation(equipmentDTO.getLocation());
        equipment.setStatus(equipmentDTO.getStatus());
        return equipment;
    }
}
