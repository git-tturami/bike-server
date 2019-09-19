package com.gitturami.bikeserver.controller.station;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.controller.station.exception.StationNotFoundException;
import com.gitturami.bikeserver.infra.bike.BikeStationApi;
import com.gitturami.bikeserver.infra.bike.impl.BikeStationApiImpl;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepo;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationRepoLight;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {
    @Autowired
    private RetrofitConfig config;
    @Autowired
    private BikeStationApi bikeStationApi;

    @GetMapping("/id")
    public BikeStationRepo getStationInfoById(@RequestParam String id) {
        BikeStationRepo result = bikeStationApi.getStationInfoById(id);

        if (result == null) {
            throw new StationNotFoundException();
        }
        return result;
    }

    @GetMapping("/name")
    public BikeStationRepo getStationInfoByTownName(@RequestParam String name) {
        BikeStationRepo result = bikeStationApi.getStationInfoByTownName(name);

        if (result == null) {
            throw new StationNotFoundException();
        }
        return result;
    }

    @GetMapping("/enable")
    public BikeStationResponse getStationListByEnableBike() {
        return bikeStationApi.getStationListByEnableBike();
    }

    @GetMapping("/close")
    public BikeStationResponse getStationListByDistance(@RequestParam float lat, @RequestParam float lon) {
        return bikeStationApi.getStationListByDistance(lat, lon);
    }

    @GetMapping("/list")
    public List<BikeStationRepo> getAllStationList() {
        BikeStationResponse response =  bikeStationApi.getStationList(1, 1000);
        response.rentBikeStatus.row.addAll(
                bikeStationApi.getStationList(1001, 2000).rentBikeStatus.row
        );
        System.out.println(response.rentBikeStatus.row.size());
        return response.rentBikeStatus.row;
    }

    @GetMapping("/summaries")
    public List<BikeStationRepoLight> getLightStationList() {
        List<BikeStationRepoLight> lightList = new ArrayList<>();
        lightList = bikeStationApi.getLightStationList(1, 1000);
        lightList.addAll(
                bikeStationApi.getLightStationList(1001, 2000)
        );
        System.out.println(lightList.size());

        return lightList;
    }
}
