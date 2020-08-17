package com.SpringBootWeb.fleetapp.controllers;

import com.SpringBootWeb.fleetapp.models.VehicleStatus;
import com.SpringBootWeb.fleetapp.servies.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleStatusController {

    @Autowired
    private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehiclestatus")
    public String getVehicleStatuss(Model model) {
        model.addAttribute("vehicleStatuss", vehicleStatusService.getVehicleStatuss());
        return "VehicleStatus";
    }

    @RequestMapping("vehiclestatus/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(Integer id)
    {
        return vehicleStatusService.findById(id);
    }

    //Add VehicleStatus
    @PostMapping(value="vehiclestatus/addNew")
    public String addNew(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehiclestatus";
    }

    @RequestMapping(value="vehiclestatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleStatus vehicleStatus) {
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehiclestatus";
    }

    @RequestMapping(value="vehiclestatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleStatusService.delete(id);
        return "redirect:/vehiclestatus";
    }

}
