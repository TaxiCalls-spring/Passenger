package com.taxicalls.passenger.repository;

import com.taxicalls.passenger.model.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger, Integer> {

    public Passenger findByEmail(String email);

}
