package com.kerfaiyassine.team.repositories;

import com.kerfaiyassine.team.entities.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, Long> {

}
