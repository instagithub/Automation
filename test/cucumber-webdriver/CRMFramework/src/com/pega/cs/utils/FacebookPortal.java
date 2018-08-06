package com.pega.cs.utils;

import com.pega.Browser;

import com.pega.cs.SocialPortal;
import com.pega.cs.TestEnvironmentImpl;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;




public class FacebookPortal extends TestEnvironmentImpl
{
	PegaWebDriver pegaDriver = null;
	Browser browser = null;
	SocialPortal socialPortal = null;
	CommonMethods commonMethod = new CommonMethods(pegaDriver);
	
	
	String FB_USERNAME_XPATH = "//input[@id='email']";
	String FB_PASSWORD_XPATH = "//input[@id='pass']";
	String FB_LOGINBUTTON_XPATH = "//label[@id='loginbutton']";
	String PAGE_POST_XPATH = "//div[text()='Write something on this Page...']";
//	String STATUS_XPATH = "//a[contains(@class,'fbReactComposerAttachmentSelector_STATUS')]/span/span[text()='Status']";
	String STATUS_XPATH = "//span[text()='Status']";
	String POSTBUTTON_XPATH = "//button[contains(@data-testid,'react-composer-post-button')]";
	String REPLY_POST_XPATH = "//div[@title='Write a reply...']/descendant::div[@data-block='true']";
	String CUSTOMERNAME_XPATH="//div/a[contains(@class,'fbxWelcomeBoxName')][contains(@data-gt,'type_self_timeline')]";
	String NOTIFICATION_ICON_XPATH = "//a[@class='jewelButton'][@name='notifications']";
	String NOTIFICATION_COMMENT_XPATH = "(//div[@id='fbNotificationsFlyout']/div[@class='_33p']/descendant::div[@class='uiScrollableAreaContent']/descendant::a[contains(@href,'#FBPageID#')])[1]";
	String MESSAGEBUTTON_XPATH = "//div[@id='pages_actions_pagelet']/descendant::button[text()='Message']";
	String MESSAGE_POST_XPATH = "//div[@title='Type a message...']/descendant::div[@data-block='true']";
	
	
	public FacebookPortal()
	{
		

//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("profile.default_content_settings.popups", 0);
//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("prefs", prefs);
//		pegaDriver =  (PegaWebDriver) new ChromeDriver(options);
		
		
		pegaDriver = getPegaDriver();
		browser = getBrowser();
		browser.open("http://www.facebook.com");
		
	}

	

	public void loginToFacebook(String username, String pwd) 
	{
		pegaDriver.findElement(By.xpath(FB_USERNAME_XPATH)).sendKeys(username);
		pegaDriver.findElement(By.xpath(FB_PASSWORD_XPATH)).sendKeys(pwd);
		PegaWebElement loginButton = pegaDriver.findElement(By.xpath(FB_LOGINBUTTON_XPATH));
		loginButton.submit();
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchTo().defaultContent();
	
	}
	
	public String getFacebookCustomerName()
	{
		String customerName = pegaDriver.findElement(By.xpath(CUSTOMERNAME_XPATH)).getText();
		System.out.println(customerName);
		return customerName;
	}
	
	public void tearDown() 
	{
		terminate();
		
	}



	public void navigateToPage(String pageURL) 
	{
		pegaDriver.get(pageURL);
		
	}
	
	public String postConcernOnPage(String concernText)
	{
		
		
		System.out.println(pegaDriver.getCurrentUrl());
		pegaDriver.findElement(By.xpath(STATUS_XPATH)).click(false);

		concernText = concernText+" "+ commonMethod.getCurrentTime();
		Actions builder = getDriverActions();
		builder.sendKeys(pegaDriver.findElement(By.xpath(PAGE_POST_XPATH)).getWebElement(), concernText).build().perform();
		PegaWebElement postButton = pegaDriver.findElement(By.xpath(POSTBUTTON_XPATH));
		postButton.click(false);
		return concernText;
	}
	
	public void escapePopUp()
	{
		Actions action = getDriverActions();
		action.sendKeys(Keys.ENTER).build().perform();
		pegaDriver.getWindowHandle();
		System.out.println("Escape popup method exiting....");
	}
	
	public void launchNotification(String fbPageID)
	{
		pegaDriver.findElement(By.xpath(NOTIFICATION_ICON_XPATH)).click(false);
		String finalXpath =  new String(NOTIFICATION_COMMENT_XPATH).replace("#FBPageID#", fbPageID);
		
		pegaDriver.findElement(By.xpath(finalXpath)).click(false);
	}



	public String replyForPost(String concernText) 
	{
		
		concernText = concernText+" "+ commonMethod.getCurrentTime()+Keys.ENTER;
		Actions builder = getDriverActions();
		builder.sendKeys(pegaDriver.findElement(By.xpath(REPLY_POST_XPATH)).getWebElement(), concernText).build().perform();
		return concernText;
	}
	
	public String sendAPM(String pageURL, String dmText)
	{
		navigateToPage(pageURL);
		pegaDriver.findElement(By.xpath(MESSAGEBUTTON_XPATH)).click(false);
//		String currentTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		dmText = dmText+" "+ commonMethod.getCurrentTime() +Keys.ENTER;
		Actions builder = getDriverActions();
		builder.sendKeys(pegaDriver.findElement(By.xpath(MESSAGE_POST_XPATH)).getWebElement(), dmText).build().perform();	
		return dmText;
		
	}
	
	
}
