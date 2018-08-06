package com.pega.cs.tiles.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pega.TestEnvironment;
import com.pega.cs.designerstudio.ApplicationWizard;
import com.pega.cs.designerstudio.impl.ApplicationWizardImpl;
import com.pega.cs.interactions.CTI;
import com.pega.cs.interactions.ChatInteraction;
import com.pega.cs.interactions.Interactions;
import com.pega.cs.interactions.NewDemoInteraction;
import com.pega.cs.interactions.NewInboundInteraction;
import com.pega.cs.interactions.OutboundPhoneCall;
import com.pega.cs.interactions.PhoneCall;
import com.pega.cs.interactions.ResearchInteraction;
import com.pega.cs.interactions.SocialInteraction;
import com.pega.cs.interactions.impl.CTIImpl;
import com.pega.cs.interactions.impl.ChatInteractionImpl;
import com.pega.cs.interactions.impl.NewDemoInteractionImpl;
import com.pega.cs.interactions.impl.NewInboundInteractionImpl;
import com.pega.cs.interactions.impl.OutboundPhoneCallImpl;
import com.pega.cs.interactions.impl.PhoneCallImpl;
import com.pega.cs.interactions.impl.ResearchInteractionImpl;
import com.pega.cs.interactions.impl.SocialInteractionImpl;
import com.pega.cs.tiles.TopNav;
import com.pega.explorer.DesignerStudio;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;
import com.pega.wizard.DecisioningServices;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;

public class TopNavImpl implements TopNav {

	public String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	public String VERSION = "$Id: TopNavImpl.java 125039 2015-02-20 11:25:50Z PallaviGanesh $";
	public static String AppName=null;

	private PegaWebDriver pegaDriver = null;
	private TestEnvironment testEnv = null;
	public static List<List<String>> myvariables=null;
	int connectorsCount = 0;

	public TopNavImpl(TestEnvironment testEnv) {
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver();
	}

	@Override
	public PhoneCall createNewPhoneCall() {
		pegaDriver.findElement(By.xpath("//a[@title='Create New Interaction']")).click();
		pegaDriver.findElement(By.xpath("//td[@id='ItemMiddle' and text()='Phone Call']")).click();
		// you need to implement logic
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		PhoneCall newPhoneCall = new PhoneCallImpl(frameElmt, frameId);
		newPhoneCall._setEnvironment(testEnv, frameId);
		return newPhoneCall;
	}

	public void launchDemoInteraction() {

	}

	@Override
	public NewDemoInteraction createNewDemoPop() {
		pegaDriver.navigate().refresh();
		pegaDriver.findElement(By.xpath("//a[@title='Create New Interaction']")).click();
		pegaDriver.findElement(By.xpath("//span[@class='menu-item-title' and text()='Demo Pop - CONNOR']")).click();
		pegaDriver.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Accept']")).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		NewDemoInteraction newDemoInteraction = new NewDemoInteractionImpl(frameElmt, frameId);
		newDemoInteraction._setEnvironment(testEnv, frameId);
		return newDemoInteraction;
	}

	@Override
	public NewInboundInteraction startInboundCase() {
		// pegaDriver.navigate().refresh();
		pegaDriver.findElement(By.xpath("//a[text()='New']")).click();
		pegaDriver.handleWaits().sleep(3);
		// pegaDriver.findElement(By.xpath("//li[@title='Launch New Inbound
		// Correspondence']")).click();
		pegaDriver.findElement(By.xpath("//span[text()='Inbound correspondence']")).click();
		pegaDriver.handleWaits().sleep(3);
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		NewInboundInteraction newInboundInteraction = new NewInboundInteractionImpl(frameElmt, frameId);
		newInboundInteraction._setEnvironment(testEnv, frameId);
		return newInboundInteraction;
	}

	@Override
	public <T extends Interactions> T getInteractionType(String value) {
		// TODO Auto-generated method stub

		System.out.println("Inside the Interaction Type Method");
		System.out.println("value for the driver is: : : :" + pegaDriver);
		pegaDriver.findElement(By.xpath("//a[@data-test-id='2014100609491604293426']")).click();
		pegaDriver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
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
		pegaDriver.switchTo().defaultContent();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//a[@data-test-id='2014100609491604293426']"));
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//a[@data-test-id='2014100609491604293426']")).click();
		PegaWebElement element = pegaDriver
				.findElement(By.xpath("//span[@class='menu-item-title' and contains(text(),'Demo Screen Pops')]"));
		testEnv.getScriptExecutor().mouseOver(element);
		pegaDriver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();

		// if(value.contains("Demo Pop")){
		// return null;
		// } else {
		return returnInteractionType(value);
		// }
	}
	@Override
	public <T extends Interactions> T getDemoInteractionTypeAsManager(String value) {
		pegaDriver.navigate().refresh();
		pegaDriver.switchTo().frame("FormFactoriFrame");
		pegaDriver.findElement(By.xpath("//i[@title='CS Manager']")).click();
		pegaDriver.switchTo().frame("FormFactoriFrame");
		pegaDriver.findElement(By.xpath("//span[contains(text(),'Switch portal')]")).mouseOver();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//span[contains(text(),'Interaction Portal')]"));
		pegaDriver.findElement(By.xpath("//span[contains(text(),'Interaction Portal')]")).click(false);
		//pegaDriver.handleWaits().waitForAlert();
		//pegaDriver.switchTo().alert().accept();
		try {
			pegaDriver.handleWaits().waitForAlert();
			pegaDriver.switchTo().alert().accept();
			pegaDriver.handleWaits().waitForAlert();
			pegaDriver.switchTo().alert().accept();
			pegaDriver.handleWaits().waitForAlert();
			pegaDriver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
		pegaDriver.switchTo().defaultContent();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//a[@data-test-id='2014100609491604293426']"));
		pegaDriver.findElement(By.xpath("//a[@data-test-id='2014100609491604293426']")).click();
		pegaDriver.findElement(By.xpath("//span[@class='menu-item-title' and contains(text(),'Demo Screen Pops')]")).mouseOver();
		pegaDriver.findElement(By.xpath("//span[contains(text(),'" + value + "')]")).click();
		return returnInteractionType(value);
	}
	@Override
	public <T extends Interactions> T returnInteractionType(String value) {
		if (value.equalsIgnoreCase("Phone Call")) {
			String frameId = pegaDriver.getActiveFrameId(false);
			WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
			pegaDriver.switchTo().frame(frameElmt);
			PhoneCall newPhoneCall = new PhoneCallImpl(frameElmt, frameId);
			newPhoneCall._setEnvironment(testEnv, frameId);
			return (T) newPhoneCall;
		}

		else if (value.contains("Demo Pop") || value.contains("BROWN")) {
			// pegaDriver.findElement(By.xpath("//div[@class='pzbtn-mid' and
			// text()='Accept']")).click();
			String frameId = pegaDriver.getActiveFrameId(false);
			System.out.println(frameId);
			WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
			pegaDriver.switchTo().frame(frameElmt);
			NewDemoInteraction newDemoInteraction = new NewDemoInteractionImpl(frameElmt, frameId);
			newDemoInteraction._setEnvironment(testEnv, frameId);
			return (T) newDemoInteraction;
		} else if (value.contains("Inbound correspondence")) {

			String frameId = pegaDriver.getActiveFrameId(false);
			System.out.println(frameId);
			WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
			pegaDriver.switchTo().frame(frameElmt);
			NewInboundInteraction newInboundInteraction = new NewInboundInteractionImpl(frameElmt, frameId);
			newInboundInteraction._setEnvironment(testEnv, frameId);
			return (T) newInboundInteraction;
		} else if (value.contains("Outbound Phone Call")) {

			String frameId = pegaDriver.getActiveFrameId(false);
			System.out.println(frameId);
			WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
			pegaDriver.switchTo().frame(frameElmt);
			OutboundPhoneCall outboundPhoneCall = new OutboundPhoneCallImpl(frameElmt, frameId);
			outboundPhoneCall._setEnvironment(testEnv, frameId);
			return (T) outboundPhoneCall;
		}

		else if (value.equalsIgnoreCase("Outbound Call API Simulation")) {

			String frameId = pegaDriver.getActiveFrameId(false);
			System.out.println(frameId);
			WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
			pegaDriver.switchTo().frame(frameElmt);
			OutboundPhoneCall outboundPhoneCall = new OutboundPhoneCallImpl(frameElmt, frameId);
			outboundPhoneCall._setEnvironment(testEnv, frameId);
			return (T) outboundPhoneCall;

		}
		else if(value.equalsIgnoreCase("Chat")) {
			String frameId = pegaDriver.getActiveFrameId(false);
			WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
			pegaDriver.switchTo().defaultContent();
			ChatInteraction chatInteraction = new ChatInteractionImpl(frameElmt, frameId);
			chatInteraction._setEnvironment(testEnv, frameId);
			pegaDriver.switchTo().defaultContent();
			if(pegaDriver.verifyElement(By.xpath("//*[@title='Agent is unavailable']")))
			{
			pegaDriver.findElement(By.xpath("//*[@title='Agent is unavailable']")).click(false);
			pegaDriver.waitForDocStateReady(3);
			pegaDriver.switchTo().defaultContent();
			}
			return (T) chatInteraction;
		}

		return null;

	}

	@Override
	public void searchPortal(String name) {
		pegaDriver.waitForDocStateReady(10);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(SEARCH_BOX_XPATH)).sendKeys(Keys.CLEAR);
		pegaDriver.findElement(By.xpath(SEARCH_BOX_XPATH)).sendKeys(name);
		pegaDriver.findElement(By.xpath(SEARCH_ITEM_XPATH)).click();
	}

