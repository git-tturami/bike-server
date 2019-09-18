package com.gitturami.bikeserver.infra.cafe;

import com.gitturami.bikeserver.infra.cafe.repository.CafeRepo;
import com.gitturami.bikeserver.infra.cafe.repository.CafeResponse;
import com.gitturami.bikeserver.infra.cafe.repository.LightCafe;

import java.util.List;

public interface CafeApi {
    CafeResponse getCafeList(int startPage, int endPage);
    CafeResponse getAllCafeList();
    List<LightCafe> getAllLightCafeList();
    CafeRepo getCafeByName(String name);
}
