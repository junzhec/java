package com.SpringBootWeb.fleetapp.controllers;

import com.SpringBootWeb.fleetapp.models.Location;
import com.SpringBootWeb.fleetapp.servies.CountryService;
import com.SpringBootWeb.fleetapp.servies.LocationService;
import com.SpringBootWeb.fleetapp.servies.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public String getLocations(Model model) {
        model.addAttribute("states", stateService.getStates());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("locations", locationService.getLocations());
        return "Location";
    }

    @RequestMapping("locations/findById")
    @ResponseBody
    public Optional<Location> findById(Integer id)
    {
        return locationService.findById(id);
    }

    //Add Location
    @PostMapping(value="locations/addNew")
    public String addNew(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value="locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value="locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        locationService.delete(id);
        return "redirect:/locations";
    }

}
