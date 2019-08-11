package com.gitturami.bikeserver.infra.restaurant.retrofit;

import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestaurantRetrofit {
    @GET("CrtfcUpsoInfo/{startPage}/{endPage}")
    Call<RestaurantResponse> restaurantList(
            @Path("startPage") int startPage,
            @Path("endPage") int endPage
    );
}
