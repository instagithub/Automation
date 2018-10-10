package com.pega.crm.customerservice.stepdefs;

import java.awt.AWTException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.google.inject.Inject;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.CSPortal;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.NewInboundInteraction;
import com.pega.crm.customerservice.interactions.PhoneCall;
import com.pega.crm.customerservice.utils.CommonMethods;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;
import com.pega.util.FileUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;


@ScenarioScoped

public class InboundInteraction {

	private PhoneCall phoneInteraction;
	private NewInboundInteraction inboundInteraction;
	private Interactions interaction;
	private CommonMethods commonMethods;
	private PegaWebDriver pegaDriver;
	TestEnvironment testEnv;
	private CSPortal csPortal;
	public String frameId = null;
	public Wizard newWizard = null;
	public List<String> caseId = new ArrayList();
	public String id;
	
	//String filePath= "C:\\AutoItScript\\sample.exe";
	String path = System.getProperty("user.dir");
	String filePath = path+"\\Data\\sample.exe";

	@Inject
	public InboundInteraction(TopNavglue topNavFixture, CRMTestEnvironment testEnv) {
		inboundInteraction =topNavFixture.getInboundInteraction();
		phoneInteraction = topNavFixture.getPhoneCall();
		commonMethods = testEnv.getCommonMethods();
		pegaDriver = testEnv.getPegaDriver();
		interaction = topNavFixture.getInteractions();
	}
	
