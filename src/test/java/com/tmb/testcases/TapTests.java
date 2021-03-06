package com.tmb.testcases;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmb.facade.DragDropFacade;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class TapTests  extends BaseTest{ //Test

    //Animal and Dog --> Dog is An Animal

    // HomePage is A Page --> inheritance home page and base page

    /*
    1. Never hardcode
    2. Try to reuse the code but inheritance is the last solution
    3. Make it easy for others to follow or write new tests
    4. Clean code
    5. Keep right things at right places
     */

    @Test(dataProvider = "getData")
    public void tapTests(Map<String,String> data) throws MalformedURLException {

        String successMessage = new DragDropFacade().navigateToDragAndDropPage()
                .getDragAndDropPage()
                .performDragAndDrop()
                .getSuccessMessage();

        assertThat(successMessage)
                .isEqualTo("Dropped!");

    }

    @DataProvider(parallel = true)
    public Object[] getData() throws IOException {
        HashMap<String,String> hashMap = new ObjectMapper().readValue(new File(System.getProperty("user.dir") +
                "/src/test/resources/jsontestdata/iteration1.json"), HashMap.class);
        HashMap<String,String> hashMap2 = new ObjectMapper().readValue(new File(System.getProperty("user.dir") +
                "/src/test/resources/jsontestdata/iteration2.json"), HashMap.class);
        //list<Map<String,String>>  list.toArray
        return new Object[]{hashMap,hashMap2};
    }




    //@Test
    public void swipeTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,
                System.getProperty("user.dir")+"/src/test/resources/apkfiles/ApiDemos-debug.apk");
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT,"8201");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.appium.android.apis");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,".ApiDemos");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"myHonorPlay");

        AndroidDriver<AndroidElement> driver =
                new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.findElementByXPath("//android.widget.TextView[contains(@text,'Views')]").click();
    }
}
