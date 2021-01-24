package com.example.CarDealership.service;


import com.example.CarDealership.Dao.CarDao;
import com.example.CarDealership.Dao.OwnerDao;
import com.example.CarDealership.model.Car;
import com.example.CarDealership.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OwnerService {

    private OwnerDao ownerDao;
    @Autowired
    public OwnerService(@Qualifier("owners") OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    public List<Owner> getOwners(){

        return ownerDao.selectAllOwner();
    }

    public int addOwner(Owner owner){
        ownerDao.insertOwner(owner);
        return 1;
    }

    public Optional<Owner> getOwnerById(UUID id){
        return ownerDao.selectOwnerById(id);
    }

    public int deleteOwner(UUID id){
        return ownerDao.deleteOwnerById(id);
    }

    public int updateOwner(UUID id, Owner newOwner){
        return  ownerDao.updateOwnerById(id,newOwner);
    }

}
