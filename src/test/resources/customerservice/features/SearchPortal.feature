@search @smoke @smoke-customer-service
Feature: Search Portal Test cases

  # author : Prakash
  @TC-opennewaccount
  Scenario: Search with Individual for Biggs
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "cacsr" and "install12345!"
    Then Verify Operator name "CS CSR"
    Then User will be navigated to the portal
    When Select "contact" and serach for "Biggs"
    Then Verify the left nav header and search results for biggs
    When Filter the result with "first name" and "Rebecca"
    Then verify the result displayed for the "Rebecca" filter
    When Select the result "Rebecca" displayed
    Then verify the title and account details for "Rebecca"
    When Click on Add Task to launch Service Process
    Then verify "contact" category under AddTask
    Then verify "general" category under AddTask
    When Launch "Open New Account" service process
    When select the verification questions for service cases and click on verified
    Then verify "Open New Account" flow is launched
    Then select a category "GENERAL" with product "IND003" and owner "Customer"
    When submit account details
    When Confirm the flow
    When close the research interaction flow
    When Operator logs of the portal
