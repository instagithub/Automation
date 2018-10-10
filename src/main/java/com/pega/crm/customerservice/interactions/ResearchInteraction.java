package com.pega.crm.customerservice.interactions;

public interface ResearchInteraction extends Interactions{
	String UPDATE_CONTACT_PROFILE_XPATH = "//a[text()='Update Contact Profile' and @class='Add_task']";
	String OCCUPATION_XPATH = "//input[@id='Occupation']";
	String CLOSE_INTERACTION_XPATH = "//a[@class='Wrap_up' and text()='Close']";
	//void selectResult();
	String checkCaseStatus(String caseId);
	void launchUpdateContactProfile();
	void updateContactProfile();
	//void closeInteraction();
	public void searchCaseStatus(String searchType, String value);
	
	

}
