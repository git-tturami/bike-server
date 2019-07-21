package com.gitturami.bikeserver.infra.tour;

import com.gitturami.bikeserver.infra.tour.repository.TourRepo;

import java.util.List;

public interface TourApi {
    List<TourRepo> getTourList();
    TourRepo getTourListByName();
    TourRepo getTourListById();
}
