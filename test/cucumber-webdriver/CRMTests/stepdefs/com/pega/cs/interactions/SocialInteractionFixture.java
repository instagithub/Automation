package com.pega.cs.interactions;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.google.inject.Inject;
import com.pega.Configuration;
import com.pega.MyBrowser;
import com.pega.MyTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.cs.utils.CommonMethods;
import com.pega.cs.utils.FacebookAPIService;
import com.pega.cs.utils.TwitterAPIService;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;
import com.pega.tiles.TopNavFixture;
import com.pega.cs.interactions.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import twitter4j.TwitterException;

@ScenarioScoped

public class SocialInteractionFixture {

	private SocialInteraction socialInteraction;
	private Interactions interaction;
	private CommonMethods commonMethods;
	private PegaWebDriver pegaDriver;
	TestEnvironment testEnv;
	public String frameId = null;
	public Wizard newWizard = null;
	public String[] caseStatus = new String[10];
	private TwitterAPIService twitterAPIService;
	private FacebookAPIService facebookAPIService;
	private static String customertweetText;
	CommonMethods commonMethod = new CommonMethods(pegaDriver);
	public String csrReplyText;
	public String customerName = null;
	private Configuration configuration = null;
	TopNavFixture topNavFixture;

	
	@Inject
	public SocialInteractionFixture(TopNavFixture topNavFixture, MyTestEnvironment testEnv) {
		this.testEnv = testEnv;
		socialInteraction = topNavFixture.getSocialInteraction();
		interaction = topNavFixture.getInteractions();
		commonMethods = testEnv.getCommonMethods();
		pegaDriver = testEnv.getPegaDriver();
		configuration = testEnv.getConfiguration();
		twitterAPIService = new TwitterAPIService();
		facebookAPIService = new FacebookAPIService();
//		MyBrowser browser;
//		topNavFixture = new TopNavFixture();

		

	}

	
	public SocialInteractionFixture() {
		// TODO Auto-generated constructor stub
	}


	@When("^CSR responds to the case from IP$")
	public void csr_responds_to_the_case_from_IP(){

		csrReplyText =  socialInteraction.reply();
		System.out.println("CSR text::::::::::"+csrReplyText);

	    
	    
	}
	
