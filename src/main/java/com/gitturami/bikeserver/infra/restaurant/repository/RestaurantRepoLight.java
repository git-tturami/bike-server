package com.gitturami.bikeserver.infra.restaurant.repository;

import com.google.gson.Gson;

public class RestaurantRepoLight {
    public String UPSO_SNO;
    public String UPSO_NM;
    public double Y_DNTS;
    public double X_CNTS;
    public int index;

    @Override
    public String toString() {
        return String.format(
                "restaurant index : %d\n" +
                "restaurant number : %s\n" +
                        "restaurant name : %s\n" +
                        "latitude : %f\n" +
                        "longitude : %f\n" ,
                index, UPSO_SNO, UPSO_NM, Y_DNTS, X_CNTS
        );
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
