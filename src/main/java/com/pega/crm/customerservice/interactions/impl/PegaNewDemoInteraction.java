package com.pega.crm.customerservice.interactions.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.interactions.NewDemoInteraction;

public class PegaNewDemoInteraction extends PegaInteractions implements NewDemoInteraction{
	
	
	
	

	public PegaNewDemoInteraction(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
		pop = true;
	}

	@Override
	public void acceptCall() {
		findElement(By.xpath("//button[contains(.,'Accept')]")).click();
		pegaDriver.waitForDocStateReady(2);
	}
	
	


}
