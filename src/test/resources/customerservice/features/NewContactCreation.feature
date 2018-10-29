@newcontact @smoke @smoke-customer-service
Feature: New Contact Creation Test cases

  # author : Prakash
  @TC-createcontact
  Scenario: Create new contact and run update contact profile
    Given a user is on login page of CS Portal
    When User logs in to CS portal as mikejones
    When CS operator logs in to the portal "mikejones" and "install12345!"
    Then Verify Operator name "Mike Jones"
    When CSR launched the New Phone Interaction
    When Search for the Customer with Contact Name "testcontact_name"
    Then verify no contact is present and create new contact option is available
    When CSR opens the create contact flow
    Then Enter mandatory fields "New Contact FN" and "New Contact LN" and "testcontactmailid" and submit
    When Click on Add Task to launch Service Process
    When Launch "Update Contact Profile" service process
    When select the verification questions for service cases and click on verified
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