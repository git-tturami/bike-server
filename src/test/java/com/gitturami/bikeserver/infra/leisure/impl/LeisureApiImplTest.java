package com.gitturami.bikeserver.infra.leisure.impl;

import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;
import com.gitturami.bikeserver.infra.leisure.repository.body.item.LeisureItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PowerMockIgnore({"javax.net.ssl.*",
        "com.sun.org.apache.xerces.*",
        "javax.xml.*",
        "org.xml.*",
        "javax.management.*"})
public class LeisureApiImplTest {

    @Autowired
    private LeisureApiImpl leisureApiImpl;

    @Test
    public void testGetAllLeisureInformation() {
        LeisureResponse response = leisureApiImpl.getAllLeisureInformation();
        if (response.body.items.size() < 2000) {
            fail();
        }
    }

    @Test
    public void testGetLeisureInformationByContentId() {
        LeisureResponse response = leisureApiImpl.getLeisureInformationByContentId(ContentTypeIds.PARK);
        for (LeisureItem item : response.body.items) {
            assertEquals(12, item.contenttypeid);
        }
    }
}