	@Override
	public String getStatusOfCase() {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		String status = pegaDriver.findElement(By.xpath("//td[@data-attribute-name='Status']/div/span")).getText();
		return status;
	}

	@Override
	public ResearchInteraction searchResult(String interactionType, String name) {
		//searchPortal(name);
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		DropDown SelectedDataSource = pegaDriver.findSelectBox(By.xpath(SELECT_DATA_SOURCE_XPATH));
		SelectedDataSource.selectByVisibleText(interactionType);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(SEARCH_BOX_XPATH)).sendKeys(name);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(SEARCH_ITEM_XPATH)).click();
		// pegaDriver.findElement(By.xpath("(//a[text()='"+name+"'])[2]")).click();
		pegaDriver.switchToActiveFrame();
	//	pegaDriver.findElement(By.xpath("//div[@node_name='SearchResultsContact']/descendant::a[text()='" + name + "'][1]")).click();
		pegaDriver.findElement(By.xpath("//span[contains(text(),'"+name+"')]/ancestor::tr[1]/descendant::i[contains(@data-click,'...')]")).click();
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath("//span[text()='Start research']/ancestor::span[1]")).click();
		
		/* * PegaWebElement searchTypeTab = pegaDriver.findElement(By.xpath(
		 * "//h3[@class='layout-group-item-title'][text()='"+interactionType+
		 * "']")); searchTypeTab.click(); pegaDriver.waitForDocStateReady(3);
		 * pegaDriver.switchToActiveFrame(); PegaWebElement searchResult =
		 * pegaDriver.findElement(By.xpath("//a[contains(@title,'"+name+
		 * "')][text()='"+name+"']")); searchResult.click();*/
		 
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		ResearchInteraction researchInteraction = new ResearchInteractionImpl(frameElmt, frameId);
		researchInteraction._setEnvironment(testEnv, frameId);
		return researchInteraction;
	}

	@Override
	public ResearchInteraction searchDropDownresult(String result) {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		if(pegaDriver.verifyElement(By.xpath("//span[contains(text(),'"+result+"')]/../../../td[5]/div/span/button")))
		{
		PegaWebElement selectAccount = pegaDriver.findElement(By.xpath("//span[contains(text(),'"+result+"')]/../../../td[5]/div/span/button"));
		selectAccount.click(false);
		PegaWebElement startresearch=pegaDriver.findElement(By.xpath("//span[contains(text(),'Start research')]"));
		startresearch.click();
		}
		else if(pegaDriver.verifyElement(By.xpath("//span/a[contains(text(),'"+result+"')]")))
		{
			PegaWebElement selectAccount = pegaDriver.findElement(By.xpath("//span/a[contains(text(),'"+result+"')]"));
			selectAccount.click(false);
		}
		else{
			//PegaWebElement selectAccount = pegaDriver.findElement(By.xpath("//span[contains(text(),'"+result+"')]/../../../td[8]/div/span/button"));
			PegaWebElement selectAccount = pegaDriver.findElement(By.xpath("//span[contains(text(),'"+result+"')]/../../../td[@class=' gridCell ']//*[@aria-haspopup='true' and contains(@data-click,'CPMSearchResultMenu')]"));
			selectAccount.click(false);
			PegaWebElement startresearch=pegaDriver.findElement(By.xpath("//span[contains(text(),'Start research')]"));
			startresearch.click();
		}
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		ResearchInteraction researchInteraction = new ResearchInteractionImpl(frameElmt, frameId);
		researchInteraction._setEnvironment(testEnv, frameId);
		return researchInteraction;
	}
	@Override
	public ResearchInteraction initiateACall(String result) {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		if(pegaDriver.verifyElement(By.xpath("//span[contains(text(),'"+result+"')]/../../../td[5]/div/span/button")))
		{
		PegaWebElement selectAccount = pegaDriver.findElement(By.xpath("//span[contains(text(),'"+result+"')]/../../../td[5]/div/span/button"));
		selectAccount.click(false);
		PegaWebElement initiateacall=pegaDriver.findElement(By.xpath("//span[contains(text(),'Initiate a call')]"));
		initiateacall.click();
		}
		else if(pegaDriver.verifyElement(By.xpath("//span/a[contains(text(),'"+result+"')]")))
		{
			PegaWebElement selectAccount = pegaDriver.findElement(By.xpath("//span/a[contains(text(),'"+result+"')]"));
			selectAccount.click(false);
		}
		else{
			//PegaWebElement selectAccount = pegaDriver.findElement(By.xpath("//span[contains(text(),'"+result+"')]/../../../td[8]/div/span/button"));
			PegaWebElement selectAccount = pegaDriver.findElement(By.xpath("//span[contains(text(),'"+result+"')]/../../../td[@class=' gridCell ']//*[@aria-haspopup='true' and contains(@data-click,'CPMSearchResultMenu')]"));
			selectAccount.click(false);
			PegaWebElement initiateacall=pegaDriver.findElement(By.xpath("//span[contains(text(),'Initiate a call')]"));
			initiateacall.click();
		}
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		ResearchInteraction researchInteraction = new ResearchInteractionImpl(frameElmt, frameId);
		researchInteraction._setEnvironment(testEnv, frameId);
		return researchInteraction;
	}
	@Override
	public ResearchInteraction closeInteraction() {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		PegaWebElement closeInteraction = pegaDriver.findElement(By.xpath("//button[@class='Wrap_up_button pzhc pzbutton' and @title='Close']"));
		closeInteraction.click(false);
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		ResearchInteraction researchInteraction = new ResearchInteractionImpl(frameElmt, frameId);
		researchInteraction._setEnvironment(testEnv, frameId);
		return researchInteraction;
	}

	@Override
	public ResearchInteraction search(String name) {
		searchPortal(name);
		return null;

	}

	@Override
	public CTI agentLogin(String linkname, String extension, String agentId, String password) {
		pegaDriver.findElement(By.xpath("//button[contains(@onclick,'callLogin')]")).click();
		DropDown CTILink = pegaDriver.findSelectBox(By.id("pySelectedLinkName"));
		CTILink.selectByValue(linkname);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//input[@title='Extension']")).sendKeys(extension);
		pegaDriver.findElement(By.id("pyAgentId")).doClickWithMouse();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.id("pyAgentId")).sendKeys(agentId);
		pegaDriver.handleWaits().sleep(2);
		pegaDriver.findElement(By.id("pyAgentPwd")).sendKeys(password);
		pegaDriver.handleWaits().sleep(3);
		pegaDriver.findElement(By.xpath("//button[@class='Strong pzhc pzbutton' and text()='Login']")).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		CTI cti = new CTIImpl(frameElmt, frameId);
		cti._setEnvironment(testEnv, frameId);
		return cti;
	}

	@Override
	public void createNewDemoPop_BROWN() {
		pegaDriver.findElement(By.xpath("//a[@title='Create New Interaction']")).click();
		pegaDriver.findElement(By.xpath("//li[@title='Launch New interaction with Brown']")).click();

		/*
		 * 
		 * pegaDriver.findElement(By.xpath(
		 * "//div[@class='pzbtn-mid' and text()='Accept']")).click(); String
		 * frameId = pegaDriver.getActiveFrameId(false); WebElement frameElmt =
		 * pegaDriver.findElement(By.id(frameId)).getWebElement();
		 * pegaDriver.switchTo().frame(frameElmt); NewDemoInteraction
		 * newDemoInteraction = new NewDemoInteractionImpl(frameElmt, frameId);
		 * newDemoInteraction._setEnvironment(testEnv, frameId);
		 */
		// return newDemoInteraction;
	}

	@Override
	public NewDemoInteraction Accept_NewDemoPop_BROWN() {
		pegaDriver.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Accept']")).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		NewDemoInteraction newDemoInteraction = new NewDemoInteractionImpl(frameElmt, frameId);
		newDemoInteraction._setEnvironment(testEnv, frameId);
		return newDemoInteraction;
	}

	@Override
	public NewDemoInteraction NewDemoPop_BROWN() {
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		NewDemoInteraction newDemoInteraction = new NewDemoInteractionImpl(frameElmt, frameId);
		newDemoInteraction._setEnvironment(testEnv, frameId);
		return newDemoInteraction;
	}

	@Override
	public ChatInteraction chatAgentLogin(String serverName, String displayName) {
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().defaultContent();
		ChatInteraction chatInteraction = new ChatInteractionImpl(frameElmt, frameId);
		chatInteraction._setEnvironment(testEnv, frameId);
		pegaDriver.findElement(By.xpath("//*[@title='Login to chat server']")).click();
		pegaDriver.switchTo().activeElement();

		DropDown chatdroplist = pegaDriver.findSelectBox(By.xpath(CHAT_SERVER_XPATH));
		chatdroplist.selectByValue(serverName);
		pegaDriver.switchTo().defaultContent();
		//pegaDriver.findElement(By.xpath(CHAT_SERVER_DISPLAY_NAME_XPATH)).clear();
		//pegaDriver.findElement(By.xpath(CHAT_SERVER_DISPLAY_NAME_XPATH)).sendKeys(Keys.chord(Keys.CONTROL,"a"),displayName);
		pegaDriver.findElement(By.xpath(CHAT_SERVER_DISPLAY_NAME_XPATH)).sendKeys(Keys.TAB);
		pegaDriver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
		pegaDriver.waitForDocStateReady(5);
		pegaDriver.navigate().refresh();
		pegaDriver.switchTo().defaultContent();
		//pegaDriver.waitForDocStateReady(3);
		//pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//*[@title='Agent is unavailable']")).click(false);
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		return chatInteraction;
	}

	@Override
	public ApplicationWizard createApplication(String name) {
		DesignerStudio designerStudio = testEnv.getBrowser().getPortal(DesignerStudio.class);
		designerStudio.getTopNav().createApplication(name);
		String frameId = pegaDriver.getActiveFrameId(false);
		Wizard wizard = pegaDriver.findWizard(frameId);
		ApplicationWizard appWizard = new ApplicationWizardImpl(wizard, frameId);
		appWizard._setEnvironment(testEnv, wizard.getId());
		return appWizard;

	}
	@Override
	public ApplicationWizard launchNewAppWizard() {
	pegaDriver.switchTo().defaultContent();
	pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//a[@title='Application menu']"));
	pegaDriver.findElement(By.xpath("//a[@title='Application menu']")).click(true);
	pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//span[text()='New Application']"));
	pegaDriver.findElement(By.xpath("//span[text()='New Application']")).click();
	pegaDriver.waitForDocStateReady(2);
	String frameId = pegaDriver.getActiveFrameId(false);
	Wizard wizard = pegaDriver.findWizard(frameId);
	ApplicationWizard appWizard = new ApplicationWizardImpl(wizard, frameId);
	appWizard._setEnvironment(testEnv, wizard.getId());
	return appWizard;
	}
	
	
	@Override
	public ApplicationWizard createNewApplication(String appName, String appType, String caseTypes, String channels,
			Boolean cdh, String dataTypes) {
		//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
		String timeStamp = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
		String frameId = pegaDriver.getActiveFrameId(false);
		Wizard wizard = pegaDriver.findWizard(frameId);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		ApplicationWizard appWizard = new ApplicationWizardImpl(wizard, frameId);
		appWizard._setEnvironment(testEnv, wizard.getId());
		pegaDriver.findElement(By.xpath("//span[contains(text(),'Customer Service 7.')]")).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		pegaDriver.findElement(By.xpath("//button[text()='Use this application type']")).click();
		if (caseTypes.equalsIgnoreCase("All")) {
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			if(!pegaDriver.findElement(By.id("CSSelectCaseTypes")).isSelected())
			pegaDriver.findElement(By.id("CSSelectCaseTypes")).click();
			pegaDriver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		} else {
		}
		if (channels.equalsIgnoreCase("All")) {
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			if(!pegaDriver.findElement(By.id("CSSelectInteractionTypes")).isSelected())
			pegaDriver.findElement(By.id("CSSelectInteractionTypes")).click();
			pegaDriver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		} else {
		}
		if (cdh) {
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			if(!pegaDriver.findElement(By.id("EnableMarketing")).isSelected())
			pegaDriver.findElement(By.id("EnableMarketing")).click();
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			pegaDriver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		} else {
		}
		if (dataTypes.equalsIgnoreCase("All")) {
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			if(!pegaDriver.findElement(By.id("pySelectDataTypes")).isSelected())
				pegaDriver.findElement(By.id("pySelectDataTypes")).click();
			pegaDriver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		} else {
		}
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		pegaDriver.findElement(By.id("pyLabel")).sendKeys(appName+timeStamp);
		pegaDriver.findElement(By.xpath("//button[text()='Create application']")).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		pegaDriver.waitForDocStateReady(50);
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//*[text()='Congratulations!']"));
		Assert.assertTrue("New application creation unsuccessful",
				pegaDriver.verifyElement(By.xpath("//*[text()='Congratulations!']")));
		return appWizard;
	}
	@Override
	public void selectApp(String AppName){
		pegaDriver.findElement(By.xpath(Link_AppType.replace("TextValue", AppName))).click();
	}
	@Override
	public void clickOnUseThisApp(){
		//pegaDriver.findElement(By.xpath("//button[text()='Use this application type']")).click();
		//testEnv.getScriptExecutor().click("xpath=//button[contains(text(),'Continue')]");
		pegaDriver.switchToActiveFrame();
		testEnv.getScriptExecutor().click("xpath=//button[@data-test-id='201605111212520498157683']");
		pegaDriver.switchToActiveFrame();
		testEnv.getScriptExecutor().click("xpath=//button[@data-test-id='20160721154732067125766']");
		
	}
	@Override
	public void selectCaseTypes(String SelectAllFlag, DataTable CaseType){
		/*if(SelectAllFlag.equalsIgnoreCase("All"))
		{
			if(!pegaDriver.findElement(By.xpath("//input[@data-test-id='20160819113350031561666']")).isSelected())
				pegaDriver.findElement(By.xpath("//input[@data-test-id='20160819113350031561666']")).click();
				pegaDriver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		}
		else if(SelectAllFlag.equalsIgnoreCase("")||SelectAllFlag.equalsIgnoreCase(null)){
		selectCaseTypes(CaseType);
		pegaDriver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		}*/
		pegaDriver.switchToActiveFrame();
		testEnv.getScriptExecutor().click("xpath=//button[contains(text(),'Continue')]");

	}
	@Override
	public void selectChannels(String SelectAllFlag, DataTable Channel){
		/*if(SelectAllFlag.equalsIgnoreCase("All"))
		{
			if(!pegaDriver.findElement(By.id("CSSelectInteractionTypes")).isSelected())
				pegaDriver.findElement(By.id("CSSelectInteractionTypes")).click();
				pegaDriver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		}
		else if(SelectAllFlag.equalsIgnoreCase("")||SelectAllFlag.equalsIgnoreCase(null)){
		selectCaseTypes(Channel);
		pegaDriver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		}*/
		pegaDriver.switchToActiveFrame();
		testEnv.getScriptExecutor().click("xpath=//button[contains(text(),'Continue')]");
	}
	@Override
	public void selectDataTypes(String SelectAllFlag,DataTable DataType){
		/*if(SelectAllFlag.equalsIgnoreCase("All"))
		{
			if(!pegaDriver.findElement(By.id("pySelectDataTypes")).isSelected())
				pegaDriver.findElement(By.id("pySelectDataTypes")).click();
				pegaDriver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		}
		else if(SelectAllFlag.equalsIgnoreCase("")||SelectAllFlag.equalsIgnoreCase(null)){
		selectCaseTypes(DataType);
		pegaDriver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		}*/
		pegaDriver.switchToActiveFrame();
		testEnv.getScriptExecutor().click("xpath=//button[contains(text(),'Continue')]");
	}

	@Override
	public void selectCDH(String Flag) {
		if (Flag.equalsIgnoreCase("Enable")) {
			if (!pegaDriver.findElement(By.xpath("//input[@data-test-id='20160926063503085117821']")).isSelected())
			//pegaDriver.findElement(By.xpath("//input[@data-test-id='20160926063503085117821']")).click();
				testEnv.getScriptExecutor().click("xpath=//input[@data-test-id='20160926063503085117821']");
		} else {
			if (pegaDriver.findElement(By.xpath("//input[@data-test-id='20160926063503085117821']")).isSelected())
			//	pegaDriver.findElement(By.xpath("//input[@data-test-id='20160926063503085117821']")).click();
				testEnv.getScriptExecutor().click("xpath=//input[@data-test-id='20160926063503085117821']");
				}
		pegaDriver.switchToActiveFrame();
		//pegaDriver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		testEnv.getScriptExecutor().click("xpath=//button[contains(text(),'Continue')]");
		pegaDriver.switchToActiveFrame();
		testEnv.getScriptExecutor().click("xpath=//*[text()='Default']");
	}
	@Override
	public void advancedSettings() {
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath(Link_AdvancedConfig)).click();
	}
	
	@Override
	public void selectAppStructure(String AppStructure) {
		pegaDriver.switchToActiveFrame();
		String timeStamp = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
		AppName="A"+timeStamp;
		pegaDriver.findElement(By.xpath(RBN_AppStructure.replace("TextValue", AppStructure))).click();
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.id(Txt_AppId_Id)).sendKeys(AppName);
		pegaDriver.switchTo().activeElement().sendKeys(Keys.TAB);
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath(Btn_Save)).click();
		pegaDriver.handleWaits();
		pegaDriver.waitForDocStateReady();
	}
	@Override
	public void clicksOnCreateApp() {
	pegaDriver.findElement(By.xpath(Btn_CreateApp)).click();
	}
	public void selectCaseTypes(DataTable ListOfValues){
		List<List<String>> listOfFields = ListOfValues.raw();
		for(List<String> row:listOfFields){
			pegaDriver.findElement(By.xpath(Chk_NewAppWiz.replace("TextValue", row.get(0)))).click();
		}
	}
	@Override
	public void modifyAccessGroupNew(){
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
	    pegaDriver.findElement(By.xpath(CS_IMPL_OPERATOR_MENU_XPATH)).click();
	    pegaDriver.switchTo().defaultContent();
	    pegaDriver.findElement(By.xpath(CS_IMPL_OPERATOR_XPATH)).click();
	    pegaDriver.switchToActiveFrame();
	    String updatedAccessGrp=pegaDriver.findElement(By.xpath(NewAppAccessGrp_Xpath.replace("Value", AppName))).getAttribute("value").replace("Author", "Admin");
	    pegaDriver.findElement(By.xpath(NewAppAccessGrp_Xpath.replace("Value", AppName))).clear();
	    pegaDriver.findElement(By.xpath(NewAppAccessGrp_Xpath.replace("Value", AppName))).sendKeys(updatedAccessGrp);
	    pegaDriver.switchToActiveFrame();
	    pegaDriver.findElement(By.xpath(RBN_NewAppAccessGrp_Xpath.replace("ReplaceValue", AppName))).click();
	    pegaDriver.switchToActiveFrame();
	    pegaDriver.findElement(By.xpath(Btn_Save)).click();
	    pegaDriver.waitForDocStateReady(2);
	}
	@Override
	public void modifyAccessGroupToCS(){
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
	    pegaDriver.findElement(By.xpath(CS_IMPL_OPERATOR_MENU_XPATH)).click();
	    pegaDriver.switchTo().defaultContent();
	    pegaDriver.findElement(By.xpath(CS_IMPL_OPERATOR_XPATH)).click();
	    pegaDriver.switchToActiveFrame();
	    pegaDriver.findElement(By.xpath(RBN_CSAccessGrp_Xpath)).click();
	    pegaDriver.switchToActiveFrame();
	    pegaDriver.findElement(By.xpath(Btn_Save)).click();
	    pegaDriver.waitForDocStateReady(2);
	}
	@Override
	public void deletesNewAppAccessGroup(){
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
	    pegaDriver.switchToActiveFrame();
	    pegaDriver.findElement(By.xpath(Btn_RemoveNewAccessGrp_Xpath.replace("ReplaceValue", AppName))).click();
	    pegaDriver.switchToActiveFrame();
	    pegaDriver.findElement(By.xpath(Btn_Save)).click();
	    pegaDriver.waitForDocStateReady(2);
	}
	@Override
	public void switchToNewApplication(){
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
	    pegaDriver.switchToActiveFrame();
	    pegaDriver.findElement(By.xpath(Btn_SwitchToNewApplication_Xpath)).click();
	    pegaDriver.switchToActiveFrame();
	    pegaDriver.findElement(By.xpath(Btn_Save)).click();
	    pegaDriver.waitForDocStateReady(2);
	}
	@Override
	public void logOutDS(){
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(CS_IMPL_OPERATOR_MENU_XPATH)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(CS_IMPL_LogOff_XPATH)).click();	
	}
	@Override
	public void selectNavigationFromDS(DataTable ListOfValues){
		List<List<String>> listOfFields = ListOfValues.raw();
		int counter=1;
		String ParentLink="";
		String SubMenuLink="";
		String SubLink="";
		pegaDriver.findElement(By.xpath(Link_DesignerStudio_Xpath)).click();
		for(List<String> row:listOfFields){
			if(counter==1){
				ParentLink=Link_DSMenuNav_Xpath.replace("TextValue", row.get(0));
				testEnv.getScriptExecutor().mouseOver(pegaDriver.findElement(By.xpath(ParentLink)));
			pegaDriver.waitForDocStateReady(3);
			}
			else if(counter==2){
				SubMenuLink=ParentLink+"/descendant::span[text()='"+row.get(0)+"']/ancestor::li[1]";
				testEnv.getScriptExecutor().mouseOver(pegaDriver.findElement(By.xpath(SubMenuLink)));
				pegaDriver.waitForDocStateReady(3);
				}
			else if(counter==listOfFields.size()){
				SubLink=SubMenuLink+"/descendant::span[text()='"+row.get(0)+"']/ancestor::li[1]";
				pegaDriver.findElement(By.xpath(SubLink)).click();
				break;
			}
			counter++;
		}
	}
	@Override
	public void clickOnQuerySettingsTab(){
		pegaDriver.switchToActiveFrame();
		if(pegaDriver.findElements(By.xpath(Tab_QuerySettings_Xpath)).size()>0){
			pegaDriver.switchToActiveFrame();
			pegaDriver.findElement(By.xpath(Tab_QuerySettings_Xpath)).click();
		}
	}
	@Override
	public void checkSearch(String CheckBox){
		pegaDriver.switchToActiveFrame();
		pegaDriver.handleWaits().waitForDocStateReady();
		pegaDriver.switchToActiveFrame();
		int size=pegaDriver.findElements(By.xpath("//*[contains(text(),'All work')]/ancestor::td[1]/following-sibling::td/descendant::span[text()='Available']")).size();
		System.out.println("flag***"+size);
		if(size<1){
		System.out.println("size inside***"+size);
		System.out.println("Inside reindex Available checkbox***");
		pegaDriver.navigate().refresh();
		pegaDriver.handleWaits().waitForDocStateReady();
		pegaDriver.switchToActiveFrame();
		pegaDriver.handleWaits().waitForElementVisibility(pegaDriver.findElement(By.xpath(Chk_Search_Xpath)),180);
		pegaDriver.handleWaits().waitForElementClickable(By.xpath(Chk_Search_Xpath));
		/*if(!pegaDriver.findElement(By.xpath(Chk_Search_Xpath.replace("TextValue", CheckBox))).isSelected()){
		pegaDriver.findElement(By.xpath(Chk_Search_Xpath.replace("TextValue", CheckBox))).click();}*/
		if(!pegaDriver.findElement(By.xpath(Chk_Search_Xpath)).isSelected()){
			pegaDriver.findElement(By.xpath(Chk_Search_Xpath)).click();}
		}
	}
	@Override
	public void Reindex(String ReindexOf){
		pegaDriver.switchToActiveFrame();
		pegaDriver.handleWaits().waitForDocStateReady();
		pegaDriver.switchToActiveFrame();
		int size=pegaDriver.findElements(By.xpath("//*[contains(text(),'All work')]/ancestor::td[1]/following-sibling::td/descendant::span[text()='Available']")).size();
		System.out.println("size***"+size);
		if(size<1){
		System.out.println("size inside***"+size);
		System.out.println("Inside reindex Available***");
		pegaDriver.switchToActiveFrame();
		pegaDriver.handleWaits().waitForElementClickable(By.xpath(Btn_Reindex.replace("TextValue", ReindexOf)));
		//pegaDriver.handleWaits().waitForElementVisibility(By.xpath(Btn_Reindex.replace("TextValue", ReindexOf)));
		pegaDriver.findElement(By.xpath(Btn_Reindex.replace("TextValue", ReindexOf))).click();
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath(Btn_ReindexOk)).click(false);
		pegaDriver.handleWaits().waitForAlert();
		pegaDriver.switchTo().alert().accept();
		try {
			Thread.sleep(5000);
	        WebDriverWait wait = new WebDriverWait(pegaDriver, 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = pegaDriver.switchTo().alert();
	        alert.accept();
	    } catch (Exception e) {
	        System.out.println("No elert found");
	    }
		//pegaDriver.handleWaits().waitForElementVisibility(By.xpath(Btn_CancelReindex));
		pegaDriver.handleWaits();
		pegaDriver.waitForDocStateReady(300);
		pegaDriver.handleWaits().waitForElementVisibility(pegaDriver.findElement(By.xpath("//*[contains(text(),'All work')]/ancestor::td[1]/following-sibling::td/descendant::span[text()='Available']")),180);
		pegaDriver.verifyElementVisible(By.xpath("//*[contains(text(),'All work')]/ancestor::td[1]/following-sibling::td/descendant::span[text()='Available']"));
		//pegaDriver.verifyElementVisible(By.xpath(Btn_Reindex.replace("TextValue", ReindexOf)));
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath(Btn_Reindex.replace("TextValue", ReindexOf)));
		}
	}
	@Override
	public OutboundPhoneCall createOutboundPhoneCall() {
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		OutboundPhoneCall outboundPhoneCall = new OutboundPhoneCallImpl(frameElmt, frameId);
		outboundPhoneCall._setEnvironment(testEnv, frameId);
		return outboundPhoneCall;
	}

	/*@Override
	public DialogsAndCoachingTips ConfigDialog() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//a[@title='Launch another portal']")).click();
		pegaDriver.findElement(By.xpath("//span[text()='Interaction Portal']")).click();
		pegaDriver.handleWaits().sleep(3);
		ArrayList<String> tabs = new ArrayList<String>(pegaDriver.getWindowHandles());
		pegaDriver.switchTo().window(tabs.get(1));
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		DialogsAndCoachingTips dialogsAndCoachingTips = new DialogsAndCoachingTipsImpl(frameElmt, frameId);
		dialogsAndCoachingTips._setEnvironment(testEnv, frameId);
		//dialogsAndCoachingTips._setEnvironment(null, "");
		return dialogsAndCoachingTips;
	}*/
	
	
	@Override
	public SocialInteraction launchTwitterCase(String customerName) {
//		pegaDriver.waitForDocStateReady(15);
		for(int i=0; i<10;i++)
		pegaDriver.waitForDocStateReady(5);
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//i[contains(@title,'View social cases')]")).click();
//		return findCaseAndLaunch(customerName);
		PegaWebElement openCasesTable = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'D_GetOpenSocialCasesFromWorklist.pxResults')]"));
		int openCasesCount = openCasesTable.findElements(By.tagName("tr")).size();
		System.out.println(openCasesCount);
		for(int i=1; i <= openCasesCount; i++)
		{
			
			PegaWebElement custNameWebElement = pegaDriver.findElement(By.xpath("//tr[contains(@id,'$PD_GetOpenSocialCasesFromWorklist')]/descendant::a[contains(@data-click,'pxResults("+i+")')]"));
			String custName = custNameWebElement.getText();
					System.out.println(custName);
						if(custName.equalsIgnoreCase(customerName))
						{
							
							custNameWebElement.click();
							break;
								
						}
		}
		
		pegaDriver.waitForDocStateReady(10);
		
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		SocialInteraction socialInteraction = new SocialInteractionImpl(frameElmt, frameId);
		socialInteraction._setEnvironment(testEnv, frameId);
		return socialInteraction;
		
		
	}

	public SocialInteraction findCaseAndLaunch(String customerName) {
		
//		String finalXpath = null;
		PegaWebElement openCasesTable = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'D_GetOpenSocialCasesFromWorklist.pxResults')]"));
		int openCasesCount = openCasesTable.findElements(By.tagName("tr")).size();
		System.out.println(openCasesCount);
		for(int i=1; i <= openCasesCount; i++)
		{
			
			PegaWebElement custNameWebElement = pegaDriver.findElement(By.xpath("//tr[contains(@id,'$PD_GetOpenSocialCasesFromWorklist')]/descendant::a[contains(@data-click,'pxResults("+i+")')][contains(text(),'"+customerName+"')]"));
			String custName = custNameWebElement.getText();
						System.out.println(custName);
						if(custName.equalsIgnoreCase(customerName))
						{
							
							custNameWebElement.click();
							break;
								
						}
		}
		
		pegaDriver.waitForDocStateReady(10);
		
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		SocialInteraction socialInteraction = new SocialInteractionImpl(frameElmt, frameId);
		socialInteraction._setEnvironment(testEnv, frameId);
		return socialInteraction;
			
