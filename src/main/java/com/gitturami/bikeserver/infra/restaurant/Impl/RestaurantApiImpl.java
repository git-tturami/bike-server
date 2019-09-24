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
    List<RestaurantRepo> restaurantList;
    List<RestaurantRepoLight> lightRestaurantList;

    @Autowired
    private RetrofitConfig retrofitConfig;

    @Override
    public List<RestaurantRepo> getAllRestaurantList() {
        if (restaurantList == null) {
            setRestaurantList();
        }

        return restaurantList;
    }

    public void setRestaurantList() {
        restaurantList = new ArrayList<>();
        lightRestaurantList = new ArrayList<>();

        for (int i = 1 ;; i += 1000) {
            restaurantList.addAll(getRestaurantList(i, i + 999).CrtfcUpsoInfo.row);

            if (restaurantList.size() % 1000 != 0) {
                break;
            }
        }

        for (int i=0; i<restaurantList.size(); i++) {
            restaurantList.get(i).index = i + 1;
        }

        for(int i=0; i<restaurantList.size(); i++) {
            RestaurantRepoLight repo = new RestaurantRepoLight();
            repo.index = restaurantList.get(i).index;
            repo.UPSO_NM = restaurantList.get(i).UPSO_NM;
            repo.UPSO_SNO = restaurantList.get(i).UPSO_SNO;
            repo.X_CNTS = Double.parseDouble(restaurantList.get(i).X_CNTS);
            repo.Y_DNTS = Double.parseDouble(restaurantList.get(i).Y_DNTS);

            lightRestaurantList.add(repo);
        }
    }

    @Override
    public RestaurantResponse getRestaurantList(int startPage, int endPage) {
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
    public List<RestaurantRepoLight> getLightRestaurantList() {
        if (lightRestaurantList == null) {
            setRestaurantList();
        }

        return lightRestaurantList;
    }

    @Override
    public List<RestaurantRepo> getNearbyRestaurantList(float startLat, float startLon, float endLat, float endLon) {
        return sortingNearbyRestaurant(startLat, startLon, endLat, endLon);
    }

    private List<RestaurantRepo> sortingNearbyRestaurant(float startLat, float startLon,
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

    private List<RestaurantRepo> requestAndSortStationList(Comparator<RestaurantRepo> comparator) {
        List<RestaurantRepo> list = new ArrayList<>();

        if (restaurantList == null) {
            setRestaurantList();
        }

        list.addAll(restaurantList);
        list.sort(comparator);
        return list;
    }

    @Override
    public RestaurantRepo getRestaurantByName(String name) {
        if (restaurantList == null) {
            setRestaurantList();
        }

        for (RestaurantRepo repo : restaurantList) {
            if (name.equals(repo.UPSO_NM)) {
                return repo;
            }
        }
        return null;
    }

    @Override
    public RestaurantRepo getRestaurantById(int id) {
        if (restaurantList == null) {
            setRestaurantList();
        }

        for (RestaurantRepo repo : restaurantList) {
            if (repo.index == id) {
                return repo;
            }
        }
        return null;
    }
}
