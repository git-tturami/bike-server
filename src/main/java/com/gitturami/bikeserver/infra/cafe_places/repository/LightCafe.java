package com.gitturami.bikeserver.infra.cafe_places.repository;

public class LightCafe {
    public String name;
    public String lat;
    public String lng;

    @Override
    public String toString() {
        return String.format(
                "name : %s\n" +
                        "lat : %s\n" +
                        "lng : %s\n",
                name, lat, lng);
    }
}