//				
		
	}

	@Override
	public void startDataFlow() {
//		pegaDriver.switchTo().defaultContent();
//		 pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
//		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		  DropDown socialStreamDropDown = pegaDriver.findSelectBox(By.xpath("//select[@id='ProjectIDForStreams']"));
//		  socialStreamDropDown.selectByValue("CSSocialQA");
		  socialStreamDropDown.selectByVisibleText("SocialQAStream");
		  
		  if(pegaDriver.verifyElement(By.xpath("//button[@title = 'Start connector']")))
		  {
			  connectorsCount = pegaDriver.findElements(By.xpath("//button[@title = 'Start connector']")).size();
			  
			  
			  while(connectorsCount!=0)
			  {
				  
				  pegaDriver.findElement(By.xpath("(//button[@title = 'Start connector'])["+connectorsCount+"]")).click();
				  pegaDriver.waitForDocStateReady(2);
				  connectorsCount--;
			  }
		  }
		
	}
	@Override
	public void clickSearchConfiguration()
	{	
		//pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		String clicksearchconfiguration="//span[contains(.,'search results')]";
		PegaWebElement searchconfig = pegaDriver.findElement(By.xpath(clicksearchconfiguration));
		searchconfig.click();
		pegaDriver.waitForDocStateReady(2);
	}
	
	@Override
	public void stopDataFlow() {
//		pegaDriver.switchTo().defaultContent();
//		 pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		  DropDown socialStreamDropDown = pegaDriver.findSelectBox(By.xpath("//select[@id='ProjectIDForStreams']"));
//		  socialStreamDropDown.selectByValue("CSSocialQA");
		  socialStreamDropDown.selectByVisibleText("SocialQAStream");
		  
//		  PegaWebElement connectorsList = pegaDriver.findElement(By.xpath("//button[@title = 'Start connector']"));
		  connectorsCount = pegaDriver.findElements(By.xpath("//button[@title = 'Stop connector']")).size();
		  
		  
		  while(connectorsCount!=0)
		  {
			  
			  pegaDriver.findElement(By.xpath("(//button[@title = 'Stop connector'])["+connectorsCount+"]")).click();
			  pegaDriver.waitForDocStateReady(2);
			  connectorsCount--;
		  }
		
	}

	
	/*@Override
	public void checkDataFlow() {
		
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		pegaDriver.findElement(By.xpath("//i[@data-test-id,'201508110758590523161815']")).clear();
		pegaDriver.waitForDocStateReady(1);
		
		int startedConnectorsCount = pegaDriver.findElements(By.xpath("//button[@title = 'Stop connector']")).size();
		
		
		  
		  

		
		
		
	}
	*/
	@Override
	public void socialLogOutDS(){
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//i[@title='SocialQAAdmin']")).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(CS_IMPL_LogOff_XPATH)).click();
	
	}

	@Override
	public void modifyAccessGroup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createNewCase(String caseName, String stageName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createNewApplication(String builton, String type, String organization) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public SocialInteraction launchCaseViaGetMostUrgent() {
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//i[contains(@title,'View social cases')]")).click();
		
		PegaWebElement getMostUrgentWebElement = pegaDriver.findElement(By.xpath("//button[@title='Open most urgent case']"));
		getMostUrgentWebElement.click();
		
		pegaDriver.waitForDocStateReady(10);
		
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		SocialInteraction socialInteraction = new SocialInteractionImpl(frameElmt, frameId);
		socialInteraction._setEnvironment(testEnv, frameId);
		return socialInteraction;
	}
	
	

	@Override
	public void selectDataSource() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		DropDown datasource= pegaDriver.findSelectBox(By.xpath("//select[@title='Select data source']"));
		datasource.selectByVisibleText("Account");
		//String PortalSearchField="//input[@id='IsSearchable']";
		//PegaWebElement PortalSearch = pegaDriver.findElement(By.xpath(PortalSearchField));
		//PortalSearch.click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		String DefaultTabField="//input[@type='checkbox' and @id='IsSearchDefaultTab']";
		PegaWebElement DefaultTab = pegaDriver.findElement(By.xpath(DefaultTabField));
		DefaultTab.click();
		
	}
	@Override
	public void selectContactDataSource() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		DropDown datasource= pegaDriver.findSelectBox(By.xpath("//select[@title='Select data source']"));
		datasource.selectByVisibleText("Contact");
		//String PortalSearchField="//input[@id='IsSearchable']";
		//PegaWebElement PortalSearch = pegaDriver.findElement(By.xpath(PortalSearchField));
		//PortalSearch.click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		String DefaultTabField="//input[@type='checkbox' and @id='IsSearchDefaultTab']";
		PegaWebElement DefaultTab = pegaDriver.findElement(By.xpath(DefaultTabField));
		DefaultTab.click();
		
	}
	@Override
	public void selectOrganizationDataSource() {
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		String DefaultTabField="//input[@type='checkbox' and @id='IsSearchDefaultTab']";
		PegaWebElement DefaultTab = pegaDriver.findElement(By.xpath(DefaultTabField));
		DefaultTab.click();
		
	}
	@Override
	public void selectAccountDataSourceFields(DataTable AccountFields) {
		// TODO Auto-generated method stub
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		List<List<String>> listOfFields = AccountFields.raw();
		for(List<String> row:listOfFields){
			pegaDriver.switchToActiveFrame();
			PegaWebElement chbk1=pegaDriver.findElement(By.xpath("//span[text()='"+row.get(0)+"']/ancestor::td[1]/following-sibling::td[1]/descendant::input[@class='checkbox chkBxCtl']"));
			chbk1.click();
			pegaDriver.switchToActiveFrame();
			PegaWebElement chbk2=pegaDriver.findElement(By.xpath("//span[text()='"+row.get(0)+"']/ancestor::td[1]/following-sibling::td[2]/descendant::input[@class='checkbox chkBxCtl']"));
			chbk2.click();
			//Assert.assertTrue(row.get(0)+" Data Type is not available",
					//pegaDriver.verifyElement(By.xpath("//*[contains(text(),'"+row.get(0)+"')]")));
	
			
	}	
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		String SaveButton= "//button[@title='Save']";
		PegaWebElement save =pegaDriver.findElement(By.xpath(SaveButton));
		save.click();
	}

	@Override
	public void addDSMNode() {
		
        pegaDriver.waitForDocStateReady(2);
 		pegaDriver.switchTo().defaultContent();
 		pegaDriver.switchTo().frame("PegaGadget0Ifr");
        
        pegaDriver.findSelectBox(By.xpath("//select[@id='pyChosenInstance']")).selectByVisibleText("RealTime");
        
        pegaDriver.waitForDocStateReady(2);
  		pegaDriver.switchTo().defaultContent();
  		pegaDriver.switchTo().frame("PegaGadget0Ifr");
  		
  		if(!(pegaDriver.verifyElement(By.xpath("//span[text()='NORMAL']"))))
  		{
  		
	  		pegaDriver.findElement(By.xpath("//button[@data-test-id='add_node']")).click(false);
	  		
	  		pegaDriver.waitForDocStateReady(2);
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			
			
			pegaDriver.findElement(By.xpath("//i[@title='This node ']/ancestor::td/preceding-sibling::td[contains(@class,'gridCell')]/descendant::input[@id='pySelected1']")).click(false);
			pegaDriver.waitForDocStateReady(2);
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("PegaGadget0Ifr");
			
			
			pegaDriver.findElement(By.xpath("//button[@id='ModalButtonSubmit']")).click(false);
  		}
		
	}

	@Override
	public void openLandingPage(String designerStudio, String decisioning, String infrastructure, String services,
			String dataflow) {
		
		//pegaDriver.findElement(By.xpath(Link_DesignerStudio_Xpath)).click();
		String linkConfigure="//a[contains(text(),'Configure')]";
		pegaDriver.findElement(By.xpath(linkConfigure)).click();
		String decisioningXpath = "//span[text()='"+decisioning+"']/ancestor::li[@role='presentation']";
		testEnv.getScriptExecutor().mouseOver(pegaDriver.findElement(By.xpath(decisioningXpath)));
		pegaDriver.waitForDocStateReady(3);
//		String infrastructureXpath = decisioningXpath+
		testEnv.getScriptExecutor().mouseOver(pegaDriver.findElement(By.xpath("//span[text()='"+infrastructure+"']")));
		pegaDriver.waitForDocStateReady(3);
		testEnv.getScriptExecutor().mouseOver(pegaDriver.findElement(By.xpath("//span[text()='"+services+"']")));
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.findElement(By.xpath("//span[text()='"+dataflow+"']")).click(false);
		
		
		
	}
	
	public void addDSMNodesInDecisionDataStore() {

	pegaDriver.waitForDocStateReady(3);
	pegaDriver.switchTo().defaultContent();
	pegaDriver.switchTo().frame("PegaGadget0Ifr");
	int records=pegaDriver.findElements(By.xpath("//*[contains(text(),'Decision data store nodes')]/ancestor::div[@node_type='HEADER']/following-sibling::div[1]/descendant::span[@data-test-id='20160324112457098195328']")).size();
	//if((pegaDriver.findElements(By.xpath("//*[contains(text(),'Decision data store nodes')]/ancestor::div[@node_type='HEADER']/following-sibling::div[1]/descendant::span[text()='NORMAL']")).size()<1)&&(pegaDriver.findElements(By.xpath("//*[contains(text(),'Decision data store nodes')]/ancestor::div[@node_type='HEADER']/following-sibling::div[1]/descendant::span[text()='JOINING_FAILED']")).size()<1))
	if(records<1)
	{
		pegaDriver.findElement(By.xpath("(//button[@data-test-id='add_node'])[1]")).click(false);
		pegaDriver.waitForDocStateReady(5);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		//old  //i[@title='This node ']/ancestor::td/preceding-sibling::td[contains(@class,'gridCell')]/descendant::input[contains(@id,'pySelected')]
		pegaDriver.findElement(By.xpath("//i[@title='This node ']/ancestor::td/preceding-sibling::td[contains(@class,'gridCell')]/descendant::input[contains(@name,'pySelected') and contains(@type,'checkbox')]")).click(false);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		pegaDriver.findElement(By.xpath("//button[@id='ModalButtonSubmit']")).click(false);
	}

}

