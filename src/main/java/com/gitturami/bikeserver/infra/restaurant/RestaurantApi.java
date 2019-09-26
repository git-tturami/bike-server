package com.gitturami.bikeserver.infra.restaurant;

import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepo;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepoLight;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;

import java.util.List;

public interface RestaurantApi {
    List<RestaurantRepo> getAllRestaurantList();

    // getRestaurantList() returns restaurant list from start page to end page.
    RestaurantResponse getRestaurantList(int startPage, int endPage);

    // getRestaurantByname() returns restaurant information with the station's name requested by client.
    RestaurantRepo getRestaurantByName(String name);

    // getRestaurantById() returns restaurant information with the station's id requested by client.
    RestaurantRepo getRestaurantById(int id);

    // getLightRestaurantList() returns summarized restaurant list from start page to end page.
    List<RestaurantRepoLight> getLightRestaurantList();

    // getNearRestaurantList() returns restaurant list located in nearby start pos or end pos.
    List<RestaurantRepo> getNearbyRestaurantList(float startLat, float startLon, float endLat, float endLon);
}
