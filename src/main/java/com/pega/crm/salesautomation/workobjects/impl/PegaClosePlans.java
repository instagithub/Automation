package com.pega.crm.salesautomation.workobjects.impl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.ClosePlans;
import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;


public class PegaClosePlans extends WizardImpl implements ClosePlans{

	public PegaClosePlans(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	String FILTERBY_ID="BaseFilterForLP";
	String APPLYBUTTON_XPATH=PegaUtil.getButtonXpath("Apply");
	String EXPORTBUTTON_XPATH=PegaUtil.getButtonXpath("Export");
	String CLOSEPLAN_OPPTY="//table[contains(@pl_prop_class,'Opportunity')]//tr[contains(@id,'1')]";
	String CLOSEPLAN_OPPORTUNITY_ORG = "//table[contains(@pl_prop_class,'Opportunity')]//tr//td//div[contains(@section_index, '2')]";
	String CLOSEPLAN_COMMETNS="//body[contains(@title,'This is a rich text')]";
	String ADDNEW_XPATH=PegaUtil.getStrongButtonXPath("Add new");
	String ORGNAME_TITLE = "OrganizationName";
	

	@Override
	public boolean isFilterMenuDisplayed() {
		return pegaDriver.findElement(By.id(FILTERBY_ID)).isVisible();
	}

	@Override
	public boolean isApplyButtonDisplayed() {
		return pegaDriver.findElement(By.xpath(APPLYBUTTON_XPATH)).isVisible();
	}

	@Override
	public boolean isExportButtonDisplayed() {
		return pegaDriver.findElement(By.xpath(EXPORTBUTTON_XPATH)).isVisible();
	}

	@Override
	public void clickOppty() {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(CLOSEPLAN_OPPTY)).click();
	}

	@Override
	public void enterClosePlans(String comments) {
		pegaDriver.getActiveFrameId(true);
		if(pegaDriver.verifyElement(By.xpath(ADDNEW_XPATH)))
			pegaDriver.findElement(By.xpath(ADDNEW_XPATH)).click();
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.getActiveFrameId(true);
		WebElement wb=pegaDriver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor')]")).getWebElement();
		pegaDriver.switchTo().frame(wb);
		pegaDriver.findElement(By.xpath(CLOSEPLAN_COMMETNS)).sendKeys(comments);
		
	}
	
	@Override
	public void filterBy(String option) {
		Select filter = new Select(pegaDriver.findElement(By.id(FILTERBY_ID)));
		filter.selectByVisibleText(option);
	}

	@Override
	public void searchForOrganization(String orgName) {
		PegaUtil.autoComplete(pegaDriver, ORGNAME_TITLE, orgName);
	}

	@Override
	public void apply() {
		PegaWebElement applyButton = pegaDriver.findElement(By.xpath(APPLYBUTTON_XPATH));
		applyButton.click();
	}

	@Override
	public List<WebElement> getOrgsFromOpportunities() {
		pegaDriver.getActiveFrameId(true);
		List<WebElement> opportunities = pegaDriver.findElements(By.xpath(CLOSEPLAN_OPPORTUNITY_ORG));
		return (opportunities);
	}
	
	

}
