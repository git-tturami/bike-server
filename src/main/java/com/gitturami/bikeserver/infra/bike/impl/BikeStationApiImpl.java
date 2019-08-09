package com.gitturami.bikeserver.infra.bike.impl;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.infra.bike.BikeStationApi;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepo;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;
import com.gitturami.bikeserver.infra.bike.retrofit.BikeRetrofit;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Service
public class BikeStationApiImpl implements BikeStationApi {

    private static final String TAG = "BikeStationApiImpl";
    @Autowired
    private RetrofitConfig retrofitConfig;

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

    private List<BikeStationRepo> requestAllStationList() {
        return getStationList(1, 1000).rentBikeStatus.row;
    }

    private BikeStationResponse requestAndSortStationList(Comparator<BikeStationRepo> comparator) {
        BikeStationResponse bikeStationResponse = getStationList(1, 1000);
        bikeStationResponse.rentBikeStatus.row.sort(comparator);
        return bikeStationResponse;
    }

    @Override
    public String getEnableBike(String stationId) {
        // TODO : implement it!
        return null;
    }

    @Override
    public String getTotalBike() {
        return null;
    }

    //minji
    @Override
    public String getStationInfoById (String stationId) {
        List<BikeStationRepo> totalBikeStationList = requestAllStationList();

        for (BikeStationRepo bikeStationRepo : totalBikeStationList) {
            if (bikeStationRepo.stationId.equals(stationId)) {
                return bikeStationRepo.toJson();
            }
        }
        return null;
    }

    @Override
    public String getStationInfoByTownName(String townName) {
        List<BikeStationRepo> totalBikeStationList = requestAllStationList();

        for (BikeStationRepo bikeStationRepo : totalBikeStationList) {
            if (bikeStationRepo.stationName.contains(townName)) {
                return bikeStationRepo.toJson();
            }
        }
        return null;
    }

    private BikeStationResponse sortingStationListByEnableBike() {
        return requestAndSortStationList((o1, o2) -> o2.parkingBikeTotCnt - o1.parkingBikeTotCnt);
    }

    @Override
    public String getStationListByEnableBike() {
        BikeStationResponse bikeStationResponse = sortingStationListByEnableBike();

        return bikeStationResponse.toJson();
    }

    @Override
    public String getStationListByDistance(float lat, float lon) {
        BikeStationResponse bikeStationResponse = sortingStationListByDistance(lat, lon);
        return bikeStationResponse.toJson();
    }

    private BikeStationResponse sortingStationListByDistance(float lat, float lon) {
        return requestAndSortStationList((o1, o2) -> {
            double distanceFromA = Math.pow((double)(o1.stationLatitude - lat), 2.0)
                    + Math.pow((double)(o1.stationLongitude - lon), 2.0);
            double distanceFromB = Math.pow((double)(o2.stationLatitude - lat), 2.0)
                    + Math.pow((double)(o2.stationLongitude - lon), 2.0);
            return Double.compare(distanceFromA, distanceFromB);
        });
    }

    @Override
    public BikeStationResponse getStationList(int startPage, int endPage) {
        Call<BikeStationResponse> call = retrofitConfig.getBikeRetrofit().listStation(startPage, endPage);
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
