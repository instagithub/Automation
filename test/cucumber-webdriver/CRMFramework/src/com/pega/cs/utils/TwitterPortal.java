package com.pega.cs.utils;

import com.pega.Browser;
import com.pega.cs.SocialPortal;
import com.pega.cs.TestEnvironmentImpl;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


public class TwitterPortal extends TestEnvironmentImpl{
	PegaWebDriver pegaDriver = null;
	Browser browser = null;
	SocialPortal socialPortal = null;
	CommonMethods commonMethod = new CommonMethods(pegaDriver);
	String customerName = null;
	
	String TWITTER_MAIN_LOGINBUTTON_XPATH = "//a[contains(@class,'Button StreamsLogin js-login')]";
	String TWITTER_USERNAME_XPATH = "//div[@id='login-dialog']/descendant::input[@class='text-input email-input js-signin-email']";
	String TWITTER_PASSWORD_XPATH = "//div[@id='login-dialog']/descendant::input[@class='text-input']";
	String TWITTER_LOGINBUTTON_XPATH = "//div[@id='login-dialog']/descendant::input[@value= 'Log in']";
	String TWEETBOX_XPATH = "//div[contains(@class,'rich-editor')]/div";
	String TWEET_TEXTAREA_XPATH = "//div[@name='tweet'][contains(@id,'tweet-box-home-timeline')]";
	String TWEETBUTTON_XPATH = "//div[@name='tweet'][contains(@id,'tweet-box')]/div/ancestor::div[@class='tweet-content']/following-sibling::div[@class='TweetBoxToolbar']/descendant::button[contains(@class,'js-tweet-btn')]/span[contains(@class,'tweeting-text')]";
	String TWEET_VIEWCONV_XPATH = "//div[contains(@class,'rich-editor')]/div/a";
	String CUSTOMERNAME_XPATH = "//a[@class='u-textInheritColor']";
	String NOTIFICATIONS_XPATH = "//span[text()='Notifications']";
	String VIEWCONVERSATION_XPATH = "(//span[text()='View conversation'])[1]";
	String DM_XPATH= "//span[text()='Messages']";
	String DM_NEWMESSAGE_XPATH = "//div[@id='dm_dialog']/descendant::button[@class='DMInbox-toolbar DMComposeButton btn primary-btn dm-new-button js-initial-focus small']/span[text()='New Message']";
	String DM_HANDLE_XPATH = "(//textarea[contains(@class,'TokenizedMultiselect-input')])[1]";
	String DM_INITIATE_XPATH = "//button[contains(@class, 'dm-initiate-conversation')]";
	String DM_TWEETBOX_XPATH = "//div[contains(@id, 'tweet-box-dm-conversation')]";
	String DM_SEND_XPATH = "//span[text()='Send']";
	
	
	
	public TwitterPortal()
	{
		pegaDriver = getPegaDriver();
		browser = getBrowser();
		browser.open("http://twitter.com");
	
	}
	
	public void loginToTwitter(String username, String password){
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(TWITTER_MAIN_LOGINBUTTON_XPATH)).click(false);
		pegaDriver.findElement(By.xpath(TWITTER_USERNAME_XPATH)).sendKeys(username);
		pegaDriver.findElement(By.xpath(TWITTER_PASSWORD_XPATH)).sendKeys(password);
		PegaWebElement loginButton = pegaDriver.findElement(By.xpath(TWITTER_LOGINBUTTON_XPATH));
		loginButton.submit();
		customerName = pegaDriver.findElement(By.xpath(CUSTOMERNAME_XPATH)).getText();
	}
	
	public String getTwitterCustomerName()
	{
		return customerName;
	}

	public String tweetAPost(String tweetText) 
	{
		
		PegaWebElement tweetTextBox = pegaDriver.findElement(By.xpath(TWEETBOX_XPATH));
		tweetTextBox.click(false);

		tweetText = tweetText+" "+ commonMethod.getCurrentTime();
		pegaDriver.findElement(By.xpath(TWEET_TEXTAREA_XPATH)).sendKeys(tweetText);
		pegaDriver.findElement(By.xpath(TWEETBUTTON_XPATH)).click(false);
		 return tweetText;
	}
	
	
	public String replyForPost(String tweetText)
	{
		PegaWebElement notifications = pegaDriver.findElement(By.xpath(NOTIFICATIONS_XPATH));
		notifications.click(false);
		PegaWebElement viewConv = pegaDriver.findElement(By.xpath(VIEWCONVERSATION_XPATH));
		viewConv.click(false);
		

		tweetText = tweetText+" "+ commonMethod.getCurrentTime();
		Actions builder = getDriverActions();
		builder.sendKeys(pegaDriver.findElement(By.xpath(TWEET_VIEWCONV_XPATH)).getWebElement(), tweetText).build().perform();
		PegaWebElement tweetButton = pegaDriver.findElement(By.xpath(TWEETBUTTON_XPATH));
		tweetButton.click(false);
		return tweetText;

		
	}

	public void tearDown() 
	{

		terminate();

		
	}

	

	public void sendADM(String handle, String dmText) 
	{
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		PegaWebElement messagesButton = pegaDriver.findElement(By.xpath(DM_XPATH));
		messagesButton.click(false);
		
		PegaWebElement newMessageButton = pegaDriver.findElement(By.xpath(DM_NEWMESSAGE_XPATH));
		newMessageButton.click(false);

		PegaWebElement dmHandle = pegaDriver.findElement(By.xpath(DM_HANDLE_XPATH));
		dmHandle.click(false);
		dmHandle.sendKeys(handle);

		pegaDriver.findElement(By.xpath(DM_INITIATE_XPATH)).click(false);

		

		dmText = dmText+" "+ commonMethod.getCurrentTime();
		
		
		PegaWebElement dmTweetBox = pegaDriver.findElement(By.xpath(DM_TWEETBOX_XPATH));
		dmTweetBox.sendKeys(dmText);
		
		PegaWebElement dmSendButton = pegaDriver.findElement(By.xpath(DM_SEND_XPATH));
		dmSendButton.click(false);
	}



	
	
	
	

}
