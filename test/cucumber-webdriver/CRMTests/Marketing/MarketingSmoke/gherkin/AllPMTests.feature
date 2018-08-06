Feature: Creation of Criteria Segment

  @Shippable 
  Scenario: Create Basic Criteria Segment
  
    Given A User logs in with Analyst credentials
    When User expands Audiences
    And Opens Segments landing page
    And User creates segment by clicking on Create button
    Then Segment name, Issue, Group, Segment Subject, Type and Analysis Project fields should be present
    When User enters "TestSegment" as segment name and selects "DemoIssue" as Issue and "DemoGroup" as Group
    And Creates and opens the segment
    Then Segment rule should be created
    And Segment rule should have Design tab, Options and Schedule tab and History tab
    And Visualization mode buttons should be present in Design tab
    When User switches to "Options and Schedule" tab in segment
    Then All fields headings such as Data Options, Sampled Segment Options and etc should be present
    When User switches to "Design" tab in segment
    And Adds a group and criteria as "SegmentCriteria" and value as "Auto"
    And User saves the segment rule
    Then Segment rule should be saved succesfully
    When User runs the Segment
    Then Stop link should be available to stop the run
    And End of the run, Population count should become "3"

 	@Shippable
  Scenario: Create an Email Treatment
    
    Given A User logs in with Analyst credentials
    When User expands Content from the Left Nav
    And Opens Treatment landing page
    Then Treatment landing Page should be displayed
    And Issue/Group, Search, View, Create, Help, Email, SMS, Sections, Paragraphs fields should be available
    When User creates Email treatment
    And User enters "TestEmailTreatment" as Email Treatment Name
    And selects "DemoIssue" as Issue and "DemoGroup" as Group for Email Treatment
    And Creates and opens the Email Treatment 
    Then Email Treatment Rule should be opened
    And Treatment, Test Message, Prompts, Pages and classes, Security and History tabs should be available
    And Subject and Key Code fields should be available
    And Edit Mode, Pick email Template, Load Template from File, View, Desktop and Mobile buttons should be available
    When User enters "TestEmailTreatment" in the Subject field
    And Enters "TestEmailKeyCode" in KeyCode field
    And Opens Email Editor
    And Enters "EmailTreatmentCriteria" in the Editor
    And Saves the Treatment
    Then Checkout button should appear   
  


  @Shippable
  Scenario: Create Multi channel campaign
    
    Given A User logs in with Analyst credentials
    When User opens Campaigns Landing Page
    Then "Campaigns" landing Page should be opened
    When User creates Multi-Channel Campaign
    Then Create a Campaign Page for MultiChannel Campaign should be displayed
    When User edits Multi-Channel Campaign with following data
      | Multi-Channel Campaign Name | Budget | Issue     | Group     |
      | DemoMultiChannelCampaign      |     -2 | DemoIssue | DemoGroup |
    And User saves the Campaign
    Then Campaign should be created and Saved
    When User edits the Campaign
    Then Save button should be Enabled for the Campaign
    When User configures Marketing Strategy
    Then Configure Marketing Strategy PopUp should be displayed
    When User searches for the Strategy "DemoStrategy" in the Search for Marketing Startegy
    Then Strategy Search Results for "DemoStrategy" should be displayed
    When User selects and adds strategy "DemoStrategy" from displayed search results
    Then Strategy Details for the strategy should be displayed
    When User applies Strategy for Campaign
    Then Marketing Strategy Section should have the Strategy "DemoStrategy" Added
    When User configures Audience
    Then Configure Audience PopUp should be displayed
    When User searches and adds the Segment "DemoSegment" in the Search for Audience
    Then Audience Search Results for segment "DemoSegment" should be displayed
    When User selects and adds Segment "DemoSegment" from Audience Search Results
    Then Audience Details should be displayed
    When User applies the Segment for campaign
    Then Audience Section should have the Segment "DemoSegment" Added
    When User configures Engagement
    Then Configure Engagement PopUp should be displayed
    When User checks Campaign Schedule
    Then Schedule Details should be displayed
    When User applies Engagement foe campaign
    Then Engagement Section should have the Schedule details Added
    And User saves the Campaign
    Then Multi-Channel Campaign with Strategy should be Saved
    When User runs Multi-Channel Campaign
    Then Engagement details should be displayed
    When User confirms the Run Schedule
    Then Campaign should move to "Scheduled" Status
    And Campaign should move to "Running" Status
    And Campaign should move to "Completed" Status

  @Shippable @Offer
  Scenario: Create an Email Offer Flow
    
    Given A User logs in with Analyst credentials
    When User expands Content from the Left Nav
    And Opens Offers landing page
    Then Offers landing Page should be displayed
    And Issue/Group, Search, View, Create, Help fields should be available
    When User creates offer
    And User enters "TestOffer" as Offer Name
    And selects "DemoIssue" as Offer Issue and "DemoGroup" as Offer Group
    And Clicks on Create and Open button in Offer Page
    Then Offer Rule should be opened
    And Diagram, Details, Test Offer and History tabs should be available
    When user deletes the existing start connector
    And adds a new send email shape to the offer at point "-450","0" in the offer
    And opens the properties of send email shape with name "Send Email"
    And renames the send email shape as "SendEmail"
    And sets the treatment as "DemoEmailTreatment"
    And sets the email account as "Default"
    And submits the properties
    And connects the start shape to the send email shape
    And connects the send email shape to the end shape
    And Saves the Offer
    Then the offer should be saved and checkout button should be visible
    
  @Shippable
  Scenario: Creation of Strategy from Strategy Designer page
  
    Given A User logs in with Analyst credentials
    When User expands Intelligence and navigates to Strategies
    When User opens Strategies from PMPortal
    And User creates a strategy using guide me through it
    And User enters strategy name and description as "Strategy"
    And User configures the Objective of strategy as Ranked
    Then User verfies Ranked Objective is added
    When User applies configure modal dialog
    And User selects Business Issue as "DemoIssue"
    And User selects Group as "DemoGroup"
    And User selects Audience Driven targeting approach
    And User configure Audience and add segment with name as "DemoSegment"
    Then User verifies that segment is added
    When User applies configure modal dialog
    And User assigns an offer with name as "DemoEmailOffer"
    Then Verify that offer is added
    When User applies configure modal dialog
    And User saves the strategy