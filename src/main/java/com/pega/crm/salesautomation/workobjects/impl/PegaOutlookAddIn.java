package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.crm.salesautomation.workobjects.OutlookAddIn;
import com.pega.framework.PegaWebDriver;

public class PegaOutlookAddIn implements OutlookAddIn {

	String OL_SIGNIN_XPATH = "//*[text()='Sign in']";
	String OL_USERNAME_XPATH = "//*[@name='loginfmt']";
	String OL_NEXTBTN_XPATH = "//*[@value='Next']";
	String OL_PWD_XPATH = "//*[@name='passwd']";
	String OL_SIGNINTBTN_XPATH = "//*[@value='Sign in']";
	String OL_MAILICON_XPATH = "//*[text()=' Outlook ']";
	String OL_STAYSIGNEDINNO_XPATH = "//input[@value='No']";
	String OL_NEWMESSAGE_XPATH = "//button[contains(@title,'Write a new message')]";
	String OL_MESSAGETO_XPATH = "//input[contains(@aria-label,'To')]";
	String OL_MESSAGEBODY_XPATH = "//div[contains(@aria-label,'Message body')]";
	String OL_MESSAGESUBJECT_XPATH = "//input[contains(@placeholder,'Add a subject')]";
	String OL_SENDMAIL_XPATH = "//span[text()='Send']";
	String OL_SENTITEMS_XPATH = "//span[text()='Sent Items']";
	
	String OL_SAOLPLUGIN_XPATH = "//button[contains(@title, 'Sales Automation Add-in')]";
	String OL_SAUSERNAME_ID = "txtUserID";
	String OL_SAPWD_ID = "txtPassword";
	String OL_SALOGIN_XPATH = "//span[text() = 'Log in']";
	String OL_CREATE_XPATH = "//*[@data-test-id='2015012008382704523734']";
	
	
	private PegaWebDriver pegaDriver;
	
	
	public PegaOutlookAddIn(PegaWebDriver pegaDriver) 
	{
		this.pegaDriver = pegaDriver;
	}
	
	@Override
	public void loginToOutlook(String userName, String pwd) {
		
		pegaDriver.findElement(By.xpath(OL_SIGNIN_XPATH)).click(false);
		pegaDriver.findElement(By.xpath(OL_USERNAME_XPATH)).sendKeys(userName);
		pegaDriver.findElement(By.xpath(OL_NEXTBTN_XPATH)).click(false);
		pegaDriver.findElement(By.xpath(OL_PWD_XPATH)).sendKeys(pwd);
		pegaDriver.findElement(By.xpath(OL_SIGNINTBTN_XPATH)).click(false);
		pegaDriver.findElement(By.xpath(OL_STAYSIGNEDINNO_XPATH)).click(false);
		
	}

	@Override
	public void acessMailbox() {
	
		pegaDriver.findElement(By.xpath(OL_MAILICON_XPATH)).click(false);
	    String currentWindowHandle = pegaDriver.getWindowHandle();
		ArrayList<String> windowHandles = new ArrayList<String>(pegaDriver.getWindowHandles());
	    for (String window:windowHandles){
	        if (window != currentWindowHandle){
	        	pegaDriver.switchTo().window(window);
	        }
	    }
	}

	@Override
	public void sendEmail(String sendMailTo, String subject, String messageBody) {
		pegaDriver.findElement(By.xpath(OL_NEWMESSAGE_XPATH)).click(false);
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.findElement(By.xpath(OL_MESSAGETO_XPATH)).sendKeys(sendMailTo);
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.findElement(By.xpath(OL_MESSAGESUBJECT_XPATH)).sendKeys(subject);
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.findElement(By.xpath(OL_MESSAGEBODY_XPATH)).sendKeys(messageBody); 
		pegaDriver.waitForDocStateReady(3);
		List<WebElement> sendKeys = pegaDriver.findElements(By.xpath(OL_SENDMAIL_XPATH));
		sendKeys.get(0).click();
	}
	
	@Override
	public void selectRecentMail(String MailSubject){
	
		pegaDriver.findElement(By.xpath(OL_SENTITEMS_XPATH)).click(false);
		pegaDriver.waitForDocStateReady(3);
		String OL_RECENTMAIL_XPATH = "//span[contains(text(),'" + MailSubject + "')]";
		System.out.println("OL_RECENTMAIL_XPATH" + OL_RECENTMAIL_XPATH);
		pegaDriver.findElement(By.xpath(OL_RECENTMAIL_XPATH)).click(false);
		pegaDriver.waitForDocStateReady(5);
		pegaDriver.findElement(By.xpath(OL_SAOLPLUGIN_XPATH)).click(false);
		pegaDriver.waitForDocStateReady(5);
	}
	
	@Override
	public void loginToAddin(String SalesRepUserName, String SalesRepPassword) {
		if(pegaDriver.verifyElement(By.xpath(OL_SALOGIN_XPATH))) {
			pegaDriver.waitForDocStateReady(3);
			pegaDriver.findElement(By.id(OL_SAUSERNAME_ID)).sendKeys(SalesRepUserName);
			pegaDriver.waitForDocStateReady(3);
			pegaDriver.findElement(By.id(OL_SAPWD_ID)).sendKeys(SalesRepPassword);
			pegaDriver.waitForDocStateReady(3);
			pegaDriver.findElement(By.xpath(OL_SALOGIN_XPATH)).click(false);
			} else {
		}
	}
	
	@Override
	public boolean verifyContactHeader() {
		pegaDriver.handleWaits().sleep(5);
		pegaDriver.switchTo().frame("exttsp0");
		return pegaDriver.verifyElement(By.xpath(OL_CREATE_XPATH));
	}
}
