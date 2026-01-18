package com.kerfaiyassine.referee.controllers;


import com.kerfaiyassine.referee.dtos.RefereeDTO;
import com.kerfaiyassine.referee.entities.Referee;
import com.kerfaiyassine.referee.services.RefereeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/referee")
@CrossOrigin("*")
public class RefereeController {

    private final RefereeService refereeService;

    public RefereeController(RefereeService refereeService) {
        this.refereeService = refereeService;
    }


    @PostMapping("/")
    public ResponseEntity<Referee> saveReferee(@RequestBody RefereeDTO refereeDTO) {
        Referee referee = refereeService.addReferee(refereeDTO);
        return ResponseEntity.ok(referee);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RefereeDTO> getReferee(@PathVariable("name") String name) {
        RefereeDTO refereeDTO = refereeService.getRefereeByName(name);
        return ResponseEntity.ok(refereeDTO);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RefereeDTO> getReferee(@PathVariable("id") Integer id) {
        RefereeDTO refereeDTO = refereeService.getReferee(id);
        return ResponseEntity.ok(refereeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReferee(@PathVariable("id") Integer id) {
        refereeService.deleteReferee(id);
        return ResponseEntity.ok().build();
    }
}
