package com.tmb.pages;

import static com.tmb.utils.DynamicXpathUtils.getXpath;

public class ViewsLandingPageNative extends NativeBasePage {
    //android and ios --> you might need to create two diff locators

    private String dragAndDrop = "//android.widget.TextView[contains(@text,'%s')]";


    public void clickAMenuItem(String menuname){
        String newxpath = getXpath(dragAndDrop, menuname);
        click("xpath",newxpath,"Drag and Drop");

    }
}
