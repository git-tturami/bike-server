package com.gitturami.bikeserver.infra.cafe_places.repository;

import java.util.List;

public class CafeList {
    public List<String> html_attributions;
    public String next_page_token;
    public List<CafeRepo> results;
    public String status;


    @Override
    public String toString() {
        return String.format(
                "html_attributions : %s\n" +
                "next_page_token : %s\n" +
                "results : %s\n\n" +
                "stauts : %s", html_attributions, next_page_token ,results, status);
    }

}
