package com.gitturami.bikeserver.controller.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason= "No such restaurant")
public class RestaurantNotFoundException extends RuntimeException {
    @Override
    public String toString() { return "Not Found the restaurant!"; }
}
