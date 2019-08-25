package com.gitturami.bikeserver.infra.bike.impl;

import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepo;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PowerMockIgnore("javax.net.ssl.*")
public class BikeStationApiImplTest {

    @Autowired
    private BikeStationApiImpl api;

    @Test
    public void testGetStationList() {
        // execute
        BikeStationResponse response = api.getStationList(1, 2);

        // verify
        System.out.println(response.toString());
        assertEquals(2, response.rentBikeStatus.row.size());
    }

    @Test
    public void testGetStationInfoById_success() {
        BikeStationRepo result = api.getStationInfoById("ST-109898");
        System.out.println(result);
        assertNull(result);
    }

    @Test
    public void testGetStationInfoById_fail() {
        BikeStationRepo result = api.getStationInfoById("ST-10");
        if (!result.stationName.contains("서교동")) {
            fail();
        }
    }

    @Test
    public void testGetStationInfoByName_success() {
        BikeStationRepo result = api.getStationInfoByTownName("링딩동");
        System.out.println(result);
        assertNull(result);
    }

    @Test
    public void testGetStationInfoByTownName_fail() {
        BikeStationRepo result = api.getStationInfoByTownName("서교동");
        System.out.println(result);
        if(!result.stationId.contains("ST-10")) {
            fail();
        }
    }

    @Test
    public void testGetStationListByEnableBike() {
        BikeStationResponse result = api.getStationListByEnableBike();
        System.out.println(result);
    }

    @Test
    public void testSortingStationListByEnableBike() throws Exception {
        BikeStationResponse bikeStationResponse =
                Whitebox.invokeMethod(api, "sortingStationListByEnableBike");

        List<BikeStationRepo> bikeStationList = bikeStationResponse.rentBikeStatus.row;

        for (int i = 1; i<bikeStationList.size(); i++) {
            if (bikeStationList.get(i-1).parkingBikeTotCnt < bikeStationList.get(i).parkingBikeTotCnt) {
                fail(i + "index is bigger than " + (i-1) + "index.");
            }
        }
    }

    @Test
    public void testSortiongStationListByDistance() throws Exception {
        // testLat testLong is lat and lon of Chung-Ang university
        float testLat = 37.5050881f;
        float testLon = 126.9571012f;
        BikeStationResponse bikeStationResponse =
                Whitebox.invokeMethod(api, "sortingStationListByDistance", testLat, testLon);

        double prevDistance = 0.0;
        for (int i=0; i < bikeStationResponse.rentBikeStatus.row.size(); i++) {
            BikeStationRepo repo = bikeStationResponse.rentBikeStatus.row.get(i);
            double distance = Math.pow((double)(repo.stationLatitude - testLat), 2.0)
                    + Math.pow((double)(repo.stationLongitude - testLon), 2.0);
            if (i > 0) {
                // Distance must be larger than previous Distance.
                if (distance < prevDistance) {
                    fail();
                }
            }
            prevDistance = distance;
        }
    }
}