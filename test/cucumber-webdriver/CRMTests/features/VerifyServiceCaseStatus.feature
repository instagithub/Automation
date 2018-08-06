Feature: Status for the Service Case for an Interaction

  # author : Kavish
  @CS-smoke @TC-116972
  Scenario: Validation of the Two Service Cases Status when launched in the Single Interaction. One of the Service is resolved and another is cancelled
  Given CSR launch the interaction with the Customer
  When CSR accpets the interaction
  Then Verify the Interaction portal for the customer at CSR portal
  When CSR selects the Address Change task for the Customer and update the customer address
  Then Address is updated with the status of the service case as resolved-completed
  When CSR selects another Task for the customer and canel in the between
  Then verify that the status of the service case is resolved-cancelled
  When CSR wrap-up the call
  Then Interaction is closed and home page is displyed
