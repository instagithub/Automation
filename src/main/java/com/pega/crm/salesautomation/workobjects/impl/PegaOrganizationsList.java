package com.pega.crm.salesautomation.workobjects.impl;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.crm.salesautomation.workobjects.Organizations;
import com.pega.crm.salesautomation.workobjects.OrganizationsList;
import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;

public class PegaOrganizationsList extends WizardImpl implements OrganizationsList{
	
	
		String ORGANIZATIONS_TAB = new String("//span[text()='Organizations']");
		
		String CREATE_ORG_BTN_XPATH = new String("//button[text()='Create organization']");
		String ORG_SEARCH_FIELD = "FilterTermForOrganization";
		String exportButton = "//span[text()='Export']";
		String refreshButton = "//span[text()='Refresh']";
		String filterButton = "//button[text()='Filter']";
		String ORGLIST_MENU = "//*[@data-test-id='20180807070707023921318']";
		String ORGANIZATION_NAME_XPATH="//table[@data-test-id='201801031011410135512-layout']//tr[@aria-rowindex='1']//a[1]";
		String NO_ORGANIZATIONS_XPATH = "//div[text='No organizations']";
		
		
	public PegaOrganizationsList(WebElement elmt) {
		super(elmt);
	}
	
	public PegaOrganizationsList(WebElement elmt, String elmtId){
		super(elmt, elmtId);
	}

	@Override
	public void search() {
		
	}
	
	public void verifyOrgListpage()
	{	
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		Assert.assertTrue(pegaDriver.verifyElement(By.xpath(CREATE_ORG_BTN_XPATH)));
		Assert.assertTrue(pegaDriver.verifyElement(By.id(ORG_SEARCH_FIELD)));
		Assert.assertTrue(pegaDriver.verifyElement(By.xpath(filterButton)));
		
	}
	
	public Organizations navigateOrganiztion()
	{
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations org = new PegaOrganization(framElmt, frameId);
		org._setEnvironment(testEnv, frameId);
		return org;
	
	}
	
	
	
	@Override
	public OrganizationsList searchOrganization(String orgName) {
		
		pegaDriver.getActiveFrameId(true);
		
		findElement(By.id(ORG_SEARCH_FIELD)).sendKeys(orgName);
		findElement(By.id(ORG_SEARCH_FIELD)).sendKeys(Keys.ENTER);
		pegaDriver.waitForDocStateReady(2);
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		OrganizationsList org = new PegaOrganizationsList(framElmt, frameId);
		org._setEnvironment(testEnv, frameId);
		return org;
		
	}
	
	@Override
	public Organizations openOrganization(String OrgName)
	{
		pegaDriver.getActiveFrameId(true);
		
		findElement(By.id(ORG_SEARCH_FIELD)).clear();
		findElement(By.id(ORG_SEARCH_FIELD)).sendKeys(OrgName);
		findElement(By.id(ORG_SEARCH_FIELD)).sendKeys(Keys.ENTER);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.getActiveFrameId(true);
		if(pegaDriver.verifyElement(By.xpath("//a[contains(text(),'"+OrgName+"')]")))
		pegaDriver.findElement(By.xpath("//a[contains(text(),'"+OrgName+"')]")).click();
		else
		{
			findElement(By.id(ORG_SEARCH_FIELD)).clear();
			findElement(By.id(ORG_SEARCH_FIELD)).sendKeys(Keys.ENTER);
			openFirstOrganization();
		}
		
		String frameId= pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations org = new PegaOrganization(framElmt, frameId);
		org._setEnvironment(testEnv, frameId);
		
		frameId = pegaDriver.getActiveFrameId(false);
		framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		return org;
	}
	
	
	
	public void verifyOrgNewHarness()
	{
		
	}
	

	@Override
	public Organizations createOrganization() {
		findElement(By.xpath(CREATE_ORG_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations org = new PegaOrganization(framElmt, frameId);
		org._setEnvironment(testEnv, frameId);
		return org;	
	}
	
	@Override
	public Organizations openFirstOrganization() {
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		findElement(By.xpath(ORGANIZATION_NAME_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		
		
		frameId = pegaDriver.getActiveFrameId(false);
		framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		Organizations organization = new PegaOrganization(framElmt, frameId);
		organization._setEnvironment(testEnv, frameId);
		return organization;
	
}

	@Override
	public boolean isOrganizationListEmpty() {
		
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		pegaDriver.getActiveFrameId(true);
		if(verifyElement(By.xpath(NO_ORGANIZATIONS_XPATH)))
		return true;
		else
		return false;
	}
	
	
	
	
}
