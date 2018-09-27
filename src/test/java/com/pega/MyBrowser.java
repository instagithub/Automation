package com.pega;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
//import com.pega.sfa.workobjects.TerritoriesList;
//import com.pega.sfa.workobjects.UtilImpl;
import org.openqa.selenium.WebElement;

import com.google.inject.Inject;
import com.pega.cs.CSPortal;
import com.pega.cs.SFAPortal;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.pm.DesignerStudio;
import com.pega.pm.PMPortal;
import com.pega.pm.impl.PegaExpressPortal;
import com.pega.sfa.workobjects.AccountList;
import com.pega.sfa.workobjects.AppointmentList;
import com.pega.sfa.workobjects.ClosePlans;
import com.pega.sfa.workobjects.ContactList;
import com.pega.sfa.workobjects.EngagementMaps;
import com.pega.sfa.workobjects.Forecast;
import com.pega.sfa.workobjects.HouseholdList;
//import com.pega.sfa.workobjects.IToolsList;
import com.pega.sfa.workobjects.LeadsList;
import com.pega.sfa.workobjects.Login;
import com.pega.sfa.workobjects.OperatorList;
import com.pega.sfa.workobjects.OpportunityList;
import com.pega.sfa.workobjects.OrganizationsList;
import com.pega.sfa.workobjects.PartnersList;
import com.pega.sfa.workobjects.Pulse;
import com.pega.sfa.workobjects.TerritoriesList;
import com.pega.sfa.workobjects.ToolsList;
import com.pega.sfa.workobjects.impl.LoginImpl;
import com.pega.sfa.workobjects.impl.UtilImpl;
import com.pega.util.HTTPUtil;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
//import webDriverStepDef.CSPortal;

@ScenarioScoped
public class MyBrowser extends com.pega.cs.BrowserImpl {

	String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	String VERSION = "$Id: MyBrowser.java 189580 2016-04-27 10:38:53Z SachinVellanki $";

	TestEnvironment testEnv;
	private CSPortal csPortal;
	public SFAPortal sfaPortal;
	private PegaWebDriver pegaDriver;
	public OrganizationsList orgList;
	public HouseholdList hhList;
	public AccountList accList;
	public LeadsList leadList;
	public OpportunityList oppList;
	public TerritoriesList terrList;
	public OperatorList oprList;
	public PartnersList parList;
	public ContactList conList;
	public Login login;
	public ToolsList toolsList;
	// public DataLoader dataloader;
	public AppointmentList appList;
	public EngagementMaps egMaps;
	public Forecast forecast;
	public ClosePlans closeplans;
	public Pulse pulseList;
	// variable to check whether campaign exists or not
	public boolean campaignExists;

	public static String EDIT_XPATH = UtilImpl.getButtonXpath("Edit");
	public static String WO_FOLLOW_XPATH = UtilImpl.getButtonXpath("Follow");

	private PegaExpressPortal pegaExpressPortal;
	private PMPortal pegaMarketingPortal;
	private DesignerStudio designerStudio;
	private Configuration configuration;

	@Inject
	public MyBrowser(TestEnvironment testEnv) {
		super(testEnv);
		this.testEnv = testEnv;
		pegaDriver = testEnv.getPegaDriver();
		configuration = testEnv.getConfiguration();
	}

	/*public <T extends Portal> T getPortal(Class<T> type) {
		T portal = null;
		String className = type.getName();
		if (className.contains("PMPortal")) {
			portal = type.cast(new PegaPMPortal(testEnv));
		} else if (className.contains("PegaExpressPortal")) {
			portal = type.cast(new PegaExpressPortal(testEnv));
		} else if (className.contains("DesignerStudio")) {
			portal = type.cast(new PegaDesignerStudio(testEnv));
		}
		return portal;
	}*/

	public PMPortal getPMPortal() {
		return pegaMarketingPortal;
	}

	public DesignerStudio getDesignerStudio() {
		return designerStudio;
	}

	public PegaExpressPortal getExpressPortal() {
		return pegaExpressPortal;
	}

