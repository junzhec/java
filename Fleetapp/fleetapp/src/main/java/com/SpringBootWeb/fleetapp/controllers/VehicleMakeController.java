package com.SpringBootWeb.fleetapp.controllers;

import com.SpringBootWeb.fleetapp.models.VehicleMake;
import com.SpringBootWeb.fleetapp.servies.CountryService;
import com.SpringBootWeb.fleetapp.servies.VehicleMakeService;
import com.SpringBootWeb.fleetapp.servies.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMakeController {


    @Autowired
    private VehicleMakeService vehicleMakeService;

    @GetMapping("/vehiclemake")
    public String getVehicleMakes(Model model) {
        model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
        return "VehicleMake";
    }

    @RequestMapping("vehiclemake/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(Integer id)
    {
        return vehicleMakeService.findById(id);
    }

    //Add VehicleMake
    @PostMapping(value="vehiclemake/addNew")
    public String addNew(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehiclemake";
    }

    @RequestMapping(value="vehiclemake/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMake vehicleMake) {
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehiclemake";
    }

    @RequestMapping(value="vehiclemake/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMakeService.delete(id);
        return "redirect:/vehiclemake";
    }

}
