package com.gitturami.bikeserver.controller;

import com.gitturami.bikeserver.controller.exception.StationNotFoundException;
import com.gitturami.bikeserver.infra.bike.BikeStationApi;
import com.gitturami.bikeserver.infra.bike.impl.BikeStationApiImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class StationController {
    private BikeStationApi bikeStationApi = new BikeStationApiImpl();

    @RequestMapping(value= "/stations", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public String getStationInfoById(@RequestParam String id) {
        String result = bikeStationApi.getStationInfoById(id);

        if (result == null) {
            throw new StationNotFoundException();
        }
        return result;
    }
}
