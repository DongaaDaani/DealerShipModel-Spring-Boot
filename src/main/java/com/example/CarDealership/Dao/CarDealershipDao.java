package com.example.CarDealership.Dao;

import com.example.CarDealership.model.CarDealership;
import com.example.CarDealership.model.Owner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarDealershipDao {
    List<CarDealership> selectAllCarDealership();
    Optional<CarDealership> selectCarDealershipById(Long id);
    int deleteCarDealershipById(Long id);
    int insertCarDealership(CarDealership carDealership);

    int updateCarDealershipById(Long id,CarDealership carDealership);
}
