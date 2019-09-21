package com.gitturami.bikeserver.infra.cafe_places.impl;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.infra.cafe_places.CafePlacesApi;
import com.gitturami.bikeserver.infra.cafe_places.repository.CafeList;
import com.gitturami.bikeserver.infra.cafe_places.repository.CafeRepo;
import com.gitturami.bikeserver.infra.cafe_places.repository.CafeResponse;
import com.gitturami.bikeserver.infra.cafe_places.repository.LightCafe;
import com.gitturami.bikeserver.infra.cafe_places.retrofit.CafePlacesRetrofit;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CafePlacesApiImpl implements CafePlacesApi {

    private static final String TAG = "Cafe_PlacesApiImpl";

    @Autowired
    private RetrofitConfig retrofitConfig;
    private String key = "AIzaSyDKfG8w4vC4Wv4NCIKOMK2i1ioODzcHqDM";


    @Override
    public CafeList getCafeList(String location) {
        Response<CafeList> response;
       Call<CafeList> call = retrofitConfig.getCafePlacesRetrofit().allCafe(location, "1500", "cafe", key);
  try{
             response = call.execute();
            return response.body();
        }catch (IOException e){
            ApiLogger.i(TAG, e.getMessage());
        }
        return null;
    }

    @Override
    public List<CafeRepo> getAllPageCafeList(String location) {
        List<CafeRepo> allcafe = new ArrayList<>();
        CafeList response;
        response = getCafeList(location);
        allcafe.addAll(response.results);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(response.next_page_token!=null){
            Response<CafeList> secondPage = null;
            Call<CafeList> call = retrofitConfig.getCafePlacesRetrofit().nextPage(key,response.next_page_token);
            try {
                secondPage = call.execute();
                allcafe.addAll(secondPage.body().results);
            } catch (IOException e) {
                ApiLogger.i(TAG, e.getMessage());
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(secondPage.body().next_page_token!=null){
                Response<CafeList> thirdPage;
                call = retrofitConfig.getCafePlacesRetrofit().nextPage(key,secondPage.body().next_page_token);
                try {
                    thirdPage = call.execute();
                    allcafe.addAll(thirdPage.body().results);
                } catch (IOException e) {
                    ApiLogger.i(TAG, e.getMessage());
                }
            }
        }
        return allcafe;
    }

    @Override
    public List<LightCafe> getAllLightCafeList(String location) {
        List<LightCafe> allCafe = new ArrayList<>();
        List<CafeRepo> response = getAllPageCafeList(location);
        for(CafeRepo repo : response){
            if(repo.geometry.location.lat ==null || "".equals(repo.geometry.location.lat.trim())){
                continue;
            }
            LightCafe item = new LightCafe();
            item.name = repo.name;
            item.lat = repo.geometry.location.lat;
            item.lng = repo.geometry.location.lng;
            allCafe.add(item);
        }
        return allCafe;
    }

    @Override
    public CafeRepo getCafeByName(String name) {
        return null;
    }
}
