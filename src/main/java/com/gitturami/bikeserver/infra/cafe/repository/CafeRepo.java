package com.gitturami.bikeserver.infra.cafe.repository;

import com.gitturami.bikeserver.common.repository.Item;

public class CafeRepo implements Item {
    public String NM;
    public String ADDR_OLD;
    public String ADDR;
    public String OPEN_DT;
    public String STATE;
    public String STOP_DT;
    public String SUSPENSION_START_DT;
    public String SUSPENSION_END_DT;
    public String RE_OPEN_DT;
    public String AREA;
    public String POST;
    public String WATER_SUPPLY;
    public String MALE_NUM;
    public String YEAR;
    public String USEDBYMANYPEOPLE;
    public String GRADE_NM;
    public String TOTAL_SCALE;
    public String FEMALE_NUM;
    public String BUZPLC_ARND_NM;
    public String HYGIENE_TYPE;
    public String D;
    public String TEL;
    public String XCODE;
    public String YCODE;
    public String PERMISSION_NO;
    public String DETAIL_STAT_NM;

    @Override
    public String toString() {
        return String.format(
                "name : %s\n" +
                        "old address : %s\n" +
                        "address : %s\n" +
                        "open dt : %s\n" +
                        "state : %s\n" +
                        "stop dt : %s\n" +
                        "suspension start dt : %s\n" +
                        "suspenstion end dt : %s\n" +
                        "re open dt : %s\n" +
                        "area : %s\n" +
                        "post : %s\n" +
                        "water supply : %s\n" +
                        "male num : %s\n" +
                        "year : %s\n" +
                        "used by many people : %s\n" +
                        "grade name : %s\n" +
                        "total scale : %s\n" +
                        "female num : %s\n" +
                        "buzplc arnd num : %s\n" +
                        "hygiene type : %s\n" +
                        "hygiene conditions : %s\n" +
                        "tel : %s\n" +
                        "xcode : %s\n" +
                        "ycode : %sS\n" +
                        "permission no : %s\n" +
                        "detail stat num : %s\n",
                NM, ADDR_OLD, ADDR, OPEN_DT, STATE, STOP_DT, SUSPENSION_START_DT,
                SUSPENSION_END_DT, RE_OPEN_DT, AREA, POST, WATER_SUPPLY, MALE_NUM,
                YEAR, USEDBYMANYPEOPLE, GRADE_NM, TOTAL_SCALE, FEMALE_NUM, BUZPLC_ARND_NM,
                HYGIENE_TYPE, HYGIENE_CONDITIONS, TEL, XCODE, YCODE, PERMISSION_NO, DETAIL_STAT_NM);
    }

    @Override
    public String getLatitude() {
        return YCODE;
    }

    @Override
    public String getLongitude() {
        return XCODE;
    }
}
