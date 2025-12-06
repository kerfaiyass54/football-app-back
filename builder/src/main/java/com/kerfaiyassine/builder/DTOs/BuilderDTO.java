package com.kerfaiyassine.builder.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.kerfaiyassine.builder.enums.Expertise;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BuilderDTO {

    private Integer Id;
    private String name;
    private String nationality;
    private Expertise expertise;
    private int yearEstablished;
    private int price;

}
