package com.gitturami.bikeserver.config;

import com.gitturami.bikeserver.infra.bike.retrofit.BikeRetrofit;
import com.gitturami.bikeserver.infra.cafe.retrofit.CafeRetrofit;
import com.gitturami.bikeserver.infra.cafe_places.CafePlacesApi;
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
    private CafeRetrofit cafeRetrofit;
    private LeisureRetrofit leisureRetrofit;
    private com.gitturami.bikeserver.infra.cafe_places.retrofit.CafeRetrofit cafePlaceRetrofit;

    @Value("${url.seoulUrl}")
    private String seoulUrl;

    @Value("${url.tourUrl}")
    private String tourUrl;

    @Value("${url.placesUrl}")
    private String placesUrl;

    public RetrofitConfig() {
        System.out.println("retrofit config");
    }

    public void setSeoulUrl(String url) {
        seoulUrl = url;
    }

    public BikeRetrofit getBikeRetrofit() {
        if (bikeRetrofit == null) {
            setBikeRetrofit();
        }

        return bikeRetrofit;
    }

    private void setBikeRetrofit() {
        bikeRetrofit = new Retrofit.Builder()
                .baseUrl(seoulUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BikeRetrofit.class);
    }

    public RestaurantRetrofit getRestaurantRetrofit() {
        System.out.println("getRestaurantRetrofit()");
        if (restaurantRetrofit == null) {
            setRestaurantRetrofit();
        }

        return restaurantRetrofit;
    }

    private void setRestaurantRetrofit() {
        restaurantRetrofit = new Retrofit.Builder()
                .baseUrl(seoulUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestaurantRetrofit.class);
    }

    public CafeRetrofit getCafeRetrofit() {
        if (cafeRetrofit == null) {
            setCafeRetrofit();
        }

        return cafeRetrofit;
    }

    private void setCafeRetrofit() {
        cafeRetrofit = new Retrofit.Builder()
                .baseUrl(seoulUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CafeRetrofit.class);
    }

    public LeisureRetrofit getLeisureRetrofit() {
        if (leisureRetrofit == null) {
            setLeisureRetrofit();
        }

        return leisureRetrofit;
    }

    private void setLeisureRetrofit() {
        leisureRetrofit = new Retrofit.Builder()
                .baseUrl(tourUrl)
                .addConverterFactory(JaxbConverterFactory.create())
                .build()
                .create(LeisureRetrofit.class);
    }

    public com.gitturami.bikeserver.infra.cafe_places.retrofit.CafeRetrofit getCafePlaceRetrofit() {
        if (cafePlaceRetrofit == null) {
            setCafePlaceRetrofit();
        }

        return cafePlaceRetrofit;
    }

    private void setCafePlaceRetrofit() {
        cafePlaceRetrofit = new Retrofit.Builder()
                .baseUrl(placesUrl)
                .addConverterFactory(JaxbConverterFactory.create())
                .build()
                .create(com.gitturami.bikeserver.infra.cafe_places.retrofit.CafeRetrofit.class);
    }
}
