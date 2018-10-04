@shippable 
Feature: PegaMarketing Selenium Shippable Tests
  
  Scenario: Create Basic Criteria Segment
    Given A User logs in with Analyst credentials
    When User expands Audiences
    When Opens Segments landing page
    When User creates segment by clicking on Create button
    Then Segment name, Issue, Group, Segment Subject, Type and Analysis Project fields should be present
    When User enters "TestSegment" as segment name and selects "DemoIssue" as Issue and "DemoGroup" as Group
    When Creates and opens the segment
    Then Segment rule should be created
    Then Segment rule should have Design tab, Options and Schedule tab and History tab
    Then Visualization mode buttons should be present in Design tab
    When User switches to "Options and Schedule" tab in segment
    Then All fields headings such as Data Options, Sampled Segment Options and etc should be present
    When User switches to "Design" tab in segment
    When Adds a group and criteria as "SegmentCriteria" and value as "M"
    When User saves the segment rule
    Then Segment rule should be saved succesfully
    When User runs the Segment
    #Then Stop link should be available to stop the run
    Then End of the run, Population count should become "2,570"

  Scenario: Create an Email Treatment
    Given A User logs in with Analyst credentials
    When User expands Content from the Left Nav
    When Opens Treatment landing page
    Then Treatment landing Page should be displayed
    Then Issue/Group, Search, View, Create, Help, Email, SMS, Sections, Paragraphs fields should be available
    When User creates Email treatment
    When User enters "TestEmailTreatment" as Email Treatment Name
    When selects "DemoIssue" as Issue and "DemoGroup" as Group for Email Treatment
    When Creates and opens the Email Treatment
    Then Email Treatment Rule should be opened
    Then Treatment, Test Message, Prompts, Pages and classes, Security and History tabs should be available
    Then Subject and Key Code fields should be available
    Then Edit Mode, Pick email Template, Load Template from File, View, Desktop and Mobile buttons should be available
    When User enters "TestEmailTreatment" in the Subject field
    When Enters "TestEmailKeyCode" in KeyCode field
    When Opens Email Editor
    When Enters "EmailTreatmentCriteria" in the Editor
    When Saves the Treatment
    Then Checkout button should appear

  Scenario: Create an Email Offer Flow
    Given A User logs in with Analyst credentials
    When User expands Content from the Left Nav
    When Opens Offers landing page
    Then Offers landing Page should be displayed
    Then Issue/Group, Search, View, Create, Help fields should be available
    When User creates offer
    When User enters "TestOffer" as Offer Name
    When selects "DemoIssue" as Offer Issue and "DemoGroup" as Offer Group
    When Clicks on Create and Open button in Offer Page
    Then Offer Rule should be opened
    Then Diagram, Details, Test Offer and History tabs should be available
    When user deletes the existing start connector
    When adds a new send email shape to the offer at point "-450","0" in the offer
    When opens the properties of send email shape with name "Send Email"
    When renames the send email shape as "SendEmail"
    When sets the treatment as "TestAutoEmailTreatment021343"
    When sets the email account as "Default"
    When submits the properties
    When connects the start shape to the send email shape
    When connects the send email shape to the end shape
    When Saves the Offer
    Then the offer should be saved and checkout button should be visible
   
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
    #Then User verifies that segment is added
    When User applies configure modal dialog
    When User assigns an offer with name as "TestAutoEmailOffer"
    #Then Verify that offer is added
    When User applies configure modal dialog
    When User saves the strategy
     
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
    Then Campaign should move to "Scheduled" Status
    Then Campaign should move to "Running" Status
    Then Campaign should move to "Completed" Status