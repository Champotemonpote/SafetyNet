package com.SafetyNet.Alerts.service;

import com.SafetyNet.Alerts.model.FireStation;
import com.SafetyNet.Alerts.model.Person;
import com.SafetyNet.Alerts.repository.FireStationRepository;
import com.SafetyNet.Alerts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FireStationService {

    private final FireStationRepository fireStationRepository;
    private final PersonRepository personRepository;

    @Autowired

    public FireStationService(@Qualifier("fire") FireStationRepository fireStationRepository, PersonRepository personRepository) {
        this.fireStationRepository = fireStationRepository;
        this.personRepository = personRepository;
    }


    public List<String> findPhoneNumbersByStationNumber(String number) {

        List<String> result = new ArrayList<>();

        List<FireStation> fireStations = fireStationRepository.findAllFireStationsAddressByNumber(number);

        List<Person> persons = personRepository.findAllPersons();

        for (Person person : persons) {
            if (personsContainsFireStationAddress(fireStations, person)) {
                result.add(person.getPhone());
            }
        }

        return result;

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
