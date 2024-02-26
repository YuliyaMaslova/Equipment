package com.example.equipment.service;

import com.example.equipment.component.EquipmentMapper;
import com.example.equipment.model.EquipmentDTO;
import com.example.equipment.entity.Equipment;
import com.example.equipment.entity.User;
import com.example.equipment.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;


    public EquipmentServiceImpl(EquipmentRepository equipmentRepository,
                                EquipmentMapper equipmentMapper) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentMapper = equipmentMapper;

    }

    @Override
    public void saveEquipment(EquipmentDTO equipmentDTO) {
        Equipment equipment = equipmentMapper.convertToEntity(equipmentDTO);
        equipmentRepository.save(equipment);

    }

    @Override
    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }


    public Equipment getEquipmentById(Long equipmentId) {
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipmentId);
        return optionalEquipment.orElseGet(() -> null);

    }
}
