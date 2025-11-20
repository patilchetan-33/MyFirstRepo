package com.qa.makeMyrTrip.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.qa.makeMyrTrip.util.GlobalVariables.*;

public class GetDriver {

    public static void StartBrowser() throws IOException {

        String browser = ConfigReader.ReadConfigData("Browser");

        if(browser.equalsIgnoreCase("chrome")){

            ChromeOptions wdOptions = new ChromeOptions();
            wdOptions.addArguments("--no-sandbox");
            wdOptions.addArguments("--incognito");
            wdOptions.addArguments("disable-extensions");
            wdOptions.addArguments("--disable-popup-blocking");
            wdOptions.addArguments("test-type");
            wdOptions.addArguments("disable-infobars");

            System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver.exe");
            driver = new ChromeDriver(wdOptions);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        }
        else if(browser.equalsIgnoreCase("firefox")){
            FirefoxOptions wdOptions = new FirefoxOptions();
            driver = new FirefoxDriver(wdOptions);

        }
    }

    public static void openApplication() throws IOException, InterruptedException {
        String env = ConfigReader.ReadConfigData("Env");

        if(env.equalsIgnoreCase("SIT")){

            Thread.sleep(2000);
            driver.get(ConfigReader.ReadConfigData("SIT_URL"));
        } else if (env.equalsIgnoreCase("UAT")) {
            Thread.sleep(2000);
            driver.get(ConfigReader.ReadConfigData("UAT_URL"));

        }


    }
}
