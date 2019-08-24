package com.gitturami.bikeserver.infra.leisure.impl;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.LeisureApi;
import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import java.io.IOException;

@Service
public class LeisureApiImpl implements LeisureApi {
    private static final String TAG = "LeisureApiImpl";
    private String serviceKey = "7BU6hvKaLizImcLOotFguCrmNH5l/ixLxWZzpCT4n2ceil5n72Y04LoPnBLC7prrNXjawXY+ZzIO3Smg2OQl5w==";

    @Autowired
    private RetrofitConfig retrofitConfig;

    @Override
    public LeisureResponse getAllLeisureInformation() {
        return callRetrofit(
                retrofitConfig.getLeisureRetrofit().leisureList(
                        serviceKey, "", 1, "", "", "", "", "Y",
                "ETC", "TourAPI3.0_Guide", "A", 10000, 1)
        );
    }

    @Override
    public LeisureResponse getLeisureInformationByContentId(ContentTypeIds contentTypeId) {
        return callRetrofit(
                retrofitConfig.getLeisureRetrofit().leisureList(
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
