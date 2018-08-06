Feature: TW Public and Direct Messages Threading

  # author : Shobha
  @Social-smoke @TC-100001
  Scenario: Threading Twitter public and direct messages test
    Given a user logs into social Portal
    When User enters loginID and password of socialcsr
    Then User logs into social portal
    Then Verify Operator ID of user logged in
    When Login into TW using customer ID and password
    And post a tweet to csr
    And CSR refresh to get the case
    Then CSR checks the case 
 	When case is made available, csr launches it
 	Then verify if case is launched
 	When CSR replies to the tweet sent by customer
 	Then Verify the status of the case
 	Then customer verified the reply
 	When customer sends a DM
 	Then CSR refreshes and gets the update
 	Then verify the status of case
 	When case gets updated, launch it
 	Then verify the status of case
 	Then check if customer update is threaded and send a DM    
    When Social CSR logout of the portal
