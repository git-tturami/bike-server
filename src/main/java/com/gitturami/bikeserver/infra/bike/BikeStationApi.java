package com.gitturami.bikeserver.infra.bike;

import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepo;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepoLight;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;

import java.util.List;

public interface BikeStationApi {
    // getStationInfo() returns station information.
    String getStationInfo();

    // getEnablebike() returns the number of bike parked in station.
    String getEnableBike(String stationId);

    // getTotalBike() returns total number of bike.
    String getTotalBike();

    // getStationInfoById() returns station information with the station-ID requested by client.
    BikeStationRepo getStationInfoById(String stationId);

    // getStationInfoByTownName() returns station information with the town-name requested by client.
    BikeStationRepo getStationInfoByTownName(String townName);

    // getStationListByEnableBike() returns stations list sorted by the number of enable bike.
    BikeStationResponse getStationListByEnableBike();

    // getStationListByDistance(float lat, float lon) returns stations list sorted by distance from my current location.
    BikeStationResponse getStationListByDistance(float lat, float lon);

    // getStationList() returns station list from start page to end page.
    BikeStationResponse getStationList(int startPage, int endPage);

    // getStationList() returns summarized station list from start page to end page.
    List<BikeStationRepoLight> getLightStationList(int startPage, int endPage);
}
