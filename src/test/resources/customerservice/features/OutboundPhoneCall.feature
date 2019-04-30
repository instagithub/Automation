@outboundphone @smoke @smoke-customer-service
Feature: Outbound Phone call test cases

  # author : Shobha
   @TC-outbound-disconnect
  Scenario: Outbound phone call with Address Change and Disconnected Number
    Given a user is on login page of CS Portal
    When User logs in to CS portal as CSR
    Then Verify Operator name "CS CSR"
    Then User will be navigated to the portal
    Then User places an outbound phone call
    Then Verify fields on search screen
    Then Search for customer with lastname "connor" and accNo "12345000"
    Then select result from the result and proceed
    Then Select reason "AddressChange" and Outbound call status "Disconnected number" and Submit
    Then Enter comments for Exit Interaction "Exiting interaction" and Submit
    Then Operator logs of the portal

 # author : Shobha
 @TC-dispute-transaction
  Scenario: Outbound phone call answered with DisputeTransaction
    Given a user is on login page of CS Portal
    When User logs in to CS portal as CSR
    Then Verify Operator name "CS CSR"
    Then User will be navigated to the portal
    Then User places an outbound phone call
    Then Verify fields on search screen
    Then Search for customer with lastname "Biggs" and accNo "12345678"
    Then select result from the result and proceed
    Then Select reason "DisputeTransaction" and Outbound call status "Answered" and Submit
    #Then select the verification questions and submit for biggs
    When select the verification questions and click on verified
    When Click on Add Task to launch Service Process
    Then Verify all the service process items and other fields
    When Launch "Dispute Transaction" service process
    When select the verification questions for service cases and click on verified
    Then verify "Dispute Transaction" flow is launched
    Then select transaction "9028" for dispute
    When Select dispute reason "Merchandise not received" and submit
    When Confirm the flow
    Then check for completed or cancelled task "Dispute Transaction"
    When launch wrapup to complete outbound interaction
    Then verify the wrapup dialog
    When complete the wrap up and verify reason "Dispute Transaction"
    When Operator logs of the portal
    
  # author : Shobha
  @TC-outboundapi
  Scenario: Outbound phone call API Simulation Answered
    Given a user is on login page of CS Portal
    When User logs in to CS portal as CSR
    Then Verify Operator name "CS CSR"
    Then User will be navigated to the portal
    Then CSR launches Outbound Demo Interaction for "Outbound Call API Simulation"
    Then capture outbound interaction ID
    When User launches outbound call from "OutboundCall" workbasket
    Then User verifies checkpoints in the interaction launched
    Then User Launches interaction for "Sara Connor" with Call status "Answered"
    Then Submit the changes
    When select the verification questions and click on verified
    When Click on Add Task to launch Service Process
    Then Verify all the service process items and other fields
    When Launch "Address Change" service process
    When select the verification questions for service cases and click on verified
    Then verify "Address Change" flow is launched
    Then verify that "Address Change" flow is launched with dialog
    When change the address and other fields and submit
    When check additional account for address change and submit
    #Then check the dialog in in confirm screen and in progress task in left nav
    When confirm the changes made
    Then check for completed or cancelled task "Address Change"
    When launch wrapup to complete outbound interaction
    Then verify the wrapup dialog
    When complete the wrap up and verify reason "Address Change"
    When Operator logs of the portal