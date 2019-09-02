package com.gitturami.bikeserver.infra.bike.impl;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.infra.bike.BikeStationApi;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepo;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Service
public class BikeStationApiImpl implements BikeStationApi {

    private static final String TAG = "BikeStationApiImpl";

    @Autowired
    private RetrofitConfig retrofitConfig;

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

    @Override
    public BikeStationRepo getStationInfoById (String stationId) {
        List<BikeStationRepo> totalBikeStationList = requestAllStationList();

        for (BikeStationRepo bikeStationRepo : totalBikeStationList) {
            if (bikeStationRepo.stationId.equals(stationId)) {
                return bikeStationRepo;
            }
        }
        return null;
    }

    @Override
    public BikeStationRepo getStationInfoByTownName(String townName) {
        List<BikeStationRepo> totalBikeStationList = requestAllStationList();

        for (BikeStationRepo bikeStationRepo : totalBikeStationList) {
            if (bikeStationRepo.stationName.contains(townName)) {
                return bikeStationRepo;
            }
        }
        return null;
    }

    private BikeStationResponse sortingStationListByEnableBike() {
        return requestAndSortStationList((o1, o2) -> o2.parkingBikeTotCnt - o1.parkingBikeTotCnt);
    }

    @Override
    public BikeStationResponse getStationListByEnableBike() {
        BikeStationResponse bikeStationResponse = sortingStationListByEnableBike();

        return bikeStationResponse;
    }

    @Override
    public BikeStationResponse getStationListByDistance(float lat, float lon) {
        BikeStationResponse bikeStationResponse = sortingStationListByDistance(lat, lon);
        return bikeStationResponse;
    }

    private BikeStationResponse sortingStationListByDistance(float lat, float lon) {
        return requestAndSortStationList((o1, o2) -> {
            double distanceFromA = Math.pow((Double.parseDouble(o1.stationLatitude) - (double)lat), 2.0)
                    + Math.pow((Double.parseDouble(o1.stationLongitude) - (double)lon), 2.0);
            double distanceFromB = Math.pow((Double.parseDouble(o2.stationLatitude) - (double)lat), 2.0)
                    + Math.pow((Double.parseDouble(o2.stationLongitude) - (double)lon), 2.0);
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

    @Override
    public String getStationInfo() {
        return null;
    }
}
