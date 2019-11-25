package com.gitturami.bikeserver.infra.cafe_places.repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Geometry implements Serializable {
    @SerializedName("location")
    @Expose
    public Location location = new Location();
    @SerializedName("viewport")
    @Expose
    public Viewport viewport = new Viewport();

    public class Location implements Serializable{
        @SerializedName("lat")
        @Expose
        public String lat;
        @SerializedName("lng")
        @Expose
        public String lng;
    }
    public class Viewport implements Serializable{
        @SerializedName("northeast")
        @Expose
        public Location northeast= new Location();
        @SerializedName("southwest")
        @Expose
        public Location southwest= new Location();
    }
}
