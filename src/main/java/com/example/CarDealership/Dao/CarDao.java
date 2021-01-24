package com.example.CarDealership.Dao;
import com.example.CarDealership.model.Car;

import javax.swing.text.html.Option;
import java.util.List;
import  java.util.Optional;
import java.util.UUID;

public interface CarDao {
/*
    int insertCar(UUID id, Car car);

    default  int insertCar(Car car){
        UUID id = UUID.randomUUID();
        return  insertCar(id,car);
    } */

     int insertCar(Car car);

    List<Car> selectAllCar();
    Optional<Car> selectCarById(String licensePlate);
    int deleteCarById(String licensePlate);
    int updateCarById(String licensePlate,Car car);



}
