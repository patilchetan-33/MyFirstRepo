package com.qa.makeMyrTrip.Steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.qa.makeMyrTrip.util.GlobalVariables.driver;

public class TestHooks {

    @AfterStep
    public void afterStep(Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());



    }

    @After
    public void afterScenario(Scenario scenario) {
        if(scenario.isFailed()) {
            try{
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
            catch(Exception e){
            System.out.println(e.getMessage());
            }
        }
        driver.quit();

    }

}
