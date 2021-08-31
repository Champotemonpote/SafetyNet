package com.SafetyNet.Alerts.service;

import com.SafetyNet.Alerts.model.FireStation;
import com.SafetyNet.Alerts.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FireStationService {

    public List<String> findPhoneNumbersByStationNumber(String number) {

        List<String> result = new ArrayList<>();

        List<FireStation> fireStations = fireStationRepository.findAllFireStationsAddressByNumber(number);


        List<Person> persons = personRepository.findAllPersons();

        // make a third list and put the addresses inside
        for (Person person : persons) {
            if (personsContainsFirestationAddress(fireStations, person)) {
                result.add(person.getPhone());
            }
        }

        return result;

    }
    public List<Person> findAllPersons() {

        return dataHandler.getData().getPersons();
    }
    public List<FireStation> findAllFireStationsAddressByNumber(Integer number) {

        return dataHandler.getData().getFirestations().stream().filter(p -> p.getStation().equals(number.toString())).collect(Collectors.toList());
    }
    private boolean personsContainsFireStationAddress(List<FireStation> fireStations, Person person) {
        for (FireStation fireStation : fireStations) {
            if (fireStation.getAddress().equals(person.getAdress())) {
                return true;
            }
        }
        return false;
    }
}
