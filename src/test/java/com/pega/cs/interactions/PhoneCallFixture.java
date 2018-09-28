package com.pega.cs.interactions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.google.inject.Inject;
import com.pega.MyTestEnvironment;
import com.pega.ObjectsBean;
import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;
import com.pega.tiles.TopNavFixture;
import customerservice.CSPortal;
import customerservice.interactions.Interactions;
import customerservice.interactions.PhoneCall;
import customerservice.interactions.ResearchInteraction;
import customerservice.utils.CommonMethods;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;


@ScenarioScoped

public class PhoneCallFixture {

	private PhoneCall phoneInteraction;
	private Interactions interaction;
	private ResearchInteraction researchInteraction;
	private CommonMethods commonMethods;
	private PegaWebDriver pegaDriver;
	TestEnvironment testEnv;
	private CSPortal csPortal;
	public String frameId = null;
	public Wizard newWizard = null;
	public List<String> caseId = new ArrayList();
	public static String CaseID = null;
	public String FOLLOW_CASE_ID = "//div[@id='CT']/span";
	@Inject
	public PhoneCallFixture(TopNavFixture topNavFixture, MyTestEnvironment testEnv) {
		phoneInteraction = topNavFixture.getPhoneCall();
		//demoInteraction = topNavFixture.getDemoInteraction();
		interaction = topNavFixture.getInteractions();
		commonMethods = testEnv.getCommonMethods();
		pegaDriver = testEnv.getPegaDriver();
		researchInteraction = topNavFixture.getResearchInteraction();
	}

