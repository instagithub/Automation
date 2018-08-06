Feature: New Demo Interacton

  # author : Murali
  @CS-smoke @TC-116970
  Scenario: New Demo Interaction
    Given a user is on login page of CS Portal and enters username and password
    When User starts a new demo interaction
    And process address change
    And process statement copy
    And Wrapup the Interaction
    Then User then verify the status of the interaction
    Then User will logged out of the portal
