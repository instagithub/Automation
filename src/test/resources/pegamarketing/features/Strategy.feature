@smoke-pega-marketing
Feature: Smoke Test cases
# author : PM

Scenario: Creation of Strategy from Strategy Designer page
    Given A User logs in with Analyst credentials
    When User expands Intelligence and navigates to Strategies
    When User opens Strategies from PMPortal
    When User creates a strategy using guide me through it
    When User enters strategy name and description as "DemoStrategy"
    When User configures the Objective of strategy as Ranked
    Then User verfies Ranked Objective is added
    When User applies configure modal dialog
    When User selects Business Issue as "DemoIssue"
    When User selects Group as "DemoGroup"
    When User selects Audience Driven targeting approach
    When User configure Audience and add segment with name as "TestAutoSegment"
    When User applies configure modal dialog
    When User assigns an offer with name as "TestEmailOffer"
    When User applies configure modal dialog
    When User saves the strategy