	@Then("^verify status of the case$")
	public void verify_status_of_the_case() {
	    
	    pegaDriver.waitForDocStateReady(2);
	    pegaDriver.switchTo().defaultContent();
//	    pegaDriver.switchTo().frame(arg0)
		Assert.assertTrue("Case status is not updated", pegaDriver.verifyElement(By.xpath("//div[contains(text(),'AWAITING')]")));
		
	}
	
	
	public String getCSRReplyText() {

		System.out.println("csrReplyText :::: "+csrReplyText);
		return csrReplyText;
		
	}
	
	
	@When("^User \"([^\"]*)\" sends a DM$")
	public void user_sends_a_DM(String customerName) throws Throwable {
	 
		try 
		{
			this.customerName = customerName;
			String currentTime =  commonMethod.getCurrentTime();
			customertweetText = configuration.getCredential("CSSOCIAL_TWEETTEXT")+" "+currentTime;
			String corporateHandle = configuration.getCredential("CSSOCIAL_HANDLE");
			twitterAPIService.sendDM(customerName, corporateHandle, customertweetText);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public String getCustomerTweetText() {

		System.out.println("CustomerTweetText "+customertweetText);
		return customertweetText;
		
	}
	
	@When("^User \"([^\"]*)\" sends a response$")
	public void user_sends_a_response(String customerName) throws Throwable {
		

		String currentTime =  commonMethod.getCurrentTime();
		customertweetText = configuration.getCredential("CSSOCIAL_HANDLE")+" "+configuration.getCredential("CSSOCIAL_TWEETTEXT")+" "+currentTime;
		long inReplyToStatusId = twitterAPIService.findTweetByID(customerName, csrReplyText);		
		twitterAPIService.replyToTweet(customerName, inReplyToStatusId, customertweetText);
		
	}
	
	@Then("^CSR verifies social interaction header for \"([^\"]*)\" customer$")
	public void csr_verifies_social_interaction_header_for_customer(String customerType) {
	   
		if(customerType.equalsIgnoreCase("unknown"))
		{
			pegaDriver.switchTo().defaultContent();
			Assert.assertTrue("Customer name is not present",pegaDriver.verifyElement(By.xpath(SocialInteraction.CUSTOMERNAME_XPATH)));
			Assert.assertTrue("Unknown customer field is not present",pegaDriver.verifyElement(By.xpath(SocialInteraction.UNKNOWN_CUSTOMER_XPATH)));
			Assert.assertTrue("TW Handle field is not present",pegaDriver.verifyElement(By.xpath(SocialInteraction.TWHANDLE_VALUE_XPATH)));
			Assert.assertTrue("TW ID field is not present",pegaDriver.verifyElement(By.xpath(SocialInteraction.TWID_VALUE_XPATH)));
			Assert.assertTrue("Followers field is not present",pegaDriver.verifyElement(By.xpath(SocialInteraction.FOLLOWERS_VALUE_XPATH)));
			Assert.assertTrue("Following field is not present",pegaDriver.verifyElement(By.xpath(SocialInteraction.FOLLOWING_VALUE_XPATH)));
			
		}
		else if (customerType.equalsIgnoreCase("known"))
		{
		
			pegaDriver.switchTo().defaultContent();
			Assert.assertTrue("Customer Name is not present",pegaDriver.verifyElement(By.xpath("//div/span[contains(text(),'Brown')]")));
//			Assert.assertTrue("Unknown customer field is not present",pegaDriver.verifyElement(By.xpath(SocialInteraction.UNKNOWN_CUSTOMER_XPATH)));
			Assert.assertTrue("TW Handle field is not present",pegaDriver.verifyElement(By.xpath(SocialInteraction.TWHANDLE_VALUE_XPATH)));
			Assert.assertTrue("TW ID field is not present",pegaDriver.verifyElement(By.xpath(SocialInteraction.TWID_VALUE_XPATH)));
			Assert.assertTrue("Followers field is not present",pegaDriver.verifyElement(By.xpath(SocialInteraction.FOLLOWERS_VALUE_XPATH)));
			Assert.assertTrue("Following field is not present",pegaDriver.verifyElement(By.xpath(SocialInteraction.FOLLOWING_VALUE_XPATH)));
			
		}
		
	}

	@Then("^CSR verifies customer text$")
	public void csr_verifies_customer_text() {
	    
		pegaDriver.switchTo().defaultContent();
		Assert.assertTrue("Case ID is not present",pegaDriver.verifyElement(By.xpath(SocialInteraction.CASEID_XPATH)));
		Assert.assertTrue("Status is not correct",pegaDriver.verifyElement(By.xpath(SocialInteraction.CASE_STATUS_XPATH)));
		Assert.assertTrue("TW/FB icon is not present",pegaDriver.verifyElement(By.xpath("//i[contains(@name,'SocialCaseHeader_D_Interaction')][contains(@class,'twitter') or contains(@class, 'facebook')]")));
		System.out.println("Customer Text::::"+customertweetText);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		Assert.assertTrue("Customer response text is not present",pegaDriver.verifyElement(By.xpath("//span[@class='cssocial_std_text_bold'][contains(text(),'"+customertweetText+"')]")));
		
	}


	public void setCustomerTweetText(String customertweetText) {
		this.customertweetText = customertweetText;
		System.out.println("Customer Tweet Text"+customertweetText);
		
	}
	

	@Then("^CSR verifies \"([^\"]*)\" radio button$")
	public void csr_verifies_radio_button(String responseType)  {
	    
		String selectedRadioButton = pegaDriver.findElement(By.xpath("//div[contains(@class,'radioTable')]")).getAttribute("radvalue");
//		if(selectedRadioButton.equalsIgnoreCase(responseType))
//		Assert.assertTrue(responseType+" is not selected", false);
		Assert.assertTrue(responseType+" is not selected",selectedRadioButton.equalsIgnoreCase(responseType));
		
		
	}
	
	@Then("^CSR verifies private message icon$")
	public void csr_verifies_private_message_icon() {
	    
		Assert.assertTrue("Private icon is not present", pegaDriver.verifyElement(By.xpath("//span[contains(text(),'"+customertweetText+"')]/ancestor::div[contains(@class,'item-2')]/preceding-sibling::div[contains(@class,'item-1')]/descendant::i[contains(@title,'Private')]")));
		
		
		
	}


	@When("^CSR Reassigns to \"([^\"]*)\" and name is \"([^\"]*)\"$")
	public void csr_Reassigns_to_and_name_is(String reassignType, String reassignTo) {
	   
		System.out.println("Social Interaction::::::::::"+socialInteraction);
		socialInteraction.reassigncase(reassignType,reassignTo);
		
		
	}
	
	
	
	@When("^CSR Escalates a case to \"([^\"]*)\"$")
	public void csr_Escalates_a_case_to(String escalateTo) {
	   
		socialInteraction.escalatecase(escalateTo);
		
	}
	
	@When("^CSR wraps up social interaction as \"([^\"]*)\" with reason as \"([^\"]*)\"$")
	public void csr_wraps_up_social_interaction_as_with_reason_as(String status, String reason) {
	    
		socialInteraction.wrapUpInteraction(status, reason);
		
	} 
	
	@Then("^CSR checks the case in \"([^\"]*)\" tab of social cases overlay$")
	public void csr_checks_the_case_in_tab_of_social_cases_overlay(String status) {
	    
		socialInteraction.validateCaseWrappedUp(status);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		Assert.assertTrue("resolved/dismissed case is not available",pegaDriver.verifyElement(By.xpath("//div/span[contains(text(),'"+customertweetText+"')]")));
	}
	
	@Then("^CSR verifies if case is displayed$")
	public void csr_verifies_if_case_is_displayed() throws Throwable {
	    
		pegaDriver.switchToActiveFrame();
		Assert.assertFalse("No Assignments to work for CSR", pegaDriver.verifyElement(By.xpath("//div[contains(text(),'There are currently no assignments available for you to work on. Please try again later.')]")));
		
	}
	
	@When("^CSR changes Reply handle to respond$")
	public void csr_changes_Reply_handle_to_respond() {

		socialInteraction.selectReplyAs(configuration.getCredential("CSSOCIAL_REPLYAS_HANDLE"));
	}

	
	@When("^User \"([^\"]*)\" sends a DM to ReplyAs Handle$")
	public void user_sends_a_DM_to_ReplyAs_Handle(String customerName) {
	    
		try 
		{
			this.customerName = customerName;
			String currentTime =  commonMethod.getCurrentTime();
			customertweetText = configuration.getCredential("CSSOCIAL_TWEETTEXT")+" "+currentTime;
			String corporateHandle = configuration.getCredential("CSSOCIAL_REPLYAS_HANDLE");
			twitterAPIService.sendDM(customerName, corporateHandle, customertweetText);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
	}

	@When("^User \"([^\"]*)\" sends a response to ReplyAs Handle$")
	public void user_sends_a_response_to_ReplyAs_Handle(String customerName) throws TwitterException {
	    
		String currentTime =  commonMethod.getCurrentTime();
		customertweetText = configuration.getCredential("CSSOCIAL_REPLYAS_HANDLE")+" "+configuration.getCredential("CSSOCIAL_TWEETTEXT")+" "+currentTime;
		long inReplyToStatusId = twitterAPIService.findTweetByID(customerName, csrReplyText);		
		twitterAPIService.replyToTweet(customerName, inReplyToStatusId, customertweetText);
	}
	
	@When("^CSR retweets the tweet$")
	public void csr_retweets_the_tweet() {
		
		socialInteraction.retweet(customertweetText);
		
	}
	
	@Then("^CSR validates created note$")
	public void csr_validates_created_note() {

		Assert.assertTrue("posted text is not present",
				pegaDriver.verifyElement(By.xpath("//p[contains(text(),'Test Note for JohnBrown')]")));
	} 

	
	
	
}
