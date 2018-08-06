package com.pega.cs;

import org.openqa.selenium.By;

import com.pega.cs.tiles.LeftNav;
import com.pega.cs.tiles.TopNav;
import com.pega.framework.PegaWebElement;
import com.pega.page.Portal;

public interface SocialPortal extends Portal{

	String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	String VERSION = "$Id: CSPortalImpl.java 117333 2015-06-18 09:12:21Z MuraliKondapally $";
	String WL_Refresh_XPATH = "//i[contains(@title,'Refresh my cases')]";
	String WO_CustomerName_XPATH = "(//table[@pl_prop_class='Assign-Worklist']/tbody/tr[2]/descendant::a[contains(@class,'CSSocial_MyCasesCustomerLink_Bold')][contains(text(),'#customername#')])[1]";
	String WO_Status_XPATH = "(//table[@pl_prop_class='Assign-Worklist']/tbody/tr[2]/descendant::button[contains(@data-click,'openAssignment')]/descendant::div[contains(text(), '#wostatus#')])[1]";
	String WO_Time_XPATH = "(//table[@pl_prop_class='Assign-Worklist']/tbody/tr[2]/descendant::span[contains(@class,'cssocial_timelinedate')])[1]";
	String OPEN_RESPONSE_AREA ="//div[contains(@title,'Disclose Response')]/i[contains(@class,'icon-openclose')]";
	String RESPONSE_AREA = "//textarea[contains(@id,'SocialMediaResponse')]";
	String TWEET_REPLY = "//button[contains(@name,'CPMSocialResponseActions')]/descendant::div[contains(text(),'Reply')]";
	String CASE_STATUS = "(//div[contains(@class, 'cssocialStdTextBold')])[1]";
	String CLOSE_CASE = "//i[contains(@data-click,'ResetSocialPaneDefaults')]";
//	String WO_TEXT_XPATH = "//tr[@id='$PD_GetOpenSocialCasesFromWorklist$ppxResults$l#rowcount#']/descendant::div[contains(@class,'cssocial_mycaseshighlight')]/descendant::span[contains(@class,'cssocial_leftnav_content_bold')]";
	
	String OPERATORID_XPATH = "//i[@data-test-id='px-opr-image-ctrl']";
	String LOGOUT = "//span[text()='Log off']";
	String PREFERENCES_XPATH = "//span[text()='Preferences']";
	String launchOAuth = "//a[contains(text(),'#source#')]";
	String OAUTH_ID = "OAuthClient";
	String AUTHORIZE_BUTTON_XPATH = "//button[text()='  Authorize ']";
	String AUTHORIZE_TW_USER_ID = "username_or_email";
	String AUTHORIZE_TW_PWD_ID = "password";
	String AUTHORIZE_APP_ID = "allow";
	String SAVE_BUTTON_XPATH = "//div[contains(text(),'Save')]";
	String PREF_IFRAME_NAME = "UserPreferenceData";
	String TW_AUTHTEXT_XPATH = "//div[contains(@node_name,'TwitterAuthorization')]/descendant::div[@class='field-item dataLabelWrite heading_2_dataLabelWrite']";
	String FB_AUTHTEXT_XPATH = "//div[contains(@pyclassname,'PegaFW-Admin-Authorization-Facebook')]/descendant::div[@class='field-item dataLabelWrite heading_2_dataLabelWrite']";
	
	
	String AUTHTEXT_XPATH = "//div[contains(@pyclassname,'PegaFW-Admin-Authorization-#source#')]/descendant::div[@class='field-item dataLabelWrite heading_2_dataLabelWrite']";
	String AUTHORIZE_FB_USER_ID = "//input[@id='email']";
	String AUTHORIZE_FB_PWD_ID = "//input[@id='pass']";
	String AUTHORIZE_LOGIN_ID = "//button[@id='loginbutton']";
	String REPLYAS_DROPDOWN_ID = "ReplyAsAuthorHandles";
	
	
	
	
	void refreshWorklist();
//	boolean checkCase(String caseStatus, String customerName );
	void launchCase();
	String reply();
	void closeCase();
	void logout();
	void launchPreferences();
	void refreshPortal();
	void authorizeCSR(String source, String userID, String pwd );
	void verifyResponseText();
	boolean launchSocialCase(String source, String customerName, String text);
	void selectReplyAs(String replyHandle);
	

	
	
	
	
}
