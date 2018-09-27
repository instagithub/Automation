$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/CSSmokeTest.feature");
formatter.feature({
  "line": 2,
  "name": "CS Smoke Test cases",
  "description": "",
  "id": "cs-smoke-test-cases",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@CRMALL"
    },
    {
      "line": 1,
      "name": "@CSSMOKECASES"
    }
  ]
});
formatter.before({
  "duration": 6446597101,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 22,
      "value": "# author : Prakash"
    }
  ],
  "line": 24,
  "name": "Create new contact and run update contact profile",
  "description": "",
  "id": "cs-smoke-test-cases;create-new-contact-and-run-update-contact-profile",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 23,
      "name": "@TC-002"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "a user is on login page of CS Portal",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "CS operator logs in to the portal \"mikejones\" and \"install12345!\"",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Verify Operator name \"Mike Jones\"",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "CSR launched the New Phone Interaction",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "Search for the Customer with Contact Name \"testcontact_name\"",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "verify no contact is present and create new contact option is available",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "CSR opens the create contact flow",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "Enter mandatory fields \"New Contact FN\" and \"New Contact LN\" and \"testcontactmailid\" and submit",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Click on Add Task to launch Service Process",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "Launch \"Update Contact Profile\" service process",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "select the verification questions for service cases and click on verified",
  "keyword": "When "
});
formatter.step({
  "line": 36,
  "name": "update DOB \"01/07/1990\" and Gender \"M\" and Marital Status \"Single\"",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "update the primary address",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "update communication preference method \"Mail\" time \"8am-10am\" and language to \"English\"",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 39,
      "value": "#Then update notification to \"Email\""
    }
  ],
  "line": 40,
  "name": "Submit the changes made",
  "keyword": "Then "
});
formatter.step({
  "line": 41,
  "name": "confirm the changes made",
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "launch warpup to complete the interaction",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "verify the wrapup dialog",
  "keyword": "Then "
});
formatter.step({
  "line": 44,
  "name": "complete the wrap up",
  "keyword": "When "
});
formatter.step({
  "line": 45,
  "name": "User will be navigated to the portal",
  "keyword": "Then "
});
formatter.step({
  "line": 46,
  "name": "Operator logs of the portal",
  "keyword": "When "
});
formatter.match({
  "location": "MyBrowser.open()"
});
formatter.result({
  "duration": 684010091,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "mikejones",
      "offset": 35
    },
    {
      "val": "install12345!",
      "offset": 51
    }
  ],
  "location": "MyBrowser.loginToCSPortal(String,String)"
});
formatter.result({
  "duration": 14769574851,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mike Jones",
      "offset": 22
    }
  ],
  "location": "MyBrowser.verify_Operator_name(String)"
});
formatter.result({
  "duration": 27164035,
  "status": "passed"
});
formatter.match({
  "location": "TopNavFixture.csr_launched_the_New_Phone_Interaction()"
});
formatter.result({
  "duration": 12651124356,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testcontact_name",
      "offset": 43
    }
  ],
  "location": "PhoneCallFixture.search_for_the_Customer_with_Contact_Name(String)"
});
formatter.result({
  "duration": 8306771372,
  "status": "passed"
});
formatter.match({
  "location": "CSSmoke.verify_no_contact_is_present_and_create_new_contact_option_is_available()"
});
formatter.result({
  "duration": 389787805,
  "status": "passed"
});
formatter.match({
  "location": "CSSmoke.csr_opens_the_create_contact_flow()"
});
formatter.result({
  "duration": 2362858254,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "New Contact FN",
      "offset": 24
    },
    {
      "val": "New Contact LN",
      "offset": 45
    },
    {
      "val": "testcontactmailid",
      "offset": 66
    }
  ],
  "location": "CSSmoke.enter_mandatory_fields_and_and_and_submit(String,String,String)"
});
formatter.result({
  "duration": 19084645058,
  "status": "passed"
});
formatter.match({
  "location": "PhoneCallFixture.click_on_Add_Task_to_launch_Service_Process()"
});
formatter.result({
  "duration": 5271734437,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Update Contact Profile",
      "offset": 8
    }
  ],
  "location": "PhoneCallFixture.launch_service_process(String)"
});
formatter.result({
  "duration": 36654674435,
  "status": "passed"
});
formatter.match({
  "location": "PhoneCallFixture.select_the_verification_questions_for_service_cases_and_click_on_verified()"
});
formatter.result({
  "duration": 207215979,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "01/07/1990",
      "offset": 12
    },
    {
      "val": "M",
      "offset": 36
    },
    {
      "val": "Single",
      "offset": 59
    }
  ],
  "location": "CSSmoke.update_DOB_and_Gender_and_Marital_Status(String,String,String)"
});
formatter.result({
  "duration": 11576776899,
  "status": "passed"
});
formatter.match({
  "location": "CSSmoke.update_the_primary_address()"
});
formatter.result({
  "duration": 17335122049,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mail",
      "offset": 40
    },
    {
      "val": "8am-10am",
      "offset": 52
    },
    {
      "val": "English",
      "offset": 79
    }
  ],
  "location": "CSSmoke.update_communication_preference_method_time_and_language_to(String,String,String)"
});
formatter.result({
  "duration": 13823924438,
  "status": "passed"
});
formatter.match({
  "location": "CSSmoke.submit_the_changes_made()"
});
formatter.result({
  "duration": 37237679565,
  "status": "passed"
});
formatter.match({
  "location": "PhoneCallFixture.confirm_the_changes_made()"
});
formatter.result({
  "duration": 33874613812,
  "status": "passed"
});
formatter.match({
  "location": "PhoneCallFixture.launch_warpup_to_complete_the_interaction()"
});
formatter.result({
  "duration": 10672897084,
  "status": "passed"
});
formatter.match({
  "location": "PhoneCallFixture.verify_the_wrapup_dialog()"
});
formatter.result({
  "duration": 43760,
  "status": "passed"
});
formatter.match({
  "location": "PhoneCallFixture.complete_the_wrap_up()"
});
formatter.result({
  "duration": 7584557901,
  "status": "passed"
});
formatter.match({
  "location": "MyBrowser.user_will_be_navigated_to_the_portal()"
});
formatter.result({
  "duration": 61352013,
  "status": "passed"
});
formatter.match({
  "location": "MyBrowser.csr_logout_of_the_portal()"
});
formatter.result({
  "duration": 948374148,
  "status": "passed"
});
formatter.after({
  "duration": 494002244,
  "status": "passed"
});
formatter.after({
  "duration": 5773992485,
  "status": "passed"
});
});