@sa-smoke
Feature: Smoke tests for SA
  Tests covering all the core SA work objects and few actions on them.

  
@TC-108452
  Scenario Outline: Creating a Business Opportunities
    Given a user is logged into application with "tmason" and "install"
	  Given navigates to "Opportunities" List page
    When users clicks on Create OpprotunityButton and selects "<Opptype>"
    And Enters all the mandatory data for "<Opptype>"
    Then "<Opptype>" Opportunity should be created
    And opportunity should have all the tabs

    Examples: 
   | Opptype    |
   | Business   |     
	
@TC-108455
  Scenario Outline: Updating the Stage of the "<Opptype>" opportunity
  	Given a user is logged into application with "tmason" and "install"
	  Given navigates to "Opportunities" List page
    When user opens the "<Opptype>" opportunity with "<OpptyName>"
    And clicks on Update Stage button
    Then user should navigate to change stage page
    When user updates the stage and submit the changes
    Then stage of the "<Opptype>" opportunity should be changed

    Examples: 
 | Opptype    |  | OpptyName |
 | Individual |  | PIR Motion Detector Sensors for Laurel Reitler|

@TC-108456
  Scenario Outline: Closing the Opportunity
	  Given a user is logged into application with "tmason" and "install"
  	Given navigates to "Opportunities" List page
  	When users clicks on Create OpprotunityButton and selects "<Opptype>"
    And Enters all the mandatory data for "<Opptype>"
    Then "<Opptype>" Opportunity should be created
  	Given navigates to "Opportunities" List page
    When user opens the "<Opptype>" opportunity with "<OpptyName>"
    And clicks on Close button for "<Opptype>" Opportunity
    And user enters the reason for closing of opportunity and saves the changes
    Then "<Opptype>" opportunity should be closed

    Examples: 
| Opptype    |  | OpptyName|
| Business   |  | Automation opp for business |

  @TC-156750
  Scenario Outline: Creating  Business Lead
  	Given a user is logged into application with "tmason" and "install"
   	Given navigates to "Leads" List page
    When users clicks on Create LeadButton and selects "<Leadtype>"
    And Enters all the mandatory Lead data for "<Leadtype>"
    Then "<Leadtype>" Lead should be created with "<LeadName>"
    Then verify the lead WO subtabs

    Examples: 
      | Leadtype   |  | LeadName                   |
      | Business   |  | Automation lead Business   |
      
@TC-181927
  Scenario Outline: Changing ownership of the "<Leadtype>" opportunity
  	Given a user is logged into application with "tmason" and "install"
   	Given navigates to "Leads" List page
    When user opens the "<Leadtype>" Lead with "<LeadName>"
    And clicks on change owner button
    When user changes the Owner, enters the reason and submit the changes
    Then ownership of the "<Leadtype>" lead should be changed

    Examples: 
      | Leadtype   |  | LeadName     |
      | Business   |  | Sarah Connor |
      
@TC-341237
Scenario: entering closeplan for an opportunity
	Given a user is logged into application with "skendall" and "install"
	Given navigates to "Close plans" List page
	When user enters clicks on oppty in closeplan
	Then user able to enter the closeplan for that oppty and enters it
  
    

@TC-108434
  Scenario: Creating a contact
  Given a user is logged into application with "skendall" and "install"
  Given navigates to "Contacts" List page
    When User clicks on Create ContactButton and enters all the madatory data
    And clicks on Save button
    Then Contact should be created
    Then verify contact subtabs
    Then C2A relationship should be created
    Then Primary Individual account should be created automatically
      

@TC-156738 
Scenario: Creating a Households
	Given a user is logged into application with "skendall" and "install"
 	Given navigates to "Households" List page
	When user clicks on CreateHousehold button
	Then user should navigate to Household creation page
	When user enters all HH mandatory data for households and saves the changes
	Then Household should be created
	Then verify the Household WO subtabs
  

 @TC-113320
  Scenario: create Sales Rep Operator by Sales Ops
   	Given a user is logged into application with "sfasamplesalesops" and "install"
    Given navigates to "Operators" List page
    Then SalesRepOperatorCreation - Verify that user navigates to Operators tab 
    When SalesRepOperatorCreation -  clicks on Create Operator button
    Then SalesRepOperatorCreation - verify that Operator New harness is displayed
    When SalesRepOperatorCreation - Sales Ops enters the data and navigates to Operator Access tab
    Then SalesRepOperatorCreation - verify that Operator navigates to Access tab
    When SalesRepOperatorCreation - enters data in Operator Access tab and navigates to Sales Goals tab
    Then SalesRepOperatorCreation - Verify that Sales Goals tab is displayed 
    When SalesRepOperatorCreation - Enters Sales Goals information and submits
    Then SalesRepOperatorCreation - Verify that operator record is created
    When SalesRepOperatorCreation - Navigate to Operator list page to search the newly created Operator
    When SalesRepOperatorCreation - Sales Ops Logout of SFA application
    
 @TC-103169
  Scenario: create Organization
    Given a user is logged into application with "skendall" and "install"
    Given navigates to "Organizations" List page
    When SalesOps navigates to Organization tab to Create Org
    Then Verify that user navigates to Organization tab 
    When SalesOps clicks on Create Oranization button
    Then verify that Organization New harness is displayed
    When SalesOps enters the data and submits
    Then verify that Organization Wo is created
   	Given navigates to "Organizations" List page
    Then SaleOps search for the Organization
    When SaleOps Opens the Organization WO1
    Then SaleOps validates the Organization work object details      
    
 @TC-108441
  Scenario: Creating a Account
  	Given a user is logged into application with "skendall" and "install"
    Given navigates to "Accounts" List page
    When user clicks on CreateAccount button
    Then user should navigate to Account creation page
	  When user enters all the mandatory data and saves the changes
    Then Account should be created
    
@TC-108442
  Scenario Outline: Editing an account
  	Given a user is logged into application with "skendall" and "install"
   	Given navigates to "Accounts" List page
    When user opens the existing Account with "<AccName>"
    And clicks on edit button
    Then user should able to edit all the fields in Account page
    When user edits the input fields and save the changes
    Then Account should be reflected with the changes made in the account page
		Examples:
		|AccName|
		|Nexus Energy|
    
@TC-112912
Scenario Outline: create a Business Territory Hierarchy by Global Sales Ops
Given a user is logged into application with "sfasamplesalesops" and "install"
When User Navigates to Territories tab
When User clicks on Create Territory button
Then verify that Business Territory New modal dialog is displayed
When User enters the data for "<Territory Name>" "<Parent Territory>" "<Owner>" "<ReservedForPartner>" and submits
Then verify that Business Territory with name "<Territory Name>" and "<Owner>" is created  
    
Examples:
 	|Territory Name|		|Parent Territory|			|Owner|			
  |South East|		|Global|				|Terry Mason|
  
@TC-156760
Scenario: Creating a Partner with Salesrep
Given a user is logged into application with "sfasamplesalesops" and "install"
Given navigates to "Partners" List page
When User clicks on Create Partner and enters all the madatory data
And clicks on OK button
Then Partner should be created