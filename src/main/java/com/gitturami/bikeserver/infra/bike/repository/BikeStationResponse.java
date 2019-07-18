package com.gitturami.bikeserver.infra.bike.repository;

public class BikeStationResponse {
    public BikeStationList rentBikeStatus;

    @Override
    public String toString() {
        return rentBikeStatus.toString();
    }
}
