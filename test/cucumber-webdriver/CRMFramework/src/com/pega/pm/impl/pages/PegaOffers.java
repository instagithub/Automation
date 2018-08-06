package com.pega.pm.pages;

import com.pega.TestEnvironment;
import com.pega.pm.rules.Offer;
import com.pega.pm.rules.PegaOffer;

public class PegaOffers extends PegaLandingPage implements Offers {

	public PegaOffers(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public Offer create() {
		findElement(CREATE_BUTTON).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		Offer offer = new PegaOffer(frameId, testEnv);
		return offer;
	}
}
