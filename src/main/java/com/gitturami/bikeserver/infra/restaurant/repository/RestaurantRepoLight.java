package com.gitturami.bikeserver.infra.restaurant.repository;

import com.google.gson.Gson;

public class RestaurantRepoLight {
    public int UPSO_SNO;
    public String UPSO_NM;
    public double Y_DNTS;
    public double X_CNTS;

    @Override
    public String toString() {
        return String.format(
                "restaurant number : %d\n" +
                        "restaurant name : %s\n" +
                        "latitude : %f\n" +
                        "longitude : %f\n" ,
                UPSO_SNO, UPSO_NM, Y_DNTS, X_CNTS
        );
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
