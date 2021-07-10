package com.tmb.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Map;

public interface IDriver {
    //interfaces gives you skeleton.
    public WebDriver getDriver(Map<String,String> map) throws MalformedURLException;

}