	@Then("^verify the inbound case fields and FA header$")
	public void verify_the_inbound_case_fields_and_FA_header() {
		pegaDriver.switchTo().defaultContent();
		Assert.assertTrue("Inbound Case frame header is not present",
				pegaDriver.verifyElement(By.xpath("//a[@title='New inbound correspondence']")));
		
		pegaDriver.switchToActiveFrame();
		/*Assert.assertTrue("Inbound In progress field is not present",
				pegaDriver.verifyElement(By.xpath("//a[@title='In-progress task Create Inbound Correspondence']")));*/
		Assert.assertTrue("Search for customer flow action header is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Create Inbound Correspondence']")));
		Assert.assertTrue("Tools Menu button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@title='Tools Menu' or @title='Tools menu']")));
		/*Assert.assertTrue("Tools Menu button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@title='Help']")));*/
		Assert.assertTrue("Other Actions buttons is not present",
				pegaDriver.verifyElement(By.xpath("//button[@title='Other Actions' or @title='Other actions']")));

	}
	
	@Then("^verify the options for Inbound case$")
	public void verify_the_options_for_Inbound_case() {
		Assert.assertTrue("Refresh menu option is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Refresh']")));
	}

	@When("^create a inbound case with channel as \"([^\"]*)\" account \"([^\"]*)\" and contact \"([^\"]*)\"$")
	public void create_a_inbound_case_with_channel_as_account_and_contact(String channelType, String accNum, String contactId) throws AWTException {
			   
	   id = inboundInteraction.createInboundCase(channelType, accNum, contactId);
	}
	
	@When("^create a inbound case without entering the channel mandatory field$")
	public void create_a_inbound_case_without_entering_the_channel_mandatory_field() throws Throwable {
		inboundInteraction.createInboundCaseWithoutmandatoryFields();
	}
	

	
	@When("^Create a inbound with Future date and channel \"([^\"]*)\"$")
	public void create_a_inbound_with_Future_date_and_channel(String channelType) throws Throwable {
	 inboundInteraction.inboundCaseWithFutureDate(channelType);   
	}
		

	@Then("^Verify Menu Options after clicking on tools menu buttons for Inbound$")
	public void verify_Menu_Options_after_clicking_on_tools_menu_buttons_for_Inbound() {
		Assert.assertTrue("Refresh menu option is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Refresh']")));
	}

	@Then("^User launches inbound case from \"([^\"]*)\" workbasket$")
	public void user_launches_inbound_case_from_workbasket(String workBasket) throws Throwable {
	    interaction.launchCaseFromInboundWorkbasket(workBasket, id.trim());
	}

	@When("^search again for customer details$")
	public void search_again_for_customer_details()  {
	    inboundInteraction.searchAgain();
	}
	
	@When("^Click on \"([^\"]*)\" from attach a file button$")
	public void click_on_from_attach_a_file_button(String linkText) throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		
		pegaDriver.findElement(By.xpath("//button[contains(text(),'Attach a file')]")).click();
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement(By.xpath("//span[text()='"+linkText+"']")).click();
		
	    
	}

	@Then("^Verify the options displayed for URL page$")
	public void verify_the_options_displayed_for_URL_page() throws Throwable {
		
		
		pegaDriver.switchToActiveFrame();
		Assert.assertTrue("Attach a link field is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Attach a link')]")));
		Assert.assertTrue("close button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@id='container_close']")));
		
		
		Assert.assertTrue("Subject field is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Subject')]")));
		Assert.assertTrue("URL field is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'URL')]")));
		Assert.assertTrue("Attachment Category field is not present",
				pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Attachment Category')]")));
		
		Assert.assertTrue("Cancel button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@id='ModalButtonCancel']")));
		Assert.assertTrue("Submit button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@id='ModalButtonSubmit']")));
	}

	@When("^Select the URL and other fields and click submit$")
	public void select_the_URL_and_other_fields_and_click_submit() throws Throwable {
		inboundInteraction.attachURL();
		    
	}
	
	
	@Then("^Verify the email fields$")
	public void verify_the_email_fields() throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		
		Assert.assertTrue("Email header is not present",
				pegaDriver.verifyElement(By.xpath("//div[contains(text(),'Email')]")));
		Assert.assertTrue("Subject text is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Subject')]")));
		Assert.assertTrue("Message text is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Message')]")));
		Assert.assertTrue("Reply text is not present",
				pegaDriver.verifyElement(By.xpath("//button[contains(text(),'Reply')]")));
		Assert.assertTrue("attachment icon is not present",
				pegaDriver.verifyElement(By.xpath("//img[@title='Add or open attachments']")));
		
	}

	@When("^click on attachment icon in the email field$")
	public void click_on_attachment_icon_in_the_email_field() throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		PegaWebElement attachment = pegaDriver.findElement(By.xpath("//img[@title='Add or open attachments']"));
		attachment.click();
	   
	}

	@Then("^Verify the attachment is displayed$")
	public void verify_the_attachment_is_displayed() throws Throwable {
		
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		
		Assert.assertTrue("Correspondence Case Attachment header is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Correspondence Case Attachment')]")));
		Assert.assertTrue("Pega link text is not present",
				pegaDriver.verifyElement(By.xpath("//a[@title='Pega Link']")));
		Assert.assertTrue("Delete icon is not present",
				pegaDriver.verifyElement(By.xpath("//a[@class='iconDelete']")));
		
		pegaDriver.findElement(By.xpath("//button[@id='ModalButtonSubmit']")).click();
		
	}
	
	
	@Then("^Verify the options displayed for Attach file from device page$")
	public void verify_the_options_displayed_for_Attach_file_from_device_page() throws Throwable {
		
		pegaDriver.switchToActiveFrame();
		Assert.assertTrue("Attach files field is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Attach file')]")));
		Assert.assertTrue("Attach files field is not present",
				pegaDriver.verifyElement(By.xpath("//input[@id='$PpyAttachmentPage$ppxAttachName']")));
		
		Assert.assertTrue("Cancel button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@id='ModalButtonCancel']")));
		Assert.assertTrue("Submit button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@id='ModalButtonSubmit']")));
		
		
		
	}

	@When("^Attach a file from the local machine and click submit$")
	public void attach_a_file_from_the_local_machine_and_click_submit() throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath("//input[@id='$PpyAttachmentPage$ppxAttachName']")).click();
		System.out.println(filePath+"***filePath");		
		File file = new File("C:/AutoItScript");
		file.mkdir();
		file.createNewFile();
		File theDir = new File("C:/AutoItScript");
		if (!theDir.exists()) {
		        theDir.mkdir();
		}
		String source=path+"/Data/Samplefile.docx";
		String dest="C:/AutoItScript/Samplefile.docx";
		FileUtil.copyFile(source, dest);
		Runtime.getRuntime().exec(filePath);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath("//button[@id='ModalButtonSubmit']")).click();
	}
	
	
	@Then("^Verify the file attached from local machine is displayed$")
	public void verify_the_file_attached_from_local_machine_is_displayed() throws Throwable {
		
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		
		Assert.assertTrue("Correspondence Case Attachment header is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Correspondence Case Attachment')]")));
		Assert.assertTrue("Pega link text is not present",
				pegaDriver.verifyElement(By.xpath("//a[contains(text(),'Attach new')]")));
		Assert.assertTrue("Attached file name is not present",
				pegaDriver.verifyElement(By.xpath("//a[contains(text(),'Samplefile')]")));
		Assert.assertTrue("Delete icon is not present",
				pegaDriver.verifyElement(By.xpath("//a[@class='iconDelete']")));
		
		pegaDriver.findElement(By.xpath("//button[@id='ModalButtonSubmit']")).click();
	    
	}

	
	@Then("^Veriy the Skip Account Selection is displayed$")
	public void veriy_the_Skip_Account_Selection_is_displayed() throws Throwable {
		pegaDriver.switchToActiveFrame();
		Assert.assertTrue("Skip account selection field is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Skip account selection')]")));
		Assert.assertTrue("Tools Menu button is not present",
				pegaDriver.verifyElement(By.xpath("//button[@title='Tools menu']")));
		Assert.assertTrue("Other Actions buttons is not present",
				pegaDriver.verifyElement(By.xpath("//button[@title='Other actions']")));
	}

	@When("^Conform the Skip account selection$")
	public void conform_the_Skip_account_selection() throws Throwable {
		inboundInteraction.searchAgain();
	    
	}
	
	@When("^Click submit without selecting the user$")
	public void click_submit_without_selecting_the_user() throws Throwable {
	    inboundInteraction.searchAgain();
	}
	
	@When("^Click on \"([^\"]*)\" button in the Email field$")
	public void click_on_button_in_the_Email_field(String arg1) throws Throwable {
	    pegaDriver.switchTo().defaultContent();
	    PegaWebElement replyButton = pegaDriver.findElement(By.xpath("//button[@class='Community_buttons pzhc pzbutton' and contains(text(),'Reply')]"));
	    replyButton.click();
	}

	@When("^click on \"([^\"]*)\" in send correspondence page$")
	public void click_on_in_send_correspondence_page(String Recipients) throws Throwable {
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchToActiveFrame();
		
		PegaWebElement emailrecp = pegaDriver.findElement(By.xpath("//a[@title='"+Recipients+"']"));
		emailrecp.click();
	    
	}

	@Then("^verify the mail ids and option displayed in send correspondence$")
	public void verify_the_mail_ids_and_option_displayed_in_send_correspondence() throws Throwable {
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchToActiveFrame();
		
		Assert.assertTrue("Choose Contacts title is not present",
				pegaDriver.verifyElement(By.xpath("//div[contains(text(),'Choose Contacts')]")));
		Assert.assertTrue("View lable is not present",
				pegaDriver.verifyElement(By.xpath("//label[@for='CorrWorkParty' and contains(text(),'View')]")));
						
	}

	@When("^Select a mail id from the list of mails displayed$")
	public void select_a_mail_id_from_the_list_of_mails_displayed() throws Throwable {
	   PegaWebElement selectid = pegaDriver.findElement(By.id("pySelected1_rdi_1"));
	   selectid.click();
	}

	

}
