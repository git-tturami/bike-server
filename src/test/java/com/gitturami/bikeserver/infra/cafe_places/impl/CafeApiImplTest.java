package com.gitturami.bikeserver.infra.cafe_places.impl;

import com.gitturami.bikeserver.infra.cafe_places.repository.CafeResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PowerMockIgnore("javax.net.ssl.*")
public class CafeApiImplTest {

    @Autowired
    private CafeApiImpl cafeApiImpl;

    @Test
    public void testGetCafeList(){
        CafeResponse response = cafeApiImpl.getCafeList("37.505070,126.956967");
        System.out.println(response);
    }
}
