package com.kerfaiyassine.builder.repositories;

import com.kerfaiyassine.builder.entities.Builder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuilderRepository extends JpaRepository<Builder, Integer> {

    public Builder findBuilderById(Integer id);
}
