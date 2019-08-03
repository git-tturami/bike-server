package com.gitturami.bikeserver.infra.leisure;

import com.gitturami.bikeserver.infra.leisure.constants.ContentTypeIds;
import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;

public interface LeisureApi {
    // getAllLeisureInformation() returns all information of leisure in seoul.
    LeisureResponse getAllLeisureInformation();

    // getLeisureInformationByContentId() returns informations of leisure by content id.
    LeisureResponse getLeisureInformationByContentId(ContentTypeIds contentTypeId);
}
