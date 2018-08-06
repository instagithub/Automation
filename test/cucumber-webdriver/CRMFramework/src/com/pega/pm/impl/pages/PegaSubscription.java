package com.pega.pm.pages;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;

public class PegaSubscription implements Subscription {
	TestEnvironment testEnv;
	PegaWebDriver pegaDriver;
	public PegaSubscription(TestEnvironment testEnv) {
			this.testEnv = testEnv;
			pegaDriver = testEnv.getPegaDriver();
		}
	@Override
	public void unsubscribe() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("MarketingMicrositeIfr");
		pegaDriver.handleWaits().sleep(10);
		//pegaDriver.waitForDocStateReady(2);
		pegaDriver.findElement(NOT_INTRESTED_RADIO_BUTTON).click(false);
		pegaDriver.findElement(UNSUBSCRIBE_BUTTON).click();
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("MarketingMicrositeIfr");
	}
	@Override
	public void closeSubscription() {
		pegaDriver.close();
	}
}
