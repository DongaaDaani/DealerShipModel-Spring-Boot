package com.example.CarDealership.api;

import com.example.CarDealership.model.Car;
import com.example.CarDealership.model.Owner;
import com.example.CarDealership.service.CarService;
import com.example.CarDealership.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/owner")
@RestController
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService){
        this.ownerService=ownerService;
    }

    @PostMapping
    public void postOwner(@RequestBody Owner owner){
        ownerService.addOwner(owner);
    }

    @GetMapping
    public List<Owner> getOwners(){
       return ownerService.getOwners();
    }

    @GetMapping(path="{id}")
    public Owner getOwnerById(@PathVariable("id") UUID id){
        return ownerService.getOwnerById(id)
                .orElse(null);
    }


    @DeleteMapping(path = "{id}")
    public int deleteCarById(@PathVariable("id") UUID id){
        return ownerService.deleteOwner(id);
    }

    @PutMapping(path = "{id}")
    public void updateOwner(@PathVariable("id") UUID id,@RequestBody Owner updateOwner){
        ownerService.updateOwner(id,updateOwner);
    }

}
