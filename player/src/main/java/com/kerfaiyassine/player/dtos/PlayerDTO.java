package com.kerfaiyassine.player.dtos;


import com.kerfaiyassine.player.enums.PlayerPosition;
import com.kerfaiyassine.player.enums.PlayerSituation;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PlayerDTO {

    private String name;
    private int age;
    private String nationality;
    private PlayerPosition position;
    private double ability;
    private String team;
    private PlayerSituation situation;
    private double marketValue;
    private double height;
    private double weight;
}
