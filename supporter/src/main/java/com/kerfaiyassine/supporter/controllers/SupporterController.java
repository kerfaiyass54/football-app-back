package com.kerfaiyassine.supporter.controllers;


import com.kerfaiyassine.supporter.DTOs.LocationSupporter;
import com.kerfaiyassine.supporter.DTOs.SupporterDTO;
import com.kerfaiyassine.supporter.entities.Supporter;
import com.kerfaiyassine.supporter.services.SupporterService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supporter")
@CrossOrigin("*")
public class SupporterController {

    private final SupporterService  supporterService;

    public SupporterController(SupporterService supporterService) {
        this.supporterService = supporterService;
    }


    @PostMapping("/")
    public ResponseEntity<Supporter> addSupporter(@RequestBody SupporterDTO supporter) {
        Supporter supporter1 = supporterService.save(supporter);
        return ResponseEntity.ok(supporter1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupporterDTO>  getSupporter(@PathVariable String id) {
        SupporterDTO supporterDTO = supporterService.getSupporterByID(id);
        return ResponseEntity.ok(supporterDTO);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<SupporterDTO>> getSupporterByLocation(@PathVariable String location) {
        List<SupporterDTO> supporterDTOS = supporterService.getSupportersByLocation(location);
        return ResponseEntity.ok(supporterDTOS);
    }

    @GetMapping("/list")
    public ResponseEntity<List<SupporterDTO>> getAllSupporters() {
        List<SupporterDTO> supporterDTOS = supporterService.getAllSupporters();
        return ResponseEntity.ok(supporterDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupporter(@PathVariable String id) {
        supporterService.deleteSupporterByID(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<SupporterDTO> getSupporterByName(@PathVariable String name) {
        SupporterDTO supporter = supporterService.getByName(name);
        return ResponseEntity.ok(supporter);
    }

    @GetMapping("/nationality/{nationality}")
    public ResponseEntity<List<SupporterDTO>> getAllSupportersByNationality(@PathVariable String nationality) {
        List<SupporterDTO> supporterDTOS = supporterService.getByNationality(nationality);
        return ResponseEntity.ok(supporterDTOS);
    }

    @PutMapping("/")
    public ResponseEntity<Void> assignLocation(@RequestBody LocationSupporter locationSupporter) {
        supporterService.assignLocation(locationSupporter.getLocationName(),locationSupporter.getName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity<Page<SupporterDTO>> getAllSupportersPaged(int page, int size) {
        Page<SupporterDTO> supporterDTOS = supporterService.getAllSupportersPaged(page, size);
        return ResponseEntity.ok(supporterDTOS);
    }


}
