package com.qa.makeMyrTrip.Pages;

import com.qa.makeMyrTrip.util.ExcelUtilities;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class HomePage {

    public static void verifyHomePage() throws InterruptedException, IOException {

        Thread.sleep(2000);
        WebElement InitialPopupCloseIcon = ExcelUtilities.getElementFromExcel1("xpath","InitialPopupCloseIcon");
        Thread.sleep(2000);
        InitialPopupCloseIcon.click();



    }
}
