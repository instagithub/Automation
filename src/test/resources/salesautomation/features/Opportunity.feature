@OPPORTUNITYFEATURES @Smoke @SmokeSalesAutomation
Feature: Basic Opportunity flows
Tests covering the core Opportunity flow actions like Create, Change Stage and Closing an opportunity.

Background:
    Given a user is logged into application with "tmason" and "install"
  
@TC-108452 @TC-CreateOpportunity
  Scenario Outline: Creating a Business Opportunities

	  Given navigates to "Opportunities" List page
    When users clicks on Create OpprotunityButton and selects "<Opptype>"
    When Enters all the mandatory data for "<Opptype>"
    Then "<Opptype>" Opportunity should be created
    Then opportunity should have all the tabs

    Examples: 
   | Opptype    |
   | Business   |
	
@TC-108455 @TC-OpportunityChangeStage
  Scenario Outline: Updating the Stage of the "<Opptype>" opportunity

	  Given navigates to "Opportunities" List page
    When user opens the "<Opptype>" opportunity with "<OpptyName>"
    When clicks on Update Stage button
    Then user should navigate to change stage page
    When user updates the stage and submit the changes
    Then stage of the "<Opptype>" opportunity should be changed

    Examples: 
 | Opptype    |  | OpptyName |
 | Individual |  | PIR Motion Detector Sensors for Laurel Reitler|

@TC-108456 @TC-CloseOpportunity
  Scenario Outline: Closing the Opportunity

  	Given navigates to "Opportunities" List page
  	When users clicks on Create OpprotunityButton and selects "<Opptype>"
    When Enters all the mandatory data for "<Opptype>"
    Then "<Opptype>" Opportunity should be created
  	Given navigates to "Opportunities" List page
    When user opens the "<Opptype>" opportunity with "<OpptyName>"
    When clicks on Close button for "<Opptype>" Opportunity
    When user enters the reason for closing of opportunity and saves the changes
    Then "<Opptype>" opportunity should be closed

    Examples: 
| Opptype    |  | OpptyName|
| Business   |  | Automation opp for business |