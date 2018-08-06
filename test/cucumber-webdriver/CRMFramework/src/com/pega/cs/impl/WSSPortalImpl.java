package com.pega.cs.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.Browser;
import com.pega.Configuration;
import com.pega.TestEnvironment;
import com.pega.cs.SocialPortal;
import com.pega.cs.TestEnvironmentImpl;
import com.pega.cs.WSSPortal;
import com.pega.cs.interactions.Interactions;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.page.PortalImpl;
import com.pega.ri.Wizard;
//import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;
import com.pega.cs.utils.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WSSPortalImpl extends PortalImpl implements WSSPortal {

	public String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	public String VERSION = "$Id: CSPortalImpl.java 117333 2015-06-18 09:12:21Z MuraliKondapally $";

	private PegaWebDriver pegaDriver = null;
	public Wizard newWizard = null;
	public String finalXPath = null;
	public String frameId = null;
	public Configuration configuration;
	//public Browser browser = null;
	CommonMethods commonMethod = new CommonMethods(pegaDriver);

	public WSSPortalImpl(TestEnvironment testEnv) {
		super(testEnv);
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver();

	}

	public void loginToWSS() {
		String url = testEnv.getConfiguration().getURL();
		url = url+"/PRServletCustom?AppName=WSS";
		pegaDriver.get(url);
		

	}
	
	@Override
	public void loginByContact(String userId){
        
        //WebElement wsscontactname = pegaDriver.findElement(By.xpath(WSS_USER_NAME));
        Select contactname = new Select(pegaDriver.findElement(By.xpath(WSS_USER_NAME)));
        contactname.selectByValue(userId);
        pegaDriver.waitForDocStateReady(1);
        pegaDriver.findElement(By.xpath(WSS_LOGIN_BUTTON)).click(false);
               
  }


	public void initiateChat() {
		pegaDriver.switchTo().activeElement();
		pegaDriver.findElement(By.xpath("//div[text()='Need help?']")).click();
		// pegaDriver.findElement(By.xpath("//div[@class=\'headline\' and
		// text()=\'Need help?\']")).click();
		// DropDown squeue =
		// newWizard.findSelectBox(By.xpath("//select[@data-reactid='.0.2.1.0.2']"));
		// squeue.selectByVisibleText("Comms");

	}

	@Override
	public void wssLogout(String userName) {
        pegaDriver.switchTo().defaultContent();
        pegaDriver.findElement(By.xpath("//a[text()='"+userName+"']")).click(false);
        pegaDriver.findElement(By.xpath(SIGN_OUT)).click(false);
        pegaDriver.waitForDocStateReady(1);
        pegaDriver.quit();
        
  }


	public void sendChatMessage(String chatMessage) {
		pegaDriver.findElement(By.xpath("//input[@id=\'sendMessageField\']")).sendKeys(chatMessage);
		pegaDriver.findElement(By.xpath("//input[@id=\'sendMessageField\']")).sendKeys(Keys.ENTER);

	}


	public void addTask(String caseName) {

		WebElement iWantTo = pegaDriver.findElement(By.xpath("//select[@class='wss_quick_links']"));
		Select casename = new Select(iWantTo);
		casename.selectByValue(caseName);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame(caseName + "Ifr");

	}

	@Override
	public void loginByShortUrl(String appName) {
		configuration = testEnv.getConfiguration();		
		String URL = this.configuration.getURL()+"/PRServletCustom?AppName="+appName;
		System.out.println(URL);
		pegaDriver.get(URL);
		System.out.println(URL);

		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verifyLoggedUser(String usrName,PegaWebDriver pegaWebDriver) {
		pegaDriver.waitForDocStateReady(2);
		//pegaDriver.switchTo().defaultContent();
		String InitialXPath = "//span/a[@class='WSS_Help_and_Support' and contains(text(),'#name#')]";
		String FinalXpath = new String(InitialXPath).replace("#name#", usrName);
		pegaDriver.verifyElement(By.xpath(FinalXpath));
		
	}
	
	@Override
	public void conform() {
		pegaDriver.switchTo().frame("AddressChangeIfr");
		PegaWebElement submitButton = pegaDriver.findElement(By.xpath(CONFORM_BUTTON_XPATH));
		submitButton.click();
		
	}
	
	@Override
	public void changeAddressinWssPortal() {
		
		pegaDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
			pegaDriver.switchTo().frame("AddressChangeIfr");
			List<WebElement> changeAddress12 = pegaDriver.findElements(By.xpath(Interactions.ADDRESS_LINE1_XPATH));
			changeAddress12.get(0).clear();
			changeAddress12.get(0).sendKeys("123");
			
			
		
		/*PegaWebElement changeAddress1 = newWizard.findElement(By.xpath("//input[@id='AddressLine1'][1]"));
		changeAddress1.clear();
		changeAddress1.sendKeys("123");
		PegaWebElement changeAddress = newWizard.findElement(By.xpath("//input[@id='AddressLine2'][1]"));
		changeAddress.clear();
		changeAddress.sendKeys("New Street");
		DropDown CountryCode = newWizard.findSelectBox(By.xpath("//select[@id='CountryCode'][2]"));
		CountryCode.selectByValue("AUS");
		PegaWebElement zipCode = newWizard.findElement(By.xpath("//input[@id='ZipCode'][2]"));
		zipCode.clear();
		zipCode.sendKeys("11001 ");
		PegaWebElement city = newWizard.findElement(By.xpath("//input[@id='City'][2]"));
		city.clear();
		city.sendKeys("Sydney ");
		// DropDown stateCode =
		// newWizard.findSelectBox(By.xpath("//select[@id='StateCode']"));
		// stateCode.selectByValue("CO");
		PegaWebElement HomePhone = newWizard.findElement(By.xpath("//input[@id='HomePhone'][2]"));
		HomePhone.clear();
		HomePhone.sendKeys("12345659099 ");
		PegaWebElement CellPhone = newWizard.findElement(By.xpath("//input[@id='CellPhone']"));
		CellPhone.clear();
		CellPhone.sendKeys("2288909023 ");
		PegaWebElement Fax = newWizard.findElement(By.xpath("//input[@id='Fax']"));
		Fax.clear();
		Fax.sendKeys("2288909023 ");
		PegaWebElement Email = newWizard.findElement(By.xpath("//input[@id='Email']"));
		Email.clear();
		Email.sendKeys("test@pega.com ");*/
		PegaWebElement submitButton = pegaDriver.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Save'][1]"));
		submitButton.click();
	}

	@Override
	public void selectFlowAction(String option) {
		WebDriverWait wait = new WebDriverWait(pegaDriver, 120); 
		pegaDriver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Hello')]")));
		//pegaDriver.waitForDocStateReady(2);
		Select dropDown = new Select(pegaDriver.findElement(By.id("WSSAction")));
		dropDown.selectByVisibleText(option);
		
	}
	
	@Override
	public void selectAdditionalAccounts() {
		pegaDriver.switchTo().frame("AddressChangeIfr");
		PegaWebElement checkBox = pegaDriver.findElement(By.id("pyTemplateCheckbox"));
		checkBox.click();
		pegaDriver.switchTo().frame("AddressChangeIfr");
		PegaWebElement submitButton = pegaDriver.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Save'][1]"));
		submitButton.click();
		pegaDriver.switchTo().defaultContent();
		
	}
	
	
	@Override
	public void ConformChanges(String FlowType) {
		if(FlowType.equalsIgnoreCase("Dispute")){
			pegaDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame("ComplaintOrComplimentIfr");
			PegaWebElement submitButton = pegaDriver.findElement(By.xpath(CONFORM_BUTTON_XPATH));
			submitButton.click();
			
		}
		
		else if(FlowType.equalsIgnoreCase("Profile")){
			
			pegaDriver.switchToActiveFrame();
			pegaDriver.switchTo().frame("UpdateContactNameIfr");
			PegaWebElement submitButton = pegaDriver.findElement(By.xpath(CONFORM_BUTTON_XPATH));
			submitButton.click();
			
		}
		
	}
	
	@Override
	public void selectIssueAndIssueType(String type, String issueType) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("ComplaintOrComplimentIfr");
		DropDown typeDropDown = pegaDriver.findSelectBox(By.id("Category"));
		typeDropDown.selectByValue(type);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("ComplaintOrComplimentIfr");
		DropDown issueDropDown = pegaDriver.findSelectBox(By.id("Reason"));
		issueDropDown.selectByValue(issueType);
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("ComplaintOrComplimentIfr");
		List<WebElement> submitButton = pegaDriver.findElements(By.xpath(SAVE_BUTTON_XPATH));
		submitButton.get(1).click();
		
		
	}
	
	@Override
	public void selectTrancation() {
		pegaDriver.switchToActiveFrame();
		pegaDriver.switchTo().frame("DisputeTransactionIfr");
			
		List<WebElement> checkBox1 = pegaDriver.findElements(By.xpath("//input[@class='checkbox chkBxCtl' and @id='pySelected1']"));
		checkBox1.get(0).click();
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("DisputeTransactionIfr");
		
		List<WebElement> submitButton = pegaDriver.findElements(By.xpath(WSS_SUBMIT_BUTTON_XPATH));
		submitButton.get(0).click();
		
		
	}
	
	@Override
	public void updateProfile() {
		pegaDriver.switchToActiveFrame();
		pegaDriver.switchTo().frame("UpdateContactNameIfr");
		
		List<WebElement> Employeer = pegaDriver.findElements(By.xpath("//input[@id='Company']"));
		Employeer.get(1).clear();
		Employeer.get(1).sendKeys("BOA");
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("UpdateContactNameIfr");
		
		List<WebElement> submitButton = pegaDriver.findElements(By.xpath(SAVE_BUTTON_XPATH));
		submitButton.get(1).click();
		
	}
	
	@Override
	public void selectProfileLink() {
		WebDriverWait wait = new WebDriverWait(pegaDriver, 120); 
		pegaDriver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Hello')]")));
		pegaDriver.findElement(By.xpath("//a[@class='WSS_Std_Link' and text()='Update profile']")).click();
		
	}
	
	
	
}
