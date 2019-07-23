package com.gitturami.bikeserver.infra.tour.retrofit;

import com.gitturami.bikeserver.infra.tour.repository.TourResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface TourRetrofit {
    @GET("keyword={keyword}&MobileOS=ETC&MobileApp=bikeserver")
    Call<TourResponse> listTour(
            @Path("keyword") String keyword
    );
}
