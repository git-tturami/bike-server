package com.gitturami.bikeserver.infra.restaurant.repository;

import com.gitturami.bikeserver.common.repository.Item;
import com.google.gson.Gson;

public class RestaurantRepoLight implements Item {
    public String UPSO_SNO;
    public String UPSO_NM;
    public String Y_DNTS;
    public String X_CNTS;

    @Override
    public String toString() {
        return String.format(
                "restaurant number : %s\n" +
                        "restaurant name : %s\n" +
                        "latitude : %s\n" +
                        "longitude : %s\n" ,
                UPSO_SNO, UPSO_NM, Y_DNTS, X_CNTS
        );
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    @Override
    public String getLatitude() { return Y_DNTS; }

    @Override
    public String getLongitude() {
        return X_CNTS;
    }
}
