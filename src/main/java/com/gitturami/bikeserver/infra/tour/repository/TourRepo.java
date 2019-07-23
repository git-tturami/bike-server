package com.gitturami.bikeserver.infra.tour.repository;

import com.google.gson.Gson;

public class TourRepo {
    public int contentId;
    public String firstImage;
    public int mlevel;
    public int areaCode;
    public int contentTypeId;
    public String title;
    public String cat1;
    public String addr1;
    public String cat3;
    public String addr2;
    public String cat2;
    public int bookTour;
    public String createdTime;
    public String modifiedTime;
    public int readCount;
    public float mapx;
    public float mapy;
    public String firstImage2;

    @Override
    public String toString(){
        return String.format(
          "contentId : %d\n"+
                  "firstimage : %s\n"+
                  "mlevel : %d\n"+
                  "areaCode : %d\n"+
                  "content Type id : %d\n"+
                  "title : %S\n"+
                  "cat1 : %s\n"+
                  "addr1 : %s\n"+
                  "cat3 : %s\n"+
                  "addr2 : %s\n"+
                  "cat2 : %s\n"+
                  "bookTour : %d\n"+
                  "created time : %s\n"+
                  "modified time : %s\n"+
                  "read count : %d\n"+
                  "mapx : %f\n"+
                  "mapy : %f\n"+
                  "firstimage2 : %s\n",
            contentId, firstImage, mlevel, areaCode, contentTypeId, title, cat1, addr1, cat3, addr2, cat2,
                bookTour, createdTime, modifiedTime, readCount, mapx, mapy, firstImage2
        );
    }

    public String toJson(){
        return new Gson().toJson(this);
    }

}
