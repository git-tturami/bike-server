package com.gitturami.bikeserver.infra.leisure.constants;

public enum ContentTypeIds {
    PARK("12"),
    CULTURE("14"),
    FESTIVAL("15"),
    COURSE("25"),
    LEPORTS("28"),
    HOTEL("32"),
    SHOPPING("38"),
    FOOD("39");

    private final String contentTypeId;

    public String getContentTypeId() {
        return contentTypeId;
    }

    ContentTypeIds(String contentTypeId) {
        this.contentTypeId = contentTypeId;
    }
}
