package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.crm.salesautomation.workobjects.Accounts;
import com.pega.crm.salesautomation.workobjects.Appointment;
import com.pega.crm.salesautomation.workobjects.Contacts;
import com.pega.crm.salesautomation.workobjects.Leads;
import com.pega.crm.salesautomation.workobjects.Opportunities;
import com.pega.crm.salesautomation.workobjects.Organizations;
import com.pega.crm.salesautomation.workobjects.Partners;
import com.pega.crm.salesautomation.workobjects.QuickCreate;
import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;

public class PegaQuickCreate extends WizardImpl implements QuickCreate{

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
			
	

	public PegaQuickCreate(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Organizations clickOrganization() {
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(ORGANIZATION_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations org= new PegaOrganization(framElmt, frameId);
		org._setEnvironment(testEnv, frameId);
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
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Opportunities oppty= new PegaOpportunity(framElmt, frameId);
		oppty._setEnvironment(testEnv, frameId);
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
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Accounts acc= new PegaAccounts(framElmt, frameId);
		acc._setEnvironment(testEnv, frameId);
		return acc;
	}

	@Override
	public Contacts clickContact() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(CONTACT_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Contacts cont= new PegaContact(framElmt, frameId);
		cont._setEnvironment(testEnv, frameId);
		return cont;
	}

	@Override
	public Partners clickPartner() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(CONTACT_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Partners part= new PegaPartners(framElmt, frameId);
		part._setEnvironment(testEnv, frameId);
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
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Leads lead= new PegaLeads(framElmt, frameId);
		lead._setEnvironment(testEnv, frameId);
		return lead;
	}

}
