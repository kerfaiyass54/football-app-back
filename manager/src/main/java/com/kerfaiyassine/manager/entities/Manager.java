package com.kerfaiyassine.manager.entities;


import com.kerfaiyassine.manager.enums.ManagerStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "managers")
public class Manager {

    @Id
    private String id;
    
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @Min(1950)
    private Integer yearOfBirth;
    
    @NotNull
    private ManagerStatus status;
    
    @NotNull
    @Size(max = 30)
    private String nationality;
    
    
    private List<Long> careers;
}
