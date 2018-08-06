package com.pega.cs.interactions.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.cs.interactions.CTI;
import com.pega.cs.interactions.Interactions;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;

public class CTIImpl extends WizardImpl implements CTI{
	
	public String frameId = null;
	public Wizard newWizard = null;
	String PEGACALL_CALL_OPTION_XPATH = "//td[text()='#newoption#']";
	private static final String CTI_IMPL_OPERATOR_MENU_XPATH = "//div[@class='field-item dataValueWrite']/span/a[contains(text(),'Murali')]";
	private static final String CTI_IMPL_LOG_OFF_XPATH = "//td[@class='middleBack' and text()='Logout']";
	
	boolean pop = false;

	public boolean isPop() {
		return pop;
	}

	public void setPop(boolean pop) {
		this.pop = pop;
	}

	public CTIImpl(WebElement elmt) {
		super(elmt);
	}
	
	public CTIImpl(WebElement elmt, String frameId) {
		super(elmt, frameId);
	}

	@Override
	public void agentLogout() {
		
			pegaDriver.waitForDocStateReady(2);
	        pegaDriver.switchTo().defaultContent();
	        pegaDriver.findElement(By.xpath(CTI_IMPL_OPERATOR_MENU_XPATH)).click();
	        pegaDriver.switchTo().defaultContent();
	        pegaDriver.findElement(By.xpath(CTI_IMPL_LOG_OFF_XPATH)).click(false);
	        pegaDriver.handleWaits().waitForAlert();
			pegaDriver.switchTo().alert().accept();
		
		
		
	}

	@Override
	public void changeCallLogionOption(String option) {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//button[contains(@data-click, 'AgentAvailabilityCall')]//img[contains(@src,'pxmenubuttonarrowwhite')]"))
		.click();
		String finalXPath = new String(PEGACALL_CALL_OPTION_XPATH).replace("#newoption#", option);
		PegaWebElement status = pegaDriver.findElement(By.xpath(finalXPath));
		status.click();
		
	}

	@Override
	public void acceptCall() {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Accept']")).click();
		
	}

	@Override
	public void answerCall() {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//button[@title='Phone Line 1, Incoming call']")).click();
		
	}
	
	
	

}