public void addDSMNodesInAdaptiveDecisionManager() {

	pegaDriver.waitForDocStateReady(3);
	pegaDriver.switchTo().defaultContent();
	pegaDriver.switchTo().frame("PegaGadget0Ifr");

	//if((pegaDriver.findElements(By.xpath("//*[contains(text(),'Decision data store nodes')]/ancestor::div[@node_type='HEADER']/following-sibling::div[1]/descendant::span[text()='NORMAL']")).size()<1)&&(pegaDriver.findElements(By.xpath("//*[contains(text(),'Decision data store nodes')]/ancestor::div[@node_type='HEADER']/following-sibling::div[1]/descendant::span[text()='JOINING_FAILED']")).size()<1))
	int records=pegaDriver.findElements(By.xpath("//*[contains(text(),'Adaptive decision manager')]/ancestor::div[@node_type='HEADER']/following-sibling::div[1]/descendant::span[@data-test-id='20160324112457098195328']")).size();
	if(records<1)
	{
		pegaDriver.findElement(By.xpath("(//button[@data-test-id='add_node'])[2]")).click(false);
		pegaDriver.waitForDocStateReady(5);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		// old //i[@title='This node ']/ancestor::td/preceding-sibling::td[contains(@class,'gridCell')]/descendant::input[contains(@id,'pySelected')]
		pegaDriver.findElement(By.xpath("//i[@title='This node ']/ancestor::td/preceding-sibling::td[contains(@class,'gridCell')]/descendant::input[contains(@name,'pySelected') and contains(@type,'checkbox')]")).click(false);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		pegaDriver.findElement(By.xpath("//button[@id='ModalButtonSubmit']")).click(false);
	}
}

