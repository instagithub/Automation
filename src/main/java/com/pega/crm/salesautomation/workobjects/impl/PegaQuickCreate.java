package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Accounts;
import com.pega.crm.salesautomation.workobjects.Appointment;
import com.pega.crm.salesautomation.workobjects.Contacts;
import com.pega.crm.salesautomation.workobjects.Leads;
import com.pega.crm.salesautomation.workobjects.Opportunities;
import com.pega.crm.salesautomation.workobjects.Organizations;
import com.pega.crm.salesautomation.workobjects.Partners;
import com.pega.crm.salesautomation.workobjects.QuickCreate;
import com.pega.ri.WizardImpl;

public class PegaQuickCreate extends WizardImpl implements QuickCreate{

	public PegaQuickCreate(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	String ORGANIZATION_XPATH="//span[text()='Organization']";
	String ACCOUNT_XPATH="//span[text()='Account']";
	String ACCOUNT_BUSINESS_XPATH="//span[text()='Business']";
	String CONTACT_XPATH=getQuickCreateXpath("Contact");
	String LEAD_XPATH=getQuickCreateXpath("Lead");
	String PARTNER_XPATH=getQuickCreateXpath("Partner");
	String OPPORTUNITY_XPATH=getQuickCreateXpath("Opportunity");
	
	String getQuickCreateXpath(String text)
	{
		return("//span[text()='"+text+"']");
	}
			
	


	@Override
	public Organizations clickOrganization() {
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(ORGANIZATION_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		Organizations org= new PegaOrganization(frameId, testEnv);
		return org;
	}

	@Override
	public Opportunities clickOpportunity(String opptype) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(OPPORTUNITY_XPATH)).mouseOver();
		//pegaDriver.waitForDocStateReady(true);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		//pegaDriver.findElement(By.xpath("//a[contains(@data-click,'Opportunity')]"+""+getQuickCreateXpath(opptype))).mouseOver();
		pegaDriver.getTestEnv().getDriverActions().moveToElement(pegaDriver.findElement(By.xpath("//a[contains(@data-click,'Opportunity')]"+""+getQuickCreateXpath(opptype))).getWebElement()).click().perform();
		String frameId = pegaDriver.getActiveFrameId(false);
		Opportunities oppty= new PegaOpportunity(frameId, testEnv);
		return oppty;
	}

	@Override
	public Appointment clickAppointment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Accounts clickAccount() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(ACCOUNT_XPATH)).mouseOver();
		pegaDriver.getTestEnv().getDriverActions().moveToElement(pegaDriver.findElement(By.xpath(ACCOUNT_BUSINESS_XPATH)).getWebElement()).click().perform();
		String frameId = pegaDriver.getActiveFrameId(false);
		Accounts acc= new PegaAccounts(frameId, testEnv);
		return acc;
	}

	@Override
	public Contacts clickContact() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(CONTACT_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		Contacts cont= new PegaContact(frameId, testEnv);
		return cont;
	}

	@Override
	public Partners clickPartner() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(CONTACT_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		Partners part= new PegaPartners(frameId, testEnv);
		return part;
	}

	@Override
	public Leads clickLead(String Leadtype) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(LEAD_XPATH)).mouseOver();
		//pegaDriver.waitForDocStateReady(true);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		//pegaDriver.findElement(By.xpath("//a[contains(@data-click,'Opportunity')]"+""+getQuickCreateXpath(opptype))).mouseOver();
		//pegaDriver.getTestEnv().getDriverActions().moveToElement(pegaDriver.findElement(By.xpath("//div[]//a[@tabindex='-1']"+""+getQuickCreateXpath(Leadtype))).getWebElement()).click().perform();
		//pegaDriver.getTestEnv().getDriverActions().moveToElement(pegaDriver.findElement(By.xpath("//a[@tabindex='-1']//span[text()='Lead']/../../.."+""+getQuickCreateXpath(Leadtype))).getWebElement()).click().perform();
		pegaDriver.getTestEnv().getDriverActions().moveToElement(pegaDriver.findElement(By.xpath("//a[@tabindex='-1']//span[text()='Lead']/../../.."+""+getQuickCreateXpath(Leadtype))).getWebElement()).click().perform();
		
		
		String frameId = pegaDriver.getActiveFrameId(false);
		Leads lead= new PegaLeads(frameId, testEnv);
		return lead;
	}

}
