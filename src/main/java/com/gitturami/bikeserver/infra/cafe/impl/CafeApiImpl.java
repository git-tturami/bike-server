package com.gitturami.bikeserver.infra.cafe.impl;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.infra.cafe.CafeApi;
import com.gitturami.bikeserver.infra.cafe.repository.CafeRepo;
import com.gitturami.bikeserver.infra.cafe.repository.CafeResponse;
import com.gitturami.bikeserver.infra.cafe.repository.LightCafe;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        CafeResponse response =  getCafeList(1, 1000);
        response.coffeeShopInfo.row.addAll(getCafeList(1001, 2000).coffeeShopInfo.row);
        response.coffeeShopInfo.list_total_count = response.coffeeShopInfo.row.size();
        return response;
    }

    @Override
    public List<LightCafe> getAllLightCafeList() {
        CafeResponse response = getAllCafeList();
        List<LightCafe> result = new ArrayList<>();
        for (CafeRepo repo : response.coffeeShopInfo.row) {
            if (repo.XCODE == null || "".equals(repo.XCODE.trim())) {
                continue;
            }
            LightCafe item = new LightCafe();
            item.NM = repo.NM;
            item.XCODE = repo.XCODE;
            item.YCODE = repo.YCODE;
            result.add(item);
        }
        return result;
    }

    @Override
    public CafeRepo getCafeByName(String name) {
        CafeResponse response = getAllCafeList();
        for (CafeRepo repo : response.coffeeShopInfo.row) {
            if (name.equals(repo.NM)) {
                return repo;
            }
        }
        return null;
    }
}
