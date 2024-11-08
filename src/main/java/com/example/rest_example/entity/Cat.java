package com.example.rest_example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cats")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//refactor -> Delombok -> Constructors -> убрал id
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;
    private int age;
    private int weight;

    public Cat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
