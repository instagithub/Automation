@LOGIN
@CS-Regression2
Feature: PegaExpress Test cases [Owner: Priyanka]

  # author : Murali
  @DevOps @CS-Smoke @Smoke @traceFiddler @TC-99990
  Scenario: Login to the portal as CACSR
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "cacsr" and "install12345!"
    Then Verify Operator name "CS CSR"
    Then User will be navigated to the portal
    Then Verify Left Nav links
    Then Verify all other widgets
    When Operator logs of the portal

  # author : Murali
  @Smoke @TC-99991 
  Scenario: Login to the portal as CAManager
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "camanager" and "install12345!"
    Then Verify Operator name "CA Manager"
    Then User will be navigated to the portal
    Then Verify Left Nav links
    When User navigates to the Manager tools
    Then Verify sections in there
    When User navigates to Dashboard
    Then Verify all other widgets
   When Operator logs of the portal

  # author : Prakash
  @Smoke @TC-99992
  Scenario: Login to the portal as CASysAdmin
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "gundv" and "install"
    #Then Verify Operator name "CA Sys Admin"
    #Then Verify the top Nav links for sys admin
    When Click on switch to Express Mode
    When log of the portal as operator

  # author : Prakash
  @DevOps @CS-Smoke @Smoke @TC-99993
  Scenario: Login to the portal as mikejones
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "mikejones" and "install12345!"
    Then Verify Operator name "mikejones"
    Then Verify Left Nav links for mikejones
    When Operator logs of the portal

  # author : Prakash
  @DevOps @CS-Smoke @Smoke @TC-99994
  Scenario: Login to the portal as dpercival
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "dpercival" and "install12345!"
    Then Verify Operator name "Dan Percival"
    Then Verify the top Nav links
    When Operator logs off automation portal

  # author : Murali
  @DevOps @CS-Smoke @Smoke @TC-99995
  Scenario: Login to the portal as BOUser
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "bouser" and "install12345!"
    Then Verify Operator name "Back office user "
    Then User will be navigated to the portal
    Then Verify Left Nav links
    When User navigates to the Manager tools
    Then Verify sections in there
    When User navigates to Dashboard
    Then Verify all other widgets
    Then Operator logs of the social portal

  # author : Murali
  @Smoke @TC-99996
  Scenario: Login to the portal as BOManager
    Given a user is on login page of CS Portal
    When CS operator logs in to the portal "bomanager" and "install12345!"
    Then Verify Operator name "Back office manager "
    Then User will be navigated to the portal
    Then Verify Left Nav links
    When User navigates to the Manager tools
    Then Verify sections in there
    When User navigates to Dashboard
    Then Verify all other widgets
    Then Operator logs of the social portal
