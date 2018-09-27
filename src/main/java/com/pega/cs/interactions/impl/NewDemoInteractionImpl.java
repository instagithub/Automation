package com.pega.cs.interactions.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.cs.interactions.NewDemoInteraction;
import com.pega.framework.PegaWebElement;

public class NewDemoInteractionImpl extends InteractionsImpl implements NewDemoInteraction{
	
	
	
	public NewDemoInteractionImpl(WebElement elmt, String frameId) {
		super(elmt, frameId);
		pop = true;
		// TODO Auto-generated constructor stub
	}

	public NewDemoInteractionImpl(WebElement elmt) {
		super(elmt);
		pop = true;
		
	}

	@Override
	public void acceptCall() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//button[contains(.,'Accept')]")).click();
		pegaDriver.waitForDocStateReady(2);
	}
	
	

	



	/*@Override
	public void addTask() {
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		PegaWebElement addTaskButton = pegaDriver.findElement(By.xpath(ADD_TASK_XPATH));
		addTaskButton.click();
		
		
	}*/

}
