package com.kerfaiyassine.manager.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CareerDTO {

    private long managerId;
    private long teamId;
    private int duration;
    private boolean renewable;
    private int yearStart;
}
