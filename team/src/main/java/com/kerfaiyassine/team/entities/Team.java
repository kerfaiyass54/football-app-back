package com.kerfaiyassine.team.entities;

import com.kerfaiyassine.team.enums.TeamStatus;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "team")
public class Team {

    @Id
    private long id;
    private String name;
    private int establishYear;
    private int rank;
    private String city;
    private TeamStatus status;
    private int budget;
}
