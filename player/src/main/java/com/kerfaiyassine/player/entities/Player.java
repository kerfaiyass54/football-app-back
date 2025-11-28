package com.kerfaiyassine.player.entities;


import com.kerfaiyassine.player.enums.PlayerPosition;
import com.kerfaiyassine.player.enums.PlayerSituation;
import com.kerfaiyassine.player.enums.PlayerStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document(collection = "player")
public class Player {

    @Id
    private long id;
    private String name;
    private String nationality;
    private PlayerPosition position;
    private double ability;
    private int age;
    private PlayerStatus status;
    private double marketValue;
    private PlayerSituation lineup;
    private int number;
    private List<Long> contracts;
    private double height;
    private double weight;

}
