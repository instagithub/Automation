Feature: FB Public and Private Threading

  # author : Shobha
  @Social-smoke @TC-100003
  Scenario:  Threading FB public and direct messages test
    Given User is on login page of social Portal
    When User inputs Name and password of socialcsr
    Then User login to social portal
    Then Verify OpID
    When Login Facebook using FB ID and password
    And Go to the page
    And Post user concern on FB page
    And CSR gets the case on refresh
    Then CSR identifies for the case 
 	When case is made available and csr will launch it
 	Then verify if case has been launched
 	When CSR responds to the FB post
 	Then verify case status is changed or not
 	Then customer verifies for the csr reply on FB
 	When customer sends a PM
 	Then CSR Refreshes to finds update
 	Then csr check the status of case on refresh
 	When case gets update on refresh, csr launches it
 	Then verify Status of case on reply
 	Then verify if customer PM is attached
 	Then CSR replies to the PM received    
    When Social CSR will log out from the portal

