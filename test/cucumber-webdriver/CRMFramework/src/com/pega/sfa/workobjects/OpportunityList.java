package com.pega.sfa.workobjects;

import java.util.ArrayList;

import com.pega.ri.Wizard;

public interface OpportunityList extends Wizard{
	
	
	
	Opportunity createBusniessOpportunity();
	Opportunity createIndividualOpportunity();
	Opportunity navigateOpportunity(String opportunityName);
	boolean isCreateOpportunityButtonDisplayed();
	boolean isFilterTextBoxDisplayed();
	boolean isFilterButtonDisplayed();
	boolean isAllOpptyButtonDisplayed();
	boolean isIndividualButtonDisplayed();
	boolean isBusinessButtonDisplayed();
	boolean isExportButtonDisplayed();
	boolean isRefreshButtonDisplayed();
	String getFilterPlaceHolder();
	ArrayList<String> getTableHeaders();
	Opportunity openFirstOpportunity();
	boolean isOpportunityListEmpty();
	void searchOpportunity(String opptyName);
	void SwitchToBusinessTab();
	void dragAndDropToPropasal(String OppID);
	void switchToStageView();								  

}
