package com.gitturami.bikeserver.infra.bike.repository;

import com.google.gson.Gson;

public class BikeStationResponse {
    public BikeStationList rentBikeStatus;

    @Override
    public String toString() {
        return rentBikeStatus.toString();
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
