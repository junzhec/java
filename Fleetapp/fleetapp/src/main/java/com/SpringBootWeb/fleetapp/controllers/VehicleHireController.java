package com.SpringBootWeb.fleetapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleHireController {
    @GetMapping("/vehicleshires")
    public String getVehicleHires() {
        return "VehicleHire";
    }
}