	@After
	public void afterHook(Scenario scenario) {
		String testcaseID = null;
		for (String tag : scenario.getSourceTagNames()) {
			if (tag.startsWith("@TC-"))
				testcaseID = tag;
		}
		String logMessage = testcaseID + " : " + scenario.getName() + "Selenium Test Completed";

		logMessage = logMessage.replaceAll(" ", "%20");
		String url = pegaDriver.getCurrentUrl();
		System.out.println("::::::::::::::URL" + url);
		int index = url.indexOf("prweb");
		if (index < 0)
			return;
		url = url.substring(0, index);

		url = url + "prweb/PRRestService/BuildSmokeNoAuth/Utility/WriteLogMessage?message='" + logMessage + "'";
		URL myURL;
		try {
			myURL = new URL(url);
			URLConnection myURLConnection = myURL.openConnection();
			myURLConnection.connect();
			BufferedReader br = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
			String inputLine;
			while ((inputLine = br.readLine()) != null) {
				System.out.println(inputLine);
			}
			br.close();
		} catch (MalformedURLException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

	@Given("^A User logs in with Analyst credentials$")
	public void a_User_logs_in_with_Analyst_credentials() {
		open();
		super.login(configuration.getCredential("ANALYST_USER_ID"), configuration.getCredential("ANALYST_PASSWORD"));
		pegaMarketingPortal = getPortal(PMPortal.class);
	}

	@Given("^a user is on login page of CS Portal$")
	public void open() {
		super.open();
	}

	@Given("^CS operator logs in to the portal \"(.*?)\" and \"(.*?)\"$")
	public void loginToCSPortal(String username, String password) {
		super.login(username, password);
		csPortal = getPortal(CSPortal.class);
		pegaDriver = testEnv.getPegaDriver();
	}

	@Given("^A User logs in with \"(.*?)\" and \"(.*?)\"$")
	public void login(String username, String password) {
		open();
		super.login(username, password);
		designerStudio = getPortal(DesignerStudio.class);
	}

	@Given("^User_Hz logs in to the Designer Studio as \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_hz_logs_in_to_the_Designer_Studio_as(String username, String password) throws Throwable {
		super.open();
		super.login(username, password);
		csPortal = getPortal(CSPortal.class);
		pegaDriver = testEnv.getPegaDriver();

	}

	@Then("^User will be navigated to the portal$")
	public void user_will_be_navigated_to_the_portal() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.verifyElement(By.xpath("//img[@data-ctl='Icon' and @title='Customer Service Logo']"));
		pegaDriver.verifyElement(By.xpath("//a[@title='Call Volume Alert']"));
		pegaDriver.verifyElement(By.xpath("//img[@title='Login to chat server']"));
		// pegaDriver.switchToActiveFrame();
		// Assert.assertTrue(pegaDriver.verifyElement(By.id("pySearchText")));
		pegaDriver.switchTo().defaultContent();
	}

	@Then("^Verify Operator name \"([^\"]*)\"$")
	public void verify_Operator_name(String username) throws Throwable {
		pegaDriver.switchTo().defaultContent();
		if (username.equalsIgnoreCase("CA Sys Admin")) {
			String FinalXpath = "//div[@class='content-item content-field item-1 remove-all-spacing   dataValueWrite flex flex-row ']/i[@title='"
					+ username + "']";
			pegaDriver.verifyElement(By.xpath(FinalXpath));
		} else if (username.equalsIgnoreCase("Dan Percival")) {
			String FinalXpath = "//div[@class='field-item dataValueWrite']/img[contains(@title,'" + username + "')]";
			pegaDriver.verifyElement(By.xpath(FinalXpath));
		} else {
			String FinalXpath = "//div[@class='field-item dataValueWrite']/span/a[contains(@title,'" + username + "')]";
			pegaDriver.verifyElement(By.xpath(FinalXpath));
		}
		if (username.equalsIgnoreCase("Back office user ")) {
			String FinalXpath = "//a[text()='" + username + "']";
			pegaDriver.verifyElement(By.xpath(FinalXpath));

		}
		if (username.equalsIgnoreCase("Back office manager ")) {
			String FinalXpath = "//a[text()='" + username + "']";
			pegaDriver.verifyElement(By.xpath(FinalXpath));

		}
	}



	@Then("^Verify sections in there$")
	public void verify_sections_in_there() {
		pegaDriver.verifyElement(By.xpath("//div[@class='pzbtn-mid' and text()='Bulk Actions']"));
		pegaDriver.verifyElement(By.xpath("//a[text()='Select Work for Quality Review']"));
		pegaDriver.verifyElement(By.xpath("//a[text()='View Campaign Details']"));
		pegaDriver.verifyElement(By.xpath("//a[text()='Add New Campaign']"));
		pegaDriver.verifyElement(By.xpath("//div[@class='pzbtn-mid' and text()='Launch Co-Browsing']"));
	}



	@When("^Operator logs of the portal$")
	public void csr_logout_of_the_portal() {
		logout();
	}



	@Then("^User will be navigated to the social portal$")
	public void user_will_be_navigated_to_the_social_portal() {

		Assert.assertTrue(pegaDriver.verifyElement(By.id("pySearchText")));
		Assert.assertTrue(pegaDriver.verifyElement(By.xpath("//div[text()='Get additional cases']")));
	}



	@Then("^Navigate to \"([^\"]*)\"$")
	public void navigate_to_FB_auth_URL(String URL) {

		pegaDriver.get(URL);

	}



	@When("^user imports the following \"([^\"]*)\" RAP$")
	public void user_imports_the_following_RAP(String rapPath) {
		HTTPUtil.importRAP(rapPath, testEnv);

	}



	@Then("^Verify the top Nav links for sys admin$")
	public void verify_the_top_Nav_links_for_sys_admin() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.verifyElement(By.xpath(
				"//div[@class ='content-item content-field item-3    current-application with-icon dataValueWrite flex flex-row ']/span/a[@title='Application menu']"));
		pegaDriver.verifyElement(By.xpath(
				"//div[@class ='content-item content-field item-4    launch-portals with-icon dataValueWrite flex flex-row ']/span/a[@title='Launch another portal']"));
		pegaDriver.verifyElement(By.xpath(
				"//div[@class ='content-item content-field item-5 remove-right-spacing    create-case with-icon dataValueWrite flex flex-row ']/span/a[@title='Create a case']"));
		pegaDriver.verifyElement(By.xpath("//span/input[@id='pySearchText']"));

		// pegaDriver.switchTo().defaultContent();

	}



	@Then("^Verify Left Nav links for mikejones$")
	public void verify_Left_Nav_links_for_mikejones() {
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		pegaDriver.verifyElement(By.xpath("//span/a[@title='My Work']"));
		pegaDriver.verifyElement(By.xpath("//span/a[@title='Dashboard']"));
		pegaDriver.verifyElement(By.xpath("//span/a[@title='My Reports']"));
		pegaDriver.verifyElement(By.xpath("//span/a[@title='Pulse']"));
		pegaDriver.verifyElement(By.xpath("//span/a[@title='Tags']"));

		// pegaDriver.switchTo().defaultContent();
	}

	@Then("^Verify the top Nav links$")
	public void verify_the_top_Nav_links() {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.verifyElement(By.xpath("//span/a[contains(text(),'Create')]"));
		pegaDriver.verifyElement(By.xpath("//span[@class='primary_search']/input[@id='pySearchText']"));
		pegaDriver.verifyElement(
				By.xpath("//div[@class='field-item dataValueWrite']/img[contains(@title,'Dan Percival')]"));
		pegaDriver.switchTo().defaultContent();
	}

	

	@When("^User switches to \"([^\"]*)\" portal$")
	public void user_switches_to_portal(String portal) {
		switchBetweenPortal(portal);
	}

	@When("^user clicks on New message button$")
	public void user_clicks_on_New_message_button() {

		clickOnMessageButton();

	}

	@When("^user navigates to \"([^\"]*)\" tab$")
	public void user_navigates_to_tab(String tabname) {

		switchToTab(tabname);

	}

	@When("^Search and select the \"([^\"]*)\" user$")
	public void search_and_select_the_user(String name) throws Throwable {
		selectUserFromSearch(name);

	}

	@When("^User clicks \"([^\"]*)\" for the followed case$")
	public void user_clicks_for_the_followed_case(String unfollow) {

		unFollowCase(unfollow);

	}

	@When("^CSR Clicks on Knowlwdge content$")
	public void csr_Clicks_on_Knowlwdge_content() {
		openKnowledgeContent();

	}

	@When("^select \"([^\"]*)\" article$")
	public void select_article(String name) {

		searchKMArticle(name);
		selectRatedArticle(name);

	}

	@When("^Click on \"([^\"]*)\" icon$")
	public void click_on_icon(String iconName) {

		clickOnIconsinKM(iconName);

	}

	@When("^Click on Popout icon and swith to new window$")
	public void click_on_Popout_icon_and_swith_to_new_window() {
		clickOnPopoutIcon();

	}

	@When("^Close the popup and switch back$")
	public void close_the_popup_and_switch_back() throws Throwable {

		testEnv.getBrowser().close();
		testEnv.getBrowser().switchToWindow(1);

	}

	@When("^Click submit to share the article$")
	public void click_submit_to_share_the_article() {
		/*
		 * Currently error message is displayed when clicking on send, hence changing
		 * the code to CANCEL flow
		 */
		shareArticle();

	}

	@When("^Enter the feedback and click submit$")
	public void enter_the_feedback_and_click_submit() {

		submitFeedback();

	}

	@When("^click on \"([^\"]*)\" link$")
	public void click_on_link(String linkName) {

		selectLinkUnderShareandFeedback(linkName);

	}

