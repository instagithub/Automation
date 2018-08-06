Feature: Parent and Child Interacton status

  # author : raghu
  @CS-smoke @TC-01022
  Scenario: Parent and Child Interacton status for Brown
    Given parent child interaction User is  in the login page of the CS Portal and enters username and password
	When parent child interaction User then starts a new demo interaction
	Then parent child interaction User verifies the details in the phone interaction
	When parent child interaction User accepts a phone call
	Then parent child interaction User launches the child interaction
	Then parent child interaction User verifies the child interaction tab
	When parent child interaction User check the verification and click on submit button
	Then parent child interaction User gets the child interaction id and close the child interaction
	Then parent child interaction Get the parent interaction id
	Then parent child interaction wrapup the parent interaction
	Then parent child interaction verify the parent interaction status
	Then parent child interaction User will then on logged out of the portal