package com.gitturami.bikeserver.controller.leisure;

import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.impl.LeisureApiImpl;
import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class LeisureControllerTest {
    private LeisureController controller;

    @Mock
    private LeisureApiImpl api;

    @Mock
    private LeisureResponse response;

    @Before
    public void setUp() {
        controller = new LeisureController(api);
        when(api.getAllLeisureInformation()).thenReturn(response);
        when(api.getLeisureInformationByContentId(any())).thenReturn(response);
        when(response.toString()).thenReturn("");
    }

    @Test
    public void testGetLeisureList() {
        controller.getLeisureList();
        verify(api).getAllLeisureInformation();
    }

    @Test
    public void testGetParkList() {
        controller.getParkList();
        verify(api).getLeisureInformationByContentId(eq(ContentTypeIds.PARK));
    }

    @Test
    public void testGetCultureList() {
        controller.getCultureList();
        verify(api).getLeisureInformationByContentId(eq(ContentTypeIds.CULTURE));
    }

    @Test
    public void testGetFestivalList() {
        controller.getFestivalList();
        verify(api).getLeisureInformationByContentId(eq(ContentTypeIds.FESTIVAL));
    }

    @Test
    public void testGetLeportList() {
        controller.getLeportList();
        verify(api).getLeisureInformationByContentId(eq(ContentTypeIds.LEPORTS));
    }

    @Test
    public void testGetCourseList() {
        controller.getCourseList();
        verify(api).getLeisureInformationByContentId(eq(ContentTypeIds.COURSE));
    }

    @Test
    public void testGetHotelList() {
        controller.getHotelList();
        verify(api).getLeisureInformationByContentId(eq(ContentTypeIds.HOTEL));
    }

    @Test
    public void testGetShoppingList() {
        controller.getShoppingList();
        verify(api).getLeisureInformationByContentId(eq(ContentTypeIds.SHOPPING));
    }

    @Test
    public void testGetFoodList() {
        controller.getFoodList();
        verify(api).getLeisureInformationByContentId(eq(ContentTypeIds.FOOD));
    }
}
