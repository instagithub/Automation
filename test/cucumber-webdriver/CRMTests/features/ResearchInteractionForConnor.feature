Feature: Research Interaction

  # author : Murali
  @CS-smoke @TC-116968
  Scenario: Research Interaction flow
    Given a user is logged with the default operator 
    When User search for Connor in the search portal
    Then Verify that Connor is displayed in the search results
    When Select Sara Connor from the search results
    Then Verify that research interaction is opened for the selected contact with other details like Header, composite
    When Launch Update Contact Profile
    Then Verify the In-Progress Task
    When Change the Marketing Preferences and Submit
    Then Verify that compiste is loaded 
    When Close the Interaction
    Then Verify the Dashboard
    
