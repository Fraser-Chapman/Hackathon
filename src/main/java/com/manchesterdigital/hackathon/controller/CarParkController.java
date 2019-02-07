package com.manchesterdigital.hackathon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/carpark")
public class CarParkController {

    //api/getLikelihood?lat=53.3&long=-2.3
    @RequestMapping(value = "/getlikelihood", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public double getLikelihood(@RequestParam(value = "lat") double latitude, @RequestParam(value = "long") double longitude) {
        return longitude + latitude;
    }
}
