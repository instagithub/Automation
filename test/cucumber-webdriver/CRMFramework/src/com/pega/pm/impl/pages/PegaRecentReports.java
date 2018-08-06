package com.pega.pm.impl.pages;

import com.pega.TestEnvironment;
import com.pega.pm.pages.RecentReports;
import com.pega.pm.pages.UnsubscribedCustomers;

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
