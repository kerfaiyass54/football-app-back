package com.kerfaiyassine.builder.services;


import com.kerfaiyassine.builder.DTOs.BuilderDTO;
import com.kerfaiyassine.builder.DTOs.ExpertiseStats;
import com.kerfaiyassine.builder.DTOs.YearsMAxMin;
import com.kerfaiyassine.builder.entities.Builder;
import com.kerfaiyassine.builder.enums.Expertise;
import com.kerfaiyassine.builder.repositories.BuilderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BuilderService {

    @Autowired
    private BuilderRepository builderRepository;

    public BuilderDTO mapToDTO(Builder builder) {
        BuilderDTO dto = new BuilderDTO();
        dto.setId(builder.getId());
        dto.setName(builder.getName());
        dto.setPrice(builder.getPrice());
        dto.setExpertise(builder.getExpertise());
        dto.setNationality(builder.getNationality());
        dto.setYearEstablished(builder.getYearEstablished());
        return dto;
    }

    public Builder createBuilder(BuilderDTO builderDTO) {
        Builder builder = new Builder();
        builder.setName(builderDTO.getName());
        builder.setExpertise(builderDTO.getExpertise());
        builder.setPrice(builderDTO.getPrice());
        builder.setNationality(builderDTO.getNationality());
        builder.setYearEstablished(builderDTO.getYearEstablished());
        return builderRepository.save(builder);
    }

    public BuilderDTO getBuilderById(Integer id) {
        return  mapToDTO(builderRepository.findBuilderById(id));
    }

    public List<BuilderDTO> getBuilderByNationality(String nationality) {
        return builderRepository.findBuilderByNationality(nationality).stream().map(this::mapToDTO).toList();
    }

    public List<BuilderDTO> getBuilderByExpertise(Expertise expertise) {
        return builderRepository.findBuildersByExpertise(expertise).stream().map(this::mapToDTO).toList();
    }

    public void updateBuilderPrice(Integer id, BigDecimal price) {
        Builder builder = builderRepository.findBuilderById(id);
        builder.setPrice(price);
        builderRepository.save(builder);
    }

    public Page<BuilderDTO> getAllBuilders(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return builderRepository.findAll(pageable).map(this::mapToDTO);
    }

    public ExpertiseStats countBuilders(Expertise expertise) {

        long count = builderRepository.countByExpertise(expertise);

        return new ExpertiseStats(expertise, (int) count);
    }

    public YearsMAxMin getYoungestAndOldest() {

        List<Integer> years = builderRepository.findAll()
                .stream()
                .map(Builder::getYearEstablished)
                .toList();

        YearsMAxMin result = new YearsMAxMin();

        if (years.isEmpty()) {
            result.setMinYear(0);
            result.setMaxYear(0);
            return result;
        }

        result.setMinYear(Collections.min(years));
        result.setMaxYear(Collections.max(years));

        return result;
    }

    public String getMostNationality() {

        return builderRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Builder::getNationality,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }









}
