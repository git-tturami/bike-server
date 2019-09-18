package com.gitturami.bikeserver.controller.leisure;

import com.gitturami.bikeserver.controller.leisure.exception.LeisureNotFoundException;
import com.gitturami.bikeserver.infra.leisure.LeisureApi;
import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.impl.LeisureApiImpl;
import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;
import com.gitturami.bikeserver.infra.leisure.repository.LightLeisure;
import com.gitturami.bikeserver.infra.leisure.repository.body.item.LeisureItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leisure")
public class LeisureController {

    @Autowired
    private LeisureApi leisureApi;

    @GetMapping("/list")
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

    @GetMapping("/summaries")
    public List<LightLeisure> getLightLeisureList() {
        return leisureApi.getLightLeisureList();
    }

    @GetMapping("/terrain/summaries")
    public List<LightLeisure> getLightTerrainList() {
        return leisureApi.getLightTerrainList();
    }

    @GetMapping("/name")
    public LeisureItem getLeisureByName(@RequestParam String name) {
        return leisureApi.getLeisureByName(name);
    }
}