package com.kerfaiyassine.supporter.repositories;

import com.kerfaiyassine.supporter.entities.Supporter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SupporterRepository extends MongoRepository<Supporter, String> {

    List<Supporter> findSupporterByNationality(String nationality);

    List<Supporter> findSupporterByLocationId(String locationId);

    Supporter findSupporterByName(String name);

}
