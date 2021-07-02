package com.tmb.driver;

import com.tmb.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static com.tmb.driver.DriverManager.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public final class Driver {

    private Driver(){}

    //class should be closed for modification and open for extension
    //factory pattern --> generating child classes for a super class or an interface
    //Thread safe

    //local variable are thread sage
    //local mem

    public static void initDriver() throws MalformedURLException {
        if(isNull(getDriver())) {
            String modevalue = PropertyUtils.getValue("mode");
            WebDriver driver = DriverFactory.get(Modes.valueOf(modevalue.toUpperCase()));
            setDriver(driver);
        }
    }

    public static void quitDriver(){
        if(nonNull(getDriver())) {
            getDriver().quit();
            unload();
        }

    }


}
