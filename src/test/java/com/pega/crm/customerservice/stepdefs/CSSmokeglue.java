package customerservice.stepdefs;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.google.inject.Inject;
import com.pega.MyTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;
import com.pega.tiles.TopNavFixture;
import customerservice.CSPortal;
import customerservice.designerstudio.ApplicationWizard;
import customerservice.interactions.Interactions;
import customerservice.interactions.PhoneCall;
import customerservice.utils.CommonMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped

public class CSSmokeglue {

	private PhoneCall phoneInteraction;
	private Interactions interaction;
	private CommonMethods commonMethods;
	private PegaWebDriver pegaDriver;
	TestEnvironment testEnv;
	private CSPortal csPortal;
	public String frameId = null;
	public Wizard newWizard = null;
	
	String OK_BUTTON_XPATH = "//div[@class='pzbtn-mid' and text()='OK']";
	String caSysadminLogOff_XPATH = "//span[text()='Log off']";
	String AddressLine1 = "//input[contains(@name,'AddressLine1')]";
	String AddressLine2 = "//input[contains(@name,'AddressLine2')]";
	String dropdownCountry = "//select[contains(@name,'CountryCode')]";
	String City = "//input[contains(@name,'City')]";
	String ZipCode = "//input[contains(@name,'ZipCode')]";
	

	@Inject
	public CSSmokeglue(TopNavFixture topNavFixture, MyTestEnvironment testEnv) {
		
		phoneInteraction = topNavFixture.getPhoneCall();
		commonMethods = testEnv.getCommonMethods();
		pegaDriver = testEnv.getPegaDriver();
		interaction = topNavFixture.getInteractions();

	}

