package com.pega.crm.salesautomation.workobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.pega.ri.Wizard;

public interface ClosePlans extends Wizard{
	boolean isFilterMenuDisplayed();
	boolean isApplyButtonDisplayed();
	boolean isExportButtonDisplayed();
	void clickOppty();
	void enterClosePlans(String comments);
	void filterBy(String option);
	void searchForOrganization(String orgName);
	void apply();
	List<WebElement> getOrgsFromOpportunities();

}
