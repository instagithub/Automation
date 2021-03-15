$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("salesautomation/features/PersonalEdition.feature");
formatter.feature({
  "line": 2,
  "name": "Personal edition scenarios",
  "description": "",
  "id": "personal-edition-scenarios",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@PELogin"
    }
  ]
});
formatter.before({
  "duration": 5679231800,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Submitting a Job Application",
  "description": "",
  "id": "personal-edition-scenarios;submitting-a-job-application",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@TC-JobApplication"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User logs in to Application as Recruiter",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "navigates to \"Job Application\" List page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "user enters Application details",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user Reviews Application",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user will logout",
  "keyword": "And "
});
formatter.match({
  "location": "CRMBrowser.user_logs_in_to_Application_as_Recruiter()"
});
formatter.result({
  "duration": 5044798500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Job Application",
      "offset": 14
    }
  ],
  "location": "CRMBrowser.navigates_to_page(String)"
});
formatter.result({
  "duration": 47615883300,
  "status": "passed"
});
formatter.match({
  "location": "CRMBrowser.user_enters_Application_details()"
});
formatter.result({
  "duration": 252106203300,
  "status": "passed"
});
formatter.match({
  "location": "CRMBrowser.user_Reviews_Application()"
});
formatter.result({
  "duration": 67309967900,
  "status": "passed"
});
formatter.match({
  "location": "CRMBrowser.user_will_logout()"
});
formatter.result({
  "duration": 40809900600,
  "status": "passed"
});
formatter.after({
  "duration": 6112159400,
  "status": "passed"
});
});