public void addDSMNodesInDataFlow() {

	pegaDriver.waitForDocStateReady(2);
	pegaDriver.switchTo().defaultContent();
	pegaDriver.switchTo().frame("PegaGadget0Ifr");
	pegaDriver.findSelectBox(By.xpath("//select[@id='pyChosenInstance']")).selectByVisibleText("RealTime");

	pegaDriver.waitForDocStateReady(2);
	pegaDriver.switchTo().defaultContent();
	pegaDriver.switchTo().frame("PegaGadget0Ifr");
	//if(!(pegaDriver.verifyElement(By.xpath("//*[contains(text(),'Real-time nodes')]/ancestor::div[@node_type='HEADER']/following-sibling::div[1]/descendant::span[text()='NORMAL']"))))
	int records=pegaDriver.findElements(By.xpath("//*[contains(text(),'Real-time nodes')]/ancestor::div[@node_type='HEADER']/following-sibling::div[1]/descendant::span[@data-test-id='20160324112457098195328']")).size();
	if(records<1)
	{
		pegaDriver.findElement(By.xpath("(//button[@data-test-id='add_node'])[3]")).click(false);
		pegaDriver.waitForDocStateReady(5);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		//old xpath //i[@title='This node ']/ancestor::td/preceding-sibling::td[contains(@class,'gridCell')]/descendant::input[contains(@id,'pySelected')]
		pegaDriver.findElement(By.xpath("//i[@title='This node ']/ancestor::td/preceding-sibling::td[contains(@class,'gridCell')]/descendant::input[contains(@name,'pySelected') and contains(@type,'checkbox')]")).click(false);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		pegaDriver.findElement(By.xpath("//button[@id='ModalButtonSubmit']")).click(false);
	}

}

