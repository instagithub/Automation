package com.pega.crm.pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.impl.rules.PegaRuleInstance;
import com.pega.crm.pegamarketing.pages.UnsubscribedCustomers;
import com.pega.framework.PegaWebDriver;

//
public class PegaUnsubscribedCustomers extends PegaRuleInstance implements UnsubscribedCustomers {
	TestEnvironment testEnv;
	String frameID;
	PegaWebDriver pegaDriver;
	public PegaUnsubscribedCustomers(String frameID, TestEnvironment testEnv) {
	super(frameID, testEnv);
	this.frameID = frameID;
	this.testEnv = testEnv;
	pegaDriver= testEnv.getPegaDriver();
	}
	@Override
	public void refreshReports() {
		findElement(REFRESH_BUTTON).click();
		pegaDriver.waitForDocStateReady();
	}
	@Override
	public SubscriptionReportDrillDown drillDownNotIntrestedReport() {
		findElement(NOT_INTRESTED_COUNT).click();
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
