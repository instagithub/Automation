package com.pega.cs.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.cs.CSPortal;
import com.pega.cs.tiles.LeftNav;
import com.pega.cs.tiles.TopNav;
import com.pega.cs.tiles.impl.TopNavImpl;
import com.pega.cs.utils.CommonMethods;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.page.PortalImpl;
import com.pega.ri.Wizard;

public class CSPortalImpl extends PortalImpl implements CSPortal{
	
	public String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	public String VERSION = "$Id: CSPortalImpl.java 117333 2015-06-18 09:12:21Z MuraliKondapally $";
	
	private TopNav topNav = null;
	private LeftNav leftNav = null;
	public String frameId = null;
	public Wizard newWizard = null;
	public PegaWebDriver pegaDriver = null;
	
	public static String expectedText, actualText;
	// XPATHs for elements
	String NEWMESSAGE_XPATH = "//a[@title='Create New Alert Message']";
	String CREATEALERT_XPATH = "//button[text()='  Create Alert ']";
	String MANAGER_XPATH = "//li[text() = 'Manager']";
	String MOVETOSELECTEDWORKGROUPS_XPATH = "//div[@title='Move']";
	String STARTDATE_XPATH = "//input[@id='startDate']";
	String ENDDATE_XPATH = "//input[@id='endDate']";
	String TITLE_XPATH = "//input[@id='Title']";
	String MESSAGE_XPATH = "//textarea[@id='pyDescription']";
	String REFRESH_XPATH = "//i[@title = 'Refresh Messages &amp; Alerts Section ']";
	String MODIFYALERT_XPATH = "//button[@name= 'ModifyAlert_ModifyAlert_151']/div/div/div/div";
	String DELETEALERT_XPATH = "//button[@name= 'ModifyAlert_ModifyAlert_150']";
	String CANCEL_XPATH = ".//*[@id='RULE_KEY']/div[4]/div/div/div[1]/div/div/span/button";
	
	public CSPortalImpl(TestEnvironment testEnv) {
		super(testEnv);
		//this.testEnv�=testEnv;
	}

	@Override
	public TopNav getTopNav() {
		if (topNav == null) {
			topNav = new TopNavImpl(testEnv);
		}
		return topNav;
	}

	@Override
	public LeftNav getLeftNav() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void newMessage() {
		// TODO Auto-generated method stub
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		newWizard.findElement(By.xpath(NEWMESSAGE_XPATH)).click();
	}

	@Override
	public void createAlert(String startDate, String endDate, String title, String message) {
		newWizard.findElement(By.xpath(MANAGER_XPATH)).click();
		newWizard.findElement(By.xpath(MOVETOSELECTEDWORKGROUPS_XPATH)).click();
		newWizard.findElement(By.xpath(STARTDATE_XPATH)).sendKeys(startDate);
		newWizard.findElement(By.xpath(ENDDATE_XPATH)).sendKeys(endDate);
		newWizard.findElement(By.xpath(TITLE_XPATH)).sendKeys(title);
		newWizard.findElement(By.xpath(MESSAGE_XPATH)).sendKeys(message);
		newWizard.findElement(By.xpath(CREATEALERT_XPATH)).click();
	}

	@Override
	public void doubleClickAlert(String message) {

		PegaWebElement alert = newWizard.findElement(By.xpath("//span[text() = '" + message + "']"));
		alert.doubleClick();
		pegaDriver.waitForDocStateReady(5);
		System.out.println("final xpath is: " + message);
	}

	@Override
	public void modifyAlert(String value, String modifyingField) {
		if (modifyingField.equals("message")) {
			newWizard.findElement(By.xpath(MESSAGE_XPATH)).click();
			newWizard.findElement(By.xpath(MESSAGE_XPATH)).clear();
			newWizard.findElement(By.xpath(MESSAGE_XPATH)).sendKeys(value);
		} else if (modifyingField.equals("end date")) {
			newWizard.findElement(By.xpath(ENDDATE_XPATH)).click();
			newWizard.findElement(By.xpath(ENDDATE_XPATH)).clear();
			newWizard.findElement(By.xpath(ENDDATE_XPATH)).sendKeys(value);
		} else if (modifyingField.equals("title")) {
			newWizard.findElement(By.xpath(TITLE_XPATH)).click();
			newWizard.findElement(By.xpath(TITLE_XPATH)).clear();
			newWizard.findElement(By.xpath(TITLE_XPATH)).sendKeys(value);
		} else if (modifyingField.equals("start date")) {
			newWizard.findElement(By.xpath(STARTDATE_XPATH)).click();
			newWizard.findElement(By.xpath(STARTDATE_XPATH)).clear();
			newWizard.findElement(By.xpath(STARTDATE_XPATH)).sendKeys(value);
		}

		PegaWebElement modifyAlert = newWizard.findElement(By.xpath(MODIFYALERT_XPATH));
		modifyAlert.click();
		modifyAlert.click();
	}

	@Override
	public void deleteAlert() {
		newWizard.findElement(By.xpath(DELETEALERT_XPATH)).click();
	}

	@Override
	public void cancelModifyAlertDailogue() {
		newWizard.findElement(By.xpath(CANCEL_XPATH)).click();
	}

	@Override
	public void refreshAlertSection() {
		newWizard.findElement(By.xpath(REFRESH_XPATH)).click();
	}
	

	
	

}
