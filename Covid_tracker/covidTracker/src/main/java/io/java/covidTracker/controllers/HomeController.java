package io.java.covidTracker.controllers;


import io.java.covidTracker.models.LocationStats;
import io.java.covidTracker.services.CovidDataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CovidDataServices covidDataServices;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allstats = covidDataServices.getAllStats();
        int totalCases  = allstats.stream().mapToInt(stat -> stat.getLatestCases()).sum();
        int totalNewCases  = allstats.stream().mapToInt(stat -> stat.getNewCases()).sum();
        model.addAttribute("locationStats", allstats);
        model.addAttribute("totalReportedCases", totalCases);
        model.addAttribute("totalNewCases", totalNewCases);
        return "home";
    }
}
