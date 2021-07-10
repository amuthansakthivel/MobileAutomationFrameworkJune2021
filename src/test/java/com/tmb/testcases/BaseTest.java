package com.tmb.testcases;

import com.tmb.driver.Driver;
import com.tmb.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Map;

public class BaseTest {


    //whatever data you feeded to test method from data provider is available as Object[] in the before method
    @BeforeMethod
    public void setUpTest(Object[] data) throws MalformedURLException {
        Map<String,String> map=  (Map<String,String>)data[0];
        Driver.initDriver(map);
    }

    @AfterMethod
    public void tearDownTest(){
        Driver.quitDriver();
    }
}
