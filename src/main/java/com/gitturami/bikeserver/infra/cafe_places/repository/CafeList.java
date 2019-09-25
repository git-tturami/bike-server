package com.gitturami.bikeserver.infra.cafe_places.repository;

import java.util.List;

public class CafeList {
    public List<String> html_attributions;
    public String next_page_token;
    public Result results;
    public String status;
    public class Result{
        public List<CafeRepo> row;
        public List<Components> address_components;
    }


}
