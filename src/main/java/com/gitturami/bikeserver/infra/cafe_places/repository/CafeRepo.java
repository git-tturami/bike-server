package com.gitturami.bikeserver.infra.cafe_places.repository;


import com.gitturami.bikeserver.common.repository.Item;

import java.util.List;

public class CafeRepo implements Item {

    public Geometry geometry;
    public String icon;
    public String id;
    public String name;
    public List<Photo> photos;
    public String place_id;
    public Plus_code plus_code;
    public int price_level;
    public float rating;
    public String reference;
    public String scope;
    public List<String> types;
    public float user_ratings_total;
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
