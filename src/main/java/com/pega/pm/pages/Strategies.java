package com.pega.pm.pages;

import org.openqa.selenium.By;

import com.pega.pm.rules.MarketingStrategy;

public interface Strategies extends LandingPage {

	By GUIDE_ME_THROUGH_IT  = By.xpath("//span[text()='Guide me through it']");
	
	/**
	 * this is used for creating a strategy via Guide me through it
	 * @return it will return Marketing strategy page
	 */
	MarketingStrategy createStrategyViaGuideMeThroughIt();
	
	
	
}