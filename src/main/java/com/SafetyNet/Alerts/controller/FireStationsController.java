package com.SafetyNet.Alerts.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class FireStationsController {

    @RequestMapping(value = "phoneAlert", method = RequestMethod.GET)
    public List<String> phoneNumbers(@RequestParam(name = "fireStation") String fireStation) {

        return this.fireStationService.findAllPhoneNumbersByFireStation(fireStation);

    }


}
