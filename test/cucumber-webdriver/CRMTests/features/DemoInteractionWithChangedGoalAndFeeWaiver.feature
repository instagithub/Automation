Feature: DemoInteraction for Connor
 
 	  # author : Murali
	  @CS-smoke @TC-99798
	  Scenario: Demo Interaction with validations
	    Given User is logged in with CSR operator
	    When Demo Interaction for Connor is started
	    Then Verify all the values are correct in toaster pop
	    When CSR Accepts the Interaction
	    Then Verifiy Left nav, header, composites, dialog, Next best action
	    When CSR launches Address Change
	    Then check dialog and verify other fields
	    When Address is modified and submitted
	    Then Validate the coaching tip and dialog
	    When Change address change for Additional account and submit
	    Then verify the change in the address and check for dialog
	    When Confirm the address change
	    Then verify the dialog, completed task in left nav
	    When launch statement copy for suggestions
	    Then verify the dialog
	    When select a statement and submit
	    Then verify the dialog and check for the fee
	    When submit the flow
	    Then Get the S- id
	    When Confirm the flow
	    Then verify the completed task
	    When launch the wrap up
	    Then Verify the completed tasks in dropdown and verify the dialog
	    When select dissatisfied angry option and complete wrap up
	    Then verify home tab is loaded
	    When Logout of the Portal
	    Given User is logged in with CSR operator again
	    When Demo Interaction for Connor is started for 2nd time
	    Then Verify all the values in toaster pop
	    When CSR Accepts the Interaction for Connor
	    Then Verifiy Left nav, header, composites, dialog and changed Goal
	    When launch statement copy from Add Task
	    Then verify the changed dialog
	    When select a statement and submit the flow
	    Then verify the dialog and check for the fee waiver
	    When submit the flow again
	    Then Get the latest S- id 
	    When Confirm the flow again
	    Then verify the completed task for statement copy
	    When launch the wrap up now
	    Then Verify the completed task in dropdown and check the dialog
	    When select happy option and complete wrap up
	    Then verify that home tab is loaded
	    When Log out of the Portal
    
