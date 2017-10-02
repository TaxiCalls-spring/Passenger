package com.taxicalls.passenger.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface PassengerRepository extends Repository<Passenger, Integer> {

    public Passenger save(Passenger passenger);

    public Iterable<Passenger> findAll();

    public Passenger findOne(Integer id);

    public Passenger findByEmail(String email);

    @Query("SELECT count(*) from Passenger")
    public int countPassengers();

}
