package com.gitturami.bikeserver.infra.restaurant;

import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepo;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepoLight;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;

import java.util.List;

public interface RestaurantApi {
    RestaurantResponse getAllRestaurantList();

    // getRestaurantList() returns restaurant list from start page to end page.
    RestaurantResponse getRestaurantList(int startPage, int endPage);

    RestaurantRepo getRestaurantByName(String name);

    // getLightRestaurantList() returns summarized restaurant list from start page to end page.
    List<RestaurantRepoLight> getLightRestaurantList(int startPage, int endPage);

    // getNearRestaurantList() returns restaurant list located in nearby start pos or end pos.
    List<RestaurantRepo> getNearbyRestaurantList(float startLat, float startLon, float endLat, float endLon);
}
