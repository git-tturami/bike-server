package com.gitturami.bikeserver.controller.station;

import com.gitturami.bikeserver.config.RetrofitConfig;
import com.gitturami.bikeserver.controller.station.exception.StationNotFoundException;
import com.gitturami.bikeserver.infra.bike.BikeStationApi;
import com.gitturami.bikeserver.infra.bike.impl.BikeStationApiImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/stations")
public class StationController {
    @Autowired
    private RetrofitConfig config;
    @Autowired
    private BikeStationApi bikeStationApi;

    @GetMapping("/id")
    public String getStationInfoById(@RequestParam String id) {
        String result = bikeStationApi.getStationInfoById(id);

        if (result == null) {
            throw new StationNotFoundException();
        }
        return result;
    }

    @GetMapping("/name")
    public String getStationInfoByTownName(@RequestParam String name) {
        String result = bikeStationApi.getStationInfoByTownName(name);

        if (result == null) {
            throw new StationNotFoundException();
        }
        return result;
    }

    @GetMapping("/enable")
    public String getStationListByEnableBike() {
        return bikeStationApi.getStationListByEnableBike();
    }

    @GetMapping("/close")
    public String getStationListByDistance(@RequestParam float lat, @RequestParam float lon) {
        return bikeStationApi.getStationListByDistance(lat, lon);
    }
}
