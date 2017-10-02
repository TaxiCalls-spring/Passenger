package com.taxicalls.passenger.resource;

import com.taxicalls.passenger.model.PassengerRepository;
import com.taxicalls.passenger.model.Passenger;
import com.taxicalls.passenger.model.Route;
import com.taxicalls.passenger.resource.exceptions.PassengerNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PassengerResource {

    protected Logger logger = Logger.getLogger(PassengerResource.class.getName());
    protected PassengerRepository passengerRepository;

    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    public PassengerResource(PassengerRepository accountRepository) {
        this.passengerRepository = accountRepository;
        logger.log(Level.INFO, "AccountRepository says system has {0} accounts", accountRepository.countPassengers());
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
    public List<ServiceInstance> getRoutes() {
        return restTemplate.getForObject("http://ROUTES" + "/routes", List.class);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trip")
    public List<Route> getAvailableRoutes(Route route) {
        return restTemplate.getForObject("http://ROUTES" + "/routes/available", List.class);
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

}
