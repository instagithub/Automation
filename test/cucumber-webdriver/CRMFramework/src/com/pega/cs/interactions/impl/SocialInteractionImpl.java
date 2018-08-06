package com.pega.cs.interactions.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import com.pega.cs.interactions.SocialInteraction;

import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;
import com.pega.sync.WaitForDocStateReady;
import com.pega.cs.utils.CommonMethods;

public class SocialInteractionImpl extends InteractionsImpl implements SocialInteraction{
	
	public String frameId = null;
	public Wizard newWizard = null;
	public CommonMethods commonMethod = null;
	
	public SocialInteractionImpl(WebElement elmt, String frameId) {
		super(elmt, frameId);
		// TODO Auto-generated constructor stub
	}
	
	public SocialInteractionImpl(WebElement elmt) {
		super(elmt);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String reply() {
		commonMethod = new CommonMethods(pegaDriver);
		pegaDriver.switchTo().defaultContent();
		PegaWebElement responseAreaWebElement = pegaDriver.findElement(By.xpath(RESPONSE_TEXTBOX_XPATH));
		responseAreaWebElement.click();
		
		String responseAreaText = responseAreaWebElement.getText();
		
		String replyText = responseAreaText+" This is a test reply from CSR " + commonMethod.getCurrentTime();
		replyText = replyText.trim();
		responseAreaWebElement.clear();
		responseAreaWebElement.sendKeys(replyText);
//		String csrReplyText = replyText;
		
		responseAreaWebElement.click();
		
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchTo().defaultContent();
		
		PegaWebElement replyButton = pegaDriver.findElement(By.xpath(REPLY_BUTTON_XPATH));
		replyButton.click();
//		pegaDriver.verifyElement(By.xpath(""));
		
		return replyText;
		
	}

	@Override
	public void reassigncase(String reassignType, String reassignTo) {
		
		pegaDriver.switchTo().defaultContent();
		PegaWebElement moreActionsWebElement = pegaDriver.findElement(By.xpath(MOREACTIONS_XPATH));
		moreActionsWebElement.click();
		PegaWebElement reassignWebElement = pegaDriver.findElement(By.xpath(REASSIGN_XPATH));
		reassignWebElement.click(false);
//		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		
		String finalXpath =  new String(REASSIGNTO_XPATH).replace("#status#", reassignType);
		  PegaWebElement rdbutton = pegaDriver.findElement(By.xpath(finalXpath));
		  rdbutton.click();
		  
		  pegaDriver.switchTo().defaultContent();
		  
		  if(reassignType.equalsIgnoreCase("operator"))
			  pegaDriver.findElement(By.xpath(REASSIGNOP_TEXTBOX_XPATH)).sendKeys(reassignTo);
		  else if(reassignType.equalsIgnoreCase("workbasket"))
			  pegaDriver.findElement(By.xpath(REASSIGNWB_TEXTBOX_XPATH)).sendKeys(reassignTo);
		
		  pegaDriver.waitForDocStateReady(2);
		  pegaDriver.switchTo().defaultContent();
		  
		PegaWebElement reassignButtonWebElement = pegaDriver.findElement(By.xpath(REASSIGN_BUTTON_XPATH));
		reassignButtonWebElement.click();
		
		pegaDriver.waitForDocStateReady(10);
		
	}

	@Override
	public void escalatecase(String escalateTo) {
		
		PegaWebElement moreActionsWebElement = pegaDriver.findElement(By.xpath(MOREACTIONS_XPATH));
		moreActionsWebElement.click();
		PegaWebElement EscalateWebElement = pegaDriver.findElement(By.xpath(ESCALATE_XPATH));
		EscalateWebElement.click(false);
		
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
//		frameId = pegaDriver.getActiveFrameId(false);
//		newWizard  = pegaDriver.findWizard(frameId);
//		pegaDriver.waitForDocStateReady(2);
		DropDown reasonDropdown = pegaDriver.findSelectBox(By.xpath(ESCALATETO_DROPDOWN_XPATH));
		reasonDropdown.selectByVisibleText(escalateTo);
		pegaDriver.switchTo().defaultContent();
		if(escalateTo.equalsIgnoreCase("Work basket"))
			pegaDriver.findElement(By.xpath(ESCALATE_WB_XPATH)).sendKeys("SocialWB");
		
		pegaDriver.switchTo().defaultContent();
		
		PegaWebElement escalateButtonWebElement = pegaDriver.findElement(By.xpath(ESCALATE_BUTTON_XPATH));
		escalateButtonWebElement.click();
		
		pegaDriver.waitForDocStateReady(10);
		
		
	}

	@Override
	public void wrapUpInteraction(String status,String reason) {
			
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(2);
		
		PegaWebElement wrapupButtonWebElement = newWizard.findElement(By.xpath(WRAPUP_BUTTON_XPATH));
		wrapupButtonWebElement.click();
		
		pegaDriver.waitForDocStateReady(2);
		
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		
		DropDown statusDropdown = newWizard.findSelectBox(By.xpath(STATUS_DROPDOWN_XPATH));
		statusDropdown.selectByValue(status);
		
		DropDown reasonDropdown = newWizard.findSelectBox(By.xpath(REASONFORINTERACTION_DROPDOWN_XPATH));
		reasonDropdown.selectByVisibleText(reason);
		
		PegaWebElement submitButtonWebElement = newWizard.findElement(By.xpath(SUBMIT_BUTTON_XPATH));
		submitButtonWebElement.click(false);	  
		
		pegaDriver.waitForDocStateReady(10);
	}

	@Override
	public void validateCaseWrappedUp(String status) {
		
		 pegaDriver.switchTo().defaultContent();
		 
		 pegaDriver.findElement(By.xpath(SOCIAL_CASES_XPATH)).click();
		 
		 if(status.equalsIgnoreCase("Resolved"))
		 {
			 PegaWebElement tabElement = pegaDriver.findElement(By.xpath(RESOLVEDTAB_XPATH));
			 tabElement.click();
		 }
		 else if (status.equalsIgnoreCase("dismissed"))
		 {
			 PegaWebElement tabElement = pegaDriver.findElement(By.xpath(DISMISSEDTAB_XPATH));
			 tabElement.click();
		 }
		 
		 

		
		
	}

	@Override
	public void selectReplyAs(String replyHandle) {
		
		
		replyHandle= new String(replyHandle).replace("@", "");
		replyHandle = replyHandle.trim();
		DropDown replyAsDropdown = pegaDriver.findSelectBox(By.xpath(REPLYAS_DROPDOWN_XPATH));
		replyAsDropdown.selectByVisibleText(replyHandle);
		
	}

	@Override
	public void retweet(String customertweetText) {
		
		
	}

	
	

	


}
