Feature: Login for CAManager

  # author : Murali
  @CS-smoke 
  Scenario: Login to the portal as CAManager
    Given a user is on login page of the Portal
    When User enters loginName and password of CAManager
    Then User will be logged in to the portal
    Then Verify Operator name of Manager
    Then Verify Left Nav links in the dashboard
    When User navigates to the Manager tools
    Then Verify sections in there
    When User navigates to Dashboard
    Then Verify other widgets
    When CSManager logout of the portal
