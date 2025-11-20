package com.qa.makeMyrTrip.Steps;

import com.qa.makeMyrTrip.Pages.HomePage;
import com.qa.makeMyrTrip.util.GetDriver;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class HomePageTest {

    @Given("^User launch browser and open the application$")
    public void user_launch_browser_and_open_the_application() throws Throwable {
        GetDriver.StartBrowser();
    }

    @Given("^User login with valid user credentials$")
    public void User() throws Throwable {
        GetDriver.openApplication();
    }

    @Then("User able to view makeMyTrip booking page")
    public void userAbleToViewMakeMyTripBookingPage() throws IOException, InterruptedException {
        HomePage.verifyHomePage();
    }


}
