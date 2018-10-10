@HouseholdFeature @Smoke @SmokeSalesAutomation
Feature: Sales Automation Household feature
Test covering the creation of Household creation 

Background: 
	Given a user is logged into application with "skendall" and "install"

@TC-156738 @TC-HouseholdCreation 
Scenario: Creating a Households
	Given navigates to "Households" List page
	When user clicks on CreateHousehold button
	Then user should navigate to Household creation page
	When user enters all HH mandatory data for households and saves the changes
	Then Household should be created
	Then verify the Household WO subtabs