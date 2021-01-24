package com.example.CarDealership.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class CarDealership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
      private Long companyNumber;
      private String companyName;
      private String Address;
      private int Income;

  @OneToMany(mappedBy = "carDealership")
  private List<Owner> owners;
  @OneToMany(mappedBy = "carDealership")
  private List<Car> cars;

    public CarDealership(Long companyNumber, @JsonProperty("companyname") String companyName, @JsonProperty("address") String address, @JsonProperty("income") int income, @JsonProperty("owners") List<Owner> owners, @JsonProperty("cars") List<Car> cars) {
        this.companyNumber = companyNumber;
        this.companyName = companyName;
        Address = address;
        Income = income;
        this.owners = owners;
        this.cars = cars;
    }
    public CarDealership(){

    }

    public Long getCompanyNumber() {
        return companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return Address;
    }

    public int getIncome() {
        return Income;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
