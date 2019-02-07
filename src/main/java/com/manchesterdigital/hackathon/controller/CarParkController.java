package com.manchesterdigital.hackathon.controller;

import com.manchesterdigital.hackathon.service.LikelihoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/carpark")
public class CarParkController {

    private final LikelihoodService likelihoodService;

    @Autowired
    public CarParkController(LikelihoodService likelihoodService) {
        this.likelihoodService = likelihoodService;
    }

    @CrossOrigin(origins = {"http://localhost:4200","http://localhost:5000"})
    @RequestMapping(value = "/getlikelihood", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public double getLikelihood(@RequestParam(value = "lat") double latitude, @RequestParam(value = "long") double longitude) {
        System.out.println("hi");
        return likelihoodService.getLikelihood(latitude, longitude);
    }
}
