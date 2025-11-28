package com.kerfaiyassine.builder.entities;


import com.kerfaiyassine.builder.enums.Expertise;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="builder")
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
    @Enumerated(EnumType.STRING)
    private Expertise expertise;

    @Column(name="year_established")
    private int yearEstablished;

    @Column(name="price", nullable = false)
    private int price;



}
