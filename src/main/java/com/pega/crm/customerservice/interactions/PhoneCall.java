package com.pega.crm.customerservice.interactions;

import java.util.Map;

import com.pega.framework.PegaWebDriver;

public interface PhoneCall extends Interactions{
	
	//String LAST_NAME_ID = "SearchStringLastName";
//	String SEARCH_RESULT_ID = "$PD_Search_Customer$ppxResults$l1";
//	String CONTACT_RESULT_SUBMIT_XPATH = "//button[@title='Complete this assignment']";
	String ACCOUNT_VALUE_XPATH = "//tr[contains(@oaargs, '#accounNumber#')]";
	
//	String 	CONTACT_VERIFICATION_1_ID = "IsSecurityQuestionVerified1";
//	String 	CONTACT_VERIFICATION_2_ID = "IsSecurityQuestionVerified2";
//	String  ACCOUNT_NO_ID ="SearchStringAcctNum";
	String SEARCH_PHONE_NUMBER = "SearchStringPhone";
	String SEARCH_SSN_ID= "SearchStringSSN";
	String SEARCH_CASEID_ID = "SearchStringWorkID";
	String BU_NAME_XPATH = "//input[@id='BusinessUnitName4']"; 
	String  BU_NAME_ID ="SearchStringBUName";
	String SEARCH_EMAIL_ID = "SearchStringEmail";
	String BU_CONTACT_NAME_XPATH = "//span[contains(text(),'Anne')]/../../.."; 

	String CONTACT_NAME_ID="SearchStringLastName";
	String NUMBER_ID="SearchStringAcctNum";

	//Search results for connor
	String CONNOR_LASTNAME= "//span[text()='Connor']";
	String CONNOR_FIRSTNAME="//span[text()='Sara']";
	String CONNOR_CITY= "//span[text()='Cambridge' or text()='LA']";
	String CONNOR_STATE= "//span[text()='MA' or text()='AK']";
	
	String UNKNOWN_CUSTOMER_XPATH = "//div[text()='Unknown customer']";
	String DIALOG_ID= "//div[@id='DialogContent']";
	String LAST_INTERACTION_XPATH= "//span[text()='Last interaction']";
	String REASON_XPATH = "//span[text()='Reason']";
	String STATUS_XPATH = "//span[text()='Status']";
	String NPS_XPATH = "//span[contains(text(),'NPS')]";
	String CONTACT_INFO_XPATH = "//div[text()='Contact information']";
	String CALL_BACK_XPATH = "//span[text()='Call back']";
	String CALL1_BACK_XPATH = "//span[text()='Callback']";
	String PHONE_XPATH = "//span[text()='Phone']";
	String EMAIL_XPATH = "//span[text()='Email']";
	String ADDRESS_XPATH = "//span[text()='Address']";
	
	String CUSTOMER_SUMMARY_XPATH = "//div[text()='CUSTOMER SUMMARY']";
	String ACTIVE_ACCOUNTS_XPATH ="//span[text()='Active accounts']";
	String OPEN_CASES_XPATH ="//span[text()='Open cases']";
	String COMMUNICATION_PREF_XPATH ="//span[text()='Communication preference']";
	
	String RELATIONSHIP_XPATH = "//div[text()='Relationship']";
	String LIFETIME_XPATH = "//span[text()='Lifetime value']";
	String CHURN_RISK_XPATH = "//span[text()='Churn risk']";
	String NPS_TREND_XPATH = "//span[text()='NPS trend']";
	String CUSTOMER_SINCE_XPATH = "//span[text()='Customer since']";
	String ADDTASK_XPATH = "//button[@title='Add Task']";
	String WRAP_UP_XPATH = "//button[@title='Wrap Up']";
	String CONTACT_VERIFICATION_XPATH = "//span[text()='Verify contact']";
	String OTHER_ACTIONS_XPATH = "//button[@title='Other actions']";
	
	String REFRESH_XPATH = "//span[text()='Refresh']";
	String CONT_NOT_VERF_XPATH = "//span[text()='Contact not verified']";
	String CALLBACK_XPATH = "//span[text()='Callback']";
	String EXIT_INTE_XPATH = "//span[text()='Exit interaction']";
	
	String ORG_SUMMARY_XPATH ="//div[text()='ORGANIZATION SUMMARY']";
	String ORG_TYPE_XPATH ="//span[text()='Organization type']";
	String TOTAL_REV_XPATH ="//span[text()='Total revenue']";
	String INDUSTRY_XPATH ="//span[text()='Industry']";
	String WEBSITE_XPATH ="//span[text()='Website']";
	
	String ACME_TECH_XPATH ="//span[text()='Acme Technology Group']";
	String ACE_ANVILS_XPATH ="//span[text()='Acme Anvils']";
	String ACME_PARA_XPATH ="//span[text()='Acme Parachutes']";
	String ACME_ROBO_XPATH ="//span[text()='Acme Robots']";
	String ACME_SOFTWARE_XPATH ="//span[text()='Acme Software']";
	String SELECT_CONTACT_XPATH ="//span[text()='Select a contact']";
	String WHERE_AM_I_XPATH = "//span[text()='Where am I']";
	String SEARCH_AGAIN_XPATH = "//span[text()='Search again']";
	String CANCEL_WORK_XPATH ="//span[text()='Cancel this work']";
	String HISTORY_ATTACHMENTS_XPATH ="//span[text()='History and Attachments']";
	String PULSE_XPATH ="//span[text()='Pulse']";
	
	String SEARCH_XPATH = "//h6[@class='layout-group-item-title' and contains(text(),'Search')]";
	String GENERAL_ASSISTANCE_XPATH = "//h6[@class='layout-group-item-title' and contains(text(),'General assistance')]";
	String ADD_NEW_CUSTOMER_XPATH = "//h6[@class='layout-group-item-title' and contains(text(),'New customer')]";
	String ADD_NEW_ACCOUNT_ASSOCIATION_XPATH = "//a[@title='Add New Account Association ']";
	
	
	
	void accountSelection(String accountNum);
	
	
	void launchServiceProcess(String serviceProcess);

	void confirmAddressChange();

	String verifyCompletedTask(String serviceProcess);
	
	

	void closeAccount(String reason, String comment);
	

	
	void searchByEmail(String email);
	void scheduleActivity(String type, String account, String topic, String assign, String operator);

}
