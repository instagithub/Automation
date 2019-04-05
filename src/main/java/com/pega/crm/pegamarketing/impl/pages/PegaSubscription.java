package com.pega.crm.pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.pages.Subscription;
import com.pega.framework.PegaWebDriver;

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
		pegaDriver.switchTo().defaultContent();
		findFrame("MarketingMicrositeIfr");
		pegaDriver.handleWaits().sleep(10);
		findElement(NOT_INTRESTED_RADIO_BUTTON).click(false);
		findElement(UNSUBSCRIBE_BUTTON).click();
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		findFrame("MarketingMicrositeIfr");
	}
	@Override
	public void closeSubscription() {
		pegaDriver.close();
	}
}
