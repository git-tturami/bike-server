package com.gitturami.bikeserver.infra.cafe_places.impl;

import com.gitturami.bikeserver.infra.cafe_places.repository.CafeList;
import com.gitturami.bikeserver.infra.cafe_places.repository.CafeRepo;
import com.gitturami.bikeserver.infra.cafe_places.repository.CafeResponse;
import com.gitturami.bikeserver.infra.cafe_places.repository.LightCafe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PowerMockIgnore("javax.net.ssl.*")
public class CafePlacesApiImplTest {

    @Autowired
    private CafePlacesApiImpl cafePlacesApiImpl;

    @Test
    public void testGetCafeList(){
        CafeList response = cafePlacesApiImpl.getCafeList("37.505070,126.956967");
        assertNotEquals(null, response);
        System.out.println(response);
        //System.out.println(response);
    }

    @Test
    public void testGetAllPageCafeList(){
        List<CafeRepo> response = cafePlacesApiImpl.getAllPageCafeList("37.505070,126.956967");

        System.out.println(response);
        assertEquals(38, response.size());
        //System.out.println(response);
    }

    @Test
    public void testLightCafeList(){
        List<LightCafe> response = cafePlacesApiImpl.getAllLightCafeList("37.505070,126.956967");
        System.out.println(response);
        assertEquals(38, response.size());
        //System.out.println(response);
    }
}
