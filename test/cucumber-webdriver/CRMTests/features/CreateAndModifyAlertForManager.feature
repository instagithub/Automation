Feature: Create and Modify Alert for CAManager

  # author : Aakash
  @CS-smoke @TC-000008
  
  Scenario: Create and Modify Alert for CAManager
    Given Manager is on login page of the Portal
    When User enters login Name and password of CAManager and click on login
    Then USER will be log in to the portal
    When User will click on the New Message in Home page
    Then A dialogue will open for creating alert
    When User add Manager from Reporting WorkGroups and Create alert with required fields
    
    	|startDate|2/15/2016          |
    	|endDate  |3/15/2016          |
    	|title    |Demo Alert         |
    	|message  |Demo Alert Message1|
    Then Verify added alert is visible under Messages & Alerts
    When User double-click on the Alert
    Then A dialogue will open for modifying alert 
    When User modifies "end date" Alert data and click on Modify Alert and refreshes Message & Alerts
    
    	|startDate|2/17/2016                   |
    	|endDate  |3/18/2016                   |
    	|title    |Demo Alert Modified         |
    	|message  |Demo Alert Message1 Modified|
    	
    Then Verify modifications in Alert
    When User will double-click on the Alert
    Then dialogue will open to modify alert
    When User clicks on Delete Alert and refreshes Message & Alerts
    Then Verify created alert is deleted
    