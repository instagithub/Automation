package com.pega.cs.impl;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.Configuration;
import com.pega.TestEnvironment;
import com.pega.cs.SocialPortal;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.page.PortalImpl;
import com.pega.ri.Wizard;
//import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;
import com.pega.cs.utils.*;

public class SocialPortalImpl extends PortalImpl implements SocialPortal {

	public String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	public String VERSION = "$Id: CSPortalImpl.java 117333 2015-06-18 09:12:21Z MuraliKondapally $";

	private PegaWebDriver pegaDriver = null;
	public Wizard newWizard = null;
	public String finalXPath = null;
	public String frameId = null;
	CommonMethods commonMethod = new CommonMethods(pegaDriver);
	
	public SocialPortalImpl(TestEnvironment testEnv) {
		super(testEnv);
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver();
		
	}

	@Override
	public void refreshWorklist() {

		
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().defaultContent();

		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().defaultContent();

		pegaDriver.findElement(By.xpath(WL_Refresh_XPATH)).click(false);

		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().defaultContent();

	}
	
	@Override
	public void launchCase() 
	{

		System.out.println(finalXPath);
		pegaDriver.findElement(By.xpath(finalXPath)).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().defaultContent();
		verifyResponseText();
		
	}

	

	@SuppressWarnings("deprecation")
	@Override
	public String reply() {

		frameId = pegaDriver.getActiveFrameId();
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement responseArea = newWizard.findElement(By.xpath(RESPONSE_AREA));
		responseArea.click();
		responseArea.sendKeys(" This is a test reply from CSR " + commonMethod.getCurrentTime());
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().defaultContent();
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement replyButton = newWizard.findElement(By.xpath(TWEET_REPLY));
		replyButton.click();
		PegaWebElement caseStatusElement = newWizard.findElement(By.xpath(CASE_STATUS));
		String caseStatusText = caseStatusElement.getText();
		System.out.println(caseStatusText);
		PegaWebElement closeButton = newWizard.findElement(By.xpath(CLOSE_CASE));
		closeButton.click(false);
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchTo().defaultContent();
		return caseStatusText;

	}

	@SuppressWarnings("deprecation")
	public void closeCase() 
	{
		frameId = pegaDriver.getActiveFrameId();
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement closeButton = newWizard.findElement(By.xpath(CLOSE_CASE));
		closeButton.click(false);
	}

	public void logout() 
	{
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().defaultContent();
		int windowsCount = pegaDriver.getWindowHandles().size();
		System.out.println(windowsCount);
		while(windowsCount>1)
		{
			testEnv.getBrowser().switchToWindow(windowsCount);
			testEnv.getBrowser().close();
			windowsCount--;
			System.out.println(windowsCount);
		}
		testEnv.getBrowser().switchToWindow(windowsCount);
		PegaWebElement operatorID = pegaDriver.findElement(By.xpath(OPERATORID_XPATH));
		operatorID.click();
		PegaWebElement logoffOperator = pegaDriver.findElement(By.xpath(LOGOUT));
		logoffOperator.click(false);

	}

	public void launchPreferences()
	{
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().defaultContent();
		PegaWebElement operatorID = pegaDriver.findElement(By.xpath(OPERATORID_XPATH));
		operatorID.click(false);
		PegaWebElement preferences = pegaDriver.findElement(By.xpath(PREFERENCES_XPATH));
		preferences.click(false);
		testEnv.getBrowser().switchToWindow(2);
		
	}

	@Override
	public void refreshPortal() 
	{
		String URL = pegaDriver.getCurrentUrl();
		pegaDriver.get(URL);
		
	}

