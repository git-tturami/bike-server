package com.gitturami.bikeserver.config;

import com.gitturami.bikeserver.infra.bike.retrofit.BikeRetrofit;
import com.gitturami.bikeserver.infra.restaurant.retrofit.RestaurantRetrofit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ResourceBundle;

@Component
public class RetrofitConfig {
    private BikeRetrofit bikeRetrofit;
    private RestaurantRetrofit restaurantRetrofit;

    @Value("${url.bikeUrl}")
    private String bikeUrl;
    @Value("${url.tourUrl}")
    private String tourUrl;
    @Value("${url.restaurantUrl}")
    private String restaurantUrl;

    public RetrofitConfig() {
        System.out.println("retrofit config");
    }

    public void setBikeUrl(String url) {
        bikeUrl = url;
    }

    public void setTourUrl(String url) {
        tourUrl = url;
    }

    public BikeRetrofit getBikeRetrofit() {
        if (bikeRetrofit == null) {
            setBikeRetrofit();
        }

        return bikeRetrofit;
    }

    private void setBikeRetrofit() {
        bikeRetrofit = new Retrofit.Builder()
                .baseUrl(bikeUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BikeRetrofit.class);
    }

    public RestaurantRetrofit getRestaurantRetrofit() {
        if (restaurantRetrofit == null) {
            setRestaurantRetrofit();
        }

        return restaurantRetrofit;
    }

    private void setRestaurantRetrofit() {
        restaurantRetrofit = new Retrofit.Builder()
                .baseUrl("http://openapi.seoul.go.kr:8088/4b64546d6862687339384d4b625366/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestaurantRetrofit.class);
    }
}
