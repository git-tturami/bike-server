package com.gitturami.bikeserver.infra.restaurant.impl;

import com.gitturami.bikeserver.infra.restaurant.Impl.RestaurantApiImpl;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
