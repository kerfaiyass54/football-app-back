package com.kerfaiyassine.manager.entities;


import com.kerfaiyassine.manager.enums.ManagerStatus;
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
@Document(collection = "manager")
public class Manager {

    @Id
    private long id;
    private String name;
    private int yearOfBirth;
    private ManagerStatus status;
    private String nationality;
    private List<Long> careers;
}
