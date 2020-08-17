package com.SpringBootWeb.fleetapp.servies;

import com.SpringBootWeb.fleetapp.models.VehicleMake;
import com.SpringBootWeb.fleetapp.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    public List<VehicleMake> getVehicleMakes(){
        return (List<VehicleMake>) vehicleMakeRepository.findAll();
    }

    public void save(VehicleMake vehicleMake){

        vehicleMakeRepository.save(vehicleMake);
    }

    public Optional<VehicleMake> findById(int id){

        return vehicleMakeRepository.findById(id);
    }

    public void delete(Integer id){
        vehicleMakeRepository.deleteById(id);
    }
    
}
