Feature: Validate Composite Links on the Interaction window for various options such as Recent Interaction , Statements etc.

  # author : Kavish
  @CS-smoke @TC-00002
  Scenario: Validate Composite Links on Interaction window
   Given Login to the CsR portal
   When Launched the Interaction with the COnnor
   Then validate the Interaction window
   When accpet the interaction call with connor
   Then Interaction window is displayed and verify the Top header and different values
   When clicked on composite link for the recent interaction
   Then Verify new window pop is displayed and verify the label and differnt content on the pop-up window for interaction
   When clicked on composite link for the statements
   Then verify new window pop is displayed and verify the label and differnt content on the pop-up window for statements
   When clicked on composite link for the Transactions
   Then verify new window pop is displayed and verify the label and differnt content on the pop-up window for Transactions
   When clicked on wrap-Up
   Then Home Page is displayed