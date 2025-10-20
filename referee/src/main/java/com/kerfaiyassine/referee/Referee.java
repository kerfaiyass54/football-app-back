package com.kerfaiyassine.referee;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Referee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;

    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Column(name="nationality", nullable = false)
    private String nationality;

    @Column(name="organizer_id", nullable = false)
    private long organizerId;

}
