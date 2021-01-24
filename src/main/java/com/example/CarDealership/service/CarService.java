package com.example.CarDealership.service;

import com.example.CarDealership.Dao.CarDao;
import com.example.CarDealership.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService {
    private final CarDao cardao;
    @Autowired
    public CarService(@Qualifier("cars") CarDao cardao) {
        this.cardao = cardao;
    }

    public int addCar(Car car){
        return cardao.insertCar(car);
    }

    public List<Car> getAllCar(){
        return cardao.selectAllCar();
    }



    public Optional<Car> getCarById(String licenseplate){
        return cardao.selectCarById(licenseplate);
    }

    public int deleteCar(String licenseplate){
        return cardao.deleteCarById(licenseplate);
    }

    public int updateCar(String licenseplate, Car newPerson){
        return  cardao.updateCarById(licenseplate,newPerson);
    }
}

