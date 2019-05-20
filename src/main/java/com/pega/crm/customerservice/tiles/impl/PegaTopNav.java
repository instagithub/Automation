package com.pega.crm.customerservice.tiles.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.designerstudio.ApplicationWizard;
import com.pega.crm.customerservice.designerstudio.impl.PegaApplicationWizard;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.NewDemoInteraction;
import com.pega.crm.customerservice.interactions.NewInboundInteraction;
import com.pega.crm.customerservice.interactions.OutboundPhoneCall;
import com.pega.crm.customerservice.interactions.PhoneCall;
import com.pega.crm.customerservice.interactions.ResearchInteraction;
import com.pega.crm.customerservice.interactions.impl.PegaNewDemoInteraction;
import com.pega.crm.customerservice.interactions.impl.PegaNewInboundInteraction;
import com.pega.crm.customerservice.interactions.impl.PegaOutboundPhoneCall;
import com.pega.crm.customerservice.interactions.impl.PegaPhoneCall;
import com.pega.crm.customerservice.interactions.impl.PegaResearchInteraction;
import com.pega.crm.customerservice.tiles.TopNav;
import com.pega.crm.customerservice.utils.CommonMethods;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.page.TopDocumentImpl;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;

import cucumber.api.DataTable;

public class PegaTopNav extends TopDocumentImpl implements TopNav {

	public String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public String VERSION = "$Id: PegaTopNav.java 117333 2018-10-01 09:12:21Z JayaPrakash $";
	public CommonMethods commonMethods = null;
	public static String AppName=null;

	
	public static List<List<String>> myvariables=null;
	int connectorsCount = 0;

	public PegaTopNav(TestEnvironment testEnv) {
		super(testEnv);
	}

	@Override
	public PhoneCall createNewPhoneCall() {
		findElement(By.xpath("//a[@title='Create New Interaction']")).click();
		findElement(By.xpath("//td[@id='ItemMiddle' and text()='Phone Call']")).click();
		// you need to implement logic
		String frameId = getActiveFrameId(false);
		PhoneCall newPhoneCall = new PegaPhoneCall(frameId, testEnv);
		return newPhoneCall;
	}

	public void launchDemoInteraction() {

	}

	@Override
	public NewDemoInteraction createNewDemoPop() {
		testEnv.getBrowser().refresh();
		findElement(By.xpath("//a[@title='Create New Interaction']")).click();
		findElement(By.xpath("//span[@class='menu-item-title' and text()='Demo Pop - CONNOR']")).click();
		findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Accept']")).click();
		String frameId = getActiveFrameId(false);
		NewDemoInteraction newDemoInteraction = new PegaNewDemoInteraction(frameId, testEnv);
		return newDemoInteraction;
	}

	@Override
	public NewInboundInteraction startInboundCase() {
		// navigate().refresh();
		findElement(By.xpath("//a[text()='New']")).click();
		handleWaits().sleep(3);
		// findElement(By.xpath("//li[@title='Launch New Inbound
		// Correspondence']")).click();
		findElement(By.xpath("//span[text()='Inbound correspondence']")).click();
		handleWaits().sleep(3);
		String frameId = getActiveFrameId(false);
		NewInboundInteraction newInboundInteraction = new PegaNewInboundInteraction(frameId, testEnv);
		return newInboundInteraction;
	}

	@Override
	public <T extends Interactions> T getInteractionType(String value) {
		// TODO Auto-generated method stub

		System.out.println("Inside the Interaction Type Method");
		System.out.println("value for the driver is: : : :" + pegaDriver);
		findElement(By.xpath("//a[@data-test-id='2014100609491604293426']")).click();
		findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
		if (value.contains("Demo Pop")) {
			return null;
		} else {
			return returnInteractionType(value);
		}
	}

