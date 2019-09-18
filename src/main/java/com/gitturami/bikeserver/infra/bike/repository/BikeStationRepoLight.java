package com.gitturami.bikeserver.infra.bike.repository;

import com.google.gson.Gson;

public class BikeStationRepoLight {
    public float shared;
    public String stationLatitude;
    public String stationLongitude;
    public String stationId;

    @Override
    public String toString() {
        return String.format(
                "shared : %f\n" +
                        "station latitude : %s\n" +
                        "station longitude : %s\n" +
                        "station id : %s\n",
                shared, stationLatitude, stationLongitude, stationId
        );
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

}
