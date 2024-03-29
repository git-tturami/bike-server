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

import static org.junit.Assert.*;

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
    public void testGetLeisureListById() {
        List<LeisureItem> list = api.getLeisureListByContentId(ContentTypeIds.PARK);
        assertEquals(544, list.size());
    }

    @Test
    public void testGetLeisureByName_success() {
        LeisureItem item = api.getLeisureByName("동화면세점");
        if (item.contenttypeid != ContentTypeIds.SHOPPING.getContentTypeIdAsInteger()) {
            fail();
        }
    }

    @Test
    public void testGetLeisureByName_mustNull() {
        LeisureItem item = api.getLeisureByName("");
        assertNull(item);
    }

    @Test
    public void testLightTerrainList() {
        List<LightLeisure> lightList = new ArrayList<>();
        lightList.addAll(api.getLightTerrainList(27));

        if (lightList.size() >= 1) {
            fail();
        }
    }
}
