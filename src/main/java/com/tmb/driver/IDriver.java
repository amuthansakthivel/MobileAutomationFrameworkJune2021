package com.tmb.driver;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface IDriver {
    //interfaces gives you skeleton.
    public WebDriver getDriver() throws MalformedURLException;

}
