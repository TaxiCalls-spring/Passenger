package com.taxicalls.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.taxicalls.passenger.configuration.PassengersConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@Import(PassengersConfiguration.class)
public class PassengerApplication {

    /**
     * Run the application using Spring Boot and an embedded servlet engine.
     *
     * @param args Program arguments - ignored.
     */
    public static void main(String[] args) {
        SpringApplication.run(PassengerApplication.class, args);
    }
}
