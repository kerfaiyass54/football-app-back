package com.kerfaiyassine.team.repositories;

import com.kerfaiyassine.team.entities.Team;
import com.kerfaiyassine.team.enums.TeamStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TeamRepository extends MongoRepository<Team, String> {

    public Team findTeamByName(String name);
    public List<Team> findTeamsByStatus(TeamStatus status);
    public List<Team> findTeamsByCity(String city);
    public List<Team> findTeamsByEstablishYear(int establishYear);
    public Team findTeamById(String id);
}
