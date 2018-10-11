@demointeraction @smoke @smoke-customer-service
Feature: Demo Interaction Test cases

  # author : Murali
  @TC-accountswitching
  Scenario: Validation when Account is switched from Individual to Commercial
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "cacsr" and "install12345!"
   	When CSR launches Demo Interaction for "Demo Pop - CONNOR"
    Then verify the toaster pop values for connor
    When CSR accepts the demo call
    When Click on Add Task to launch Service Process
    Then Verify all the service process items and other fields
    When Launch "Address Change" service process
    When select the verification questions for service cases and click on verified
    Then verify "Address Change" flow is launched
    Then verify that "Address Change" flow is launched with dialog
    When change the address and other fields and submit
    When check additional account for address change and submit
    Then check the dialog in in confirm screen and in progress task in left nav
    When confirm the changes made
    Then check for completed or cancelled task "Address Change"
    When launch warpup to complete the interaction
    Then verify the wrapup dialog
    When complete the wrap up
    Then User will be navigated to the portal
    When search for I- and S- items
    Then verify the status
    When Operator logs of the portal
    
    
  # author : Prakash
  @TC-creatlead
  Scenario: Verify all the options present under account and Create Lead for user
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "mikejones" and "install12345!"
    Then Verify Operator name "Mike Jones"
    When CSR launches Demo Interaction for "Demo Pop - CONNOR"
    Then verify the toaster pop values for connor
    When CSR accepts the demo call
    Then verifiy left nav, header, composites, dialogs and other sections
    Then verify Connor name and Interaction title and dialog
    Then Verify all the details for "1234500078963456" Account number
    Then verify the tabs in "Transaction" widget
    Then verify the tabs in "Statements" widget
    When Click on Add Task to launch Service Process
    When Launch "Create Lead" service process
    Then verify that "Create Lead" flow is launched with dialog
    Then Select the Stage as "Assigned" and Rating as "1-Hot" and submit
    When confirm the changes made
    When user switches to "Overview" tab
    When launch warpup to complete the interaction
    Then verify the wrapup dialog
    When complete the wrap up
    Then User will be navigated to the portal
    When Operator logs of the portal