package com.gitturami.bikeserver.infra.bike.repository;

import com.google.gson.Gson;

public class BikeStationRepoLight {
    public float shared;
    public String stationName;
    public String stationLatitude;
    public String stationLongitude;
    public String stationId;

    @Override
    public String toString() {
        return String.format(
                "station id : %s\n" +
                        "station name : %s\n" +
                        "shared : %f\n" +
                        "station latitude : %s\n" +
                        "station longitude : %s\n" ,
                stationId, stationName, shared, stationLatitude, stationLongitude
        );
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

}
