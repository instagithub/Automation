@smoke-pega-marketing
Feature: Smoke Test cases
# author : PM

Scenario: Create Multi channel campaign
    Given A User logs in with Analyst credentials
    When User opens Campaigns Landing Page
    Then "Campaigns" landing Page should be opened
    When User creates Multi-Channel Campaign
    Then Create a Campaign Page for MultiChannel Campaign should be displayed
    When User edits Multi-Channel Campaign with following data
      | Multi-Channel Campaign Name | Budget | Issue     | Group     |
      | DemoMultiChannelCampaign    |     -2 | DemoIssue | DemoGroup |
    When User saves the Campaign
    Then Campaign should be created and Saved
    When User edits the Campaign
    Then Save button should be Enabled for the Campaign
    When User configures Marketing Strategy
    Then Configure Marketing Strategy PopUp should be displayed
    When User searches for the Strategy "TestAutoStrategy81" in the Search for Marketing Startegy
    Then Strategy Search Results for "TestAutoStrategy81" should be displayed
    When User selects and adds strategy "TestAutoStrategy81" from displayed search results
    Then Strategy Details for the strategy should be displayed
    When User applies Strategy for Campaign
    Then Marketing Strategy Section should have the Strategy "TestAutoStrategy81" Added
    When User configures Audience
    Then Configure Audience PopUp should be displayed
    When User searches and adds the Segment "TestAutoSegment" in the Search for Audience
    Then Audience Search Results for segment "TestAutoSegment" should be displayed
    When User selects and adds Segment "TestAutoSegment" from Audience Search Results
    Then Audience Details should be displayed
    When User applies the Segment for campaign
    Then Audience Section should have the Segment "TestAutoSegment" Added
    When User configures Engagement
    Then Configure Engagement PopUp should be displayed
    When User checks Campaign Schedule
    Then Schedule Details should be displayed
    When User applies Engagement foe campaign
    Then Engagement Section should have the Schedule details Added
    Then User saves the Campaign
    Then Multi-Channel Campaign with Strategy should be Saved
    When User runs Multi-Channel Campaign
    Then Engagement details should be displayed
    When User confirms the Run Schedule
    Then Campaign should move to "Completed" Status
    