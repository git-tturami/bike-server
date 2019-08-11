package com.gitturami.bikeserver.infra.restaurant.impl;

import com.gitturami.bikeserver.infra.restaurant.Impl.RestaurantApiImpl;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.net.ssl.*")
public class RestaurantApiImplTest {

    private RestaurantApiImpl api;

    @Before
    public void setUp() {
        api = new RestaurantApiImpl();
    }

    @Test
    public void testGetRestaurantList() {
        RestaurantResponse restaurantResponse = api.getRestaurantList(1, 2);
        System.out.println(restaurantResponse);
    }
}
