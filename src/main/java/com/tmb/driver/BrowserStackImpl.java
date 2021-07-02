package com.tmb.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackImpl implements IDriver{
    @Override
    public WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserstack.user", "amuthansakthivel1");
        capabilities.setCapability("browserstack.key", "xET1z5tchDwDZ4Anwepa");
        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("os_version", "9.0");
        capabilities.setCapability("project", "Test Java Project");
        capabilities.setCapability("build", "Java Android demo");
        capabilities.setCapability("name", "some name");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "bs://beca9cb73eec88c758c0aeefaf512165fca3599e" );
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        return new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"),capabilities);
    }
}
