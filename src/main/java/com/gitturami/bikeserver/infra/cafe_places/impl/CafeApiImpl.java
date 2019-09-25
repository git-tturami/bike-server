package com.gitturami.bikeserver.infra.cafe_places.impl;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.infra.cafe_places.CafePlacesApi;
import com.gitturami.bikeserver.infra.cafe_places.repository.CafeRepo;
import com.gitturami.bikeserver.infra.cafe_places.repository.CafeResponse;
import com.gitturami.bikeserver.infra.cafe_places.repository.LightCafe;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
public class CafeApiImpl implements CafePlacesApi {

    private static final String TAG = "Cafe_PlacesApiImpl";

    @Autowired
    private RetrofitConfig retrofitConfig;
    private String serviceKey = "AIzaSyDKfG8w4vC4Wv4NCIKOMK2i1ioODzcHqDM";


    @Override
    public CafeResponse getCafeList(String location) {
        Call<CafeResponse> call = retrofitConfig.getCafePlaceRetrofit().listCafe(
                location, 1500, "cafe", serviceKey
        );
        try{
            Response<CafeResponse> response = call.execute();
            return response.body();
        }catch (IOException e){
            ApiLogger.i(TAG, e.getMessage());
        }
        return null;
    }

    @Override
    public CafeResponse getAllCafeList() {
        return null;
    }

    @Override
    public List<LightCafe> getAllLightCafeList() {
        return null;
    }

    @Override
    public CafeRepo getCafeByName(String name) {
        return null;
    }
}
