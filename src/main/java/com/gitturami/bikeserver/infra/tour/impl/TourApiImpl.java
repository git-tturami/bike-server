package com.gitturami.bikeserver.infra.tour.impl;

import com.gitturami.bikeserver.infra.logger.ApiLogger;
import com.gitturami.bikeserver.infra.tour.TourApi;
import com.gitturami.bikeserver.infra.tour.repository.TourRepo;
import com.gitturami.bikeserver.infra.tour.repository.TourResponse;
import com.gitturami.bikeserver.infra.tour.retrofit.TourRetrofit;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class TourApiImpl implements TourApi {
    private static final String TAG = "TourApiImpl";
    private Retrofit retrofit;
    private TourRetrofit tourRetrofit;

    public TourApiImpl(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword?ServiceKey=ltczhzVqVJtJYFWJLucs%2BY4dhLti3vFnncvY0Rx9NP3c%2B0fa6YyexjSmvNQ1mPRlKMgwahURxuse3TDzyEpDlA%3D%3D&")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tourRetrofit = retrofit.create(TourRetrofit.class);
    }

    @Override
    public TourResponse getTourList(String keyword) {
       try {
        String encodedKeyword = URLEncoder.encode(keyword, "UTF-8");
        Call<TourResponse> call = tourRetrofit.listTour(encodedKeyword);

        Response<TourResponse> response = call.execute();
        TourResponse body = response.body();
        return body;
       } catch (UnsupportedEncodingException e) {
           ApiLogger.i(TAG, e.getMessage());
        } catch (IOException e) {
           ApiLogger.i(TAG, e.getMessage());
       }
        return null;
    }

    @Override
    public TourRepo getTourListById() {
        return null;
    }

    @Override
    public TourRepo getTourListByName() {
        return null;
    }
}