	@Then("^Verify Initial dialog and other fields and buttons$")
	public void verify_Initial_dialog_and_other_fields_and_buttons() {
		//pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath(PhoneCall.UNKNOWN_CUSTOMER_XPATH));
		Assert.assertTrue("Unknown customer field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.UNKNOWN_CUSTOMER_XPATH)));
		Assert.assertTrue("Contact information field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CONTACT_INFO_XPATH)));
		Assert.assertTrue("CUSTOMER SUMMARY field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CUSTOMER_SUMMARY_XPATH)));
		Assert.assertTrue("Relationship field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.RELATIONSHIP_XPATH)));
		pegaDriver.switchToActiveFrame();
		
		//Assert.assertTrue("Add task button is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.ADDTASK_XPATH)));
		//Assert.assertTrue("Wrap Up button is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.WRAP_UP_XPATH)));
		
		//Assert.assertTrue("Initial dialog is not present", pegaDriver.verifyElement(By.xpath("//div[contains(text(), 'Thank you for contacting U+Bank.  My name is    CS CSR. How can I help you today?')]")));
		//Assert.assertTrue("Search for Customer In progress field is not present",pegaDriver.verifyElement(By.xpath("//a[@title='Current action label']")));
		/*Assert.assertTrue("Search for customer flow action header is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Start interaction with customer']")));
		Assert.assertTrue("Tools Menu button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@title='Tools menu']")));
		Assert.assertTrue("Other Actions buttons is not present",
				pegaDriver.verifyElement(By.xpath("//button[@title='Other actions']")));*/
		Assert.assertTrue("Search text is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.SEARCH_XPATH)));
		Assert.assertTrue("General assistance text is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.GENERAL_ASSISTANCE_XPATH)));
		Assert.assertTrue("Add new customer text is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.ADD_NEW_CUSTOMER_XPATH)));
		
		//caseId.add(phoneInteraction.getCaseID());

	}
	
	@Then("^Verify Initial dialog and other fields and buttons for mike$")
	public void verify_Initial_dialog_and_other_fields_and_buttons_for_mike() throws Throwable {
		//pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		Assert.assertTrue("Unknown customer field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.UNKNOWN_CUSTOMER_XPATH)));
		Assert.assertTrue("Contact information field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CONTACT_INFO_XPATH)));
		Assert.assertTrue("CUSTOMER SUMMARY field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CUSTOMER_SUMMARY_XPATH)));
		Assert.assertTrue("Relationship field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.RELATIONSHIP_XPATH)));
		pegaDriver.switchToActiveFrame();
		
		Assert.assertTrue("Add task button is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.ADDTASK_XPATH)));
		Assert.assertTrue("Wrap Up button is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.WRAP_UP_XPATH)));
		Assert.assertTrue("Initial dialog is not present", pegaDriver.verifyElement(By.xpath("//div[contains(text(),'         Thank you for contacting U+Bank.  My name is    Mike Jones. How can I help you today?     ')]")));
		
		Assert.assertTrue("Search text is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.SEARCH_XPATH)));
		Assert.assertTrue("General assistance text is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.GENERAL_ASSISTANCE_XPATH)));
		Assert.assertTrue("Add new customer text is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.ADD_NEW_CUSTOMER_XPATH)));
			    
	}
	//div[contains(text(),'         Thank you for contacting U+Bank.  My name is    Mike Jones. How can I help you today?     ')]

	@When("^Click on Tools Menu button$")
	public void click_on_Tools_Menu_button() {
		interaction.clickOnToolsMenuButton();

	}

	@Then("^Verify Menu Options after clicking on tools menu buttons$")
	public void verify_Menu_Options_after_clicking_on_tools_menu_buttons() {
		//Assert.assertTrue("Where Am I menu option is not present",pegaDriver.verifyElement(By.xpath("//span[text()='Where am I?']")));
		Assert.assertTrue("History and Attachment option is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='History and Attachments']")));
		Assert.assertTrue("Pulse option is not present", pegaDriver.verifyElement(By.xpath("//span[text()='Pulse']")));
		PegaWebElement Refresh = pegaDriver.findElement(By.xpath("//span[text()='Refresh']"));
		Refresh.click();
		
	}
	@Then("^Verify Tools menu and other actions options$")
	public void verify_Tools_menu_Options(DataTable options) throws Throwable {
		List<List<String>> listOfOptions = options.raw();
		for(List<String> row:listOfOptions){
			Assert.assertTrue(row.get(0)+" option is not present",
					pegaDriver.verifyElement(By.xpath("//span[contains(text(),'"+row.get(0)+"')]")));
		}
		
	}
	@Then("^Verifies following fields at Configuration pop up window$")
	public void verifies_following_fields_at_Configuration_pop_up_window(DataTable fields) throws Throwable {
		List<List<String>> listOfFields = fields.raw();
		for(List<String> row:listOfFields){
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("PegaGadget2Ifr");
			Assert.assertTrue(row.get(0)+" field is not present",
					pegaDriver.verifyElement(By.xpath("//*[contains(text(),'"+row.get(0)+"')]")));
		}
	}
	@When("^User selects \"([^\"]*)\" tab at Configuration pop up window$")
	public void user_selects_tab_at_Configuration_pop_up_window(String tabName) throws Throwable {
	  interaction.selectTabAtConfigTools(tabName);
	}
	@When("^User deletes all existing dialogs$")
	public void user_deletes_all_existing_dialogs() throws Throwable {
		interaction.deleteAllExistingDialogs();
	}

	@When("^User adds a new dialog \"([^\"]*)\"$")
	public void user_adds_a_new_dialog(String dialog) throws Throwable {
		interaction.configureNewDialog(dialog);
	}
	@When("^User updates existing dialog \"([^\"]*)\"$")
	public void user_updates_existing_dialog(String dialog) throws Throwable {
		interaction.updateDialog(dialog);
	}
	@Then("^User verifies configured dialog \"([^\"]*)\"$")
	public void user_verifies_configured_dialog(String Dialog) throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget2Ifr");
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//div[contains(text(),'"+Dialog+"')]"));
		Assert.assertTrue("Configured dialog not available.",pegaDriver.verifyElement(By.xpath("//div[contains(text(),'"+Dialog+"')]")));
	}
	@Then("^User verifies configured dialog$")
	public void user_verifies_configured_dialog() throws Throwable {
		
	}
	@When("^User deletes all existing coaching tips$")
	public void user_deletes_all_existing_coaching_tips() throws Throwable {
		interaction.deleteAllExistingCoachingTips();
	}
	@When("^User deletes all assigned coaching tips$")
	public void user_deletes_all_assigned_coaching_tips() throws Throwable {
		interaction.deleteAllAssignedCoachingTips();
	}
	@When("^User adds a new coaching tip with name \"([^\"]*)\" and coaching tip \"([^\"]*)\"$")
	public void user_adds_a_new_coaching_tip_with_name_and_coaching_tip(String CoachingTipName, String CoachingTip) throws Throwable {
		interaction.createNewCoachingTips(CoachingTipName,CoachingTip);
	}

	@When("^User assigns coaching tip \"([^\"]*)\" to a \"([^\"]*)\" has value \"([^\"]*)\" with from date \"([^\"]*)\" and to date \"([^\"]*)\"$")
	public void user_assigns_coaching_tip_to_a_has_value_with_from_date_and_to_date(String CoachingTipName, String AssignTo, String AssignToValue, String FromDate,
			String ToDate) throws Throwable {
		interaction.assignCoachingTips(CoachingTipName, AssignTo, AssignToValue, FromDate, ToDate);
	}

	@Then("^User verifies configured coaching tip \"([^\"]*)\"$")
	public void user_verifies_configured_coaching_tip(String arg1) throws Throwable {
	   
	}

	@Then("^User updates existing coaching tip \"([^\"]*)\" with \"([^\"]*)\"$")
	public void user_updates_existing_coaching_tip_with(String CoachingTipName, String CoachingTip) throws Throwable {
		interaction.updateCoachingTips(CoachingTipName,CoachingTip); 
	}
	@When("^Click on Other Actions button$")
	public void click_on_Other_Actions_button() {
		interaction.clickOnOtherActionsButton();
	}
	@When("^Click on \"([^\"]*)\" Action button$")
	public void click_on_Action_button(String buttonName) throws Throwable {
		interaction.clickOnOtherActionsButton();
	    interaction.clickOnActionsitem(buttonName);
	}

	@Then("^Verify Exit interaction page is displayed$")
	public void verify_Exit_interaction_page_is_displayed() throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		
		Assert.assertTrue("Exit interaction title is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Exit interaction']")));
		Assert.assertTrue("Comments title is not present",
				pegaDriver.verifyElement(By.xpath("//label[text()='Comments']")));
				
	}

	@When("^Click on submit to exit the interaction$")
	public void click_on_submit_to_exit_the_interaction() throws Throwable {
		interaction.exitInteractionwithcomment();
	 }
	
	
	@When("^Click on submit to complete cancel work flow$")
	public void click_on_submit_to_complete_cancel_work_flow() throws Throwable {
		interaction.exitInteractionwithcomment();
	    
	}

	@Then("^Verify Menu Options after clicking on Other Actions buttons$")
	public void verify_Menu_Options_after_clicking_on_Other_Actions_buttons() {
		Assert.assertTrue("Refresh menu option is not present",pegaDriver.verifyElement(By.xpath("//span[text()='Refresh']")));
		Assert.assertTrue("Exit Interaction option is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Exit interaction']")));
		//Removing the assertions as this fields are removed in 7.31 Beta build
	}
	
	@When("^Search for the Customer with Contact Name \"([^\"]*)\"$")
	public void search_for_the_Customer_with_Contact_Name(String name)  {
		interaction.searchCustomerByName(name);
	}
	@Then("^Search for the Customer with Last Name \"([^\"]*)\"$")
	public void search_for_the_Customer_with_Last_Name(String Lastname) throws Throwable {
		interaction.searchCustomerByLastName(Lastname);
	}
	@When("^Get the id for the case$")
	public String get_the_id_for_the_case(){
		pegaDriver.waitForDocStateReady(1);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		String followCaseID = pegaDriver.findElement(By.xpath(FOLLOW_CASE_ID)).getText();
		System.out.println(followCaseID);
		CaseID = followCaseID.substring(1,followCaseID.length()-1);
		CaseID=CaseID.trim();
		System.out.println(CaseID);
		return CaseID;
		
	}

	@When("^Filter with case ID$")
	public void filter_with_case_ID() throws Throwable {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		
		System.out.println(CaseID);
		System.out.println(String.valueOf(CaseID));

		PegaWebElement searchBox = pegaDriver.findElement(By.xpath("//input[@title='Search for a Case']"));
		searchBox.clear();
		searchBox.sendKeys(String.valueOf(CaseID));
		pegaDriver.waitForDocStateReady(2);
		searchBox.sendKeys(Keys.ENTER);


	}
	@When("^Search for the Customer with Contact Name \"([^\"]*)\" Inbound$")
	public void search_for_the_Customer_with_Contact_Name_Inbound(String name) {
	    interaction.searchCustomerByNameInbound(name);
	}


	@When("^select result from the result and proceed$")
	public void select_from_the_result_and_proceed() {
		interaction.selectCustomer();
	}
	
	@When("^Select first entry from results and proceed$")
	public void select_first_entry_from_results_and_proceed() throws Throwable {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		List<WebElement> rows = pegaDriver
				.findElements(By.xpath("//tr[contains(@id,'PD_Search_Customer$ppxResults')]"));
		rows.get(0).click();
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement submit = newWizard.findElement(By.xpath("//button[@title='Complete this assignment']"));
		submit.click();
	}
	
	
	@When("^select result from the BU contact result and proceed$")
	public void select_from_the_BU_contact_result_and_proceed() {
		interaction.selectBUCustomer();
	}
	
	
	@When("^Select \"([^\"]*)\" from the results displayed$")
	public void select_from_the_results_displayed(String username) throws Throwable {
	    interaction.selectCustomerfromresult(username);
	}
	
	@When("^Select the required result for BU \"([^\"]*)\"$")
	public void select_the_required_result_for_BU(String required) throws Throwable {
		interaction.selectrequiredBU(required);
	}

	@When("^select account from inbound search results and proceed$")
	public void select_account_from_inbound_search_results_and_proceed() {
	    interaction.selectInboundCustomer();
	}
	
	@When("^click on Submit without selecting the verification questions$")
	public void click_on_Submit_without_selecting_the_verification_questions() throws Throwable {
		interaction.submitWithoutSelectingQuestions();
	    
	}

	@Then("^Verify the Error messages are displayed$")
	public void verify_the_Error_messages_are_displayed() throws Throwable {
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchToActiveFrame();
		
		Assert.assertTrue("Error message is not present",
				pegaDriver.verifyElement(By.xpath("//li[contains(.,'Contact Name:Contact not verified, please answer all questions.')]")));
	}

	@When("^select the verification questions and submit$")
	public void select_the_verification_questions_and_submit() {
		interaction.contactVerificationWithQuestions();
		//interaction.contactVerificationWithQuestions();
		//interaction.contactVerificationWithQuestions();


	}
	
	@When("^select the verification questions and click on verified$")
	public void select_the_verification_questions_and_click_on_verified() throws Throwable {
		interaction.contactVerificationQuestions();
		//interaction.contactVerificationWithQuestions();
		//interaction.contactVerificationWithQuestions();
	}
	@Then("^select verification questions and click verified for Interaction$")
	public void select_verification_questions_and_click_verified_for_Interaction() throws Throwable {
	    interaction.contactVerificationQuestionsforInteractions();
	}

	@When("^Click on Contact not verified button$")
	public void click_on_Contact_not_verified_button() throws Throwable {
		interaction.clickContactNotVerified();
	}
	@Then("^select the single verification questions and submit$")
	public void select_the_single_verification_questions_and_submit() throws Throwable {
		interaction.contactVerificationWithOneQuestions();
	}
	@When("^select the verification questions for service cases and click on verified$")
	public void select_the_verification_questions_for_service_cases_and_click_on_verified() throws Throwable {
		interaction.contactVerificationQuesforServiceCases();
	}
	@When("^select the verification questions for contact$")
	public void select_the_verification_questions_for_contact() throws Throwable {
		interaction.contactVerificationforContact();
	}

	@Then("^select the verification questions and submit for biggs$")
	public void select_the_verification_questions_and_submit_for_biggs() {
		interaction.contactVerificationWithTwoQuestions();
	}
	

	@When("^select \"([^\"]*)\" account number and submit$")
	public void select_account_number_and_submit(String accountNumber) {
		interaction.accountSelection(accountNumber);

	}
	@When("^select the verification questions$")
	public void select_the_verification_questions() throws Throwable {
	    interaction.selectQuestionswithoutSubmit();
	}

	@Then("^Verify the questions are not selected$")
	public void verify_the_questions_are_not_selected() throws Throwable {
		
	}

	@Then("^Verify the Contact not verification page is displayed$")
	public void verify_the_Contact_not_verification_page_is_displayed() throws Throwable {
		pegaDriver.waitForDocStateReady(1);
		Assert.assertTrue("Contact Not verified heading is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Contact not verified']")));
		Assert.assertTrue("Comments heading is not present",
				pegaDriver.verifyElement(By.xpath("//label[text()='Comments']")));
		Assert.assertTrue("Search for customer flow action header is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Contact not verified']")));
		/*Assert.assertTrue("Tools Menu button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@title='Tools menu']")));*/
		Assert.assertTrue("Other Actions buttons is not present",
				pegaDriver.verifyElement(By.xpath("//button[@title='Other actions']")));

	}
	@Then("^click on Other actions and click on ByPass Verification$")
	public void click_on_Other_actions_and_click_on_ByPass_Verification() throws Throwable {
		 interaction.clickOtherActionsandByPassVerification();   
	}
	@Then("^enter the reason and click on submit button$")
	public void enter_the_reason_and_click_on_submit_button() throws Throwable {
		interaction.enterReasonAndClickSubmitButton();
	}
	
	/*@Then("^validate the status of the Case$")
	public void validate_the_status_of_the_Case() throws Throwable {
		interaction.validateStatusofCase();
	}*/
	
	@Then("^validate \"([^\"]*)\"status of the case$")
	public void validate_status_of_the_case(String caseidtext) throws Throwable {
		frameId = pegaDriver.getActiveFrameId(false); 
		newWizard = pegaDriver.findWizard(frameId); 
		//String caseidtext;
		System.out.println(CaseID);
		PegaWebElement searchButton = newWizard.findElement(By.xpath("//span/i/img[@tabindex=0]")); 
		searchButton.click(); pegaDriver.waitForDocStateReady(1); 
		PegaWebElement myworkTAB = newWizard.findElement(By.xpath("//h3[contains(text(),'Recent work')]")); 
		myworkTAB.click(); 
		pegaDriver.waitForDocStateReady(1); 
		frameId = pegaDriver.getActiveFrameId(false); 
		newWizard = pegaDriver.findWizard(frameId); 
		PegaWebElement caseidStatus = newWizard.findElement(By.xpath("//tr[contains(@id,'CPMMyRecentWork')]/td[1]/descendant::a[contains(text(),'"+CaseID+"')]/../../../../td[4]/descendant::span[contains(.,'Resolved')][1]")); 
		String status=caseidStatus.getText();
		System.out.println(status); 
		status=status.replaceAll(" ", ""); 
		Assert.assertEquals("resolved not verified is not displayed", caseidtext, status);
		//return status;
	}


	
	@Then("^select History and Attachments and verify ByPass Verification$")
	public void select_History_and_Attachments_and_verify_ByPass_Verification() throws Throwable {
	    interaction.verifyByPassVerificationinHistory();
	}
	@Then("^validate no questions available message in History$")
	public void validate_no_questions_available_message_in_History() throws Throwable {
		
		interaction.verifyNoQuestionsAvailable();
			}
	
	
	

	@When("^Enter the comments and click Submit$")
	public void enter_the_comments_and_click_Submit() throws Throwable {
	    interaction.exitInteractionwithcomment();
	}
	
	@Then("^Verify the Call back page is displayed$")
	public void verify_the_Call_back_page_is_displayed() throws Throwable {
		
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchToActiveFrame();
		/*Assert.assertTrue("In-progress is not present",
				pegaDriver.verifyElement(By.xpath("//img[contains(@title,'In-progress task Contact')]")));*/
		Assert.assertTrue("Dialog is not present",
				pegaDriver.verifyElement(By.xpath("//div[@id='DialogContent' and contains(text(),'The default callback time is set to 4 hours from now.Would you like to suggest a different time of your convenience?')]")));
		Assert.assertTrue("Call Back title is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Call back')]")));
		Assert.assertTrue("set Call Back time text is not present",
				pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Set Call Back Time')]")));
	}


	@When("^Select the call back time and click submit$")
	public void select_the_call_back_time_and_click_submit() throws Throwable {
	    interaction.submitWithoutSelectingQuestions();
	}
	
	@When("^Click on Add Task to launch Service Process$")
	public void click_on_Add_Task_to_launch_Service_Process() {
		pegaDriver.waitForDocStateReady(3);
		interaction.addTask();
	}
	@Then("^launch Add Task and validate General category$")
	public void launch_Add_Task_and_validate_General_category() throws Throwable {
		pegaDriver.waitForDocStateReady(1);
		Assert.assertTrue("Add Task heading is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Add Tasks']")));
		Assert.assertTrue("Add Task heading is not present",
				//pegaDriver.verifyElement(By.xpath("//a[@title='Close this item ']")));
				pegaDriver.verifyElement(By.xpath("//span/button[@title='Add Task' and @class='Strong pzhc pzbutton']")));
		Assert.assertTrue("Search input box is not present",
				pegaDriver.verifyElement(By.xpath("//input[@id='CPMTaskSearchInput']")));
		//Assert.assertTrue("Search icon is not present",pegaDriver.verifyElement(By.xpath("//img[@title='Search for Service Process ']")));
		//Assert.assertTrue("Search icon is not present",pegaDriver.verifyElement(By.xpath("//i[@tabindex='0' and @class='icons pi pi-search-2 pi-medium pi-grey pi-mini']")));
		
		Assert.assertTrue("General Servive process header is not present",
				pegaDriver.verifyElement(By.xpath("//div[@class='layout layout-none']//span[text()='General']")));
		Assert.assertTrue("Add Task button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@title='Add Task' and text()='Add tasks']")));
		Assert.assertTrue("Cancel button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@title='Cancel']")));

		// Verifying if all the service process are listed in Add Task Menu

		Assert.assertTrue("Complaint or compliment is not present",
				pegaDriver.verifyElement(By.xpath("//a[contains(text(),'Complaint or Compliment' )and @class='Add_task']")));

		Assert.assertTrue("Send correspondence is not present",
				pegaDriver.verifyElement(By.xpath("//a[contains(text(),'Send Correspondence') and @class='Add_task']")));
		Assert.assertTrue("General service request is not present",
				pegaDriver.verifyElement(By.xpath("//a[contains(text(),'General Service Request') and @class='Add_task']")));
		/*Assert.assertTrue("Make offer is not present",
				pegaDriver.verifyElement(By.xpath("//a[text()='Make offer' and @class='Add_task']")));
		Assert.assertTrue("Offer negotiator is not present",
				pegaDriver.verifyElement(By.xpath("//a[text()='Offer negotiator' and @class='Add_task']")));*/
		//Assert.assertTrue("Add New Organization is not present",pegaDriver.verifyElement(By.xpath("//a[contains(text(),'Add New Organization') and @class='Add_task']")));
		/*Assert.assertTrue("Log sales opportunity is not present",
				pegaDriver.verifyElement(By.xpath("//a[text()='Log sales opportunity' and @class='Add_task']")));*/
		Assert.assertTrue("Schedule activity is not present",
				pegaDriver.verifyElement(By.xpath("//a[contains(text(),'Schedule Activity') and @class='Add_task']")));
		Assert.assertTrue("Open new account is not present",
				pegaDriver.verifyElement(By.xpath("//a[contains(text(),'Open New Account') and @class='Add_task']")));
		Assert.assertTrue("Add New Organization is not present",
				pegaDriver.verifyElement(By.xpath("//a[contains(text(),'Add New Organization') and @class='Add_task']")));
	}

	@Then("^Verify all the service process items and other fields$")
	public void verify_all_the_service_process_items_and_other_fields() {
		pegaDriver.waitForDocStateReady(1);
		Assert.assertTrue("Add Task heading is not present",pegaDriver.verifyElement(By.xpath(interaction.ADD_TASKS_HEADER_XPATH)));
		Assert.assertTrue("Add Task heading is not present",pegaDriver.verifyElement(By.xpath(interaction.Btn_AddTasks_Xpath)));
		Assert.assertTrue("Search input box is not present",pegaDriver.verifyElement(By.xpath(interaction.SEARCH_INPUT_BOX_XPATH)));

		Assert.assertTrue("Account Service process header is not present",pegaDriver.verifyElement(By.xpath(interaction.ACCOUNT_HEADER_XPATH)));
		Assert.assertTrue("Contact Service process header is not present",pegaDriver.verifyElement(By.xpath(interaction.CONTACT_HEADER_XPATH)));
		Assert.assertTrue("General Servive process header is not present",pegaDriver.verifyElement(By.xpath(interaction.GENERAL_HEADER_XPATH)));
		Assert.assertTrue("Add Task button is not present",pegaDriver.verifyElement(By.xpath(interaction.ADD_TASKS_BUTTON_XPATH)));
		Assert.assertTrue("Cancel button is not present",pegaDriver.verifyElement(By.xpath(interaction.CANCEL_BUTTON_XPATH)));

		// Verifying if all the service process are listed in Add Task Menu

		Assert.assertTrue("Address Change is not present",pegaDriver.verifyElement(By.xpath(interaction.ADDRESS_CHANGE_XPATH)));
		Assert.assertTrue("Close Account is not present",pegaDriver.verifyElement(By.xpath(interaction.CLOSE_ACCOUNT_XPATH)));
		Assert.assertTrue("Modify Contact Links is not present",pegaDriver.verifyElement(By.xpath(interaction.MODIFY_CONTACT_LINKS_XPATH)));
		Assert.assertTrue("Dispute Transaction is not present",pegaDriver.verifyElement(By.xpath(interaction.DISPUTE_TRANSACTION_XPATH)));
		Assert.assertTrue("Lost or stolen card is not present",pegaDriver.verifyElement(By.xpath(interaction.LOST_OR_STOLEN_XPATH)));
		Assert.assertTrue("Statement copy is not present",pegaDriver.verifyElement(By.xpath(interaction.STATEMENT_COPY_XPATH)));
		Assert.assertTrue("Modify account links is not present",pegaDriver.verifyElement(By.xpath(interaction.MODIFY_ACCOUNT_LINKS_XPATH)));
		Assert.assertTrue("Modify Organizations links is not present",pegaDriver.verifyElement(By.xpath(interaction.MODIFY_CONTACT_TO_ORG_LINKS_XPATH)));
		Assert.assertTrue("Update contact profile is not present",pegaDriver.verifyElement(By.xpath(interaction.UPDATE_CONTACT_PROFILE_XPATH)));
		Assert.assertTrue("Modify account links is not present",pegaDriver.verifyElement(By.xpath(interaction.MODIFY_ACCOUNT_LINKS_XPATH)));
		Assert.assertTrue("Modify organization links is not present",pegaDriver.verifyElement(By.xpath(interaction.MODIFY_ORGANIZATION_LINKS_XPATH)));
		//Assert.assertTrue("Complaint or compliment is not present",	pegaDriver.verifyElement(By.xpath(interaction.COMPLAINT_OR_COMPLIMENT_XPATH)));

		Assert.assertTrue("Send correspondence is not present",	pegaDriver.verifyElement(By.xpath(interaction.SEND_CORRESPONDENCE_XPATH)));
		Assert.assertTrue("General service request is not present",pegaDriver.verifyElement(By.xpath(interaction.GENERAL_SERVICE_REQUEST_XPATH)));
		/*Assert.assertTrue("Make offer is not present",pegaDriver.verifyElement(By.xpath(interaction.MAKE_OFFER_XPATH)));
		Assert.assertTrue("Offer negotiator is not present",pegaDriver.verifyElement(By.xpath(interaction.OFFER_NEGOTIATOR_XPATH)));*/
		//Assert.assertTrue("Add New Organization is not present",pegaDriver.verifyElement(By.xpath(interaction.ADD_NEW_ORGANIZATION_XPATH)));
		/*Assert.assertTrue("Log sales opportunity is not present",pegaDriver.verifyElement(By.xpath(interaction.LOG_SALES_OPPORTUNITY_XPATH)));*/
		Assert.assertTrue("Schedule activity is not present",pegaDriver.verifyElement(By.xpath(interaction.SCHEDULE_ACTIVITY_XPATH)));
		Assert.assertTrue("Open new account is not present",pegaDriver.verifyElement(By.xpath(interaction.OPEN_NEW_ACCOUNT_XPATH)));

	}

	@When("^Launch \"([^\"]*)\" service process$")
	public void launch_service_process(String serviceProcess) {
		interaction.launchServiceProcess(serviceProcess);
	}
	@Then("^verify search screen displayed$")
	public void verify_search_screen_displayed() throws Throwable {
	    interaction.validateSearchScreen();
	}

	@Then("^click on Contact Not Verified button for service cases$")
	public void click_on_Contact_Not_Verified_button_for_service_cases() throws Throwable {
	    interaction.clickonContactNotVerified();
	}
	@Then("^click on Contact Not Verified button for Interactions$")
	public void click_on_Contact_Not_Verified_button_for_Interactions() throws Throwable {
		interaction.clickonContactNotVerifiedForInteractions();
	}


	@When("^change the address and other fields and submit$")
	public void change_the_address_and_other_fields_and_submit() {
		interaction.changeAddress();
	}

	@When("^check additional account for address change and submit$")
	public void check_additional_account_for_address_change_and_submit() {
		interaction.changeAdditionalAddress();
	}

	@Then("^check the dialog in in confirm screen and in progress task in left nav$")
	public void check_the_dialog_in_in_confirm_screen_and_in_progress_task_in_left_nav() {
		//String dialog = pegaDriver.findElement(By.xpath("//div[@id='DialogContent']")).getText();
		String dialog = pegaDriver.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'changes')]")).getText();
		System.out.println(dialog);
		Assert.assertEquals("Address Change flow dialog is not present or incorrect",
				"I have made the changes you requested.", dialog);
		Assert.assertTrue("In Progress Label is not present",pegaDriver.verifyElement(By.xpath("//a[contains(text(),'Address Change')]")));
		//a[contains(text(),'Account Address Change')]  Changed above xpath.
		String fullAddress = null;
		List<WebElement> address = pegaDriver.findElements(
				By.xpath("//div[@node_name='CANewAddress']//div[@class='field-item dataValueRead']/span"));
		for (WebElement e : address) {
			fullAddress = fullAddress + e.getText();
		}
		System.out.println(fullAddress);

	}
	@When("^confirm the changes made$")
	public void confirm_the_changes_made() {
		interaction.confirmAddressChange();

	}
	
	@When("^Submit the details$")
	public void submit_the_details() throws Throwable {
		if (pegaDriver.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='OK']")).isVisible()) {
			//pegaDriver.switchToActiveFrame();
			PegaWebElement confirmButton = pegaDriver.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='OK']"));
			confirmButton.click();
			pegaDriver.waitForDocStateReady(2);	
		}
		//interaction.confirmchange();
	}
	
	@Then("^check for completed or cancelled task \"([^\"]*)\"$")
	public void check_for_completed_or_cancelled_task(String serviceProcess) {
		Assert.assertTrue("Completed process Label is not present",
				pegaDriver.verifyElement(By.xpath(interaction.verifyCompletedTask(serviceProcess))));
				
	}
	
	@When("^launch the cancel flow$")
	public void launch_the_cancel_flow() {
		interaction.clickOnOtherActionsButton();
		interaction.cancelFlow();
	}
	
	@Then("^verify the dialog in cancel flow of \"([^\"]*)\" and in progress label$")
	public void verify_the_dialog_in_cancel_flow_of_and_in_progress_label(String serviceProcess) throws Throwable {
		String SERVICE_PROCESS_XPATH = "//a[text()='#sericecase#']";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#sericecase#", serviceProcess);
		pegaDriver.waitForDocStateReady(1);
		Assert.assertTrue("In Progress Label is not present",
				pegaDriver.verifyElement(By.xpath(finalXPath)));
		Assert.assertTrue("In Progress Label is not present",
				pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Cancel this work')]")));
	   
	}
	
	@When("^cancel the flow$")
	public void cancel_the_flow() {
		interaction.submitCancelFlow();
	    
	}
	@When("^Click on Next Best Action$")
	public void click_on_Next_Best_Action() throws Throwable {
	    //String Next_Best_Action="//i[@class='icon icon-openclose']";
	    PegaWebElement NextBestActionButton = pegaDriver.findElement(By.xpath("//i[@class='icon icon-openclose']"));
	    NextBestActionButton.click(false);
	   
	}
	@When("^launch warpup to complete the interaction$")
	public void launch_warpup_to_complete_the_interaction() {
		
	   interaction.launchWrapup();
	
	   //interaction.getCaseID();
	   //System.out.println(caseId);
	   //ObjectsBean.getObjectsMap().put("caseids", caseId);
	}
	@When("^user wraps up the interaction$")
	public void user_wraps_up_the_interaction() throws Throwable {
		 interaction.WrapUpInteraction();
	}
	
	@Then("^Get the case ID$")
	public void get_the_case_ID() {
		pegaDriver.waitForDocStateReady(3);
		CaseID=interaction.getCaseID();
		
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);
		/*PegaWebElement toolsButton = pegaDriver.findElement(By.xpath("//button[@title='Tools Menu']"));
		toolsButton.click(false);
		String Parent_Window = pegaDriver.getWindowHandle();
		PegaWebElement viewHistory = pegaDriver.findElement(By.xpath("//span[text()='History and Attachments']"));
		viewHistory.click();
		//testEnv.getBrowser().switchToWindow(2);
		 Set<String> handles =  pegaDriver.getWindowHandles();
		 for(String windowHandle  : handles)
	       {
	       if(!windowHandle.equals(Parent_Window))
	          {
	          pegaDriver.switchTo().window(windowHandle);
	         
	  		String caseId = pegaDriver.findElement(By
	  				.xpath("//span[contains(text(),'I-') or contains(text(),'S-')]")).getText();
	  		Object c = caseId;
	  		 System.out.println(c);
			 ObjectsBean.getObjectsMap().put("caseids", c);
			 ObjectsBean.getObjectNames().put("caseids", caseId);
	         pegaDriver.close();
	         pegaDriver.switchTo().window(Parent_Window);
	          }
	       }*/
		 	    
	}
	
	@Then("^Get the case ID from History and Attachments link$")
	public void get_the_case_ID_from_History_and_Attachments_link() throws Throwable {
		pegaDriver.waitForDocStateReady(3);
		CaseID=interaction.getCaseDetails();
		
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);
		
	}
	
	@When("^Get the caseID from tools menu$")
	public void get_the_caseID_from_tools_menu() throws Throwable {
		pegaDriver.waitForDocStateReady(3);
		CaseID=interaction.getCaseIDunderToolsmenu();
		
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);
	}

	@Then("^verify the wrapup dialog$")
	public void verify_the_wrapup_dialog() {
	   
	    
	}

	@When("^complete the wrap up$")
	public void complete_the_wrap_up() {
	   
	    interaction.completeWrapUpWithoutReason();
	    System.out.println(caseId);
	    ObjectsBean.getObjectsMap().put("caseids", caseId);
	}
	
	@When("^complete chat wrap up$")
	public void complete_chat_wrap_up() {
	   
	    interaction.completeChatWrapUpWithoutReason();
	    System.out.println(caseId);
	    ObjectsBean.getObjectsMap().put("caseids", caseId);
	}

	
	@When("^complete the wrap up and verify reason \"([^\"]*)\"$")
	public void complete_the_wrap_up_and_verify_reason(String reason)  {

		interaction.completeWrapUp(reason);
	    System.out.println(caseId);
	    ObjectsBean.getObjectsMap().put("caseids", caseId);
	}
	
	
	@When("^search for I- and S- items$")
	public void search_for_I_and_S_items() {
		
		
	   
		/*for(int i=0; i<caseId.size(); i++){
			caseStatus[i] = phoneInteraction.checkCaseStatus(caseId.get(i));
		}
	    System.out.println(caseStatus);*/
	}

	@Then("^verify the status$")
	public void verify_the_status() {
	    
	    
	}
	
	@Then("^check for the accounts displayed$")
	public void check_for_the_accounts_displayed() {
		//pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath(PhoneCall.LAST_INTERACTION_XPATH));
		Assert.assertTrue("Last interaction heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.LAST_INTERACTION_XPATH)));
		Assert.assertTrue("Reason heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.REASON_XPATH)));
		Assert.assertTrue("Status heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.STATUS_XPATH)));
		Assert.assertTrue("NPS heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.NPS_XPATH)));
		
		Assert.assertTrue("Contact information heading is not present",	pegaDriver.verifyElement(By.xpath(PhoneCall.CONTACT_INFO_XPATH)));
		Assert.assertTrue("Callback heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CALL1_BACK_XPATH)));
		Assert.assertTrue("Phone heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.PHONE_XPATH)));
		Assert.assertTrue("Email heading is not present",pegaDriver.verifyElement(By.xpath("//span[text()='Email']")));
		Assert.assertTrue("Address heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.ADDRESS_XPATH)));
		
		Assert.assertTrue("CUSTOMER SUMMARY heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CUSTOMER_SUMMARY_XPATH)));
		Assert.assertTrue("Active accounts heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.ACTIVE_ACCOUNTS_XPATH)));
		Assert.assertTrue("Open cases heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.OPEN_CASES_XPATH)));
		Assert.assertTrue("Communication preference heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.COMMUNICATION_PREF_XPATH)));
		
		
		Assert.assertTrue("Relationship heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.RELATIONSHIP_XPATH)));
		Assert.assertTrue("Lifetime value heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.LIFETIME_XPATH)));
		Assert.assertTrue("Churn risk heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CHURN_RISK_XPATH)));
		Assert.assertTrue("NPS trend heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.NPS_TREND_XPATH)));
		Assert.assertTrue("Customer since heading is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CUSTOMER_SINCE_XPATH)));
				
		
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(2);
		/*Assert.assertTrue("Add task button is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.ADDTASK_XPATH)));
		Assert.assertTrue("Wrap Up button is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.WRAP_UP_XPATH)));
		pegaDriver.switchToActiveFrame();
		String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
		System.out.println(dialog);
		dialog.trim();
		//Assert.assertEquals("Contact verification dialog is not present or incorrect","Is there an account you are calling about today?", dialog);
		Assert.assertTrue("Select an Account In progress field is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Select an account']")));
		Assert.assertTrue("Select an account flow action dialog is not present",
				pegaDriver.verifyElement(By.xpath("//div[contains(text(),'Select an account for')]")));
		Assert.assertTrue("Select an account flow action dialog is not present",
				pegaDriver.verifyElement(By.xpath("//div[contains(text(),'or press Submit to continue')]")));
		
		interaction.clickOnToolsMenuButton();
		//Assert.assertTrue("Where Am I menu option is not present",pegaDriver.verifyElement(By.xpath("//span[text()='Where am I?']")));
		Assert.assertTrue("History and Attachment option is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='History and Attachments']")));
		Assert.assertTrue("Pulse option is not present", pegaDriver.verifyElement(By.xpath("//span[text()='Pulse']")));

		interaction.clickOnOtherActionsButton();

		Assert.assertTrue("Refresh menu option is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Refresh']")));
		Assert.assertTrue("Exit Interaction option is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Exit interaction']")));*/
	}
	
	@Then("^verifiy left nav, header, composites, dialogs and other sections$")
	public void verifiy_left_nav_header_composites_dialogs_and_other_sections() {
		pegaDriver.waitForDocStateReady(2);
		//pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath(PhoneCall.PHONE_XPATH));
		
		Assert.assertTrue("phone field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.PHONE_XPATH)));
		Assert.assertTrue("Email Field is not present",pegaDriver.verifyElement(By.xpath("//span[text()='Email']")));
		//Assert.assertTrue("Active Accounts field is not present",pegaDriver.verifyElement(By.xpath("//span[text()='Active accounts']")));
		Assert.assertTrue("Address field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.ADDRESS_XPATH)));
		//Assert.assertTrue("Open Cases field is not present",pegaDriver.verifyElement(By.xpath("//span[text()='Open cases']")));
		//Assert.assertTrue("Online Field is not present",pegaDriver.verifyElement(By.xpath("//span[text()='Online']")));
		//Assert.assertTrue("Communication preference field is not present",pegaDriver.verifyElement(By.xpath("//span[text()='Communication preference']")));
		Assert.assertTrue("Chrun risk is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CHURN_RISK_XPATH)));
		Assert.assertTrue("Lifetime Value is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.LIFETIME_XPATH)));
		Assert.assertTrue("Customer since field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CUSTOMER_SINCE_XPATH)));
		//Assert.assertTrue("Call back field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CALL1_BACK_XPATH)));
		Assert.assertTrue("Call back field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.NPS_TREND_XPATH)));
		Assert.assertTrue("Last interaction field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.LAST_INTERACTION_XPATH)));
		Assert.assertTrue("Reason field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.REASON_XPATH)));
		Assert.assertTrue("NPS field is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.NPS_XPATH)));
		
		pegaDriver.switchToActiveFrame();

		Assert.assertTrue("Add Task button is not present",
				pegaDriver.verifyElement(By.xpath("//button[contains(@title,'Add')]")));
		Assert.assertTrue("Wrap up button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@class='Wrap_up_button pzhc pzbutton' and @title='Wrap Up']")));
		/*Assert.assertTrue("NBA section is not present",
				pegaDriver.verifyElement(By.xpath("//h2[text()='Next best action']")));*/
		/*Assert.assertTrue("Account tab is not present",
				pegaDriver.verifyElement(By.xpath("//div[@class='header']/h3[text()='Account']")));*/
		Assert.assertTrue("Summary tab is not present", pegaDriver.verifyElement(By.xpath("//h3[text()='Overview']")));
		Assert.assertTrue("Open service case section is not present",
				pegaDriver.verifyElement(By.xpath("//h2[text()='Recent cases']")));
		Assert.assertTrue("Recent Interactions section is not present",
				pegaDriver.verifyElement(By.xpath("//h2[text()='Recent interactions']")));
		/*Assert.assertTrue("Transactions section is not present",
				pegaDriver.verifyElement(By.xpath("//h2[text()='Transactions']")));
		Assert.assertTrue("Statements section is not present",
				pegaDriver.verifyElement(By.xpath("//h2[text()='Statements']")));
		Assert.assertTrue("Authorized contacts section is not present",
				pegaDriver.verifyElement(By.xpath("//h2[text()='Authorized contacts']")));*/
				pegaDriver.verifyElement(By.xpath("//h2[text()='Authorized Contacts']"));


	}
	
	@Then("^check for \"([^\"]*)\" account displayed$")
	public void check_for_account_displayed(String accountNumber) throws Throwable {
		/*String ACCOUNT_NUMBER_XPATH = "//*[contains(@oaargs, '#accountNumber#')]";
		String finalXPath = new String(ACCOUNT_NUMBER_XPATH).replace("#accountNumber#", accountNumber);*/
		Assert.assertTrue(accountNumber+" account is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'"+accountNumber+"')]/ancestor::tr[1]")));
	   
	}

	
	
	@Then("^verify \"([^\"]*)\" flow is launched$")
	public void verify_flow_is_launched(String serviceProcess) {
		pegaDriver.waitForDocStateReady(2);
		String INPROGESS_LABEL_XPATH = "//a[contains(text(),'#serviceProcess#')]";
		String finalXPathInProgress = new String(INPROGESS_LABEL_XPATH).replace("#serviceProcess#", serviceProcess);
		Assert.assertTrue(serviceProcess +"In Progress Label is not present",
				pegaDriver.verifyElement(By.xpath(finalXPathInProgress)));
		
		/*interaction.clickOnToolsMenuButton();*/


		interaction.clickOnOtherActionsButton();
		Assert.assertTrue("Where Am I menu option is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.WHERE_AM_I_XPATH)));
		Assert.assertTrue("History and Attachment option is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH)));
		Assert.assertTrue("Pulse option is not present", pegaDriver.verifyElement(By.xpath(PhoneCall.PULSE_XPATH)));

		Assert.assertTrue("Refresh menu option is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.REFRESH_XPATH)));
		Assert.assertTrue("Cancel this work menu option is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CANCEL_WORK_XPATH)));
		Actions action = new Actions(pegaDriver.getDriver());
		action.sendKeys(Keys.ESCAPE).build().perform();
		
	}
	
	@Then("^verify the confirm screen for \"([^\"]*)\"$")
	public void verify_the_confirm_screen_for(String serviceProcess) {
		String INPROGESS_LABEL_XPATH = "//a[contains(text(),'#serviceProcess#')]";
		String finalXPathInProgress = new String(INPROGESS_LABEL_XPATH).replace("#serviceProcess#", serviceProcess);
		//Assert.assertTrue(serviceProcess +"In Progress Label is not present",pegaDriver.verifyElement(By.xpath(finalXPathInProgress)));
				Assert.assertTrue("Confirm screen message is not present",pegaDriver.verifyElement(By.xpath("//div[contains(text(),'has been created successfully.  Select confirm to')]")));
				pegaDriver.verifyElement(By.xpath("//div[contains(text(),'"+serviceProcess+"') and contains(text(),'has been created successfully.  Select confirm to continue.')]"));
		/*		interaction.clickOnToolsMenuButton();
		Assert.assertTrue("History and Attachment option is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH)));
		Assert.assertTrue("Pulse option is not present", pegaDriver.verifyElement(By.xpath(PhoneCall.PULSE_XPATH)));*/
		}
	
	@When("^Confirm the flow$")
	public void confirm_the_flow() {
	    interaction.confirmFlow();
	}
	
	@Then("^verify dialog, FA header and other options for Schedule Activity$")
	public void verify_dialog_FA_header_and_other_options_for_Schedule_Activity() {
		String dialog = pegaDriver.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'schedule')]")).getText();
		System.out.println(dialog);
		Assert.assertEquals("Schedule Activity initial dialog is not present or incorrect",
				"In order to schedule the activity, I'll need a few details from you. ", dialog);
		Assert.assertTrue("Schedule Activity FA header is not present",
				pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Schedule Activity')]")));
		Assert.assertTrue("In Schedule Activity Conference call is not present",
				pegaDriver.verifyElement(By.xpath("//div[text()='Conference call']")));
		Assert.assertTrue("In Schedule Activity Appointment is not present",
				pegaDriver.verifyElement(By.xpath("//div[text()='Appointment']")));
		Assert.assertTrue("In Schedule Activity Task is not present",
				pegaDriver.verifyElement(By.xpath("//div[text()='Task']")));
	}
	
	@When("^launch intent task \"([^\"]*)\" from suggestions$")
	public void launch_intent_task_from_suggestions(String suggestedTask) {
		interaction.launchSuggestedTask(suggestedTask);
	    
	}
	
	@When("^launch intent offer \"([^\"]*)\" from suggestions$")
	public void launch_intent_offer_from_suggestions(String suggestedOffer) {
	  interaction.launchOffer(suggestedOffer);
	}
	
	@When("^learn more and accept offer$")
	public void learn_more_and_accept_offer() {
		interaction.learnMoreAndAcceptOffer();
	    
	}
	
	@When("^defer the offer$")
	public void defer_the_offer() {
	    interaction.deferOffer();
	}

	@When("^decline the offer$")
	public void decline_the_offer() {
	   interaction.declineOffer();
	}

	@When("^switch to \"([^\"]*)\" flow$")
	public void switch_to_flow(String serviceProcess) {
	    interaction.switchCase(serviceProcess);
	}


	@When("^switch to Interaction of \"([^\"]*)\"$")
	public void switch_to_Interaction_of(String interactionItem) {
		interaction.switchInteraction(interactionItem);
	}
	
	
	@When("^Select category \"([^\"]*)\" product \"([^\"]*)\" and owner\"([^\"]*)\" and submit$")
	public void select_category_product_and_owner_and_submit(String category, String product, String owner) throws Throwable {
		
		interaction.openNewAccountFlow(category, product, owner);
		
	    
	}
	
	@When("^Enter the mail id \"([^\"]*)\" and subject \"([^\"]*)\" and click submit$")
	public void enter_the_mail_id_and_subject_and_click_submit(String mailID, String subject) {
		interaction.sendCorrespondanceFlow(mailID, subject);
		
	    
	}

	@When("^Click on \"([^\"]*)\" service process$")
	public void click_on_service_process(String serviceProcess) {
		interaction.selectSingleserviceprocess(serviceProcess);
	    
	}

	@When("^Click on Add task button to launch the services$")
	public void click_on_Add_task_button_to_launch_the_services(){
		interaction.selectAddTask();
	    
	}
	
	@When("^Search \"([^\"]*)\" from the search menu$")
	public void search_from_the_search_menu(String serviceName) {
		
		interaction.searchForServiceProcess(serviceName);
			    
	}

	@Then("^Select \"([^\"]*)\" from the search result$")
	public void select_from_the_search_result(String searchResult) {
		
		interaction.clickOnSearchResult(searchResult);
	   
	}
	
	@When("^Select the account \"([^\"]*)\" under account summary$")
	public void select_the_account_under_account_summary(String AcNo) {
		
		interaction.selectaccountfromaccountSummary(AcNo);
			   
	}

	@Then("^verify the left nav and headers for \"([^\"]*)\" account$")
	public void verify_the_left_nav_and_headers_for_account(String AcNo)   {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(2);
		
		Assert.assertTrue("Account header is not present",
				pegaDriver.verifyElement(By.xpath("//h3[contains(text(),'Account')]")));
		Assert.assertTrue("Overview header is not present",
				pegaDriver.verifyElement(By.xpath("//h3[contains(text(),'Overview')]")));
		Assert.assertTrue("Organization header is not present",
				pegaDriver.verifyElement(By.xpath("//h3[contains(text(),'Organization')]")));
		//Assert.assertTrue("Opportunities header is not present",
		//		pegaDriver.verifyElement(By.xpath("//h3[contains(text(),'Opportunities')]")));
		Assert.assertTrue("Notes header is not present",
				pegaDriver.verifyElement(By.xpath("//h3[contains(text(),'Notes')]")));
		Assert.assertTrue("News header is not present",
				pegaDriver.verifyElement(By.xpath("//h3[contains(text(),'News')]")));
	}

	@When("^Click on Account number$")
	public void click_on_Account_number()   {
		
		interaction.clickAccountNumber();
		
	    
	}

	@Then("^Veriy the other accounts displayed$")
	public void veriy_the_other_accounts_displayed()  {
		
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(2);
		
		Assert.assertTrue("Account number header is not present",
				pegaDriver.verifyElement(By.xpath("//div[contains(text(),'Account number')]")));
		Assert.assertTrue("Account  type header is not present",
				pegaDriver.verifyElement(By.xpath("//div[contains(text(),'Account  type')]")));
		Assert.assertTrue("Role header is not present",
				pegaDriver.verifyElement(By.xpath("//div[contains(text(),'Role')]")));
		Assert.assertTrue("Status header is not present",
				pegaDriver.verifyElement(By.xpath("//div[contains(text(),'Status')]")));
	    
	}


	
	@Then("^Verify \"([^\"]*)\" is displayed in interaction goal$")
	public void verify_is_displayed_in_interaction_goal(String interactionGoal) throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();

		Assert.assertTrue("Interaction Goal Value is not displayed",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'"+interactionGoal+"')]")));
	    
	}
	
	@When("^Enable the Customer inquiry option$")
	public void enable_the_Customer_inquiry_option(){
		interaction.customerInquiry();
	
	}
	
	@When("^Select \"([^\"]*)\" and \"([^\"]*)\" check boxes$")
	public void select_and_check_boxes(String checkbox1, String checkbox2) {
		PegaWebElement firstChkBx = pegaDriver.findElement(By.xpath("//span[contains(text(),'"+checkbox1+"')]/ancestor::div[1]/preceding-sibling::div/descendant::input[@class='cpm-history-checkbox']"));
		firstChkBx.click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchToActiveFrame();
		PegaWebElement secondChkBx = pegaDriver.findElement(By.xpath("//span[contains(text(),'"+checkbox2+"')]/ancestor::div[1]/preceding-sibling::div/descendant::input[@class='cpm-history-checkbox']"));
		secondChkBx.click();
			   
	}
	/*@When("^Validate Favorites details \"([^\"]*)\" in My Favorites$")
	public void validate_Favorites_details_in_My_Favorites(String contact) throws Throwable {
		interaction.validateFavorites(contact);
	}
*/
	@When("^Click on \"([^\"]*)\" icon in the interaction page$")
	public void click_on_icon_in_the_interaction_page(String LinkName) throws Throwable {
	    interaction.ShowdataLink(LinkName);
	}
	
	/*@When("^Filter with case ID$")
	public void filter_with_case_ID() throws Throwable {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		
		System.out.println(CaseID);
		System.out.println(String.valueOf(CaseID));

		PegaWebElement searchBox = pegaDriver.findElement(By.id("CPMAssignmentsSearchText"));
		searchBox.clear();
		searchBox.sendKeys(String.valueOf(CaseID));
		pegaDriver.waitForDocStateReady(2);
		searchBox.sendKeys(Keys.ENTER);


	}*/
	
	@Then("^validate Reopen case$")
	public void validateReopencase() 
	{
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		String RefreshButton = "//i[contains(@title,'Refresh My Work Gadget')]";
		PegaWebElement Refresh = pegaDriver.findElement(By.xpath(RefreshButton));
		Refresh.click(false);
		String caseState = "//span[contains(text(),Open)]";
		pegaDriver.verifyElement(By.xpath("caseState"));
	}
	@When("^Click on Closed Case and Reopen$")
	public void click_on_Closed_Case_and_Reopen() throws Throwable {
		interaction.reopenCase();
	   
	}
	
	@When("^Update the \"([^\"]*)\" ID \"([^\"]*)\" and submit$")
	public void update_the_ID_and_submit(String source, String id) {
		
		interaction.updateID(source, id);
		
	}
	
	@When("^CSR adds a contact note$")
	public void csr_adds_a_contact_note() {
	 
		interaction.createContactNote();
	}
	
	

	
}
