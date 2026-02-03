package com.kerfaiyassine.supporter.services;


import com.kerfaiyassine.supporter.DTOs.SupporterDTO;
import com.kerfaiyassine.supporter.entities.Location;
import com.kerfaiyassine.supporter.entities.Supporter;
import com.kerfaiyassine.supporter.repositories.LocationRepository;
import com.kerfaiyassine.supporter.repositories.SupporterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SupporterService {

    private final SupporterRepository supporterRepository;
    private final LocationRepository locationRepository;

    public SupporterService(SupporterRepository supporterRepository, LocationRepository locationRepository) {
        this.supporterRepository = supporterRepository;
        this.locationRepository = locationRepository;
    }

    public SupporterDTO mapToDTO(Supporter supporter) {
        SupporterDTO supporterDTO = new SupporterDTO();
        supporterDTO.setName(supporter.getName());
        supporterDTO.setLocationId(supporter.getLocationId());
        return supporterDTO;
    }

    public Supporter save(SupporterDTO supporter) {
        Supporter supporterEntity = new Supporter();
        supporterEntity.setName(supporter.getName());
        supporterEntity.setLocationId(supporter.getLocationId());
        supporterRepository.save(supporterEntity);
        return supporterEntity;
    }


    public SupporterDTO getSupporterByID(String id) {
        return  mapToDTO(supporterRepository.findById(id).get());
    }

    public List<SupporterDTO> getSupportersByLocation(String location) {
        return supporterRepository.findSupporterByLocationId(locationRepository.findLocationByName(location).getId()).stream().map(this::mapToDTO).toList();
    }

    public List<SupporterDTO> getAllSupporters() {
        return supporterRepository.findAll().stream().map(this::mapToDTO).toList();
    }

    public void deleteSupporterByID(String id) {
        supporterRepository.deleteById(id);
    }

    public SupporterDTO getByName(String name) {
        return mapToDTO(supporterRepository.findSupporterByName(name));
    }

    public List<SupporterDTO> getByNationality(String nationality) {
        return supporterRepository.findSupporterByNationality(nationality).stream().map(this::mapToDTO).toList();
    }

    public void assignLocation(String locationName,String name){
        Location location = locationRepository.findLocationByName(locationName);
        supporterRepository.findSupporterByName(name).setLocationId(location.getId());
    }


}
