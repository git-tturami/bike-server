package com.gitturami.bikeserver.infra.leisure.impl;

import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;
import com.gitturami.bikeserver.infra.leisure.repository.LightLeisure;
import com.gitturami.bikeserver.infra.leisure.repository.body.item.LeisureItem;
import com.gitturami.bikeserver.infra.restaurant.repository.RestaurantRepoLight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PowerMockIgnore({"javax.net.ssl.*",
        "com.sun.org.apache.xerces.*",
        "javax.xml.*",
        "org.xml.*",
        "javax.management.*"})
public class LeisureApiImplTest {

    @Autowired
    private LeisureApiImpl api;

    @Test
    public void testGetAllLeisureInformation() {
        LeisureResponse response = api.getAllLeisureInformation();
        if (response.body.items.size() < 2000) {
            fail();
        }
    }

    @Test
    public void testGetLeisureList() {
        List<LeisureItem> leisureList = api.getLeisureList();
        System.out.println(leisureList.size());
        System.out.println(leisureList);
    }

    @Test
    public void testGetLightRestaurantList() {
        List<LightLeisure> lightLeisureList = api.getLightLeisureList();
        System.out.println(lightLeisureList.size());
        System.out.println(lightLeisureList);
    }

    @Test
    public void testGetLeisureInformationByContentId() {
        // LeisureResponse response = leisureApiImpl.getLeisureInformationByContentId(ContentTypeIds.PARK);
        // for (LeisureItem item : response.body.items) {
        //     assertEquals(12, item.contenttypeid);
        // }
    }

    @Test
    public void testGetLeisurebyName() {
        System.out.println(api.getLeisureByName("동화면세점"));
    }

    @Test
    public void testLightTerrainList() {
        List<LightLeisure> lightList = new ArrayList<>();
        lightList.addAll(api.getLightTerrainList());

        System.out.println(lightList.size());
        System.out.println(lightList.get(1));
    }
}
