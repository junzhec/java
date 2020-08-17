package com.SpringBootWeb.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMaintenanceController {

    @GetMapping("/vehiclesmaintenance")
    public String getVehicleMaintenance() {
        return "VehicleMaintenance";
    }

}
