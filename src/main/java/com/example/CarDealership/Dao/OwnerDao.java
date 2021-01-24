package com.example.CarDealership.Dao;

import com.example.CarDealership.model.Car;
import com.example.CarDealership.model.Owner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OwnerDao {

    int insertOwner(UUID id, Owner owner);
    default  int insertOwner(Owner owner){
        UUID id = UUID.randomUUID();
        return  insertOwner(id,owner);
    }


    List<Owner> selectAllOwner();
    Optional<Owner> selectOwnerById(UUID id);
    int deleteOwnerById(UUID id);
    int updateOwnerById(UUID id,Owner owner);
}

