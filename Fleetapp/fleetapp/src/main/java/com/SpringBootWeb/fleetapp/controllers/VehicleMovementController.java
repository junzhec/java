package com.SpringBootWeb.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleMovementController {

    @GetMapping("/vehiclesmovement")
    public String getVehicleMovements() {
        return "VehicleMovement";
    }

}
