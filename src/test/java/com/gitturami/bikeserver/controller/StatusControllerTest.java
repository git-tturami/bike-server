package com.gitturami.bikeserver.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StatusControllerTest {
    private StatusController controller;
    @Before
    public void setUp() {
        controller = new StatusController();
    }

    @Test
    public void testIsRunning() {
        String result = controller.isRunning();
        assertEquals("StatusController is running.", result);
    }
}
