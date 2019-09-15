package com.gitturami.bikeserver.controller.restaurant;

import com.gitturami.bikeserver.controller.restaurant.exception.RestaurantNotFoundException;
import com.gitturami.bikeserver.infra.restaurant.Impl.RestaurantApiImpl;
import com.gitturami.bikeserver.infra.restaurant.RestaurantApi;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepo;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantApi restaurantApi;

    @GetMapping("/list")
    public List<RestaurantRepo> getTotalRestaurantList() {
        RestaurantResponse result = restaurantApi.getAllRestaurantList();

        if (result == null) {
            throw new RestaurantNotFoundException();
        }
        return result.CrtfcUpsoInfo.row;
    }
}
