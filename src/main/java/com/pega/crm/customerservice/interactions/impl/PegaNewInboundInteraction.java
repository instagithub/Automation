package com.pega.crm.customerservice.interactions.impl;

import java.awt.AWTException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.crm.customerservice.interactions.NewInboundInteraction;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;

public class PegaNewInboundInteraction extends PegaInteractions implements NewInboundInteraction{
	
	public String frameId = null;
	public Wizard newWizard = null;
	
	public PegaNewInboundInteraction(WebElement elmt, String frameId) {
		super(elmt, frameId);
		// TODO Auto-generated constructor stub
	}

	public PegaNewInboundInteraction(WebElement elmt) {
		super(elmt);
		// TODO Auto-generated constructor stub
	}
	
	public String getDate(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String dateAndTime = format.format(cal.getTime());
		return dateAndTime;
	}

	@Override
	public String createInboundCase(String channelType, String accNum, String contactId) throws AWTException {
		pegaDriver.switchToActiveFrame();
		PegaWebElement dateReceived = pegaDriver.findElement(By.xpath(DATE_RECEIVED_XPATH));
		dateReceived.sendKeys(getDate());
		pegaDriver.waitForDocStateReady(2);
		DropDown channel = pegaDriver.findSelectBox(By.id(CHANNEL_TYPE_ID));
		channel.selectByValue(channelType);
		PegaWebElement accountNumberTextBox = pegaDriver.findElement(By.id(ACCOUNT_NUMBER_ID));
		accountNumberTextBox.sendKeys(accNum);
		PegaWebElement contactIDBox = pegaDriver.findElement(By.id(CONTACT_ID));
		contactIDBox.sendKeys(contactId);
		/*PegaWebElement attachFile = pegaDriver.findElement(By.xpath("//button[text()='+ Attach a file']"));
		attachFile.click();
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement uploadFile = pegaDriver.findElement(By.xpath("//span[text()='File from device']"));
		uploadFile.click();
		pegaDriver.waitForDocStateReady(2);
		
		pegaDriver.findElement(By.id("$PpyAttachmentPage$ppxAttachName")).click();
		
		File file = new File(".\\Data\\SampleFile.txt");
		System.out.println(file.getAbsolutePath());
		StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		try{
		
		Robot robot = new Robot();
		
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);}catch (Exception e){
        	e.printStackTrace();
        }
		
        testEnv.getBrowser().switchToWindow(1);
        pegaDriver.findElement(By.xpath("//input[@onchange]")).sendKeys(System.getProperty("user.dir")+"\\Data\\SampleFile.txt");
        pegaDriver.findElement(By.id("MSOUploadButton")).click(false);
        testEnv.getBrowser().switchToWindow(1);
        String frameId = pegaDriver.getActiveFrameId(false);
        WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
        pegaDriver.switchTo().frame(frameElmt);
        
        pegaDriver.waitForDocStateReady(2);
        frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
        PegaWebElement attach = newWizard.findElement(By.xpath("//button[@title='Attach']"));
        attach.click();*/

		/*PegaWebElement filePath = newWizard.findElement(By.id(BROWSE_PATH_ID));
		File file = new File(".\\Data\\SampleFile.txt");
		System.out.println(file.getAbsolutePath());
		filePath.sendKeys(file.getAbsolutePath());
		PegaWebElement descTextBox = newWizard.findElement(By.id(DESC_ID));
		descTextBox.sendKeys("creating a new case for Inbound Interaction");*/
        pegaDriver.waitForDocStateReady(2);
		PegaWebElement submitButton = pegaDriver.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement interactionID = pegaDriver.findElement(By.xpath(INTERACTION_ID_XPATH));
		String intID = interactionID.getText();
		System.out.println(intID);
		PegaWebElement confirmButton = pegaDriver.findElement(By.xpath(CLOSE_THIS_BUTTON_XPATH));
		confirmButton.click(false);
		//pegaDriver.switchTo().defaultContent();
		//pegaDriver.findElement(By.xpath("//i[@title='Close Tab']")).click();
		/*pegaDriver.handleWaits();
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath(CLOSE_THIS_BUTTON_XPATH));
		pegaDriver.waitForDocStateReady(3);*/
		return intID;
		
	}
	
	@Override
	public void createInboundCaseWithoutmandatoryFields(){
		pegaDriver.switchToActiveFrame();
		PegaWebElement dateReceived = pegaDriver.findElement(By.xpath(DATE_RECEIVED_XPATH));
		dateReceived.sendKeys(getDate());
		       
        pegaDriver.waitForDocStateReady(2);
		PegaWebElement submitButton = pegaDriver.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
			
	}
	
