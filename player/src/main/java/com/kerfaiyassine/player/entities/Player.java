package com.kerfaiyassine.player.entities;


import com.kerfaiyassine.player.enums.PlayerPosition;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Player {

    private String id;
    private String name;
    private String nationality;
    private PlayerPosition position;
    private double ability;
    private int age;

}
