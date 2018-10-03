package com.pega.crm.customerservice.stepdefs;

import com.google.inject.Inject;
import com.pega.Browser;
import com.pega.CRMBrowser;
import com.pega.explorer.DesignerStudio;
import customerservice.CSPortal;
import customerservice.interactions.DialogsAndCoachingTips;
import customerservice.interactions.Interactions;
import customerservice.interactions.NewDemoInteraction;
import customerservice.interactions.NewInboundInteraction;
import customerservice.interactions.OutboundPhoneCall;
import customerservice.interactions.PhoneCall;
import customerservice.interactions.ResearchInteraction;
import customerservice.tiles.TopNav;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class TopNavglue {

	private CSPortal csPortal;
	private Browser browser;
	private NewDemoInteraction demoInteraction;
	private PhoneCall phoneCall;
	private ResearchInteraction researchInteraction;
	private NewInboundInteraction inboundInteraction;
	private DialogsAndCoachingTips dialogsAndCoachingTips;
	private OutboundPhoneCall outboundPhoneCall;
	private TopNav topnav;
	public String[] caseStatus = new String[10];
	private customerservice.designerstudio.ApplicationWizard applicationWizard;
	private Interactions interactions;
	private DesignerStudio designerStudio;

	@Inject
	public TopNavglue(CRMBrowser browser) {
		this.browser = browser;
		topnav = browser.getPortal(CSPortal.class).getTopNav();
	}

	@When("^Demo Interaction for Sara Connor is started$")
	public void demo_Interaction_for_Sara_Connor_is_started() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		demoInteraction = csPortal.getTopNav().getInteractionType("Demo Pop - CONNOR");
		interactions = demoInteraction;
	}

	@When("^CSR Accpets the Interaction$")
	public void csr_Accpets_the_Interaction() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		demoInteraction = csPortal.getTopNav().returnInteractionType("Accept");
		interactions = demoInteraction;
	}
	
	@When("^CSR launched the New Phone Interaction$")
	public void csr_launched_the_New_Phone_Interaction() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		phoneCall = csPortal.getTopNav().getInteractionType("Phone Call");// c
																			// changed
																			// to
																			// C
		interactions = phoneCall;
	}

	@When("^CSR launches Demo Interaction for \"([^\"]*)\"$")
	public void csr_launches_Demo_Interaction_for(String demoInteraction) throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		this.demoInteraction = csPortal.getTopNav().getDemoInteractionType(demoInteraction);
		interactions = this.demoInteraction;

	}
	@When("^User launches demo interaction \"([^\"]*)\"$")
	public void user_launches_demo_interaction(String demoInteraction) throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		this.demoInteraction = csPortal.getTopNav().getDemoInteractionType(demoInteraction);
		interactions = this.demoInteraction;
	}
	@When("^User launches demo interaction as manager \"([^\"]*)\"$")
	public void user_launches_demo_interaction_as_manager(String demoInteraction) throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		this.demoInteraction = csPortal.getTopNav().getDemoInteractionTypeAsManager(demoInteraction);
		interactions = this.demoInteraction;
	}
	/*@When("^CSR logs into chat queue \"([^\"]*)\" with display name \"([^\"]*)\"$")
	public void csr_logs_into_chat_queue_with_display_name(String chatServer, String displayName) throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		chatInteraction = csPortal.getTopNav().chatAgentLogin(chatServer, displayName);
		interactions = chatInteraction;
	}*/
	

	@When("^CSR launches Inbound Interaction$")
	public void csr_launches_Inbound_Interaction() {
		csPortal = browser.getPortal(CSPortal.class);
		inboundInteraction = csPortal.getTopNav().startInboundCase();
		interactions = inboundInteraction;
	}

	@Then("^User places an outbound phone call$")
	public void user_places_an_outbound_phone_call() {
		csPortal = browser.getPortal(CSPortal.class);
		outboundPhoneCall = csPortal.getTopNav().getInteractionType("Outbound Phone Call");
		System.out.println(outboundPhoneCall);
		interactions = outboundPhoneCall;
	}

	@Then("^CSR launches Outbound Demo Interaction for \"([^\"]*)\"$")
	public void csr_launches_Outbound_Demo_Interaction_for(String outboundSimulationText) {
		csPortal = browser.getPortal(CSPortal.class);
		outboundPhoneCall = csPortal.getTopNav().getDemoInteractionType(outboundSimulationText);
		interactions = outboundPhoneCall;
	}
	
	

	// @When("^CSR searches \"([^\"]*)\"$")
	// public void csr_searches(String searchText) {
	//
	//
	// csPortal.getTopNav().searchPortal(searchText);
	//
	//
	// }

	// @Then("^CSR launches research interaction \"([^\"]*)\"$")
	// public void csr_launches_research_interaction(String searchText) {
	//
	// researchInteraction = csPortal.getTopNav().searchResult(searchText);
	// interactions = researchInteraction;
	//// pegaDriver.findElement(By.xpath("//a[contains(@title,'Connor')][text()='Connor']")).click();
	// }

	@When("^CSR launches \"([^\"]*)\" research interaction \"([^\"]*)\"$")
	public void csr_launches_research_interaction(String interactionType, String searchText) {

		csPortal = browser.getPortal(CSPortal.class);
		researchInteraction = csPortal.getTopNav().searchResult(interactionType, searchText);
		interactions = researchInteraction;
	}

	@When("^CSR searches for \"([^\"]*)\" from search portal$")
	public void csr_searches_for_from_search_portal(String searchString) {
		csPortal = browser.getPortal(CSPortal.class);
		researchInteraction = csPortal.getTopNav().search(searchString);
		interactions = researchInteraction;
	}

	@When("^Select the result \"([^\"]*)\" displayed$")
	public void select_the_result_displayed(String result) {
		csPortal = browser.getPortal(CSPortal.class);
		researchInteraction = csPortal.getTopNav().searchDropDownresult(result);
		interactions = researchInteraction;

	}
	

	
	@When("^Select the Account \"([^\"]*)\" for Initiate a Call displayed$")
	public void select_the_Account_for_Initiate_a_Call_displayed(String result)  {
	    // Write code here that turns the phrase above into concrete actions
		csPortal = browser.getPortal(CSPortal.class);
		researchInteraction = csPortal.getTopNav().initiateACall(result);
		interactions = researchInteraction;
	}

	@When("^close the research interaction flow$")
	public void close_the_research_interaction_flow() {
		csPortal = browser.getPortal(CSPortal.class);
		researchInteraction = csPortal.getTopNav().closeInteraction();
		interactions = researchInteraction;

	}
	
	/*@When("^Create Dialog for a service case$")
	public void create_Dialog_for_a_service_case() {
		csPortal = browser.getPortal(CSPortal.class);
		dialogsAndCoachingTips = csPortal.getTopNav().ConfigDialog();
		interactions = dialogsAndCoachingTips;
	}*/

	/*
	 * @When("^search for I- and S- items$") public void
	 * search_for_I_and_S_items() { List<String> caseIds = (List<String>)
	 * ObjectsBean.getObjectsMap().get("caseids");
	 * 
	 * 
	 * 
	 * for(int i=0; i<caseIds.size(); i++){ topnav.searchPortal(caseIds.get(i));
	 * caseStatus[i] = topnav.getStatusOfCase(); }
	 * System.out.println(caseStatus); }
	 */

	/*
	 * @Then("^verify the status$") public void verify_the_status() {
	 * 
	 * 
	 * }
	 */

	@When("^User_Hz Clicks on New Application$")
	public void user_hz_Clicks_on_New_Application() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		applicationWizard = csPortal.getTopNav().createApplication("Test12345");

	}
	@When("^User clicks on New Application$")
	public void user_clicks_on_New_Application() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		applicationWizard = csPortal.getTopNav().launchNewAppWizard();
	}
	@When("^User starts creating new application$")
	public void user_starts_creating_new_application() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		applicationWizard = csPortal.getTopNav().createNewApplication("App", "Customer ", "All", "All", true,"All");
	}
	
	@When("^User selects application type \"([^\"]*)\"$")
	public void user_selects_application_type(String AppName) throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().selectApp(AppName);
	}
	@When("^user selects use this application type$")
	public void user_selects_use_this_application_type() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().clickOnUseThisApp();
	    
	}

	@When("^user submits the case types \"([^\"]*)\"$")
	public void user_submits_the_case_types(String SelectAllFlag, DataTable CaseType) throws Throwable {
		
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().selectCaseTypes(SelectAllFlag, CaseType);
	}
	@When("^user submits the Channels \"([^\"]*)\"$")
	public void user_submits_the_Channels(String SelectAllFlag, DataTable Channel) throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().selectChannels(SelectAllFlag, Channel);
	}
	@When("^user submits data types \"([^\"]*)\"$")
	public void user_submits_data_types(String SelectAllFlag, DataTable DataType) throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().selectDataTypes(SelectAllFlag, DataType);
	}
	@When("^user submits CUSTOMER DECISION HUB as \"([^\"]*)\"$")
	public void user_submits_CUSTOMER_DECISION_HUB_as(String Flag) throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().selectCDH(Flag);
	}
	@When("^user click on advanced configuration$")
	public void user_click_on_advanced_configuration() throws Throwable {
	   
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().advancedSettings();
	}
	@When("^user selects application structure as \"([^\"]*)\"$")
	public void user_selects_application_structure_as(String AppStructure) throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().selectAppStructure(AppStructure);
	}
	@When("^user clicks on create new application$")
	public void user_clicks_on_create_new_application() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().clicksOnCreateApp();
	}
	@When("^user modifies access group to new app$")
	public void user_modifies_access_group_to_new_app() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().modifyAccessGroupNew();
	}
	@When("^user modifies access group to cs sample$")
	public void user_modifies_access_group_to_cs_sample() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().modifyAccessGroupToCS();
	}
	@When("^user deletes new application access group$")
	public void user_deletes_new_application_access_group() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().deletesNewAppAccessGroup();
	}
	@When("^user switches to new application$")
	public void user_switches_to_new_application() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().switchToNewApplication();
	}
	@When("^user logs of from designer studio$")
	public void user_logs_of_from_designer_studio() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().logOutDS();
	}
	@When("^User selects following navigation from designer studio$")
	public void user_selects_following_navigation_from_designer_studio(DataTable ListOfValues) throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().selectNavigationFromDS(ListOfValues);
	}
	@When("^User clicks on Query settings$")
	public void user_clicks_on_Query_settings() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().clickOnQuerySettingsTab();
	}
	@When("^User checks \"([^\"]*)\"$")
	public void user_checks(String CheckBox) throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().checkSearch(CheckBox);
	}
	@When("^User clicks on button Re-index  of \"([^\"]*)\" and confirms$")
	public void user_clicks_on_button_and_confirms(String ReindexOf) throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().Reindex(ReindexOf);
	}
	
	public NewDemoInteraction getDemoInteraction() {
		return demoInteraction;
	}

	public PhoneCall getPhoneCall() {
		return phoneCall;
	}



	public ResearchInteraction getResearchInteraction() {

		return researchInteraction;
	}

	public NewInboundInteraction getInboundInteraction() {
		return inboundInteraction;
	}

	public DialogsAndCoachingTips getDialogsAndCoachingTips() {
		return dialogsAndCoachingTips;
	}

	public Interactions getInteractions() {
		return interactions;
	}

	public OutboundPhoneCall getOutboundPhoneCall() {
		return outboundPhoneCall;
	}

	public customerservice.designerstudio.ApplicationWizard getApplicationWizard() {

		return applicationWizard;
	}
	


	
	@When("^Admin launches social landing page$")
	public void admin_launches_social_landing_page()  {

		DesignerStudio designerStudio = browser.getPortal(DesignerStudio.class);
        System.out.println("got DS object");
        designerStudio.getTopNav().openLandingPage("Channel Services", "Pega Social"); 
	}
	
	
	@When("^Admin starts dataflows$")
	public void admin_starts_dataflows() {
		
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().startDataFlow();
		
		
	}
	
	@Then("^Admin check for the dataflow status$")
	public void admin_check_for_the_dataflow_status() {
	   
//		csPortal = browser.getPortal(CSPortal.class);
//		csPortal.getTopNav().checkDataFlow();
		
	}
	
	@Then("^social admin logs of from designer studio$")
	public void social_admin_logs_of_from_designer_studio() {
	    
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().socialLogOutDS();
	}
	@When("^Click on Search Configuration$")
	public void click_on_Search_Configuration() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().clickSearchConfiguration();
	}

	@When("^Admin stops dataflows$")
	public void admin_stops_dataflows() {
		
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().stopDataFlow();
		
		
	}

	@When("^Select Account Data Source$")
	public void select_Account_Data_Source() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().selectDataSource();
	}
	@When("^Select Contact Data Source$")
	public void select_Contact_Data_Source() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().selectContactDataSource();
	}
	@When("^Select Organization Data Source$")
	public void select_Organization_Data_Source() throws Throwable {
		csPortal = browser.getPortal(CSPortal.class);
		csPortal.getTopNav().selectOrganizationDataSource();
	}
	
	  @When("^Select Fields displayed in Search and Advanced Search$")
		public void select_Fields_displayed_in_Search_and_Advanced_Search(DataTable AccountFields) throws Throwable {
		  csPortal = browser.getPortal(CSPortal.class);
			csPortal.getTopNav().selectAccountDataSourceFields(AccountFields);
		  
			} 
		   
	  @When("^Admin adds a DSM node$")
		public void admin_adds_a_DSM_node() {
//		  DesignerStudio designerStudio = browser.getPortal(DesignerStudio.class);
//	        System.out.println("got DS object");
//	        designerStudio.getTopNav().openLandingPage(DecisioningServices.class, "Decisioning","Infrastructure","Services","Data Flow");
//	        csPortal = browser.getPortal(CSPortal.class);
//			csPortal.getTopNav().addDSMNode();
////		  
			csPortal = browser.getPortal(CSPortal.class);
//			csPortal.getTopNav().selectNavigationFromDS(ListOfValues);
			csPortal.getTopNav().openLandingPage("Designer Studio ","Decisioning","Infrastructure","Services","Data Flow");
			csPortal.getTopNav().addDSMNode();
		  
		} 

	  @When("^User switches to interaction portal from operator menu$")
	  public void user_switches_to_interaction_portal_from_operator_menu() throws Throwable {
			csPortal = browser.getPortal(CSPortal.class);
			csPortal.getTopNav().SwitchToInteractionPortal();
	  
	  } 
	  
	  @When("^admin adds DSM Nodes in \"([^\"]*)\" tab$")
	  public void admin_adds_DSM_Nodes_in_tab(String tabName) throws Throwable {
		  csPortal = browser.getPortal(CSPortal.class);
			csPortal.getTopNav().openLandingPage("Designer Studio","Decisioning","Infrastructure","Services",tabName);
			csPortal.getTopNav().addDSMNodesInDecisionDataStore();
			csPortal.getTopNav().switchToDSMTabs("Adaptive Decision Manager");
			csPortal.getTopNav().addDSMNodesInAdaptiveDecisionManager();		
			csPortal.getTopNav().switchToDSMTabs("Data flow");
			csPortal.getTopNav().addDSMNodesInDataFlow();			
			csPortal.getTopNav().switchToDSMTabs("Real-time Data Grid");
			csPortal.getTopNav().addDSMNodesInRealTimeDataGrid();			
			csPortal.getTopNav().switchToDSMTabs("Stream");
			csPortal.getTopNav().addDSMNodesInStream();
			
	  }
	  
	
	  @When("^Launch \"([^\"]*)\" service process in Express$")
	  public void launch_service_process_in_Express(String arg1) throws Throwable {
		  csPortal = browser.getPortal(CSPortal.class);
			csPortal.getTopNav().launchServiceProcessExpress();
	  }

	  @When("^User navigates to section and clicks on Edit icon$")
	  public void user_navigates_to_section_and_clicks_on_Edit_icon() throws Throwable {
		  csPortal = browser.getPortal(CSPortal.class);
			csPortal.getTopNav().launchServiceProcessExpress();
	  }
	 

	 
		}
	

	

