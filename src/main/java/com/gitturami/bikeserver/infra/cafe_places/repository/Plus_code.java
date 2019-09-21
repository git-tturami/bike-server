package com.gitturami.bikeserver.infra.cafe_places.repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Plus_code implements Serializable {
    @SerializedName("compound_code")
    @Expose
    public String compound_code;
    @SerializedName("global_code")
    @Expose
    public String global_code;
}
