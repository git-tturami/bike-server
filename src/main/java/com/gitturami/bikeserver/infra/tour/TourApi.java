package com.gitturami.bikeserver.infra.tour;

import com.gitturami.bikeserver.infra.tour.repository.TourRepo;
import com.gitturami.bikeserver.infra.tour.repository.TourResponse;

import java.util.List;

public interface TourApi {
    TourResponse getTourList(String keyword);
    TourRepo getTourListByName();
    TourRepo getTourListById();
}
