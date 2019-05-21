@startresearch @smoke @smoke-customer-service
Feature: Start Research test cases

  # author : GV
  @TC-addresschange
  Scenario: Search with All fields under Accounts for Connor
    Given a user is on login page of CS Portal
    When User logs in to CS portal as bouser
    Then User will be navigated to the portal
    When Select "account" and serach for "Connor"
    Then Verify the left nav header and search results
    When Filter with Account number "12457890" Type "Checking" Status "True" and owner "Sara"
    Then verify the result displayed for the "12457890" filter
    When Select the result "12457890" displayed
    #Then verify the title and account details for "12457890"
    #Then verify left nav, header and composite sections for Account with "12457890"
    When Click on Add Task to launch Service Process
    Then verify "Account" category under AddTask
    Then verify "General" category under AddTask
    When Launch "Address Change" service process
    When select the verification questions for service cases and click on verified
    Then verify "Address Change" flow is launched
    Then verify that "Address Change" flow is launched with dialog
    When change the address and other fields and submit
    When check additional account for address change and submit
    When Confirm the flow
    When close the research interaction flow
    Then Operator logs of the social portal

