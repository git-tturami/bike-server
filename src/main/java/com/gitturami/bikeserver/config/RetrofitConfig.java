package com.gitturami.bikeserver.config;

import com.gitturami.bikeserver.infra.bike.retrofit.BikeRetrofit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class RetrofitConfig {
    private BikeRetrofit bikeRetrofit;

    @Value("${url.bikeUrl}")
    private String bikeUrl;
    @Value("${url.tourUrl}")
    private String tourUrl;

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
}
