package com.taxicalls.passenger.resources;

import com.taxicalls.passenger.model.Passenger;
import com.taxicalls.passenger.service.PassengerService;
import com.taxicalls.protocol.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passengers")
public class PassengersResource {

    @Autowired
    private PassengerService passengerService;

    @RequestMapping(method = RequestMethod.POST)
    public Response createPassenger(@RequestBody Passenger passenger) {
        return Response.successful(passengerService.createPassenger(passenger));
    }

    @RequestMapping
    public Response getPassengers() {
        return Response.successful(passengerService.getPassengers());
    }

    @RequestMapping(value = "/{id}")
    public Response getPassenger(@PathVariable("id") Long id) {
        Passenger passenger = passengerService.getPassenger(id);
        if (passenger == null) {
            return Response.notFound();
        }
        return Response.successful(passenger);
    }

}
