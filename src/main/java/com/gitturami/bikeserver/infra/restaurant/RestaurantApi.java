package com.gitturami.bikeserver.infra.restaurant;

import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepo;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepoLight;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;

import java.util.List;

public interface RestaurantApi {
    RestaurantResponse getAllRestaurantList();

    // getRestaurantList() returns restaurant list from start page to end page.
    RestaurantResponse getRestaurantList(int startPage, int endPage);

    // getLightRestaurantList() returns summarized restaurant list from start page to end page.
    List<RestaurantRepoLight> getLightRestaurantList(int startPage, int endPage);

    RestaurantRepo getRestaurantByName(String name);
}
