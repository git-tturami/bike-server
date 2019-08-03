package com.gitturami.bikeserver.infra.leisure.impl;

import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.LeisureApi;
import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;
import com.gitturami.bikeserver.infra.leisure.retrofit.LeisureRetrofit;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jaxb.JaxbConverterFactory;

import java.io.IOException;

public class LeisureApiImpl implements LeisureApi {
    private static final String TAG = "LeisureApiImpl";
    private String serviceKey = "7BU6hvKaLizImcLOotFguCrmNH5l/ixLxWZzpCT4n2ceil5n72Y04LoPnBLC7prrNXjawXY+ZzIO3Smg2OQl5w==";
    private Retrofit retrofit;
    private LeisureRetrofit leisureRetrofit;

    public LeisureApiImpl() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.visitkorea.or.kr/openapi/service/rest/KorService/")
                .addConverterFactory(JaxbConverterFactory.create())
                .build();
        leisureRetrofit = retrofit.create(LeisureRetrofit.class);
    }

    @Override
    public LeisureResponse getAllLeisureInformation() {
        return callRetrofit(
                leisureRetrofit.leisureList(
                        serviceKey, "", 1, "", "", "", "", "Y",
                "ETC", "TourAPI3.0_Guide", "A", 10000, 1)
        );
    }


    @Override
    public LeisureResponse getLeisureInformationByContentId(ContentTypeIds contentTypeId) {
        return callRetrofit(
                leisureRetrofit.leisureList(
                serviceKey, contentTypeId.getContentTypeId(), 1, "", "", "", "","Y",
                "ETC", "TourAPI3.0_Guide","A", 10000, 1)
        );
    }

    private LeisureResponse callRetrofit(Call<LeisureResponse> call) {
        try {
            Response<LeisureResponse> response = call.execute();
            LeisureResponse body = response.body();
            return body;
        } catch (IOException e) {
            ApiLogger.i(TAG, e.getMessage());
        }
        return null;
    }
}
