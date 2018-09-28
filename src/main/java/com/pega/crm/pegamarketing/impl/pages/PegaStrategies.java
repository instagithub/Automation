package pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import pegamarketing.impl.rules.PegaMarketingStrategy;
import pegamarketing.pages.Strategies;
import pegamarketing.rules.MarketingStrategy;

import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class PegaStrategies extends PegaLandingPage implements Strategies {

	public PegaStrategies(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public MarketingStrategy createStrategyViaGuideMeThroughIt() {
		findElement(CREATE_BUTTON).click();
		findElement(GUIDE_ME_THROUGH_IT).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		MarketingStrategy strategy = new PegaMarketingStrategy(frameId, testEnv);
		return strategy;
	}
}