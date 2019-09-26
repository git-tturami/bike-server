package com.gitturami.bikeserver.infra.cafe_places.repository;

public class CafeResponse {
    public CafeList cafeInfo;

    @Override
    public String toString() {
        return cafeInfo.toString();
    }
}
