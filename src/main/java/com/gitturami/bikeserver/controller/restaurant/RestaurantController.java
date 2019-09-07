package com.gitturami.bikeserver.controller.restaurant;

import com.gitturami.bikeserver.controller.restaurant.exception.RestaurantNotFoundException;
import com.gitturami.bikeserver.infra.restaurant.Impl.RestaurantApiImpl;
import com.gitturami.bikeserver.infra.restaurant.RestaurantApi;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private RestaurantApi restaurantApi = new RestaurantApiImpl();

    @GetMapping("")
    public RestaurantResponse getTotalRestaurantList() {
        RestaurantResponse result = restaurantApi.getAllRestaurantList();

        if (result == null) {
            throw new RestaurantNotFoundException();
        }
        return result;
    }
}
