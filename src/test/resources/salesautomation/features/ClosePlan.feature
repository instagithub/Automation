@closeplanfeature @smoke @smoke-sales-automation
Feature: Close Plan in Sales Automation
Tests covering the creation of close plan for an opportunity.

Background:
    Given a user is logged into application with "skendall" and "install" 
@TC-close-plan-creation
Scenario: entering closeplan for an opportunity
	Given navigates to "Close plans" List page
	When user enters clicks on oppty in closeplan
	Then user able to enter the closeplan for that oppty and enters it