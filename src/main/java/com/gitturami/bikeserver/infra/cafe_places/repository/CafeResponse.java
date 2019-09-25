package com.gitturami.bikeserver.infra.cafe_places.repository;

public class CafeResponse {
    public CafeList coffeeShopInfo;

    @Override
    public String toString() {
        return coffeeShopInfo.toString();
    }
}
