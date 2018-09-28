package pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import pegamarketing.impl.rules.PegaOffer;
import pegamarketing.pages.Offers;
import pegamarketing.rules.Offer;

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
