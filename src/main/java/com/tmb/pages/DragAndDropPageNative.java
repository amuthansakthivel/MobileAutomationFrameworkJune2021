package com.tmb.pages;

import com.tmb.driver.DriverManager;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPageNative extends NativeBasePage {

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    private AndroidElement dot1;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_2")
    private AndroidElement dot2;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_result_text")
    private AndroidElement labeldropped;

    public DragAndDropPageNative(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()),this);
    }

    public DragAndDropPageNative performDragAndDrop(){
        dragAndDrop(dot1,dot2);
        return this;
    }

    public String getSuccessMessage(){
        return getText(labeldropped);
    }
}
