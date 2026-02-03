package com.kerfaiyassine.supporter.repositories;

import com.kerfaiyassine.supporter.entities.Location;
import com.kerfaiyassine.supporter.entities.Supporter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {

}
