package com.gitturami.bikeserver.controller.station.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason= "No such station")
public class StationNotFoundException extends RuntimeException {
    @Override
    public String toString() {
        return "Not found the station!";
    }
}
