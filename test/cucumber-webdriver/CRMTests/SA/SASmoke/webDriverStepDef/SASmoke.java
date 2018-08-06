package webDriverStepDef;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.ri.Wizard;
import com.pega.MyBrowser;
import com.pega.cs.SFAPortal;
import com.pega.cs.tiles.LeftNav;
import com.pega.sfa.workobjects.AccountList;
import com.pega.sfa.workobjects.Accounts;
import com.pega.sfa.workobjects.Activity;
import com.pega.sfa.workobjects.Contact;
import com.pega.sfa.workobjects.ContactList;
import com.pega.sfa.workobjects.Households;
import com.pega.sfa.workobjects.HouseholdList;

import com.pega.sfa.workobjects.Leads;
import com.pega.sfa.workobjects.LeadsList;
import com.pega.sfa.workobjects.Operator;
import com.pega.sfa.workobjects.OperatorList;
import com.pega.sfa.workobjects.Opportunity;
import com.pega.sfa.workobjects.OpportunityList;
import com.pega.sfa.workobjects.PartnersList;
import com.pega.sfa.workobjects.Partners;


import com.pega.sfa.workobjects.OrganizationsList;
import com.pega.sfa.workobjects.Organization;
import com.pega.sfa.workobjects.ClosePlans;


import com.pega.sfa.workobjects.Relationship;
import com.pega.sfa.workobjects.Tasks;
import com.pega.sfa.workobjects.Territories;
import com.pega.sfa.workobjects.TerritoriesList;

