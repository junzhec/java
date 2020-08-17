package com.SpringBootWeb.fleetapp.servies;

import com.SpringBootWeb.fleetapp.models.VehicleStatus;
import com.SpringBootWeb.fleetapp.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    public List<VehicleStatus> getVehicleStatuss(){
        return (List<VehicleStatus>) vehicleStatusRepository.findAll();
    }

    public void save(VehicleStatus vehicleStatus){

        vehicleStatusRepository.save(vehicleStatus);
    }

    public Optional<VehicleStatus> findById(int id){

        return vehicleStatusRepository.findById(id);
    }

    public void delete(Integer id){
        vehicleStatusRepository.deleteById(id);
    }
    
}
