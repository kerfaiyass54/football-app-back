package com.kerfaiyassine.manager.controllers;


import com.kerfaiyassine.manager.dtos.ManagerCreationDTO;
import com.kerfaiyassine.manager.dtos.ManagerDTO;
import com.kerfaiyassine.manager.dtos.ManagerStatusDTO;
import com.kerfaiyassine.manager.entities.Manager;
import com.kerfaiyassine.manager.enums.ManagerStatus;
import com.kerfaiyassine.manager.services.ManagerService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@RestController
@RequestMapping("/manager")
@CrossOrigin("*")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/status")
    public ResponseEntity<Page<ManagerStatusDTO>> getManagersWithStatus(@RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "5") int size) {
        Page<ManagerStatusDTO> managerStatusDTOPage = managerService.getManagersWithStatus(page, size);
        return ResponseEntity.ok(managerStatusDTOPage);
    }

    @GetMapping("/nationality")
    public ResponseEntity<Page<ManagerDTO>> getManagersByNationality(@RequestParam String nationality, @RequestParam(defaultValue = "0") int page,
                                                                     @RequestParam(defaultValue = "5") int size){
        Page<ManagerDTO> managers = managerService.getManagersByNationality(nationality, page, size);
        return ResponseEntity.ok(managers);
    }

    @PatchMapping("/")
    public ResponseEntity<Void> changeStatus(@RequestParam String id, @RequestParam ManagerStatus managerStatus){
        managerService.changeStatus(id,managerStatus);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<ManagerDTO> getManagerById(@PathVariable String id){
        ManagerDTO managerDTO = managerService.getManager(id);
        if (managerDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(managerDTO);
    }

    @GetMapping("/")
    public ResponseEntity<Page<ManagerDTO>> getAllManagers(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "5") int size){
        Page<ManagerDTO> managerDTOS = managerService.getManagers(page, size);
        return ResponseEntity.ok(managerDTOS);
    }

    @PostMapping("/")
    public ResponseEntity<ManagerDTO> addManager(@RequestBody ManagerCreationDTO managerCreationDTO){
        ManagerDTO manager = managerService.addManager(managerCreationDTO);
        return ResponseEntity.status(201).body(manager);
    }

    @GetMapping("/stats")
    public ResponseEntity<Integer> numberOfManagerByStatus(@RequestParam ManagerStatus managerStatus){
        Integer managerNumber = managerService.numberOfManagerByStatus(managerStatus);
        return ResponseEntity.ok(managerNumber);
    }

}
