package com.kerfaiyassine.player.entities;


import com.kerfaiyassine.player.enums.PlayerPosition;
import com.kerfaiyassine.player.enums.PlayerSituation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
    private PlayerSituation situation;
    private double marketValue;

    @DBRef
    private List<Contract> contracts;

}
