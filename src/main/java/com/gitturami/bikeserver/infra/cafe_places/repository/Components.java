package com.gitturami.bikeserver.infra.cafe_places.repository;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Components implements Serializable {
    @SerializedName("long_name")
    @Expose
    public String long_name;
    @SerializedName("short_name")
    @Expose
    public String short_name;
    @SerializedName("types")
    @Expose
    public List<String> types = new ArrayList<String>();
}
