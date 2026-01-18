package com.kerfaiyassine.player.controllers;


import com.kerfaiyassine.player.dtos.PlayerDTO;
import com.kerfaiyassine.player.entities.Player;
import com.kerfaiyassine.player.repositories.PlayerRepository;
import com.kerfaiyassine.player.services.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@CrossOrigin("*")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/")
    public ResponseEntity<Player> createPlayer(@RequestBody PlayerDTO playerDTO) {
        Player  player = playerService.addPlayer(playerDTO);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> findPlayerById(@PathVariable Long id) {
        PlayerDTO playerDTO = playerService.getPlayerById(id);
        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<PlayerDTO> findPlayerByName(@PathVariable String name) {
        PlayerDTO playerDTO = playerService.getPlayerByName(name);
        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }

    @GetMapping("/nationality/{nationality}")
    public ResponseEntity<List<PlayerDTO>> findAllPlayersByNationality(@PathVariable String nationality) {
        List<PlayerDTO> players = playerService.getAllPlayersByNationality(nationality);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
        Player player = playerService.updatePlayer(playerDTO, id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
