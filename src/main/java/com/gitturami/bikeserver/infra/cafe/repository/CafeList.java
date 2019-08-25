package com.gitturami.bikeserver.infra.cafe.repository;

import java.util.List;

public class CafeList {
    public int list_total_count;
    public Result RESULT;
    public List<CafeRepo> row;

    public class Result {
        public String CODE;
        public String MESSAGE;
    }

    @Override
    public String toString() {
        return String.format("Result Code : %s\n" +
                "Result Message : %s\n" +
                "List total count : %d\n\n" +
                "row : %s", RESULT.CODE, RESULT.MESSAGE, list_total_count, row);
    }
}
