package com.pega.crm.customerservice.stepdefs;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.google.inject.Inject;
import com.pega.CRMObjectsBean;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.CSPortal;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.OutboundPhoneCall;
import com.pega.crm.customerservice.interactions.PhoneCall;
import com.pega.crm.customerservice.tiles.impl.PegaTopNav;
import com.pega.crm.customerservice.utils.CommonMethods;
import com.pega.framework.PegaWebDriver;
import com.pega.ri.Wizard;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;


@ScenarioScoped

public class OutboundCall {

	private PhoneCall phoneInteraction;
	private OutboundPhoneCall outboundPhoneCall;
	private Interactions interaction;
	private CommonMethods commonMethods;
	private PegaWebDriver pegaDriver;
	TestEnvironment testEnv;
	private CSPortal csPortal;
	public String frameId = null;
	public Wizard newWizard = null;
	public List<String> caseId = new ArrayList();
	public String caseID = null;
	private PegaTopNav topNav;
	public String intID = null;
	
	

	@Inject
	public OutboundCall(NewTopNav topNavFixture, CRMTestEnvironment testEnv) {
		outboundPhoneCall = topNavFixture.getOutboundPhoneCall();
		interaction = topNavFixture.getInteractions();
		commonMethods = testEnv.getCommonMethods();
		pegaDriver = testEnv.getPegaDriver();
	}
	
	@Then("^Verify fields on search screen$")
	public void verify_fields_on_search_screen() {
	
		Assert.assertTrue("Unknown customer field is not present",interaction.verifyElement(By.xpath(PhoneCall.UNKNOWN_CUSTOMER_XPATH)));
		Assert.assertTrue("Contact information field is not present",interaction.verifyElement(By.xpath(PhoneCall.CONTACT_INFO_XPATH)));
		
		Assert.assertTrue("Relationship field is not present",interaction.verifyElement(By.xpath(PhoneCall.RELATIONSHIP_XPATH)));
		
		
		Assert.assertTrue("Add task button is not present",interaction.verifyElement(By.xpath(PhoneCall.ADDTASK_XPATH)));
		Assert.assertTrue("Wrap Up button is not present",interaction.verifyElement(By.xpath(PhoneCall.WRAP_UP_XPATH)));
		
		Assert.assertTrue("Search text is not present",interaction.verifyElement(By.xpath(PhoneCall.SEARCH_XPATH)));
		Assert.assertTrue("General assistance text is not present",interaction.verifyElement(By.xpath(PhoneCall.GENERAL_ASSISTANCE_XPATH)));
		
		
	}

	@Then("^Search for customer with lastname \"([^\"]*)\" and accNo \"([^\"]*)\"$")
	public void search_for_customer_with_lastname_and_accNo(String lastName, String accountNum) {
	    
		interaction.searchByCustomerNameAndAccountNo(lastName, accountNum);
	}
	
	
	@Then("^Select reason \"([^\"]*)\" and Outbound call status \"([^\"]*)\" and Submit$")
	public void select_reason_and_Outbound_call_status_and_Submit(String reason, String status) {
		
		interaction.CaptureCallReasonAndPlaceCall(reason, status);
	  
	  
	}

	@Then("^Enter comments for Exit Interaction \"([^\"]*)\" and Submit$")
	public void enter_comments_for_Exit_Interaction_and_Submit(String exitComments) {
	  
		outboundPhoneCall.exitInteraction(exitComments);
	  
	}

	@When("^launch wrapup to complete outbound interaction$")
	public void launch_wrapup_to_complete_outbound_interaction() {
		
		outboundPhoneCall.launchOutboundWrapUp();
	   
	}

	@Then("^select transaction \"([^\"]*)\" for dispute$")
	public void select_transaction_for_dispute(String transID) {
	    interaction.selectDisputeTransaction(transID);
	}

	@When("^Select dispute reason \"([^\"]*)\" and submit$")
	public void select_dispute_reason_and_submit(String reason)  {
	    
		interaction.selectReasonForDispute(reason);
	}
	
	
	@Then("^select a category \"([^\"]*)\" with product \"([^\"]*)\" and owner \"([^\"]*)\"$")
	public void select_a_category_with_product_and_owner(String category, String product, String owner) {
	   
		//outboundPhoneCall.selectAProduct(category, product, owner);
		interaction.selectAProduct(category, product, owner);
		
	}

	@When("^submit account details$")
	public void submit_account_details() {
	   
		interaction.enterAccountDetails();
		
	}
	
	@When("^User launches outbound call from \"([^\"]*)\" workbasket$")
	public void user_launches_outbound_call_from_workbasket(String workbasket) {

		interaction.launchCaseFromWorkbasket(workbasket,CRMObjectsBean.getTimestampedValue("CaseID"));
		
	}
	
	@Then("^User verifies checkpoints in the interaction launched$")
	public void user_verifies_checkpoints_in_the_interaction_launched() {
		Assert.assertTrue("Outbound call ID is not present", interaction.verifyElement(By.xpath("//span[contains(text(),'"+CRMObjectsBean.getTimestampedValue("CaseID")+"')]")));
		Assert.assertTrue("Status is not present", interaction.verifyElement(By.xpath("//span[contains(text(),'New')]")));
		interaction.findElement(By.xpath("//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/descendant::tr[2]")).click();
	
		Assert.assertTrue("Customer name is not present", interaction.verifyElement(By.xpath("//span[contains(@class,'work_identifier')][contains(text(),'Sara Connor')]")));
		Assert.assertTrue("Call reason is not present", interaction.verifyElement(By.xpath("//span[contains(text(),'Initiate')]")));
		Assert.assertTrue("Dialog is not present", interaction.verifyElement(By.xpath("//span[contains(text(),'Hello, my name is CS CSR.')][contains(text(),'calling on behalf of pega.com about Address Change')]")));
		
	}

	@Then("^User Launches interaction for \"([^\"]*)\" with Call status \"([^\"]*)\"$")
	public void user_Launches_interaction_for_with_Call_status(String contactName, String callStatus) {
	   
		outboundPhoneCall.launchOutboundInteractionforFirst(contactName, callStatus);
	    
	}
	

	
	@Then("^Submit the changes$")
	public void submit_the_changes() {
	    outboundPhoneCall.submitChanges();
	}
	
	
		

	@Then("^verify the error message displayed for the reason  box$")
	public void verify_the_error_message_displayed_for_the_reason_box() throws Throwable {
		Assert.assertTrue("Select a reason for outbound call is not present", interaction.verifyElement(By.xpath("//label[contains(text(),'Select a reason for outbound call')]")));
		Assert.assertTrue("Outbound call status is not present", interaction.verifyElement(By.xpath("//label[contains(text(),'Outbound call status')]")));
		
	}


	


}
