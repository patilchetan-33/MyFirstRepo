package com.qa.makeMyrTrip.util;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.qa.makeMyrTrip.util.GlobalVariables.driver;

public class Utilities {

    public static long pageLoadTimeout =60;
    public static long implicitWait = 50;

    public static void fluentWait(String Element){

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(1, TimeUnit.SECONDS)
                .withTimeout(60,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Element)));

    }

    public static void isDisplayed(WebElement element){

       Boolean actRes =  element.isDisplayed();
        Assert.assertEquals(actRes,true);
    }

    public static void actionSendKeys(String data){
        Actions actions = new Actions(driver);
       actions.sendKeys(data).build().perform();

    }

    public static void switchToChildWindow(){
       String mainWindow =  driver.getWindowHandle();
       Set<String> allWindows = driver.getWindowHandles();

       for(String window : allWindows){
           if(!window.equals(mainWindow)){
               driver.switchTo().window(window);
               break;
           }
       }
    }
}
