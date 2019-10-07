package com.gitturami.bikeserver.infra.bike.repository;

import com.gitturami.bikeserver.common.repository.Item;
import com.google.gson.Gson;

public class BikeStationRepo implements Item {
    public int rackTotCnt;
    public String stationName;
    public int parkingBikeTotCnt;
    public float shared;
    public String stationLatitude;
    public String stationLongitude;
    public String stationId;
    public int idx;

    @Override
    public String toString() {
        return String.format(
                "station index : %d\n" +
                        "rack to count : %s\n" +
                        "station name : %s\n" +
                        "parking bike total count : %d\n" +
                        "shared : %f\n" +
                        "station latitude : %s\n" +
                        "station longitude : %s\n" +
                        "station id : %s\n",
                idx, rackTotCnt, stationName, parkingBikeTotCnt, shared, stationLatitude, stationLongitude, stationId
        );
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    @Override
    public String getLatitude() {
        return stationLatitude;
    }

    @Override
    public String getLongitude() {
        return stationLongitude;
    }
}
