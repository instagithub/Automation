package com.pega.pm.pages;

import com.pega.TestEnvironment;
import com.pega.pm.rules.MarketingStrategy;
import com.pega.pm.rules.PegaMarketingStrategy;

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