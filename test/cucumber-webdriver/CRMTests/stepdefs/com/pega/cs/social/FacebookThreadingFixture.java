package com.pega.cs.social;

import com.pega.MyTestEnvironment;
import com.pega.Configuration;
import com.pega.cs.SocialPortal;
import com.pega.cs.impl.SocialPortalImpl;
import com.pega.cs.utils.FacebookPortal;
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


@ScenarioScoped

public class FacebookThreadingFixture {

	private SocialPortal socialPortal;
	private FacebookPortal fbPortal;
	private PegaWebDriver pegaDriver;
	private String customerName = null;
	private Configuration configuration = null;
	private boolean status = false;
	public Wizard newWizard = null;
	public String frameId = null;
	private String caseStatusText = null;
	private String postText = null;
	
	@Inject
	public FacebookThreadingFixture(MyTestEnvironment testEnv) 
	{
		socialPortal = new SocialPortalImpl(testEnv);
		pegaDriver = testEnv.getPegaDriver();
		fbPortal = new FacebookPortal();
		configuration = testEnv.getConfiguration();
		
	}

	
	@When("^Login to Facebook using \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_to_Facebook_using_and(String username, String password)  {
	    
		 fbPortal.loginToFacebook(username,password);
		 customerName = fbPortal.getFacebookCustomerName();
	}
	
	
	@Then("^Navigate to the page$")
	public void navigate_to_the_page()  {
		
		fbPortal.navigateToPage(configuration.getCredential("CSSOCIAL_FB_PAGE"));
	}

	@When("^Post concern on FB page$")
	public void post_concern_on_FB_page()  {
	    
		postText = fbPortal.postConcernOnPage(configuration.getCredential("CSSOCIAL_POST_TEXT"));
	}

	@When("^customer verifies the reply and responds to the comment$")
	public void customer_verifies_the_reply_and_responds_to_the_comment()  {
	    
		 postText = fbPortal.replyForPost(configuration.getCredential("CSSOCIAL_POST_TEXT"));
	}

	@When("^customer verifies the reply and responds with a PM$")
	public void customer_verifies_the_reply_and_responds_with_a_PM()  {
	    
		postText = fbPortal.sendAPM(configuration.getCredential("CSSOCIAL_FB_PAGE"), configuration.getCredential("CSSOCIAL_POST_TEXT"));
	}


	
	
	@Then("^CSR launches the FB case$")
	public void csr_launches_the_FB_case()  {

		status = socialPortal.launchSocialCase( "fb", customerName, postText);
		if(!status)
			Assert.fail("FB case is not created. Please check the configurations.");
		
	}

	@Then("^verify customer FB update$")
	public void verify_customer_FB_update()  {
		status = socialPortal.launchSocialCase( "fb", customerName, postText);
		if(!status)
			Assert.fail("FB case is not created. Please check the configurations.");

	}
	

	@After("@FacebookThreading")
	@Then("^Close Facebook Portal$")
	public void close_Facebook_Portal() {
		if( fbPortal != null)
			fbPortal.terminate();

	}

	

}
