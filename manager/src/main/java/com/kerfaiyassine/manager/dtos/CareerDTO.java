package com.kerfaiyassine.manager.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CareerDTO {

    private long careerId;
    private long teamId;
    private int duration;
    private boolean renewable;
}
