package com.gitturami.bikeserver.controller.leisure;

import com.gitturami.bikeserver.controller.leisure.exception.LeisureNotFoundException;
import com.gitturami.bikeserver.infra.leisure.LeisureApi;
import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.impl.LeisureApiImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeisureController {
    private LeisureApi leisureApi;

    public LeisureController() {
        leisureApi = new LeisureApiImpl();
    }

    public LeisureController(LeisureApi api) {
        leisureApi = api;
    }

    @RequestMapping(value="/leisure")
    @ResponseStatus(value= HttpStatus.OK)
    public String getLeisureList() {
        return leisureApi.getAllLeisureInformation().toString();
    }

    @RequestMapping(value="/leisure/parks")
    @ResponseStatus(value=HttpStatus.OK)
    public String getParkList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.PARK).toString();
    }

    @RequestMapping(value="/leisure/cultures")
    @ResponseStatus(value=HttpStatus.OK)
    public String getCultureList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.CULTURE).toString();
    }

    @RequestMapping(value="/leisure/festivals")
    @ResponseStatus(value=HttpStatus.OK)
    public String getFestivalList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.FESTIVAL).toString();
    }

    @RequestMapping(value="/leisure/leports")
    @ResponseStatus(value=HttpStatus.OK)
    public String getLeportList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.LEPORTS).toString();
    }

    @RequestMapping(value="/leisure/courses")
    @ResponseStatus(value=HttpStatus.OK)
    public String getCourseList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.COURSE).toString();
    }

    @RequestMapping(value="/leisure/hotels")
    @ResponseStatus(value=HttpStatus.OK)
    public String getHotelList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.HOTEL).toString();
    }

    @RequestMapping(value="/leisure/shopping")
    @ResponseStatus(value=HttpStatus.OK)
    public String getShoppingList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.SHOPPING).toString();
    }

    @RequestMapping(value="/leisure/foods")
    @ResponseStatus(value=HttpStatus.OK)
    public String getFoodList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.FOOD).toString();
    }
}