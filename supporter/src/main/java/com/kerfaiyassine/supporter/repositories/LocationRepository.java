package com.kerfaiyassine.supporter.repositories;

import com.kerfaiyassine.supporter.entities.Location;
import com.kerfaiyassine.supporter.entities.Supporter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LocationRepository extends MongoRepository<Location, String> {

    Location findLocationByName(String name);

    Page<Location> findLocationByContinent(String continent, Pageable pageable);
}
