package com.pega.pm.impl.pages;

import com.pega.TestEnvironment;
import com.pega.pm.impl.rules.PegaOffer;
import com.pega.pm.pages.Offers;
import com.pega.pm.rules.Offer;

public class PegaOffers extends PegaLandingPage implements Offers {

	public PegaOffers(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public Offer create() {
		findElement(CREATE_BUTTON).click();
		findElement(CREATE_OFFER).click(); 
		String frameId = pegaDriver.getActiveFrameId(true);
		Offer offer = new PegaOffer(frameId, testEnv);
		return offer;
	}
}
