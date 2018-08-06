Feature: DemoInteractionForB2B
 
 	  # author : Murali
	  @CS-smoke @TC-116956
	  Scenario: Demo Interaction for B2B with validations
	    Given CS operator logs into the portal
	    When Demo Interaction for B2B is started
	    Then Verify all the values are correct in toaster pop for B2B
	    When CSR Accepts the Interaction for Business
	    Then Verifiy Interaction tab is loaded and other fields are loaded properly
	    When CSR Click on Add Task Button and selects the Task
	    Then Verify Task in added in left navigation pannel and Verify the address change window
	    When Update the Current Address filed and Submit the Address Change Action
	    Then Select the Account for the Address Change and Submit the Address Change Request
	    When Confirm the Address Change and click confirm button
	    Then Verify the Status for the Address Change Task and verify the changed address
	    When Click on the Wrap-Up to end the interaction
	    Then End the Interaction with the Feedback and Verify Home Page is displayed
	    When Perform the logout for the CSR
	    Then Verify the Login page is displayed