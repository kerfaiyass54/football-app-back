package com.kerfaiyassine.player.entities;


import com.kerfaiyassine.player.enums.PlayerPosition;
import com.kerfaiyassine.player.enums.PlayerSituation;
import com.kerfaiyassine.player.enums.PlayerStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
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
    private int yearOfBirth;
    private PlayerStatus status;
    private double marketValue;
    private PlayerSituation lineup;
    private int number;
    private List<Long> contracts;
    private double height;
    private double weight;

}
