package com.gitturami.bikeserver.infra.leisure.retrofit;

import com.gitturami.bikeserver.infra.leisure.repository.LeisureResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=7BU6hvKaLizImcLOotFguCrmNH5l%2FixLxWZzpCT4n2ceil5n72Y04LoPnBLC7prrNXjawXY%2BZzIO3Smg2OQl5w%3D%3D
&contentTypeId=28&areaCode=1&sigunguCode=&cat1=&cat2=&cat3=&listYN=Y&MobileOS=ETC&MobileApp=TourAPI3.0_Guide&arrange=A&numOfRows=12&pageNo=1
 */
public interface LeisureRetrofit {
    @GET("areaBasedList")
    Call<LeisureResponse> leisureList(
            @Query("ServiceKey") String serviceKey,
            @Query("contentTypeId") String contentTypeId,
            @Query("areaCode") int areaCode,
            @Query("sigunguCode") String sigunguCode,
            @Query("cat1") String cat1,
            @Query("cat2") String cat2,
            @Query("cat3") String cat3,
            @Query("listYN") String listYN,
            @Query("MobileOS") String mobileOS,
            @Query("MobileApp") String mobileApp,
            @Query("arrange") String arrange,
            @Query("numOfRows") int numOfRows,
            @Query("pageNo") int pageNo
    );
}
