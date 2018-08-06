package com.pega.pm.pages;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;

public class PegaUnsubscribedCustomers implements UnsubscribedCustomers {
	TestEnvironment testEnv;
	String frameID;
	PegaWebDriver pegaDriver;
	public PegaUnsubscribedCustomers(String frameID, TestEnvironment testEnv) {
	this.frameID = frameID;
	this.testEnv = testEnv;
	pegaDriver= testEnv.getPegaDriver();
	}
	@Override
	public void refreshReports() {
		pegaDriver.findElement(REFRESH_BUTTON).click();
		pegaDriver.waitForDocStateReady();
	}
	@Override
	public SubscriptionReportDrillDown drillDownNotIntrestedReport() {
		pegaDriver.findElement(NOT_INTRESTED_COUNT).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		SubscriptionReportDrillDown subscriptionDrillDown =  new PegaSubscriptionReportDrillDown(frameId, testEnv);
		return subscriptionDrillDown;
	}
	public class PegaSubscriptionReportDrillDown implements SubscriptionReportDrillDown{
		String frameID;
		TestEnvironment testEnv;
		public PegaSubscriptionReportDrillDown(String frameID, TestEnvironment testEnv) {
			this.frameID = frameID;
			this.testEnv = testEnv;
		}
				
	}
}
