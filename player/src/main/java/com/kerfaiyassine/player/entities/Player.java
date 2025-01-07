package com.kerfaiyassine.player.entities;


import com.kerfaiyassine.player.enums.PlayerPosition;
import com.kerfaiyassine.player.enums.PlayerSituation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document(collection = "player")
public class Player {

    @Id
    private String id;
    private String name;
    private String nationality;
    private PlayerPosition position;
    private double ability;
    private int age;
    private PlayerSituation situation;
    private double marketValue;

}
