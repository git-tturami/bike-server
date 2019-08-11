package com.gitturami.bikeserver.controller.restaurant;

import com.gitturami.bikeserver.controller.restaurant.exception.RestaurantNotFoundException;
import com.gitturami.bikeserver.infra.restaurant.Impl.RestaurantApiImpl;
import com.gitturami.bikeserver.infra.restaurant.RestaurantApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private RestaurantApi restaurantApi = new RestaurantApiImpl();

    @GetMapping("")
    public String getTotalRestaurantList() {
        String result = restaurantApi.getTotalRestaurantList();

        if (result == null) {
            throw new RestaurantNotFoundException();
        }
        return result;
    }
}
