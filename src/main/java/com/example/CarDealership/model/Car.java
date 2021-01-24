package com.example.CarDealership.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Car {
    @Id
    private String licensePlate;
    private String type;
    private LocalDate yearOfManufacturer;
    private String model;
    private int hoursePower;
    @ManyToOne
    private CarDealership carDealership;

    public Car(@JsonProperty("licenseplate") String licensePlate, @JsonProperty("type") String type, @JsonProperty("date") LocalDate yearOfManufacturer, @JsonProperty("model") String model,@JsonProperty("hoursepower") int hoursePower) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.yearOfManufacturer = yearOfManufacturer;
        this.model = model;
        this.hoursePower = hoursePower;
    }
    public Car(){

    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getType() {
        return type;
    }

    public LocalDate getYearOfManufacturer() {
        return yearOfManufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getHoursePower() {
        return hoursePower;
    }





}
