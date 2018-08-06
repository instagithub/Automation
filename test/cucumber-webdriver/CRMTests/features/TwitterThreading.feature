Feature: TW Public Threading

  # author : Shobha
  @Social-smoke @TC-100000
  Scenario: Twitter Threading functionality test
    Given a user is on login page of social Portal
    When User enters loginName and password of socialcsr
    Then User will have be logged into social portal
    Then Verify Operator ID
    When Login into twitter using customer ID and password
    And tweet a post to csr
    And CSR refreshes to get the case
    Then CSR checks for the case 
 	When case is available, csr launches it
 	Then check if case is launched
 	When CSR replies to the tweet
 	Then check the status of the case
 	Then customer checks for the reply
 	When customer replies to the tweet
 	Then CSR refreshes to get the update
 	Then check the status of case
 	When case is updated, launch it
 	Then verify the status
 	Then verify customer update    
    When Social CSR logs out of the portal
