package com.SpringBootWeb.fleetapp.controllers;

import com.SpringBootWeb.fleetapp.models.VehicleType;
import com.SpringBootWeb.fleetapp.servies.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicletype")
    public String getVehicleTypes(Model model) {
        model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
        return "VehicleType";
    }

    @RequestMapping("vehicletype/findById")
    @ResponseBody
    public Optional<VehicleType> findById(Integer id)
    {
        return vehicleTypeService.findById(id);
    }

    //Add VehicleType
    @PostMapping(value="vehicletype/addNew")
    public String addNew(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicletype";
    }

    @RequestMapping(value="vehicletype/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleType vehicleType) {
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicletype";
    }

    @RequestMapping(value="vehicletype/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleTypeService.delete(id);
        return "redirect:/vehicletype";
    }

}
