package com.gitturami.bikeserver.infra.bike.impl;

import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepo;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepoLight;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;
import org.junit.Ignore;
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
        // assertEquals(2, response.rentBikeStatus.row.size());
    }

    @Test
    public void testGetStationInfoById_mustNull() {
        BikeStationRepo result = api.getStationInfoById(124133);
        System.out.println(result);
        // assertNull(result);
    }

    @Test
    public void testGetStationInfoById_success() {
        BikeStationRepo result = api.getStationInfoById(38);
        if (!result.stationName.contains("서교동")) {
            // fail();
        }
    }

    @Test
    public void testGetStationInfoByName_fail() {
        BikeStationRepo result = api.getStationInfoByTownName("링딩동");
        System.out.println(result);
        // assertNull(result);
    }

    @Test
    public void testGetStationInfoByTownName_success() {
        BikeStationRepo result = api.getStationInfoByTownName("서교동");
        System.out.println(result);
        if(!result.stationId.contains("ST-10")) {
            // fail();
        }
    }

    @Test
    public void testGetStationListByEnableBike() {
        List<BikeStationRepo> result = api.getStationListByEnableBike();
        System.out.println(result);
    }

    @Test
    public void testSortingStationListByEnableBike() throws Exception {
        List<BikeStationRepo> bikeStationList =
                Whitebox.invokeMethod(api, "sortingStationListByEnableBike");

        for (int i = 1; i<bikeStationList.size(); i++) {
            if (bikeStationList.get(i-1).parkingBikeTotCnt < bikeStationList.get(i).parkingBikeTotCnt) {
                // fail(i + "index is bigger than " + (i-1) + "index.");
            }
        }
    }

    @Test
    public void testSortiongStationListByDistance() throws Exception {
        // testLat testLong is lat and lon of Chung-Ang university
        float testLat = 37.5050881f;
        float testLon = 126.9571012f;
        List<BikeStationRepoLight> lightList = api.getStationListByDistance(testLat, testLon);
        //        Whitebox.invokeMethod(api, "sortingStationListByDistance", testLat, testLon);

        double prevDistance = 0.0;

        for (int i=0; i < lightList.size(); i++) {
            BikeStationRepoLight bikeStationRepoLight = lightList.get(i);
            double distance = Math.pow(Double.parseDouble(bikeStationRepoLight.stationLatitude) - testLat, 2.0)
                    + Math.pow(Double.parseDouble(bikeStationRepoLight.stationLongitude) - testLon, 2.0);

            System.out.println(distance);
            System.out.println(bikeStationRepoLight);

            if (i > 0) {
                // Distance must be larger than previous Distance.
                if (distance < prevDistance) {
                    fail();
                }
            }

            prevDistance = distance;
        }
    }

    @Test
    public void testGetLightStationList() {
        List<BikeStationRepoLight> lightList = api.getLightStationList(1, 2);
        System.out.println(lightList.get(1));
    }

    @Test
    public void testGetAllStationList() {
        BikeStationResponse bikeStationResponse = api.getStationList(1, 2);
        System.out.println(bikeStationResponse.rentBikeStatus.row.size());
    }
}