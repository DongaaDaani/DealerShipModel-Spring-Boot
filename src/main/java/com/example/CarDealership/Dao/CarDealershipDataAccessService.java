package com.example.CarDealership.Dao;

import com.example.CarDealership.model.Car;
import com.example.CarDealership.model.CarDealership;
import com.example.CarDealership.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("carDealership")
public class CarDealershipDataAccessService implements CarDealershipDao {
    public static List<CarDealership>carDealershipsDB = new ArrayList<>();

    @Override
    public List<CarDealership> selectAllCarDealership() {
        return carDealershipsDB;
    }

    @Override
    public Optional<CarDealership> selectCarDealershipById(Long id) {
        return   carDealershipsDB.stream()
                .filter(carDealership -> carDealership.getCompanyName().equals(id))
                .findFirst();
    }

    @Override
    public int deleteCarDealershipById(Long id) {
        Optional<CarDealership>carDealershipDelete= selectCarDealershipById(id);

        if(carDealershipDelete.isEmpty()){
            return 0;
        }
        carDealershipsDB.remove(carDealershipDelete.get());
        return  1;
    }

    @Override
    public int insertCarDealership( CarDealership carDealership) {
        carDealershipsDB.add(new CarDealership(carDealership.getCompanyNumber(),carDealership.getCompanyName(),carDealership.getAddress(),carDealership.getIncome(),carDealership.getOwners(),carDealership.getCars()));
        return 1;
    }

    @Override
    public int updateCarDealershipById(Long id, CarDealership carDealershipUpdate) {
        return selectCarDealershipById(id)
                .map(car ->{
                    int indexOfPersonToUpdate = carDealershipsDB.indexOf(car);
                    if(indexOfPersonToUpdate >= 0){
                        carDealershipsDB.set(indexOfPersonToUpdate,new CarDealership(id, carDealershipUpdate.getCompanyName(),carDealershipUpdate.getAddress(),carDealershipUpdate.getIncome(),carDealershipUpdate.getOwners(),carDealershipUpdate.getCars()));
                        return  1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
