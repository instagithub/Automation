@contactfeature @smoke @smoke-sales-automation
Feature: Contact Feature in Sales Automation
Test covering the creation of contact creation 

Background: 
Given a user is logged into application with "skendall" and "install"

@TC-contact-creation
  Scenario: Creating a contact
    Given navigates to "Contacts" List page
    When User clicks on Create ContactButton and enters all the madatory data
    When clicks on Save button
    Then Contact should be created
    Then verify contact subtabs
    Then C2A relationship should be created
    Then Primary Individual account should be created automatically