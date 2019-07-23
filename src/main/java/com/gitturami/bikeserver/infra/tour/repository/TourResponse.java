package com.gitturami.bikeserver.infra.tour.repository;

public class TourResponse {
    public TourList tourList;

    @Override
    public String toString(){
        return tourList.toString();
    }

}
