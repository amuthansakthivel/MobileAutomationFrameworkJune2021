package com.tmb.pages;

import com.tmb.reports.ExtentLogger;
import org.openqa.selenium.WebElement;

public class WebAppBasePage  {

    //parent class for Web and Native

    public void click(WebElement element, String elementname){
        element.click();
        ExtentLogger.pass(elementname+" is clicked successfully");
    }
}
