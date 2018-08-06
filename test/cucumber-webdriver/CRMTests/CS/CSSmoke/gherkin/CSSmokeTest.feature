@APPEXPRESS @CS-Regression @Gears-Regression @CRMALL

Feature: CS Smoke Test cases  

# author : GV
  @CRM-SMOKE @SparkOne @Smoke @TC-400023
  Scenario: Verify  Resolved-Completed status for a wrap up followed case in Follow case tab and Recent work Tab
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "bouser" and "install12345!"
    Then Verify Operator name "Back office user"
    When Favorites already Exist in My Favorites
    Then User will be navigated to the portal
    When Select "contact" and serach for "Biggs"
    Then Verify the left nav header and search results for biggs
    When Filter the result with "first name" and "Rebecca"
    Then verify the result displayed for the "Rebecca" filter
    When Select the result "Rebecca" displayed
    When Click on Favorites
    When switch to Interaction of "Home"
    When Validate Favorites details "Rebecca" in My Favorites
    Then Operator logs of the social portal
	
	 # author : Prakash
  @CRM-REGRESSION @ChipsSOR @Smoke @Chips @CS-DevOpsChips @traceFiddler @TC-550001
  Scenario: Create new contact and run update contact profile
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "mikejones" and "install12345!"
    Then Verify Operator name "Mike Jones"
    When CSR launched the New Phone Interaction
    #Then Verify Initial dialog and other fields and buttons for mike
    #When Click on Tools Menu button
    #Then Verify Menu Options after clicking on tools menu buttons
    #When Click on Other Actions button
    #Then Verify Menu Options after clicking on Other Actions buttons
    When Search for the Customer with Contact Name "testcontact_name"
    Then verify no contact is present and create new contact option is available
    When CSR opens the create contact flow
    Then Enter mandatory fields "New Contact FN" and "New Contact LN" and "testcontactmailid" and submit
    When Click on Add Task to launch Service Process
    When Launch "Update Contact Profile" service process
    Then update DOB "01/07/1990" and Gender "M" and Marital Status "Single"
    Then update the primary address
    Then update communication preference method "Mail" time "8am-10am" and language to "English"
    #Then update notification to "Email"
    Then Submit the changes made
    When confirm the changes made
    When launch warpup to complete the interaction
    Then verify the wrapup dialog
    When complete the wrap up
    Then User will be navigated to the portal
    When Operator logs of the portal
	
	# author : Prakash
  @CRM-REGRESSION @Smoke @CRM-SMOKE @Chips @TC-550010
  Scenario: For existing contact update Address in CS portal and verify it in SA Portal
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "mikejones" and "install12345!"
    Then Verify Operator name "Mike Jones"
    When CSR launched the New Phone Interaction
    When Click on Other Actions button
    #Then Verify Menu Options after clicking on Other Actions buttons
    Then Verify Menu options in Other Actions buttons
    When Search for the Customer with Contact Name "connor"
    Then Check the results for contact and other fields
    When select result from the result and proceed
    #Then Verify the dialog, flow action header, contact verification
    When select the verification questions and click on verified   
    Then check for the accounts displayed
    Then check for "12345000" account displayed
    When select "12345000" account number and submit
    Then verifiy left nav, header, composites, dialogs and other sections
    #When CSR launches Demo Interaction for "Demo Pop - CONNOR"
    #Then verify the toaster pop values for connor
    #When CSR accepts the demo call
    #Then verify Connor name and Interaction title and dialog
    #Then verify Demp Pop Connor name and Interaction title and dialog
    When Click on Add Task to launch Service Process
    Then Verify all the service process items and other fields
    When Launch "Address Change" service process
    Then verify "Address Change" flow is launched
    Then verify that "Address Change" flow is launched with dialog
    When change the address and other fields and submit
    #Then Verify the dialog and next best action suggestions and coaching tip
    Then Verify the dialog and next best action suggestions and coaching tip for Address Change
    When check additional account for address change and submit
    Then check the dialog in in confirm screen and in progress task in left nav
    When confirm the changes made
    Then check for completed or cancelled task "Address Change"
    When launch warpup to complete the interaction
    Then verify the wrapup dialog
    When complete the wrap up
    Then User will be navigated to the portal
    When User switches to "Pega Sales Automation Sample Application" portal
    Then Verify the top Nav links
    When Select "Contacts" from left nav
    Then verify the options displayed under contacts
    When Search and select the "Sara Connor" user
    Then verify the tabs present for the user
    When user navigates to "Details" tab
    Then Verify the updated address
    When User switches to "Customer Service" portal
    Then User will be navigated to the portal
    When Operator logs of the portal
	
	# author : Murali
  @COMMENTCRM-REGRESSION @DevOps @CS-Smoke @Smoke @traceFiddler @MI @TC-116957
  Scenario: Validation when Account is switched from Individual to Commercial
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "cacsr" and "install12345!"
   # When Demo Interaction for Sara Connor is started
   	When CSR launches Demo Interaction for "Demo Pop - CONNOR"
    #Then Verify all the values are correct in toaster pop for Sara Connor
    Then verify the toaster pop values for connor
    When CSR accepts the demo call
    #When CSR Accpets the Interaction
    Then Verifiy Interaction tab and verify the corrosponding fields
    When CSR clicks on the Account Number select Commercial Account
    Then Verify the Commercial Account is selected and New Tab Business Unit is displayed
    When CSR clicks on the new tab Busniess Unit
    Then Verify the fields displayed in the interaction area for the new tab
     When Click on Add Task to launch Service Process
    Then Verify all the service process items and other fields
    And Verify BU service process
    When Launch "Update Organization Profile" service process
    Then verify that BU "Update Organization Profile" flow is launched with dialog
    When update business unit comm details and submit
    When confirm the changes made
    Then check for completed or cancelled task "Update Organization Profile"
   	When launch warpup to complete the interaction
    Then verify the wrapup dialog
    When complete the wrap up
    Then User will be navigated to the portal
    When search for I- and S- items
    Then verify the status
    When Operator logs of the portal
	
	
	# author : Murali
   @CRM-SMOKE @CRM-REGRESSION @SparkTwo @Smoke @TC-134576 
  Scenario: Phone Interaction with email search and Schedule Activity
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "cacsr" and "install12345!"
    When CSR launched the New Phone Interaction
    #Then Verify Initial dialog and other fields and buttons
    #When Click on Tools Menu button
    #Then Verify Menu Options after clicking on tools menu buttons
    #When Click on Other Actions button
    #Then Verify Menu Options after clicking on Other Actions buttons
    When Search with email "jennifer.lake@hotmail123.net"
    Then verify the contact displayed
    When select result from the result and proceed
    #Then Verify the dialog, in progress task and FA header email contact
    #When select the verification questions and submit
 		When select the verification questions and click on verified
    Then check for "223000018" account displayed
    And Verify the dialog, FA header, message displayed
    When select "223000018" account number and submit
    Then verifiy left nav, header, composites, dialogs and other sections
    #Then verify Lake name and Interaction title and dialog
    When Click on Add Task to launch Service Process
    Then Verify all the service process items and other fields
    When Launch "Schedule Activity" service process
    Then verify "Schedule Activity" flow is launched
    And verify dialog, FA header and other options for Schedule Activity
    When select "Conference call" and options as account "223000018" topic "Accounts" Assign to "Operator" and name "CASysAdmin"
    Then Confirm the case details
    When Confirm the flow
    When launch warpup to complete the interaction
    Then verify the wrapup dialog
    When complete the wrap up
    Then User will be navigated to the portal
    When search for I- and S- items
    Then verify the status
    When Operator logs of the portal
	
		
	
	# author : Prakash
  @CRM-SMOKE @CRM-REGRESSION @CS-SMOKE @Smoke @TC-224745
  Scenario: Search with Individual for Biggs
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "cacsr" and "install12345!"
    Then Verify Operator name "CS CSR"
    Then User will be navigated to the portal
    When Select "contact" and serach for "Biggs"
    Then Verify the left nav header and search results for biggs
    When Filter the result with "first name" and "Rebecca"
    Then verify the result displayed for the "Rebecca" filter
    When Select the result "Rebecca" displayed
    Then verify the title and account details for "Rebecca"
    When Click on Add Task to launch Service Process
    Then verify "contact" category under AddTask
    Then verify "general" category under AddTask
    When Launch "Complaint or Compliment" service process
    Then verify "Complaint or Compliment" flow is launched
    When Select "Complaint" type as "AccountIssue" issue as "Contact Profile Outdated" and submit
    Then verify confirm message, case name and status
    When Confirm the flow
    When close the research interaction flow
    When Operator logs of the portal

	
	# author : GV
  @CRM-REGRESSION @SparkThree @Smoke @TC-400017
  Scenario: Search with All fields under Accounts for Connor
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "bouser" and "install12345!"
    Then Verify Operator name "Back office user"
    Then User will be navigated to the portal
    When Select "account" and serach for "Connor"
    Then Verify the left nav header and search results
    When Filter with Account number "12457890" Type "Checking" Status "True" and owner "Sara"
    Then verify the result displayed for the "12457890" filter
    When Select the result "12457890" displayed
    Then verify the title and account details for "12457890"
    Then verify left nav, header and composite sections for Account with "12457890"
    When Click on Add Task to launch Service Process
    Then verify "Account" category under AddTask
    Then verify "General" category under AddTask
    When Launch "Address Change" service process
    Then verify "Address Change" flow is launched
    Then verify that "Address Change" flow is launched with dialog
    When change the address and other fields and submit
    When check additional account for address change and submit
    When Confirm the flow
    When close the research interaction flow
    Then Operator logs of the social portal
	
	
	# author : Shobha
  @SparkOne @Smoke @TC-40009
  Scenario: Outbound phone call API Simulation Answered
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "cacsr" and "install12345!"
    Then Verify Operator name "CS CSR"
    Then User will be navigated to the portal
    Then CSR launches Outbound Demo Interaction for "Outbound Call API Simulation"
    Then capture outbound interaction ID
    When User launches outbound call from "OutboundCall" workbasket
    Then User verifies checkpoints in the interaction launched
    Then User Launches interaction for "Sara Connor" with Call status "Answered"
    Then Submit the changes
    #Then Select the verification questions and submit for outboundcall
    When select the verification questions and click on verified
    When Click on Add Task to launch Service Process
    Then Verify all the service process items and other fields
    When Launch "Address Change" service process
    Then verify "Address Change" flow is launched
    Then verify that "Address Change" flow is launched with dialog
    When change the address and other fields and submit
    When check additional account for address change and submit
    Then check the dialog in in confirm screen and in progress task in left nav
    When confirm the changes made
    Then check for completed or cancelled task "Address Change"
    When launch wrapup to complete outbound interaction
    Then verify the wrapup dialog
    #When get the interaction ID
    When complete the wrap up and verify reason "Address Change"
    #When Search "Resolved-Completed" status of outbound interaction
    When Operator logs of the portal
	
	
	# author : Shobha
  @SparkOne @Smoke @TC-40007
  Scenario: Outbound phone call answered with DisputeTransaction
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "cacsr" and "install12345!"
    Then Verify Operator name "CS CSR"
    Then User will be navigated to the portal
    Then User places an outbound phone call
    Then Verify fields on search screen
    Then Search for customer with lastname "Biggs" and accNo "12345678"
    Then select result from the result and proceed
    Then Select reason "DisputeTransaction" and Outbound call status "Answered" and Submit
    #Then select the verification questions and submit for biggs
    When select the verification questions and click on verified
    When Click on Add Task to launch Service Process
    Then Verify all the service process items and other fields
    When Launch "Dispute Transaction" service process
    Then verify "Dispute Transaction" flow is launched
    Then select transaction "9028" for dispute
    When Select dispute reason "Merchandise not received" and submit
    When Confirm the flow
    Then check for completed or cancelled task "Dispute Transaction"
    When launch wrapup to complete outbound interaction
    Then verify the wrapup dialog
    When complete the wrap up and verify reason "Dispute Transaction"
    When Operator logs of the portal
	
	
	
	# author : Prakash
  @CRM-REGRESSION @ChipsSOR @ChipsRegression @Chips @traceFiddler @TC-550003
  Scenario: Verify all the options present under account and Create Lead for user
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "mikejones" and "install12345!"
    Then Verify Operator name "Mike Jones"
    When CSR launches Demo Interaction for "Demo Pop - CONNOR"
    Then verify the toaster pop values for connor
    When CSR accepts the demo call
    Then verifiy left nav, header, composites, dialogs and other sections
    And verify Connor name and Interaction title and dialog
    And Verify all the details for "1234500078963456" Account number
    And verify the tabs in "Transaction" widget
    And verify the tabs in "Statements" widget
    When Click on Add Task to launch Service Process
    When Launch "Create Lead" service process
    Then verify that "Create Lead" flow is launched with dialog
    Then Select the Stage as "Assigned" and Rating as "1-Hot" and submit
    When confirm the changes made
    When user switches to "Overview" tab
    #Then verify "Assigned" and "1-Hot" are displayed in Lead tab under "Overview"
    When launch warpup to complete the interaction
    Then verify the wrapup dialog
    When complete the wrap up
    Then User will be navigated to the portal
    When Operator logs of the portal
	
	
	# author : Prakash
  @COMMENTCRM-REGRESSION @Smoke @TC-770704
  Scenario: Close Account flow with reason as competitor processing sub case from Recent cases widget
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "cacsr" and "install12345!"
    When CSR launches Demo Interaction for "Demo Pop - CONNOR"
    Then verify the toaster pop values for connor
    When CSR accepts the demo call
    Then verifiy left nav, header, composites, dialogs and other sections
    When Click on Add Task to launch Service Process
    Then Verify all the service process items and other fields
    When Launch "Close Account" service process
    Then verify "Close Account" flow is launched
    And verify Close Account dialog, header and question for connor
    When close the account with reason "Competitor" and comments "Close the account"
    Then verify the confirm screen for "Close Account"
    And Get the case ID from History and Attachments link
    And verify the dialog, status and changes
    And Verify the Status of " Enter reason for closing account  " is "Completed"
    When Confirm the flow
    Then check for completed or cancelled task "Close Account"
    And Verifiy Interaction tab and verify the corrosponding fields
    And verify the above interaction is displayed under recent cases widget
    And Veriy "Open" status is displayed for the case
    #When Select View Details for the case
    #Then Verify the fields displayed for "Close account"
    #When Click on cases button to naviage to Recent cases widget
    When Select the above created Case
    Then Verify "Close Account" subcase is displayed
    When Select "Close Account" sub case
    Then Verify the header and other deatis in close account page
    Then Submit the changes made
    And Verify the Status of "Close Account" is "Completed"
    When confirm the changes made
    Then Veriy "Resolved" status is displayed for the case
    When launch warpup to complete the interaction
    Then verify the wrapup dialog
    When complete the wrap up
    Then User will be navigated to the portal
    When Operator logs of the portal

  # author : Prakash
  @COMMENTCRM-REGRESSION @Smoke @TC-770705
  Scenario: Dispute transaction with amount low amount
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "cacsr" and "install12345!"
    When CSR launches Demo Interaction for "Demo Pop - CONNOR"
    Then verify the toaster pop values for connor
    When CSR accepts the demo call
    Then verifiy left nav, header, composites, dialogs and other sections
    When Click on Add Task to launch Service Process
    Then Verify all the service process items and other fields
    When Launch "Dispute Transaction" service process
    Then verify "Dispute Transaction" flow is launched
    Then verify that "Dispute Transaction" flow is launched with dialog
    When Select "1029" statement  and submit
    Then Verify Dialog, amount and In-progress task for "1029" statement
    When Select a dispute "Incorrect Charge" and submit
    Then Verify the confirm screen and inprogress task
    And Get the case ID from History and Attachments link
    And Verify the "Resolved-Completed" status displayed
    And Verify the Status of " Collect dispute details  " is "Completed"
    And Verify the Status of "Dispute Transaction" is "Resolved-Completed"
    When Confirm the Dispute transaction flow
    Then check for completed or cancelled task "Dispute Transaction"
    And Verifiy Interaction tab and verify the corrosponding fields
    And verify the above interaction is displayed under recent cases widget
    And Verify "1" count is for Dispute Transaction is displayed
    Then Veriy "Resolved" status is displayed for the case
    When launch warpup to complete the interaction
    Then verify the wrapup dialog
    When complete the wrap up
    Then User will be navigated to the portal
    When Operator logs of the portal