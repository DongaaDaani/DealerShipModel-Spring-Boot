package com.example.CarDealership.api;

import com.example.CarDealership.model.Car;
import com.example.CarDealership.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/car")
@RestController
public class CarController {

    private final CarService carService;
    @Autowired
    public CarController(CarService carService){this.carService=carService;}



    @PostMapping
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }

    @GetMapping
    public List<Car> getCar(){
    return  carService.getAllCar();
    }

    @GetMapping(path="{id}")
    public Car getCarById(@PathVariable("id") String licenseplate){
        return carService.getCarById(licenseplate)
                .orElse(null);
    }

    @DeleteMapping(path = "{licenseplate}")
    public int deleteCarById(@PathVariable("licenseplate") String licenseplate){
        return carService.deleteCar(licenseplate);
    }

    @PutMapping(path = "{licenseplate}")
    public void updateCar(@PathVariable("licenseplate") String licenseplate,@RequestBody Car UpdateCar){
        carService.updateCar(licenseplate,UpdateCar);
    }

}
