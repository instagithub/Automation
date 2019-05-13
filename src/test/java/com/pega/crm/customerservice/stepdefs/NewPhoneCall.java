package com.pega.crm.customerservice.stepdefs;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.google.inject.Inject;
import com.pega.CRMObjectsBean;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.CSPortal;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.PhoneCall;
import com.pega.crm.customerservice.interactions.ResearchInteraction;
import com.pega.crm.customerservice.utils.CommonMethods;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.framework.elmt.FrameImpl;
import com.pega.ri.Wizard;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;


@ScenarioScoped

public class NewPhoneCall {

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
	public String OK_BUTTON_XPATH = "//div[@class='pzbtn-mid' and text()='OK']";
	public String caSysadminLogOff_XPATH = "//span[text()='Log off']";
	public String AddressLine1 = "//input[contains(@name,'AddressLine1')]";
	public String AddressLine2 = "//input[contains(@name,'AddressLine2')]";
	public String dropdownCountry = "//select[contains(@name,'CountryCode')]";
	public String City = "//input[contains(@name,'City')]";
	public String ZipCode = "//input[contains(@name,'ZipCode')]";
	
	@Inject
	public NewPhoneCall(NewTopNav topNavFixture, CRMTestEnvironment testEnv) {
		phoneInteraction = topNavFixture.getPhoneCall();
		//demoInteraction = topNavFixture.getDemoInteraction();
		interaction = topNavFixture.getInteractions();
		commonMethods = testEnv.getCommonMethods();
		pegaDriver = testEnv.getPegaDriver();
		researchInteraction = topNavFixture.getResearchInteraction();
	}


	@When("^select result from the result and proceed$")
	public void select_from_the_result_and_proceed() {
		interaction.selectCustomer();
	}
	
	
	@When("^select the verification questions and submit$")
	public void select_the_verification_questions_and_submit() {
		interaction.contactVerificationWithQuestions();
	}
	
	@When("^select the verification questions and click on verified$")
	public void select_the_verification_questions_and_click_on_verified() throws Throwable {
		interaction.contactVerificationQuestions();
	}
	


	@When("^select the verification questions for service cases and click on verified$")
	public void select_the_verification_questions_for_service_cases_and_click_on_verified() throws Throwable {
		interaction.contactVerificationQuesforServiceCases();
	}
	

	@Then("^select the verification questions and submit for biggs$")
	public void select_the_verification_questions_and_submit_for_biggs() {
		interaction.contactVerificationWithTwoQuestions();
	}
	

	@When("^select \"([^\"]*)\" account number and submit$")
	public void select_account_number_and_submit(String accountNumber) {
		interaction.accountSelection(accountNumber);

	}


	
	@When("^Click on Add Task to launch Service Process$")
	public void click_on_Add_Task_to_launch_Service_Process() {
		interaction.addTask();
	}
	
	


