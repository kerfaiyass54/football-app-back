package com.kerfaiyassine.organizer.controllers;


import com.kerfaiyassine.organizer.dtos.OrganizerDTO;
import com.kerfaiyassine.organizer.entities.Organizer;
import com.kerfaiyassine.organizer.services.OrganizerService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organizer")
@CrossOrigin("*")
public class OrganizerController {

    private final OrganizerService organizerService;

    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @PostMapping("/{name}")
    public ResponseEntity<Organizer> addNewOrganizer(@PathVariable String name){
        Organizer organizer = organizerService.addNewOrganizer(name);
        return new ResponseEntity<>(organizer, HttpStatus.OK);
    }

    @PutMapping("/{id}/{name}")
    public ResponseEntity<Void>  updateOrganizer(@PathVariable Integer id, @PathVariable String name){
        organizerService.updateOrganizer(id, name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizerDTO> getOrganizer(@PathVariable Integer id){
        OrganizerDTO organizerDTO = organizerService.getOrganizerById(id);
        return new ResponseEntity<>(organizerDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Page<OrganizerDTO>> getOrganizers(@RequestParam int size, @RequestParam int page){
        Page<OrganizerDTO> organizerDTOs = organizerService.getOrganizers(size, page);
        return new ResponseEntity<>(organizerDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Integer id){
        organizerService.deleteOrganizer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
