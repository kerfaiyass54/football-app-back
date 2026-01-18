package com.kerfaiyassine.player.services;


import com.kerfaiyassine.player.dtos.PlayerDTO;
import com.kerfaiyassine.player.entities.Player;
import com.kerfaiyassine.player.enums.PlayerSituation;
import com.kerfaiyassine.player.enums.PlayerStatus;
import com.kerfaiyassine.player.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerDTO mapToDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName(player.getName());
        playerDTO.setNationality(player.getNationality());
        playerDTO.setPosition(player.getPosition());
        playerDTO.setAbility(player.getAbility());
        playerDTO.setSituation(player.getLineup());
        playerDTO.setMarketValue(player.getMarketValue());
        playerDTO.setHeight(player.getHeight());
        playerDTO.setWeight(player.getWeight());
        playerDTO.setYearOfBirth(player.getYearOfBirth());
        playerDTO.setStatus(player.getStatus());
        return playerDTO;
    }

    public Player addPlayer(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setName(playerDTO.getName());
        player.setNationality(playerDTO.getNationality());
        player.setPosition(playerDTO.getPosition());
        player.setAbility(65);
        player.setYearOfBirth(playerDTO.getYearOfBirth());
        player.setMarketValue(0);
        player.setLineup(PlayerSituation.FREE);
        player.setNumber(0);
        player.setWeight(playerDTO.getWeight());
        player.setStatus(PlayerStatus.NEW);
        return playerRepository.save(player);
    }


    public PlayerDTO getPlayerById(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            return mapToDTO(player.get());
        }
        return null;
    }

    public PlayerDTO getPlayerByName(String name) {
        return mapToDTO(playerRepository.findPlayerByName(name));
    }

    public List<PlayerDTO> getAllPlayersByNationality(String nationality) {
        return playerRepository.findPlayersByNationality(nationality).stream().map(this::mapToDTO).toList();
    }

    public Player updatePlayer(PlayerDTO playerDTO,Long id) {
        Player player = playerRepository.findPlayerById(id);
        player.setName(playerDTO.getName());
        player.setNationality(playerDTO.getNationality());
        player.setPosition(playerDTO.getPosition());
        player.setAbility(playerDTO.getAbility());
        player.setYearOfBirth(playerDTO.getYearOfBirth());
        player.setWeight(playerDTO.getWeight());
        player.setStatus(playerDTO.getStatus());
        player.setMarketValue(playerDTO.getMarketValue());
        player.setHeight(playerDTO.getHeight());
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }


}
