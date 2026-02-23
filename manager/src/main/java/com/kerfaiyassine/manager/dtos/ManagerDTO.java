package com.kerfaiyassine.manager.dtos;


import com.kerfaiyassine.manager.enums.ManagerStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ManagerDTO {
    private String id;
    private String name;
    private int yearOfBirth;
    private ManagerStatus status;
    private String nationality;
}
