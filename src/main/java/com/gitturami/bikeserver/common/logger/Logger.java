package com.gitturami.bikeserver.common.logger;

public class Logger {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getGlobal();

    public static void i(String className, String message) {
        logger.info(className + " : " + message);
    }
}
