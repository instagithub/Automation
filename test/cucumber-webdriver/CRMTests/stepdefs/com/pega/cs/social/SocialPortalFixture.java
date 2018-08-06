/*package com.pega.cs.social;

import com.pega.MyTestEnvironment;
import com.pega.Configuration;
import com.pega.cs.SocialPortal;
import com.pega.cs.impl.SocialPortalImpl;
import com.pega.cs.utils.CommonMethods;
import com.pega.cs.utils.FacebookAPIService;
import com.pega.cs.utils.TwitterAPIService;
import com.pega.cs.utils.TwitterPortal;
import com.pega.framework.PegaWebDriver;
import com.pega.ri.Wizard;


import org.junit.Assert;
import org.openqa.selenium.By;

import com.google.inject.Inject;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import twitter4j.TwitterException;


@ScenarioScoped

public class SocialPortalFixture {

	private SocialPortal socialPortal;
	
	private PegaWebDriver pegaDriver;
	public String customerName = null;
	private Configuration configuration = null;
	public Wizard newWizard = null;
	public String frameId = null;
	private String caseStatusText = null;
	private String source = null;
	private TwitterAPIService twitterAPIService;
	private FacebookAPIService facebookAPIService;
	private String customertweetText;
	private String currentTime;
	CommonMethods commonMethod = new CommonMethods(pegaDriver);
	private String csrReplyText;
	
	@Inject
	public SocialPortalFixture(MyTestEnvironment testEnv) 
	{
		socialPortal = new SocialPortalImpl(testEnv);
		pegaDriver = testEnv.getPegaDriver();
		configuration = testEnv.getConfiguration();
		twitterAPIService = new TwitterAPIService();
		facebookAPIService = new FacebookAPIService();
				
				
	}


	@When("^CSR refreshes and get the case$")
	public void csr_refreshes_and_get_the_case() {
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().defaultContent();
		System.out.println("Refreshing WL");
		socialPortal.refreshWorklist();
	}



	@When("^CSR replies to the case$")
	public void csr_replies_to_the_case() {
		frameId  = pegaDriver.getActiveFrameId();
		newWizard = pegaDriver.findWizard(frameId);
		if(newWizard.verifyElement(By.xpath("//span[@class='cs_social_authorization_error_text']")))
		{
			String authText = newWizard.findElement(By.xpath("//span[@class='cs_social_authorization_error_text']")).getText();
			if(authText.contains("Facebook"))
				source="Facebook";
			else
				source = "Twitter";
			socialPortal.launchPreferences();
			socialPortal.authorizeCSR(source, configuration.getCredential("CSSOCIAL_USER_ID"), configuration.getCredential("CS_PASSWORD"));
			socialPortal.refreshPortal();
		}
		frameId  = pegaDriver.getActiveFrameId();
		newWizard = pegaDriver.findWizard(frameId);
		caseStatusText = socialPortal.reply();
	    
	}

	@Then("^verify case status$")
	public void verify_case_status() {

	    Assert.assertTrue("Case status is not changed to Awaiting Customer Response", caseStatusText.equalsIgnoreCase("Awaiting Customer Response") );
//	    Assert.assertTrue("Case status in WL is not changed.", pegaDriver.verifyElement(By.xpath("//div[contains(@node_name,'CSSocialMycasesReply')]/descendant::div[contains(@class,'cssocial_std_label_dataLabelRead')]")));
	    
	}


	
	@Then("^Close the case$")
	public void close_the_case()  {
		socialPortal.closeCase();
	}


	@Then("^CSR sends a DM$")
	public void csr_sends_a_DM()  {
		
		caseStatusText = socialPortal.reply();
	}
	
	
	@Then("^CSR responds with a PM$")
	public void csr_responds_with_a_PM()  {
	    
		caseStatusText = socialPortal.reply();
		
		Assert.assertTrue("Case status is not changed to Awaiting Customer Response", caseStatusText.equalsIgnoreCase("Awaiting Customer Response") );
//	    Assert.assertTrue("Case status in WL is not changed.", pegaDriver.verifyElement(By.xpath("//div[contains(@node_name,'CSSocialMycasesReply')]/descendant::div[contains(@class,'cssocial_std_label_dataLabelRead')]")));
	}
	
	@Then("^CSR changes Reply handle to respond$")
	public void csr_changes_Reply_handle_to_respond()  {
	    
		socialPortal.selectReplyAs(configuration.getCredential("CSSOCIAL_REPLYAS_HANDLE"));
	}
	
	
	
}
*/