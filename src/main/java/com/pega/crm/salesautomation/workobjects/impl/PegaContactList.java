package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.ContactList;
import com.pega.crm.salesautomation.workobjects.Contacts;

public class PegaContactList extends PegaWorkObject implements ContactList {

	public PegaContactList(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}


	public Contacts createContact()
	{
		findElement(By.xpath(CREATE_CONT_BTN_XPATH)).click();
		String frameId =  getActiveFrameId(false);
		Contacts Cont = new PegaContact(frameId, testEnv);
		return Cont;	
	}

	
	public Contacts navigateContact(StringBuffer contactName) {
		
		findElement(By.id(CONT_SEARCH_FIELD_ID)).sendKeys(contactName);
		findElement(By.xpath(CONT_FILTERBUTTON_XPATH)).click();
		findElement(By.xpath(CONT_NAME_XPATH)).click();
		String frameId =  getActiveFrameId(false);
		Contacts Cont = new PegaContact(frameId, testEnv);
		return Cont;	
	}
	
	public Contacts navigateContact(String contactName) {
		
		findElement(By.id(CONT_SEARCH_FIELD_ID)).sendKeys(contactName);
		findElement(By.xpath(CONT_FILTERBUTTON_XPATH)).click();
		findElement(By.xpath(CONT_NAME_XPATH)).click();
		String frameId =  getActiveFrameId(false);
		Contacts Cont = new PegaContact(frameId, testEnv);
		return Cont;	
	}
	
	public Contacts openFirstContact() {
		findElement(By.xpath(CONT_NAME_XPATH)).click();
		String frameId =  getActiveFrameId(false);
		Contacts Cont = new PegaContact(frameId, testEnv);
		return Cont;
	}

	@Override
	public boolean isContactListEmpty() {
		  
		try {
			findElement(By.xpath(NO_CONTACTS_XPATH));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	
}
