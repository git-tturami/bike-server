package com.gitturami.bikeserver.infra.cafe_places.repository;


import com.gitturami.bikeserver.common.repository.Item;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CafeRepo implements Item, Serializable {
    @SerializedName("geometry")
    @Expose
    public Geometry geometry = new Geometry();
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("photos")
    @Expose
    public List<Photo> photos= new ArrayList<Photo>();
    @SerializedName("place_id")
    @Expose
    public String place_id;
    @SerializedName("plus_code")
    @Expose
    public Plus_code plus_code = new Plus_code();
    @SerializedName("price_level")
    @Expose
    public int price_level;
    @SerializedName("rating")
    @Expose
    public float rating;
    @SerializedName("reference")
    @Expose
    public String reference;
    @SerializedName("scope")
    @Expose
    public String scope;
    @SerializedName("types")
    @Expose
    public List<String> types = new ArrayList<String>();
    @SerializedName("user_ratings_total")
    @Expose
    public float user_ratings_total;
    @SerializedName("vicinity")
    @Expose
    public String vicinity;

    @Override
    public String toString() {
        return String.format(
                "geometry : %s\n" +
                        "icon : %s\n" +
                        "id : %s\n" +
                        "name: %s\n" +
                        "photos : %s\n" +
                        "place_id : %s\n" +
                        "plus_code : %s\n" +
                        "price_level : %d\n" +
                        "rating : %f\n" +
                        "reference : %s\n" +
                        "scope : %s\n" +
                        "types : %s\n" +
                        "user_ratings_total : %f\n" +
                        "vicinity : %s\n",
                geometry, icon, id, name, photos, place_id, plus_code, price_level, rating,reference, scope, types,user_ratings_total,vicinity);
    }

    @Override
    public String getLatitude() {
        return null;
    }

    @Override
    public String getLongitude() {
        return null;
    }
}
