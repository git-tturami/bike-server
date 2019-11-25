package com.gitturami.bikeserver.infra.leisure.repository;

public class LightLeisure {
    public String title;
    public String mapx;
    public String mapy;
    public int index;

    @Override
    public String toString() {
        return String.format(
                "id = %d\n" +
                        "title = %s\n" +
                        "mapx = %s\n" +
                        "mapy = %s\n" ,
                index, title, mapx, mapy
        );
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> c37d79bbd9fd3a184fd261657436071050d397d8
