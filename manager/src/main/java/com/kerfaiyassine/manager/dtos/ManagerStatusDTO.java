package com.kerfaiyassine.manager.dtos;


import com.kerfaiyassine.manager.enums.ManagerStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ManagerStatusDTO {

    private ManagerStatus status;
    private String name;

}
