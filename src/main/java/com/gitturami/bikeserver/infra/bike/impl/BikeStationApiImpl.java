package com.gitturami.bikeserver.infra.bike.impl;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.infra.bike.BikeStationApi;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepo;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepoLight;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.*;

@Service
public class BikeStationApiImpl implements BikeStationApi {

    private static final String TAG = "BikeStationApiImpl";

    @Autowired
    private RetrofitConfig retrofitConfig;

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

    private List<BikeStationRepo> requestAllStationList() {
        List<BikeStationRepo> bikeStationList = getStationList(1, 999).rentBikeStatus.row;
        bikeStationList.addAll(getStationList(1000, 1900).rentBikeStatus.row);

        for (int i=0; i<bikeStationList.size(); i++) {
            bikeStationList.get(i).idx = i + 1;
        }

        return bikeStationList;
    }

    @Override
    public List<BikeStationRepoLight> getLightStationList(int startPage, int endPage) {
        BikeStationResponse bikeStationResponse = getStationList(startPage, endPage);

        if (bikeStationResponse == null) {
            return null;
        }

        List<BikeStationRepoLight> body = new ArrayList<>();

        for (int i = 0; i < bikeStationResponse.rentBikeStatus.row.size(); i++) {
            BikeStationRepoLight bikeStationRepoLight = new BikeStationRepoLight();
            bikeStationRepoLight.idx = i;
            bikeStationRepoLight.stationName = bikeStationResponse.rentBikeStatus.row.get(i).stationName;
            bikeStationRepoLight.stationId = bikeStationResponse.rentBikeStatus.row.get(i).stationId;
            bikeStationRepoLight.shared = bikeStationResponse.rentBikeStatus.row.get(i).shared;
            bikeStationRepoLight.stationLatitude = bikeStationResponse.rentBikeStatus.row.get(i).stationLatitude;
            bikeStationRepoLight.stationLongitude = bikeStationResponse.rentBikeStatus.row.get(i).stationLongitude;

            body.add(bikeStationRepoLight);
        }

        return body;
    }

    @Override
    public String getEnableBike(String stationId) {
        // TODO : implement it!
        return null;
    }

    @Override
    public BikeStationRepo getStationInfoById(int stationId) {
        List<BikeStationRepo> totalBikeStationList = requestAllStationList();
        return totalBikeStationList.get(stationId - 1);
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

    private List<BikeStationRepo> requestAndSortStationList(Comparator<BikeStationRepo> comparator) {
        List<BikeStationRepo> bikeStationList = requestAllStationList();
        bikeStationList.sort(comparator);
        return bikeStationList;
    }

    private List<BikeStationRepo> sortingStationListByEnableBike() {
        return requestAndSortStationList((o1, o2) -> o2.parkingBikeTotCnt - o1.parkingBikeTotCnt);
    }

    @Override
    public List<BikeStationRepo> getStationListByEnableBike() {
        List<BikeStationRepo> bikeStationList = sortingStationListByEnableBike();
        return bikeStationList;
    }

    @Override
    public List<BikeStationRepoLight> getStationListByDistance(float lat, float lon) {
        List<BikeStationRepo> bikeStationList = sortingStationListByDistance(lat, lon);
        List<BikeStationRepoLight> lightList = new ArrayList<>();

        for (int i = 0; i < bikeStationList.size(); i++) {
            BikeStationRepoLight bikeStationRepoLight = new BikeStationRepoLight();
            bikeStationRepoLight.idx = bikeStationList.get(i).idx;
            bikeStationRepoLight.stationName = bikeStationList.get(i).stationName;
            bikeStationRepoLight.stationId = bikeStationList.get(i).stationId;
            bikeStationRepoLight.shared = bikeStationList.get(i).shared;
            bikeStationRepoLight.stationLongitude = bikeStationList.get(i).stationLongitude;
            bikeStationRepoLight.stationLatitude = bikeStationList.get(i).stationLatitude;

            lightList.add(bikeStationRepoLight);
        }

        return lightList;
    }

    private List<BikeStationRepo> sortingStationListByDistance(float lat, float lon) {
        return requestAndSortStationList((o1, o2) -> {
            double distanceFromA = Math.pow((Double.parseDouble(o1.stationLatitude) - (double)lat), 2.0)
                    + Math.pow((Double.parseDouble(o1.stationLongitude) - (double)lon), 2.0);
            double distanceFromB = Math.pow((Double.parseDouble(o2.stationLatitude) - (double)lat), 2.0)
                    + Math.pow((Double.parseDouble(o2.stationLongitude) - (double)lon), 2.0);
            return Double.compare(distanceFromA, distanceFromB);
        });
    }
}
