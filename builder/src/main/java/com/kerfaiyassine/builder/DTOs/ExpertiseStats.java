package com.kerfaiyassine.builder.DTOs;


import com.kerfaiyassine.builder.enums.Expertise;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExpertiseStats {

    @NotNull
    private Expertise expertise;

    @NotNull
    private int numberOfBuilders;
}
