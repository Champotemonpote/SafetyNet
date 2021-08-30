package com.SafetyNet.Alerts.service;

public class FireStationService {

    public List<String> findPhoneNumbersByStationNumber(int number) {

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

    private boolean personsContainsFirestationAddress(List<FireStation> fireStations, Person person) {
        for (FireStation fireStation : fireStations) {
            if (fireStation.getAddress().equals(person.getAdress())) {
                return true;
            }
        }
        return false;
    }
}
