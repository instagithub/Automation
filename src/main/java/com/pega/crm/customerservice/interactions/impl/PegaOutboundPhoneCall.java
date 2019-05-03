package com.pega.crm.customerservice.interactions.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.interactions.OutboundPhoneCall;
import com.pega.crm.customerservice.utils.CommonMethods;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;

public class PegaOutboundPhoneCall extends PegaInteractions implements OutboundPhoneCall {

	public PegaOutboundPhoneCall(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
		commonMethods = new CommonMethods(pegaDriver);
		}
	public String frameId = null;
	public Wizard newWizard = null;
	public CommonMethods commonMethods = null;
	

	@Override
	public void CaptureCallReasonAndPlaceCall(String reason, String status) {
		  
		  frameId = pegaDriver.getActiveFrameId(false);
		  newWizard  = pegaDriver.findWizard(frameId);
		  pegaDriver.waitForDocStateReady(2);
		  DropDown reasonDropdown = newWizard.findSelectBox(By.xpath(OUTBOUND_REASON_XPATH));
		  reasonDropdown.selectByValue(reason);
		  pegaDriver.waitForDocStateReady(2);
		  String finalXpath =  new String(OUTBOUND_STATUS_XPATH).replace("#status#", status);
		  PegaWebElement rdbutton = newWizard.findElement(By.xpath(finalXpath));
		  rdbutton.click();
		  pegaDriver.waitForDocStateReady(3);
		  PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		  submitButton.click(false);
		
		  	
	}
	
	
	public void exitInteraction(String exitComments)
	{
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		newWizard.findElement(By.xpath(EXITCOMMENT_TEXTAREA_XPATH)).sendKeys(exitComments);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		
	}
	
	public void launchOutboundWrapUp()
	{
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement wrapUp = newWizard.findElement(By.xpath(OUTBOUND_WRAP_UP_XPATH));
		wrapUp.click();
	}
	
	
	
	public void launchOutboundInteractionforFirst(String contactName, String callStatus)
	{
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		String custName;
		String phType;
		
		PegaWebElement outboundCallTable = pegaDriver.findElement(By.xpath(OUTBOUND_SIMULATION_TABLE_XPATH));
		int outboundCallRows = outboundCallTable.findElements(By.tagName("tr")).size();
		System.out.println(outboundCallRows);
		for(int i=2; i <= outboundCallRows; i++)
		{
			custName = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/descendant::tr["+i+"]/td[1]/div/span")).getText();
			System.out.println(custName);
			phType = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'D_ContactsCommsByAccountNumber')]/descendant::tr["+i+"]/td[4]/div/span")).getText();
			System.out.println(phType);
			DropDown callStatusDropdown = newWizard.findSelectBox(By.xpath("//select[contains(@name,'l"+(i-1)+"$pOutboundCallStatus')]"));
			if (custName.equalsIgnoreCase(contactName) && phType.equalsIgnoreCase("Business Phone"))
			{
				callStatusDropdown.selectByValue(callStatus);
			}
			if (custName.equalsIgnoreCase(contactName) && (phType.equalsIgnoreCase("Home Phone")||phType.equalsIgnoreCase("HOM")))
			{
				System.out.println("IN IF loop");
				callStatusDropdown.selectByValue(callStatus);
			}
			
			if  (custName.equalsIgnoreCase(contactName) && (phType.equalsIgnoreCase("Mobile Phone")||phType.equalsIgnoreCase("MOB")))
			{
				System.out.println("IN IF loop");
				callStatusDropdown.selectByValue(callStatus);
			}
			
		}
		
		
	}

	

	public void submitChanges(){
	
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		  submitButton.click(false);
		 
	}
	

	
	
	

	
}
