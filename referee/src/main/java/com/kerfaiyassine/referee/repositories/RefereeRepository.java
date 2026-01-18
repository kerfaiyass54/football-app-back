package com.kerfaiyassine.referee.repositories;

import com.kerfaiyassine.referee.entities.Referee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RefereeRepository extends CrudRepository<Referee, Integer> {

    public Referee findRefereeByName(String name);

    public List<Referee> findRefereesByNationality(String nationality);
}
