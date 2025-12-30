package com.kerfaiyassine.manager.entities;


import com.kerfaiyassine.manager.enums.CareerStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document(collection = "career")
public class Career {

    @Id
    private long id;
    private int duration;
    private int yearStart;
    private CareerStatus status;
    private boolean renewable;
    private long managerId;
    private long teamId;


}
