Feature: Validate Composite Links on the Interaction window for various options such as Recent Interaction , Statements etc for B2B.

  # author : Kavish
  @CS-smoke @TC-00003
  Scenario: Validate Composite Links on Interaction window for B2B
   Given Login to the csR portal
   When Launched the Interaction with the B2B
   Then validate the Interaction Window
   When accpet the interaction call for B2B
   Then Interaction window is displayed and verify the Top header and different values for B2B
   When clicked on Businees Unit Tab
   Then Validate the different widgets for business unit
   When clicked on View all for customers
   Then New window is displayed and validate the values
   When wrap up the B2B interaction
   Then submit the feedback and home page is displayed