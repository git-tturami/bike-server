package com.gitturami.bikeserver.infra.cafe_places.impl;

import com.gitturami.bikeserver.infra.cafe_places.repository.CafeRepo;
import com.gitturami.bikeserver.infra.cafe_places.repository.CafeResponse;
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
        CafeResponse response = cafePlacesApiImpl.getCafeList("37.505070,126.956967");
        assertNotEquals(null, response);
        System.out.println(response);
        //System.out.println(response);
    }
}
