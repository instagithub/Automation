Feature: Inbound Case creation
 
  # author : Murali
  @CS-smoke @TC-116959
  Scenario: Inbound Interaction scenario
    Given a user logs into the portal with username and password
    When User starts a new Inbound interaction and creates a case
    And search the case and opens it
    And Exit the Interaction
    Then Logout of the CS Portal
