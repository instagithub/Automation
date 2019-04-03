package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.AccountList;
import com.pega.crm.salesautomation.workobjects.Accounts;
import com.pega.ri.WizardImpl;

public class PegaAccountList extends WizardImpl implements AccountList 
{
	public PegaAccountList(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}


	String CREATE_ACC_BTN_XPATH = PegaUtil.getStrongButtonXPath("Create account");
	String BUSINESSTAB_XPATH=PegaUtil.getSegmentedButtonXPath("Business");
	String ACC_SEARCH_FIELD_ID = "FilterTermForAccount'";
	String ACC_FILTER_PLACEHOLDER_XPATH = "//input[@placeholder='Filter accounts']";
	String ACC_FILTERBUTTON_XPATH=PegaUtil.getButtonXpath("Filter");
	String ACC_NAME_XPATH="//table[@id='gridLayoutTable']//tr[@aria-rowindex='1']//a[1]";
	StringBuffer ACC_NAME=new StringBuffer("Automation_Account");
	String NO_ACCOUNTS_XPATH= "//tr[@id='Grid_NoResults']";
	String ACC_ALL_BUTTON_XPATH=PegaUtil.getSegmentedButtonXPath("All");
	String ACC_INDIVIDUAL_BUTTON_XPATH=PegaUtil.getSegmentedButtonXPath("Individual");
	String ACC_EXPORT_BUTTON_XPATH="//*[@data-test-id='20141201005938049326913']";
	String OPP_REFRESH_BUTTON_XPATH="//*[@data-test-id='20141201005938049427324']";
	String ACC_TABLE_HEADER_XPATH="//table[@id='bodyTbl_right']//th//div[@class='cellIn ']";


	public StringBuffer WOName;
	public Accounts createAccount() {
		findElement(By.xpath(CREATE_ACC_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		Accounts acc = new PegaAccounts(frameId, testEnv);
		return acc;	
		
	}


	public Accounts navigateAccount(StringBuffer acc_name) {
		
		//pegaDriver.getActiveFrameId(true);
		findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).sendKeys(acc_name);
		findElement(By.xpath(ACC_FILTERBUTTON_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		if(verifyElement(By.xpath(ACC_NAME_XPATH)))
		{
			findElement(By.xpath(ACC_NAME_XPATH)).click();
		}	
		else
		{
			openFirstAccount();
		}
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		Accounts acc = new PegaAccounts(frameId, testEnv);
		return acc;	
	}
	
	public Accounts navigateAccount(String acc_name) {
		
		//pegaDriver.getActiveFrameId(true);
		findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).sendKeys(acc_name);
		findElement(By.xpath(ACC_FILTERBUTTON_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		if(verifyElement(By.xpath(ACC_NAME_XPATH)))
		{
			findElement(By.xpath(ACC_NAME_XPATH)).click();
		}	
		else
		{
			openFirstAccount();
		}
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		Accounts acc = new PegaAccounts(frameId, testEnv);
		return acc;	
	}

	@Override
	public Accounts openFirstAccount() {
		pegaDriver.getActiveFrameId(true);
		findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).sendKeys(PegaUtil.SelectAll);
		findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).sendKeys(Keys.TAB);
		findElement(By.xpath(BUSINESSTAB_XPATH)).click();
		String name=findElement(By.xpath(ACC_NAME_XPATH)).getText();
		WOName= new StringBuffer(name);
		findElement(By.xpath(ACC_NAME_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		Accounts acc = new PegaAccounts(frameId, testEnv);
		return acc;
	}

	@Override
	public Boolean isAccountListEmpty() {
		pegaDriver.getActiveFrameId(true);
		try {
			findElement(By.xpath(NO_ACCOUNTS_XPATH));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}


	@Override
	public boolean isCreateButtonDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(CREATE_ACC_BTN_XPATH)).isVisible();
		return b;
	}


	@Override
	public boolean isFilterTextBoxDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).isVisible();
		return b;
	}


	@Override
	public String getFilterPlaceHolder() {
		pegaDriver.getActiveFrameId(true);
		String b= pegaDriver.findElement(By.xpath(ACC_FILTER_PLACEHOLDER_XPATH)).getAttribute("placeholder");
		return b;
	}


	@Override
	public boolean isFilterButtonDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(ACC_FILTERBUTTON_XPATH)).isVisible();
		return b;
	}


	@Override
	public boolean isAllButtonDisplayed() {
		boolean b= pegaDriver.findElement(By.xpath(ACC_ALL_BUTTON_XPATH)).isVisible();
		return b;
	}


	@Override
	public boolean isBusinessButtonDisplayed() {
		boolean b= pegaDriver.findElement(By.xpath(BUSINESSTAB_XPATH)).isVisible();
		return b;	}


	@Override
	public boolean isIndividualButtonDisplayed() {
		boolean b= pegaDriver.findElement(By.xpath(ACC_INDIVIDUAL_BUTTON_XPATH)).isVisible();
		return b;
	}


	@Override
	public boolean isExportButtonDisplayed() {
		boolean b= pegaDriver.findElement(By.xpath(ACC_EXPORT_BUTTON_XPATH)).isVisible();
		return b;
	}


	@Override
	public boolean isRefreshButtonDisplayed() {
		
		boolean b= pegaDriver.findElement(By.xpath(OPP_REFRESH_BUTTON_XPATH)).isVisible();
		return b;
	}


	@Override
	public ArrayList<String> getTableHeaders() {
		pegaDriver.getActiveFrameId(true);
		ArrayList<String> s= new ArrayList<String>();
		
		List<WebElement> wb=pegaDriver.findElements(By.xpath(ACC_TABLE_HEADER_XPATH));
		for(WebElement w:wb)
		{
			String s1=w.getText();
			s.add(s1);
		}
		return s;
	}
	
	
}
