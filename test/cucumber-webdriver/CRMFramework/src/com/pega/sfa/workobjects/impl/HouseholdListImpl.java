package com.pega.sfa.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;
import com.pega.sfa.workobjects.HouseholdList;
import com.pega.sfa.workobjects.Households;
//import com.pega.sfa.workobjects.impl.HouseholdsImpl;

public class HouseholdListImpl extends WizardImpl implements HouseholdList{
	
	


	public HouseholdListImpl(WebElement elmt, String elmtId) {
		super(elmt, elmtId);

	}


	public Households createHousehold() {
		findElement(By.xpath(CREATE_HH_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Households hh=new HouseholdsImpl(framElmt, frameId);
	    hh._setEnvironment(testEnv, frameId);	
  
		return hh;	
		
		
	}
	public Households navigateHouseholds(String householdsName) 
	{
		findElement(By.id(HH_SEARCH_FIELD_ID)).sendKeys(householdsName);
		findElement(By.xpath(HH_FILTERBUTTON_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		findElement(By.xpath(HH_NAME_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Households hh = new HouseholdsImpl(framElmt, frameId);
		hh._setEnvironment(testEnv, frameId);
		return hh;	
	}
	
	@Override
	public boolean isHouseholdListEmpty() {
		pegaDriver.getActiveFrameId(true);
		try {
			findElement(By.xpath(NO_HOUSEHOLDS_XPATH));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}


	@Override
	public Households openFirstHousehold() {
		pegaDriver.getActiveFrameId(true);
		findElement(By.xpath(HH_NAME_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Households household = new HouseholdsImpl(framElmt, frameId);
		household._setEnvironment(testEnv, frameId);
		return household;
	}


	@Override
	public boolean isCreateButtonDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(CREATE_HH_BTN_XPATH)).isVisible();
		return b;
	}


	@Override
	public boolean isFilterTextBoxDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(HH_FILTER_PLACEHOLDER_XPATH)).isVisible();
		return b;
	}


	@Override
	public String getFilterPlaceHolder() {
		pegaDriver.getActiveFrameId(true);
		String b= pegaDriver.findElement(By.xpath(HH_FILTER_PLACEHOLDER_XPATH)).getAttribute("placeholder");
		return b;
	}


	@Override
	public boolean isFilterButtonDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(HH_FILTERBUTTON_XPATH)).isVisible();
		return b;
	}


	@Override
	public boolean isExportButtonDisplayed() {
		
		boolean b= pegaDriver.findElement(HH_EXPORT_BUTTON_XPATH).isVisible();
		return b;
	}


	@Override
	public boolean isRefreshButtonDisplayed() {
		boolean b= pegaDriver.findElement(HH_REFERSH_BUTTON_XPATH).isVisible();
		return b;
	}


	@Override
	public ArrayList<String> getTableHeaders() {
		pegaDriver.getActiveFrameId(true);
		ArrayList<String> s= new ArrayList<String>();
		
		
		List<WebElement> wb=pegaDriver.findElements(By.xpath(HH_TABLE_HEADER_XPATH));
		for(WebElement w:wb)
		{
			String s1=w.getText();
			s.add(s1);
		}
		return s;
	}

}