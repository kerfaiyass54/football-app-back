package com.kerfaiyassine.manager.services;


import com.kerfaiyassine.manager.dtos.ManagerCreationDTO;
import com.kerfaiyassine.manager.dtos.ManagerDTO;
import com.kerfaiyassine.manager.dtos.ManagerStatusDTO;
import com.kerfaiyassine.manager.entities.Manager;
import com.kerfaiyassine.manager.enums.ManagerStatus;
import com.kerfaiyassine.manager.repositories.ManagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class ManagerService {

    private final ManagerRepository managerRepository;
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public ManagerDTO mapToDTO(Manager manager) {
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setId(manager.getId());
        managerDTO.setName(manager.getName());
        managerDTO.setStatus(manager.getStatus());
        managerDTO.setNationality(manager.getNationality());
        managerDTO.setYearOfBirth(manager.getYearOfBirth());
        return managerDTO;
    }

    public Manager mapToCreation(ManagerCreationDTO managerCreationDTO) {
        Manager manager = new Manager();
        manager.setName(managerCreationDTO.getName());
        manager.setNationality(managerCreationDTO.getNationality());
        manager.setYearOfBirth(managerCreationDTO.getYearOfBirth());
        manager.setStatus(ManagerStatus.FREE);
        return manager;
    }

    public ManagerStatusDTO mapToStatusDTO(Manager manager) {
        ManagerStatusDTO managerStatusDTO = new ManagerStatusDTO();
        managerStatusDTO.setName(manager.getName());
        managerStatusDTO.setStatus(manager.getStatus());
        return managerStatusDTO;
    }

    public Manager addManager(ManagerCreationDTO managerCreationDTO) {
        return  managerRepository.save(mapToCreation(managerCreationDTO));
    }

    public Page<ManagerDTO> getManagers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return managerRepository.findAll(pageable).map(this::mapToDTO);
    }

    public ManagerDTO getManager(String id){
        return mapToDTO(managerRepository.findManagerById(id));
    }

    public void changeStatus(String id, ManagerStatus managerStatus) {
        Manager manager = managerRepository.findManagerById(id);
        manager.setStatus(managerStatus);
        managerRepository.save(manager);
    }

    public Page<ManagerDTO> getManagersByNationality(String nationality, int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        return managerRepository.findManagersByNationality(nationality,pageable).map(this::mapToDTO);
    }


    public Page<ManagerStatusDTO> getManagersWithStatus(int size, int page){
        Pageable pageable = PageRequest.of(page, size);
        return managerRepository.findAll(pageable).map(this::mapToStatusDTO);
    }

    public Integer numberOfManagerByStatus(ManagerStatus managerStatus) {
        return managerRepository.findManagersByStatus(managerStatus).size();
    }

    public Map<ManagerStatus, Integer> countManagersGroupedByStatus() {

        Map<ManagerStatus, Integer> result = new EnumMap<>(ManagerStatus.class);

        for (ManagerStatus status : ManagerStatus.values()) {
            result.put(status, managerRepository.countManagersByStatus(status));
        }

        return result;
    }


}
