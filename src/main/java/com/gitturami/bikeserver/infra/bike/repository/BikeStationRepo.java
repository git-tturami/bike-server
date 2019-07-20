package com.gitturami.bikeserver.infra.bike.repository;

import com.google.gson.Gson;

public class BikeStationRepo {
    public int rackTotCnt;
    public String stationName;
    public int parkingBikeTotCnt;
    public float shared;
    public float stationLatitude;
    public float stationLongitude;
    public String stationId;

    @Override
    public String toString() {
        return String.format(
                "rack to count : %s\n" +
                        "station name : %s\n" +
                        "parking bike total count : %d\n" +
                        "shared : %f\n" +
                        "station latitude : %f\n" +
                        "station longitude : %f\n" +
                        "station id : %s\n",
                rackTotCnt, stationName, parkingBikeTotCnt, shared, stationLatitude, stationLongitude, stationId
        );
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
