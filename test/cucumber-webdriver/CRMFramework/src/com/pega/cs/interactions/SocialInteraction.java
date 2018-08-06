package com.pega.cs.interactions;

public interface SocialInteraction extends Interactions{
	String UPDATE_CONTACT_PROFILE_XPATH = "//a[text()='Update Contact Profile' and @class='Add_task']";
	String OCCUPATION_XPATH = "//input[@id='Occupation']";
	String CLOSE_INTERACTION_XPATH = "//a[@class='Wrap_up' and text()='Close']";
	String RESPONSE_TEXTBOX_XPATH = "//textarea[contains(@id,'SocialMediaResponse')]";
	String REPLY_BUTTON_XPATH = "//button[contains(@title,'Send response')]/descendant::div[contains(text(),'Reply')]";
	
	String UNKNOWN_CUSTOMER_XPATH = "//div[contains(text(),'Unknown customer')]";
	String CUSTOMERNAME_XPATH = "//div/span[contains(@data-test-id,'20150102041453078010253')]";
	
	String TWHANDLE_XPATH = "//div/span[@data-test-id='2018013005042308012861-Label']";
	String TWHANDLE_VALUE_XPATH = "//div/span[contains(@data-test-id,'2018013005042308012861')]";
	String TWID_XPATH = "//div/span[contains(@data-test-id,'201705020725070683151764-Label')]";
	String TWID_VALUE_XPATH = "//div/span[contains(@data-test-id,'20180130035807093610515')]";
	String FOLLOWERS_XPATH = "//div/span[@data-test-id='201801300534360213497-Label']";
	String FOLLOWERS_VALUE_XPATH = "//div/span[@data-test-id='201801300534360213497']";
	String FOLLOWING_XPATH = "//div/span[contains(@data-test-id,'20180130050559007857-Label')]";
	String FOLLOWING_VALUE_XPATH = "//div/span[contains(@data-test-id,'20180130050559007857')]";
	String CASEID_XPATH = "//div/span[contains(@data-test-id,'2015081302020004297286')]";
	String CASE_STATUS_XPATH = "//div[contains(text(),'OPEN')]";
	
	String MOREACTIONS_XPATH = "//i[@title='More actions']";
	String REASSIGN_XPATH = "//span[text()='Reassign']";
	String REASSIGNTO_XPATH= "//label[text()='#status#']";
	String REASSIGNOP_TEXTBOX_XPATH = "//input[@data-test-id='20160610050439031367179']";
	String REASSIGNWB_TEXTBOX_XPATH = "//input[@data-test-id='20141219033449062365278']";
	String REASSIGN_BUTTON_XPATH = "//div[text()='Reassign']";
	
	
	String ESCALATE_XPATH =  "//span[text()='Escalate']";
	String ESCALATETO_DROPDOWN_XPATH = "//select[@data-test-id='2015040704450609211111']";
	
	String ESCALATE_WB_XPATH = "//input[@data-test-id='2015040704450609211111']";
	String ESCALATE_BUTTON_XPATH = "//div[text()='Escalate']";
	
	
	String WRAPUP_BUTTON_XPATH = "//i[@title='Wrap Up']";
	String STATUS_DROPDOWN_XPATH = "//select[@data-test-id='201509020515440814116114']";
	String REASONFORINTERACTION_DROPDOWN_XPATH = "//select[@data-test-id='201508190152080897203319'][@id='ReasonForInteraction']";
		
	
	String SOCIALCASE_ICON_XPATH = "//i[contains(@title,'View social cases')]";
//	String RESOLVEDTAB_XPATH = "//div[@data-test-id='201801050055120825']";
	String RESOLVEDTAB_XPATH = "//h3[contains(text(),'Resolved')]";
//	String DISMISSEDTAB_XPATH = "//div[@data-test-id='201801050055120914']";
	String DISMISSEDTAB_XPATH = "//h3[contains(text(),'Dismissed')]";
	String REPLYAS_DROPDOWN_XPATH = "//select[@data-test-id='20150512063131015753498']";
	
	String SOCIAL_CASES_XPATH = "//i[contains(@title,'View social cases')]";
	
//	public void searchCaseStatus(String searchType, String value);
	String reply();

	void reassigncase(String reassignType,String reassignTo);
	void escalatecase(String escalateTo);
	void wrapUpInteraction(String status,String reason);

	void validateCaseWrappedUp(String status);

	void selectReplyAs(String replyAsHandle);

	void retweet(String customertweetText);

	

	
	

}
