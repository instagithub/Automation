package com.pega.crm.customerservice.stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.google.inject.Inject;
import com.pega.CRMTestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;

import customerservice.interactions.Interactions;
import customerservice.interactions.NewDemoInteraction;
import customerservice.utils.CommonMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class NewDemoInteractionglue {

	private NewDemoInteraction demoInteraction;
	private CommonMethods commonMethods;
	private Interactions interaction;
	private PegaWebDriver pegaDriver;
	public String frameId = null;
	public Wizard newWizard = null;

	@Inject
	public NewDemoInteractionglue(TopNavglue topNavFixture, CRMTestEnvironment testEnv) {
		demoInteraction = topNavFixture.getDemoInteraction();
		interaction = topNavFixture.getInteractions();
		commonMethods = testEnv.getCommonMethods();
		pegaDriver = testEnv.getPegaDriver();
	}

	@Then("^verify the toaster pop values for connor$")
	public void verify_the_toaster_pop_values_for_connor() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		Assert.assertTrue("Incoming call icon not present",
				pegaDriver.verifyElement(By.xpath("//i[@class='cursordefault  icons cti-status pcti-phone cti-status-smart']")));
		Assert.assertTrue("Incoming call text not present",
				pegaDriver.verifyElement(By.xpath("//div[text()='Incoming call...']")));
		Assert.assertTrue("Sara name text not present", pegaDriver.verifyElement(By.xpath("//span[text()='Sara']")));
		Assert.assertTrue("Connor name text not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Connor']")));
		Assert.assertTrue("phone num text not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='617-374-9637']")));
		/*Assert.assertTrue("Account num label text not present",pegaDriver.verifyElement(By.xpath("//span[text()='Account:']")));
		Assert.assertTrue("Account num  text not present",pegaDriver.verifyElement(By.xpath("//span[text()='Account:']")));
		Assert.assertTrue("Account num is not present",pegaDriver.verifyElement(By.xpath("//span[text()='1234500078963456']")));
		Assert.assertTrue("Account type is not present",pegaDriver.verifyElement(By.xpath("//span[text()='(Credit Card)']")));
		Assert.assertTrue("Priority notes field is not present", pegaDriver.verifyElement(By.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'Priority note')]")));
		Assert.assertTrue("priority notes for sara is missing", pegaDriver.verifyElement(
				By.xpath("//div[@class='field-item dataValueRead']/span[text()='VIP-formerly on board of directors.']")));
		Assert.assertTrue("IVR option field is missing", pegaDriver.verifyElement(By
				.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'IVR option selected')]")));
		Assert.assertTrue("IVR option is blank", pegaDriver
				.verifyElement(By.xpath("//div[@class='field-item dataValueRead'and contains(text(),'Transaction review')]")));//text changed to Transaction review from Txn review
		Assert.assertTrue("Language field is missing", pegaDriver.verifyElement(
				By.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'Language')]")));
		Assert.assertTrue("Language value is missing", pegaDriver
				.verifyElement(By.xpath("//div[@class='field-item dataValueRead']/span[text()='English' or text()='Spanish']")));*/
		Assert.assertTrue("Decline button not visible",
				pegaDriver.verifyElement(By.xpath("//button[@title='Decline the call']")));

	}
	@Then("^verify the toaster pop values fname \"([^\"]*)\" lname \"([^\"]*)\" phone number \"([^\"]*)\" and account number \"([^\"]*)\"$")
	public void verify_the_toaster_pop_values_fname_lname_phone_number_and_account_number(String fName, String lName, String phoneNum, String acctNum) throws Throwable {
		pegaDriver.switchTo().defaultContent();
		Assert.assertTrue("Incoming call icon not present",
				pegaDriver.verifyElement(By.xpath("//i[@class='cursordefault  icons cti-status pcti-phone cti-status-smart']")));
		Assert.assertTrue("Incoming call text not present",
				pegaDriver.verifyElement(By.xpath("//div[text()='Incoming call...']")));
		Assert.assertTrue("Sara name text not present", pegaDriver.verifyElement(By.xpath("//span[text()='"+fName+"']")));
		Assert.assertTrue("Connor name text not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='"+lName+"']")));
		Assert.assertTrue("phone num text not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='"+phoneNum+"']")));
		/*Assert.assertTrue("Account num label text not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Account:']")));
		Assert.assertTrue("Account num  text not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Account:']")));
		Assert.assertTrue("Account num is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='"+acctNum+"']")));
		Assert.assertTrue("Account type is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='(Credit Card)']")));
		Assert.assertTrue("Priority notes field is not present", pegaDriver.verifyElement(
				By.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'Priority note')]")));
		Assert.assertTrue("priority notes for sara is missing", pegaDriver.verifyElement(
				By.xpath("//div[@class='field-item dataValueRead']/span[text()='VIP-formerly on board of directors.']")));
		Assert.assertTrue("IVR option field is missing", pegaDriver.verifyElement(By
				.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'IVR option selected')]")));
		Assert.assertTrue("IVR option is blank", pegaDriver
				.verifyElement(By.xpath("//div[@class='field-item dataValueRead'and contains(text(),'Transaction review')]")));//text changed to Transaction review from Txn review
		Assert.assertTrue("Language field is missing", pegaDriver.verifyElement(
				By.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'Language')]")));
		Assert.assertTrue("Language value is missing", pegaDriver
				.verifyElement(By.xpath("//div[@class='field-item dataValueRead']/span[text()='English' or text()='Spanish']")));*/
		Assert.assertTrue("Decline button not visible",
				pegaDriver.verifyElement(By.xpath("//button[@title='Decline the call']")));
	}
	
	
	@Then("^verify the toaster pop values for connor Lost/Stolen$")
	public void verify_the_toaster_pop_values_for_connor_Lost_Stolen() { 
		pegaDriver.switchTo().defaultContent();
	Assert.assertTrue("Incoming call icon not present",
			pegaDriver.verifyElement(By.xpath("//i[@class='cursordefault  icons cti-status pcti-phone cti-status-smart']")));
	Assert.assertTrue("Incoming call text not present",
			pegaDriver.verifyElement(By.xpath("//div[text()='Incoming call...']")));
	Assert.assertTrue("Sara name text not present", pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Sara')]")));
	Assert.assertTrue("Connor name text not present",
			pegaDriver.verifyElement(By.xpath("//span[text()='Connor']")));
	Assert.assertTrue("phone num text not present",
			pegaDriver.verifyElement(By.xpath("//span[text()='617-374-9637']")));
	/*Assert.assertTrue("Account num label text not present",
			pegaDriver.verifyElement(By.xpath("//span[text()='Account:']")));
	Assert.assertTrue("Account num  text not present",
			pegaDriver.verifyElement(By.xpath("//span[text()='Account:']")));
	Assert.assertTrue("Account num is not present",
			pegaDriver.verifyElement(By.xpath("//span[text()='123450000']")));
	Assert.assertTrue("Account type is not present",
			pegaDriver.verifyElement(By.xpath("//span[text()='(Individual)']")));
	Assert.assertTrue("Priority notes field is not present", pegaDriver.verifyElement(
			By.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'Priority note')]")));
	Assert.assertTrue("priority notes for sara is missing", pegaDriver.verifyElement(
			By.xpath("//div[@class='field-item dataValueRead']/span[contains(text(),'VIP-formerly on board of directors.')]")));
	Assert.assertTrue("IVR option field is missing", pegaDriver.verifyElement(By
			.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'IVR option selected')]")));
	Assert.assertTrue("IVR option is blank", pegaDriver
			.verifyElement(By.xpath("//div[@class='field-item dataValueRead'and contains(text(),'LostOrStolen')]")));
	Assert.assertTrue("Language field is missing", pegaDriver.verifyElement(
			By.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'Language')]")));
	Assert.assertTrue("Language value is missing", pegaDriver
			.verifyElement(By.xpath("//div[@class='field-item dataValueRead']/span[text()='English']")));*/
	Assert.assertTrue("Decline button not visible",
			pegaDriver.verifyElement(By.xpath("//button[@title='Decline the call']")));
	}
	
	@Then("^verify the toaster pop values for BtoB$")
	public void verify_the_toaster_pop_values_for_BtoB() {
		pegaDriver.switchTo().defaultContent();
		Assert.assertTrue("Incoming call icon not present",
				pegaDriver.verifyElement(By.xpath("//i[@class='cursordefault  icons cti-status pcti-phone cti-status-smart']")));
		Assert.assertTrue("Incoming call text not present",
				pegaDriver.verifyElement(By.xpath("//div[text()='Incoming call...']")));
		//Assert.assertTrue("Sara name text not present", pegaDriver.verifyElement(By.xpath("//span[text()='Sara']")));
		Assert.assertTrue("Sara name text not present", pegaDriver.verifyElement(By.xpath("//span[text()='Jo Anne']")));
		Assert.assertTrue("Connor name text not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Biggs']")));
		Assert.assertTrue("phone num text not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='617-374-1234']")));
		/*Assert.assertTrue("Account num label text not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Account:']")));
		Assert.assertTrue("Account num is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='111110000']")));
		Assert.assertTrue("Account type is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='(Commercial Checking)']")));
		Assert.assertTrue("Priority notes field is not present", pegaDriver.verifyElement(
				By.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'Priority note')]")));
		Assert.assertTrue("priority notes for sara is missing", pegaDriver.verifyElement(
				By.xpath("//div[@class='field-item dataValueRead']/span[text()='VIP-formerly on board of directors.']")));
		Assert.assertTrue("IVR option field is missing", pegaDriver.verifyElement(By
				.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'IVR option selected')]")));
		Assert.assertTrue("Language field is missing", pegaDriver.verifyElement(
				By.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'Language')]")));
		Assert.assertTrue("Language value is missing", pegaDriver
				.verifyElement(By.xpath("//div[@class='field-item dataValueRead']/span[text()='English']")));*/
		Assert.assertTrue("Decline button not visible",
				pegaDriver.verifyElement(By.xpath("//button[@title='Decline the call']")));
	    
	}

	@When("^CSR accepts the demo call$")
	public void csr_accepts_the_demo_call() {
	    
		demoInteraction.acceptCall();
		
	}
	@When("^User accepts the demo call$")
	public void user_accepts_the_demo_call() throws Throwable {
		demoInteraction.acceptCall();
	}
	@Then("^Verifiy Interaction tab and verify the corrosponding fields$")
	public void verifiy_Interaction_tab_and_verify_the_corrosponding_fields() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// mapValues = commonMethods.assertTopHeaderFields("Sara R Connor");
		// commonMethods.verifyResult(mapValues.get("Lifetime
		// value"),"Platinum");
		// commonMethods.verifyResult(mapValues.get("Churn risk"),"High");
		
		
		frameId = pegaDriver.getActiveFrameId(false);
		Wizard newWizard = pegaDriver.findWizard(frameId);

		Assert.assertTrue("Add Task Button is not present",
				newWizard.verifyElement(By.xpath("//button[@title='Add Task']")));
		Assert.assertTrue("Wrap Up button is not present",
				newWizard.verifyElement(By.xpath("//button[@class='Wrap_up_button pzhc pzbutton' and @title='Wrap Up']")));
		String actualText = commonMethods.getText(By.xpath("//h2[contains(text(),'Next best action')]"), pegaDriver);
		String expectedText = "Next best action";
		commonMethods.verifyResult(actualText, expectedText);
		Assert.assertTrue("Account Tab Text is not visible",
				newWizard.verifyElement(By.xpath("//h3[text()='Account']/i[@class='icon icon-openclose']")));
		Assert.assertTrue("Summary Tab Text is not Visible",
				newWizard.verifyElement(By.xpath("//h3[text()='Overview']/i[@class='icon icon-openclose']")));
		/*Assert.assertTrue("Account No is not displayed", newWizard
				.verifyElement(By.xpath("//a[starts-with(@name,'CPMAccountData_pyWorkPage') and contains(text(),'12345000')]")));*/
		actualText = commonMethods.getText(By.xpath("//*[contains(text(),'Recent cases')]"), pegaDriver);
		expectedText = "Recent cases";
		commonMethods.verifyResult(actualText, expectedText);
		actualText = commonMethods.getText(By.xpath("//*[contains(text(),'Recent interactions')]"), pegaDriver);
		expectedText = "Recent interactions";
		commonMethods.verifyResult(actualText, expectedText);
		actualText = commonMethods.getText(By.xpath("//h2[contains(text(),'Transactions')]"), pegaDriver);
		expectedText = "Transactions";
		commonMethods.verifyResult(actualText, expectedText);
		actualText = commonMethods.getText(By.xpath("//h2[contains(text(),'Statements')]"), pegaDriver);
		expectedText = "Statements";
		commonMethods.verifyResult(actualText, expectedText);
