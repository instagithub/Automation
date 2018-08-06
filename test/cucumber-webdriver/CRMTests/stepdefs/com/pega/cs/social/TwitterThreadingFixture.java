package com.pega.cs.social;

import com.pega.MyTestEnvironment;
import com.pega.Configuration;
import com.pega.cs.SocialPortal;
import com.pega.cs.impl.SocialPortalImpl;
import com.pega.cs.interactions.SocialInteraction;
import com.pega.cs.interactions.SocialInteractionFixture;
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
import facebook4j.FacebookException;
import facebook4j.internal.org.json.JSONException;
import twitter4j.TwitterException;


@ScenarioScoped

public class TwitterThreadingFixture {

	private SocialPortal socialPortal;
	private TwitterPortal twitterPortal;
	private PegaWebDriver pegaDriver;
	public String customerName = null;
	private Configuration configuration = null;
	private boolean status = false;
	public Wizard newWizard = null;
	public String frameId = null;
	CommonMethods commonMethod = new CommonMethods(pegaDriver);
	private String caseStatusText = null;
	private String tweetText = null;
	private String customertweetText;
	private TwitterAPIService twitterAPIService;
	private FacebookAPIService fbAPIService;
	SocialInteractionFixture socialInteractionFixture = new SocialInteractionFixture();
	
	@Inject
	public TwitterThreadingFixture(MyTestEnvironment testEnv) 
	{
		
		twitterAPIService = new TwitterAPIService();
		fbAPIService = new FacebookAPIService();
		configuration = testEnv.getConfiguration();
		
		
		
	}
	

	
	@When("^User \"([^\"]*)\" sends a tweet$")
	public void user_sends_a_tweet(String customerName){
	  
		try 
		{
			this.customerName = customerName;
			String currentTime =  commonMethod.getCurrentTime();
			customertweetText = configuration.getCredential("CSSOCIAL_HANDLE")+" "+configuration.getCredential("CSSOCIAL_TWEETTEXT")+" "+currentTime;
			twitterAPIService.sendTweet(customerName, customertweetText);
			socialInteractionFixture.setCustomerTweetText(customertweetText);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	
	
	@When("^User \"([^\"]*)\" sends a TW DM$")
	public void user_sends_a_TW_DM(String customerName)  {
		try 
		{
			this.customerName = customerName;
			String currentTime =  commonMethod.getCurrentTime();
			customertweetText = configuration.getCredential("CSSOCIAL_HANDLE")+" "+configuration.getCredential("CSSOCIAL_TWEETTEXT")+" "+currentTime;
			String corporateHandle = configuration.getCredential("CSSOCIAL_HANDLE");
			twitterAPIService.sendDM(customerName, corporateHandle, customertweetText);
			socialInteractionFixture.setCustomerTweetText(customertweetText);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	@When("^User \"([^\"]*)\" sends a post$")
	public void user_sends_a_post(String customerName) {
	    
		try 
		{
			String fbpostID = fbAPIService.postMessageOnPage(customerName, configuration.getCredential("CSSOCIAL_FB_PAGEID"), configuration.getCredential("CSSOCIAL_HANDLE")+" "+configuration.getCredential("CSSOCIAL_TWEETTEXT")+" "+ commonMethod.getCurrentTime());
//			socialInteractionFixture.setFBPostID(fbpostID);
			
		} catch (FacebookException | JSONException e) {
			e.printStackTrace();
		}
		
	}
	
	


}
