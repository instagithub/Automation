package com.pega.pm.pages;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebElement;
import com.pega.pm.rules.PegaRuleInstance;

public class PegaServiceRestInstance extends PegaRuleInstance implements ServiceRestInstance{
	public PegaServiceRestInstance(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}
	public void selectHttpMethod(String httpMethod) {
		pegaDriver.findElement(By.xpath("//input[@value='POST']")).click();
	}
	
	public void executeSimulation() {
		pegaDriver.findElement(By.xpath("//span[@class='pzbtn-label' and contains(text(),'Execute')]")).click();
		
	}
	public void run() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("Developer");
		pegaDriver.switchTo().frame("PegaGadget1Ifr");
		PegaWebElement actions = pegaDriver.findElement(ACTION_BUTTON);
		pegaDriver.handleWaits().waitForElementVisibility(ACTION_BUTTON);
		pegaDriver.handleWaits().waitForElementClickable(ACTION_BUTTON);
		actions.click(false);
		PegaWebElement runLink = pegaDriver.findElement(RUN_LINK);
		pegaDriver.handleWaits().waitForElementVisibility(runLink);
		pegaDriver.handleWaits().waitForElementClickable(RUN_LINK);
		runLink.click(false);
		pegaDriver.waitForDocStateReady(3);
		
	}

}
