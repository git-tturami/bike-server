package com.gitturami.bikeserver.controller.station;

import com.gitturami.bikeserver.controller.station.exception.StationNotFoundException;
import com.gitturami.bikeserver.infra.bike.BikeStationApi;
import com.gitturami.bikeserver.infra.bike.impl.BikeStationApiImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class StationController {
    private BikeStationApi bikeStationApi = new BikeStationApiImpl();

    @RequestMapping(value= "/stations", params= "id")
    @ResponseStatus(value= HttpStatus.OK)
    public String getStationInfoById(@RequestParam String id) {
        String result = bikeStationApi.getStationInfoById(id);

        if (result == null) {
            throw new StationNotFoundException();
        }
        return result;
    }

    @RequestMapping(value= "/stations", params= "name")
    @ResponseStatus(value= HttpStatus.OK)
    public String getStationInfoByTownName(@RequestParam String name) {
        String result = bikeStationApi.getStationInfoByTownName(name);

        if (result == null) {
            throw new StationNotFoundException();
        }
        return result;
    }

    @RequestMapping(value= "/stations/enable", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public String getStationListByEnableBike() {
        return bikeStationApi.getStationListByEnableBike();
    }
}
