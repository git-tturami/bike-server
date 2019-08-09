package com.gitturami.bikeserver.controller.leisure;

import com.gitturami.bikeserver.controller.leisure.exception.LeisureNotFoundException;
import com.gitturami.bikeserver.infra.leisure.LeisureApi;
import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.impl.LeisureApiImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leisure")
public class LeisureController {
    private final LeisureApi leisureApi;

    public LeisureController() {
        leisureApi = new LeisureApiImpl();
    }

    public LeisureController(LeisureApi api) {
        leisureApi = api;
    }

    @GetMapping("")
    public String getLeisureList() {
        return leisureApi.getAllLeisureInformation().toString();
    }

    @GetMapping("/parks")
    public String getParkList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.PARK).toString();
    }

    @GetMapping("/cultures")
    public String getCultureList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.CULTURE).toString();
    }

    @GetMapping("/festivals")
    public String getFestivalList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.FESTIVAL).toString();
    }

    @GetMapping("/leports")
    public String getLeportList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.LEPORTS).toString();
    }

    @GetMapping("/courses")
    public String getCourseList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.COURSE).toString();
    }

    @GetMapping("/hotels")
    public String getHotelList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.HOTEL).toString();
    }

    @GetMapping("/shopping")
    public String getShoppingList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.SHOPPING).toString();
    }

    @GetMapping("/foods")
    public String getFoodList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.FOOD).toString();
    }
}