	@Override
	public void inboundCaseWithFutureDate(String channelType){
		pegaDriver.switchToActiveFrame();
		PegaWebElement dateReceived = pegaDriver.findElement(By.xpath(DATE_RECEIVED_XPATH));
		dateReceived.sendKeys(getFutureDate());
		pegaDriver.waitForDocStateReady(2);
		DropDown channel = pegaDriver.findSelectBox(By.id(CHANNEL_TYPE_ID));
		channel.selectByValue(channelType);
       
        pegaDriver.waitForDocStateReady(2);
		PegaWebElement submitButton = pegaDriver.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
			
	}
	

	@Override
	public void searchInboundCase(String interactID) {
		
		//= createInboundCase();
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement workBasket = newWizard.findElement(By.xpath(WORKBASKET_LINK_XPATH));
		workBasket.click();
		DropDown workBasketSelect = newWizard.findSelectBox(By.id(WORKBASKET_INBOUND_ID));
		workBasketSelect.selectByValue("InboundCorrespondence");
		String finalXpath = new String(INBOUND_CASE_XPATH).replace("#id#", interactID);
		PegaWebElement inboundID = newWizard.findElement(By.xpath(finalXpath));
		System.out.println(finalXpath);
		inboundID.scrollIntoView();
		inboundID.click();
		//System.out.println("Opening the Inbound Interaction");
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();		
		
	}

	@Override
	public void configureEmailAndSend() {
		// TODO Auto-generated method stub
		
		String recipientsEmailId = "test_"+RandomStringUtils.randomAlphanumeric(5)+"@test.com";
		
		pegaDriver.switchToActiveFrame();
	    //Entering value in the Recipient Text Box.
		pegaDriver.findElement(By.id("ToRecipients")).sendKeys("recipientsEmailId");
		pegaDriver.findElement(By.id("corrSubject")).sendKeys("This is the Test Subject for the Correspondance Call");
		pegaDriver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
	}

	@Override
	public void clickSendCorrespondanceFromNextBestAction() {
		// TODO Auto-generated method stub
		
		pegaDriver.switchToActiveFrame();
		PegaWebElement pegaWebElement = pegaDriver.findElement(By.xpath("//a[@title='Suggested task         Send Correspondence   ']"));
		pegaWebElement.click();
	}

	@Override
	public void verifyStatusAndConfirmTask(PegaWebDriver pegaWebDriver) {
		// TODO Auto-generated method stub
		 pegaDriver.switchToActiveFrame();
		 By getStatusElement = By.xpath("//label[@for='pyStatusWork']/../div/div/a");
		 String actualText = commonMethods.getText(getStatusElement, pegaWebDriver);
		 String expectedText = "Resolved-Completed";
		 commonMethods.verifyResult(actualText, expectedText);
		 
		 pegaDriver.findElement(By.xpath("//button[@title='Confirm']")).click();
	}

	@Override
	public String createInboundCaseOnlyMandatoryFields() {
		// TODO Auto-generated method stub
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement dateReceived = newWizard.findElement(By.xpath(DATE_RECEIVED_XPATH));
		dateReceived.sendKeys(getDate());
		DropDown channelType = newWizard.findSelectBox(By.id(CHANNEL_TYPE_ID));
		channelType.selectByValue("email");
		PegaWebElement filePath = newWizard.findElement(By.id(BROWSE_PATH_ID));
		File file = new File(".\\Data\\SampleFile.txt");
		System.out.println(file.getAbsolutePath());
		filePath.sendKeys(file.getAbsolutePath());
		PegaWebElement descTextBox = newWizard.findElement(By.id(DESC_ID));
		descTextBox.sendKeys("creating a new case for Inbound Interaction");
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement interactionID = newWizard.findElement(By.xpath(INTERACTION_ID_XPATH));
		String intID = interactionID.getText();
		System.out.println(intID);
		PegaWebElement confirmButton = newWizard.findElement(By.xpath(NewInboundInteraction.CLOSE_BUTTON_XPATH));
		confirmButton.click(false);
		pegaDriver.waitForDocStateReady();
		return intID;
	}

	@Override
	public void searchAgain() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
		
	}
	
	@Override
	public void attachURL() {
		pegaDriver.switchToActiveFrame();
		PegaWebElement subjectfield = pegaDriver.findElement(By.xpath("//input[@id='pyNote']"));
		subjectfield.sendKeys(LINK_TEXT);
		
		PegaWebElement URLink = pegaDriver.findElement(By.xpath("//input[@id='pyURL']"));
		URLink.sendKeys(URL);
				
		PegaWebElement submit = pegaDriver.findElement(By.xpath("//button[@id='ModalButtonSubmit']"));
		submit.click();
	}
	
		
	
	
}
