package com.gitturami.bikeserver.infra.restaurant.repository;

import com.google.gson.Gson;

public class RestaurantResponse {
    public RestaurantList CrtfcUpsoInfo;

    @Override
    public String toString() {
        return CrtfcUpsoInfo.toString();
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
