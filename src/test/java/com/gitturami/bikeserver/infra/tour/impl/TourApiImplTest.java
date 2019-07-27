package com.gitturami.bikeserver.infra.tour.impl;

import com.gitturami.bikeserver.infra.tour.TourApi;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TourApiImplTest {
    private TourApi api;

    @Before
    public void setUp() {
        api = new TourApiImpl();
    }

    @Test
    public void exampleTest() {
        System.out.println("TODO");
    }
}
