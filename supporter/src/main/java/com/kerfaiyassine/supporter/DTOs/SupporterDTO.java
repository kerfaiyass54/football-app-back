package com.kerfaiyassine.supporter.DTOs;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SupporterDTO {

    private String id;
    private String name;
    private String nationality;
    private String locationId;
}
