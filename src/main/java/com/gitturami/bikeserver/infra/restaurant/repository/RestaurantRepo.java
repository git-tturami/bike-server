package com.gitturami.bikeserver.infra.restaurant.repository;

import com.gitturami.bikeserver.common.repository.Item;
import com.google.gson.Gson;

public class RestaurantRepo {
    public String CRTFC_UPSO_MGT_SNO;
    public String UPSO_SNO;
    public String UPSO_NM;
    public String CGG_CODE;
    public String CGG_CODE_NM;
    public String COB_CODE_NM;
    public String BIZCND_CODE_NM;
    public String OWNER_NM;
    public String CRTFC_GBN;
    public String CRTFC_GBN_NM;
    public String CRTFC_GHR_NM;
    public String CRTFC_CHR_ID;
    public String CRTFC_YMD;
    public String USE_YN;
    public String MAP_INDICT_YN;
    public String CRTFC_CLASS;
    public String Y_DNTS;
    public String X_CNTS;
    public String TEL_NO;
    public String RDN_DETAIL_ADDR;
    public String RDN_ADDR_CODE;
    public String RDN_CODE_NM;
    public String BIZCND_CODE;
    public String COB_CODE;
    public String CRTFC_SNO;
    public String CRT_TIME;
    public String CRT_USR;
    public String UPD_TIME;
    public String FOOD_MENU;
    public String GNT_NO;
    public String CRTFC_YN;


    @Override
    public String toString() {
        return String.format(
                "food certification management serial number : %s\n" +
                        "restaurant number : %s\n" +
                        "restaurant name : %s\n" +
                        "town code : %s\n" +
                        "town name : %s\n" +
                        "business code : %s\n" +
                        "business name : %s\n" +
                        "owner name : %s\n" +

                        "food certification classification code : %s\n" +
                        "food certification classification name : %s\n" +
                        "certification manager name : %s\n" +
                        "certification manager ID : %s\n" +
                        "certification date : %s\n" +
                        "whether use or not (Y? N?) : %s\n" +
                        "whether show on map or not (Y? N?)  : %s\n" +
                        "food certification level : %s\n" +

                        "latitude : %s\n" +
                        "longitude : %s\n" +
                        "tel number : %s\n" +
                        "detailed address : %s\n" +
                        "address code : %s\n" +
                        "address : %s\n" +
                        "business code : %s\n" +
                        "business code : %s\n" +
                        "authorization number : %s\n" +

                        "first created date : %s\n" +
                        "first created manager : %s\n " +
                        "last modified date : %s\n" +
                        "representative menu : %s\n" +
                        "grant number : %s\n" +
                        "whether certificated or not (Y? N?) : %s\n" ,
                CRTFC_UPSO_MGT_SNO, UPSO_SNO, UPSO_NM, CGG_CODE, CGG_CODE_NM, COB_CODE_NM, BIZCND_CODE_NM, OWNER_NM,
                CRTFC_GBN, CRTFC_GBN_NM, CRTFC_GHR_NM, CRTFC_CHR_ID, CRTFC_YMD, USE_YN, MAP_INDICT_YN, CRTFC_CLASS,
                Y_DNTS, X_CNTS, TEL_NO, RDN_DETAIL_ADDR, RDN_ADDR_CODE, RDN_CODE_NM, BIZCND_CODE, COB_CODE, CRTFC_SNO,
                CRT_TIME, CRT_USR, UPD_TIME, FOOD_MENU, GNT_NO, CRTFC_YN
        );
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