	@Then("^Verify all the service process items and other fields$")
	public void verify_all_the_service_process_items_and_other_fields() {
		Assert.assertTrue("Add Task heading is not present",interaction.verifyElement(By.xpath(interaction.ADD_TASKS_HEADER_XPATH)));
		Assert.assertTrue("Add Task heading is not present",interaction.verifyElement(By.xpath(interaction.Btn_AddTasks_Xpath)));
		Assert.assertTrue("Search input box is not present",interaction.verifyElement(By.xpath(interaction.SEARCH_INPUT_BOX_XPATH)));

		Assert.assertTrue("Account Service process header is not present",interaction.verifyElement(By.xpath(interaction.ACCOUNT_HEADER_XPATH)));
		Assert.assertTrue("Contact Service process header is not present",interaction.verifyElement(By.xpath(interaction.CONTACT_HEADER_XPATH)));
		Assert.assertTrue("General Servive process header is not present",interaction.verifyElement(By.xpath(interaction.GENERAL_HEADER_XPATH)));
		Assert.assertTrue("Add Task button is not present",interaction.verifyElement(By.xpath(interaction.ADD_TASKS_BUTTON_XPATH)));
		Assert.assertTrue("Cancel button is not present",interaction.verifyElement(By.xpath(interaction.CANCEL_BUTTON_XPATH)));

	

		Assert.assertTrue("Address Change is not present",interaction.verifyElement(By.xpath(interaction.ADDRESS_CHANGE_XPATH)));
		Assert.assertTrue("Close Account is not present",interaction.verifyElement(By.xpath(interaction.CLOSE_ACCOUNT_XPATH)));
		Assert.assertTrue("Modify Contact Links is not present",interaction.verifyElement(By.xpath(interaction.MODIFY_CONTACT_LINKS_XPATH)));
		Assert.assertTrue("Dispute Transaction is not present",interaction.verifyElement(By.xpath(interaction.DISPUTE_TRANSACTION_XPATH)));
		Assert.assertTrue("Lost or stolen card is not present",interaction.verifyElement(By.xpath(interaction.LOST_OR_STOLEN_XPATH)));
		Assert.assertTrue("Statement copy is not present",interaction.verifyElement(By.xpath(interaction.STATEMENT_COPY_XPATH)));
		Assert.assertTrue("Modify account links is not present",interaction.verifyElement(By.xpath(interaction.MODIFY_ACCOUNT_LINKS_XPATH)));
		Assert.assertTrue("Modify Organizations links is not present",interaction.verifyElement(By.xpath(interaction.MODIFY_CONTACT_TO_ORG_LINKS_XPATH)));
		Assert.assertTrue("Update contact profile is not present",interaction.verifyElement(By.xpath(interaction.UPDATE_CONTACT_PROFILE_XPATH)));
		Assert.assertTrue("Modify account links is not present",interaction.verifyElement(By.xpath(interaction.MODIFY_ACCOUNT_LINKS_XPATH)));
		Assert.assertTrue("Modify organization links is not present",interaction.verifyElement(By.xpath(interaction.MODIFY_ORGANIZATION_LINKS_XPATH)));
	

		Assert.assertTrue("Send correspondence is not present",	interaction.verifyElement(By.xpath(interaction.SEND_CORRESPONDENCE_XPATH)));
		Assert.assertTrue("General service request is not present",interaction.verifyElement(By.xpath(interaction.GENERAL_SERVICE_REQUEST_XPATH)));
		
		Assert.assertTrue("Schedule activity is not present",interaction.verifyElement(By.xpath(interaction.SCHEDULE_ACTIVITY_XPATH)));
		Assert.assertTrue("Open new account is not present",interaction.verifyElement(By.xpath(interaction.OPEN_NEW_ACCOUNT_XPATH)));

	}