public void addDSMNodesInRealTimeDataGrid() {

	pegaDriver.waitForDocStateReady(3);
	pegaDriver.switchTo().defaultContent();
	pegaDriver.switchTo().frame("PegaGadget0Ifr");

	//if(!(pegaDriver.verifyElement(By.xpath("//*[contains(text(),'Real-time data grid nodes')]/ancestor::div[@node_type='HEADER']/following-sibling::div[1]/descendant::span[text()='NORMAL']"))))
	int records=pegaDriver.findElements(By.xpath("//*[contains(text(),'Real-time data grid nodes')]/ancestor::div[@node_type='HEADER']/following-sibling::div[1]/descendant::span[@data-test-id='20160324112457098195328']")).size();
	if(records<1)
	{
		pegaDriver.findElement(By.xpath("(//button[@data-test-id='add_node'])[4]")).click(false);
		pegaDriver.waitForDocStateReady(5);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		// old //i[@title='This node ']/ancestor::td/preceding-sibling::td[contains(@class,'gridCell')]/descendant::input[contains(@id,'pySelected')]
		pegaDriver.findElement(By.xpath("//i[@title='This node ']/ancestor::td/preceding-sibling::td[contains(@class,'gridCell')]/descendant::input[contains(@name,'pySelected') and contains(@type,'checkbox')]")).click(false);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		pegaDriver.findElement(By.xpath("//button[@id='ModalButtonSubmit']")).click(false);
	}

}

