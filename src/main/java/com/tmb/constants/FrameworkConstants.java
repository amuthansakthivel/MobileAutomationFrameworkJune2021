package com.tmb.constants;

public final class FrameworkConstants {

    //lombak

    private FrameworkConstants(){}

    private static final String resourcepath = System.getProperty("user.dir") + "/src/test/resources";
    private static final String apkfilepath = resourcepath+"/apkfiles/ApiDemos-debug.apk";
    private static final String configfilepath = resourcepath+"/config/config.properties";

    public static String getApkFilePath() {
        return apkfilepath;
    }

    public static String getConfigFilePath() {
        return configfilepath;
    }
}
