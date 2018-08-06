Feature: Phone Interaction with dispute trans
 
 	  # author : Murali
	  @CS-smoke @TC-99814
	  Scenario: Phone Interaction with with dispute trans
	    Given CSR logged into the portal
	    When Phone Call flow is launched
	    Then Verify Initial dialog and other fields and buttons
	    When Search for the Customer
	    Then Check the results and other fields
	    When select a record from the result and proceed
	    Then Verify the dialog
	    When select the verification questions and submit
	    Then check for the accounts displayed
	    When select an general account and submit
	    Then verifiy left nav, header, composites, dialogs and other sections
	    When launch address change from Edit link
	    Then verify that address change flow is launched with dialog
	    When change the address and other fields and submit
	    Then Verify the dialog and next best action suggestions and coaching tip
	    When check additional account for address change and submit
	    Then check the dialog in in confirm screen and in progress task in left nav
	    When confirm the changes made
	    Then check for completed task
	    When click on transction id from Transactions
	    Then check the dialog and in progress task
	    When select a reson for dispute and submit
	    Then Check for dialog and get the s- id for reference
	    When confirm the dispute details
	    Then verify the completed task and dialog
	    When launch warpup to complete the interaction
	    Then verify the wrapup dialog
	    When complete the flow by submitting
	    Then verify that interaction is closed and home tab is loaded