	@When("^Select \"([^\"]*)\" and serach for \"([^\"]*)\"$")
	public void select_and_serach_for(String searchType, String value) {

		selectandSearchResearchType(searchType, value);

	}

	@When("^Filter the result with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void filter_the_result_with_and(String searchBox, String searchString) {
		filterwithInitialValues(searchBox, searchString);

	}

	@When("^Click On Clear button$")
	public void click_On_Clear_button() {

		clearFilter();

	}

	@When("^Filter with Account number \"([^\"]*)\" Type \"([^\"]*)\" Status \"([^\"]*)\" and owner \"([^\"]*)\"$")
	public void filter_with_Account_number_Type_Status_and_owner(String AcNo, String Type, String Status,
			String OwnerName) {

		filterWithAllForAccount(AcNo, Type, Status, OwnerName);

	}

	@When("^Filter with Org name \"([^\"]*)\" Type \"([^\"]*)\" Tax ID\"([^\"]*)\" Ind \"([^\"]*)\" Cntry \"([^\"]*)\" City \"([^\"]*)\" state \"([^\"]*)\"$")
	public void filter_with_Org_name_Type_Tax_ID_Ind_Cntry_City_state(String Name, String Type, String TaxID,
			String Industry, String Country, String City, String State) {

		filterWithAllValuesForOrganization(Name, Type, TaxID, Industry, Country, City, State);

	}

	@When("^Filter with FN \"([^\"]*)\" Ln \"([^\"]*)\" mail \"([^\"]*)\" city \"([^\"]*)\" State \"([^\"]*)\"$")
	public void filter_with_FN_Ln_Org_phone_mail_city_State(String Fname, String Lname, String mail, String City,
			String State) {

		filterWithAllValuesForIndividual(Fname, Lname, mail, City, State);

	}

	@When("^Filter with article \"([^\"]*)\" Content \"([^\"]*)\" Average \"([^\"]*)\" Content \"([^\"]*)\"$")
	public void filter_with_article_Content_Average_Content(String article, String Content, String Average,
			String Views) {
		filterWithAllValuesForContent(article, Content, Average, Views);

	}

	@When("^Get the interaction case ID$")
	public void get_the_interaction_case_ID() {
		pegaDriver.waitForDocStateReady(1);
		CaseIDOfInteraction();

	}

	@When("^Get the case ID from History and Attachments$")
	public void get_the_case_ID_from_History_and_Attachments() {
		pegaDriver.waitForDocStateReady(1);
		CaseIDOfInteractionfromHistory();

	}

	@When("^Select \"([^\"]*)\" and search for previous CaseID$")
	public void select_and_search_for_previous_CaseID(String searchType) {
		searchCaseswithPreviousCaseID(searchType);

	}

	@When("^Filter with previous Case Id$")
	public void filter_with_previous_Case_Id() {
		filterusingPreviousCaseID();

	}

	@When("^Select the case ID$")
	public void select_the_case_ID() {
		selectthePreviousCaseID();

	}

	@When("^Close the interaction case$")
	public void close_the_interaction_case() {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		PegaWebElement closeInteraction = pegaDriver
				.findElement(By.xpath("//a[@class='Wrap_up' and @title='Close item']"));
		closeInteraction.click();

	}

	@When("^CSR searches for case Id research interaction under \"([^\"]*)\"$")
	public void csr_searches_for_case_Id_research_interaction_under(String interactionType) {

		searchWithAllUsingCaseID(interactionType);

	}

	@When("^Select the case from the result$")
	public void select_the_case_from_the_result() {
		selectthePreviousCaseID();

	}

	@When("^Select initiate call for particular case$")
	public void select_initiate_call_for_particular_case() throws Throwable {

		forPreviousCaseID();
	}

	@When("^Filter with Case Id description \"([^\"]*)\" AcNo \"([^\"]*)\" CustName \"([^\"]*)\" and Status \"([^\"]*)\"$")
	public void filter_with_Case_Id_description_AcNo_CustName_and_Status(String desc, String AcNo, String CName,
			String Status) {

	}

	@When("^Click on Create contact button$")
	public void click_on_Create_contact_button() {
		clickCreateContactSAPortal();

	}

	@When("^Enter firstname \"([^\"]*)\" last name \"([^\"]*)\" and submit$")
	public void enter_firstname_last_name_and_submit(String FirstName, String LastName) {

		CreateContactMandatoryDetailsSAPortal(FirstName, LastName);
	}

	// SA Methods

	@Given("^a user is logged into application with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void a_user_is_logged_into_application_with_and(String arg1, String arg2) throws Throwable {
		open();
		login(arg1, arg2);

	}

	@Given("^navigates to \"([^\"]*)\" List page$")
	public void navigates_to_page(String LeftNavItem) {
		sfaPortal = getPortal(SFAPortal.class);
		String CAMPAIGN_Exists;

		switch (LeftNavItem) {
		case "Organizations": {
			orgList = sfaPortal.getLeftNav().getOrganizationList();
			break;
		}
		case "Households": {
			hhList = sfaPortal.getLeftNav().getHouseholdList();
			break;
		}
		case "Accounts": {
			accList = sfaPortal.getLeftNav().getAccountList();
			break;
		}
		case "Contacts": {
			conList = sfaPortal.getLeftNav().getContactList();
			break;
		}
		case "Leads": {
			leadList = sfaPortal.getLeftNav().getLeadsList();
			break;
		}
		case "Opportunities": {

			String CAMPAIGN_LIST_XPATH = "//span[text()='Campaign']";

			if (pegaDriver.verifyElement(By.xpath(CAMPAIGN_LIST_XPATH)))
				campaignExists = true;
			oppList = sfaPortal.getLeftNav().getOpportunityList();
			break;
		}
		case "Territories": {
			terrList = sfaPortal.getLeftNav().getTerritoriesList();
			break;
		}
		case "Operators": {
			oprList = sfaPortal.getLeftNav().getOperatorsList();
			break;
		}
		case "Partners": {
			parList = sfaPortal.getLeftNav().getPartnersList();
			break;
		}
		case "Dashboard": {
			pegaDriver.getActiveFrameId(true);
			Assert.assertTrue(pegaDriver.verifyElement(By.xpath("//div[contains(text(),'Dashboard')]")));
			String frameId = pegaDriver.getActiveFrameId(false);
			PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
			pegaDriver.switchTo().frame(frameId);
			login = new LoginImpl(framElmt, frameId);
			login._setEnvironment(testEnv, frameId);
			break;
		}
		case "Tools": {
			toolsList = sfaPortal.getLeftNav().getToolsList();
			break;
		}
		case "Appointments": {
			appList = sfaPortal.getLeftNav().getAppointmentsList();
			break;
		}
		case "Engagement Map": {
			egMaps = sfaPortal.getLeftNav().getEngagementMaps();
			break;

		}
		case "Pulse": {
			pulseList = sfaPortal.getLeftNav().getPulseList();
			break;
		}
		case "Forecast": {
			forecast = sfaPortal.getLeftNav().getForecast();
			break;
		}
		case "Close plans": {
			closeplans = sfaPortal.getLeftNav().getClosePlans();
			break;
		}

		}
	}

