package com.SafetyNet.Alerts.controller;

import com.SafetyNet.Alerts.service.FireStationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class FireStationsController {

    private final FireStationService fireStationService;

    public FireStationsController(FireStationService fireStationService) {
        this.fireStationService = fireStationService;

    }

    //Get a number list
    @RequestMapping(value = "phoneAlert", method = RequestMethod.GET)
    public List<String> findAllPhoneNumbersByFireStation(@RequestParam(name = "fireStation") String fireStation) {

        return this.fireStationService.findPhoneNumbersByStationNumber(fireStation);

    }

}
