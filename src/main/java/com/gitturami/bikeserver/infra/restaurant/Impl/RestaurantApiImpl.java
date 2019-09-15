package com.gitturami.bikeserver.infra.restaurant.Impl;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import com.gitturami.bikeserver.infra.restaurant.RestaurantApi;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Service
public class RestaurantApiImpl implements RestaurantApi {

    private static final String TAG = "RestaurantApiImpl";

    @Autowired
    private RetrofitConfig retrofitConfig;

    @Override
    public RestaurantResponse getAllRestaurantList() {
        return getRestaurantList(1, 1000);
    }

    @Override
    public RestaurantResponse getRestaurantList(int startPage, int endPage) {
        System.out.println("get()");
        Call<RestaurantResponse> call = retrofitConfig.getRestaurantRetrofit().restaurantList(startPage, endPage);
        try {
            Response<RestaurantResponse> response = call.execute();
            RestaurantResponse body = response.body();
            return body;
        } catch (IOException e) {
            ApiLogger.i(TAG, e.getMessage());
        }
        return null;
    }
}