	@When("^clicks on Edit button$")
	public void clicks_on_edit_button() {
		pegaDriver.findElement(By.xpath(EDIT_XPATH)).click();
	}

	@When("^clicks on \"([^\"]*)\" follow icon$")
	public void clicks_on_Follow_button(String WOName) {
		pegaDriver.findElement(By.xpath(WO_FOLLOW_XPATH)).click();

	}

	@When("^Click on switch to Express Mode$")
	public void click_on_switch_to_Express_Mode() throws Throwable {

		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		String SwitchExpress = "//i[@class='pi pi-arrows-ne-sw-join']";
		pegaDriver.findElement(By.xpath(SwitchExpress)).click();
	}

	@Then("^Click on Tools$")
	public void click_on_Tools() throws Throwable {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		String Tools = "//a[contains(text(),'Tools')]";
		pegaDriver.findElement(By.xpath(Tools)).click();
	}

	@Then("^Click on Customer verification$")
	public void click_on_Customer_verification() throws Throwable {
		// String CustomerVerification = "//a[text()='Customer verification']";
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		// pegaDriver.switchToActiveFrame();
		pegaDriver.switchTo().frame("pxExpress");
		String CustomerVerification = "//a[text()='Customer verification' and @data-test-id='20160629063758035710160']";
		pegaDriver.findElement(By.xpath(CustomerVerification)).click();
	}

