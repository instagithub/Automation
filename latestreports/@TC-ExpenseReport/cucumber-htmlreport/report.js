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
  "duration": 5667873100,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Submitting an Expense Report",
  "description": "",
  "id": "personal-edition-scenarios;submitting-an-expense-report",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@TC-ExpenseReport"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "User logs in to Application as Recruiter",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "navigates to \"Expense Report\" List page",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "user enters expense details",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "user creates task and submits report",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "user will logout",
  "keyword": "And "
});
formatter.match({
  "location": "CRMBrowser.user_logs_in_to_Application_as_Recruiter()"
});
formatter.result({
  "duration": 3581419800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Expense Report",
      "offset": 14
    }
  ],
  "location": "CRMBrowser.navigates_to_page(String)"
});
formatter.result({
  "duration": 11753078900,
  "error_message": "org.openqa.selenium.ElementNotInteractableException: element not interactable\n  (Session info: chrome\u003d88.0.4324.190)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-VKREOAL\u0027, ip: \u0027192.168.1.42\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_121\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 88.0.4324.190, chrome: {chromedriverVersion: 88.0.4324.96 (68dba2d8a0b14..., userDataDir: C:\\Users\\KALYAN~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:52184}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: 3fc0bcb4bcd511a17034681f4c166a95\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\r\n\tat com.pega.framework.PegaWebElementImpl.click(PegaWebElementImpl.java:500)\r\n\tat com.pega.framework.PegaWebElementImpl.click(PegaWebElementImpl.java:402)\r\n\tat com.pega.crm.customerservice.tiles.impl.PegaLeftNav.launchExpenseReport(PegaLeftNav.java:210)\r\n\tat com.pega.CRMBrowser.navigates_to_page(CRMBrowser.java:223)\r\n\tat ✽.Given navigates to \"Expense Report\" List page(salesautomation/features/PersonalEdition.feature:15)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "CRMBrowser.user_enters_expense_details()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CRMBrowser.user_creates_task_and_submits_report()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CRMBrowser.user_will_logout()"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 6538371900,
  "status": "passed"
});
});