package com.pega.crm.salesautomation.workobjects;

import java.util.ArrayList;

import com.pega.ri.Wizard;

public interface Login extends Wizard {
	
	public String MYWORK_LISTPAGE="//span[text()='My Work']";
	public String WORK_LIST_XPATH="//h2[text()='Work list']";
	public String TO_DO_LIST_XPATH="//h2[text()='To-do list']";
	public String SUGGESTED_VISITS_XPATH="//h2[text()='Suggested visits']";
	public void validateOperator(String Title);
	public ArrayList<String> validateLeftNav();
	//public void validateLeftNav(String operator);
	public void clickMyWork();
	public boolean verifyWorkListSection();
	public boolean verifyToDoList();
	public boolean verifySuggestedVisits();

}
