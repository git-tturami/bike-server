package com.gitturami.bikeserver.infra.cafe_places.repository;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Photo implements Serializable {
    @SerializedName("height")
    @Expose
    public int height;
    @SerializedName("html_attributions")
    @Expose
    public List<String> html_attributions = new ArrayList<String>();
    @SerializedName("photo_reference")
    @Expose
    public String photo_reference;
    @SerializedName("width")
    @Expose
    public int width;
}
