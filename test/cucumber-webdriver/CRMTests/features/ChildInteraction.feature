Feature: Child Interacton

  # author : raghu
  @CS-smoke @TC-116958
  Scenario: Child Interaction
    Given child interaction User is  in the login page of the CS Portal and enters username and password
	When child interaction User then starts a new demo interaction
	Then child interaction User verifies the details in the phone interaction
	When child interaction User accepts a phone call
	Then child interaction User launches the child interaction
	Then child interaction User verifies the child interaction tab
	When child interaction User check the verification and click on submit button
	Then child interaction User verifies the account details and select account
	Then child interaction User verifies the child interaction details
	When child interaction User selects the add task and selects the update profile service
	Then child interaction User verifies the update contact text and updates the date of birth
	When child interaction User clicks submit button
	Then child interaction again verifies the details
	Then child interaction launch wrapup the interaction
	Then child interaction verify child interaction tab
	Then child interaction User will then on logged out of the portal