package com.gitturami.bikeserver.infra.bike.impl;

import com.gitturami.bikeserver.infra.bike.BikeStationApi;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationList;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepo;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;
import com.gitturami.bikeserver.infra.bike.retrofit.BikeRetrofit;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BikeStationApiImpl implements BikeStationApi {

    private static final String TAG = "BikeStationApiImpl";
    private Retrofit retrofit;
    private BikeRetrofit bikeRetrofit;

    public BikeStationApiImpl() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://openapi.seoul.go.kr:8088/4b64546d6862687339384d4b625366/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        bikeRetrofit = retrofit.create(BikeRetrofit.class);
    }

    @Override
    public String getEnableBike(String stationId) {
        // Call<List<BikeStationRepo>> list = bikeRetrofit.listStation(startPage, endPage);

        return null;
    }

    @Override
    public String getTotalBike() {
        return null;
    }

    //minji
    @Override
    public String getStationInfoById (String stationId) {
        BikeStationResponse bikeStationResponse = getStationList(1, 1000);
        List<BikeStationRepo> totalBikeStationList = bikeStationResponse.rentBikeStatus.row;

        for (BikeStationRepo bikeStationRepo : totalBikeStationList) {
            if (bikeStationRepo.stationId.equals(stationId)) {
                return bikeStationRepo.toJson();
            }
        }
        return null;
    }

    @Override
    public String getStationInfoByTownName(String townName) {
        BikeStationResponse bikeStationResponse = getStationList(1, 1000);
        List<BikeStationRepo> totalBikeStationList = bikeStationResponse.rentBikeStatus.row;

        for (BikeStationRepo bikeStationRepo : totalBikeStationList) {
            if (bikeStationRepo.stationName.contains(townName)) {
                return bikeStationRepo.toJson();
            }
        }
        return null;
    }

    private BikeStationResponse sortingStationListByEnableBike() {
        BikeStationResponse bikeStationResponse = getStationList(1, 1000);

        bikeStationResponse.rentBikeStatus.row.sort((o1, o2) -> o2.parkingBikeTotCnt - o1.parkingBikeTotCnt);

        return bikeStationResponse;
    }

    @Override
    public String getStationListByEnableBike() {
        BikeStationResponse bikeStationResponse = sortingStationListByEnableBike();

        return bikeStationResponse.toJson();
    }

    @Override
    public String getStationInfo() {
        return null;
    }

    @Override
    public BikeStationResponse getStationList(int startPage, int endPage) {
        Call<BikeStationResponse> call = bikeRetrofit.listStation(startPage, endPage);
        try {
            Response<BikeStationResponse> response = call.execute();
            BikeStationResponse body = response.body();
            return body;
        } catch (IOException e) {
            ApiLogger.i(TAG, e.getMessage());
        }
        return null;
    }
}
