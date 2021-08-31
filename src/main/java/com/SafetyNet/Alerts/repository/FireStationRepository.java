package com.SafetyNet.Alerts.repository;

import com.SafetyNet.Alerts.model.FireStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("fire")
public class FireStationRepository {

    private final DataHandler dataHandler;

    @Autowired
    public FireStationRepository(DataHandler dataHandler) {

        this.dataHandler = dataHandler;
    }

    public List<FireStation> findAllFireStationsAddressByNumber(String number) {

        return dataHandler.getData().getFirestations().stream().filter(p -> p.getStation().equals(number.toString())).collect(Collectors.toList());
    }

    public FireStation findFireStationNumberByAddress(String address) {
        return dataHandler.getData().getFirestations().stream().filter(p -> p.getAddress().equals(address)).findFirst().orElseGet(() -> new FireStation());
    }
}
