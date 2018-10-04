@BOFEATURES @Smoke @SmokeCustomerService
Feature: BO user Test cases

  # author : GV
  @TC-400023
  Scenario: Verify  Resolved-Completed status for a wrap up followed case in Follow case tab and Recent work Tab
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "bouser" and "install12345!"
    Then Verify Operator name "Back office user"
    When Favorites already Exist in My Favorites
    Then User will be navigated to the portal
    When Select "contact" and serach for "Biggs"
    Then Verify the left nav header and search results for biggs
    When Filter the result with "first name" and "Rebecca"
    Then verify the result displayed for the "Rebecca" filter
    When Select the result "Rebecca" displayed
    When Click on Favorites
    When switch to Interaction of "Home"
    When Validate Favorites details "Rebecca" in My Favorites
    Then Operator logs of the social portal

 