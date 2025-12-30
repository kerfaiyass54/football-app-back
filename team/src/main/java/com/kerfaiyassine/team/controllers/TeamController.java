package com.kerfaiyassine.team.controllers;


import com.kerfaiyassine.team.dto.TeamCreationDTO;
import com.kerfaiyassine.team.dto.TeamDTO;
import com.kerfaiyassine.team.dto.TeamRanking;
import com.kerfaiyassine.team.entities.Team;
import com.kerfaiyassine.team.enums.TeamStatus;
import com.kerfaiyassine.team.repositories.TeamRepository;
import com.kerfaiyassine.team.services.TeamService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
@CrossOrigin("*")
public class TeamController {

    private final TeamService  teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<TeamDTO>> getAllTeams(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "5") int size){
        Page<TeamDTO> teams = teamService.getAllTeams(page, size);
        return ResponseEntity.ok(teams);
    }

    @PostMapping("/")
    public ResponseEntity<Team>  createTeam(@RequestBody TeamCreationDTO teamDTO){
        Team team = teamService.addNewTeam(teamDTO);
        return ResponseEntity.ok(team);
    }

    @GetMapping("/rank")
    public ResponseEntity<Page<TeamRanking>> getTeamRanking(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "5") int size){
        Page<TeamRanking> rankings = teamService.getTeamsRanking(page, size);
        return ResponseEntity.ok(rankings);
    }

    @PutMapping("/{id}/{teamStatus}")
    public ResponseEntity<Void> changeStatus(@PathVariable long id, @PathVariable TeamStatus teamStatus){
        teamService.changeStatus(id, teamStatus);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/{budget}")
    public ResponseEntity<Void> updateBudget(@PathVariable long id, @PathVariable int budget){
        teamService.updateBudget(id, budget);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{year}")
    public ResponseEntity<List<TeamDTO>> getTeamsByYear(@PathVariable int year){
        return ResponseEntity.ok(teamService.getTeamsByYear(year));
    }

    @GetMapping("/{city}")
    public ResponseEntity<List<TeamDTO>> getTeamsByCity(@PathVariable String city){
        return ResponseEntity.ok(teamService.getTeamsByCity(city));
    }

    @GetMapping("/{teamStatus}")
    public ResponseEntity<List<TeamDTO>> getTeamsByTeamStatus(@PathVariable TeamStatus teamStatus){
        return ResponseEntity.ok(teamService.getTeamsByTeamStatus(teamStatus));
    }

    @GetMapping("/{name}")
    public ResponseEntity<TeamDTO> getTeamsByName(@PathVariable String name){
        return ResponseEntity.ok(teamService.getTeamByName(name));
    }
}
