Feature: NewPhoneCall_Referesh&ExitInteraction

  # author : Kavish
  @CS-smoke @TC-116924
  Scenario: Validate the Referesh and Exit Interaction feature when launching new Interaction
  Given Csr perform login to the portal
  When Csr launched the New Phone Interaction
  Then Verify New Interaction Page is displayed
  When Search for any of the Contact in the Interaction page
  Then Contact is dispalayed
  When Select the Refersh option from the Other Actions dropdown.
  Then Interaction page is refereshed and reset to default
  When Select the Exit Interaction option and complete the Exit interaction
  Then Exit Interaction page is displayed after submitting home page is displayed
  