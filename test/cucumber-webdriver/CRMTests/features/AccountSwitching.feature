Feature: AccountSwitching

  # author : Kavish
  @CS-smoke @TC-116957
  Scenario: Validation when Account is switched from Individual to Commercial
    Given CS operator login to the portal
    When Demo Interaction for Sara Connor is started
    Then Verify all the values are correct in toaster pop for Sara Connor
    When CSR Accpets the Interaction
    Then Verifiy Interaction tab and verify the corrosponding fields
    When CSR clicks on the Account Number select Commercial Account
    Then Verify the Commercial Account is selected and New Tab Business Unit is displayed
    When CSR clicks on the new tab Busniess Unit
    Then Verify the fields displayed in the interaction area for the new tab
    Then Verify Tasks for the Business Unit in AddTask Button
    When CSR Wrap Up the call
    Then Feedback window is displayed and selected the feedback
    When Select the Logout option
    
   
