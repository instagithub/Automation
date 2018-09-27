package com.pega.sfa.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;
import com.pega.sfa.workobjects.Contact;
import com.pega.sfa.workobjects.ContactList;

public class ContactListImpl extends WizardImpl implements ContactList {

	public ContactListImpl(WebElement elmt, String elmtId)
	{
		super(elmt, elmtId);
	}
	public ContactListImpl(WebElement elmt) {
		super(elmt);
		// TODO Auto-generated constructor stub
	}
	public Contact createContact()
	{
		findElement(By.xpath(CREATE_CONT_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Contact Cont = new ContactImpl(framElmt, frameId);
		Cont._setEnvironment(testEnv, frameId);
		return Cont;	
	}

	
	public Contact navigateContact(StringBuffer contactName) {
		
		findElement(By.id(CONT_SEARCH_FIELD_ID)).sendKeys(contactName);
		findElement(By.xpath(CONT_FILTERBUTTON_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		findElement(By.xpath(CONT_NAME_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Contact Cont = new ContactImpl(framElmt, frameId);
		Cont._setEnvironment(testEnv, frameId);
		return Cont;	
	}
	
	public Contact navigateContact(String contactName) {
		
		findElement(By.id(CONT_SEARCH_FIELD_ID)).sendKeys(contactName);
		findElement(By.xpath(CONT_FILTERBUTTON_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		findElement(By.xpath(CONT_NAME_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Contact Cont = new ContactImpl(framElmt, frameId);
		Cont._setEnvironment(testEnv, frameId);
		return Cont;	
	}
	
	public Contact openFirstContact() {
		findElement(By.xpath(CONT_NAME_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Contact Cont = new ContactImpl(framElmt, frameId);
		Cont._setEnvironment(testEnv, frameId);
		return Cont;
	}

	@Override
	public boolean isContactListEmpty() {
		pegaDriver.getActiveFrameId(true);
		try {
			findElement(By.xpath(NO_CONTACTS_XPATH));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
}
