package com.gitturami.bikeserver.infra.restaurant.impl;

import com.gitturami.bikeserver.infra.restaurant.Impl.RestaurantApiImpl;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepo;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepoLight;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PowerMockIgnore("javax.net.ssl.*")
public class RestaurantApiImplTest {

    @Autowired
    private RestaurantApiImpl api;

    @Test
    public void testGetRestaurantList() {
        RestaurantResponse restaurantResponse = api.getRestaurantList(1, 2);
        System.out.println(restaurantResponse.CrtfcUpsoInfo.row.size());
    }

    @Test
    public void testGetLightRestaurantList() {
        List<RestaurantRepoLight> restaurantRepoLightList = api.getLightRestaurantList();
        System.out.println(restaurantRepoLightList.size());
    }

    @Test
    public void testGetNearbyRestaurantList() {
        float testStartLat = 37.5050881f;
        float testStartLon = 126.9571012f;
        float testEndLat = 37.566535f;
        float testEndLon = 126.9779691f;

        List<RestaurantRepo> list = api.getNearbyRestaurantList(testStartLat, testStartLon, testEndLat, testEndLon);
        double prevDistance = 0.0;

        for (int i = 0; i < list.size(); i++) {
            RestaurantRepo restaurantRepo = list.get(i);

            double distanceFromStart = Math.pow(Double.parseDouble(restaurantRepo.Y_DNTS) - testStartLat, 2.0)
                    + Math.pow(Double.parseDouble(restaurantRepo.X_CNTS) - testStartLon, 2.0);
            double distanceFromEnd = Math.pow(Double.parseDouble(restaurantRepo.Y_DNTS) - testEndLat, 2.0)
                    + Math.pow(Double.parseDouble(restaurantRepo.X_CNTS) - testEndLon, 2.0);

            double distance = distanceFromStart < distanceFromEnd ? distanceFromStart : distanceFromEnd;

            System.out.println("distance : " + distance);
            System.out.println(restaurantRepo);

            if (i > 0) {
                if (prevDistance > distance) {
                    fail();
                }
            }

            prevDistance = distance;
        }
    }
}
