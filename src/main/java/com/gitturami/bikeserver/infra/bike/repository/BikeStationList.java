package com.gitturami.bikeserver.infra.bike.repository;

import java.util.List;

public class BikeStationList {
    public int list_total_count;
    public Result RESULT;
    public List<BikeStationRepo> row;

    public class Result {
        String CODE;
        String MESSAGE;
    }

    @Override
    public String toString() {
        return String.format("Result Code : %s\n" +
                "Result Message : %s\n" +
                "List total count : %d\n\n" +
                "row : %s", RESULT.CODE, RESULT.MESSAGE, list_total_count, row);
    }
}
