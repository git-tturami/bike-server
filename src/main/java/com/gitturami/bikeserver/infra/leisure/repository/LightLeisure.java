package com.gitturami.bikeserver.infra.leisure.repository;

public class LightLeisure {
    public String title;
    public String mapx;
    public String mapy;

    @Override
    public String toString() {
        return String.format(
                "title = %s\n" +
                        "mapx = %s\n" +
                        "mapy = %s\n" ,
                title, mapx, mapy
        );
    }
}