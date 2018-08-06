Feature: SendCorrespondance_InboundInteraction

  # author : Kavish
  @CS-smoke @TC-116960
  Scenario: Validate Send Correspondance is displayed in reason dropdown when wrapping up the Inbound call
  Given Login to the CSR portal for Inbound Correspondance
  When Launch the Inbound Correspondance call with the CSR
  Then Verify Info window is displayed to enter the data
  When Fill all the details and Submit the Correspondance data
  Then Confirmation window is displayed and confirm the window
  When Select the Id from the workbasket and click on the ID
  Then Interaction is launched for the correspondance
  When Click on Send Correspondance from the Next Best Action
  Then Verify that email config page is displayed
  When Email Config is completed and submitted
  Then 	Verify the status for the Send correspondance.
  When Wrap Up the Interaction
  Then Send Correspondance is displayed in the Reason dropdown in the feedback page
   