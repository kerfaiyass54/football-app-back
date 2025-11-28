package com.kerfaiyassine.builder.services;


import com.kerfaiyassine.builder.repositories.BuilderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BuilderService {

    private final BuilderRepository builderRepository;

}
