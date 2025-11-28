package com.kerfaiyassine.player.entities;


import com.kerfaiyassine.player.enums.ContractStatus;
import com.kerfaiyassine.player.enums.ContractType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document(collection = "contract")
public class Contract {

    @Id
    private long id;
    private int duration;
    private int yearStart;
    private boolean renewable;
    private ContractType contractType;
    private ContractStatus contractStatus;
    private long teamId;
    private long playerId;
}
