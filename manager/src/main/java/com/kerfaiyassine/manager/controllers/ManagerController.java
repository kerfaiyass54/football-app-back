package com.kerfaiyassine.manager.controllers;


import com.kerfaiyassine.manager.dtos.ManagerCreationDTO;
import com.kerfaiyassine.manager.dtos.ManagerDTO;
import com.kerfaiyassine.manager.dtos.ManagerStatusDTO;
import com.kerfaiyassine.manager.entities.Manager;
import com.kerfaiyassine.manager.enums.ManagerStatus;
import com.kerfaiyassine.manager.services.ManagerService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/nationality/{nationality}")
    public ResponseEntity<Page<ManagerDTO>> getManagersByNationality(@PathVariable String nationality, @RequestParam(defaultValue = "0") int page,
                                                                     @RequestParam(defaultValue = "5") int size){
        Page<ManagerDTO> managers = managerService.getManagersByNationality(nationality, page, size);
        return ResponseEntity.ok(managers);
    }

    @PutMapping("/{id}/{managerStatus}")
    public ResponseEntity<Void> changeStatus(@PathVariable String id, @PathVariable ManagerStatus managerStatus){
        managerService.changeStatus(id,managerStatus);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManagerDTO> getManagerById(@PathVariable String id){
        ManagerDTO managerDTO = managerService.getManager(id);
        return ResponseEntity.ok(managerDTO);
    }

    @GetMapping("/")
    public ResponseEntity<Page<ManagerDTO>> getAllManagers(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "5") int size){
        Page<ManagerDTO> managerDTOS = managerService.getManagers(page, size);
        return ResponseEntity.ok(managerDTOS);
    }

    @PostMapping("/")
    public ResponseEntity<Manager> addManager(@RequestBody ManagerCreationDTO managerCreationDTO){
        Manager manager = managerService.addManager(managerCreationDTO);
        return ResponseEntity.ok(manager);
    }

    @GetMapping("/stats/number/{managerStatus}")
    public ResponseEntity<Integer> numberOfManagerByStatus(@PathVariable ManagerStatus managerStatus){
        Integer managerNumber = managerService.numberOfManagerByStatus(managerStatus);
        return ResponseEntity.ok(managerNumber);
    }

    @GetMapping("/number")
    public ResponseEntity<Map<ManagerStatus, Integer>> numberOfManagersByStatus() {
        return ResponseEntity.ok(managerService.countManagersGroupedByStatus());
    }
}
