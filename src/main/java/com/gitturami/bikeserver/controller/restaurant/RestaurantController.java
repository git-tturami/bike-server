package com.gitturami.bikeserver.controller.restaurant;

import com.gitturami.bikeserver.infra.restaurant.Impl.RestaurantApiImpl;
import com.gitturami.bikeserver.infra.restaurant.RestaurantApi;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {
    private RestaurantApi restaurantApi = new RestaurantApiImpl();

    @RequestMapping(value= "/restaurants", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public String getTotalRestaurantList() {
        String result = restaurantApi.getTotalRestaurantList();

        if (result == null) {
//            throw new StationNotFoundException();
        }
        return result;
    }
}
