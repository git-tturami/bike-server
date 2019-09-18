package com.gitturami.bikeserver.controller.cafe;

import com.gitturami.bikeserver.infra.cafe.CafeApi;
import com.gitturami.bikeserver.infra.cafe.repository.CafeRepo;
import com.gitturami.bikeserver.infra.cafe.repository.LightCafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cafes")
public class CafeController {
    @Autowired
    private CafeApi api;

    @GetMapping("/summaries")
    public List<LightCafe> getAllCafeSummaries() {
        return api.getAllLightCafeList();
    }

    @GetMapping("/name")
    public CafeRepo getCafeByName(@RequestParam String name) {
        return api.getCafeByName(name);
    }
}
