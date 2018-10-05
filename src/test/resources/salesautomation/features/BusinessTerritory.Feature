@BusinessTerritoryFeature @Smoke @SmokeSalesAutomation
Feature: Sales Automation Business Territory feature
Test covering the creation of Business Territory in Sales Automation 

Background: 
Given a user is logged into application with "sfasamplesalesops" and "install" 

@TC-112912 @TC-CreateBusinessTerritory
Scenario Outline: create a Business Territory Hierarchy by Global Sales Ops
	When User Navigates to Territories tab
	When User clicks on Create Territory button
	Then verify that Business Territory New modal dialog is displayed
	When User enters the data for "<Territory Name>" "<Parent Territory>" "<Owner>" "<ReservedForPartner>" and submits
	Then verify that Business Territory with name "<Territory Name>" and "<Owner>" is created  
    
Examples:
 	|Territory Name|		|Parent Territory|			|Owner|			
  |South East|		|Global|				|Terry Mason|
  