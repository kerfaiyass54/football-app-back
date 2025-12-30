package com.kerfaiyassine.manager.dtos;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ManagerCreationDTO {

    private String name;
    private int yearOfBirth;
    private String nationality;
}
