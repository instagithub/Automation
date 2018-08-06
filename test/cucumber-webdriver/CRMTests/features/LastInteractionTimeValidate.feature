Feature: LastInteractionValidate

  # author : Kavish
  @CS-smoke @TC-116961
  Scenario: Validate the Last Interaction Time at the CSR Portal.
    Given login to the CSR portal
    When Start the demo call with Sara Connor
    Then verify that the call has started
    Then Wrap up the call
    When again launch the interaction for Sara connor
    Then verify the last interaction time at the top header which should be current date
    When wrap up the call
    Then Verify that the home tab is displayed
    