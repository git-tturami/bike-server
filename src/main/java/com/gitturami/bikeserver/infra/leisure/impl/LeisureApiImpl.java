package com.gitturami.bikeserver.infra.leisure.impl;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.LeisureApi;
import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;
import com.gitturami.bikeserver.infra.leisure.repository.LightLeisure;
import com.gitturami.bikeserver.infra.leisure.repository.body.item.LeisureItem;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LeisureApiImpl implements LeisureApi {
    private static final String TAG = "LeisureApiImpl";
    List<LeisureItem> leisureList;
    List<LightLeisure> lightLeisureList;

    @Autowired
    private RetrofitConfig retrofitConfig;
    private String serviceKey = "7BU6hvKaLizImcLOotFguCrmNH5l/ixLxWZzpCT4n2ceil5n72Y04LoPnBLC7prrNXjawXY+ZzIO3Smg2OQl5w==";

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

    private void setLeisureList() {
        leisureList = new ArrayList<>();
        lightLeisureList = new ArrayList<>();

        LeisureResponse response = new LeisureResponse();
        response = getAllLeisureInformation();

        for (int i=0; i < response.body.items.size(); i++) {
            LeisureItem item = new LeisureItem();
            item = response.body.items.get(i);

            if (item == null || "".equals(item.mapx) || "".equals(item.title) || item.mapx == null
                    || item.mapy == null || "null".equals(item.mapx) || "null".equals(item.mapy)) {
                continue;
            }

            leisureList.add(item);

            LightLeisure lightItem = new LightLeisure();
            lightItem.title = item.title;
            lightItem.mapx = item.mapx;
            lightItem.mapy = item.mapy;
            lightLeisureList.add(lightItem);
        }
    }

    @Override
    public List<LeisureItem> getLeisureList() {
        if (leisureList == null) {
            setLeisureList();
        }

        return leisureList;
    }

    @Override
    public List<LightLeisure> getLightLeisureList() {
        if (lightLeisureList == null) {
            setLeisureList();
        }

        return lightLeisureList;
    }

    @Override
    public LeisureResponse getLeisureInformationByContentId(ContentTypeIds contentTypeId) {
        return null;
    }

    @Override
    public LeisureItem getLeisureByName(@NotNull String name) {
        if (leisureList == null) {
            setLeisureList();
        }

        for (LeisureItem item : leisureList) {
            if (name.equals(item.title)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<LightLeisure> getLightTerrainList() {
        if (lightLeisureList == null) {
            setLeisureList();
        }

        List<LightLeisure> lightList = new ArrayList<>();

        for (LeisureItem item : leisureList) {
            if (item.contenttypeid == 12) {
                LightLeisure lightItem = new LightLeisure();
                lightItem.title = item.title;
                lightItem.mapx = item.mapx;
                lightItem.mapy = item.mapy;

                lightList.add(lightItem);
            }
        }

        return lightList;
    }
}
