Feature: Lost or Stolen Card feature for Brown 

  # author : raghu
  @CS-smoke @TC-116963
  Scenario: New Demo PopUp Interaction
    Given  user is  in the login page of the CS Portal and enters username and password
    When User then starts a new demo interaction
    Then User verifies the details in the phone interaction
    When User accepts a phone call
    Then User verifies the left navigation header and other details
    When User clicks adds a task and selects LostOrStolenCard
    Then User verifies the text displayed and service cases and fill the details
    When User clicks submit button
    Then Verifies the details
    When User again clicks submit button
    Then Verifies the details in the delivery method screen
    When User once again clicks submit button
    Then Verifies the details in Confirmation of Lost or Stolen Card
    When User clicks confirm button
    Then Wrap up this Interaction
    Then User will then on logged out of the portal
