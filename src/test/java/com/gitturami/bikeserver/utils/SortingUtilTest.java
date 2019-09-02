package com.gitturami.bikeserver.utils;

import com.gitturami.bikeserver.common.repository.Item;
import com.gitturami.bikeserver.infra.cafe.impl.CafeApiImpl;
import com.gitturami.bikeserver.infra.cafe.repository.CafeRepo;
import com.gitturami.bikeserver.infra.cafe.repository.CafeResponse;
import com.gitturami.bikeserver.infra.restaurant.Impl.RestaurantApiImpl;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepo;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PowerMockIgnore("javax.net.ssl.*")
public class SortingUtilTest {

    @Autowired
    private RestaurantApiImpl restaurantApi;

    @Test
    public void testPickNearby() {
        RestaurantResponse restaurantResponse = restaurantApi.getRestaurantList(1, 1000);
        List<RestaurantRepo> restaurantList = restaurantResponse.CrtfcUpsoInfo.row;

        List<RestaurantRepo> result = SortingUtil.pickNearby(37.556406, 126.937992,
                37.564040,126.975246, restaurantList);
        System.out.println(result);
    }
}
