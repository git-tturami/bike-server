package com.gitturami.bikeserver.infra.bike.retrofit;

import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BikeRetrofit {
    @GET("bikeList/{startPage}/{endPage}")
    Call<BikeStationResponse> listStation(
            @Path("startPage") int startPage,
            @Path("endPage") int endPage
    );
}