	@Then("^verify no contact is present and create new contact option is available$")
	public void verify_no_contact_is_present_and_create_new_contact_option_is_available() throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		Assert.assertTrue("Customer Matches heading is present",
				pegaDriver.verifyElement(By.xpath("//div[text()='Customer Matches(0)']")));
		Assert.assertTrue("Create new contact button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@title='Create new contact']")));
		Assert.assertTrue("Customer does not exists message is not present",
				pegaDriver.verifyElement(By.xpath("//div[text()='This customer does not exist']")));
	}

	@When("^CSR opens the create contact flow$")
	public void csr_opens_the_create_contact_flow() throws Throwable {
		interaction.launchCreateContactFlow();
	}

	@Then("^Enter mandatory fields \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and submit$")
	public void enter_mandatory_fields_and_and_and_submit(String Fitstname, String lastname, String mailid) {
		phoneInteraction.enterMandatoryFieldsInContacts(Fitstname, lastname, mailid);

	}

	@Then("^update DOB \"([^\"]*)\" and Gender \"([^\"]*)\" and Marital Status \"([^\"]*)\"$")
	public void update_DOB_and_Gender_and_Marital_Status(String DOB, String Gender, String status) {

		interaction.updateContactProfile(DOB, Gender, status);

	}

	@Then("^update the primary address$")
	public void update_the_primary_address() {

		//interaction.updatePrimaryAddressInContactProfile();
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement newAddress = pegaDriver.findElement(By.xpath("//a[@title='Add a new address']"));
		newAddress.click();
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement checkBox = pegaDriver.findElement(By.xpath("//span[contains(@title,'Check if primary')]"));
		checkBox.click();
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement changeAddress1 = pegaDriver.findElement(By.xpath(AddressLine1));
		changeAddress1.sendKeys("123");
		PegaWebElement changeAddress = pegaDriver.findElement(By.xpath(AddressLine2));
		changeAddress.sendKeys("New Street");
		DropDown CountryCode = pegaDriver.findSelectBox(By.xpath(dropdownCountry));
		CountryCode.selectByValue("USA");// AUS
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement city = pegaDriver.findElement(By.xpath(City));
		city.sendKeys("Alabama");// Sydney
		DropDown state = pegaDriver.findSelectBox(By.xpath("//select[@title='Select State']"));
		state.selectByValue("AL");
		PegaWebElement zipCode = pegaDriver.findElement(By.xpath(ZipCode));
		zipCode.sendKeys("35006");
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement submitButton = pegaDriver.findElement(By.id("ModalButtonSubmit"));
		submitButton.click();
	}


	@Then("^update communication preference method \"([^\"]*)\" time \"([^\"]*)\" and language to \"([^\"]*)\"$")
	public void update_communication_preference_method_time_and_language_to(String mail, String Time, String Language) throws InterruptedException {
		pegaDriver.switchToActiveFrame();
		PegaWebElement editPreference = pegaDriver
				.findElement(By.xpath("//a[@data-test-id='2017122801503707468a4b4a37-2779-4922-9226-0e6b0f66741c595' or @title='Edit communication preferences']"));
		editPreference.click();
		pegaDriver.waitForDocStateReady(2);
		DropDown language = pegaDriver.findSelectBox(By.xpath("//select[@data-test-id='20150324022253084615187']"));
		language.selectByValue(Language);
		//Commented below code due to DOM Changes and modified accordingly  @Madhuri
		//DropDown comMethod = pegaDriver.findSelectBox(By.xpath("//select[@id='CommunicationPreference']"));
		//comMethod.selectByValue(mail);
		//Modifying CommunicationMode xpath according to latest platform changes. old xpath //input[@id='CommPreferenceByEmail']
		//old //input[@data-test-id='201503240223430352394794']
		PegaWebElement CommunicationMode = pegaDriver.findElement(By.xpath("//span[contains(@title,'Email Preference')]"));	
		CommunicationMode.click();
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement submitButton = pegaDriver.findElement(By.id("ModalButtonSubmit"));
		submitButton.click();

	}

	@Then("^Submit the changes made$")
	public void submit_the_changes_made() throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement submitButton = pegaDriver.findElement(By.xpath("//button[contains(.,'Submit')]"));
		submitButton.click();
	}

	@Then("^Verify Menu options in Other Actions buttons$")
	public void verify_Menu_options_in_Other_Actions_buttons() throws Throwable {
		Assert.assertTrue("Refresh menu option is not present",pegaDriver.verifyElement(By.xpath("//span[text()='Refresh']")));
		Assert.assertTrue("Exit Interaction option is not present",pegaDriver.verifyElement(By.xpath("//span[text()='Exit interaction']")));
		//Removing the assertions as this fields are removed in 7.31 Beta build
		pegaDriver.findElement(By.xpath("//span[text()='Refresh']")).click();
		pegaDriver.waitForDocStateReady(3);
	}

	@Then("^Check the results for contact and other fields$")
	public void check_the_results_for_contact_and_other_fields() throws Throwable {
		pegaDriver.switchToActiveFrame();
		Assert.assertTrue("Last name results are not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CONNOR_LASTNAME)));
		Assert.assertTrue("First Name results are not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CONNOR_FIRSTNAME)));
		Assert.assertTrue("City results are not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CONNOR_CITY)));
		Assert.assertTrue("State results are not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CONNOR_STATE)));
	}

	@Then("^verify that \"([^\"]*)\" flow is launched with dialog$")
	public void verify_that_flow_is_launched_with_dialog(String serviceProcess) throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		if (serviceProcess == "Address change") {
			Assert.assertTrue("Address change flow header is not present",
					pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Address Change')]")));
			String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			System.out.println(dialog);
			Assert.assertEquals("Address Change flow dialog is not present or incorrect",
					"May I have the new address and phone number for your Individual account, please?", dialog);
		} else if (serviceProcess == "Statement Copy") {
			Assert.assertTrue("Address change flow header is not present",
					pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Recent Statements')]")));
			String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			System.out.println(dialog);
			Assert.assertEquals("Address Change flow dialog is not present or incorrect",
					"Which statements would you like to receive copies of, Ms. Connor?", dialog);
			Assert.assertTrue("Flow action header message is not present", pegaDriver
					.verifyElement(By.xpath("//div[text()='Select the statements requested by the customer:']")));
		}

		else if (serviceProcess == "Schedule appointment") {
			String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			System.out.println(dialog);
			Assert.assertEquals("Appointment dialog is not present or incorrect",
					"         Please enter  details for the Appointment     ", dialog);

		}

		else if (serviceProcess == "Open new account") {
			String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			System.out.println(dialog);
			Assert.assertEquals("Open new account dialog is not present or incorrect",
					"Thank you for your interest in our products, Ms. Biggs. What type of account are you interested in opening today?",
					dialog);
		}

		else if (serviceProcess == "Add New Organization") {
			String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			System.out.println(dialog);
			Assert.assertEquals("Add new organization dialog is not present or incorrect",
					"Can you spell the name of your business for me? And, what is the company's primary address?",
					dialog);
		} else if (serviceProcess == "Create lead") {
			String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			System.out.println(dialog);
			Assert.assertEquals("Create Lead dialog is not present or incorrect",
					"Thank you for your interest in our products, Ms. Connor. Let me collect some details from you so that a sales person can contact you.",
					dialog);
		} else if (serviceProcess == "Modify account links") {
			String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			System.out.println(dialog);
			Assert.assertEquals("Modify Account links dialog is not present or incorrect",
					"I can add or delete an account link. Can you give me the account number of the account you'd like me to link or unlink to your profile?",
					dialog);
		}

		else if (serviceProcess == "Primary Communication") {
			String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			System.out.println(dialog);
			Assert.assertEquals("PrimaryCommunication dialog is not present or incorrect",
					"What is the primary phone number? Do you have a general email or fax number that I should record?",
					dialog);
		}

		else if (serviceProcess == "Schedule appointment") {
			String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			System.out.println(dialog);
			Assert.assertEquals("Schedule appointment dialog is not present or incorrect",
					"Please enter details for the Appointment", dialog);
		}

		else if (serviceProcess == "Offer negotiator") {
			String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			System.out.println(dialog);
			Assert.assertEquals("Schedule appointment dialog is not present or incorrect",
					"Hi Ms. Connor, before I close your account, can I ask you a few questions about your experience with us as your provider?",
					dialog);
		}

		else if (serviceProcess == "Make offer") {
			String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			System.out.println(dialog);
			Assert.assertEquals("Schedule appointment dialog is not present or incorrect",
					"Would you be interested in learning more about our Cash Rewards promotion ?", dialog);
		}

		else if (serviceProcess == "Dispute Transaction") {
			String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
			System.out.println(dialog);
			Assert.assertEquals("Dispute Transaction dialog is not present or incorrect",
					"Which transaction were you concerned about  Ms. Connor?", dialog);
		}
		// caseId.add(phoneInteraction.getCaseID());

	}

	@Then("^Verify the dialog and next best action suggestions and coaching tip for Address Change$")
	public void verify_the_dialog_and_next_best_action_suggestions_and_coaching_tip_for_Address_Change() throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		interaction.clickOnOtherActionsButton();

		Assert.assertTrue("History and Attachment option is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH)));
		Assert.assertTrue("Pulse option is not present", pegaDriver.verifyElement(By.xpath(PhoneCall.PULSE_XPATH)));

		Assert.assertTrue("Where Am I menu option is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.WHERE_AM_I_XPATH)));

		Assert.assertTrue("Refresh menu option is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.REFRESH_XPATH)));
		Assert.assertTrue("Cancel this work menu option is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.CANCEL_WORK_XPATH)));

		Assert.assertTrue("Additional account is not present",pegaDriver.verifyElement(By.xpath("//tr[contains(@oaargs, '12457890')]")));
		Assert.assertTrue("In Progress Label is not present",pegaDriver.verifyElement(By.xpath("//a[contains(text(),'Address Change')]")));
		Assert.assertTrue("Address change flow header is not present",pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Address Change')]")));
		
		String dialog = pegaDriver.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'update')]")).getText();
		System.out.println(dialog);
		Assert.assertEquals("Address Change flow dialog is not present or incorrect",
				"I've made that change. Should I also update the addresses of the other accounts you own, Ms. Connor?",dialog);
		Assert.assertTrue("Flow action header message is not present",pegaDriver.verifyElement(By.xpath("//div[text()='Select additional accounts to update']")));
	}

	@When("^Select \"([^\"]*)\" from left nav$")
	public void select_from_left_nav(String arg1) throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		String Tab_XPATH = "//span[text()='#sericecase#']";
		String final_Tab_XPath = new String(Tab_XPATH).replace("#sericecase#", arg1);

		PegaWebElement navLeft = pegaDriver.findElement(By.xpath(final_Tab_XPath));
		navLeft.click();

	}

	@Then("^verify the options displayed under contacts$")
	public void verify_the_options_displayed_under_contacts() throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		Assert.assertTrue("Export button is not present", pegaDriver.verifyElement(By.xpath("//i[contains(@alt,'Export')]")));
		//Assert.assertTrue("Find contacts near me button is not present",pegaDriver.verifyElement(By.xpath("//button[@class='pzhc pzbutton' and text()='Find contacts near me']")));
		Assert.assertTrue("Refresh is not present",pegaDriver.verifyElement(By.xpath("//i[contains(@alt,'Refresh')]")));
		//button[@class='pzhc pzbutton' and text()='Refresh'] old xpath
		Assert.assertTrue("Contacts header is not present",pegaDriver.verifyElement(By.xpath("//div[contains(text(),'Contacts')]")));
		Assert.assertTrue("Filter header is not present",pegaDriver.verifyElement(By.xpath("//input[@id='FilterTermForContact']")));
		Assert.assertTrue("Filter button is not present",pegaDriver.verifyElement(By.xpath("//button[contains(text(),'Filter')]")));
		Assert.assertTrue("Create Contact button is not present",pegaDriver.verifyElement(By.xpath("//button[contains(text(),'Create contact')]")));
	}

	@Then("^verify the tabs present for the user$")
	public void verify_the_tabs_present_for_the_user() throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		Assert.assertTrue("Details Tab is not present",
				pegaDriver.verifyElement(By.xpath("//h2[@class='layout-group-item-title' and text()='Details']")));
		Assert.assertTrue("Relationships Tab is not present", pegaDriver
				.verifyElement(By.xpath("//h2[@class='layout-group-item-title' and text()='Relationships']")));
		Assert.assertTrue("Opportunities Tab is not present", pegaDriver
				.verifyElement(By.xpath("//h2[@class='layout-group-item-title' and text()='Opportunities']")));
		//Commented below line for Customer movie and added for Timeline.
		//Assert.assertTrue("Customer movie Tab is not present", pegaDriver.verifyElement(By.xpath("//h3[@class='layout-group-item-title' and text()='Customer movie']")));
		Assert.assertTrue("Customer movie Tab is not present", pegaDriver.verifyElement(By.xpath("//h2[@class='layout-group-item-title' and text()='Timeline']")));
		Assert.assertTrue("Engagement profile Tab is not present", pegaDriver
				.verifyElement(By.xpath("//h2[@class='layout-group-item-title' and text()='Engagement profile']")));
		Assert.assertTrue("Households Tab is not present",
				pegaDriver.verifyElement(By.xpath("//h2[@class='layout-group-item-title' and text()='Households']")));
		Assert.assertTrue("Activities Tab is not present",
				pegaDriver.verifyElement(By.xpath("//h2[@class='layout-group-item-title' and text()='Activities']")));   
	}

	@Then("^Verify the updated address$")
	public void verify_the_updated_address() throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		// String address = pegaDriver.findElement(By.xpath("")).getText();
				// System.out.println(address);
	}

	@Then("^Verify BU service process$")
	public void verify_BU_service_process() throws Throwable {
		Assert.assertTrue("Update Organization Profile is not present",
				pegaDriver.verifyElement(By.xpath("//a[text()='Update Organization Profile' and @class='Add_task']")));
		Assert.assertTrue("Modify organization links is not present",
				pegaDriver.verifyElement(By.xpath("//a[text()='Modify Organization Links' and @class='Add_task']")));
	}

	@Then("^verify that BU \"([^\"]*)\" flow is launched with dialog$")
	public void verify_that_BU_flow_is_launched_with_dialog(String serviceProcess) throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		if (serviceProcess == "Update Organization Profile") {
			Assert.assertTrue("In Progress Label is not present",
					pegaDriver.verifyElement(By.xpath("//a[contains(text(),'Update Organization Profile')]")));
			Assert.assertTrue("Update BU comm details flow header is not present",
					pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Update business unit details')]")));
			String dialog = pegaDriver.findElement(By.xpath("//div[@id='DialogContent']")).getText();
			System.out.println(dialog);
			Assert.assertEquals("Address Change flow dialog is not present or incorrect",
					"I have your business profile available. What information can I change for you,    Ms.   Connor?", dialog);
		}else if (serviceProcess == "Modify organization links") {
			Assert.assertTrue("In Progress Label is not present",
					pegaDriver.verifyElement(By.xpath("//a[contains(text(),'Modify organization links')]")));
			Assert.assertTrue("Modify BU links flow header is not present",
					pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Search for business units to link')]")));
			Assert.assertTrue("Modify BU links flow header message is not present",
					pegaDriver.verifyElement(By.xpath("//div[contains(text(),'Acme Software   is associated with the following business units')]")));
			String dialog = pegaDriver.findElement(By.xpath("//div[@id='DialogContent']")).getText();
			System.out.println(dialog);
			Assert.assertEquals("Modify BU links flow dialog is not present or incorrect",
					"What is the name of the business?", dialog);
			/*Assert.assertTrue("Flow action header message is not present", pegaDriver
					.verifyElement(By.xpath("//div[text()='Select the statements requested by the customer:']")));*/
		}
	}

	@When("^update business unit comm details and submit$")
	public void update_business_unit_comm_details_and_submit() throws Throwable {
		interaction.updateBUCommDetails();
	}

	@When("^Search with email \"([^\"]*)\"$")
	public void search_with_email(String email) throws Throwable {
		phoneInteraction.searchByEmail(email);
	}

	@Then("^verify the contact displayed$")
	public void verify_the_contact_displayed() throws Throwable {
		Assert.assertTrue("search results are not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Lake']")));
		Assert.assertTrue("search results are not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Jennifer']")));
		Assert.assertTrue("search results are not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Easton']")));
		Assert.assertTrue("search results are not present", pegaDriver.verifyElement(By.xpath("//span[text()='MD']")));
	}

	@Then("^Verify the dialog, FA header, message displayed$")
	public void verify_the_dialog_FA_header_message_displayed() throws Throwable {
		String dialog = pegaDriver.findElement(By.xpath(PhoneCall.DIALOG_ID)).getText();
		System.out.println(dialog);
		Assert.assertEquals("Select Account dialog is not present or incorrect",
				"Is there an account you are calling about today?",
				dialog);
		Assert.assertTrue("Select an Account FA header is not present",pegaDriver.verifyElement(By.xpath("//span[text()='Select an account']")));
		Assert.assertTrue("Select an account flow action dialog is not present",pegaDriver.verifyElement(By.xpath("//div[contains(text(),'Select an account for')]")));
		Assert.assertTrue("Select an account flow action dialog is not present",pegaDriver.verifyElement(By.xpath("//div[contains(text(),'or press Submit to continue')]")));
		
		phoneInteraction.clickOnOtherActionsButton();
		Assert.assertTrue("Where Am I menu option is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.WHERE_AM_I_XPATH)));
		Assert.assertTrue("Refresh menu option is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.REFRESH_XPATH)));
		Assert.assertTrue("Exit Interaction option is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.EXIT_INTE_XPATH)));
		Assert.assertTrue("History and Attachment option is not present",pegaDriver.verifyElement(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH)));
		Assert.assertTrue("Pulse option is not present", pegaDriver.verifyElement(By.xpath(PhoneCall.PULSE_XPATH)));
	}

	@When("^select \"([^\"]*)\" and options as account \"([^\"]*)\" topic \"([^\"]*)\" Assign to \"([^\"]*)\" and name \"([^\"]*)\"$")
	public void select_and_options_as_account_topic_Assign_to_and_name(String type, String account, String topic, String assign, String operator) throws Throwable {
		phoneInteraction.scheduleActivity(type, account, topic, assign, operator);
	}

	@Then("^Confirm the case details$")
	public void confirm_the_case_details() throws Throwable {
		String dialog = pegaDriver.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'scheduled')]")).getText();
		System.out.println(dialog);
		Assert.assertEquals("Schedule Activity confirm flow dialog is not present or incorrect",
				"I've scheduled your request, Mrs. Lake.", dialog);
		Assert.assertTrue("Schedule activity  is not present", pegaDriver
				.verifyElement(By.xpath("//span[text()='Schedule Activity']")));
	}

	@When("^Select \"([^\"]*)\" type as \"([^\"]*)\" issue as \"([^\"]*)\" and submit$")
	public void select_type_as_issue_as_and_submit(String option, String type, String issueType) throws Throwable {
		interaction.selectComplaint();
		interaction.selectTypeAsIssueAs(option, type, issueType);
	}

	@Then("^verify Connor name and Interaction title and dialog$")
	public void verify_Connor_name_and_Interaction_title_and_dialog() throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//span[contains(text(),'Sara') and contains(text(),'Connor')]"));
		Assert.assertTrue("Account Name is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Sara') and contains(text(),'Connor')]")));
		
		pegaDriver.switchToActiveFrame();
	}

	@Then("^Verify all the details for \"([^\"]*)\" Account number$")
	public void verify_all_the_details_for_Account_number(String AccountNumber) throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		// span[regex:contains(text(),'^[A-Za-z]{1,}\s[0-9]{1,}[,]\s[0-9]{1,}$')]

		if (AccountNumber == "1234500078963456") {
			Assert.assertTrue("Credit Card header are not present",
					pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Credit Card')]")));
			Assert.assertTrue("Account Owner name header are not present",
					pegaDriver.verifyElement(By.xpath("//p[contains(text(),'Sara Connor')]")));
		}

		if (AccountNumber == "111110000") {
			Assert.assertTrue("Credit Card header are not present",
					pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Commercial Checking')]")));
			Assert.assertTrue("Account Owner name header are not present",
					pegaDriver.verifyElement(By.xpath("//p[contains(text(),'Acme Software ')]")));

		}

		// Account field
		Assert.assertTrue("Account header are not present",
				pegaDriver.verifyElement(By.xpath("//div[label[contains(text(),'Account #')]]")));
		Assert.assertTrue("Account number header are not present",
				pegaDriver.verifyElement(By.xpath("//a[contains(text(),'" + AccountNumber + "')]")));
		Assert.assertTrue("Account type header are not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Account type')]")));

		//Assert.assertTrue("Account Owner header are not present",pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Account owner')]")));

		Assert.assertTrue("Edit link is not present",
				pegaDriver.verifyElement(By.xpath("//a[contains(text(),'Edit')]")));

		// Balance field
		Assert.assertTrue("Status header is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Status')]")));
		Assert.assertTrue("Active header is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Active')]")));
		Assert.assertTrue("Last statement date is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Last statement date')]")));
		Assert.assertTrue("Next statement date is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Next statement date')]")));

		// Payment date
		Assert.assertTrue("Payment date is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Payment date')]")));
		Assert.assertTrue("Last payment amount is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Last payment amount')]")));
		Assert.assertTrue("Last payment posted is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Last payment posted')]")));
		Assert.assertTrue("YTD payments is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'YTD payments')]")));

		// Min payment
		Assert.assertTrue("Min. payments is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Min. payment')]")));
		Assert.assertTrue("Min. payments is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Available balance')]")));
		Assert.assertTrue("Avg monthly balance is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Avg monthly balance')]")));
		Assert.assertTrue("Account open date is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Account open date')]")));
	}

	@Then("^verify the tabs in \"([^\"]*)\" widget$")
	public void verify_the_tabs_in_widget(String widgetName) throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		if (widgetName.equalsIgnoreCase("Transaction")) {
			Assert.assertTrue("Date field is not present",
					pegaDriver.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Date']")));
			Assert.assertTrue("Txn ID field is not present",
					pegaDriver.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Transaction id']")));
			Assert.assertTrue("Merchant field is not present",
					pegaDriver.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Merchant']")));
			//Assert.assertTrue("Txn amount field is not present",pegaDriver.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Transaction amount']")));
			Assert.assertTrue("Txn amount field is not present",pegaDriver.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Amount']")));
		}

		if (widgetName.equalsIgnoreCase("Statements")) {
			Assert.assertTrue("Month field is not present",
					pegaDriver.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Month']")));
			Assert.assertTrue("Start balance field is not present",
					pegaDriver.verifyElement(By.xpath("//div[@class='cellIn ' and text()='Start balance']")));
			Assert.assertTrue("End balance field is not present",
					pegaDriver.verifyElement(By.xpath("//div[@class='cellIn ' and text()='End balance']")));
		}
	}

	@Then("^Select the Stage as \"([^\"]*)\" and Rating as \"([^\"]*)\" and submit$")
	public void select_the_Stage_as_and_Rating_as_and_submit(String Stage, String Rating) throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		DropDown leadStage = pegaDriver.findSelectBox(By.xpath("//select[@id='LeadStage']"));
		leadStage.selectByValue(Stage);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown leadRating = pegaDriver.findSelectBox(By.xpath("//select[@id='LeadRating']"));
		leadRating.selectByValue(Rating);
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(OK_BUTTON_XPATH));
		submitButton.click();
	}

	@When("^user switches to \"([^\"]*)\" tab$")
	public void user_switches_to_tab(String tab) throws Throwable {
		interaction.userSwitchToTab(tab);
	}

	@Then("^verify Close Account dialog, header and question for connor$")
	public void verify_Close_Account_dialog_header_and_question_for_connor() throws Throwable {
		Assert.assertTrue("Close Account flow header is not present",
				pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Close an account')]")));
		String dialog = pegaDriver.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'hear')]")).getText();
		System.out.println(dialog);
		Assert.assertEquals("Close account flow dialog is not present or incorrect",
				"I'm sorry to hear you'd like to close this account, Ms. Connor.  May I ask the reason?", dialog);
		Assert.assertTrue("Flow action header message is not present", pegaDriver
				.verifyElement(By.xpath("//div[text()='Enter the reason for closing the account 1234500078963456']"))); 
	}

	@When("^close the account with reason \"([^\"]*)\" and comments \"([^\"]*)\"$")
	public void close_the_account_with_reason_and_comments(String reason, String comment){
		interaction.closeAccount(reason, comment);
	}

	@Then("^verify the dialog, status and changes$")
	public void verify_the_dialog_status_and_changes() throws Throwable {
		String dialog = pegaDriver.findElement(By.xpath("//div[@id='DialogContent' and contains(.,'request')]")).getText();
		System.out.println(dialog);
		Assert.assertEquals("Close Account flow dialog is not present or incorrect",
				"I've completed entering your request.", dialog);
		Assert.assertTrue("Close Account  is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Close Account']")));

		Assert.assertTrue("Serive case status is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Open']")));
	}

	@Then("^Verify the Status of \"([^\"]*)\" is \"([^\"]*)\"$")
	public void verify_the_Status_of_is(String subCase, String Status) throws Throwable {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);
		
		
		if(subCase.equalsIgnoreCase("Pick Up Card At Branch")||subCase.equalsIgnoreCase("Resolve work")||subCase.equalsIgnoreCase("Dispute Transaction")
				||subCase.equalsIgnoreCase("Complete scheduled appointment")||subCase.equalsIgnoreCase("Process dispute")||subCase.equalsIgnoreCase("Resolve complaint or compliment")){
			Assert.assertTrue(" Enter new account address field is not present",
					newWizard.verifyElement(By.xpath("//a[contains(text(),'"+subCase+"')]")));
			
			
			}
			
		else{
			Assert.assertTrue(" Enter new account address field is not present",
					newWizard.verifyElement(By.xpath("//div[contains(text(),'"+subCase+"')]")));
			
		}	
		
		if(Status.equalsIgnoreCase("Open")){
			Assert.assertTrue(" Completed field is not present",
					newWizard.verifyElement(By.xpath("//a[contains(text(),'"+subCase+"')]/ancestor::td[1]/following-sibling::td[3]/descendant::a[contains(text(),'"+Status+"')]")));
			
		}
		else if (Status.equalsIgnoreCase("Completed")){
			Assert.assertTrue(" Completed field is not present",
					newWizard.verifyElement(By.xpath("//div[contains(text(),'"+subCase+"')]/ancestor::td[1]/following-sibling::td[3]/descendant::a[contains(text(),'"+Status+"')]")));
			
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
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);
		Assert.assertTrue(" Sub case field is not present",
					newWizard.verifyElement(By.xpath("//div[contains(@class,'dataValueRead')]/a[contains(text(),'"+subCase+"')]")));
	}

	@When("^Select \"([^\"]*)\" sub case$")
	public void select_sub_case(String arg1) throws Throwable {
		interaction.selectSubCaseFromTasks(arg1);
	}

	@Then("^Verify the header and other deatis in close account page$")
	public void verify_the_header_and_other_deatis_in_close_account_page() throws Throwable {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(3);
							
			Assert.assertTrue("Close Account header is not present",pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Close Account')]")));
			Assert.assertTrue("Reason header is not present",pegaDriver.verifyElement(By.xpath("//div[text()='Reason']")));
			Assert.assertTrue("Comments header is not present",pegaDriver.verifyElement(By.xpath("//div[text()='Comments']")));
	}

	@When("^Select \"([^\"]*)\" statement  and submit$")
	public void select_statement_and_submit(String transaction) throws Throwable {
		interaction.selectDisputeTransaction(transaction);
	}

	@Then("^Verify Dialog, amount and In-progress task for \"([^\"]*)\" statement$")
	public void verify_Dialog_amount_and_In_progress_task_for_statement(String disputeId) throws Throwable {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(3);
		
					
		//String dialog = pegaDriver.findElement(By.xpath("//div[@id='DialogContent']")).getText();
		String dialog = pegaDriver.findElement(By.xpath("//div[@id='DialogContent' and contains(text(),'charge')]")).getText();
		System.out.println(dialog);
		
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
				pegaDriver.verifyElement(By.xpath("//a[contains(@title,'Dispute Transaction')]")));
		
		Assert.assertTrue("Dispute Transaction flow action header is not present",
				pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Dispute Transaction')]")));
		
				
		interaction.clickOnOtherActionsButton();
		Assert.assertTrue("Where Am I menu option is not present",pegaDriver.verifyElement(By.xpath(phoneInteraction.WHERE_AM_I_XPATH)));
		Assert.assertTrue("Refresh menu option is not present",pegaDriver.verifyElement(By.xpath(phoneInteraction.REFRESH_XPATH)));
		Assert.assertTrue("Exit Interaction option is not present",pegaDriver.verifyElement(By.xpath(phoneInteraction.CANCEL_WORK_XPATH)));
	}

	@When("^Select a dispute \"([^\"]*)\" and submit$")
	public void select_a_dispute_and_submit(String reason) throws Throwable {
		interaction.selectReasonForDispute(reason);
	}

	@Then("^Verify the confirm screen and inprogress task$")
	public void verify_the_confirm_screen_and_inprogress_task() throws Throwable {
		pegaDriver.waitForDocStateReady(2);

		Assert.assertTrue("Dispute Transaction field is not present",pegaDriver.verifyElement(By.xpath("//a[contains(@title,'Dispute Transaction')]")));
		Assert.assertTrue("Dispute Transaction flow action dialog is not present",pegaDriver.verifyElement(By.xpath("//div[text()='Claim(s) successfully created, please confirm!']")));

		Assert.assertTrue("Dispute Transaction flow action dialog is not present",pegaDriver.verifyElement(By.xpath("//span[text()='Dispute Transaction']")));
	}

	@Then("^Verify the \"([^\"]*)\" status displayed$")
	public void verify_the_status_displayed(String status) throws Throwable {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);
		String Initial_Xpath = "//div[@class='field-item dataValueRead']/span[contains(text(),'#statustype#')]";
		String Final_XPath = new String(Initial_Xpath).replace("#statustype#", status);
		Assert.assertTrue("Status is not present",pegaDriver.verifyElement(By.xpath(Final_XPath)));
	}

	@When("^Confirm the Dispute transaction flow$")
	public void confirm_the_Dispute_transaction_flow() throws Throwable {
		interaction.confirmDisputeDetails();
	}

	@Then("^Verify \"([^\"]*)\" count is for Dispute Transaction is displayed$")
	public void verify_count_is_for_Dispute_Transaction_is_displayed(String count) throws Throwable {
		String Initial_Xpath = "//span[text()='(#total#)']";
		String Final_XPath = new String(Initial_Xpath).replace("#total#", count);

		Assert.assertTrue("Count is not present", pegaDriver.verifyElement(By.xpath(Final_XPath)));
	}


	


}
