package com.pega.crm.customerservice.interactions.impl;

import java.awt.AWTException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.interactions.NewInboundInteraction;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;

import cucumber.api.java.en.When;

public class PegaNewInboundInteraction extends PegaInteractions implements NewInboundInteraction{
	
	public PegaNewInboundInteraction(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	public String frameId = null;
	public Wizard newWizard = null;
	
	

	
	public void filterwithInitialValues(String searchBox, String searchString) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		
		if(searchBox.equalsIgnoreCase("first name")||searchBox.equalsIgnoreCase("organization name")){
			
			PegaWebElement searchtype = pegaDriver.findElement(By.xpath(FIRST_NAME_SEARCH_BOX_XPATH));
			searchtype.sendKeys(searchString);
		}
		
		else{
			String initialXPath = "//input[@title='Search #Issue#']";
			String finalXPath = new String(initialXPath).replace("#Issue#", searchBox);

			PegaWebElement searchtype = pegaDriver.findElement(By.xpath(finalXPath));
			searchtype.sendKeys(searchString);
		}
		

		pegaDriver.waitForDocStateReady(10);
		pegaDriver.switchToActiveFrame();

		if (searchString.equalsIgnoreCase("123450000")) {
			PegaWebElement searchButton = pegaDriver.findElement(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.click();
		} else if (searchString.equalsIgnoreCase("Acme Software")) {
			PegaWebElement searchButton = pegaDriver.findElement(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.click();
		} else if (searchString.equalsIgnoreCase("Rebecca")) {
			List<WebElement> searchButton = pegaDriver.findElements(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.get(0).click();
		} else if (searchString.equalsIgnoreCase("Credit Card Fees & Charges")) {
			PegaWebElement searchButton = pegaDriver.findElement(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.click();
		} else if (searchString.equalsIgnoreCase("12457890")) {
			PegaWebElement searchButton = pegaDriver.findElement(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.click();
		}

	}
	
	@Override
	public void filterWithAllForAccount(String AcNo, String Type, String Status, String OwnerName) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		PegaWebElement accountNumber = pegaDriver.findElement(By.xpath("//input[@title='Search account number']"));
		accountNumber.sendKeys(AcNo);

		PegaWebElement accountType = pegaDriver.findElement(By.xpath("//input[@title='Search account type']"));
		accountType.sendKeys(Type);

		PegaWebElement accountStatus = pegaDriver.findElement(By.xpath("//input[@title='Search status']"));
		accountStatus.sendKeys(Status);

		PegaWebElement accountOwner = pegaDriver.findElement(By.xpath("//input[@title='Search owner first name']"));
		accountOwner.sendKeys(OwnerName);

		pegaDriver.waitForDocStateReady(10);
		pegaDriver.switchToActiveFrame();

		PegaWebElement searchButton = pegaDriver.findElement(By.xpath(RESEARCH_SEARCH_XPATH));
		searchButton.click();

	}
	
	
}
