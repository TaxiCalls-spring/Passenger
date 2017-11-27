package com.taxicalls.passenger.resources;

import com.taxicalls.passenger.model.Trip;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.taxicalls.passenger.services.NotificationService;
import com.taxicalls.passenger.services.TripService;
import com.taxicalls.protocol.Response;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/trips")
public class TripsResource {

    protected static final Logger LOGGER = Logger.getLogger(TripsResource.class.getName());

    @Autowired
    private TripService tripService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(method = RequestMethod.POST)
    public Response createTrip(@RequestBody Trip trip) {
        LOGGER.log(Level.INFO, "createTrip() invoked");
        return Response.successful(trip);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/drivers/available")
    public Response getAvailableRoutes(@RequestBody Trip trip) {
        LOGGER.log(Level.INFO, "getAvailableRoutes() invoked");
        return tripService.getAvailableDrivers(trip);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/drivers/choose")
    public Response chooseDriver(@RequestBody ChooseDriverRequest chooseDriverRequest) {
        tripService.chooseDriver(chooseDriverRequest);
        return notificationService.chooseDriver(chooseDriverRequest);
    }

}
