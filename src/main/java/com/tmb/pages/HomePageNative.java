package com.tmb.pages;

import com.tmb.driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageNative extends NativeBasePage {

    //Page Factory
    //By locators
    //String locators

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Views')]")
    @iOSXCUITFindBy(accessibility = "Views")
    private MobileElement views;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Animation')]")
    private AndroidElement animation;

    @AndroidFindBy(xpath = "//android.widget.TextView")
    @iOSXCUITFindBy(accessibility = "Views")
    private List<MobileElement> menuitems;

    public HomePageNative(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()),this);
    }

    public ViewsLandingPageNative clickOnViews(){
        click(views,"Views");
        return new ViewsLandingPageNative();
    }

    public void clickAMenuItem(String menu){
        chooseItemAndClick(menuitems,menu);

        /*for(WebElement element:menuitems){
            if (element.getText().equalsIgnoreCase(menu)) {
                element.click();
            }
        }*/
    }



}
