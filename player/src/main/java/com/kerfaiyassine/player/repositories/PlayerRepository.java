package com.kerfaiyassine.player.repositories;


import com.kerfaiyassine.player.entities.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String > {
}
