package com.gitturami.bikeserver.infra.leisure;

import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;
import com.gitturami.bikeserver.infra.leisure.repository.LightLeisure;
import com.gitturami.bikeserver.infra.leisure.repository.body.LeisureBody;
import com.gitturami.bikeserver.infra.leisure.repository.body.item.LeisureItem;

import java.util.List;

public interface LeisureApi {
    // getAllLeisureInformation() returns all information of leisure in seoul.
    LeisureResponse getAllLeisureInformation();

    // getLeisureList() returns full leisure list;
    List<LeisureItem> getLeisureList();

    // getLightLeisureList() returns summarized leisure list.
    List<LightLeisure> getLightLeisureList();

    // getLeisureInformationByContentId() returns informations of leisure by content id.
    LeisureResponse getLeisureInformationByContentId(ContentTypeIds contentTypeId);

    LeisureItem getLeisureByName(String name);

    List<LightLeisure> getLightTerrainList();
}
