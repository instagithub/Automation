@LEADFEATURE @Smoke @SmokeSalesAutomation
Feature: Lead work object Feature
Tests covering the Lead flow actions like Create , Change ownership on a lead

Background:
    Given a user is logged into application with "tmason" and "install" 
 
 
  @TC-156750
  Scenario Outline: Creating  Business Lead
  	Given navigates to "Leads" List page
    When users clicks on Create LeadButton and selects "<Leadtype>"
    When Enters all the mandatory Lead data for "<Leadtype>"
    Then "<Leadtype>" Lead should be created with "<LeadName>"
    Then verify the lead WO subtabs

    Examples: 
      | Leadtype   |  | LeadName                   |
      | Business   |  | Automation lead Business   |
      
@TC-181927
  Scenario Outline: Changing ownership of the "<Leadtype>" opportunity
  	Given navigates to "Leads" List page
    When user opens the "<Leadtype>" Lead with "<LeadName>"
    When clicks on change owner button
    When user changes the Owner, enters the reason and submit the changes
    Then ownership of the "<Leadtype>" lead should be changed

    Examples: 
      | Leadtype   |  | LeadName     |
      | Business   |  | Sarah Connor |