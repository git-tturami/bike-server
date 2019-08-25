package com.gitturami.bikeserver.infra.cafe;

import com.gitturami.bikeserver.infra.cafe.repository.CafeResponse;

public interface CafeApi {
    CafeResponse getCafeList(int startPage, int endPage);
    CafeResponse getAllCafeList();
}
