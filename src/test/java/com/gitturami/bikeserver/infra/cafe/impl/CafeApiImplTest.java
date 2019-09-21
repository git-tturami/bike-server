package com.gitturami.bikeserver.infra.cafe.impl;

import com.gitturami.bikeserver.infra.cafe.repository.CafeRepo;
import com.gitturami.bikeserver.infra.cafe.repository.CafeResponse;
import com.gitturami.bikeserver.infra.cafe.repository.LightCafe;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PowerMockIgnore("javax.net.ssl.*")
public class CafeApiImplTest {

    @Autowired
    private CafeApiImpl api;

    @Test
    public void testGetCafeList() {
        // execute
        CafeResponse response = api.getCafeList(1, 1);

        // verify
        System.out.println(response);
        assertEquals("INFO-000", response.coffeeShopInfo.RESULT.CODE);
        assertEquals(1, response.coffeeShopInfo.row.size());
    }

    @Test
    public void testGetAllCafeList() {
        // execute
        CafeResponse response = api.getAllCafeList();

        // verify
        if (response.coffeeShopInfo.row.size() < 1000) {
            fail();
        }
    }

    @Test
    public void testGetAllLightCafeList() {
        List<LightCafe> response = api.getAllLightCafeList();

        System.out.println(response);
    }

    @Test
    public void testCafeByName() {
        CafeRepo repo = api.getCafeByName("흙");
        System.out.println(repo);
    }
}