	public void authorizeCSR(String source, String userID, String pwd )
	{
		
		String finalXpath = new String(launchOAuth).replace("#source#", source);
		pegaDriver.findElement(By.xpath(finalXpath)).click(false);
		
		pegaDriver.switchTo().frame(PREF_IFRAME_NAME);
		
		String finalAuthXpath = new String(AUTHTEXT_XPATH).replace("#source#", source);
		String authText = pegaDriver.findElement(By.xpath(finalAuthXpath)).getText();
		
		if(authText.equalsIgnoreCase("You are not authorized")||authText.equalsIgnoreCase("Please authorize yourself")) 
		{
			if(source == "Twitter")
				pegaDriver.findElement(By.id(OAUTH_ID)).sendKeys("TwitterOAuthClient");
			pegaDriver.findElement(By.xpath(AUTHORIZE_BUTTON_XPATH)).click(false);
			testEnv.getBrowser().switchToWindow(3);
			if(source.equalsIgnoreCase("Twitter"))
			{
				pegaDriver.findElement(By.id(AUTHORIZE_TW_USER_ID)).sendKeys(userID);
				pegaDriver.findElement(By.id(AUTHORIZE_TW_PWD_ID)).sendKeys(pwd);
				pegaDriver.findElement(By.id(AUTHORIZE_APP_ID)).click(false);
			}
			else
			{
				pegaDriver.findElement(By.xpath(AUTHORIZE_FB_USER_ID)).sendKeys(userID);
				pegaDriver.findElement(By.xpath(AUTHORIZE_FB_PWD_ID)).sendKeys(pwd);
				pegaDriver.findElement(By.xpath(AUTHORIZE_LOGIN_ID)).click(false);
			}
			
			testEnv.getBrowser().switchToWindow(2);
			pegaDriver.switchTo().frame(PREF_IFRAME_NAME);
			pegaDriver.findElement(By.xpath(SAVE_BUTTON_XPATH)).click(false);
			pegaDriver.verifyElement(By.xpath("//div[contains(text(),'You are authorized')]"));
			testEnv.getBrowser().close();
			testEnv.getBrowser().switchToWindow(1);
		}
		
		
	}

	@Override
	public void verifyResponseText() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean launchSocialCase(String source, String customerName, String text) 
	{
		
		
		finalXPath = null;
		for(int count=0; count < 10; count++)
		{
			refreshWorklist();
			PegaWebElement openCasesTable = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'D_GetOpenSocialCasesFromWorklist.pxResults')]"));
			int openCasesCount = openCasesTable.findElements(By.tagName("tr")).size();
			System.out.println(openCasesCount);
			for(int i=1; i <= openCasesCount; i++)
			{
				//verify the source of the case
				if(pegaDriver.verifyElement(By.xpath("//tr[contains(@id,'$PD_GetOpenSocialCasesFromWorklist$ppxResults$l"+i+"')]/descendant::div[contains(@class,'cssocial_mycaseshighlight')]/descendant::img[contains(@src,'"+source+"')]")))
				{
//					String media = pegaDriver.findElement(By.xpath("//tr[contains(@id,'$PD_GetOpenSocialCasesFromWorklist$ppxResults$l"+i+"')]/descendant::div[contains(@class,'cssocial_mycaseshighlight')]/descendant::img[contains(@src,'"+source+"')]")).getText();
//					System.out.println(media);
//					if(media.equalsIgnoreCase(source))
//					{
//					System.out.println(customerName);
						// verify the customer name
						if(pegaDriver.verifyElement(By.xpath("//tr[@id='$PD_GetOpenSocialCasesFromWorklist$ppxResults$l"+i+"']/descendant::div[contains(@class,'cssocial_mycaseshighlight')]/descendant::a[contains(@title,'"+customerName+"')]")))
						{
							String custName = pegaDriver.findElement(By.xpath("//tr[@id='$PD_GetOpenSocialCasesFromWorklist$ppxResults$l"+i+"']/descendant::div[contains(@class,'cssocial_mycaseshighlight')]/descendant::a[contains(@title,'"+customerName+"')]")).getText();
							System.out.println(custName);
							if(custName.equalsIgnoreCase(customerName))
							{
								//verify the content of the tweet/post
								String actualText = pegaDriver.findElement(By.xpath("//tr[@id='$PD_GetOpenSocialCasesFromWorklist$ppxResults$l"+i+"']/descendant::div[contains(@class,'cssocial_mycaseshighlight')]/descendant::span[contains(@class,'cssocial_leftnav_content_bold')]")).getText();
								System.out.println("Posted text\n"+text);
								System.out.println("Actual text\n"+actualText);
								if(actualText.equalsIgnoreCase(text))
								{
									//build final xpath
									finalXPath = "//tr[@id='$PD_GetOpenSocialCasesFromWorklist$ppxResults$l"+i+"']/descendant::div[contains(@class,'cssocial_mycaseshighlight')]/descendant::a[contains(@title,'"+customerName+"')]";
									System.out.println(finalXPath);
									launchCase();
									break;
								}
									
							}
						}
//					}
				}
			}
			
			
		}	
		if(finalXPath==null)
			return false;
		else
			return true;
		
	}
	
	
	@Override
	public void selectReplyAs(String replyHandle)
	{
		frameId = pegaDriver.getActiveFrameId();
		newWizard = pegaDriver.findWizard(frameId);
		replyHandle= new String(replyHandle).replace("@", "");
		replyHandle = replyHandle.trim();
		DropDown replyAsDropdown = newWizard.findSelectBox(By.id(REPLYAS_DROPDOWN_ID));
		replyAsDropdown.selectByVisibleText(replyHandle);

	
	}


	
	
}
