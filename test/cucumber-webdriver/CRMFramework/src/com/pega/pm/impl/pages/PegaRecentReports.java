package com.pega.pm.pages;

import com.pega.TestEnvironment;

public class PegaRecentReports extends PegaLandingPage implements RecentReports {

	public PegaRecentReports(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
		}

	@Override
	public UnsubscribedCustomers openUnsubsribedCustomersReport() {
		findElement(UNSUBSCRIBED_CUSTOMERS_LINK).click();
		findElement(LAST30DAYSREPORTLINK).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		UnsubscribedCustomers unsubscribedCustomers =  new PegaUnsubscribedCustomers(frameId, testEnv);
		return unsubscribedCustomers;
	}

}
