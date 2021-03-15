$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("salesautomation/features/BusinessTerritory.feature");
formatter.feature({
  "line": 2,
  "name": "Sales Automation Business Territory feature",
  "description": "Test covering the creation of Business Territory in Sales Automation",
  "id": "sales-automation-business-territory-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@businessterritory"
    },
    {
      "line": 1,
      "name": "@smoke"
    },
    {
      "line": 1,
      "name": "@smoke-sales-automation"
    }
  ]
});
formatter.scenarioOutline({
  "line": 9,
  "name": "create a Business Territory Hierarchy by Global Sales Ops",
  "description": "",
  "id": "sales-automation-business-territory-feature;create-a-business-territory-hierarchy-by-global-sales-ops",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 8,
      "name": "@TC-create-business-territory"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "User Navigates to Territories tab",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "User clicks on Create Territory button",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "verify that Business Territory New modal dialog is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "User enters the data for \"\u003cTerritory Name\u003e\" \"\u003cParent Territory\u003e\" \"\u003cOwner\u003e\" \"\u003cReservedForPartner\u003e\" and submits",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "verify that Business Territory with name \"\u003cTerritory Name\u003e\" and \"\u003cOwner\u003e\" is created",
  "keyword": "Then "
});
formatter.examples({
  "line": 16,
  "name": "",
  "description": "",
  "id": "sales-automation-business-territory-feature;create-a-business-territory-hierarchy-by-global-sales-ops;",
  "rows": [
    {
      "cells": [
        "Territory Name",
        "",
        "Parent Territory",
        "",
        "Owner"
      ],
      "line": 17,
      "id": "sales-automation-business-territory-feature;create-a-business-territory-hierarchy-by-global-sales-ops;;1"
    },
    {
      "cells": [
        "South East",
        "",
        "Global",
        "",
        "Terry Mason"
      ],
      "line": 18,
      "id": "sales-automation-business-territory-feature;create-a-business-territory-hierarchy-by-global-sales-ops;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 169944502600,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "User logs in to SA Application as salesops",
  "keyword": "Given "
});
formatter.match({
  "location": "CRMBrowser.user_logs_in_to_SA_Application_as_salesops()"
});
formatter.result({
  "duration": 31866963400,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "create a Business Territory Hierarchy by Global Sales Ops",
  "description": "",
  "id": "sales-automation-business-territory-feature;create-a-business-territory-hierarchy-by-global-sales-ops;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@smoke"
    },
    {
      "line": 8,
      "name": "@TC-create-business-territory"
    },
    {
      "line": 1,
      "name": "@smoke-sales-automation"
    },
    {
      "line": 1,
      "name": "@businessterritory"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "User Navigates to Territories tab",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "User clicks on Create Territory button",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "verify that Business Territory New modal dialog is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "User enters the data for \"South East\" \"Global\" \"Terry Mason\" \"\u003cReservedForPartner\u003e\" and submits",
  "matchedColumns": [
    0,
    2,
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "verify that Business Territory with name \"South East\" and \"Terry Mason\" is created",
  "matchedColumns": [
    0,
    4
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "BusinessTerritory.user_Navigates_to_Territories_tab_to_Create_Territories()"
});
formatter.result({
  "duration": 300107969200,
  "error_message": "com.pega.exceptions.PegaElementNotFoundException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//span[text()\u003d\u0027Territories\u0027]\"}\n  (Session info: chrome\u003d89.0.4389.82)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-4GOC9V2\u0027, ip: \u0027192.168.29.157\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_281\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 89.0.4389.82, chrome: {chromedriverVersion: 89.0.4389.23 (61b08ee2c5002..., userDataDir: C:\\Users\\KARTHI~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:58102}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:largeBlob: true, webauthn:virtualAuthenticators: true}\nSession ID: b3b36a88e714966d8b1fd9c67608b064\n*** Element info: {Using\u003dxpath, value\u003d//span[text()\u003d\u0027Territories\u0027]}\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-4GOC9V2\u0027, ip: \u0027192.168.29.157\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_281\u0027\nDriver info: driver.version: unknown\r\n\tat com.pega.framework.WaitHandlerImpl.waitForElementPresence(WaitHandlerImpl.java:217)\r\n\tat com.pega.framework.WaitHandlerImpl.waitForElementPresence(WaitHandlerImpl.java:206)\r\n\tat com.pega.framework.PegaWebDriverImpl.findElement(PegaWebDriverImpl.java:83)\r\n\tat com.pega.page.TopDocumentImpl.findElement(TopDocumentImpl.java:50)\r\n\tat com.pega.page.TopDocumentImpl.findElement(TopDocumentImpl.java:55)\r\n\tat com.pega.crm.customerservice.tiles.impl.PegaLeftNav.getTerritoriesList(PegaLeftNav.java:150)\r\n\tat com.pega.crm.salesautomation.stepdefs.BusinessTerritory.user_Navigates_to_Territories_tab_to_Create_Territories(BusinessTerritory.java:73)\r\n\tat ✽.When User Navigates to Territories tab(salesautomation/features/BusinessTerritory.feature:10)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "BusinessTerritory.user_clicks_on_Create_Territory_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "BusinessTerritory.verify_that_Business_Territory_New_modal_dialog_is_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "South East",
      "offset": 26
    },
    {
      "val": "Global",
      "offset": 39
    },
    {
      "val": "Terry Mason",
      "offset": 48
    },
    {
      "val": "\u003cReservedForPartner\u003e",
      "offset": 62
    }
  ],
  "location": "BusinessTerritory.user_enters_the_data_and_submits(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "South East",
      "offset": 42
    },
    {
      "val": "Terry Mason",
      "offset": 59
    }
  ],
  "location": "BusinessTerritory.verify_that_Business_Territory_is_created(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 8231892100,
  "status": "passed"
});
});