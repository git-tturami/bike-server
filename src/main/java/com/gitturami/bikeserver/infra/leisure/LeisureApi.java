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

    // getLeisureInformationByContentId() returns leisure list by content id.
    List<LeisureItem> getLeisureListByContentId(ContentTypeIds contentTypeId);

    // getLeisureInformationByContentId() returns information of leisure by name.
    LeisureItem getLeisureByName(String name);

    // getLightTerrainList() returns leisure list by sigungucode.
    List<LightLeisure> getLightTerrainList(int townCode);

    List<LightLeisure> getLightItems(ContentTypeIds id);

    LeisureItem getLeisureByIndex(int index);
}
