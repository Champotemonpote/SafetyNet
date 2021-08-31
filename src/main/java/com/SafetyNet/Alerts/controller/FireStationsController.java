package com.SafetyNet.Alerts.controller;

import com.SafetyNet.Alerts.service.FireStationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class FireStationsController {

    @RestController
    public class FireStationController {
        private final FireStationService fireStationService;

        public FireStationController(FireStationService fireStationService) {
            this.fireStationService = fireStationService;
        }

        @RequestMapping(value = "phoneAlert", method = RequestMethod.GET)
        List<String> listPhones(@RequestParam(name = "firestation") String number) {

            return this.fireStationService.findPhoneNumbersByStationNumber(number);

        }

    }
}
