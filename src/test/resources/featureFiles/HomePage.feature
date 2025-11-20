Feature: Verify Home Page of Make My Trip Page

  Background: User start browser and open application
    Given User launch browser and open the application

    @Demo
  Scenario: Verify User able to login successfully
    Given User login with valid user credentials
    Then User able to view makeMyTrip booking page
    Then Verify "MakeMyTripLogo" is visible on the screen
    Then User wait for "TrainsMenu" field to be visible
    Then User click on "TrainsMenu"
    Then User click on "TrainsFrom"
    Then User enter "Mumbai" in "TrainsFromSearchBar" field
#    Then User enter "Kolkata" in "TrainsTo" field
#    Then User wait for "TrainsSearchBtn" field to be visible
#    Then User click on "TrainsSearchBtn"