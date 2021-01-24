package com.example.CarDealership.api;

import com.example.CarDealership.model.Car;
import com.example.CarDealership.model.CarDealership;
import com.example.CarDealership.model.Owner;
import com.example.CarDealership.service.CarDealershipService;
import com.example.CarDealership.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/carDealership")
public class CarDealershipController {

    private final CarDealershipService carDealershipService;

    @Autowired
    public CarDealershipController(CarDealershipService carDealershipService){
        this.carDealershipService=carDealershipService;
    }

    @PostMapping
    public void postCarDealer(@RequestBody CarDealership carDealership){
        carDealershipService.addCarDealership(carDealership);
    }

    @GetMapping
    public List<CarDealership> getCarDealership(){
        return carDealershipService.getAllCarDealership();
    }

    @GetMapping(path="{id}")
    public CarDealership getCarDealershipById(@PathVariable("id") Long id){
        return carDealershipService.getCarDealershipById(id)
                .orElse(null);
    }


    @DeleteMapping(path = "{id}")
    public int deleteCarDealershipById(@PathVariable("id") Long id){
        return carDealershipService.deleteCarDealership(id);
    }

    @PutMapping(path = "{id}")
    public void updateCarDealership(@PathVariable("id") Long id,@RequestBody CarDealership carDealership){
        carDealershipService.updateCarDealership(id,carDealership);
    }
}
