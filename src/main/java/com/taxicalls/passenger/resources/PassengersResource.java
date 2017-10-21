package com.taxicalls.passenger.resources;

import com.taxicalls.passenger.model.Passenger;
import com.taxicalls.passenger.service.PassengerService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passengers")
public class PassengersResource {

    @Autowired
    private PassengerService passengerService;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Passenger createPassenger(Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }

    @RequestMapping("/")
    public List<Passenger> getPassengers() {
        return passengerService.getPassengers();
    }

    @RequestMapping(value = "/{id}")
    public Passenger getPassenger(@PathVariable("id") Integer id) {
        return passengerService.getPassenger(id);
    }

}
