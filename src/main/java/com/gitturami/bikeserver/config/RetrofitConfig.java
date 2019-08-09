package com.gitturami.bikeserver.config;

import com.gitturami.bikeserver.infra.bike.retrofit.BikeRetrofit;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jaxb.JaxbConverterFactory;

@Component
@ConfigurationProperties(prefix="url")
public class RetrofitConfig {
    private BikeRetrofit bikeRetrofit;

    private String bikeUrl;
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
