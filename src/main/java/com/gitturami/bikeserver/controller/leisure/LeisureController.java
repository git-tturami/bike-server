package com.gitturami.bikeserver.controller.leisure;

import com.gitturami.bikeserver.controller.leisure.exception.LeisureNotFoundException;
import com.gitturami.bikeserver.infra.leisure.LeisureApi;
import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.impl.LeisureApiImpl;
import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;
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
    public LeisureResponse getLeisureList() {
        return leisureApi.getAllLeisureInformation();
    }

    @GetMapping("/parks")
    public LeisureResponse getParkList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.PARK);
    }

    @GetMapping("/cultures")
    public LeisureResponse getCultureList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.CULTURE);
    }

    @GetMapping("/festivals")
    public LeisureResponse getFestivalList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.FESTIVAL);
    }

    @GetMapping("/leports")
    public LeisureResponse getLeportList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.LEPORTS);
    }

    @GetMapping("/courses")
    public LeisureResponse getCourseList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.COURSE);
    }

    @GetMapping("/hotels")
    public LeisureResponse getHotelList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.HOTEL);
    }

    @GetMapping("/shopping")
    public LeisureResponse getShoppingList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.SHOPPING);
    }

    @GetMapping("/foods")
    public LeisureResponse getFoodList() {
        return leisureApi.getLeisureInformationByContentId(ContentTypeIds.FOOD);
    }
}