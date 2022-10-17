package ru.sobornov.model;

import lombok.*;


import javax.persistence.*;
import java.util.List;

/**
 * @author : Sobornov Vladimir
 * @since : 10.10.2022
 **/

@Entity
@Table(name = "Person")
@Data
public class Person {

    public Person () {}

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    private List<Item> items;
}
