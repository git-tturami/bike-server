package com.gitturami.bikeserver.infra.bike.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BikeStationRepoTest {
    private BikeStationRepo bikeStationRepo;

    @Before
    public void setUp() {
        bikeStationRepo = new BikeStationRepo();
    }

    @Test
    public void testToJson() {
        bikeStationRepo.stationId = "id";
        bikeStationRepo.parkingBikeTotCnt = 1;
        bikeStationRepo.rackTotCnt = 1;
        bikeStationRepo.shared = 1.0f;
        bikeStationRepo.stationLatitude = 1.11f;
        bikeStationRepo.stationLongitude = 1.21f;
        bikeStationRepo.stationName = "name";

        String result = bikeStationRepo.toJson();
        System.out.println(result);
    }
}
