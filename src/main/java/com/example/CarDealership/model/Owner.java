package com.example.CarDealership.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Owner {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private UUID id;
    private String name;
    private int age;
    private String email;
    @ManyToOne
    private CarDealership carDealership;



    public Owner(UUID id, @JsonProperty("name") String name, @JsonProperty("age") int age, @JsonProperty("email") String email,@JsonProperty("cardealership") CarDealership carDealership) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.carDealership = carDealership;
    }
    public Owner(){

    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public CarDealership getCarDealership() {
        return carDealership;
    }
}
