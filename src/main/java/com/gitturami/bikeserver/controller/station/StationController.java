package com.gitturami.bikeserver.controller.station;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.controller.station.exception.StationNotFoundException;
import com.gitturami.bikeserver.infra.bike.BikeStationApi;
import com.gitturami.bikeserver.infra.bike.impl.BikeStationApiImpl;
import com.gitturami.bikeserver.infra.bike.impl.MockStationApiImpl;
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
    @Autowired
    private MockStationApiImpl mockStationApi;

    @GetMapping("/id")
    public BikeStationRepo getStationInfoById(@RequestParam int id) {
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
    public List<BikeStationRepo> getStationListByEnableBike() {
        return bikeStationApi.getStationListByEnableBike();
    }

    @GetMapping("/close")
    public List<BikeStationRepoLight> getStationListByDistance(@RequestParam float lat, @RequestParam float lon) {
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

    @GetMapping("/mock/summaries")
    public List<BikeStationRepoLight> getLightMockList() {
        return mockStationApi.getMockLightStationList();
    }

    @GetMapping("/mock/index")
    public BikeStationRepo getMockStationByIndex(@RequestParam int index) {
        return mockStationApi.getStationByIndex(index);
    }

    @GetMapping("/mock/id")
    public BikeStationRepo getMockStationById(@RequestParam String id) {
        return mockStationApi.getStationById(id);
    }


}
