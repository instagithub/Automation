@newphonecall @smoke @smoke-customer-service
Feature: Phone Interaction Test cases

  # author : Murali
  @TC-scheduleactivity
  Scenario: Phone Interaction with email search and Schedule Activity
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "cacsr" and "install12345!"
    When CSR launched the New Phone Interaction
    When Search with email "jennifer.lake@hotmail123.net"
    Then verify the contact displayed
    When select result from the result and proceed
    When select the verification questions and click on verified
    Then check for "223000018" account displayed
    Then Verify the dialog, FA header, message displayed
    When select "223000018" account number and submit
    Then verifiy left nav, header, composites, dialogs and other sections
    When Click on Add Task to launch Service Process
    Then Verify all the service process items and other fields
    When Launch "Schedule Activity" service process
    Then verify "Schedule Activity" flow is launched
    Then verify dialog, FA header and other options for Schedule Activity
    When select "Conference call" and options as account "223000018" topic "Accounts" Assign to "Operator" and name "CASysAdmin"
    Then Confirm the case details
    When Confirm the flow
    When launch warpup to complete the interaction
    Then verify the wrapup dialog
    When complete the wrap up
    Then User will be navigated to the portal
    When search for I- and S- items
    Then verify the status
    When Operator logs of the portal

     