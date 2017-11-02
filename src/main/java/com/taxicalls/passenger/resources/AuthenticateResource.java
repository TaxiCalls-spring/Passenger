package com.taxicalls.passenger.resources;

import com.taxicalls.passenger.model.Passenger;
import com.taxicalls.passenger.service.PassengerService;
import com.taxicalls.protocol.Response;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateResource {

    @Autowired
    private PassengerService passengerService;

    @RequestMapping(method = RequestMethod.POST)
    public Response authenticatePassenger(@RequestBody Passenger passenger) {
        List<Passenger> passengers = passengerService.getPassengers();
        for (Passenger stored : passengers) {
            if (stored.getEmail().equals(passenger.getEmail()) && stored.getPassword().equals(passenger.getPassword())) {
                return Response.successful(stored);
            }
        }
        return Response.notFound();
    }
}
