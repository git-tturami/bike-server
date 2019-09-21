package com.gitturami.bikeserver.infra.restaurant.Impl;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.infra.logger.ApiLogger;
import com.gitturami.bikeserver.infra.restaurant.RestaurantApi;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepo;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepoLight;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class RestaurantApiImpl implements RestaurantApi {

    private static final String TAG = "RestaurantApiImpl";

    @Autowired
    private RetrofitConfig retrofitConfig;

    @Override
    public RestaurantResponse getAllRestaurantList() {
        return getRestaurantList(1, 1000);
    }

    @Override
    public RestaurantResponse getRestaurantList(int startPage, int endPage) {
        System.out.println("get()");
        Call<RestaurantResponse> call = retrofitConfig.getRestaurantRetrofit().restaurantList(startPage, endPage);
        try {
            Response<RestaurantResponse> response = call.execute();
            RestaurantResponse body = response.body();
            return body;
        } catch (IOException e) {
            ApiLogger.i(TAG, e.getMessage());
        }
        return null;
    }

    @Override
    public List<RestaurantRepoLight> getLightRestaurantList(int startPage, int endPage) {
        RestaurantResponse restaurantResponse = getRestaurantList(startPage, endPage);

        if (restaurantResponse == null) {
            return null;
        }

        List<RestaurantRepoLight> body = new ArrayList<>();

        for(int i = 0; i < restaurantResponse.CrtfcUpsoInfo.row.size(); i++) {
            RestaurantRepoLight restaurantRepoLight = new RestaurantRepoLight();

            restaurantRepoLight.UPSO_SNO = restaurantResponse.CrtfcUpsoInfo.row.get(i).UPSO_SNO;
            restaurantRepoLight.UPSO_NM = restaurantResponse.CrtfcUpsoInfo.row.get(i).UPSO_NM;
            restaurantRepoLight.Y_DNTS = restaurantResponse.CrtfcUpsoInfo.row.get(i).Y_DNTS;
            restaurantRepoLight.X_CNTS = restaurantResponse.CrtfcUpsoInfo.row.get(i).X_CNTS;

            body.add(restaurantRepoLight);
        }

        return body;
    }

    @Override
    public List<RestaurantRepo> getNearbyRestaurantList(float startLat, float startLon,
                                                  float endLat, float endLon) {
        RestaurantResponse restaurantResponse = sortingNearbyRestaurant(startLat, startLon, endLat, endLon);
        List<RestaurantRepo> retList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            retList.add(restaurantResponse.CrtfcUpsoInfo.row.get(i));
        }

        return retList;
    }

    private RestaurantResponse sortingNearbyRestaurant(float startLat, float startLon,
                                                       float endLat, float endLon) {
        return requestAndSortStationList((o1, o2) -> {
            double distanceFromA = Math.pow((Double.parseDouble(o1.Y_DNTS) - (double)startLat), 2.0)
                    + Math.pow((Double.parseDouble(o1.X_CNTS) - (double)startLon), 2.0);
            double tempA = Math.pow((Double.parseDouble(o1.Y_DNTS) - (double)endLat), 2.0)
                    + Math.pow((Double.parseDouble(o1.X_CNTS) - (double)endLon), 2.0);

            distanceFromA = distanceFromA > tempA ? tempA : distanceFromA;

            double distanceFromB = Math.pow((Double.parseDouble(o2.Y_DNTS) - (double)startLat), 2.0)
                    + Math.pow((Double.parseDouble(o2.X_CNTS) - (double)startLon), 2.0);
            double tempB = Math.pow((Double.parseDouble(o2.Y_DNTS) - (double)endLat), 2.0)
                    + Math.pow((Double.parseDouble(o2.X_CNTS) - (double)endLon), 2.0);

            distanceFromB = distanceFromB > tempB ? tempB : distanceFromB;

            return Double.compare(distanceFromA, distanceFromB);
        });
    }

    private RestaurantResponse requestAndSortStationList(Comparator<RestaurantRepo> comparator) {
        RestaurantResponse restaurantResponse = getRestaurantList(1, 1000);
        restaurantResponse.CrtfcUpsoInfo.row.sort(comparator);
        return restaurantResponse;
    }

    @Override
    public RestaurantRepo getRestaurantByName(String name) {
        RestaurantResponse response = getAllRestaurantList();
        for (RestaurantRepo repo : response.CrtfcUpsoInfo.row) {
            if (name.equals(repo.UPSO_NM)) {
                return repo;
            }
        }
        return null;
    }
}
