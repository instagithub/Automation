@PELogin
Feature: Personal edition scenarios

 @TC-JobApplication
  Scenario: Submitting a Job Application
  	Given User logs in to Application as Recruiter
  	Given navigates to "Job Application" List page
  	Then user enters Application details
  	Then user Reviews Application
  	And user will logout
    
@TC-ExpenseReport
Scenario: Submitting an Expense Report
  	Given User logs in to Application as Recruiter
  	Given navigates to "Expense Report" List page
  	Then user enters expense details
  	Then user creates task and submits report
  	And user will logout