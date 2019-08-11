package com.gitturami.bikeserver.infra.restaurant.repository;

import com.gitturami.bikeserver.infra.bike.repository.BikeStationList;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepo;

import java.util.List;

public class RestaurantList {
    public int list_total_count;
    public RestaurantList.Result RESULT;
    public List<RestaurantRepo> row;

    public class Result {
        String CODE;
        String MESSAGE;
    }

    @Override
    public String toString() {
        return String.format("Result Code : %s\n" +
                "Result Message : %s\n" +
                "List total count : %d\n\n" +
                "row : %s", RESULT.CODE, RESULT.MESSAGE, list_total_count, row);
    }
}