public void addDSMNodesInStream() {
	pegaDriver.waitForDocStateReady(3);
	pegaDriver.switchTo().defaultContent();
	pegaDriver.switchTo().frame("PegaGadget0Ifr");
	pegaDriver.waitForDocStateReady(5);
	//if(!(pegaDriver.verifyElement(By.xpath("//*[contains(text(),'Stream nodes')]/ancestor::div[@node_type='HEADER']/following-sibling::div[1]/descendant::span[text()='NORMAL']"))))
	int records=pegaDriver.findElements(By.xpath("//*[contains(text(),'Stream nodes')]/ancestor::div[@node_type='HEADER']/following-sibling::div[1]/descendant::span[@data-test-id='20160324112457098195328']")).size();
	if(records<1)
	{
		pegaDriver.findElement(By.xpath("(//button[@data-test-id='add_node'])[5]")).click(false);
		pegaDriver.waitForDocStateReady(5);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		// old //i[@title='This node ']/ancestor::td/preceding-sibling::td[contains(@class,'gridCell')]/descendant::input[contains(@id,'pySelected')]
		pegaDriver.findElement(By.xpath("//i[@title='This node ']/ancestor::td/preceding-sibling::td[contains(@class,'gridCell')]/descendant::input[contains(@name,'pySelected') and contains(@type,'checkbox')]")).click(false);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		pegaDriver.findElement(By.xpath("//button[@id='ModalButtonSubmit']")).click(false);
	}

}


