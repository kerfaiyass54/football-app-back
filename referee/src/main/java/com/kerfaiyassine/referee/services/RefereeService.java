package com.kerfaiyassine.referee.services;


import com.kerfaiyassine.referee.dtos.RefereeDTO;
import com.kerfaiyassine.referee.entities.Referee;
import com.kerfaiyassine.referee.repositories.RefereeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RefereeService {

    private final RefereeRepository refereeRepository;

    public RefereeService(RefereeRepository refereeRepository) {
        this.refereeRepository = refereeRepository;
    }

    public RefereeDTO mapToDTO(Referee referee) {
        RefereeDTO refereeDTO = new RefereeDTO();
        refereeDTO.setId(referee.getId());
        refereeDTO.setName(referee.getName());
        refereeDTO.setNationality(referee.getNationality());
        return refereeDTO;
    }

    public Referee addReferee(RefereeDTO referee) {
        Referee referee1 = new Referee();
        referee1.setId(referee.getId());
        referee1.setName(referee.getName());
        referee1.setNationality(referee.getNationality());
        return refereeRepository.save(referee1);
    }

    public RefereeDTO getRefereeByName(String name) {

        Referee referee = refereeRepository.findRefereeByName(name);
        RefereeDTO refereeDTO = mapToDTO(referee);
        return refereeDTO;
    }

    public RefereeDTO getReferee(Integer id){
        RefereeDTO refereeDTO = new RefereeDTO();
        Optional<Referee> referee = refereeRepository.findById(id);
        if(referee.isPresent()){
            refereeDTO.setId(referee.get().getId());
            refereeDTO.setName(referee.get().getName());
            refereeDTO.setNationality(referee.get().getNationality());
        }
        return refereeDTO;
    }


    public void deleteReferee(Integer id) {
        refereeRepository.deleteById(id);
    }
}


