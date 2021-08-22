package com.tmb.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BrowserStackImpl implements IDriver{
    @Override

    public WebDriver getDriver(Map<String,String> map) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        map.forEach(capabilities::setCapability);//it reads all the key value from map and store it in capabilities
        capabilities.setCapability("browserstack.user", "amuthansakthivel1"); //update your user
        capabilities.setCapability("browserstack.key", "xET1z5tchDwDZ4Anwepa"); //update your key
        capabilities.setCapability("project", "Test Java Project");
        capabilities.setCapability("build", "Java Android demo");
        capabilities.setCapability("name", "some name");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "bs://b38557fcfe3048b6b46e26dc35ddb4f3c870832f" );
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.asMap().forEach((k,v)-> System.out.println(k+":"+v));
        return new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"),capabilities);
    }
}
