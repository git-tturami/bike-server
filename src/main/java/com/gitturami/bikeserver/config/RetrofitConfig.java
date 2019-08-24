package com.gitturami.bikeserver.config;

import com.gitturami.bikeserver.infra.bike.retrofit.BikeRetrofit;
import com.gitturami.bikeserver.infra.leisure.retrofit.LeisureRetrofit;
import com.gitturami.bikeserver.infra.restaurant.retrofit.RestaurantRetrofit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jaxb.JaxbConverterFactory;

import java.util.ResourceBundle;

@Component
public class RetrofitConfig {
    private BikeRetrofit bikeRetrofit;
    private RestaurantRetrofit restaurantRetrofit;
    private LeisureRetrofit leisureRetrofit;

    @Value("${url.bikeUrl}")
    private String bikeUrl;
    @Value("${url.tourUrl}")
    private String tourUrl;
    @Value("${url.restaurantUrl}")
    private String restaurantUrl;
    @Value("${url.leisureUrl}")
    private String leisureUrl;

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

    public LeisureRetrofit getLeisureRetrofit() {
        if (leisureRetrofit == null) {
            setLeisureRetrofit();
        }

        return leisureRetrofit;
    }

    private void setLeisureRetrofit() {
        leisureRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.visitkorea.or.kr/openapi/service/rest/KorService/")
                .addConverterFactory(JaxbConverterFactory.create())
                .build()
                .create(LeisureRetrofit.class);
    }
}
