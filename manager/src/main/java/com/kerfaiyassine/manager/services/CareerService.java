package com.kerfaiyassine.manager.services;


import com.kerfaiyassine.manager.dtos.CareerDTO;
import com.kerfaiyassine.manager.dtos.ContractsDTO;
import com.kerfaiyassine.manager.entities.Career;
import com.kerfaiyassine.manager.enums.CareerStatus;
import com.kerfaiyassine.manager.repositories.CareerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CareerService {

    private final CareerRepository careerRepository;

    public CareerService(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    public Career mapToCareer(CareerDTO  careerDTO) {
        Career career = new Career();
        career.setDuration(careerDTO.getDuration());
        career.setYearStart(careerDTO.getYearStart());
        career.setTeamId(careerDTO.getTeamId());
        career.setManagerId(careerDTO.getManagerId());
        career.setRenewable(careerDTO.isRenewable());
        career.setStatus(CareerStatus.ASKED);
        return career;
    }

    public ContractsDTO mapToContractsDTO(Career career) {
        ContractsDTO contractsDTO = new ContractsDTO();
        contractsDTO.setDuration(career.getDuration());
        contractsDTO.setYearStart(career.getYearStart());
        contractsDTO.setTeamId(career.getTeamId());
        contractsDTO.setManagerId(career.getManagerId());
        contractsDTO.setRenewable(career.isRenewable());
        contractsDTO.setStatus(career.getStatus());
        return contractsDTO;
    }


    public Career addNewContract(CareerDTO careerDTO) {
        return  careerRepository.save(mapToCareer(careerDTO));
    }


}
