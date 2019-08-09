package com.gitturami.bikeserver.controller.leisure.exception;

public class LeisureNotFoundException extends RuntimeException {
    @Override
    public String toString() {
        return "Leisure information not found.";
    }
}
