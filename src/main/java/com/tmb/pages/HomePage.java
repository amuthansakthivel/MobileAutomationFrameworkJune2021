package com.tmb.pages;

import com.tmb.driver.DriverManager;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    //Page Factory
    //By locators
    //String locators

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Views')]")
    private AndroidElement views;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Animation')]")
    private AndroidElement animation;

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()),this);
    }

    public ViewsLandingPage clickOnViews(){
        views.click();
        return new ViewsLandingPage();
    }

}
