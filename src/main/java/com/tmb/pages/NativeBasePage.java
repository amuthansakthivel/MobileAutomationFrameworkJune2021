package com.tmb.pages;

import com.tmb.driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.tmb.reports.ExtentLogger.pass;

public class NativeBasePage {
    //parent of android and ios is mobile element
    //android(android element), ios(ios element), mobile chrome (webelement)

    protected String getText(MobileElement element){
        return element.getText();
    }

    public void click(MobileElement element, String elementname){
        explicitWait(element);
        element.click();
        pass(elementname + " is clicked successfully");
    }

    private void explicitWait(MobileElement element) {
        new WebDriverWait(DriverManager.getDriver(),5)
                .withMessage(()->"Some problems while finding the element")
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(By by, String elementname){
        click((MobileElement) DriverManager.getDriver().findElement(by),elementname);
    }

    protected void click(String locatortype, String value, String elementname){
        //TODO - Java 8
        if(locatortype.equalsIgnoreCase("xpath")){
            click(By.xpath(value),elementname);
        } else if(locatortype.equalsIgnoreCase("id")){
            click(By.id(value),elementname);
        }
    }

    protected void chooseItemAndClick(List<MobileElement> list,String menu){
        MobileElement mobileElement = list.parallelStream()
                .filter(e -> e.getText().contains(menu))
                .findFirst()
                .get();

        click(mobileElement,menu);
    }

    protected  void scrollToSpecificElementandClick(By by)
    {

        while(DriverManager.getDriver().findElements(by).isEmpty()) //==0
        {
            Dimension dimensions =DriverManager.getDriver().manage().window().getSize();
            Double screenHeightStart = dimensions.getHeight() * 0.5;
            int scrollStart = screenHeightStart.intValue();
            Double screenHeightEnd = dimensions.getHeight() * 0.2;
            int scrollEnd = screenHeightEnd.intValue();
            int center = (int) (dimensions.width*0.5);
            new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                    .press(PointOption.point(center,scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                    moveTo(PointOption.point(center,scrollEnd)).release().perform();
        }

        if(!DriverManager.getDriver().findElements(by).isEmpty())
        {
            DriverManager.getDriver().findElement(by).click();
        }
    }

    protected void dragAndDrop(AndroidElement source, AndroidElement target) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver()).longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
        System.out.println("drag and drop is success");
    }

    private void swipe(AndroidElement source, AndroidElement target) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
    }

    protected void longPress(AndroidElement peoplenames) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peoplenames)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .perform();
    }

    protected void tapUsingCoordinates(int x,int y) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver()).tap(PointOption.point(x,y)).perform();
    }

    protected void tap(AndroidElement views) {
        new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(views)))
                .perform();
    }


}
