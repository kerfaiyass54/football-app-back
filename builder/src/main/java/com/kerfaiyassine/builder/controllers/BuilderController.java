package com.kerfaiyassine.builder.controllers;


import com.kerfaiyassine.builder.services.BuilderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/builder")
@CrossOrigin("*")
public class BuilderController {

    private final BuilderService builderService;

    public BuilderController(BuilderService builderService) {
        this.builderService = builderService;
    }


}
