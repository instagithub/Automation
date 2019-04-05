package com.pega.crm.pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import com.pega.TestEnvironmentImpl;
import com.pega.crm.pegamarketing.pages.Microsites;
import com.pega.crm.pegamarketing.pages.Subscription;

public class PegaMicrosites extends PegaLandingPage implements Microsites {

	private String uRLPort;

	public PegaMicrosites(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	@Override
	public Subscription launchMicrositeURL(String micrositeURL) {
		TestEnvironment t1 = new TestEnvironmentImpl();
		pegaDriver = t1.getPegaDriver();
		uRLPort = t1.getConfiguration().getURL();
		uRLPort = uRLPort.replace("/prweb", "");
		//System.out.println("***URL POrt is :" +uRLPort);
		micrositeURL = micrositeURL.replace("*****", uRLPort);
		System.out.println("*** URL Is: " +micrositeURL);
		pegaDriver.get(micrositeURL);
		pegaDriver.handleWaits().waitTillTitleContains("Subscription");
		pegaDriver.waitForDocStateReady(4);
			return new PegaSubscription(micrositeURL, t1);
		}

}
