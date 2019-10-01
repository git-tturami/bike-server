package com.gitturami.bikeserver.infra.bike.impl;

import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepo;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepoLight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockStationApiImpl {

    List<BikeStationRepoLight> lightList = new ArrayList<>();
    List<BikeStationRepo> list = new ArrayList<>();

    private void setList() {
        BikeStationRepoLight item1 = new BikeStationRepoLight();
        item1.index = 0;
        item1.stationId = "0";
        item1.shared = 50f;
        item1.stationLongitude = "126.963413";
        item1.stationLatitude = "37.508982";
        item1.stationName = "흑석역 1번출구";

        BikeStationRepoLight item2 = new BikeStationRepoLight();
        item2.index = 1;
        item2.stationId = "1";
        item2.shared = 20f;
        item2.stationLongitude = "126.948258";
        item2.stationLatitude = "37.503588";
        item2.stationName = "상도역 4번출구";

        lightList.add(item1);
        lightList.add(item2);

        BikeStationRepo repo1 = new BikeStationRepo();
        repo1.index = 0;
        repo1.shared = 50f;
        repo1.stationId = "0";
        repo1.stationLatitude = "37.508982";
        repo1.stationLongitude = "126.963413";
        repo1.stationName = "흑석역 1번출구";
        repo1.rackTotCnt = 15;
        repo1.parkingBikeTotCnt = 7;

        BikeStationRepo repo2 = new BikeStationRepo();
        repo2.index = 1;
        repo2.shared = 20f;
        repo2.stationId = "1";
        repo2.stationLatitude = "37.503588";
        repo2.stationLongitude = "126.948258";
        repo2.stationName = "상도역 4번출구";
        repo2.rackTotCnt = 10;
        repo2.parkingBikeTotCnt = 8;

        list.add(repo1);
        list.add(repo2);
    }

    public List<BikeStationRepoLight> getMockLightStationList() {
        if (lightList.isEmpty()) {
            setList();
        }
        return lightList;
    }

    public BikeStationRepo getStationByIndex(int index) {
        if (list.isEmpty()) {
            setList();
        }
        return list.get(index);
    }
}
