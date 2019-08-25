package com.gitturami.bikeserver.infra.cafe.impl;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.infra.cafe.CafeApi;
import com.gitturami.bikeserver.infra.cafe.repository.CafeResponse;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Service
public class CafeApiImpl implements CafeApi {

    private static final String TAG = "CafeApiImpl";

    @Autowired
    private RetrofitConfig retrofitConfig;

    @Override
    public CafeResponse getCafeList(int startPage, int endPage) {
        Call<CafeResponse> call = retrofitConfig.getCafeRetrofit().listCafe(startPage, endPage);
        try {
            Response<CafeResponse> response = call.execute();
            return response.body();
        } catch (IOException e) {
            ApiLogger.i(TAG, e.getMessage());
        }
        return null;
    }

    @Override
    public CafeResponse getAllCafeList() {
        return getCafeList(1, 1000);
    }
}