	@When("^Launch \"([^\"]*)\" service process$")
	public void launch_service_process(String serviceProcess) {
		interaction.launchServiceProcess(serviceProcess);
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
		
		String dialog = interaction.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'changes')]")).getText();
		Assert.assertEquals("Address Change flow dialog is not present or incorrect",
				"I have made the changes you requested.", dialog);
		Assert.assertTrue("In Progress Label is not present",interaction.verifyElement(By.xpath("//a[contains(text(),'Address Change')]")));
	
		String fullAddress = null;
		List<WebElement> address = interaction.findElements(
				By.xpath("//div[@node_name='CANewAddress']//div[@class='field-item dataValueRead']/span"));
		for (WebElement e : address) {
			fullAddress = fullAddress + e.getText();
		}
		

	}
	
	@When("^confirm the changes made$")
	public void confirm_the_changes_made() {
		interaction.confirmAddressChange();

	}
	
	
	@Then("^check for completed or cancelled task \"([^\"]*)\"$")
	public void check_for_completed_or_cancelled_task(String serviceProcess) {
		Assert.assertTrue("Completed process Label is not present",
				interaction.verifyElement(By.xpath(interaction.verifyCompletedTask(serviceProcess))));
				
	}
	

	@When("^launch warpup to complete the interaction$")
	public void launch_warpup_to_complete_the_interaction() {
		
	   interaction.launchWrapup();
	
	}

	
	@Then("^Get the case ID from History and Attachments link$")
	public void get_the_case_ID_from_History_and_Attachments_link() throws Throwable {
		
		CaseID=interaction.getCaseDetails();
				
	}



	@When("^complete the wrap up$")
	public void complete_the_wrap_up() {
	   
	    interaction.completeWrapUpWithoutReason();
	  
	    CRMObjectsBean.getObjectsMap().put("caseids", caseId);
	}
	


	
	@When("^complete the wrap up and verify reason \"([^\"]*)\"$")
	public void complete_the_wrap_up_and_verify_reason(String reason)  {

		interaction.completeWrapUp(reason);
	   
	    CRMObjectsBean.getObjectsMap().put("caseids", caseId);
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

	
	@Then("^verifiy left nav, header, composites, dialogs and other sections$")
	public void verifiy_left_nav_header_composites_dialogs_and_other_sections() {
		
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath(PhoneCall.PHONE_XPATH));
		
		Assert.assertTrue("phone field is not present",interaction.verifyElement(By.xpath(PhoneCall.PHONE_XPATH)));
		Assert.assertTrue("Email Field is not present",interaction.verifyElement(By.xpath("//span[text()='Email']")));
		Assert.assertTrue("Address field is not present",interaction.verifyElement(By.xpath(PhoneCall.ADDRESS_XPATH)));
		Assert.assertTrue("Chrun risk is not present",interaction.verifyElement(By.xpath(PhoneCall.CHURN_RISK_XPATH)));
		Assert.assertTrue("Lifetime Value is not present",interaction.verifyElement(By.xpath(PhoneCall.LIFETIME_XPATH)));
		Assert.assertTrue("Customer since field is not present",interaction.verifyElement(By.xpath(PhoneCall.CUSTOMER_SINCE_XPATH)));
		Assert.assertTrue("Call back field is not present",interaction.verifyElement(By.xpath(PhoneCall.NPS_TREND_XPATH)));
		Assert.assertTrue("Last interaction field is not present",interaction.verifyElement(By.xpath(PhoneCall.LAST_INTERACTION_XPATH)));
		Assert.assertTrue("Reason field is not present",interaction.verifyElement(By.xpath(PhoneCall.REASON_XPATH)));
		Assert.assertTrue("NPS field is not present",interaction.verifyElement(By.xpath(PhoneCall.NPS_XPATH)));
		
	

		Assert.assertTrue("Add Task button is not present",interaction.verifyElement(By.xpath("//button[contains(@title,'Add')]")));
		Assert.assertTrue("Wrap up button is not present",interaction.verifyElement(By.xpath("//button[@class='Wrap_up_button pzhc pzbutton' and @title='Wrap Up']")));
		Assert.assertTrue("Summary tab is not present", interaction.verifyElement(By.xpath("//h3[text()='Overview']")));
		Assert.assertTrue("Open service case section is not present",interaction.verifyElement(By.xpath("//h2[text()='Recent cases']")));
		Assert.assertTrue("Recent Interactions section is not present",interaction.verifyElement(By.xpath("//h2[text()='Recent interactions']")));
		interaction.verifyElement(By.xpath("//h2[text()='Authorized Contacts']"));

	}
	
	@Then("^check for \"([^\"]*)\" account displayed$")
	public void check_for_account_displayed(String accountNumber) throws Throwable {
		
		Assert.assertTrue(accountNumber+" account is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'"+accountNumber+"')]/ancestor::tr[1]")));
	   
	}

	
	
	@Then("^verify \"([^\"]*)\" flow is launched$")
	public void verify_flow_is_launched(String serviceProcess) {
		
		String INPROGESS_LABEL_XPATH = "//a[contains(text(),'#serviceProcess#')]";
		String finalXPathInProgress = new String(INPROGESS_LABEL_XPATH).replace("#serviceProcess#", serviceProcess);
		Assert.assertTrue(serviceProcess +"In Progress Label is not present",
				interaction.verifyElement(By.xpath(finalXPathInProgress)));
		
		/*interaction.clickOnToolsMenuButton();*/


		interaction.clickOnOtherActionsButton();
		Assert.assertTrue("Where Am I menu option is not present",interaction.verifyElement(By.xpath(PhoneCall.WHERE_AM_I_XPATH)));
		Assert.assertTrue("History and Attachment option is not present",interaction.verifyElement(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH)));
		Assert.assertTrue("Pulse option is not present", interaction.verifyElement(By.xpath(PhoneCall.PULSE_XPATH)));

		Assert.assertTrue("Refresh menu option is not present",interaction.verifyElement(By.xpath(PhoneCall.REFRESH_XPATH)));
		Assert.assertTrue("Cancel this work menu option is not present",interaction.verifyElement(By.xpath(PhoneCall.CANCEL_WORK_XPATH)));
		Actions action = new Actions(pegaDriver.getDriver());
		action.sendKeys(Keys.ESCAPE).build().perform();
		
	}
	
	
	
	@When("^Confirm the flow$")
	public void confirm_the_flow() {
	    interaction.confirmFlow();
	}
	
	@Then("^verify dialog, FA header and other options for Schedule Activity$")
	public void verify_dialog_FA_header_and_other_options_for_Schedule_Activity() {
		String dialog = interaction.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'schedule')]")).getText();
		System.out.println(dialog);
		Assert.assertEquals("Schedule Activity initial dialog is not present or incorrect",
				"In order to schedule the activity, I'll need a few details from you. ", dialog);
		Assert.assertTrue("Schedule Activity FA header is not present",
				interaction.verifyElement(By.xpath("//label[contains(text(),'Schedule Activity')]")));
		Assert.assertTrue("In Schedule Activity Conference call is not present",
				interaction.verifyElement(By.xpath("//div[text()='Conference call']")));
		Assert.assertTrue("In Schedule Activity Appointment is not present",
				interaction.verifyElement(By.xpath("//div[text()='Appointment']")));
		Assert.assertTrue("In Schedule Activity Task is not present",
				interaction.verifyElement(By.xpath("//div[text()='Task']")));
	}
	


	

	@When("^switch to Interaction of \"([^\"]*)\"$")
	public void switch_to_Interaction_of(String interactionItem) {
		interaction.switchInteraction(interactionItem);
	}
	
	
	

	@When("^Click on \"([^\"]*)\" service process$")
	public void click_on_service_process(String serviceProcess) {
		interaction.selectSingleserviceprocess(serviceProcess);
	    
	}



	@Then("^verify that \"([^\"]*)\" flow is launched with dialog$")
	public void verify_that_flow_is_launched_with_dialog(String serviceProcess) throws Throwable {
		
		if (serviceProcess == "Address change") {
			Assert.assertTrue("Address change flow header is not present",
					interaction.verifyElement(By.xpath("//label[contains(text(),'Address Change')]")));
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			Assert.assertEquals("Address Change flow dialog is not present or incorrect",
					"May I have the new address and phone number for your Individual account, please?", dialog);
		} else if (serviceProcess == "Statement Copy") {
			Assert.assertTrue("Address change flow header is not present",
					interaction.verifyElement(By.xpath("//label[contains(text(),'Recent Statements')]")));
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			Assert.assertEquals("Address Change flow dialog is not present or incorrect",
					"Which statements would you like to receive copies of, Ms. Connor?", dialog);
			Assert.assertTrue("Flow action header message is not present", interaction
					.verifyElement(By.xpath("//div[text()='Select the statements requested by the customer:']")));
		}

		else if (serviceProcess == "Schedule appointment") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			Assert.assertEquals("Appointment dialog is not present or incorrect",
					"         Please enter  details for the Appointment     ", dialog);

		}

		else if (serviceProcess == "Add New Organization") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			Assert.assertEquals("Add new organization dialog is not present or incorrect",
					"Can you spell the name of your business for me? And, what is the company's primary address?",
					dialog);
		} else if (serviceProcess == "Create lead") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			
			Assert.assertEquals("Create Lead dialog is not present or incorrect",
					"Thank you for your interest in our products, Ms. Connor. Let me collect some details from you so that a sales person can contact you.",
					dialog);
		} else if (serviceProcess == "Modify account links") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			
			Assert.assertEquals("Modify Account links dialog is not present or incorrect",
					"I can add or delete an account link. Can you give me the account number of the account you'd like me to link or unlink to your profile?",
					dialog);
		}

		else if (serviceProcess == "Primary Communication") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			
			Assert.assertEquals("PrimaryCommunication dialog is not present or incorrect",
					"What is the primary phone number? Do you have a general email or fax number that I should record?",
					dialog);
		}

		else if (serviceProcess == "Schedule appointment") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			
			Assert.assertEquals("Schedule appointment dialog is not present or incorrect",
					"Please enter details for the Appointment", dialog);
		}

		else if (serviceProcess == "Offer negotiator") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			
			Assert.assertEquals("Schedule appointment dialog is not present or incorrect",
					"Hi Ms. Connor, before I close your account, can I ask you a few questions about your experience with us as your provider?",
					dialog);
		}

		else if (serviceProcess == "Make offer") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			
			Assert.assertEquals("Schedule appointment dialog is not present or incorrect",
					"Would you be interested in learning more about our Cash Rewards promotion ?", dialog);
		}

		else if (serviceProcess == "Dispute Transaction") {
			String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			
			Assert.assertEquals("Dispute Transaction dialog is not present or incorrect",
					"Which transaction were you concerned about  Ms. Connor?", dialog);
		}
		// caseId.add(phoneInteraction.getCaseID());

	}

	@When("^Search with email \"([^\"]*)\"$")
	public void search_with_email(String email) throws Throwable {
		phoneInteraction.searchByEmail(email);
	}
	
	

	@Then("^verify the contact displayed$")
	public void verify_the_contact_displayed() throws Throwable {
		Assert.assertTrue("search results are not present",
				interaction.verifyElement(By.xpath("//span[text()='Lake']")));
		Assert.assertTrue("search results are not present",
				interaction.verifyElement(By.xpath("//span[text()='Jennifer']")));
		Assert.assertTrue("search results are not present",
				interaction.verifyElement(By.xpath("//span[text()='Easton']")));
		Assert.assertTrue("search results are not present", interaction.verifyElement(By.xpath("//span[text()='MD']")));
	}

	
	@Then("^Verify the dialog, FA header, message displayed$")
	public void verify_the_dialog_FA_header_message_displayed() throws Throwable {
		String dialog = interaction.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
		System.out.println(dialog);
		Assert.assertEquals("Select Account dialog is not present or incorrect",
				"Is there an account you are calling about today?",
				dialog);
		Assert.assertTrue("Select an Account FA header is not present",interaction.verifyElement(By.xpath("//span[text()='Select an account']")));
		Assert.assertTrue("Select an account flow action dialog is not present",interaction.verifyElement(By.xpath("//div[contains(text(),'Select an account for')]")));
		Assert.assertTrue("Select an account flow action dialog is not present",interaction.verifyElement(By.xpath("//div[contains(text(),'or press Submit to continue')]")));
		
		phoneInteraction.clickOnOtherActionsButton();
		Assert.assertTrue("Where Am I menu option is not present",interaction.verifyElement(By.xpath(PhoneCall.WHERE_AM_I_XPATH)));
		Assert.assertTrue("Refresh menu option is not present",interaction.verifyElement(By.xpath(PhoneCall.REFRESH_XPATH)));
		Assert.assertTrue("Exit Interaction option is not present",interaction.verifyElement(By.xpath(PhoneCall.EXIT_INTE_XPATH)));
		Assert.assertTrue("History and Attachment option is not present",interaction.verifyElement(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH)));
		Assert.assertTrue("Pulse option is not present", interaction.verifyElement(By.xpath(PhoneCall.PULSE_XPATH)));
	}

	@When("^select \"([^\"]*)\" and options as account \"([^\"]*)\" topic \"([^\"]*)\" Assign to \"([^\"]*)\" and name \"([^\"]*)\"$")
	public void select_and_options_as_account_topic_Assign_to_and_name(String type, String account, String topic, String assign, String operator) throws Throwable {
		phoneInteraction.scheduleActivity(type, account, topic, assign, operator);
	}

	@Then("^Confirm the case details$")
	public void confirm_the_case_details() throws Throwable {
		String dialog = interaction.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'scheduled')]")).getText();
		System.out.println(dialog);
		Assert.assertEquals("Schedule Activity confirm flow dialog is not present or incorrect",
				"I've scheduled your request, Mrs. Lake.", dialog);
		Assert.assertTrue("Schedule activity  is not present", pegaDriver
				.verifyElement(By.xpath("//span[text()='Schedule Activity']")));
	}



	@Then("^verify Connor name and Interaction title and dialog$")
	public void verify_Connor_name_and_Interaction_title_and_dialog() throws Throwable {
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//span[contains(text(),'Sara') and contains(text(),'Connor')]"));
		Assert.assertTrue("Account Name is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Sara') and contains(text(),'Connor')]")));
		
		
	}

	@Then("^Verify all the details for \"([^\"]*)\" Account number$")
	public void verify_all_the_details_for_Account_number(String AccountNumber) throws Throwable {
		

		// span[regex:contains(text(),'^[A-Za-z]{1,}\s[0-9]{1,}[,]\s[0-9]{1,}$')]

		if (AccountNumber == "1234500078963456") {
			Assert.assertTrue("Credit Card header are not present",
					interaction.verifyElement(By.xpath("//span[contains(text(),'Credit Card')]")));
			Assert.assertTrue("Account Owner name header are not present",
					interaction.verifyElement(By.xpath("//p[contains(text(),'Sara Connor')]")));
		}

		if (AccountNumber == "111110000") {
			Assert.assertTrue("Credit Card header are not present",
					interaction.verifyElement(By.xpath("//span[contains(text(),'Commercial Checking')]")));
			Assert.assertTrue("Account Owner name header are not present",
					interaction.verifyElement(By.xpath("//p[contains(text(),'Acme Software ')]")));

		}

		// Account field
		Assert.assertTrue("Account header are not present",
				interaction.verifyElement(By.xpath("//div[label[contains(text(),'Account #')]]")));
		Assert.assertTrue("Account number header are not present",
				interaction.verifyElement(By.xpath("//a[contains(text(),'" + AccountNumber + "')]")));
		Assert.assertTrue("Account type header are not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Account type')]")));

		//Assert.assertTrue("Account Owner header are not present",interaction.verifyElement(By.xpath("//span[contains(text(),'Account owner')]")));

		Assert.assertTrue("Edit link is not present",
				interaction.verifyElement(By.xpath("//a[contains(text(),'Edit')]")));

		// Balance field
		Assert.assertTrue("Status header is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Status')]")));
		Assert.assertTrue("Active header is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Active')]")));
		Assert.assertTrue("Last statement date is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Last statement date')]")));
		Assert.assertTrue("Next statement date is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Next statement date')]")));

		// Payment date
		Assert.assertTrue("Payment date is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Payment date')]")));
		Assert.assertTrue("Last payment amount is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Last payment amount')]")));
		Assert.assertTrue("Last payment posted is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Last payment posted')]")));
		Assert.assertTrue("YTD payments is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'YTD payments')]")));

		// Min payment
		Assert.assertTrue("Min. payments is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Min. payment')]")));
		Assert.assertTrue("Min. payments is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Available balance')]")));
		Assert.assertTrue("Avg monthly balance is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Avg monthly balance')]")));
		Assert.assertTrue("Account open date is not present",
				interaction.verifyElement(By.xpath("//span[contains(text(),'Account open date')]")));
	}

	@Then("^verify the tabs in \"([^\"]*)\" widget$")
	public void verify_the_tabs_in_widget(String widgetName) throws Throwable {

		if (widgetName.equalsIgnoreCase("Transaction")) {
			Assert.assertTrue("Date field is not present",
					interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Date']")));
			Assert.assertTrue("Txn ID field is not present",
					interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Transaction id']")));
			Assert.assertTrue("Merchant field is not present",
					interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Merchant']")));
			//Assert.assertTrue("Txn amount field is not present",interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Transaction amount']")));
			Assert.assertTrue("Txn amount field is not present",interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Amount']")));
		}

		if (widgetName.equalsIgnoreCase("Statements")) {
			Assert.assertTrue("Month field is not present",
					interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Month']")));
			Assert.assertTrue("Start balance field is not present",
					interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Start balance']")));
			Assert.assertTrue("End balance field is not present",
					interaction.verifyElement(By.xpath("//div[@class='cellIn ' and text()='End balance']")));
		}
	}

	@Then("^Select the Stage as \"([^\"]*)\" and Rating as \"([^\"]*)\" and submit$")
	public void select_the_Stage_as_and_Rating_as_and_submit(String Stage, String Rating) throws Throwable {
		DropDown leadStage = interaction.findSelectBox(By.xpath("//select[@id='LeadStage']"));
		leadStage.selectByValue(Stage);
		DropDown leadRating = interaction.findSelectBox(By.xpath("//select[@id='LeadRating']"));
		leadRating.selectByValue(Rating);
		
		PegaWebElement submitButton = interaction.findElement(By.xpath(OK_BUTTON_XPATH));
		submitButton.click();
	}

	@When("^user switches to \"([^\"]*)\" tab$")
	public void user_switches_to_tab(String tab) throws Throwable {
		interaction.userSwitchToTab(tab);
	}

	@Then("^verify Close Account dialog, header and question for connor$")
	public void verify_Close_Account_dialog_header_and_question_for_connor() throws Throwable {
		Assert.assertTrue("Close Account flow header is not present",
				interaction.verifyElement(By.xpath("//label[contains(text(),'Close an account')]")));
		String dialog = interaction.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'hear')]")).getText();
		
		Assert.assertEquals("Close account flow dialog is not present or incorrect",
				"I'm sorry to hear you'd like to close this account, Ms. Connor.  May I ask the reason?", dialog);
		Assert.assertTrue("Flow action header message is not present", interaction
				.verifyElement(By.xpath("//div[text()='Enter the reason for closing the account 1234500078963456']"))); 
	}

	@When("^close the account with reason \"([^\"]*)\" and comments \"([^\"]*)\"$")
	public void close_the_account_with_reason_and_comments(String reason, String comment){
		interaction.closeAccount(reason, comment);
	}

	@Then("^verify the dialog, status and changes$")
	public void verify_the_dialog_status_and_changes() throws Throwable {
		String dialog = interaction.findElement(By.xpath("//div[@id='DialogContent' and contains(.,'request')]")).getText();
		
		Assert.assertEquals("Close Account flow dialog is not present or incorrect",
				"I've completed entering your request.", dialog);
		Assert.assertTrue("Close Account  is not present",
				interaction.verifyElement(By.xpath("//span[text()='Close Account']")));

		Assert.assertTrue("Serive case status is not present",
				interaction.verifyElement(By.xpath("//span[text()='Open']")));
	}

	@Then("^Verify the Status of \"([^\"]*)\" is \"([^\"]*)\"$")
	public void verify_the_Status_of_is(String subCase, String Status) throws Throwable {
			
		
		if(subCase.equalsIgnoreCase("Pick Up Card At Branch")||subCase.equalsIgnoreCase("Resolve work")||subCase.equalsIgnoreCase("Dispute Transaction")
				||subCase.equalsIgnoreCase("Complete scheduled appointment")||subCase.equalsIgnoreCase("Process dispute")||subCase.equalsIgnoreCase("Resolve complaint or compliment")){
			Assert.assertTrue(" Enter new account address field is not present",
					interaction.verifyElement(By.xpath("//a[contains(text(),'"+subCase+"')]")));
			
			
			}
			
		else{
			Assert.assertTrue(" Enter new account address field is not present",
					interaction.verifyElement(By.xpath("//div[contains(text(),'"+subCase+"')]")));
			
		}	
		
		if(Status.equalsIgnoreCase("Open")){
			Assert.assertTrue(" Completed field is not present",
					interaction.verifyElement(By.xpath("//a[contains(text(),'"+subCase+"')]/ancestor::td[1]/following-sibling::td[3]/descendant::a[contains(text(),'"+Status+"')]")));
			
		}
		else if (Status.equalsIgnoreCase("Completed")){
			Assert.assertTrue(" Completed field is not present",
					interaction.verifyElement(By.xpath("//div[contains(text(),'"+subCase+"')]/ancestor::td[1]/following-sibling::td[3]/descendant::a[contains(text(),'"+Status+"')]")));
			
		}
	}

	@Then("^verify the above interaction is displayed under recent cases widget$")
	public void verify_the_above_interaction_is_displayed_under_recent_cases_widget() throws Throwable {
		 interaction.verifyRecentCases();
	}

	@Then("^Veriy \"([^\"]*)\" status is displayed for the case$")
	public void veriy_status_is_displayed_for_the_case(String Status) throws Throwable {
		interaction.verifytheStatusForTheCase(Status);
	}

	@When("^Select the above created Case$")
	public void select_the_above_created_Case() throws Throwable {
		interaction.selectCaseFromCasesWidget();
	}

	@Then("^Verify \"([^\"]*)\" subcase is displayed$")
	public void verify_subcase_is_displayed(String subCase) throws Throwable {
		
		Assert.assertTrue(" Sub case field is not present",
				interaction.verifyElement(By.xpath("//div[contains(@class,'dataValueRead')]/a[contains(text(),'"+subCase+"')]")));
	}

	@When("^Select \"([^\"]*)\" sub case$")
	public void select_sub_case(String arg1) throws Throwable {
		interaction.selectSubCaseFromTasks(arg1);
	}

	@Then("^Verify the header and other deatis in close account page$")
	public void verify_the_header_and_other_deatis_in_close_account_page() throws Throwable {
		
							
			Assert.assertTrue("Close Account header is not present",interaction.verifyElement(By.xpath("//label[contains(text(),'Close Account')]")));
			Assert.assertTrue("Reason header is not present",interaction.verifyElement(By.xpath("//div[text()='Reason']")));
			Assert.assertTrue("Comments header is not present",interaction.verifyElement(By.xpath("//div[text()='Comments']")));
	}

	@When("^Select \"([^\"]*)\" statement  and submit$")
	public void select_statement_and_submit(String transaction) throws Throwable {
		interaction.selectDisputeTransaction(transaction);
	}

	@Then("^Verify Dialog, amount and In-progress task for \"([^\"]*)\" statement$")
	public void verify_Dialog_amount_and_In_progress_task_for_statement(String disputeId) throws Throwable {
		
		
					
		//String dialog = interaction.findElement(By.xpath("//div[@id='DialogContent']")).getText();
		String dialog = interaction.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'charge')]")).getText();
		
		
		if(disputeId.equalsIgnoreCase("1029")){
			
			Assert.assertEquals("Select Contact flow dialog is not present or incorrect",
					"I see the $ 29.74 charge for North Western Power Supply , Ms. Connor. Can you tell me the reason for this dispute?", dialog);
		}
		
		if(disputeId.equalsIgnoreCase("2083")){
			
			Assert.assertEquals("Select Contact flow dialog is not present or incorrect",
					//"I see the $ 349.87 charge for Torento Auto Finance , Ms. Connor. Can you tell me the reason for this dispute?", dialog);
					"I see the $ 349.87 charge for Torento Auto Finance, Ms. Connor. Can you tell me the reason for this dispute?", dialog);
		}
		
		if(disputeId.equalsIgnoreCase("2089")){
			
			Assert.assertEquals("Select Contact flow dialog is not present or incorrect",
					"I see the $ 129.74 charge for Volvo Auto Parts, Ms. Connor. Can you tell me the reason for this dispute?", dialog);
		}
		
	if(disputeId.equalsIgnoreCase("8026")){
			
			Assert.assertEquals("Select Contact flow dialog is not present or incorrect",
					"I see the $ 1566.32 charge for Celebrity Travel Ms. Connor. Can you tell me the reason for this dispute?", dialog);
		}
	if(disputeId.equalsIgnoreCase("1578")){
		
		Assert.assertEquals("Select Contact flow dialog is not present or incorrect",
				"I see the $ 322.00 charge for Hyundai Finance Limited, Ms. Connor. Can you tell me the reason for this dispute?", dialog);
	}
				
		Assert.assertTrue("In progress Dispute Transaction field is not present",
				interaction.verifyElement(By.xpath("//a[contains(@title,'Dispute Transaction')]")));
		
		Assert.assertTrue("Dispute Transaction flow action header is not present",
				interaction.verifyElement(By.xpath("//label[contains(text(),'Dispute Transaction')]")));
		
				
		interaction.clickOnOtherActionsButton();
		Assert.assertTrue("Where Am I menu option is not present",interaction.verifyElement(By.xpath(phoneInteraction.WHERE_AM_I_XPATH)));
		Assert.assertTrue("Refresh menu option is not present",interaction.verifyElement(By.xpath(phoneInteraction.REFRESH_XPATH)));
		Assert.assertTrue("Exit Interaction option is not present",interaction.verifyElement(By.xpath(phoneInteraction.CANCEL_WORK_XPATH)));
	}

	@When("^Select a dispute \"([^\"]*)\" and submit$")
	public void select_a_dispute_and_submit(String reason) throws Throwable {
		interaction.selectReasonForDispute(reason);
	}

	@Then("^Verify the confirm screen and inprogress task$")
	public void verify_the_confirm_screen_and_inprogress_task() throws Throwable {
		

		Assert.assertTrue("Dispute Transaction field is not present",interaction.verifyElement(By.xpath("//a[contains(@title,'Dispute Transaction')]")));
		Assert.assertTrue("Dispute Transaction flow action dialog is not present",interaction.verifyElement(By.xpath("//div[text()='Claim(s) successfully created, please confirm!']")));

		Assert.assertTrue("Dispute Transaction flow action dialog is not present",interaction.verifyElement(By.xpath("//span[text()='Dispute Transaction']")));
	}

	@Then("^Verify the \"([^\"]*)\" status displayed$")
	public void verify_the_status_displayed(String status) throws Throwable {
		String Initial_Xpath = "//div[@class='field-item dataValueRead']/span[contains(text(),'#statustype#')]";
		String Final_XPath = new String(Initial_Xpath).replace("#statustype#", status);
		Assert.assertTrue("Status is not present",interaction.verifyElement(By.xpath(Final_XPath)));
	}

	@When("^Confirm the Dispute transaction flow$")
	public void confirm_the_Dispute_transaction_flow() throws Throwable {
		interaction.confirmDisputeDetails();
	}

	@Then("^Verify \"([^\"]*)\" count is for Dispute Transaction is displayed$")
	public void verify_count_is_for_Dispute_Transaction_is_displayed(String count) throws Throwable {
		String Initial_Xpath = "//span[text()='(#total#)']";
		String Final_XPath = new String(Initial_Xpath).replace("#total#", count);

		Assert.assertTrue("Count is not present", interaction.verifyElement(By.xpath(Final_XPath)));
	}


	@Then("^verify the wrapup dialog$")
	public void verify_the_wrapup_dialog() throws Throwable {
	   
	}

	@Then("^User will be navigated to the portal$")
	public void user_will_be_navigated_to_the_portal() throws Throwable {
	    
	}
	

	
}
