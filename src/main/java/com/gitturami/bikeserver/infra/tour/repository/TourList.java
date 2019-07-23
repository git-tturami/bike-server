package com.gitturami.bikeserver.infra.tour.repository;

import java.util.List;

public class TourList {
    public int list_total_count;
    public List<String> field;
    public List<TourRepo> row;


    @Override
    public String toString(){
        return String.format("Fields : %s\n"+
                "List total count : %d\n\n" +
                "row : %s",
                field, list_total_count, row
        );
    }
}

