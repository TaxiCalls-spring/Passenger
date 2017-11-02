/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxicalls.passenger.service;

import com.taxicalls.passenger.model.Passenger;
import com.taxicalls.passenger.repository.PassengerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author romulo
 */
@Service
public class PassengerService {

    protected static final Logger LOGGER = Logger.getLogger(PassengerService.class.getName());

    protected PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
        LOGGER.log(Level.INFO, "PassengerRepository says system has {0} accounts", passengerRepository.count());
    }

    public Passenger createPassenger(Passenger passenger) {
        Passenger save = passengerRepository.save(passenger);
        return save;
    }

    public List<Passenger> getPassengers() {
        LOGGER.log(Level.INFO, "getPassengers() invoked");
        List<Passenger> passengers = new ArrayList<>();
        Iterable<Passenger> findAll = passengerRepository.findAll();
        for (Passenger passenger : findAll) {
            passengers.add(passenger);
        }
        LOGGER.log(Level.INFO, "getPassengers() found {0}", passengers.size());
        return passengers;
    }

    public Passenger getPassenger(Long id) {
        Passenger passenger = passengerRepository.findOne(id);
        return passenger;
    }
}
