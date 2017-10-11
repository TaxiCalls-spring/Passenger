package com.taxicalls.passenger.resource;

import com.taxicalls.passenger.repository.PassengerRepository;
import com.taxicalls.passenger.model.Passenger;
import com.taxicalls.passenger.model.Route;
import com.taxicalls.passenger.services.NotificationsService;
import com.taxicalls.passenger.services.RoutesService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassengerResource {

    protected Logger logger = Logger.getLogger(PassengerResource.class.getName());
    protected PassengerRepository passengerRepository;

    @Autowired
    private RoutesService routesService;

    @Autowired
    private NotificationsService notificationsService;

    @Autowired
    public PassengerResource(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
        logger.log(Level.INFO, "PassengerRepository says system has {0} accounts", passengerRepository.count());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/passengers")
    public Passenger createPassenger(Passenger passenger) {
        Passenger save = passengerRepository.save(passenger);
        return save;
    }

    @RequestMapping(value = "/passengers/{id}")
    public Passenger getPassenger(@PathVariable("id") Integer id) {
        Passenger passenger = passengerRepository.findOne(id);
        return passenger;
    }

    @RequestMapping(value = "/trips")
    public List<Route> getRoutes() {
        return routesService.getRoutes();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trip")
    public List<Route> getAvailableRoutes(Route route) {
        logger.log(Level.INFO, "getAvailableRoutes() invoked");
        return routesService.getAvailableRoutes(route);
    }

    @RequestMapping("/passengers")
    public List<Passenger> getPassengers() {
        logger.log(Level.INFO, "getPassengers() invoked");
        List<Passenger> passengers = new ArrayList<>();
        Iterable<Passenger> findAll = passengerRepository.findAll();
        for (Passenger passenger : findAll) {
            passengers.add(passenger);
        }
        logger.log(Level.INFO, "getPassengers() found {0}", passengers.size());
        return passengers;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/chooseDriver")
    public void chooseDriver(Route route) {
        notificationsService.chooseDriver(route);
    }

}
