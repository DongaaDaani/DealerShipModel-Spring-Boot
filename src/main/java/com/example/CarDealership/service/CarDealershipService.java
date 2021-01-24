package com.example.CarDealership.service;

import com.example.CarDealership.Dao.CarDao;
import com.example.CarDealership.Dao.CarDealershipDao;
import com.example.CarDealership.model.Car;
import com.example.CarDealership.model.CarDealership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarDealershipService {
    private final CarDealershipDao carDealershipDao;
    @Autowired
    public CarDealershipService(@Qualifier("carDealership") CarDealershipDao carDealershipDao) {
        this.carDealershipDao = carDealershipDao;
    }
    public int updateCarDealership(Long id, CarDealership carDealershipNew ){
        return  carDealershipDao.updateCarDealershipById(id,carDealershipNew);
    }

    public int addCarDealership(CarDealership carDealership){
        return carDealershipDao.insertCarDealership(carDealership);
    }

    public List<CarDealership> getAllCarDealership(){
        return carDealershipDao.selectAllCarDealership();
    }


    public Optional<CarDealership> getCarDealershipById(Long id){
        return carDealershipDao.selectCarDealershipById(id);
    }

    public int deleteCarDealership(Long id){
        return carDealershipDao.deleteCarDealershipById(id);
    }


}
