package com.gitturami.bikeserver.infra.leisure.repository.body.item;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class LeisureItem {
    @XmlElement(name = "addr1")
    public String addr1;

    @XmlElement(name = "areacode")
    public int areacode;

    @XmlElement(name = "cat1")
    public String cat1;

    @XmlElement(name = "cat2")
    public String cat2;

    @XmlElement(name = "cat3")
    public String cat3;

    @XmlElement(name = "contentid")
    public int contentid;

    @XmlElement(name = "contenttypeid")
    public int contenttypeid;

    @XmlElement(name = "createdtime")
    public String createdtime;

    @XmlElement(name = "firstimage")
    public String firstimage;

    @XmlElement(name = "firstimage2")
    public String firstimage2;

    @XmlElement(name = "mapx")
    public float mapx;

    @XmlElement(name = "mapy")
    public float mapy;

    @XmlElement(name = "mlevel")
    public int mlevel;

    @XmlElement(name = "modifiedtime")
    public String modifiedtime;

    @XmlElement(name = "readcount")
    public int readcount;

    @XmlElement(name = "sigungucode")
    public int sigungucode;

    @XmlElement(name = "title")
    public String title;

    @XmlElement(name = "zipcode")
    public String zipcode;

    @Override
    public String toString() {
        return String.format("addr1 = %s\n" +
                "areaCode = %d\n" +
                "cat1 = %s\n" +
                "cat2 = %s\n" +
                "cat3 = %s\n" +
                "content Id = %d\n" +
                "content type id = %d\n" +
                "created time = %s\n" +
                "first image = %s\n" +
                "first image2 = %s\n" +
                "mapx = %f\n" +
                "mapy = %f\n" +
                "mlevel = %d\n" +
                "modified time = %s\n" +
                "read count = %d\n" +
                "sigungucode = %d\n" +
                "title = %s\n" +
                "zip code = %s", addr1, areacode, cat1, cat2, cat3, contentid,
                contenttypeid, createdtime, firstimage, firstimage2, mapx, mapy,
                mlevel, modifiedtime, readcount, sigungucode, title, zipcode);
    }
}