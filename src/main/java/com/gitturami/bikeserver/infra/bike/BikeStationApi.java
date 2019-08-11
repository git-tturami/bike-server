package com.gitturami.bikeserver.infra.bike;

import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;

public interface BikeStationApi {
    // getStationInfo() returns station information.
    String getStationInfo();

    // getEnablebike() returns the number of bike parked in station.
    String getEnableBike(String stationId);

    // getTotalBike() returns total number of bike.
    String getTotalBike();

    // getStationInfoById() returns station information with the station-ID requested by client.
    String getStationInfoById(String stationId);

    // getStationInfoByTownName() returns station information with the town-name requested by client.
    String getStationInfoByTownName(String townName);

    // getStationListByEnableBike() returns stations list sorted by the number of enable bike.
    String getStationListByEnableBike();

    // getStationListByDistance(float lat, float lon) returns stations list sorted by distance from my current location.
    String getStationListByDistance(float lat, float lon);

    // getStationList() returns station list from start page to end page.
    BikeStationResponse getStationList(int startPage, int endPage);
}