	@Then("^Click on Interaction and Cases Tab$")
	public void click_on_Interaction_and_Cases_Tab() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		String InteractionAndCases = "//h3[text()='Interactions and Cases']";
		pegaDriver.findElement(By.xpath(InteractionAndCases)).click();

	}

	@Then("^select Level for start of Interaction$")
	public void select_Level_for_start_of_Interaction() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		// pegaDriver.switchTo().frame("PegaGadget0Ifr");
		DropDown levelForStartInteraction = pegaDriver
				.findSelectBox(By.xpath("//select[@data-test-id='201806020309450738246185']"));
		levelForStartInteraction.selectByValue("1");

	}

	@Then("^delete and add service cases with interaction level$")
	public void delete_and_add_service_cases_with_interaction_level(DataTable servicecases) throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");

		List<WebElement> rows = pegaDriver
				.findElements(By.xpath("//table[@pl_prop_class='PegaCS-Data-CasesVerification']/tbody/tr"));
		System.out.println(rows.size() + "is ss sss");
		for (int k = rows.size(); k >= 2; k--) {
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			if (pegaDriver.verifyElement(By
					.xpath("//table[@pl_prop_class='PegaCS-Data-CasesVerification']/tbody/tr[@id='Grid_NoResults']"))) {
				System.out.println("Inside loop no results");
			} else {
				PegaWebElement delticn = pegaDriver
						.findElement(By.xpath("//table[@pl_prop_class='PegaCS-Data-CasesVerification']/tbody/tr[" + k
								+ "]/td[3]/div/span/a"));
				delticn.click();
			}
		}
		List<WebElement> fields = driver.findElements(By.xpath("//input[@data-test-id='2016072109335505834280']"));
		List<List<String>> listOfFields = servicecases.raw();
		int i = 1;
		for (List<String> row : listOfFields) {

			// for(int i=1;i<=fields.size();i++)
			// {

			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			PegaWebElement addField = pegaDriver.findElement(By.xpath("//button[text()='Add service case']"));
			addField.click();
			System.out.println("The value of i before Increment" + i);
			// System.out.println("The value of j before Increment"+j);
			// pegaDriver.switchToActiveFrame();
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			PegaWebElement serviceCases = pegaDriver
					.findElement(By.xpath("(//input[@data-test-id='2016072109335505834280'])[" + i + "]"));
			serviceCases.sendKeys("" + row.get(0) + "");
			serviceCases.sendKeys(Keys.TAB);
			i = i + 1;
			// j=j+1;
			System.out.println("The value of i after Increment" + i);
			// System.out.println("The value of j after Increment"+j);

			// }
		}

	}

	@Then("^Click on Data Type$")
	public void click_on_Data_Type() throws Throwable {
		String Data = "//a[@data-test-id='express-explorer-data']";
		pegaDriver.findElement(By.xpath(Data)).click();
	}

	@When("^Select number of fields,contact fields and customer security fields in Customer verification screen$")
	public void select_number_of_fields_contact_fields_and_customer_security_fields_in_Customer_verification_screen()
			throws Throwable {
		DropDown minNumberFields = pegaDriver.findSelectBox(By.xpath("//select[@id='MinimumFieldsVerification']"));
		minNumberFields.selectByIndex(2);

	}

	@Then("^Select Account Data Class$")
	public void select_Account_Data_Class() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		String AccountClass = "//a[@title='PegaCA-Interface-Account']";
		pegaDriver.findElement(By.xpath(AccountClass)).click();
	}

	@Then("^Select Contact Data Class$")
	public void select_Contact_Data_Class() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		String ContactClass = "//a[@title='PegaCA-Interface-Contact']";
		pegaDriver.findElement(By.xpath(ContactClass)).click();
	}

	@Then("^Select Organization Data Class$")
	public void select_Organization_Data_Class() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		String OrganisationClass = "//a[@title='PegaCA-Interface-BusinessUnit']";
		pegaDriver.findElement(By.xpath(OrganisationClass)).click();

	}

	@Then("^Click on Settings Tab$")
	public void click_on_Settings_Tab() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		// pegaDriver.switchToActiveFrame();
		String SettingsTab = "//h3[contains(text(),'Settings') and @class='layout-group-item-title']";
		pegaDriver.findElement(By.xpath(SettingsTab)).click();
		// String SearchOptions= "//span[contains(text(),'Search Options')]";
		// pegaDriver.findElement(By.xpath(SearchOptions)).click();
	}

	@Then("^Click on Switch to Designer Studio$")
	public void click_on_Switch_to_Designer_Studio() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		String SwitchDesignerStudio = "//i[@class='pi pi-arrows-ne-sw-separate']";
		pegaDriver.findElement(By.xpath(SwitchDesignerStudio)).click();
	}

	@Then("^Launch DesignerStudio$")
	public void launch_DesignerStudio() throws Throwable {
		String LaunchWebInterface = "//a[@title='Launch another portal']";
		pegaDriver.findElement(By.xpath(LaunchWebInterface)).click();
		pegaDriver.switchToActiveFrame();
		String InteractionPortal = "//span[text()='Interaction Portal']";
		pegaDriver.findElement(By.xpath(InteractionPortal)).click();
	}

	@When("^select Account DataSource Fields$")
	public void selectAccountDataSourceFields(DataTable AccountFields) {
		// TODO Auto-generated method stub
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		// pegaDriver.switchTo().defaultContent();
		// pegaDriver.switchToActiveFrame();
		List<List<String>> listOfFields = AccountFields.raw();
		for (List<String> row : listOfFields) {
			// pegaDriver.switchToActiveFrame();
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			PegaWebElement chbk1 = pegaDriver.findElement(By.xpath("//span[text()='" + row.get(0)
					+ "']/ancestor::td[1]/following-sibling::td[1]/descendant::input[@class='checkbox chkBxCtl']"));
			if (!chbk1.isSelected()) {
				chbk1.click();
			}
			// pegaDriver.switchToActiveFrame();
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			PegaWebElement chbk2 = pegaDriver.findElement(By.xpath("//span[text()='" + row.get(0)
					+ "']/ancestor::td[1]/following-sibling::td[2]/descendant::input[@class='checkbox chkBxCtl']"));
			if (!chbk2.isSelected()) {
				chbk2.click();
			}
			// Assert.assertTrue(row.get(0)+" Data Type is not available",
			// pegaDriver.verifyElement(By.xpath("//*[contains(text(),'"+row.get(0)+"')]")));
		}
		pegaDriver.switchTo().defaultContent();
		// pegaDriver.switchToActiveFrame();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		String SaveButton = "//button[@title='Save']";
		PegaWebElement save = pegaDriver.findElement(By.xpath(SaveButton));
		save.click();
	}

	@When("^select Account source fields$")
	public void select_Account_source_fields() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		List<WebElement> sourceFields = driver
				.findElements(By.xpath("//select[@data-test-id='201805170737380328342600']"));
		System.out.println(sourceFields);
		for (int i = 1; i <= sourceFields.size(); i++) {
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			DropDown minNumberFields = pegaDriver
					.findSelectBox(By.xpath("(//select[@data-test-id='201805170737380328342600'])[" + i + "]"));
			minNumberFields.selectByValue("Account");

		}

	}

	/*
	 * @Then("^select fields for Account source$") public void
	 * select_fields_for_Account_source(DataTable Fields) throws Throwable {
	 * pegaDriver.switchTo().defaultContent();
	 * pegaDriver.switchTo().frame("pxExpress");
	 * pegaDriver.switchTo().frame("PegaGadget0Ifr"); List<WebElement> fields =
	 * driver.findElements(By.xpath(
	 * "//select[@data-test-id='201805171007370954171870']")); List<List<String>>
	 * listOfFields = Fields.raw(); int i=1,j=0; for(List<String> row:listOfFields){
	 * //for(int i=1;i<=fields.size();i++) //{
	 * 
	 * 
	 * pegaDriver.switchTo().defaultContent();
	 * pegaDriver.switchTo().frame("pxExpress");
	 * pegaDriver.switchTo().frame("PegaGadget0Ifr");
	 * System.out.println("The value of i before Increment"+i);
	 * //System.out.println("The value of j before Increment"+j);
	 * //pegaDriver.switchToActiveFrame(); DropDown minNumberFields =
	 * pegaDriver.findSelectBox(By.xpath(
	 * "(//select[@data-test-id='201805171007370954171870'])["+i+"]"));
	 * //minNumberFields.click(); //pegaDriver.waitForDocStateReady();
	 * minNumberFields.selectByValue(""+row.get(0)+""); Thread.sleep(1000); i=i+1;
	 * //j=j+1; System.out.println("The value of i after Increment"+i);
	 * //System.out.println("The value of j after Increment"+j);
	 * 
	 * //} } }
	 */
	@When("^select source category$")
	public void select_source_category(DataTable sourcecategory) throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");

		List<WebElement> rows = pegaDriver
				.findElements(By.xpath("//table[@pl_prop_class='PegaCS-Data-FieldsVerification']/tbody/tr"));
		System.out.println(rows.size() + "is ss sss");
		for (int k = rows.size(); k >= 2; k--) {
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			if (pegaDriver.verifyElement(By.xpath(
					"//table[@pl_prop_class='PegaCS-Data-FieldsVerification']/tbody/tr[@id='Grid_NoResults']"))) {
				System.out.println("Inside loop no results");
			} else {
				PegaWebElement delticn = pegaDriver
						.findElement(By.xpath("//table[@pl_prop_class='PegaCS-Data-FieldsVerification']/tbody/tr[" + k
								+ "]/td[6]/div/span/a"));
				delticn.click();
			}
		}
		List<WebElement> fields = driver.findElements(By.xpath("//select[@data-test-id='2016072109335505834280']"));
		List<List<String>> listOfFields = sourcecategory.raw();
		int i = 1;
		for (List<String> row : listOfFields) {

			// for(int i=1;i<=fields.size();i++)
			// {

			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			PegaWebElement addField = pegaDriver.findElement(By.xpath("//button[text()='Add field']"));
			addField.click();
			System.out.println("The value of i before Increment" + i);
			// System.out.println("The value of j before Increment"+j);
			// pegaDriver.switchToActiveFrame();
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			DropDown minNumberFields = pegaDriver
					.findSelectBox(By.xpath("(//select[@data-test-id='2016072109335505834280'])[" + i + "]"));
			minNumberFields.selectByValue("" + row.get(0) + "");
			i = i + 1;
			// j=j+1;
			System.out.println("The value of i after Increment" + i);
			// System.out.println("The value of j after Increment"+j);

			// }
		}

	}

	@Then("^Select fields for Account source$")
	public void select_fields_for_Account_source(DataTable Fields) throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		List<WebElement> fields = driver.findElements(By.xpath("//select[@data-test-id='201806080226100176632890']"));
		List<List<String>> listOfFields = Fields.raw();
		int i = 1;
		for (List<String> row : listOfFields) {

			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			// pegaDriver.switchToActiveFrame();
			DropDown minNumberFields = pegaDriver
					.findSelectBox(By.xpath("(//select[@data-test-id='201806080226100176632890'])[" + i + "]"));

			// minNumberFields.click();
			// pegaDriver.waitForDocStateReady(5);
			minNumberFields.selectByValue("" + row.get(0) + "");
			i = i + 1;
			pegaDriver.waitForDocStateReady(5);
		}
	}

	@Then("^Enter fields in Text for CSR$")
	public void enter_fields_in_Text_for_CSR(DataTable textfields) throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		List<WebElement> fields = driver.findElements(By.xpath("//input[@data-test-id='201806080226100176630370']"));
		List<List<String>> listOfFields = textfields.raw();
		int i = 1;
		for (List<String> row : listOfFields) {

			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			// pegaDriver.switchToActiveFrame();
			PegaWebElement textFields = pegaDriver
					.findElement(By.xpath("(//input[@data-test-id='201806080226100176630370'])[" + i + "]"));

			// minNumberFields.click();
			// pegaDriver.waitForDocStateReady(5);
			textFields.sendKeys("" + row.get(0) + "");
			i = i + 1;
			// pegaDriver.waitForDocStateReady(5);
		}
	}

	@Then("^select Apply for Account source fields$")
	public void select_Apply_for_Account_source_fields() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		List<WebElement> fields = driver.findElements(By.xpath("//select[@data-test-id='201806080226100177631878']"));
		// List<List<String>> listOfFields = Fields.raw();

		// for(List<String> row:listOfFields){
		for (int i = 1; i <= fields.size(); i++) {

			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			// pegaDriver.switchToActiveFrame();
			DropDown minNumberFields = pegaDriver
					.findSelectBox(By.xpath("(//select[@data-test-id='201806080226100177631878'])[" + i + "]"));
			minNumberFields.selectByIndex(1);

		}
	}

	@Then("^select service cases for all Apply to Fields$")
	public void select_service_cases_for_all_Apply_to_Fields() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		List<WebElement> fields = driver.findElements(By.xpath("//select[@data-test-id='201806080226100177631878']"));
		// List<List<String>> listOfFields = Fields.raw();

		// for(List<String> row:listOfFields){
		for (int i = 1; i <= fields.size(); i++) {

			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			// pegaDriver.switchToActiveFrame();
			DropDown minNumberFields = pegaDriver
					.findSelectBox(By.xpath("(//select[@data-test-id='201806080226100177631878'])[" + i + "]"));
			minNumberFields.selectByIndex(2);

		}
	}

	@Then("^select interactions for all Apply to Fields$")
	public void select_interactions_for_all_Apply_to_Fields() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		List<WebElement> fields = driver.findElements(By.xpath("//select[@data-test-id='201806080226100177631878']"));
		// List<List<String>> listOfFields = Fields.raw();

		// for(List<String> row:listOfFields){
		for (int i = 1; i <= fields.size(); i++) {

			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			// pegaDriver.switchToActiveFrame();
			DropDown minNumberFields = pegaDriver
					.findSelectBox(By.xpath("(//select[@data-test-id='201806080226100177631878'])[" + i + "]"));
			minNumberFields.selectByIndex(0);

		}
	}

	@Then("^select level of interaction for all cases$")
	public void select_level_of_interaction_for_all_cases() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		List<WebElement> fields = driver.findElements(By.xpath("//select[@data-test-id='20180516023216098750179']"));
		// List<List<String>> listOfFields = Fields.raw();

		// for(List<String> row:listOfFields){
		for (int i = 1; i <= fields.size(); i++) {

			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			// pegaDriver.switchToActiveFrame();
			DropDown minNumberFields = pegaDriver
					.findSelectBox(By.xpath("(//select[@data-test-id='20180516023216098750179'])[" + i + "]"));
			minNumberFields.selectByIndex(2);

		}

	}

	@When("^select score for Account source fields$")
	public void select_score_for_Account_source_fields() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		List<WebElement> fields = driver.findElements(By.xpath("//input[@data-test-id='201806080226100177629201']"));
		// List<List<String>> listOfFields = Fields.raw();

		// for(List<String> row:listOfFields){
		for (int i = 0; i < fields.size(); i++) {

			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			// pegaDriver.switchToActiveFrame();
			// DropDown minNumberFields =
			// pegaDriver.findSelectBox(By.xpath("(//input[@data-test-id='20180514094632023767885'])["+i+"]"));
			fields.get(i).sendKeys("5");

			// minNumberFields.selectByIndex(4);

		}

	}

	@Then("^select Apply to for Account source fields$")
	public void select_Apply_to_for_Account_source_fields(DataTable applyTo) throws Throwable {
		pegaDriver.switchToActiveFrame();
		List<WebElement> fields = driver.findElements(By.xpath("//select[contains(@name,'VerificationAppliesTo')]"));
		Iterator<WebElement> itr = fields.iterator();
		while (itr.hasNext()) {

			List<List<String>> listOfFields = applyTo.raw();
			for (List<String> row : listOfFields) {
				pegaDriver.switchToActiveFrame();
				DropDown minNumberFields = pegaDriver
						.findSelectBox(By.xpath("//select[contains(@name,'VerificationAppliesTo')]"));
				minNumberFields.selectByValue("" + row.get(0) + "");
				itr.next();
			}
		}
	}

	@Then("^select score for Account fields$")
	public void select_score_for_Account_fields(DataTable score) throws Throwable {
		pegaDriver.switchToActiveFrame();
		List<WebElement> fields = driver.findElements(By.xpath("//select[contains(@name,'VerificationScore')]"));
		Iterator<WebElement> itr = fields.iterator();
		while (itr.hasNext()) {

			List<List<String>> listOfFields = score.raw();
			for (List<String> row : listOfFields) {
				pegaDriver.switchToActiveFrame();
				DropDown minNumberFields = pegaDriver
						.findSelectBox(By.xpath("//select[contains(@name,'VerificationScore')]"));
				minNumberFields.selectByValue("" + row.get(0) + "");
				itr.next();
			}
		}

	}

	@Then("^Validate account datasource selected fields displayed in search section$")
	public void validate_account_datasource_selected_fields_displayed_in_search_section() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();

		Assert.assertTrue("Account number is not present",
				pegaDriver.verifyElement(By.xpath("//div[text()='Account number']")));
		Assert.assertTrue("Account type is not present",
				pegaDriver.verifyElement(By.xpath("//div[text()='Account type']")));
		Assert.assertTrue("Account open date is not present",
				pegaDriver.verifyElement(By.xpath("//div[text()='Account open date']")));
		Assert.assertTrue("Status is not present", pegaDriver.verifyElement(By.xpath("//div[text()='Status']")));
		Assert.assertTrue("First name is not present",
				pegaDriver.verifyElement(By.xpath("//div[text()='First name']")));
		Assert.assertTrue("Last name is not present", pegaDriver.verifyElement(By.xpath("//div[text()='Last name']")));
		// Assert.assertTrue(row.get(0)+" Data Type is not available",
		// pegaDriver.verifyElement(By.xpath("//*[contains(text(),'"+row.get(0)+"')]")));

	}

	@Then("^Validate account datasource selected fields displayed in Advanced section$")
	public void validate_account_datasource_selected_fields_displayed_in_Advanced_section() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();

		Assert.assertTrue("Account number is not present",
				pegaDriver.verifyElement(By.xpath("//label[text()='Account number']")));
		Assert.assertTrue("Account type is not present",
				pegaDriver.verifyElement(By.xpath("//label[text()='Account type']")));
		Assert.assertTrue("Account open date is not present",
				pegaDriver.verifyElement(By.xpath("//label[text()='Account open date']")));
		Assert.assertTrue("Status is not present", pegaDriver.verifyElement(By.xpath("//label[text()='Status']")));
		Assert.assertTrue("First name is not present",
				pegaDriver.verifyElement(By.xpath("//label[text()='First name']")));
		Assert.assertTrue("Last name is not present",
				pegaDriver.verifyElement(By.xpath("//label[text()='Last name']")));
	}

	@Then("^Validate contact datasource selected fields displayed in search section$")
	public void validate_contact_datasource_selected_fields_displayed_in_search_section() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();

		Assert.assertTrue("First name is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='First name']")));
		Assert.assertTrue("Last name is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='Last name']")));
		Assert.assertTrue("SSN is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='SSN']")));
		Assert.assertTrue("Contact ID is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='Contact ID']")));
		Assert.assertTrue("Address line 1 is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='Address line 1']")));
		Assert.assertTrue("Date of Birth is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='Date of birth']")));
		Assert.assertTrue("Middle name is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='Middle name']")));
		// Assert.assertTrue(row.get(0)+" Data Type is not available",
		// pegaDriver.verifyElement(By.xpath("//*[contains(text(),'"+row.get(0)+"')]")));

	}

	@Then("^Validate contact datasource selected fields displayed in Advanced section$")
	public void validate_contact_datasource_selected_fields_displayed_in_Advanced_section() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();

		Assert.assertTrue("First name is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='First name']")));
		Assert.assertTrue("Last name is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='Last name']")));
		Assert.assertTrue("SSN is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='SSN']")));
		Assert.assertTrue("Contact ID is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='Contact ID']")));
		Assert.assertTrue("Address line 1 is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='Address line 1']")));
		Assert.assertTrue("Date of Birth is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='Date of birth']")));
		Assert.assertTrue("Middle name is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='Middle name']")));
	}

	@Then("^Validate organization datasource selected fields displayed in search section$")
	public void validate_organization_datasource_selected_fields_displayed_in_search_section() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();

		Assert.assertTrue("Organization is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='Organization']")));
		Assert.assertTrue("Industry is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='Industry']")));
		Assert.assertTrue("Type is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='Type']")));
		Assert.assertTrue("Tax ID is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='Tax ID']")));
		Assert.assertTrue("Address line 1 is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='Address line 1']")));
		Assert.assertTrue("Address line 2 is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='Address line 2']")));
		Assert.assertTrue("Organization ID is not present in Search section",
				pegaDriver.verifyElement(By.xpath("//div[text()='Organization ID']")));

	}

	@Then("^Validate organization datasource selected fields displayed in Advanced section$")
	public void validate_organization_datasource_selected_fields_displayed_in_Advanced_section() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();

		Assert.assertTrue("Organization is not present in Advanced Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='Organization']")));
		Assert.assertTrue("Industry is not present in Advanced Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='Industry']")));
		Assert.assertTrue("Type is not present in Advanced Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='Type']")));
		Assert.assertTrue("Tax ID is not present in Advanced Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='Tax ID']")));
		Assert.assertTrue("Address line 1 is not present in Advanced Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='Address line 1']")));
		Assert.assertTrue("Address line 2 is not present in Advanced Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='Address line 2']")));
		Assert.assertTrue("Organization ID is not present in Advanced Search section",
				pegaDriver.verifyElement(By.xpath("//label[text()='Organization ID']")));
	}

	/*
	 * @After("@Smoke") public void tearDown(Scenario scenario) {
	 * 
	 * if (scenario.isFailed()) { logout(); } }
	 */

	@When("^User enables display of knowledge articles$")
	public void user_enables_display_of_knowledge_articles() throws Throwable {
		pegaDriver.findElement(By.xpath("//a[text()='Settings']")).click();
		pegaDriver.findElement(By.xpath("//a[text()='Behaviors']")).click();
		pegaDriver.switchToActiveFrame();
		if (!pegaDriver.findElement(By.xpath("//input[@data-test-id='201609280855180087370188']")).isSelected()) {
			pegaDriver.findElement(By.xpath("//input[@data-test-id='201609280855180087370188']")).click();
		}
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath("//button[@data-test-id='2016090106575006263870']")).click();
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath("//button[@data-test-id='Channel-LP-Done']")).click();
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath("//i[@class='pi pi-arrows-ne-sw-separate']")).click();
	}

	@Then("^launch \"([^\"]*)\" page$")
	public void launch_page(String pageName) {

		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		PegaWebElement socialSettingsElement = pegaDriver.findElement(By.xpath("//a[text()='" + pageName + "']"));
		socialSettingsElement.click();

	}

	@Then("^Goto \"([^\"]*)\" tab$")
	public void goto_tab(String tabName) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		String XPath = "//h3[text()='#count#']";
		String finalXPath = new String(XPath).replace("#count#", tabName);
		PegaWebElement tabElement = pegaDriver.findElement(By.xpath(finalXPath));
		tabElement.click();
	}

	@Then("^Click on Settings Tab in express$")
	public void click_on_Settings_Tab_in_express() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		String SettingsTab = "//a[contains(text(),'Settings')]";
		pegaDriver.findElement(By.xpath(SettingsTab)).click(false);
	}

	@Then("^Launch the case$")
	public void launch_the_case() {

		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		System.out.println(CaseID);
		System.out.println(String.valueOf(CaseID));

		PegaWebElement searchBox = pegaDriver.findElement(By.xpath("//input[@data-test-id='2015032417235809251638']"));
		searchBox.clear();
		searchBox.sendKeys(String.valueOf(CaseID));
		pegaDriver.waitForDocStateReady(2);
		searchBox.sendKeys(Keys.ENTER);

		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		newWizard.findElement(By.xpath("//a[contains(text(),'" + CaseID + "')]")).click();

	}

	@Then("^Update threshold to \"([^\"]*)\" mins$")
	public void update_threshold_to_mins(String threshold) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		PegaWebElement thresholdElement = pegaDriver
				.findElement(By.xpath("//input[@data-test-id='20180202043413020554654']"));
		thresholdElement.clear();
		thresholdElement.sendKeys(threshold);
		pegaDriver.findElement(By.xpath("//button[@data-test-id='20180130064636008840163']")).click(false);
		pegaDriver.waitForDocStateReady(2);
	}

	@When("^Click on App Studio$")
	public void click_on_App_Studio() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		PegaWebElement devStudioDropDown = pegaDriver.findElement(By.xpath("//i[@class='pi pi-caret-down pi-light']"));
		devStudioDropDown.click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		PegaWebElement appStudio = pegaDriver.findElement(By.xpath("//span[text()='App Studio']"));
		appStudio.click();

	}

	@Then("^Click on Data$")
	public void click_on_Data() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		// pegaDriver.switchToActiveFrame();
		String Data = "//i[@class='pi pi-data']";
		pegaDriver.findElement(By.xpath(Data)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		String dataModel = "//a[@data-test-id='settings-slider-label']";
		pegaDriver.findElement(By.xpath(dataModel)).click();

	}

	@Then("^Click on Tools in App Studio$")
	public void click_on_Tools_in_App_Studio() throws Throwable {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		// pegaDriver.switchToActiveFrame();
		String ToolsinAppStudio = "//i[@class='pi pi-knobs']";
		pegaDriver.findElement(By.xpath(ToolsinAppStudio)).click();
	}

	@When("^Select maximum no\\.of fields to display and min no\\. of fields to verify for CSR$")
	public void select_maximum_no_of_fields_to_display_and_min_no_of_fields_to_verify_for_CSR() throws Throwable {

		// pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		// pegaDriver.switchTo().frame("PegaGadget0Ifr");
		DropDown maxNumberFieldsVerify = pegaDriver.findSelectBox(By.id("MaximumQuestionsToDisplay"));
		maxNumberFieldsVerify.selectByValue("5");
		// DropDown maxNumberFieldsVerify1 =
		// pegaDriver.findSelectBox(By.id("MaximumFieldsToDisplay"));
		// maxNumberFieldsVerify1.sendKeys(Keys.TAB);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		// pegaDriver.findSelectBox(By.xpath("//select[@id='MaximumFieldsToDisplay']")).click();
		// pegaDriver.findSelectBox(By.xpath("//select[@id='MaximumFieldsToDisplay']")).selectByIndex(5);
		DropDown minNumberFieldsVerify = pegaDriver.findSelectBox(By.id("MinimumFieldsVerification"));
		minNumberFieldsVerify.selectByValue("4");

	}

	@Then("^Verify Customers based on \"([^\"]*)\" fields$")
	public void verify_Customers_based_on_fields(String csrverify) throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		DropDown maxNumberFields = pegaDriver.findSelectBox(By.xpath("//select[@id='VerifyCustomerField']"));
		maxNumberFields.selectByValue(csrverify);
	}

	@Then("^select Required checkbox for Account sources$")
	public void select_Required_checkbox_for_Account_sources() throws Throwable {
		// pegaDriver.switchToActiveFrame();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");

		List<WebElement> checkBox = driver
				.findElements(By.xpath("//input[@type='checkbox' and @data-test-id='20180514094743033970194']"));
		for (int i = 1; i <= checkBox.size(); i++) {
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			PegaWebElement requiredCheckBox = pegaDriver.findElement(
					By.xpath("(//input[@type='checkbox' and @data-test-id='20180514094743033970194'])[" + i + "]"));
			if (!requiredCheckBox.isSelected()) {
				requiredCheckBox.click();
			}
			// requiredCheckBox.click();

		}
	}

	@Then("^select Use for Owner checkbox for Account source$")
	public void select_Use_for_Owner_checkbox_for_Account_source() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");

		List<WebElement> checkBox = driver
				.findElements(By.xpath("//input[@type='checkbox' and @data-test-id='201805150257300490224783']"));
		for (int i = 1; i <= checkBox.size(); i++) {
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			PegaWebElement requiredCheckBox = pegaDriver.findElement(
					By.xpath("(//input[@type='checkbox' and @data-test-id='201805150257300490224783'])[" + i + "]"));
			if (!requiredCheckBox.isSelected()) {
				requiredCheckBox.click();
			}
			// requiredCheckBox.click();

		}

	}

	@Then("^select include security questions checkbox$")
	public void select_include_security_questions_checkbox() throws Throwable {
		// pegaDriver.switchToActiveFrame();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		PegaWebElement managesecurityquescheckbox = pegaDriver
				.findElement(By.xpath("//input[contains(@name,'SecurityQuestionsSelected') and @type='checkbox']"));
		if (!managesecurityquescheckbox.isSelected()) {
			managesecurityquescheckbox.click();
		}
	}

	@Then("^click on Save and Close$")
	public void click_on_Save_and_Close() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		PegaWebElement save = pegaDriver.findElement(By.xpath("//button[text()='Save']"));
		save.click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		PegaWebElement close = pegaDriver.findElement(By.xpath("//button[text()='Close']"));
		close.click();
	}

	@Then("^verify fields for Account source$")
	public void verify_fields_for_Account_source(DataTable verifyfields) throws Throwable {
		pegaDriver.switchTo().defaultContent();
		// pegaDriver.switchTo().frame("pxExpress");
		pegaDriver.switchTo().frame("PegaGadget1Ifr");
		// List<WebElement> fields =
		// driver.findElements(By.xpath("//select[@data-test-id='201805171007370954171870']"));
		List<List<String>> listOfFields = verifyfields.raw();
		// int i=1,j=0;
		for (List<String> row : listOfFields) {
			// for(int i=1;i<=fields.size();i++)
			// {

			pegaDriver.switchTo().defaultContent();
			// pegaDriver.switchTo().frame("pxExpress");
			pegaDriver.switchTo().frame("PegaGadget1Ifr");
			// System.out.println("The value of i before Increment"+i);
			// System.out.println("The value of j before Increment"+j);
			// pegaDriver.switchToActiveFrame();
			Assert.assertTrue("" + row.get(0) + " is not present in Verification section",
					pegaDriver.verifyElement(By.xpath("//span[text()='" + row.get(0) + "']")));

			// }
		}

	}

	@Then("^switch to Dev Studio$")
	public void switch_to_Dev_Studio() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		PegaWebElement devStudioDropDown = pegaDriver.findElement(By.xpath("//a[@data-test-id='switch-wks']"));
		devStudioDropDown.click();
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("pxExpress");
		// pegaDriver.switchTo().defaultContent();
		// pegaDriver.switchTo().frame("pxExpress");
		PegaWebElement devStudio = pegaDriver.findElement(By.xpath("//span[text()='Dev Studio']"));
		devStudio.click();
		pegaDriver.waitForDocStateReady(3);
	}

	@Then("^user logs off from designer studio$")
	public void user_logs_off_from_designer_studio() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		// pegaDriver.switchTo().frame("pxExpress");
		// pegaDriver.switchTo().frame("FormFactoriFrame");

		PegaWebElement logoff = pegaDriver.findElement(
				By.xpath("//i[contains(@class,'icons avatar name') and @data-test-id='px-opr-image-ctrl']"));
		logoff.click(false);
		// pegaDriver.switchTo().defaultContent();
		// pegaDriver.switchTo().frame("FormFactoriFrame");
		// pegaDriver.switchTo().frame("PegaGadget0Ifr");
		PegaWebElement logout = pegaDriver.findElement(By.xpath("//span[text()='Log off']"));
		logout.click(false);
		try {
			// pegaDriver.waitForDocStateReady(1);

			pegaDriver.handleWaits().waitForAlert();
			pegaDriver.switchTo().alert().accept();

		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	@When("^Filter with \"([^\"]*)\"and select the organization$")
	public void filter_with_and_select_the_organization(String orgname) throws Throwable {
		selectorgFromSearch(orgname);
	}

}
