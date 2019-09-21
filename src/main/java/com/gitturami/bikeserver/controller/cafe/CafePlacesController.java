package com.gitturami.bikeserver.controller.cafe;

import com.gitturami.bikeserver.infra.cafe_places.repository.CafeRepo;
import com.gitturami.bikeserver.infra.cafe_places.repository.LightCafe;
import com.gitturami.bikeserver.infra.cafe_places.CafePlacesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Query;

import java.util.List;

@RestController
@RequestMapping("/cafeplaces")
public class CafePlacesController {

    @Autowired
    private CafePlacesApi api;

    @GetMapping("/summaries")
    public List<LightCafe> getAllLightCafes(@RequestParam("location") String location) {
        return api.getAllLightCafeList(location);
    }

}