//		pegaDriver.switchToActiveFrame();
		actualText = commonMethods.getText(By.xpath("//h2[contains(text(),'Authorized Contacts') or contains(text(),'Authorized contacts')]"), pegaDriver);
		expectedText = "Authorized contacts";
		commonMethods.verifyResult(actualText, expectedText);
		
		
	}

	@When("^CSR clicks on the Account Number select Commercial Account$")
	public void csr_clicks_on_the_Account_Number_select_Commercial_Account() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		demoInteraction.changeToDifferentAccount("1234500078963456", "111110000");
	}

	@Then("^Verify the Commercial Account is selected and New Tab Business Unit is displayed$")
	public void verify_the_Commercial_Account_is_selected_and_New_Tab_Business_Unit_is_displayed() throws Throwable {

		// Asserting new tab added Business Unit
		Assert.assertTrue("Tab Business Unit is displayed",
				pegaDriver.verifyElement(By.xpath("//h3[contains(text(),'Organization')]")));

		// Asserting Account Type
		String expectedValue = pegaDriver.findElement(By.xpath("//span[contains(text(),'Account type')]/../div/span")).getText();
		assert expectedValue.equalsIgnoreCase("Commercial Checking");

		// Asserting Account Owner
		expectedValue = pegaDriver
				.findElement(By
						.xpath("//span[@class='field-caption dataLabelForRead' and text()='Account owner']/../div/span"))
				.getText();
		assert expectedValue.equalsIgnoreCase("Acme Software");

	}

	@When("^CSR clicks on the new tab Busniess Unit$")
	public void csr_clicks_on_the_new_tab_Busniess_Unit() throws Throwable {

		demoInteraction.clickTab("Organization");
	}

	@Then("^Verify the fields displayed in the interaction area for the new tab$")
	public void verify_the_fields_displayed_in_the_interaction_area_for_the_new_tab() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		// Asserting Business Unit Type
		//String expectedValue = pegaDriver
				//.findElement(By.xpath("//span[@class='field-caption dataLabelForRead' and text()='Organization type']/../div/span"))
				//.getText();
		//assert expectedValue.equalsIgnoreCase("Fortune 500");

		// Asserting fields for the Business Unit
		Assert.assertTrue("Label Type is not present", pegaDriver
				.verifyElement(By.xpath("//span[@class='field-caption dataLabelForRead' and text()='Organization type']")));
		Assert.assertTrue("Label Address is not present", pegaDriver.verifyElement(
				By.xpath("//span[@class='field-caption dataLabelForRead' and text()='Address']")));
		//Assert.assertTrue("Label TaxID is not present", pegaDriver.verifyElement(By.xpath("//span[@class='field-caption dataLabelForRead cs_standard_dataLabelForRead' and text()='Tax ID']")));
		Assert.assertTrue("Label Industry is not present", pegaDriver
				.verifyElement(By.xpath("//span[@class='field-caption dataLabelForRead' and text()='Industry']")));
		//Assert.assertTrue("Label Account Open Date is not present", pegaDriver.verifyElement(By.xpath("//span[@class='field-caption dataLabelForRead' and text()='Account open date']")));
		Assert.assertTrue("Label WebSite Link is not present", pegaDriver
				.verifyElement(By.xpath("//span[@class='field-caption dataLabelForRead' and text()='Website']")));
	}

	@Then("^Verify Tasks for the Business Unit in AddTask Button$")
	public void verify_Tasks_for_the_Business_Unit_in_AddTask_Button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String actualValue = demoInteraction.verifyBusinessUnitAddedToTask();
		assert actualValue.equals("Business Unit");

		// Verify Task list present under the Business Unit

		// Assert.assertTrue("Add Business Unit is not
		// present",pegaDriver.verifyElement(By.xpath("//*[@title=' Modify
		// Contact Links ']")));
		// Assert.assertTrue("Add Business Unit is not
		// present",pegaDriver.verifyElement(By.xpath("//*[@title=' Modify
		// Business Unit Links ']")));
		Assert.assertTrue("Add Business Unit is not present",
				pegaDriver.verifyElement(By.xpath("//*[@title='        Add new business unit   ']")));
		// Assert.assertTrue("Update Business Address link is not
		// present",pegaDriver.verifyElement(By.xpath("//*[@title=' Update
		// Business Unit Address ']")));
		Assert.assertTrue("Update Business Unit Comm Details link is not present",
				pegaDriver.verifyElement(By.xpath("//*[@title='        Update Business Unit Comm Details   ']")));
		Assert.assertTrue("Update Business Details link is not present",
				pegaDriver.verifyElement(By.xpath("//*[@title='        Modify Business Unit Links   ']")));
		demoInteraction.clickCloseButton();
	}

	@When("^CSR Wrap Up the call$")
	public void csr_Wrap_Up_the_call() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// demoInteraction.launchWrapup();
	}

	@Then("^Feedback window is displayed and selected the feedback$")
	public void feedback_window_is_displayed_and_selected_the_feedback() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String actualString = pegaDriver.findElement(By.id("DialogContent")).getText();
		System.out.println("The vlaue for the Actual Result is : : : : :" + actualString);
		String expectedResult = "Thank you for contacting U+Bank,  Ms. Connor.  Have a nice day.";
		assert (actualString.trim()).contains(expectedResult);
		// demoInteraction.completeWrapUp(expectedResult);
	}
}
