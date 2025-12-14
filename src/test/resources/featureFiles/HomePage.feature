Feature: Verify Home Page of Make My Trip Page

  Background: User start browser and open application
    Given User launch browser and open the application

    @Demo
  Scenario Outline: Verify User able to login successfully
    Given User login with valid user credentials
    Then User enter <MobileNum> in the field
    Then User able to view makeMyTrip booking page
    Then Verify "MakeMyTripLogo" is visible on the screen
    Then User wait for "TrainsMenu" field to be visible
    Then User click on "TrainsMenu"
    Then User click on "TrainsFrom"
      Examples:
        |MobileNum|
        |98673456|
        |98673453|
 #   Then User enter "Mumbai" in "TrainsFromSearchBar" field
#    Then User enter "Kolkata" in "TrainsTo" field
#    Then User wait for "TrainsSearchBtn" field to be visible
#    Then User click on "TrainsSearchBtn"

  @Demo1
  Scenario Outline: Verify xml update successfully
#    Given the XML user attribute "<attribute>" is updated to "<value>"
#    And I update nested node "Company>Department>Employee" attribute "role" to "<nestedRole>"
    And I use "tag" to update "attrNameToMatch"  "valueToMatch" "attrToUpdate" "newValue"
#    And I update user with id "<userId>" to have role "<matchedRole>"
    Examples:
      |attribute|value| nestedRole | userId | matchedRole | readAttribute |
      |role|super admin| QA manager    |502| supervisor  | name          |
     # |status|partial active| developer  | 202    | lead        | email         |