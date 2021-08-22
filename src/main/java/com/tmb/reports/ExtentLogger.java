package com.tmb.reports;

import static com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String;
import static com.tmb.utils.ScreenshotUtils.getBase64Image;

public final class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
        ExtentManager.getExtentTest().fail(createScreenCaptureFromBase64String(getBase64Image()).build());
    }

    public static void skip(String message){
        ExtentManager.getExtentTest().skip(message);
    }
    public static void info(String message){
        ExtentManager.getExtentTest().info(message);
    }


}
