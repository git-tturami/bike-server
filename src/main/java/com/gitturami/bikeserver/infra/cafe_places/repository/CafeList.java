package com.gitturami.bikeserver.infra.cafe_places.repository;

import java.util.List;

public class CafeList {
    public int list_total_count;
    public List<String> html_attributions;
    public Result result;
    public String STATUS;
    public String next_page_token;
    public class Result{
        public List<CafeRepo> row;
        public List<Components> address_components;
    }


}
