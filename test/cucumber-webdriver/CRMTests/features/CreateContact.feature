Feature: CreateContact

  # author : Kavish
  @CS-smoke @TC-116931
  Scenario: Creating the New Contact from CSR Portal
  Given CsR logs-In to the Portal
  When CSR initiates the New Phone Call
  Then new Phone Interaction Page is displayed
  When Select the Create New Contact from the Other Actions dropdown
  Then Create Contact Page is displayed
  When Complete the process of Creating new Contact and Submit
  Then after submission , csr is navigated to the Interaction window
  When csr wraps up the call with the feedback
  Then Home page is displayed