package com.gitturami.bikeserver.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason= "No such Station-Id")
public class StationNotFoundException extends RuntimeException {
    @Override
    public String toString() {
        return "Not found. Try Again.";
    }
}
