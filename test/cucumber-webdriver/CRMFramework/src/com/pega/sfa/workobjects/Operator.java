package com.pega.sfa.workobjects;


import com.pega.ri.Wizard;
import com.pega.util.XPathUtil;

public interface Operator extends Wizard {
	
	//String OPR_TEMPLATE_CHECKBOX = "//input[@type='checkbox']";
	//String OPR_DEFAULT_ACCESS_CHECKBOX = "crmIsDefaultOperatorAccess";
	/*	String OPR_NEXT_BUTTON = XPathUtil.getButtonPzBtnMidXPath("Next >>");
	String OPR_NEXT_BUTTON_XPATH = "//button//div[contains(text(),'Next >>')]";
	String OPR_FINISH_BUTTON = XPathUtil.getButtonPzBtnMidXPath("Finish"); 

	String OPERATORID_FIELD = "pyUserIdentifier"; 
	String OPR_PWD_BUTTON = "//button[contains(text(),'Password *')]";
	String OPR_PASSWORD = "pyPwdNew";
	String OPR_CONFIRMPASSWORD = "pyPwdConfirmText";
	String OPR_FIRST_NAME = "pyFirstName";
	String OPR_LAST_NAME = "pyLastName";
	String OPR_FULL_NAME = "pyUserName";
	String OPR_POSTITION ="pyPosition"; 
	String OPR_TELEPHONE = "pyTelephone";
	String OPR_EMAILADDRESS = "pyEmailAddress";
	String OPR_TIMEZONE = "pyDefaultTimeZone";
	String OPR_REPORTSTO = "crmSearchTerm";
	String OPR_TITLE = "pyTitle";
	String OPR_TYPE = "pyAccessGroup";
	String OPR_TERRITORY = "TerritoryID";
	*/
	
	
	void setOperatorID(String str);
	void setPassword(String str);
	void setTitle(String str);
	void setFirstName(String str);
	void setLastName(String str);
	void setFullName(String str);
	void setPostition(String str);
	void setPhone(String str);
	void setEmail(String str);
	void setTimeZone(String str);
	void setReportTo(String str);
	void setOperatorType(String str);
	void setTerritory(String str);
	
	String getOperatorId();
	String getTitle();
	String getFirstName();
	String getLastName();
	String getFullName();
	String getPostition();
	String getPhone();
	String getEmail();
	String getTimeZone();
	String getReportsTo();
	void navigateToAccessAndPermissionsTab();
	String getOperatorType();
	String getTerritory();
	void defaultSalesRepAccess();
	boolean verifyOprSalesGoalsScreen();
	boolean verifyOprAccessScreen();
	boolean verifyOprNewHarness();
	void clickNext();
	void clickFinish();
	Operator navigateOperator();
	
	
}
