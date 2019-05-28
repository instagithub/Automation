@outboundphone @smoke @smoke-customer-service
Feature: Outbound Phone call test cases

  # author : Shobha
  @TC-outbound-disconnect
  Scenario: Outbound phone call with Address Change and Disconnected Number
    Given a user is on login page of CS Portal
    When User logs in to CS portal as CSR
    When User places an outbound phone call
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
    When User places an outbound phone call
    Then Verify fields on search screen
    Then Search for customer with lastname "Biggs" and accNo "12345678"
    Then select result from the result and proceed
    Then Select reason "DisputeTransaction" and Outbound call status "Answered" and Submit
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
    When complete the wrap up and verify reason "Dispute Transaction"
    When Operator logs of the portal