import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class SASmoke
{

	String OPP_SOURCE = "Customer Referral";
	String OPP_SHORTNAME = "Auto_oppty";
	private SFAPortal sfaPortal =null;
	private TestEnvironment testEnv;
	private MyBrowser browser;
	private PegaWebDriver pegaDriver;
	Opportunity opp;
	Organization organization, org;
	
	OpportunityList oppList;
	OrganizationsList orgList,organizationList,orgResult;
	LeadsList leadlist;
	Tasks task;
	Activity activity;
	public static String Subject=null; 
	String OPP_CLONE_BUSINESS_NAME="Automation opp for business cloned";
	String OPP_CLONE_INDIVIDUAL_NAME= "Automation opp for individual cloned";
	String OPP_BUSINESS_NAME= "Automation opp for business";
	String OPP_INDIVIDUAL_NAME= "Automation opp for individual";
	String OPP_UPDATEDAMOUNT="54123";
	String OPP_UPDATEDFORECAST= "Upside";
	String OPP_UPDATEDOWNER="Anna Parker";
	String OPP_UPDATE_CONTACTS="Annabelle Boord";
	String OPP_UPDATEDSOURCE ="Employee Referral";
	String OPP_CLONEAMOUNT="58000";
	String OPP_PLACEHOLDER="Filter opportunity";
	String OPP_FORECAST="Stretch";
	String OPP_AMOUNT="65400";
	String OPP_BUSINESS_CONTACT="Acme Software";
	String OPP_INDIVIDUAL_CONTACT="Kris Marrier";
	String OPP_TERRIORTY="Global";
	String OPP_STAGE="Qualification";
	String OPP_UPDATED_STAGE="Decision";
	String OPP_UPDATED_STAGE_FROMSUBTAB="Negotiation";
	String OPP_MERGE_DESCRIPTION="Merged as part of automation";
	String OPP_NAME_FOR_FOLLOW="Wireless Tri-Zone Sensors for John Smith";
	
	//String OPP_SUBTABS[]={"Details", "Contacts", "Leads", "Close plans","Activities", "Attachments", "Sales team"};
	String NewStage;
	String OPP_SUBTABS[]={"Pulse","Details", "Contacts", "Activities", "Leads", "Close plans", "Recent attachments", "Partner contacts","Sales Navigator"};
	
	
	List<String> OPP_LISTTABS = new ArrayList<String>(Arrays.asList(OPP_SUBTABS));
	String OPP_CHANGEREASON= "Owner is changed as part of automation testing";
	String OPP_CLOSE_COMMENTS="Closed as  we won the Opportunity";
	String OPP_CLOSE_REASON="Lost";
	String OPP_DESCRIPTION="Created as part of Automation scripts";
	String OPP_ACTIVITY_COMMUNICATIONTYPE="Phone";
	String OPP_ACTIVITY_OUTCOME="Outcome for the activity from Opportunity";
	
	String OPP_TASK_SUBJECT="Adding task to oppty";
	String OPP_TASK_TASKTYPE="Customer Communication";
	String OPP_TASK_PRIORITY="2-Medium";
	String OPP_TASK_STATUS="Not Started";
	String OPP_TASK_COMMENTS="Comments from oppty";
	static String OPP_DUE_DATE="4/30/2017";
	String TASKVALUES[]={OPP_TASK_SUBJECT, OPP_TASK_STATUS,OPP_DUE_DATE, "tmason", OPP_TASK_PRIORITY};
	List<String> OPP_TASKROWVALUES= new ArrayList<String>(Arrays.asList(TASKVALUES));
	String ACTIVITYVALUES[]={Subject, OPP_ACTIVITY_COMMUNICATIONTYPE,OPP_DUE_DATE, "Terry Mason"," "};
	List<String> OPP_ACTIVITYROWVALUES= new ArrayList<String>(Arrays.asList(ACTIVITYVALUES));
	String OPP_ID="";
	
	String OPP_TableHeader[]={"Name", "Account", "Stage", "Owner", "Amount"," ", "Close date", "Must win", "Territory","Source",""};
	List<String> OPP_LISTHEADER = new ArrayList<String>(Arrays.asList(OPP_TableHeader));
	String actual_name, actual_territory, actual_con, actual_amount, actual_closedate, actual_owner,actual_shortName, actual_source, actual_stage, actual_win, actual_Forecast, actual_description;
	
	@Inject
	public SASmoke(TestEnvironment testEnv, MyBrowser browser){
		this.testEnv = testEnv;
		this.browser = browser;
		pegaDriver=testEnv.getPegaDriver();
		sfaPortal = browser.getPortal(SFAPortal.class);
		this.leadlist=browser.leadList;
		this.organizationList=browser.orgList;
		
		//this.organization= browser.org
		//this.closeplans=browser.closeplans;
		this.oppList=browser.oppList;
		this.contList=browser.conList;
		this.householdlist=browser.hhList;
		this.accList=browser.accList;
		this.partList= browser.parList;
		
		CONT_FULLNAME= new StringBuffer("");
		CONT_FULLNAME= CONT_FULLNAME.append(CONT_FIRSTNAME);
		CONT_FULLNAME=CONT_FULLNAME.append(" ").append(CONT_LASTNAME);
		CONT_WORKEMAIL=CONT_FULLNAME+"@"+CONT_COMPANY+".com";
		if(browser.campaignExists)
			OPP_LISTHEADER.set(10,"Campaign");
	}
	

	//For Scenario: Creating a Opportunity for Business
	@When("^users clicks on Create OpprotunityButton and selects \"(.+)\"$")
	public void users_clicks_on_Create_OpprtunityButton(String opptype) throws InterruptedException 
	{
		if(opptype.equals("Business"))
		{
			opp=oppList.createBusniessOpportunity();
		}
		else if(opptype.equals("Individual"))
		{
			opp=oppList.createIndividualOpportunity();
		}
	   
	}
	
	//For Scenario: Creating a Opportunity for Business
	@When("^Enters all the mandatory data for \"(.+)\"$")
	public void enters_all_the_mandatory_data(String opptype) throws InterruptedException 
	{
		
		opp.setAmount(OPP_AMOUNT);
		opp.setDate();
		//opp.setTerritory(OPP_TERRIORTY);
		NewStage=opp.setStage(OPP_STAGE);
		opp.setForecastCategory(OPP_FORECAST);
		opp.setSource(OPP_SOURCE);
		opp.setShotName(OPP_SHORTNAME);
		opp.setDescrption(OPP_DESCRIPTION);
		opp.setOpptyMustWin();
		
		if(opptype.equals("Business"))
			{
				opp.setName(OPP_BUSINESS_NAME);
				opp.setContact(OPP_BUSINESS_CONTACT);
			}
		else
		{
			System.out.println("Opportunity type selection missing ");
		}
		opp.clickCreate();
		
	}
	
	
	//For Scenario: Creating a Opportunity for Business
	@Then("^\"(.+)\" Opportunity should be created$")
	public void Bussiness_opprtunity_should_be_created(String opptype)
	{
		
		actual_amount=opp.getAmount();
		actual_closedate=opp.getClosedate();
		actual_territory= opp.getTerritory();
		actual_shortName=opp.getShortName();
		actual_Forecast=opp.getForecast();
		actual_source=opp.getSource();
		actual_stage=opp.getStageForBusiness();
		actual_win=opp.getWin();
		Assert.assertEquals(actual_amount, OPP_AMOUNT);
		Assert.assertEquals(actual_shortName, OPP_SHORTNAME);
		Assert.assertEquals(actual_Forecast, OPP_FORECAST);
		Assert.assertEquals(actual_source, OPP_SOURCE);
		Assert.assertEquals(actual_stage, NewStage);
		Assert.assertEquals(actual_win, "Yes");
		if(opptype.equals("Business"))
		{
			actual_name=opp.getName();
			Assert.assertEquals(actual_name, OPP_BUSINESS_NAME);
			
		}
		 
	}
	
	@When("^user updates the stage and submit the changes$")
	public void user_updates_the_stage_and_submit_the_changes()
	{
		NewStage=opp.setStage(OPP_UPDATED_STAGE);
		opp.clickSubmitButton();
	}
	
	
	@Then("^opportunity should have all the tabs$")
	public void opportunityTabs()
	{
		ArrayList<String> subTabs= opp.getSubTabs();
		Assert.assertEquals(subTabs, OPP_LISTTABS);
		
	}
	
	@Then("^user should navigate to change stage page$")
	public void user_should_navigate_to_change_stage_page()
	{
		String sectionname=opp.getSectionHeader();
		Assert.assertEquals(sectionname.trim(), "Change stage");
	}
	
	@Then("^stage of the \"(.*?)\" opportunity should be changed$")
	public void stage_of_the_opportunity_should_be_changed(String opptype)
	{
		
		String Stage=null;
		
		if(opptype.equals("Business"))
		{
			Stage=opp.getStageForBusiness();
		}
		else if(opptype.equals("Individual"))
		{
			Stage=opp.getStageForIndividual();
		}
		 
		Assert.assertEquals(Stage.trim(), NewStage);
	}
	
	
	
	@When("^user opens the \"(.+)\" opportunity with \"(.+)\"$")
	public void user_opens_the_opportunity(String oppType, String OpptyName)
	{
		  
		   if(oppType.equals("Business"))
		   {
			   opp=oppList.navigateOpportunity(OpptyName);
		   }
		   else if(oppType.equals("Individual"))
		   {
			   opp=oppList.navigateOpportunity(OpptyName);
		   }		   
	}

	
	@When("^clicks on Close button for \"(.*?)\" Opportunity$")
	public void clicks_on_Close_button_for_Opportunity(String opptype) 
	{
		if(opptype.equals("Business"))
		{
			opp.clickCloseForBusiness();
		}
		else if(opptype.equals("Individual"))
		{
			opp.clickCloseForIndividual();
		}
			
	}

	@When("^user enters the reason for closing of opportunity and saves the changes$")
	public void user_enters_the_reason_for_closing_of_opportunity_and_saves_the_changes() 
	{

		opp.setCloseReason(OPP_CLOSE_REASON);
		opp.setCloseComments(OPP_CLOSE_COMMENTS);
		opp.clickSubmitButton();
	}

	@Then("^\"(.*?)\" opportunity should be closed$")
	public void opportunity_should_be_closed(String arg1)
	{
		Assert.assertTrue(opp.isActionItemValuePresent("Reactivate opportunity"));
		
	}

	@When("^clicks on Update Stage button$")
	public void clicks_on_Update_Stage_button()
	{
		opp.clickUpdateStage();
	}
	
	@When("^clicks on Update Stage button from Subtab$")
	public void clicks_on_Update_Stage_button_from_Subtab() 
	{
		opp.clickUpdateStagefromSubtab();
		
	}
	


	
	@When("^user updates the stage and submit the changes from subtab$")
	public void user_updates_the_stage_and_submit_the_changes_from()
	{
		
		NewStage=opp.setStage(OPP_UPDATED_STAGE_FROMSUBTAB);
		opp.clickSubmitButton();
	}
	
 @When("^user search for the \"([^\"]*)\" opportunity$")
	public void user_search_for_the_opportunity(String opptype) {
		oppList.switchToStageView();
		
		if(opptype.equals("Business"))
		{
			oppList.SwitchToBusinessTab();
			oppList.searchOpportunity(OPP_BUSINESS_NAME);
		}
		else if(opptype.equals("Individual"))
		{
			oppList.searchOpportunity(OPP_INDIVIDUAL_NAME);
		}
	    
	   
	}
 
 
 /*
  *  
  *  Lead Functions
  *  
  */
 
 	//String Subject = "abc";
	String LEAD_INDUSTRY="Communications";
	String LEAD_COMPANYNAME="VKgroup";
	String teritory="Global";					  
	String LEAD_LASTNAME_INDIVIDUAL="Automation Lead Individual";
	String LEAD_LASTNAME_BUSINESS="Automation lead Business";
	String LEAD_STAGE="Assigned";
	String LEAD_UPDATEDINDUSTRY="Entertainment";
	String LEAD_UPDATEDSTAGE="Sales Qualified";
	String LEAD_UPDATEDCOMPANY="CompanyUpdated";
	String LEAD_WORKHONE ="895462103";
	String LEAD_EMAIL ="abc@test.com";
	String LEAD_MOBILE= "123456";
	String LEAD_DESCRIPTION = "This is test data";
	String LEAD_TERRITORY="Global";
	String LEAD_UPDATEDOWNER="Anna Parker";
	String LEAD_CHANGEREASON="Changed as part of automation script";
	String LEAD_TASK_SUBJECT="Adding task to Lead";
	String LEAD_TASK_TASKTYPE = "Customer Communication";
	String LEAD_PLACEHOLDER="Filter lead";
	String LEAD_TableHeader[]={"Score","Name", "Company name", "Stage", "Create date", "Owner", "Territory", "Source","Days inactive"," "," "," "};
	List<String> LEAD_LISTHEADER = new ArrayList<String>(Arrays.asList(LEAD_TableHeader));
	
	String LEAD_SubTabs [] =  {"Pulse","Details","Recent attachments","Activities"};
	List<String> LEAD_WO_SUBTABS = new ArrayList<String>(Arrays.asList(LEAD_SubTabs));
	
 
 
 
 
 
 
 
 @When("^users clicks on Create LeadButton and selects \"(.*?)\"$")
	public void users_clicks_on_Create_LeadButton_and_selects(String LeadType)
	{
		if( LeadType.equals("Business"))
		{
			lead=leadlist.createBusinessLead();
		}
		else if(LeadType.equals("Individual"))
		{
			lead=leadlist.createIndividualLead();
		} 

	}
 
 
 @When("^Enters all the mandatory Lead data for \"(.*?)\"$")
	public void Enters_all_the_mandatory_data(String LeadType) 
	{

		if(LeadType.equals("Business"))
		{
			lead.setLastName(LEAD_LASTNAME_BUSINESS);
			lead.setCompany(LEAD_COMPANYNAME);
			lead.setIndustry(LEAD_INDUSTRY);
		}

		else if(LeadType.equals("Individual"))
		{
			lead.setLastName(LEAD_LASTNAME_INDIVIDUAL);
			
		}	
		
		lead.setStage(LEAD_STAGE);
		//lead.setTerritory(LEAD_TERRITORY);
		lead.clickOK();
		
	}
 
 

	@Then("^\"([^\"]*)\" Lead should be created with \"([^\"]*)\"$")
	public void lead_should_be_created_with_with(String LeadType, String LeadName) throws Throwable {
		
		if(LeadType.equals("Business"))
		{
			String lastname=lead.getLastName();
			Assert.assertEquals(lastname, LeadName);
		}

		else if(LeadType.equals("Individual"))
			
		{
			String lastname=lead.getLastNameForIndividual();
			Assert.assertEquals(lastname, LeadName);
		}
	    
	}
	
	
	@Then("^verify the lead WO subtabs$")
	public void verify_the_lead_WO_subtabs() throws Throwable {
		
		 ArrayList<String> subTabs= lead.getSubTabs();
		 Assert.assertEquals(subTabs, LEAD_WO_SUBTABS);
	
	}
	
	@When("^clicks on change owner button$")
	public void clicks_on_change_owner_button() {
	    // Write code here that turns the phrase above into concrete actions
		lead.clickChangeOwner();
	}

	@Then("^user should navigate to change Owner page$")
	public void user_should_navigate_to_change_Owner_page(){
		String sectionname = lead.getSectionHeader();
		Assert.assertEquals(sectionname.trim(), "Change owner");
	}
	
	
	@When("^user changes the Owner, enters the reason and submit the changes$")
	public void user_changes_the_Owner_enters_the_reason_and_submit_the_changes(){

		lead.setOwner(LEAD_UPDATEDOWNER);
		lead.setReason(LEAD_CHANGEREASON);
		lead.clickSubmitButton();
	}
	
	
	@Then("^ownership of the \"([^\"]*)\" lead should be changed$")
	public void ownership_of_the_lead_should_be_changed(String LeadType) {
		String owner= lead.getOwner();
		Assert.assertEquals(owner, LEAD_UPDATEDOWNER);
	}
	
	
	
	@When("^user enters clicks on oppty in closeplan$")
	public void user_enters_clicks_on_oppty_in_closeplan(){
	   //closeplans.clickOppty();
	   //closeplans.enterClosePlans(CLOSEPLANS_COMMENTS);
	}

	
	@Then("^user able to enter the closeplan for that oppty and enters it$")
	public void user_able_to_enter_the_closeplan_for_that_oppty_and_enters_it() {
	  
	}

	
	/*
	 * 
	 * Contacts functions
	 * 
	 */
	
	//private SFAPortal sfaPortal =null;
	//ContactList contList;
	//AccountList accList;
	//Contact cont;
	String contactName;
	Scenario s1;
	Leads lead;
	//Opportunity opp;
	Households hh;
	//Activity activity;
	//Tasks task;

 StringBuffer CONT_FIRSTNAME=new StringBuffer("Siddarath");
	StringBuffer CONT_LASTNAME=new StringBuffer("Roy");
	//StringBuffer CONT_FULLNAME= new StringBuffer("FirstName LastName1");

	String CONT_ORG="Nexus Energy";
	String CONT_UPDATEDLASTNAME="Automation_LastName";
	String CONT_SALUTATION="Mr.";
	String CONT_COMPANY="Pega";
	String CONT_DEPARTMENT="Financial Services";
	String CONT_INFLUENCE="2-Medium";
	String CONT_UPDATED_INFLUENCE="1-High";
	String CONT_UPDATED_MARITALSTATUS="Married";
	String CONT_FAVORABILITY="2-Passive";
	String CONT_WORKPHONE="654897562";
	StringBuffer CONT_FULLNAME=null;
	String CONT_WORKEMAIL= null;
	//String CONT_WORKEMAIL=CONT_FULLNAME+"@"+CONT_COMPANY+".com";
	String CONT_TERRIOTRY="Global";	
	String STREET="Raheja IT Park";
	String CITY="Hyderabad";
	String STATE="Telangana";
	//String ZIPCODE="500019";
	//String COUNTRY="India";
	String HOMEPHONE="040-56984026";
	String HOMEEMAIL="HomeEmail@pega.com";
	String MOBILE="9874662315";
	String FAX="040-5698745";
	
	
	
	@When("^User clicks on Create ContactButton and enters all the madatory data$")
	public void user_clicks_on_Create_ContactButton_and_enters_all_the_madatory_data()
	{
		cont=browser.conList.createContact();
		cont.setFirstName(CONT_FIRSTNAME);
		cont.setLastName(CONT_LASTNAME);
		cont.setOrganization(CONT_ORG);
		
		cont.setSalutation(CONT_SALUTATION);
		cont.setDepartment(CONT_DEPARTMENT);
		cont.setInfluence(CONT_INFLUENCE);
		cont.setFavorability(CONT_FAVORABILITY);
		//cont.setTerritory(CONT_TERRIOTRY);
		cont.setAddress();
		String AddressType=cont.getAddressType();
		Assert.assertEquals(AddressType, "Business Address");
	}
	
	@When("^clicks on Save button$")
	public void clicks_on_Save_button() throws Throwable 
	{
		cont.clickCreate();
	}
	
	
	@Then("^Contact should be created$")
	public void contact_should_be_created() throws Throwable 
	{
		 contactName= cont.getFullname();
		 //String name= new String(contactName);
		 String name= CONT_FULLNAME.toString();
		 Assert.assertEquals(contactName, name);
		 
		 
	}
	
	@Then("^verify contact subtabs$")
	public void verify_contact_subtabs() throws Throwable 
	{
		 //Verify contact Sub tabs
		ArrayList<String> subTabs = cont.getSubTabs();
		//= cont.getSubtabs();
		//Assert.assertEquals(subTabs, CON_WO_SUBTABS);
	     
		 
	}
	
	@Then("^C2A relationship should be created$")
	public void C2A_relationship_should_be_created() throws Throwable 
	{
		
		cont.clickOnRelationshipsTab();
		String C2A_Name=cont.getC2ARelationShipName();
		String fullname=CONT_FULLNAME.toString();
		Assert.assertEquals(C2A_Name, fullname);
		
	}
	
	
	
	@Then("^Primary Individual account should be created automatically$")
	public void Primary_Individual_account_should_be_created_automatically() throws Throwable 
	{
		accList=browser.sfaPortal.getLeftNav().getAccountList();
		accList.navigateAccount(CONT_FULLNAME.toString());
		String fullname= CONT_FULLNAME.toString();
		Assert.assertEquals(cont.getPrimaryContactName(), fullname);
	}
	
	/*
	 * 
	 *  Household 
	 * 
	 */
	
	
	//private SFAPortal sfaPortal =null;
	Households households;
	HouseholdList householdlist;
	String ZIPCODE="500019";
	String COUNTRY="India";
	String HH_NAME="Household for Automation";
	String HH_NAME2 = "Smith Household";
	String HH_CITY="Hyderabad";
	String HH_STATE="Telangana";
	String HH_ZIPCODE="05403";
	String HH_MOB="8789878675";
	String HH_STREET="Build 12A";
	String HH_COUNTRY="India";
	String HH_DESCIPTION="IT's House Hold New Entry";
	String HH_FILTER_CONTACT="Minna";
	String HH_ROLE="Head of household";
	String HH_UPDATED_PHONE_NUMBER="9874561230";
	String HH_UPDATED_DESCRIPTION="Updated description for Automation Household";
	String HH_NEW_MEMBER="anne";
	String HH_NEW_MEMBER_ROLE="Friend";
	String HH_CLOSE_COMMENTS="Closing the HH as part of automation";
	String HH_PLACEHOLDER="Filter households";
	String HH_TableHeader[]={"Name", "Active members", "City", "State", "Zip code"};
	List<String> HH_LISTHEADER = new ArrayList<String>(Arrays.asList(HH_TableHeader));
	
	String HH_SubTabs [] =  {"Pulse","Members","Opportunities","Technical","Recent attachments"};
	List<String> HH_WO_SUBTABS = new ArrayList<String>(Arrays.asList(HH_SubTabs));
	
    public static int  HH_NOOFMEMBER=1;
	//private TestEnvironment testEnv;
	//private MyBrowser browser;
	//private PegaWebDriver pegaDriver;
	
	@When("^user clicks on CreateHousehold button$")
	public void user_clicks_on_CreateHousehold_button() throws Throwable {
		households=householdlist.createHousehold();
	}
	
	@Then("^user should navigate to Household creation page$")
	public void user_should_navigate_to_Household_creation_page() throws Throwable {
		String hhHeader=households.getHouseholdPageHeader();
		Assert.assertEquals(hhHeader, "Household");
	}
	
	@When("^user enters all the HH mandatory data for households and saves the changes$")
	public void user_enters_all_HH_mandatory_data_and_saves_the_changes() 
	{
		households.setHouseholdName(HH_NAME);
		households.setDescription(HH_DESCIPTION);
		households.setPhoneNumber(HH_MOB);
		households.setCity(HH_CITY);
		households.setState(HH_STATE);
		households.setStreet(HH_STREET);
		households.setPincode(HH_ZIPCODE);
		households.setCountry(HH_COUNTRY);
		households.clickAddMemberinCreate();
		households.searchContact(HH_FILTER_CONTACT);
		households.setHouseholdContact(HH_ROLE);
        households.clickCreate();
	}
	
	@Then("^Household should be created$")
	public void household_should_be_created() throws Throwable {
		String hhName= households.getHouseholdName();
		Assert.assertEquals(hhName,HH_NAME);
		String hhphonenumber=households.getPhoneNumber();
		Assert.assertEquals(hhphonenumber,HH_MOB);
		int hhActivemember=households.getActiveMember();
		Assert.assertEquals(hhActivemember,HH_NOOFMEMBER);
		Assert.assertEquals(HH_NOOFMEMBER,households.getListOfActiveMember().size());
	    String hhDescription=households.getDescription();
	    Assert.assertEquals(hhDescription,HH_DESCIPTION);
	    String hhMemberName=households.getMemberName();
	    Assert.assertEquals(hhMemberName, HH_FILTER_CONTACT);
	    String hhMemberRole=households.getMemberRole();
	    Assert.assertEquals(hhMemberRole,HH_ROLE);
		
	}
	
	@Then("^verify the Household WO subtabs$")
	public void verify_the_Household_WO_subtabs() throws Throwable {
		
		 ArrayList<String> subTabs= households.getSubTabs();
		 Assert.assertEquals(subTabs, HH_WO_SUBTABS);
	
	}
	
	/*
	 * 
	 * Operator creation
	 * 
	 */
	
//private SFAPortal sfaPortal =null;
	
	private Wizard wizard;
	private LeftNav leftNav;
	//private TestEnvironment testEnv;
	//private MyBrowser browser;
	//private Scenario scenario;
	//private PegaWebDriver pegaDriver;
	
	
	private OperatorList oprResult;
	private Operator operator, oprDetails;
	
	String NewOperatorID = new String("Automation_Rep"+new Random().nextInt(100));
	String  operatorPassword = "install";
	String  title = "Automation QA";
	String  firstName = "Automation";
	String  lastName= "QA";
	String  fullName= "QA Automation";
	String  position = "QA - Automation Lead";
	String  phone = "9513578426";
	String  email = "Automationuser"+new Random().nextInt(100)+"@pega.com";
	String  oprtimezone= "America/New_York";
	String  reportTo= "SFASalesManager";
	String operatorType="Sales Managers";
	String territory = "Global";
	
	
	
	
	
	@When("^SalesRepOperatorCreation - navigates to Operators tab$")
	public void salesrepoperatorcreation_navigates_to_Operators_tab() throws Throwable {
		//oprResult = sfaPortal.getLeftNav().getOperatorsList();
		oprList = sfaPortal.getLeftNav().getOperatorsList();
	    
	}

	@Then("^SalesRepOperatorCreation - Verify that user navigates to Operators tab$")
	public void salesrepoperatorcreation_Verify_that_user_navigates_to_Operators_tab() throws Throwable {
		//AssertJUnit.assertTrue(oprResult.verifyElement(By.xpath(oprResult.OPR_FILTER_PLACEHOLDER)));
		oprList = sfaPortal.getLeftNav().getOperatorsList();
		System.out.println("Object is:::"+oprList);
	}

	@When("^SalesRepOperatorCreation -  clicks on Create Operator button$")
	public void salesrepoperatorcreation_clicks_on_Create_Operator_button() throws Throwable {
		System.out.println("Object is:::"+oprResult);
		operator = oprList.creasteOperator();
		
	    
	}

	@Then("^SalesRepOperatorCreation - verify that Operator New harness is displayed$")
	public void salesrepoperatorcreation_verify_that_Operator_New_harness_is_displayed() throws Throwable {
	   Assert.assertTrue(operator.verifyOprNewHarness());
	}

	@When("^SalesRepOperatorCreation - Sales Ops enters the data and navigates to Operator Access tab$")
	public void salesrepoperatorcreation_Sales_Ops_enters_the_data_and_navigates_to_Operator_Access_tab() throws Throwable {
		
		operator.setOperatorID(NewOperatorID);
		operator.setPassword(operatorPassword);
		operator.setTitle(title);
		operator.setFirstName(firstName);
		operator.setLastName(lastName);
		//operator.setFullName(fullName);
		operator.setPostition(position);
		operator.setPhone(phone);
		operator.setEmail(email);
		operator.setTimeZone(oprtimezone);
		operator.setReportTo(reportTo);
		operator.clickNext();
		
	    
	}

	@Then("^SalesRepOperatorCreation - verify that Operator navigates to Access tab$")
	public void salesrepoperatorcreation_verify_that_Operator_navigates_to_Access_tab() throws Throwable {
		
		Assert.assertTrue(operator.verifyOprAccessScreen());
		
	}

	@When("^SalesRepOperatorCreation - enters data in Operator Access tab and navigates to Sales Goals tab$")
	public void salesrepoperatorcreation_enters_data_in_Operator_Access_tab_and_navigates_to_Sales_Goals_tab() throws Throwable {
		operator.setOperatorType(operatorType);
		operator.setTerritory(territory);
		//pegaDriver.waitForDocStateReady(1);
		operator.clickNext();
	}

	@Then("^SalesRepOperatorCreation - Verify that Sales Goals tab is displayed$")
	public void salesrepoperatorcreation_Verify_that_Sales_Goals_tab_is_displayed() throws Throwable {
	    
		operator.verifyOprSalesGoalsScreen();
	    
	}

	@When("^SalesRepOperatorCreation - Enters Sales Goals information and submits$")
	public void salesrepoperatorcreation_Enters_Sales_Goals_information_and_submits() throws Throwable {
	   operator.clickFinish();
	}

	@Then("^SalesRepOperatorCreation - Verify that operator record is created$")
	public void salesrepoperatorcreation_Verify_that_operator_record_is_created() throws Throwable {
		//oprDetails = oprResult.navigateOperator();
	}

	@When("^SalesRepOperatorCreation - Navigate to Operator list page to search the newly created Operator$")
	public void salesrepoperatorcreation_Navigate_to_Operator_list_page_to_search_the_newly_created_Operator() throws Throwable {
		oprResult = sfaPortal.getLeftNav().getOperatorsList();
		oprResult.searchOperator(NewOperatorID);
		Assert.assertTrue(oprResult.verifyElement(By.xpath("//table[@class='gridTable']//a[contains(text(),'"+firstName+" "+lastName+"')]")));
		oprResult.findElement(By.xpath("//table[@class='gridTable']//a[contains(text(),'"+firstName+" "+lastName+"')]")).click();
	}

	@Then("^SalesRepOperatorCreation - Validate the Sales operator profile Details information$")
	public void salesrepoperatorcreation_Validate_the_Sales_operator_record_information() throws Throwable {
		oprDetails = oprResult.navigateOperator(); 
		Assert.assertEquals(NewOperatorID,oprDetails.getOperatorId().trim());
		Assert.assertEquals(title,oprDetails.getTitle().trim());
		Assert.assertEquals(firstName,oprDetails.getFirstName().trim());
		Assert.assertEquals(lastName,oprDetails.getLastName().trim());
		Assert.assertEquals(firstName+" "+lastName,oprDetails.getFullName().trim());
		Assert.assertEquals(position,oprDetails.getPostition().trim());
		Assert.assertEquals(phone,oprDetails.getPhone().trim());
		Assert.assertEquals(email,oprDetails.getEmail().trim());
		Assert.assertEquals(oprtimezone,oprDetails.getTimeZone().trim());
		Assert.assertEquals(reportTo,oprDetails.getReportsTo().trim());
		
	}
	
	@When("^SalesRepOperatorCreation - Navigates to the Operator Access tab$")
	public void SalesRepOperatorCreation_Navigates_to_the_Operator_Access_tab() throws Throwable {
		oprDetails.navigateToAccessAndPermissionsTab();
		Assert.assertEquals(operatorType, oprDetails.getOperatorType().trim());
		Assert.assertEquals(territory,oprDetails.getTerritory().trim());
	}
	
	@Then("^SalesRepOperatorCreation - Verify the Default access details$")
	public void salesrepoperatorcreation_Verify_the_Default_access_details() throws Throwable {
	   
		Assert.assertEquals(territory,oprDetails.findElement(By.xpath("//div[@id='PEGA_GRID1']//table[@class='gridTable ']//td[@data-attribute-name='Territory']/div")).getAttribute("text").trim());
		Assert.assertEquals(territory,oprDetails.findElement(By.xpath("//div[@id='PEGA_GRID2']//table[@class='gridTable ']//td[@data-attribute-name='Territory']/div")).getAttribute("text").trim());
		Assert.assertEquals(territory,oprDetails.findElement(By.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@data-attribute-name='Territory']/div")).getAttribute("text").trim());
		Assert.assertEquals(territory,oprDetails.findElement(By.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@data-attribute-name='Territory']/div")).getAttribute("text").trim());
		Assert.assertEquals(territory,oprDetails.findElement(By.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@data-attribute-name='Territory']/div")).getAttribute("text").trim());
		Assert.assertEquals(territory,oprDetails.findElement(By.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@data-attribute-name='Territory']/div")).getAttribute("text").trim());
		oprDetails.defaultSalesRepAccess();
		
	}
	

	@When("^SalesRepOperatorCreation - Sales Ops Logout of SFA application$")
	public void salesrepoperatorcreation_Sales_Ops_Logout_of_SFA_application() throws Throwable {
	 
	 
	}
	
	/* 
	 * 
	 * *************************************************************************
	 * 
	 * 			Organization Creation
	 * 
	 * *************************************************************************
	 * 
 	 */
	
	
	public String website = new String("www.pega.com");
	public String OrgphoneNo = new String("12354789");
	public String OrgIndustry= new String("Financial Services");
	public String OrgShortName= new String("Org Short Name");
	public String OrganizationWOName = "Automation Org";
	public StringBuffer OrganizatonName;
	public String CurrentOrganization;
	public String OrganizationTerritory= "Global";
	public String OrgEmployeeCount = new String("10");
	public String OrgTicker = new String("Pega");
	public String OrgRevenue = new String("100");
	public String AcntRevenue = new String("100.00");
	public boolean	OrgTarget = true;
	public String parentOrg = "Wellmark";
	public String NewParentOrg = "APW Technologies Corp";
	public String OrgDescription = "The Acme Corporation is a fictional corporation that "
									+ "features prominently in the Road Runner/Wile E. "
									+ "Coyote cartoons as a running gag featuring outlandish "
									+ "products that fail or backfire catastrophically at the worst possible times. "
									+ "The name is also used as a generic title in many cartoons, "
									+ "films, TV series, commercials and comic strips. "
									+ "It is used also as an organization's placeholder name.";
	public static int rand= (new Random()).nextInt(100);
    public String[] domains= {new String((rand)+"pega.com"),new String((rand)+"in.pega.com")};
	public String OrgStreet = new String("Raheja IT Park"); 
	public String OrgCity = new String("Hyderabad");
	public String OrgState = new String("Telangana");
	public String OrgPostalCode = new String("500019");
	public String OrgCountry = new String("India");
	String Org_SubTabs [] =  {"Pulse","Details","Accounts","Opportunities","Contacts","Leads","Trends","Activities","Affinities","Recent attachments"};
	List<String> ORG_WO_SUBTABS = new ArrayList<String>(Arrays.asList(Org_SubTabs));
	
	
	
	
	@When("^SalesOps navigates to Organization tab to Create Org$")
	public void naivgateToOrgTab()  {
		
	}

	@Then("^Verify that user navigates to Organization tab$")
	public void verifyOrgTab()  {
		organizationList= browser.orgList;
		organizationList.verifyOrgListpage();
	}

	@When("^SalesOps clicks on Create Oranization button$")
	public void createOrg()  {
		
		organizationList= browser.orgList;
		
		try {
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		
		
	   organization = organizationList.createOrganization();
	}

	@Then("^verify that Organization New harness is displayed$")
	public void verifyNewHarnessIsDisplayed()  {
	    
	    Assert.assertTrue(organization.verifyOrgNewHarness());
	}

	@When("^SalesOps enters the data and submits$")
	public void salesmanager_enters_the_data_and_submits()  {
		
		organization.setWebsite(website);
		
		organization.setPhoneNumber(OrgphoneNo);
		organization.setIndustry(OrgIndustry);
		//organization.setTerritory(OrganizationTerritory);
		organization.setShortName(OrgShortName);
		organization.setTickerSymbol(OrgTicker);
		organization.setEmployees(OrgEmployeeCount);
		organization.setRevenue(OrgRevenue);		
		organization.setTarget(OrgTarget);
		organization.setParentOrganization(parentOrg);
		organization.setDescription(OrgDescription);
		organization.setName(OrganizationWOName);
		organization.setAddress();
		organization.setDomains(domains);
		organization.submit();
	}

	
	
	@Then("^verify that Organization Wo is created$")
	public void verify_that_Organization_Wo_is_created()  {
	
		Assert.assertEquals(OrganizationWOName,(organization.getName()));		
		Assert.assertEquals(website,(organization.getWebsite()));
		Assert.assertEquals((OrgIndustry.toLowerCase()),(organization.getIndustry().toLowerCase()));
		Assert.assertEquals(OrgphoneNo,(organization.getPhoneNumber()));
		Assert.assertEquals(OrgShortName,(organization.getShortName()));
		Assert.assertEquals(OrgTicker,(organization.getTickerSymbol()));
		Assert.assertEquals(OrgEmployeeCount,(organization.getEmployees()));
		Assert.assertTrue(((organization.getRevenue())).contains(OrgRevenue));
		if(organization.getTarget()== "Yes")
			Assert.assertTrue(OrgTarget);		
		Assert.assertTrue(parentOrg.equals(organization.getParentOrganization()));
		//Assert.assertEquals(OrganizationTerritory,organization.getTerritory().trim());
		
		organization.getDescription();
		//organization.getDomains();
		//organization.getAddress("");
		Assert.assertTrue(organization.verifyOrgNews());
		
		//Assert.assertTrue(organization.verifyTwitterIcon());
		//Assert.assertTrue(organization.verifyFacebookIcon());
		//Assert.assertTrue(organization.verifyGoogleMapIcon());
		
		//Verify the Organization WO tabs
		organization.verifySubTabs();
	}

	@When("^SalesOps navigates to Orgaization tab again$")
	public void salesmanager_navigates_to_Orgaization_tab_again()  {
	    
		//organizationList = sfaPortal.getLeftNav().getOrganizationList();
		organizationList= browser.orgList;
		organizationList.verifyOrgListpage();
		
	}

	@Then("^SaleOps search for the Organization$")
	public void saleops_search_for_the_Organization() throws Throwable {

	organizationList= browser.orgList;
	//OrganizationList orgResult;
	orgResult = organizationList.searchOrganization(OrganizationWOName);
	organization = orgResult.openOrganization(OrganizationWOName);
	     
	}

	@When("^SaleOps Opens the Organization WO(\\d+)$")
	public void saleops_Opens_the_Organization_WO(int arg1) throws Throwable {
	    
		//organization = orgResult.openOrganization(OrganizationWOName);
		//orgResult.openOrganization(OrganizationWOName);
		CurrentOrganization = organization.getName();
		
	}

	@Then("^SaleOps validates the Organization work object details$")
	public void saleops_validates_the_Organization_work_object_details() throws Throwable {
	    
		
		Assert.assertEquals(OrganizationWOName,(organization.getName()));
		//Assert.assertEquals(OrganizationTerritory,(organization.getTerritory().trim()));
		Assert.assertEquals(website,(organization.getWebsite()));
		Assert.assertEquals(OrgIndustry.toLowerCase(),(organization.getIndustry().toLowerCase()));
		Assert.assertEquals(OrgphoneNo,(organization.getPhoneNumber()));
		Assert.assertEquals(OrgShortName,(organization.getShortName()));
		Assert.assertEquals(OrgTicker,(organization.getTickerSymbol()));
		Assert.assertEquals(OrgEmployeeCount,(organization.getEmployees()));
		Assert.assertTrue((organization.getRevenue()).contains(OrgRevenue));
		if(organization.getTarget()== "Yes")
			Assert.assertTrue(OrgTarget);		
		Assert.assertEquals(parentOrg,organization.getParentOrganization());
		Assert.assertTrue(organization.verifyOrgNews());
		
		//Verify the Organization WO tabs
		ArrayList<String> subTabs= organization.verifySubTabs();
		Assert.assertEquals(subTabs, ORG_WO_SUBTABS);
	     
	}
	
	/*
	 *  
	 * Account Creation and Edit
	 *  
	 */
	
	static String Owner;
	//Scenario sc;
	//private SFAPortal sfaPortal =null;
	Accounts acc, accResult;
	//Tasks task;
	LeadsList leadList;
	Leads leads;
	ContactList contList;
	Contact cont;
	public AccountList accList, accountsList;
	//public Activity activity;
	//private TestEnvironment testEnv;
	//private MyBrowser browser;
	//private PegaWebDriver pegaDriver;
	public Relationship relationship;
	public Opportunity opportunity;
	SimpleDateFormat format= new SimpleDateFormat("MM/DD/YYYY");
	SimpleDateFormat format1= new SimpleDateFormat("M/DD/YYYY");
	//Date dt= new Date();
	
	StringBuffer ACC_NAME=new StringBuffer("Dwayne Johnson");
	StringBuffer ACC_NAME_INDIVIDUAL= new StringBuffer("Adam Collins");											
	String ACC_TERRIORTY="Global";
	String ACC_ORG="Acme Software";
	String ACC_INDUSTRY="Entertainment";
	String ACC_PHONENUMBER="12895647";
	String ACC_UPDATED_PHONENUMBER="987645321";
	String ACC_UPDATED_INDUSTRY= "Media";
	String ACC_UPDATED_EMPLOYEES = "750";
	String ACC_CHANGEOWNER="Anna Parker";
	String ACC_CHANGEREASON="Owner is changed as part of automation";
	String ACC_CLOSECOMMENTS="Closed as part of automation";
	String ACC_WEBSITE = "www.automationaccount.com";
	 String ACC_EMPLOYEES = "500";
	 String ACC_TICKER = "Pega_Account";
	 String ACC_REVENUE = "78945300.00";
	 String ACC_DESCRIPTION= "This is the account created by automation script";
	 //String actual_name, actual_territory, actual_org, actual_industry, actual_phoneNumber, actual_owner,actual_website, actual_employees, actual_ticker, actual_revenue, actual_description;
	 String ACC_PLACEHOLDER="Filter accounts";
	String ACC_TableHeader[]={"Name", "Organization", "Industry", "Opportunities", "Total amount","Target", "Owner", "Territory"};
	List<String> ACC_LISTHEADER = new ArrayList<String>(Arrays.asList(ACC_TableHeader));
	String ACC_SubTabs [] =  {"Pulse","Details","Opportunities","Contacts","Leads","Activities","Affinities","Recent attachments"};
	List<String> ACC_WO_SUBTABS = new ArrayList<String>(Arrays.asList(ACC_SubTabs));
		
	
	@When("^user clicks on CreateAccount button$")
	public void user_clicks_on_CreateAccount_button()
	{
		acc=browser.accList.createAccount();
		
	}
	
	@Then("^user should navigate to Account creation page$")
	public void user_should_navigate_to_Account_creation_page()
	{
		String accHeader=acc.getAccountPageHeader();
		Assert.assertEquals(accHeader, "Account");
	}
	
	@When("^user enters all the mandatory data and saves the changes$")
	public void user_enters_all_the_mandatory_data_and_saves_the_changes() throws InterruptedException
	{
		acc.setAccountName(ACC_NAME);
		acc.setWebSite(ACC_WEBSITE);
		acc.setPhoneNumber(ACC_PHONENUMBER);
		acc.setEmployees(ACC_EMPLOYEES);
		acc.setTickerSymbol(ACC_TICKER);
		acc.setRevenue(ACC_REVENUE);
		acc.setDescription(ACC_DESCRIPTION);
		//acc.setTerritory(ACC_TERRIORTY);
		acc.setOrganization(ACC_ORG);
		acc.setIndustry(ACC_INDUSTRY);
		acc.setAddress();
		acc.clickCreate();
	}
	
	
	
	@Then("^Account should be created$")
	public void account_should_be_created() 
	{
		actual_name= acc.getAccountName();
		String ExpaccName=ACC_NAME.toString();
		Assert.assertEquals(actual_name, ExpaccName);
		
		String  actual_org= acc.getOrganization();
		actual_territory = acc.getTerritory();
		actual_owner = acc.getOwner();
		String actual_phoneNumber= acc.getPhoneNumber();
		String actual_industry= acc.getIndustry();
		String actual_employees = acc.getEmployees();
		String actual_ticker= acc.getTicker();
		String actual_revenue = acc.getRevenue();
		actual_description = acc.getDescription();
		
		Assert.assertEquals(actual_org, ACC_ORG);
		//Assert.assertEquals(actual_territory, ACC_TERRIORTY);
		Assert.assertEquals(actual_phoneNumber, ACC_PHONENUMBER);
		Assert.assertEquals(actual_industry, ACC_INDUSTRY);
		Assert.assertEquals(actual_employees, ACC_EMPLOYEES);
		Assert.assertEquals(actual_ticker, ACC_TICKER);
		Assert.assertEquals(actual_revenue, ACC_REVENUE);
		Assert.assertEquals(actual_description, ACC_DESCRIPTION);
		

	}
	
	
	
	@When("^user opens the existing Account with \"([^\"]*)\"$")
	public void user_opens_the_existing_Account(String AccName){
		acc=accList.navigateAccount(AccName);
	  
	}
	
	
	@When("^clicks on edit button$")
	public void clickedit()
	{
		acc.clickEdit();
	}
 
	
	@Then("^user should able to edit all the fields in Account page$")
	public void user_should_able_to_edit_all_the_fields_in_Account_page()
	{
		
		Assert.assertTrue(acc.isNameEnabled());
		Assert.assertTrue(acc.isPhoneNumberEnabled());
		Assert.assertTrue(acc.isCityEnabled());
		
	}
	
	

	@When("^user edits the input fields and save the changes$")
	public void user_edits_the_input_fields_and_save_the_changes() 
	{
		acc.setPhoneNumber(ACC_UPDATED_PHONENUMBER);
		acc.setIndustry(ACC_UPDATED_INDUSTRY);
		acc.setEmployees(ACC_UPDATED_EMPLOYEES);
		acc.clickSubmit();
	}

	@Then("^Account should be reflected with the changes made in the account page$")
	public void account_should_be_reflected_with_the_changes_made_in_the_account_page() 
	{
		String actual_phoneNumber=acc.getPhoneNumber();
		Assert.assertEquals(actual_phoneNumber, ACC_UPDATED_PHONENUMBER);
		String actual_industry=acc.getIndustry();
		Assert.assertEquals(actual_industry, ACC_UPDATED_INDUSTRY);
		String actual_employees = acc.getEmployees();
		Assert.assertEquals(actual_employees, ACC_UPDATED_EMPLOYEES);
	}
	
	/*
	 * 
	 *  Business Territoryies
	 * 
	 */
	
	String TRR_PLACEHOLDER ="Filter territories";
	Scenario sc;
	//private SFAPortal sfaPortal =null;
	String TerritoryName=null;
	String ModifiedTerritoryOwner=null;
	String ModifiedTerritoryParent=null;
	//TerritoriesList trrList;
	Territories trr;
	String MODELBOXNAME="Business Territory Details";
	String TERRITORYNAME="AutoTerritory-1";
	String TERRITORYOWNER="Terry Mason";
	String DELEGATE="tmason";
	String PARENTTERRITORY="Global";
	String TRR_TableHeader[]={"Name", "Status", "Owner", "Delegate","ID", "Parent", "Partner"};
	List<String> TRR_LISTHEADER = new ArrayList<String>(Arrays.asList(TRR_TableHeader));
	//private TestEnvironment testEnv;
	//private MyBrowser browser;
	//private PegaWebDriver pegaDriver;
	String TerryName;
	

	@When("^User Navigates to Territories tab$")
	public void user_Navigates_to_Territories_tab_to_Create_Territories() 
	{
		trrList=sfaPortal.getLeftNav().getTerritoriesList();	   
	}

	@When("^User clicks on Create Territory button$")
	public void user_clicks_on_Create_Territory_button() 
	{
		trr= trrList.createTerritory();
	     
	}
	
	@Then("^verify that Business Territory New modal dialog is displayed$")
	public void verify_that_Business_Territory_New_modal_dialog_is_displayed()
	{
		Assert.assertTrue(trr.isTerritoryNameDisplayed());
		Assert.assertTrue(trr.isSubmitDisplayed());
	     
	}
	
	@When("^User enters the data for \"(.+)\" \"(.+)\" \"(.+)\" \"(.+)\" and submits$")
	public void user_enters_the_data_and_submits(String TerritoryName, String ParentTerritory, String TerritoryOwner,  String ReservedForPartner)
	{
		TerryName= TerritoryName+ new Random().nextInt(100);
		 trr.setTerritoryName(TerryName);
	     trr.setOwner(TerritoryOwner);
	     //trr.setParentTerritory(ParentTerritory);
	     trr.setReservedForPartner(ReservedForPartner);
	     trr.clickSubmit();
	     
	}
	
	
	@Then("^verify that Business Territory with name \"(.+)\" and \"(.+)\" is created$")
	public void verify_that_Business_Territory_is_created(String territoryName, String OwnerName) 
	{
	     trr=trrList.navigateTerritory(TerryName);
	     String actualTerritoryName = trr.getTerritoryName();
	     String actualOwner=trr.getTerritoryOwner();
	     Assert.assertTrue(actualTerritoryName.equals(TerryName));
	     Assert.assertEquals(actualOwner, OwnerName);
	     
	}
	
	
	/*
	 * 
	 * Partners creation
	 * 
	 */
	
	
	private Scenario scenario;
	//public SFAPortal sfaPortal =null;
	//private TestEnvironment testEnv;
	//private MyBrowser browser;
	//private PegaWebDriver pegaDriver;
	PartnersList partList;
	PartnersList partnerslist;
	Partners part;
	OperatorList oprList;
	TerritoriesList trrList;
	
	String PARTNER_NAME="Automation Partner";
	String PARTNER_NAME_CLOSE="First Alert";
	String PARTNER_PHONE="8995994999";
	String PARTNER_WEBSITE="www.partner1.com";
	String TERRITORY_NAME= new String("Automation_Partner_Territory"+new Random().nextInt(100));

	String TERRITORY_OWNER="Terry Mason";
	String PARENT_TERRITORY="Global";
	String PARTNER_TYPE="Agency";
	String PARTNER_EMAIL="partner.pega@gmail.com";
	String PARTNER_UPDATED_EMAIL= "updatedpartner.pega@gmail.com";
	String PARTNER_UPDATED_PHONE="9874561230";
	
	String PartnerID = "Partner120";
	String PartnerTaxID = "PartnerTax120";
	String PartnerFax = "67890";
	
	
	@When("^User clicks on Create Partner and enters all the madatory data$")
	public void user_clicks_on_Create_Partner_and_enters_all_the_madatory_data() 
	{
		partList = sfaPortal.getLeftNav().getPartnersList();
		part = partList.createPartner();
		part.setWebSite(PARTNER_WEBSITE);
		part.setPhone(PARTNER_PHONE);
		part.setPartnerName(PARTNER_NAME);
		part.setSFAAccess();
		part.setEmail(PARTNER_EMAIL);
		part.clickcreateTerritory();
		part.setTerritoryName(TERRITORY_NAME);
		part.setOwner(TERRITORY_OWNER);
		part.setParentTerritory(PARENT_TERRITORY);
		part.clickSubmitTerritoryScreen();
		part.setPartnerType(PARTNER_TYPE);
		part.setPartnerID(PartnerID);
		part.setPartnerTaxID(PartnerTaxID);
		part.setPartnerWorkFax(PartnerFax);
	}
	
	@When("^clicks on OK button$")
	public void clicks_on_OK_button() 
	{
		part.SubmitPartner();		
	}
	
	@Then("^Partner should be created$")
	public void partner_should_be_created()
	{
		Assert.assertEquals(part.getWebSite().trim(), PARTNER_WEBSITE);
		Assert.assertEquals(part.getPartnerID().trim(), PartnerID);
		Assert.assertEquals(part.getPhone().trim(), PARTNER_PHONE);
		Assert.assertEquals(part.getPartnerName().trim(),PARTNER_NAME);
		Assert.assertEquals(part.getPartnerWorkFax().trim(),PartnerFax);
		Assert.assertEquals(part.getEmail().trim(), PARTNER_EMAIL);
		Assert.assertEquals(part.getPartnerTaxID().trim(),PartnerTaxID);
		Assert.assertEquals(part.getPartnerType().trim(), PARTNER_TYPE);
	}
	
	
	
}
