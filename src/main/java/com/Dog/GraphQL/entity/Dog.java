package com.Dog.GraphQL.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    private String origin;

    public Dog(String name, String breed, String origin) {
        this.name=name;
        this.breed=breed;
        this.origin=origin;
    }
}

