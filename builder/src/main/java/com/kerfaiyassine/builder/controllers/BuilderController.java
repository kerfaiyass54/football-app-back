package com.kerfaiyassine.builder.controllers;


import com.kerfaiyassine.builder.DTOs.BuilderDTO;
import com.kerfaiyassine.builder.entities.Builder;
import com.kerfaiyassine.builder.enums.Expertise;
import com.kerfaiyassine.builder.services.BuilderService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/builder")
@CrossOrigin("*")
public class BuilderController {

    private final BuilderService builderService;

    public BuilderController(BuilderService builderService) {
        this.builderService = builderService;
    }

    @PostMapping("/")
    public ResponseEntity<Builder> createBuilder(@RequestBody BuilderDTO builderDTO){
        Builder builder = builderService.createBuilder(builderDTO);
        return new ResponseEntity<>(builder, HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<BuilderDTO> getBuilder(@PathVariable Integer id){
        BuilderDTO builderDTO = builderService.getBuilderById(id);
        return new ResponseEntity<>(builderDTO, HttpStatus.OK);
    }

    @GetMapping("/nationality/{nationality}")
    public ResponseEntity<List<BuilderDTO>> getBuildersByNationality(@PathVariable String nationality){
        List<BuilderDTO> builders = builderService.getBuilderByNationality(nationality);
        return new ResponseEntity<>(builders, HttpStatus.OK);
    }

    @GetMapping("/expertise/{expertise}")
    public ResponseEntity<List<BuilderDTO>> getBuildersByExpertise(@PathVariable Expertise expertise){
        List<BuilderDTO> builders = builderService.getBuilderByExpertise(expertise);
        return new ResponseEntity<>(builders, HttpStatus.OK);
    }

    @PutMapping("/price/{id}/{price}")
    public ResponseEntity<Void> updateBuilder(@PathVariable Integer id, @PathVariable Integer price){
        builderService.updateBuilderPrice(id, price);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Page<BuilderDTO>> getAllBuilders(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "5") int size){
        Page<BuilderDTO> builders = builderService.getAllBuilders(page, size);
        return new ResponseEntity<>(builders, HttpStatus.OK);
    }



}
