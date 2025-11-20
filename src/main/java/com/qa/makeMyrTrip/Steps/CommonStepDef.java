package com.qa.makeMyrTrip.Steps;

import com.qa.makeMyrTrip.util.ExcelUtilities;
import com.qa.makeMyrTrip.util.Utilities;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class CommonStepDef {

    @Then("Verify {string} is visible on the screen")
    public void verifyIsVisibleOnTheScreen(String element) throws IOException {

        WebElement Element = ExcelUtilities.getElementFromExcel1("xpath",element);
        Assert.assertTrue(Element.isDisplayed());

    }


    @Then("User wait for {string} field to be visible")
    public void userWaitForFieldToBeVisible(String element) throws IOException {

        String Element = ExcelUtilities.getLocatorValueFromExcelFile(element);
        Utilities.fluentWait(Element);
    }

    @Then("User click on {string}")
    public void userClickOn(String element) throws IOException, InterruptedException {
        WebElement Element = ExcelUtilities.getElementFromExcel1("xpath",element);
        Thread.sleep(2000);
        Element.click();
    }

    @Then("User enter {string} in {string} field")
    public void userEnterInField(String data,String element) throws IOException, InterruptedException {
        WebElement Element = ExcelUtilities.getElementFromExcel1("xpath",element);
        Thread.sleep(2000);
        Utilities.switchToChildWindow();
        Thread.sleep(2000);
        Utilities.actionSendKeys(data);
//        Element.clear();
//        Thread.sleep(2000);
//        Element.sendKeys(data);
    }


}
