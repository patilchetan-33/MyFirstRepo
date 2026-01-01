package com.qa.makeMyrTrip.Pages;

import com.qa.makeMyrTrip.util.ExcelUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static com.qa.makeMyrTrip.util.GlobalVariables.driver;

public class HomePage {

    public static void verifyHomePage() throws InterruptedException, IOException {



        Thread.sleep(2000);
        WebElement InitialPopupCloseIcon = ExcelUtilities.getElementFromExcel("xpath","InitialPopupCloseIcon");
        Thread.sleep(2000);
        InitialPopupCloseIcon.click();



    }
}
