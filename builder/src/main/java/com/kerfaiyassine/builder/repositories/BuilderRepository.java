package com.kerfaiyassine.builder.repositories;

import com.kerfaiyassine.builder.entities.Builder;
import com.kerfaiyassine.builder.enums.Expertise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuilderRepository extends JpaRepository<Builder, Integer> {

    public Builder findBuilderById(Integer id);

    public List<Builder>  findBuilderByNationality(String nationality);

    public List<Builder> findBuildersByExpertise(Expertise expertise);

    public Page<Builder> findAll(Pageable pageable);
}
