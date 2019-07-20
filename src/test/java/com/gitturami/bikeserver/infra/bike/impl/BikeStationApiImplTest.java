package com.gitturami.bikeserver.infra.bike.impl;

import com.gitturami.bikeserver.infra.bike.BikeStationApi;
import com.gitturami.bikeserver.infra.bike.repository.BikeStationResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BikeStationApiImplTest {

    private BikeStationApi api;
    @Before
    public void setUp() {
        api = new BikeStationApiImpl();
    }

    @Test
    public void testGetStationList() {
        // execute
        BikeStationResponse response = api.getStationList(1, 2);

        // verify
        System.out.println(response.toString());
        assertEquals(2, response.rentBikeStatus.row.size());
    }

    @Test
    public void testGetStationInfoById() {
        String result = api.getStationInfoById("ST-109898");
        System.out.println(result);
        assertNull(result);

        result = api.getStationInfoById("ST-10");
        if (!result.contains("서교동")) {
            fail();
        }
    }
}
