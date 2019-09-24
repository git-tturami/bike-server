package com.gitturami.bikeserver.controller.restaurant;

import com.gitturami.bikeserver.controller.restaurant.exception.RestaurantNotFoundException;
import com.gitturami.bikeserver.infra.restaurant.Impl.RestaurantApiImpl;
import com.gitturami.bikeserver.infra.restaurant.RestaurantApi;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepo;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepoLight;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantApi restaurantApi;

    @GetMapping("/list")
    public List<RestaurantRepo> getAllRestaurantList() {
        List<RestaurantRepo> list = restaurantApi.getAllRestaurantList();

        if (list == null) {
            throw new RestaurantNotFoundException();
        }
        return list;
    }

    @GetMapping("/summaries")
    public List<RestaurantRepoLight> getLightRestaurantList() {
        List<RestaurantRepoLight> lightList = new ArrayList<>();
        lightList = restaurantApi.getLightRestaurantList();

        return lightList;
    }

    @GetMapping("/close")
    public List<RestaurantRepo> getNearbyRestaurantList(@RequestParam float startLat, @RequestParam float startLon,
                                                      @RequestParam float endLat, @RequestParam float endLon) {
        return restaurantApi.getNearbyRestaurantList(startLat, startLon, endLat, endLon);
    }

    @GetMapping("/name")
    public RestaurantRepo getRestaurantByName(@RequestParam String name) {
        return restaurantApi.getRestaurantByName(name);
    }
}
