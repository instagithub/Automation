@SALogin @SA-REGRESSION @CRMALL
 Feature: Login test cases for SA [Owner: Amit Chaturvedi]

  # author : Shiva
   @SFA-smoke @TC-102881 @Smoke @CRM-SMOKE
  Scenario Outline: Login to the portal as SALES OPERATOR
    Given a user is logged into application with "<UserName>" and "Abcd@123"
    Given navigates to "Dashboard" List page
    Then User will have be logged into the portal with "<Title>"
    Then Verify Left Nav links for "<UserName>"
    When user navigates to MyWork page
    Then user should see all the tabs
    
    Examples:
    |UserName| 				|Title|
    |sfasalesops|	|SFA SalesOps|
    |tmason|		|Terry Mason|
    |skendall|		|Sarah kendall|
	
	