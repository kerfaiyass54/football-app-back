package com.kerfaiyassine.player.repositories;


import com.kerfaiyassine.player.entities.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlayerRepository extends MongoRepository<Player, Long> {

    public Player findPlayerByName(String name);

    public List<Player> findPlayersByNationality(String nationality);

    public Player findPlayerById(String id);
}
