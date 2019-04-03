package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Pulse;
import com.pega.ri.WizardImpl;

public class PegaPulse extends WizardImpl implements Pulse{
	
	public PegaPulse(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	String FOLLOWING_SECTION_XPATH="//h2[contains(text(),'Following')]";
	String SALES_COACH_WIDGET_XPATH="//h2[contains(text(),'Coaching plans')]";
	String FOLLOWERS_SECTION_XPATH="//h2[contains(text(),'Followers')]";
	String FILTER_BUTTON_XPATH="//button[@title='Filter']";
	String PULSE_TEXTAREA_ID="pyMessage";
	String PULSE_POST_BUTTON_XPATH=PegaUtil.getButtonXpath("Post");
	String PULSE_FIRST_POST_XPATH="(//div[@data-node-id='pyPostDetails']//div[@class='pulse-display-post'])[1]";

	@Override
	public void enterCommentsinPulse(String pulseComment) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PULSE_TEXTAREA_ID)).sendKeys(pulseComment);
	}

	@Override
	public void clickPost() {
		pegaDriver.findElement(By.xpath(PULSE_POST_BUTTON_XPATH)).click();
	}
	@Override
	public boolean isFollowingSectionDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(FOLLOWING_SECTION_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isFollowersSectionDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(FOLLOWERS_SECTION_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isFilterButtonDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(FILTER_BUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public String getFirstPulsePost() {
		pegaDriver.getActiveFrameId(true);
		return(pegaDriver.findElement(By.xpath(PULSE_FIRST_POST_XPATH)).getText());
	}

	@Override
	public boolean isSalesCoachWidgetDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(SALES_COACH_WIDGET_XPATH)).isVisible();
		return b;
	}
}
