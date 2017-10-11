package com.taxicalls.passenger;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.taxicalls.passenger.configuration.PassengersConfiguration;
import com.taxicalls.passenger.repository.PassengerRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@Import(PassengersConfiguration.class)
public class PassengerApplication {

    @Autowired
    protected PassengerRepository passengerRepository;

    protected Logger logger = Logger.getLogger(PassengerApplication.class.getName());

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
//        System.setProperty("spring.config.name", "passenger");
        SpringApplication.run(PassengerApplication.class, args);
    }
}
