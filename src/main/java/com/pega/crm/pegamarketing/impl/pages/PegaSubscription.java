package com.pega.crm.pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.pages.Subscription;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.elmt.Frame;

public class PegaSubscription extends PegaLandingPage  implements Subscription{
	
	TestEnvironment testEnv;
	PegaWebDriver pegaDriver;
	public PegaSubscription(String frameID, TestEnvironment testEnv) {
			super(frameID, testEnv);
			this.testEnv = testEnv;
			pegaDriver = testEnv.getPegaDriver();
		}
	@Override
	public void unsubscribe() {
		Frame frame = pegaDriver.findFrame("MarketingMicrositeIfr");
		pegaDriver.handleWaits().sleep(10);
		frame.findElement(NOT_INTRESTED_RADIO_BUTTON).click();
		frame.findElement(UNSUBSCRIBE_BUTTON).click();		
		pegaDriver.findFrame("MarketingMicrositeIfr");
	}
	@Override
	public void closeSubscription() {
		pegaDriver.close();
	}
}
