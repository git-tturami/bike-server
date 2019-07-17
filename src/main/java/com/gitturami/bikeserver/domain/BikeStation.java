package com.gitturami.bikeserver.domain;

public class BikeStation {
    private String gu;
    private String stationId;
    private int stationNum;
    private String stationName;
    private String stationAddr;
    private int nHolder;
    private float latitude;
    private float longitude;

    public String getGu() {
        return this.gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getStationId() {
        return this.stationId;
    }

    public void setStationId(String id) {
        this.stationId = id;
    }

    public int getStationNum() {
        return this.stationNum;
    }

    public void setStationNum(int num) {
        this.stationNum = num;
    }

    public String getStationName() {
        return this.stationName;
    }

    public void setStationName(String name) {
        this.stationName = name;
    }

    public String getStationAddr() {
        return this.stationAddr;
    }

    public void setStationAddr(String addr) {
        this.stationAddr = addr;
    }

    public void setHolder(int n) {
        this.nHolder = n;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
