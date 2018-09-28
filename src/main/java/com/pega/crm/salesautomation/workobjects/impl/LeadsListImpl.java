package salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;
import salesautomation.workobjects.Leads;
import salesautomation.workobjects.LeadsList;

public class LeadsListImpl extends WizardImpl implements LeadsList {

	public LeadsListImpl(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public Leads createBusinessLead() {
		UtilImpl.dropdown(pegaDriver, CREATE_LEAD_BTN_XPATH, 2);
		
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Leads lead = new LeadsImpl(framElmt, frameId);
		lead._setEnvironment(testEnv, frameId);
		return lead;	
	}

	@Override
	public Leads createIndividualLead() 
	{
		UtilImpl.dropdown(pegaDriver, CREATE_LEAD_BTN_XPATH, 1);
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Leads lead = new LeadsImpl(framElmt, frameId);
		lead._setEnvironment(testEnv, frameId);
		return lead;	
	}

	@Override
	public Leads navigateLead(String LeadName) {
		findElement(LEAD_FILTER_PLACEHOLDER_XPATH).sendKeys(LeadName);
		findElement(LEAD_FILTERBUTTON_XPATH).click();
		pegaDriver.getActiveFrameId(true);

		findElement(By.xpath("//a[contains(text(),'"+LeadName+"')]")).click();

		//findElement(By.xpath(LEAD_NAME_XPATH)).click();

		//findElement(By.xpath("//a[text()='"+ LeadName+"']")).click();

		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Leads lead = new LeadsImpl(framElmt, frameId);
		lead._setEnvironment(testEnv, frameId);
		return lead;	
	}

	@Override
	public boolean isleadsListEmpty() {
		pegaDriver.getActiveFrameId(true);
		try {
			findElement(By.xpath(NO_LEADS_XPATH));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public Leads openFirstLead() {
		pegaDriver.getActiveFrameId(true);
		findElement(By.xpath(LEAD_NAME_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Leads lead = new LeadsImpl(framElmt, frameId);
		lead._setEnvironment(testEnv, frameId);
		return lead;
	}


	@Override
	public String getSectionHeader() {
		return(UtilImpl.getSectionHeader(pegaDriver).trim());
	}


	@Override
	public boolean isCreateLeadButtonDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(CREATE_LEAD_BTN_XPATH)).isVisible();
		return b;
	}


	@Override
	public boolean isFilterTextBoxDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(LEAD_FILTER_PLACEHOLDER_XPATH).isVisible();
		return b;
	}


	@Override
	public String getFilterPlaceHolder() {
		pegaDriver.getActiveFrameId(true);
		String b= pegaDriver.findElement(LEAD_FILTER_PLACEHOLDER_XPATH).getAttribute("placeholder");
		return b;
	}


	@Override
	public boolean isFilterButtonDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(LEAD_FILTERBUTTON_XPATH).isVisible();
		return b;
	}


	@Override
	public boolean isAllLeadButtonDisplayed() {
		boolean b= pegaDriver.findElement(LEAD_ALL_BUTTON_XPATH).isVisible();
		return b;
	}


	@Override
	public boolean isBusinessButtonDisplayed() {
		boolean b= pegaDriver.findElement(LEAD_BUSINESS_BUTTON_XPATH).isVisible();
		return b;
	}


	@Override
	public boolean isIndividualButtonDisplayed() {
		boolean b= pegaDriver.findElement(LEAD_INDIVIDUAL_BUTTON_XPATH).isVisible();
		return b;
	}


	@Override
	public boolean isExportButtonDisplayed() {
		boolean b= pegaDriver.findElement(LEAD_EXPORT_BUTTON_XPATH).isVisible();
		return b;
	}


	@Override
	public boolean isRefreshButtonDisplayed() {
		boolean b= pegaDriver.findElement(LEAD_REFRESH_BUTTON_XPATH).isVisible();
		return b;
	}


	@Override
	public ArrayList<String> getTableHeaders() {
		pegaDriver.getActiveFrameId(true);
		ArrayList<String> s= new ArrayList<String>();
		List<WebElement> wb=pegaDriver.findElements(By.xpath(LEAD_TABLE_HEADER_XPATH));
		for(WebElement w:wb)
		{
			String s1=w.getText();
			System.out.println(s1);
			s.add(s1);
		}
		return s;
	}

}
