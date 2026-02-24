package com.kerfaiyassine.organizer.services;


import com.kerfaiyassine.organizer.dtos.OrganizerDTO;
import com.kerfaiyassine.organizer.entities.Organizer;
import com.kerfaiyassine.organizer.repositories.OrganizerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrganizerService {

    private final OrganizerRepository organizerRepository;

    public OrganizerService(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }

    public OrganizerDTO mapToDTO(Organizer organizer) {
        OrganizerDTO organizerDTO = new OrganizerDTO();
        organizerDTO.setId(organizer.getId());
        organizerDTO.setName(organizer.getName());
        return organizerDTO;
    }

    public Organizer addNewOrganizer(String name){
        Organizer organizer = new Organizer();
        organizer.setName(name);
        return organizerRepository.save(organizer);
    }

    public void updateOrganizer(Integer id, String name){
        Organizer organizer = organizerRepository.findById(id).get();
        organizer.setName(name);
        organizerRepository.save(organizer);
    }

    public OrganizerDTO getOrganizerById(Integer id){
        Organizer organizer = organizerRepository.findById(id).get();
        return mapToDTO(organizer);
    }

    public Page<OrganizerDTO> getOrganizers(int size, int page){
        Pageable pageable = PageRequest.of(page, size);
        return organizerRepository.findAll(pageable).map(this::mapToDTO);
    }

    public void deleteOrganizer(Integer id){
        organizerRepository.deleteById(id);
    }
}
