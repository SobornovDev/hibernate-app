package ru.sobornov.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author : Sobornov Vladimir
 * @since : 10.10.2022
 **/

@Entity
@Table(name = "Item")
@Data
public class Item {

    public Item() {}

    public Item (String name, Person person) {
        this.item_name = name;
        this.person = person;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_name")
    private String item_name;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;
}
