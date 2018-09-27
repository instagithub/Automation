package com.pega.cs.interactions;

import java.awt.AWTException;

import com.pega.framework.PegaWebDriver;

public interface NewInboundInteraction extends Interactions{
	
	String DATE_RECEIVED_XPATH = "//input[@id='RecDate']";
	String CHANNEL_TYPE_ID = "ChannelType";
	String ACCOUNT_NUMBER_ID = "SearchAccountNumber";
	String CONTACT_ID = "SearchContactId";
	String BROWSE_PATH_ID = "$PpyWorkPage$ppyTemplateInputBox";
	String DESC_ID = "pyNote";
	String INTERACTION_ID_XPATH = "//div[@class='field-item dataValueRead']/span[contains(text(), 'I-')]";
	String CLOSE_BUTTON_XPATH = "//div[@class='pzbtn-mid' and text()='Close']";
//	String WORKBASKET_LINK_XPATH = "//h3[text()='My workbaskets']";
	String WORKBASKET_INBOUND_ID = "PropertyForParameters";
	String INBOUND_CASE_XPATH = "//a[text()='#id#']";
	String CLOSE_THIS_BUTTON_XPATH = "//div[text()='Confirm']/ancestor::button[@title='Close this item']";
	String SEARCHCASE_SUBMIT_XPATH = "//button[@class='Strong pzhc' and @title='Complete this assignment']";
	String URL = "https://www.pega.com/system/files/docs/2016/Oct/Pega-Customer-Service-Application-Data-Sheet.pdf";
	String LINK_TEXT =	"Pega Link";
	
	String createInboundCase(String channelType, String accNum, String contactId) throws AWTException;
	void searchInboundCase(String interactionID);
	void clickSendCorrespondanceFromNextBestAction();
	void configureEmailAndSend();
	void verifyStatusAndConfirmTask(PegaWebDriver pegaWebDriver);
	String createInboundCaseOnlyMandatoryFields();
	void searchAgain();
	void attachURL();
	void createInboundCaseWithoutmandatoryFields();
	void inboundCaseWithFutureDate(String channelType);
		
}
