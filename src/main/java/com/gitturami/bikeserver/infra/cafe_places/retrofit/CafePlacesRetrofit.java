package com.gitturami.bikeserver.infra.cafe_places.retrofit;

import com.gitturami.bikeserver.infra.cafe_places.repository.CafeList;
import com.gitturami.bikeserver.infra.cafe_places.repository.CafeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CafePlacesRetrofit {
    @GET("nearbysearch/json")
    Call<CafeList> allCafe(
            @Query(value = "location", encoded = true) String location,
            @Query("radius") String radius,
            @Query("type") String type,
            @Query("key") String key
    );

    @GET("nearbysearch/json")
    Call<CafeList> nextPage(
            @Query("key") String key,
            @Query("pagetoken") String pagetoken
    );
}
