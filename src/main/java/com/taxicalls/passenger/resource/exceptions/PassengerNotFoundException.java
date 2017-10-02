package com.taxicalls.passenger.resource.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PassengerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PassengerNotFoundException(String accountNumber) {
        super("No such account: " + accountNumber);
    }
}
