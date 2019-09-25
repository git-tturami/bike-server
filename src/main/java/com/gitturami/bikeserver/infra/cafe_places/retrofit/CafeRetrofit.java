package com.gitturami.bikeserver.infra.cafe_places.retrofit;

import com.gitturami.bikeserver.infra.cafe_places.repository.CafeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CafeRetrofit {
    @GET("nearbysearch/json")
    Call<CafeResponse> listCafe(
            @Query("location") String location,
            @Query("radius") int radius,
            @Query("type") String type,
            @Query("key") String key
    );
}
