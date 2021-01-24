package com.example.CarDealership.Dao;

import com.example.CarDealership.model.Car;
import com.example.CarDealership.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("owners")
public class OwnerDataAccessService implements OwnerDao{

    private List<Owner> ownersDB = new ArrayList<>();

    public OwnerDataAccessService() {
        super();
    }

    @Override
    public int insertOwner(UUID id, Owner owner) {
         ownersDB.add(new Owner(id,owner.getName(),owner.getAge(),owner.getEmail(),owner.getCarDealership()));
         return 1;
    }

    @Override
    public List<Owner> selectAllOwner() {
        return ownersDB;
    }

    @Override
    public Optional<Owner> selectOwnerById(UUID id) {
        return   ownersDB.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteOwnerById(UUID id) {
        Optional<Owner>ownerDelete= selectOwnerById(id);

        if(ownerDelete.isEmpty()){
            return 0;
        }
        ownersDB.remove(ownerDelete.get());
        return  1;
    }

    @Override
    public int updateOwnerById(UUID id, Owner ownerUpdate) {
        return selectOwnerById(id)
                .map(car ->{
                    int indexOfPersonToUpdate = ownersDB.indexOf(car);
                    if(indexOfPersonToUpdate >= 0){
                        ownersDB.set(indexOfPersonToUpdate,new Owner(id, ownerUpdate.getName(),ownerUpdate.getAge(),ownerUpdate.getEmail(),ownerUpdate.getCarDealership()));
                        return  1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
