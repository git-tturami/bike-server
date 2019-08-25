package com.gitturami.bikeserver.infra.cafe.retrofit;

import com.gitturami.bikeserver.infra.cafe.repository.CafeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CafeRetrofit {
    @GET("coffeeShopInfo/{startPage}/{endPage}")
    Call<CafeResponse> listCafe(
            @Path("startPage") int startPage,
            @Path("endPage") int endPage

    );
}
