package com.example.CarDealership.Dao;

import com.example.CarDealership.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("cars")
public class FakeCarDataAccessService implements CarDao {
    private static List<Car> carsDB = new ArrayList<>();


    @Override
    public int insertCar(Car car) {
        carsDB.add(new Car(car.getLicensePlate(),car.getType(), car.getYearOfManufacturer(),car.getModel(),car.getHoursePower()));
        return 1;

    }

    @Override
    public List<Car> selectAllCar() {
        return carsDB;
    }

    @Override
    public Optional<Car> selectCarById(String licensePlate) {
        return   carsDB.stream()
                .filter(car -> car.getLicensePlate().equals(licensePlate))
                .findFirst();
    }

    @Override
    public int deleteCarById(String licensePlate) {
        Optional<Car>carDelete= selectCarById(licensePlate);

        if(carDelete.isEmpty()){
            return 0;
        }
        carsDB.remove(carDelete.get());
        return  1;
    }

    @Override
    public int updateCarById(String licensePlate, Car carUpdate) {
        return selectCarById(licensePlate)
                .map(person ->{
                    int indexOfPersonToUpdate = carsDB.indexOf(person);
                    if(indexOfPersonToUpdate >= 0){
                        carsDB.set(indexOfPersonToUpdate,new Car(licensePlate, carUpdate.getType(),carUpdate.getYearOfManufacturer(),carUpdate.getModel(),carUpdate.getHoursePower()));
                        return  1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
