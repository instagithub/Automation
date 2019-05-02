package com.pega.crm.customerservice.interactions.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.interactions.ResearchInteraction;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;

public class PegaResearchInteraction extends PegaInteractions implements ResearchInteraction{
	
	public PegaResearchInteraction(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	public String frameId = null;
	public Wizard newWizard = null;
	
	

	@Override
	public String checkCaseStatus(String caseId) {
		
		PegaWebElement searchBox = findElement(By.xpath("//input[@id='pySearchText']"));
		searchBox.sendKeys(caseId);
		PegaWebElement searchIcon = findElement(By.xpath("//img[@title='Search for an Item ']"));
		searchIcon.sendKeys(Keys.ENTER);
		PegaWebElement status = findElement(By.xpath("//span[contains(text(),'Resolved')]"));
		String caseStatus = status.getText();
		return caseStatus;
	}
	
	

}