	@Override
	public <T extends Interactions> T getDemoInteractionType(String value) {

		System.out.println("Inside the Interaction Type Method");
		System.out.println("value for the driver is: : : :" + pegaDriver);
		
		handleWaits().waitForElementVisibility(By.xpath("//a[@data-test-id='2014100609491604293426']"));
		
		findElement(By.xpath("//a[@data-test-id='2014100609491604293426']")).click();
		PegaWebElement element = pegaDriver
				.findElement(By.xpath("//span[@class='menu-item-title' and contains(text(),'Demo Screen Pops')]"));
		testEnv.getScriptExecutor().mouseOver(element);
		findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
		findElement(By.xpath("//button[contains(.,'Accept')]")).click();

		// if(value.contains("Demo Pop")){
		// return null;
		// } else {
		return returnInteractionType(value);
		// }
	}
	@Override
	public <T extends Interactions> T getDemoInteractionTypeAsManager(String value) {
		testEnv.getBrowser().refresh();
		findElement(By.xpath("//i[@title='CS Manager']")).click();
		
		findElement(By.xpath("//span[contains(text(),'Switch portal')]")).mouseOver();
		handleWaits().waitForElementVisibility(By.xpath("//span[contains(text(),'Interaction Portal')]"));
		findElement(By.xpath("//span[contains(text(),'Interaction Portal')]")).click(false);
		//handleWaits().waitForAlert();
		//switchTo().alert().accept();
		try {
			handleWaits().waitForAlert();
			pegaDriver.switchTo().alert().accept();
			handleWaits().waitForAlert();
			pegaDriver.switchTo().alert().accept();
			handleWaits().waitForAlert();
			pegaDriver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		handleWaits().waitForElementVisibility(By.xpath("//a[@data-test-id='2014100609491604293426']"));
		findElement(By.xpath("//a[@data-test-id='2014100609491604293426']")).click();
		findElement(By.xpath("//span[@class='menu-item-title' and contains(text(),'Demo Screen Pops')]")).mouseOver();
		findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
		return returnInteractionType(value);
	}
	@Override
	public <T extends Interactions> T returnInteractionType(String value) {
		if (value.equalsIgnoreCase("Phone Call")) {
			String frameId = getActiveFrameId(false);
			PhoneCall newPhoneCall = new PegaPhoneCall(frameId, testEnv);
			return (T) newPhoneCall;
		}

		else if (value.contains("Demo Pop") || value.contains("BROWN")) {
			// findElement(By.xpath("//div[@class='pzbtn-mid' and
			// text()='Accept']")).click();
			String frameId = getActiveFrameId(false);
			System.out.println(frameId);
			NewDemoInteraction newDemoInteraction = new PegaNewDemoInteraction(frameId, testEnv);
			return (T) newDemoInteraction;
		} else if (value.contains("Inbound correspondence")) {

			String frameId = getActiveFrameId(false);
			System.out.println(frameId);
			NewInboundInteraction newInboundInteraction = new PegaNewInboundInteraction(frameId, testEnv);
			return (T) newInboundInteraction;
		} else if (value.contains("Outbound Phone Call")) {

			String frameId = getActiveFrameId(false);
			System.out.println(frameId);
			OutboundPhoneCall outboundPhoneCall = new PegaOutboundPhoneCall(frameId, testEnv);
			return (T) outboundPhoneCall;
		}

		else if (value.equalsIgnoreCase("Outbound Call API Simulation")) {

			String frameId = getActiveFrameId(false);
			System.out.println(frameId);
			OutboundPhoneCall outboundPhoneCall = new PegaOutboundPhoneCall(frameId, testEnv);
			return (T) outboundPhoneCall;

		}
		/*else if(value.equalsIgnoreCase("Chat")) {
			String frameId = getActiveFrameId(false);
			WebElement frameElmt = findElement(By.id(frameId)).getWebElement();
			
			ChatInteraction chatInteraction = new ChatInteractionImpl(frameElmt, frameId);
			chatInteraction._setEnvironment(testEnv, frameId);
			
			if(verifyElement(By.xpath("//*[@title='Agent is unavailable']")))
			{
			findElement(By.xpath("//*[@title='Agent is unavailable']")).click(false);
			waitForDocStateReady(3);
			
			}
			return (T) chatInteraction;
		}*/

		return null;

	}

	@Override
	public void searchPortal(String name) {
				
		findElement(By.xpath(SEARCH_BOX_XPATH)).sendKeys(Keys.CLEAR);
		findElement(By.xpath(SEARCH_BOX_XPATH)).sendKeys(name);
		findElement(By.xpath(SEARCH_ITEM_XPATH)).click();
	}

	@Override
	public String getStatusOfCase() {
		
		String status = findElement(By.xpath("//td[@data-attribute-name='Status']/div/span")).getText();
		return status;
	}

	@Override
	public ResearchInteraction searchResult(String interactionType, String name) {
		
		
		DropDown SelectedDataSource = findSelectBox(By.xpath(SELECT_DATA_SOURCE_XPATH));
		SelectedDataSource.selectByVisibleText(interactionType);
		
		findElement(By.xpath(SEARCH_BOX_XPATH)).sendKeys(name);
		
		findElement(By.xpath(SEARCH_ITEM_XPATH)).click();
		findElement(By.xpath("//span[contains(text(),'"+name+"')]/ancestor::tr[1]/descendant::i[contains(@data-click,'...')]")).click();
		findElement(By.xpath("//span[text()='Start research']/ancestor::span[1]")).click();
		
		
		 
		String frameId = getActiveFrameId(false);
		ResearchInteraction researchInteraction = new PegaResearchInteraction(frameId, testEnv);
		return researchInteraction;
	}

	
	@Override
	public ResearchInteraction initiateACall(String result) {
		if(verifyElement(By.xpath("//span[contains(text(),'"+result+"')]/../../../td[5]/div/span/button")))
		{
		PegaWebElement selectAccount = findElement(By.xpath("//span[contains(text(),'"+result+"')]/../../../td[5]/div/span/button"));
		selectAccount.click(false);
		PegaWebElement initiateacall=findElement(By.xpath("//span[contains(text(),'Initiate a call')]"));
		initiateacall.click();
		}
		else if(verifyElement(By.xpath("//span/a[contains(text(),'"+result+"')]")))
		{
			PegaWebElement selectAccount = findElement(By.xpath("//span/a[contains(text(),'"+result+"')]"));
			selectAccount.click(false);
		}
		else{
			//PegaWebElement selectAccount = findElement(By.xpath("//span[contains(text(),'"+result+"')]/../../../td[8]/div/span/button"));
			PegaWebElement selectAccount = findElement(By.xpath("//span[contains(text(),'"+result+"')]/../../../td[@class=' gridCell ']//*[@aria-haspopup='true' and contains(@data-click,'CPMSearchResultMenu')]"));
			selectAccount.click(false);
			PegaWebElement initiateacall=findElement(By.xpath("//span[contains(text(),'Initiate a call')]"));
			initiateacall.click();
		}
		String frameId = getActiveFrameId(false);
		ResearchInteraction researchInteraction = new PegaResearchInteraction(frameId, testEnv);
		return researchInteraction;
	}
	@Override
	public ResearchInteraction closeInteraction() {
		PegaWebElement closeInteraction = findElement(By.xpath("//button[@class='Wrap_up_button pzhc pzbutton' and @title='Close']"));
		closeInteraction.click(false);
		String frameId = getActiveFrameId(false);
		ResearchInteraction researchInteraction = new PegaResearchInteraction(frameId, testEnv);
		return researchInteraction;
	}

	@Override
	public ResearchInteraction search(String name) {
		searchPortal(name);
		return null;

	}




	
	@Override
	public OutboundPhoneCall createOutboundPhoneCall() {
		String frameId = getActiveFrameId(true);
		OutboundPhoneCall outboundPhoneCall = new PegaOutboundPhoneCall(frameId, testEnv);
		return outboundPhoneCall;
	}


	@Override
	public ResearchInteraction setResearchInteraction() {
		
		
		
		String frameId = getActiveFrameId(false);
		ResearchInteraction researchInteraction = new PegaResearchInteraction(frameId, testEnv);
		return researchInteraction;
	}
	
	@Override
	public ResearchInteraction selectandSearchResearchType(String searchType, String value) {
		
		
		DropDown selectType = findSelectBox(By.xpath(TopNav.SELECT_DATA_SOURCE_XPATH));
		selectType.selectByValue(searchType);

		findElement(By.xpath(TopNav.SEARCH_BOX_XPATH)).sendKeys(Keys.CLEAR);
		findElement(By.xpath(TopNav.SEARCH_BOX_XPATH)).sendKeys(value);
		findElement(By.xpath(TopNav.SEARCH_ITEM_XPATH)).click();
		

		String frameId = getActiveFrameId(false);
		ResearchInteraction researchInteraction = new PegaResearchInteraction(frameId, testEnv);
		return researchInteraction;
	}





	

	
	
	
}
