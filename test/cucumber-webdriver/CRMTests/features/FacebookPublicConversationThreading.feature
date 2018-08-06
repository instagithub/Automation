Feature: FB Public Threading

  # author : Shobha
  @Social-smoke @TC-100002
  Scenario: Facebook Threading functionality test
    Given user is on login page of social Portal
    When User inputs loginName and password of socialcsr
    Then User will login to social portal
    Then Verify Op ID
    When Login into Facebook using FB ID and password
    And Navigate to the page
    And Post concern on FB page
    And CSR refreshes and gets the case
    Then CSR verifies for the case 
 	When case is made available and csr launches it
 	Then verify if case is launched
 	When CSR replies to the FB post
 	Then verify status of the case
 	Then customer checks for the csr reply
 	When customer replies to the customer comment
 	Then CSR Refreshes to get the update
 	Then csr check the status of case
 	When case gets updated, csr launches it
 	Then verify Status of case
 	Then verify if customer update is attached    
    When Social CSR will log out of the portal
