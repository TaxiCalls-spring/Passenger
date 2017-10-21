package com.taxicalls.passenger.configuration;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan
@EntityScan("com.taxicalls.passenger.model")
@EnableJpaRepositories("com.taxicalls.passenger.repository")
@PropertySource("classpath:db-config.properties")
public class PassengersConfiguration {

}
