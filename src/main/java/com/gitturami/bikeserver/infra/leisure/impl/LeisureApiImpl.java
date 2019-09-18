package com.gitturami.bikeserver.infra.leisure.impl;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.LeisureApi;
import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;
import com.gitturami.bikeserver.infra.leisure.repository.LightLeisure;
import com.gitturami.bikeserver.infra.leisure.repository.body.LeisureBody;
import com.gitturami.bikeserver.infra.leisure.repository.body.item.LeisureItem;
import com.gitturami.bikeserver.infra.leisure.retrofit.LeisureRetrofit;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jaxb.JaxbConverterFactory;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LeisureApiImpl implements LeisureApi {
    private static final String TAG = "LeisureApiImpl";
//    private String serviceKey = "7BU6hvKaLizImcLOotFguCrmNH5l/ixLxWZzpCT4n2ceil5n72Y04LoPnBLC7prrNXjawXY+ZzIO3Smg2OQl5w==";
//    private Retrofit retrofit;
//    private LeisureRetrofit leisureRetrofit;
//
//    public LeisureApiImpl() {
//        retrofit = new Retrofit.Builder()
//                .baseUrl("http://api.visitkorea.or.kr/openapi/service/rest/KorService/")
//                .addConverterFactory(JaxbConverterFactory.create())
//                .build();
//        leisureRetrofit = retrofit.create(LeisureRetrofit.class);
//    }

    @Autowired
    private RetrofitConfig retrofitConfig;
    private String serviceKey = "7BU6hvKaLizImcLOotFguCrmNH5l/ixLxWZzpCT4n2ceil5n72Y04LoPnBLC7prrNXjawXY+ZzIO3Smg2OQl5w==";

    private LeisureResponse callLeisureInformaion(String contentTypeId) {
        Call<LeisureResponse> call = retrofitConfig.getLeisureRetrofit().leisureList(
                serviceKey,
                contentTypeId,
                1,
                "",
                "",
                "",
                "",
                "Y",
                "ETC",
                "TourAPI3.0_Guide",
                "A",
                10000,
                1
        );
        try {
            Response<LeisureResponse> response = call.execute();
            return response.body();
        } catch (IOException e) {
            ApiLogger.i(TAG, e.getMessage());
        }
        return null;
    }

    @Override
    public LeisureResponse getAllLeisureInformation() {
        Call<LeisureResponse> call = retrofitConfig.getLeisureRetrofit().leisureList(
                serviceKey, "", 1, "", "", "", "",
                "Y", "ETC", "TourAPI3.0_Guide", "A", 10000, 1
        );
        try {
            Response<LeisureResponse> response = call.execute();
            return response.body();
        } catch (IOException e) {
            ApiLogger.i(TAG, e.getMessage());
        }
        return null;
    }

    @Override
    public LeisureResponse getLeisureInformationByContentId(ContentTypeIds contentTypeId) {
        return null;
    }

    @Override
    public List<LightLeisure> getLightLeisureList() {
        List<LeisureItem> list = getAllLeisureInformation().body.items;
        List<LightLeisure> lightList = new ArrayList<>();
        for (LeisureItem item : list) {
            LightLeisure lightItem = new LightLeisure();
            lightItem.title = item.title;
            lightItem.mapx = item.mapx;
            lightItem.mapy = item.mapy;
            lightList.add(lightItem);
        }
        return lightList;
    }

    @Override
    public LeisureItem getLeisureByName(@NotNull String name) {
        LeisureResponse response = getAllLeisureInformation();
        for (LeisureItem item : response.body.items) {
            if (name.equals(item.title)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<LightLeisure> getLightTerrainList() {
        LeisureResponse response = callLeisureInformaion("12");
        return toLightItem(response);
    }

    private List<LightLeisure> toLightItem(LeisureResponse response) {
        List<LightLeisure> list = new ArrayList<>();
        for (LeisureItem item : response.body.items) {
            LightLeisure lightItem = new LightLeisure();
            lightItem.mapx = item.mapx;
            lightItem.mapy = item.mapy;
            lightItem.title = item.title;
            list.add(lightItem);
        }
        return list;
    }
}
