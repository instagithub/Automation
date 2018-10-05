@PartnerFeature @Smoke @SmokeSalesAutomation
Feature: Sales Automation Partner feature
Test covering the creation of Partner in Sales Automation 

Background: 
	Given a user is logged into application with "sfasamplesalesops" and "install" 

@TC-156760 @TC-PartnerCreation
Scenario: Creating a Partner with Salesrep
	Given navigates to "Partners" List page
	When User clicks on Create Partner and enters all the madatory data
	When clicks on OK button
	Then Partner should be created