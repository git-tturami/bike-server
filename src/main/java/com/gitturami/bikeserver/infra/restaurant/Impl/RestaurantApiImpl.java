package com.gitturami.bikeserver.infra.restaurant.Impl;

import com.gitturami.bikeserver.infra.logger.ApiLogger;
import com.gitturami.bikeserver.infra.restaurant.RestaurantApi;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepo;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;
import com.gitturami.bikeserver.infra.restaurant.retrofit.RestaurantRetrofit;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class RestaurantApiImpl implements RestaurantApi {

    private static final String TAG = "RestaurantApiImpl";
    private Retrofit retrofit;
    private RestaurantRetrofit restaurantRetrofit;

    public RestaurantApiImpl() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://openapi.seoul.go.kr:8088/4b64546d6862687339384d4b625366/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        restaurantRetrofit = retrofit.create(RestaurantRetrofit.class);
    }

    @Override
    public String getTotalRestaurantList() {
        RestaurantResponse restaurantResponse = getRestaurantList(1, 1000);
        return restaurantResponse.toJson();
    }

    @Override
    public RestaurantResponse getRestaurantList(int startPage, int endPage) {
        Call<RestaurantResponse> call = restaurantRetrofit.restaurantList(startPage, endPage);
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
