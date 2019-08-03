package com.gitturami.bikeserver.infra.leisure.impl;

import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;
import com.gitturami.bikeserver.infra.leisure.repository.body.item.LeisureItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"javax.net.ssl.*",
        "com.sun.org.apache.xerces.*",
        "javax.xml.*",
        "org.xml.*",
        "javax.management.*"})
public class LeisureApiImplTest {
    private LeisureApiImpl leisureApiImpl;

    @Before
    public void setUp() {
        leisureApiImpl = new LeisureApiImpl();
    }

    @Test
    public void testGetAllLeisureInformation() {
        LeisureResponse response = leisureApiImpl.getAllLeisureInformation();
        assertEquals(2859, response.body.items.size());
    }

    @Test
    public void testGetLeisureInformationByContentId() {
        LeisureResponse response = leisureApiImpl.getLeisureInformationByContentId(ContentTypeIds.PARK);
        for (LeisureItem item : response.body.items) {
            assertEquals(12, item.contenttypeid);
        }
    }
}
