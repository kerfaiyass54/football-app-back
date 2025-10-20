package com.kerfaiyassine.builder;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Builder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;

    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Column(name="nationality", nullable = false)
    private String nationality;

    @Column(name="expertise")
    private String expertise;

    @Column(name="year_established")
    private int yearEstablished;

    @Column(name="price", nullable = false)
    private int price;



}
