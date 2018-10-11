@forecast @smoke @smoke-sales-automation

Feature: Forecast Close Plans
  Close Plans provide updates summarizing accomplishments for the current week and upcoming plans

Scenario: Search by organization
  Given a sales rep is at the Close Plans page
  When the rep searches for "APW Technologies Corp" organization
  Then opportunities related only to "APW Technologies" are shown
	