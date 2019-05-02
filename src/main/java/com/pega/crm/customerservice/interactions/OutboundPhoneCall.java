package com.pega.crm.customerservice.interactions;

import java.util.Map;

import com.pega.framework.PegaWebDriver;

public interface OutboundPhoneCall extends Interactions{

	/*String OUTBOUND_REASON_ID = "OutboundCallReason";
	String OUTBOUND_STATUS_XPATH = "//label[contains(text(),'#status#')]"*/;
	String EXITCOMMENT_TEXTAREA_XPATH = "//textarea[@data-test-id='2015070207425705881733']";
	String OUTBOUND_WRAP_UP_XPATH = "//button[@title = 'Wrap Up']";
	
	String OUTBOUND_SIMULATION_TABLE_XPATH = "//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/tbody";
	String OUTBOUND_CONTACT_NAME = "//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/descendant::tr['#iValue#']/td[1]/div/span";
	
	void CaptureCallReasonAndPlaceCall(String reason, String status);
	void exitInteraction(String exitComments);
	void launchOutboundWrapUp();
	void launchOutboundInteractionforSecond(String contactName, String callStatus);
	void launchOutboundInteractionforFirst(String contactName, String callStatus);
	void submitChanges();
	void CaptureCallReasonAndPlaceCallWithoutSubmit(String reason, String status);
	void submitoutboundverificationchanges();
	
	

	
}
