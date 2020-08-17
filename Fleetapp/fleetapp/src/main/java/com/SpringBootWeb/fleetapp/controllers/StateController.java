package com.SpringBootWeb.fleetapp.controllers;

import com.SpringBootWeb.fleetapp.models.State;
import com.SpringBootWeb.fleetapp.servies.CountryService;
import com.SpringBootWeb.fleetapp.servies.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {

    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;

    //Get All States
    @GetMapping("states")
    public String getStates(Model model){
        model.addAttribute("states", stateService.getStates());
        model.addAttribute("countries", countryService.getCountries());
        return "state";
    }

    @RequestMapping("states/findById")
    @ResponseBody
    public Optional<State> findById(Integer id)
    {
        return stateService.findById(id);
    }

    //Add State
    @PostMapping(value="states/addNew")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping(value="states/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping(value="states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        stateService.delete(id);
        return "redirect:/states";
    }

}
