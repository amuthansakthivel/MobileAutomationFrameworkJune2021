package com.tmb.testcases;

import com.tmb.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;

public class BaseTest {

    @BeforeMethod
    public void setUpTest() throws MalformedURLException {
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDownTest(){
        Driver.quitDriver();
    }
}
