package com.gitturami.bikeserver.api.logger;

import com.gitturami.bikeserver.common.logger.Logger;

public class ApiLogger {
    private static String TAG = "Api)";

    public static void i(String className, String message) {
        Logger.i(TAG + className, message);
    }
}
