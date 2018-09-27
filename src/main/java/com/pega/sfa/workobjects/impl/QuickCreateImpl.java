package com.pega.sfa.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;
import com.pega.sfa.workobjects.Accounts;
import com.pega.sfa.workobjects.Appointment;
import com.pega.sfa.workobjects.Contact;
import com.pega.sfa.workobjects.Leads;
import com.pega.sfa.workobjects.Opportunity;
import com.pega.sfa.workobjects.Organization;
import com.pega.sfa.workobjects.Partners;
import com.pega.sfa.workobjects.QuickCreate;

public class QuickCreateImpl extends WizardImpl implements QuickCreate{

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
			
	

	public QuickCreateImpl(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Organization clickOrganization() {
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(ORGANIZATION_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organization org= new OrganizationImpl(framElmt, frameId);
		org._setEnvironment(testEnv, frameId);
		return org;
	}

	@Override
	public Opportunity clickOpportunity(String opptype) {
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
		Opportunity oppty= new OpportunityImpl(framElmt, frameId);
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
		Accounts acc= new AccountsImpl(framElmt, frameId);
		acc._setEnvironment(testEnv, frameId);
		return acc;
	}

	@Override
	public Contact clickContact() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(CONTACT_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Contact cont= new ContactImpl(framElmt, frameId);
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
		Partners part= new PartnersImpl(framElmt, frameId);
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
		Leads lead= new LeadsImpl(framElmt, frameId);
		lead._setEnvironment(testEnv, frameId);
		return lead;
	}

}
