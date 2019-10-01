package com.gitturami.bikeserver.infra.cafe_places.repository;

public class CafeResponse {
    public CafeList cafeInfo = new CafeList();

    @Override
    public String toString() {
        return cafeInfo.toString();
    }
}