public void switchToDSMTabs(String tabName) {
	//added newly
	pegaDriver.waitForDocStateReady(10);
	pegaDriver.findElement(By.xpath("//span[text()='"+tabName+"']")).click(false);
	pegaDriver.waitForDocStateReady(5);
}
	@Override
	public void SwitchToInteractionPortal() {
		pegaDriver.navigate().refresh();
		pegaDriver.switchTo().frame("FormFactoriFrame");
		pegaDriver.findElement(By.xpath("//i[contains(@title,'CS Manager') or contains(@title,'Manager')]")).click();
		pegaDriver.switchTo().frame("FormFactoriFrame");
		pegaDriver.findElement(By.xpath("//span[contains(text(),'Switch portal')]")).mouseOver();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//span[contains(text(),'Interaction Portal') or contains(text(),'Interaction portal')]"));
		pegaDriver.findElement(By.xpath("//span[contains(text(),'Interaction Portal') or contains(text(),'Interaction portal')]")).click(false);
		try {
			pegaDriver.handleWaits().waitForAlert();
			pegaDriver.switchTo().alert().accept();
			pegaDriver.handleWaits().waitForAlert();
			pegaDriver.switchTo().alert().accept();
			pegaDriver.handleWaits().waitForAlert();
			pegaDriver.switchTo().alert().accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void launchServiceProcessExpress() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(0);
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//a[@data-test-id='2014100609491604293426']"));
		pegaDriver.switchTo().frame(0);
		pegaDriver.findElement(By.xpath("//*[text()='Demo Screen Pops']")).mouseOver();
		pegaDriver.handleWaits().waitForElementVisibility(pegaDriver.findElement(By.xpath("//*[text()='']")));
		pegaDriver.findElement(By.xpath("//*[text()='']")).click();
		pegaDriver.switchTo().frame(0);
		pegaDriver.handleWaits().waitForElementVisibility(pegaDriver.findElement(By.xpath("//button[contains(.,'Accept')]")));
		pegaDriver.findElement(By.xpath("//button[contains(.,'Accept')]")).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().frame(0);
		pegaDriver.switchTo().frame("PegaGadget1Ifr");
		System.out.println("After switch**");
		pegaDriver.findElement(By.xpath("//button[@data-test-id='2014111401004903823658']")).click();
		pegaDriver.switchTo().frame(0);
		pegaDriver.switchTo().frame("PegaGadget1Ifr");
		pegaDriver.findElement(By.xpath("//a[text()='Complaint or Compliment' and @class='Add_task']")).doubleClick();
		pegaDriver.switchTo().frame(0);
		pegaDriver.switchTo().frame("PegaGadget2Ifr");
		pegaDriver.findElement(By.xpath("//div[text()='Complaint']")).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//button[@data-test-id='UIModeButton']")).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().frame(0);
		pegaDriver.switchTo().frame("PegaGadget2Ifr");
		pegaDriver.findElement(By.xpath("//div[text()='Complaint']")).mouseOver();
		pegaDriver.findElement(By.xpath("//a[@title='Edit this section']")).mouseOver();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().frame(0);
		pegaDriver.switchTo().frame("PegaGadget2Ifr");
		pegaDriver.findElement(By.xpath("//a[@title='Edit this section']")).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().frame(0);
		pegaDriver.switchTo().frame("PegaGadget2Ifr");
		pegaDriver.findElement(By.xpath("(//div[@class='mask-element'])[2]")).mouseOver();
		pegaDriver.findElement(By.xpath("(//div[@class='mask-element'])[2]")).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().frame(0);
		pegaDriver.switchTo().frame("PegaGadget2Ifr");
		pegaDriver.switchTo().defaultContent();
		pegaDriver.waitForDocStateReady();
		pegaDriver.findElement(By.xpath("(//i[@data-test-id='region-header-add-icon'])[1]")).click();
		pegaDriver.waitForDocStateReady();pegaDriver.findElement(By.xpath("//span[text()=' Account number ']/ancestor::div[1]/following-sibling::div[2]/descendant::i[@data-test-id='add-field-icon']")).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.findElement(By.xpath("//span[contains(text(),'Add')]/ancestor::div[1]/preceding-sibling::div[1]/span/i[@data-test-id='panel-close-button']")).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.findElement(By.xpath("//span[contains(text(),'Account number') and @data-test-id='layout-editor-cell-label']")).rightClick();
		pegaDriver.waitForDocStateReady();
		pegaDriver.findElement(By.xpath("//*[text()='Delete']")).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.findElement(By.xpath("//span/i[@data-test-id='panel-close-button' and @title='Close' and contains(@class,'layout-editor-close')]")).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.findElement(By.xpath("//button[@data-test-id='UIModeButton']")).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().frame(0);
		pegaDriver.switchTo().frame("PegaGadget2Ifr");
		pegaDriver.findElement(By.xpath("//i[@data-test-id='20150102034115038933900' and @title='Wrap Up']")).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().frame(0);
		pegaDriver.switchTo().frame("PegaGadget1Ifr");
		pegaDriver.findElement(By.xpath("//button[@data-test-id='2014111404305809971010']")).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(0);
		pegaDriver.findElement(By.xpath("//i[contains(@title,'CS') or contains(@title,'CA') or contains(@title,'Mike Jones') or contains(@title,'socialqa') or contains(@title,'SocialQAAdmin')]")).click(false);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(0);
		pegaDriver.findElement(By.xpath("//*[text()='Logout']")).click(false);
		pegaDriver.switchTo().alert().accept();
		pegaDriver.switchTo().defaultContent();
		
		
	}

	@Override
	public void clicksAddTaskExpress() {
		
		
	}

	@Override
	public void enableToggleMode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickOnEditWorkArea() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteField(String field) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifyDeletedField(String field) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void launchWarpupExpress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifyWrapUpDialogExpress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void completeWrapUpExpress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickAddField() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addField(String field) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeAddFieldWindow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableToggleMode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeTemplateWindow() {
		// TODO Auto-generated method stub
		
	}		
	
	
}
