package com.gitturami.bikeserver.infra.restaurant;

import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;

public interface RestaurantApi {
    String getTotalRestaurantList();

    // getRestaurantList() returns restaurant list from start page to end page.
    RestaurantResponse getRestaurantList(int startPage, int endPage);
}
