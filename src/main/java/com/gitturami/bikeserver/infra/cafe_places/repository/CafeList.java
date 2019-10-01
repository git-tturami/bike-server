package com.gitturami.bikeserver.infra.cafe_places.repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CafeList implements Serializable {
    @SerializedName("html_attributions")
    @Expose
    public List<Object> html_attributions = new ArrayList<Object>();
    @SerializedName("next_page_token")
    @Expose
    public String next_page_token;
    @SerializedName("results")
    @Expose
    public List<CafeRepo> results = new ArrayList<CafeRepo>();
    @SerializedName("status")
    @Expose
    public String status;


    @Override
    public String toString() {
        return String.format(
                "html_attributions : %s\n" +
                "next_page_token : %s\n" +
                "results : %s\n\n" +
                "statuts : %s", html_attributions, next_page_token ,results, status);
    }

}
