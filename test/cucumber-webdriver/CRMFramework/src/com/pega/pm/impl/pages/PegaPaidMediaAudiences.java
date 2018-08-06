package com.pega.pm.pages;

import com.pega.TestEnvironment;

public class PegaPaidMediaAudiences extends PegaLandingPage implements PaidMediaAudiences {
	
	public PegaPaidMediaAudiences(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public void searchAudienceByName(String audienceName) {
		pegaDriver.handleWaits().waitForElementVisibility(SEARCH_INPUT_BOX);
		findElement(SEARCH_INPUT_BOX).sendKeys(audienceName);
		findElement(VIEW_BUTTON_LINK).click();
	}
	
	public String verifyPaidAudiencePg() {
		pegaDriver.waitForDocStateReady();
		pegaDriver.findElement(PAIDMEDIA_AUDIENCES_PATH);
		String landingPageName = findElement(PAIDMEDIA_AUDIENCES_PATH).getText();
		return landingPageName;
	}
}
