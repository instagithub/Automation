@serviceprocess @smoke @smoke-customer-service
Feature: Service Process Test cases
  # author : Prakash
  @TC-disputetransaction
  Scenario: Dispute transaction with amount low amount
    Given a user is on login page of CS Portal
    When User logs in to CS portal as CSR
    When CSR launches Demo Interaction for "Demo Pop - CONNOR" and accepts the call
    When Click on Add Task to launch Service Process
    When Launch "Dispute Transaction" service process
    #When select the verification questions for service cases and click on verified
    #Then verify "Dispute Transaction" flow is launched
    When Select "1029" statement  and submit
   	Then Verify Dialog, amount and In-progress task for "1029" statement
    When Select a dispute "Incorrect Charge" and submit
    Then Verify the "Resolved-Completed" status displayed
    When Confirm the Dispute transaction flow
    Then check for completed or cancelled task "Dispute Transaction"
    Then Verify "1" count is for Dispute Transaction is displayed
    When launch warpup to complete the interaction
    Then verify the wrapup dialog
    When complete the wrap up
    Then User will be navigated to the portal
    When Operator logs of the portal
