package com.gitturami.bikeserver.infra.cafe_places.repository;

public class Geometry {
    public Location location;
    public Viewport viewport;

    public class Location{
        public String lat;
        public String lng;
    }
    public class Viewport{
        public Location northeast;
        public Location southwest;
    }
}
