package com.tmb.pages;

import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;

import static com.tmb.utils.DynamicXpathUtils.getXpath;

public class ViewsLandingPage {

    private String dragAndDrop = "//android.widget.TextView[contains(@text,'%s')]";

    public void clickAMenuItem(String menuname){
        String newxpath = getXpath(dragAndDrop, menuname);
        DriverManager.getDriver().findElement(By.xpath(newxpath)).click();
    }
}
