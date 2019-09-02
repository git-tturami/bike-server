package com.gitturami.bikeserver.utils;

import com.gitturami.bikeserver.common.repository.Item;

import java.util.ArrayList;
import java.util.List;

public class SortingUtil {

    public static <T extends Item> List<T> pickNearby(double startLat, double startLong, double endLat, double endLong,
                                        List<T> list) {

        List<T> retList = new ArrayList<>();

        double midLat = (startLat + endLat) / 2;
        double midLong = (startLong + endLong) / 2;
        double limitDist = Math.pow(midLat - startLat, 2) + Math.pow(midLong - startLong, 2);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLatitude().trim().equals("")) {
                continue;
            }

            double dist = Math.pow(midLat - Double.valueOf(list.get(i).getLatitude()), 2) +
                    Math.pow(midLong - Double.valueOf(list.get(i).getLongitude()), 2);

            if (dist <= limitDist) {
                retList.add(list.get(i));
            }
        }

        return retList;
    }
}
