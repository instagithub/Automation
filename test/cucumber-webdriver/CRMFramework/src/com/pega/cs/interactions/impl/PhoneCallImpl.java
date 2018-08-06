package com.pega.cs.interactions.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pega.cs.interactions.PhoneCall;
import com.pega.cs.utils.CommonMethods;
import com.pega.framework.AutoComplete;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.page.Search;
import com.pega.ri.Wizard;

public class PhoneCallImpl extends InteractionsImpl implements PhoneCall {

	public String frameId = null;
	public Wizard newWizard = null;
	public CommonMethods commonMethods = null;
	public static String timeStamp="";

	public PhoneCallImpl(WebElement elmt, String frameId) {
		super(elmt, frameId);
		// TODO Auto-generated constructor stub
		commonMethods = new CommonMethods(pegaDriver);
	}

	public PhoneCallImpl(WebElement elmt) {
		super(elmt);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void searchCustomerByName(String lastName) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement lastNameElmt = newWizard.findElement(By.xpath(LAST_NAME_XPATH));
		//It is impacting many scripts , commenting the line having timestamp. If needed please create another method.
		//lastNameElmt.sendKeys(lastName+timeStamp);
		lastNameElmt.sendKeys(lastName);
		PegaWebElement search = newWizard.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();
		
	}
	@Override
	public void searchCustomerByLastName(String lastName) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement lastNameElmt = newWizard.findElement(By.xpath(LAST_NAME_XPATH));
		lastNameElmt.sendKeys(lastName+timeStamp);
		PegaWebElement search = newWizard.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();
	}
	@Override
	public void searchCustomerByAccountNumber(String accNum) {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement accNumber = newWizard.findElement(By.xpath(ACCOUNT_NO_XPATH));
		accNumber.sendKeys(accNum);
		PegaWebElement search = newWizard.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();
		
	}

/*	@Override
	public void selectCustomer() {
		PegaWebElement accountResult = newWizard.findElement(By.id(SEARCH_RESULT_ID));
		accountResult.click();
		PegaWebElement submit = newWizard.findElement(By.xpath(CONTACT_RESULT_SUBMIT_XPATH));
		submit.click();

	}*/

	/*@Override
	public void contactVerification() {
		PegaWebElement verificationCheckBox1 = pegaDriver.findElement(By.id(CONTACT_VERIFICATION_1_ID));
		verificationCheckBox1.check();
		PegaWebElement verificationCheckBox2 = pegaDriver.findElement(By.id(CONTACT_VERIFICATION_2_ID));
		verificationCheckBox2.check();
		PegaWebElement submit = pegaDriver.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submit.submit();
	}*/

	
	@Override
	public Map<String, String> verifySearchResult(PegaWebDriver webDriver) {

		// Verify the Result Text is present
		WebElement webElement = pegaDriver
				.findElement(By.xpath("//*[@class='field-item dataLabelWrite' and contains(text(),'Results')]"));
		String actualText = webElement.getText();
		commonMethods.verifyResult(actualText, "Results");

		Map<String, String> columnHeaderValue = new HashMap<String, String>();

		String column1 = commonMethods.getText(By.xpath("//div[@class='cellIn ' and contains(text(),'Last name')]"),
				pegaDriver);
		commonMethods.verifyResult(column1, "Last name");
		String value1 = commonMethods.getTextForSpecificElement(By.xpath("//*[@class='oflowDivM ']/span"), 0,
				pegaDriver);
		columnHeaderValue.put(column1, value1);

		String column2 = commonMethods.getText(By.xpath("//div[@class='cellIn ' and contains(text(),'First name')]"),
				pegaDriver);
		commonMethods.verifyResult(column2, "First Name");
		String value2 = commonMethods.getTextForSpecificElement(By.xpath("//*[@class='oflowDivM ']/span"), 1,
				pegaDriver);
		columnHeaderValue.put(column2, value2);

		String column3 = commonMethods.getText(By.xpath("//div[@class='cellIn ' and contains(text(),'City')]"),
				pegaDriver);
		commonMethods.verifyResult(column3, "City");
		String value3 = commonMethods.getTextForSpecificElement(By.xpath("//*[@class='oflowDivM ']/span"), 2,
				pegaDriver);
		columnHeaderValue.put(column3, value3);

		String column4 = commonMethods.getText(By.xpath("//div[@class='cellIn ' and contains(text(),'State')]"),
				pegaDriver);
		commonMethods.verifyResult(column4, "State");
		String value4 = commonMethods.getTextForSpecificElement(By.xpath("//*[@class='oflowDivM ']/span"), 3,
				pegaDriver);
		columnHeaderValue.put(column4, value4);

		return columnHeaderValue;
	}

/*	@Override
	public void searchByCustomerNameAndAccountNo(String lastName, String accountNum) {
		PegaWebElement pegaWebElement = pegaDriver.findElement(By.id(LAST_NAME_ID));
		pegaWebElement.clear();
		pegaWebElement.sendKeys(lastName);
		pegaWebElement = pegaDriver.findElement(By.id(ACCOUNT_NO_ID));
		pegaWebElement.clear();
		pegaWebElement.sendKeys(accountNum);
		PegaWebElement search = newWizard.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();
	}*/

	@Override
	public Map<String, String> verifySearchResultWithAccountNo(PegaWebDriver pegaWebDriver) {
		// TODO Auto-generated method stub
		Map<String, String> columnHeaderValue = new HashMap<String, String>();

		String column1 = commonMethods.getText(By.xpath("//div[@class='cellIn ' and contains(text(),'Last name')]"),
				pegaDriver);
		commonMethods.verifyResult(column1, "Last name");
		String value1 = commonMethods.getTextForSpecificElement(By.xpath("//tr[@pl_index='1']/td/div/span"), 0,
				pegaDriver);
		columnHeaderValue.put(column1, value1);

		String column2 = commonMethods.getText(By.xpath("//div[@class='cellIn ' and contains(text(),'First name')]"),
				pegaDriver);
		commonMethods.verifyResult(column2, "First Name");
		String value2 = commonMethods.getTextForSpecificElement(By.xpath("//tr[@pl_index='1']/td/div/span"), 1,
				pegaDriver);
		columnHeaderValue.put(column2, value2);

		String column3 = commonMethods.getText(By.xpath("//div[@class='cellIn ' and contains(text(),'City')]"),
				pegaDriver);
		commonMethods.verifyResult(column3, "City");
		String value3 = commonMethods.getTextForSpecificElement(By.xpath("//tr[@pl_index='1']/td/div/span"), 2,
				pegaDriver);
		columnHeaderValue.put(column3, value3);

		String column4 = commonMethods.getText(By.xpath("//div[@class='cellIn ' and contains(text(),'State')]"),
				pegaDriver);
		commonMethods.verifyResult(column4, "State");
		String value4 = commonMethods.getTextForSpecificElement(By.xpath("//tr[@pl_index='1']/td/div/span"), 3,
				pegaDriver);
		columnHeaderValue.put(column4, value4);

		String column5 = commonMethods
				.getText(By.xpath("//div[@class='cellIn ' and contains(text(),'Account number')]"), pegaDriver);
		commonMethods.verifyResult(column5, "Account Number");
		String value5 = commonMethods.getTextForSpecificElement(By.xpath("//tr[@pl_index='1']/td/div/span"), 4,
				pegaDriver);
		columnHeaderValue.put(column5, value5);

		String column6 = commonMethods.getText(By.xpath("//div[@class='cellIn ' and contains(text(),'Type')]"),
				pegaDriver);
		commonMethods.verifyResult(column6, "Type");
		String value6 = commonMethods.getTextForSpecificElement(By.xpath("//tr[@pl_index='1']/td/div/span"), 5,
				pegaDriver);
		columnHeaderValue.put(column6, value6);

		String column7 = commonMethods.getText(By.xpath("//div[@class='cellIn ' and contains(text(),'Role')]"),
				pegaDriver);
		commonMethods.verifyResult(column7, "Role");
		String value7 = commonMethods.getTextForSpecificElement(By.xpath("//div[@class='oflowDivM ']"), 6, pegaDriver);
		columnHeaderValue.put(column7, value7);
		return columnHeaderValue;
	}

	@Override
	public String verifyInvaidInputResult() {
		// TODO Auto-generated method stub
		String text = commonMethods.getTextForSpecificElement(
				By.xpath("//li[contains(text(),'Unable to find any contacts with given inputs')]"), 0, pegaDriver);
		return text;
	}

	@Override
	public void verifyExitInteractionWindowAndSubmitComment() {
		// TODO Auto-generated method stub
		pegaDriver.switchToActiveFrame();
		String actualText = commonMethods.getText(By.xpath("//span[@class='heading_2']"), pegaDriver);
		commonMethods.verifyResult(actualText, "Exit Interaction");

		pegaDriver.findElement(By.id("CancelNotes")).sendKeys("Exit Interaction");
		pegaDriver.findElement(By.xpath("//div[contains(text(),'Submit')]")).click();
	}

	@Override
	public Map<String, String> createNewContactBasicInfo() {
		// TODO Auto-generated method stub
		Map<String, String> mapValues = new HashMap<String, String>();

		pegaDriver.switchToActiveFrame();

		String firstName = "FirstName_" + RandomStringUtils.randomAlphabetic(5);
		String lastName = "LastName_" + RandomStringUtils.randomAlphabetic(5);
		String motherName = "MotherName_" + RandomStringUtils.randomAlphabetic(5);
		String ssnNo = "SSN_" + RandomStringUtils.randomNumeric(4);

		// Entering the values in the map
		mapValues.put("FirstName", firstName);
		mapValues.put("LastName", lastName);

		// Entering the Basic Info for the New Contact

		pegaDriver.findElement(By.id("FirstName")).sendKeys(firstName);
		pegaDriver.findElement(By.id("LastName")).sendKeys(lastName);
		PegaWebElement pegaWebElement = pegaDriver.findElement(By.xpath("//select[@title='Month']"));
		Select select = new Select(pegaWebElement);
		select.selectByVisibleText("August");
		pegaWebElement = pegaWebElement.findElement(By.xpath("//select[@title='Day']"));
		select = new Select(pegaWebElement);
		select.selectByVisibleText("10");
		pegaWebElement = pegaWebElement.findElement(By.xpath("//select[@title='Year']"));
		select = new Select(pegaWebElement);
		select.selectByVisibleText("1989");
		pegaDriver.findElement(By.id("Company")).sendKeys("Pega");
		pegaDriver.findElement(By.id("Occupation")).sendKeys("IT-Services");
		pegaDriver.findElement(By.id("GenderM")).click();

		// Entering the Verification Settings
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.id("SocialSecurityNumber")).sendKeys(ssnNo);
		pegaDriver.findElement(By.id("MotherMaidenName")).sendKeys(motherName);
		pegaWebElement = pegaDriver.findElement(By.id("SecurityQuestion"));
		select = new Select(pegaWebElement);
		select.selectByValue("What city were you born in?");
		pegaDriver.findElement(By.id("SecurityAnswer")).sendKeys("City");

		// Enter the Communication Preferences
		pegaDriver.switchToActiveFrame();
		pegaWebElement = pegaDriver.findElement(By.id("CommunicationPreference"));
		select = new Select(pegaWebElement);
		select.selectByValue("Phone");
		pegaWebElement = pegaDriver.findElement(By.id("BestTimeToCall"));
		select = new Select(pegaWebElement);
		select.selectByValue("2pm-4pm");
		pegaWebElement = pegaDriver.findElement(By.id("Language"));
		select = new Select(pegaWebElement);
		select.selectByValue("English");

		// Enter the Marketing Preferences
		pegaDriver.findElement(By.id("NoMarketing")).click();

		// Clicking Submit Button
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath("//div[contains(text(),'Submit')]")).click();
		return mapValues;
	}

	@Override
	public void createPrimaryContactAddress() {
		// TODO Auto-generated method stub

		pegaDriver.switchToActiveFrame();

		String address1 = "Address1_" + RandomStringUtils.randomAlphabetic(6);
		String city = "Test City";
		String postalCode = "500989";

		// Entering the Primary Address

		pegaDriver.findElement(By.id("AddressLine1")).sendKeys(address1);
		pegaDriver.findElement(By.id("City")).sendKeys(city);
		pegaDriver.findElement(By.id("ZipCode")).sendKeys(postalCode);
		PegaWebElement pegaWebElement = pegaDriver.findElement(By.id("StateCode"));
		Select select = new Select(pegaWebElement);
		select.selectByValue("AR");
		pegaWebElement = pegaDriver.findElement(By.xpath(COUNTRY_CODE_XPATH));
		select = new Select(pegaWebElement);
		select.selectByValue("USA");

		// Clicking on the Submit Button
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath("//div[contains(text(),'Submit')]")).click();
	}

	@Override
	public void enterCommunicatioOption() {
		// TODO Auto-generated method stub
		pegaDriver.switchToActiveFrame();

		String phoneNo = RandomStringUtils.randomNumeric(10);
		String faxNo = RandomStringUtils.randomNumeric(10);
		String primaryEmail = "test@testmail.com";

		// Entering Contact Communication Options
		PegaWebElement pegaWebElement = pegaDriver.findElement(By.id("CommunicationType"));
		Select select = new Select(pegaWebElement);
		select.selectByValue("Phone3");
		pegaDriver.findElement(By.id("ContactString")).sendKeys(phoneNo);

		pegaWebElement = pegaDriver.findElement(By.id("CommunicationType1"));
		select = new Select(pegaWebElement);
		select.selectByValue("Fax2");
		pegaDriver.findElement(By.id("ContactString1")).sendKeys(faxNo);

		pegaWebElement = pegaDriver.findElement(By.id("CommunicationType2"));
		select = new Select(pegaWebElement);
		select.selectByValue("Email2");
		pegaDriver.findElement(By.id("ContactString2")).sendKeys(primaryEmail);

		// Clicking on the Submit Button
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath("//div[contains(text(),'Submit')]")).click();
	}

/*	@Override
	public void clickOnToolsMenuButton() {
		pegaDriver.waitForDocStateReady(1);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement toolsMenu = pegaDriver.findElement(By.xpath("//button[@title='Tools Menu']"));
		toolsMenu.click();
		pegaDriver.waitForDocStateReady(1);

	}

	@Override
	public void clickOnOtherActionsButton() {
		pegaDriver.waitForDocStateReady(1);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement otherActions = pegaDriver.findElement(By.xpath("//button[@title='Other Actions']"));
		otherActions.click();
		pegaDriver.waitForDocStateReady(1);

	}*/
	

	
/*	@Override
	public String verifyCompletedTask(String serviceProcess) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		String SERVICE_PROCESS_XPATH = "//a[text()='#sericecase#' and @class='Standard_task']";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#sericecase#", serviceProcess);
		return finalXPath; 
		
	}*/
	
/*	@Override
	public void changeAddress() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement changeAddress1 = newWizard.findElement(By.xpath("//input[@id='AddressLine1']"));
		changeAddress1.clear();
		changeAddress1.sendKeys("123");
		PegaWebElement changeAddress = newWizard.findElement(By.xpath("//input[@id='AddressLine2']"));
		changeAddress.clear();
		changeAddress.sendKeys("New Street");
		DropDown CountryCode = newWizard.findSelectBox(By.xpath("//select[@id='CountryCode']"));
		CountryCode.selectByValue("AUS");
		PegaWebElement zipCode = newWizard.findElement(By.xpath("//input[@id='ZipCode']"));
		zipCode.clear();
		zipCode.sendKeys("11001 ");
		PegaWebElement city = newWizard.findElement(By.xpath("//input[@id='City']"));
		city.clear();
		city.sendKeys("Sydney ");
		//DropDown stateCode = newWizard.findSelectBox(By.xpath("//select[@id='StateCode']"));
		//stateCode.selectByValue("CO");
		PegaWebElement HomePhone = newWizard.findElement(By.xpath("//input[@id='HomePhone']"));
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
		Email.sendKeys("test@pega.com ");
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
	}*/
	
	/*@Override
	public void changeAdditionalAddress() {
		PegaWebElement checkBox = newWizard.findElement(By.id(ADDRESS_CHANGE_CHECKBOX_ID));
		checkBox.click();
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
		
	}*/

/*	@Override
	public void confirmAddressChange() {
		PegaWebElement confirmButton = newWizard.findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);	
		pegaDriver.waitForDocStateReady(3);
		
	}*/
	
	/*@Override
	public String getCaseID() {
		PegaWebElement toolsButton = pegaDriver.findElement(By
				.xpath("//button[@title='Tools Menu']"));
		toolsButton.click(false);
		String caseID = null;
		// String parentHandle = driver.getWindowHandle();
		PegaWebElement viewHistory = pegaDriver.findElement(By
				.xpath("//span[text()='History and Attachments']"));
		viewHistory.click();
		testEnv.getBrowser().switchToWindow(2);

		PegaWebElement id = pegaDriver.findElement(By
				.xpath("//span[contains(text(),'I-') or contains(text(),'S-')]"));
		caseID = id.getText();
		PegaWebElement closeButton = pegaDriver.findElement(By
				.xpath("//td[@id='HeaderButtonIconsTDId']//*[@title='Cancel ']"));
		closeButton.click(false);
		testEnv.getBrowser().close();
		testEnv.getBrowser().switchToWindow(1);
		//return caseID;
		return null;
	}*/
	
	
	/*@Override
	public void launchWrapup() {
		
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement wrapUp = newWizard.findElement(By.xpath(WRAP_UP_XPATH));
		wrapUp.click();
	}*/

/*	@Override
	public void completeWrapUp(String reason) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown disposition = newWizard.findSelectBox(By.xpath("//select[@id='ReasonForInteraction']"));
		disposition.selectByValue(reason);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		pegaDriver.switchToActiveFrame();
		
	}*/


	@Override
	public void searchPhoneNumber(String phoneNumber) {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
        newWizard  = pegaDriver.findWizard(frameId);
        PegaWebElement collapseIcon = newWizard.findElement(By.xpath("//div[@title='Disclose Advanced search']"));
        collapseIcon.click();
		PegaWebElement phNumber = newWizard.findElement(By.id(SEARCH_PHONE_NUMBER));
		phNumber.sendKeys(phoneNumber);
		PegaWebElement search = newWizard.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();
	}



/*	@Override
	public void confirmFlow() {
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement confirmButton = newWizard.findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);	
		pegaDriver.waitForDocStateReady(3);
		
	}*/


	
	@Override
    public void searchByBUName(String buName) {
           pegaDriver.switchToActiveFrame();
           frameId = pegaDriver.getActiveFrameId(false);
           newWizard = pegaDriver.findWizard(frameId);
           PegaWebElement collapseIcon = newWizard.findElement(By.xpath("//div[@title='Disclose Advanced search']"));
           collapseIcon.click();
           PegaWebElement bUnit = newWizard.findElement(By.id(BU_NAME_ID));
           bUnit.sendKeys(buName);
           PegaWebElement search = newWizard.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
           search.click();            
    }

    @Override
    public void selectBUContact() {
           pegaDriver.switchToActiveFrame();
           frameId = pegaDriver.getActiveFrameId(false);
           newWizard  = pegaDriver.findWizard(frameId); 
           PegaWebElement bUnitName = newWizard.findElement(By.xpath(BU_CONTACT_NAME_XPATH));
           bUnitName.click();
           PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
           submitButton.click(false);
           pegaDriver.waitForDocStateReady(2);
    }


	@Override
	public void searchByEmail(String emailId) {
		 pegaDriver.switchToActiveFrame();
		 frameId = pegaDriver.getActiveFrameId(false);
	     newWizard  = pegaDriver.findWizard(frameId);
	     PegaWebElement collapseIcon = newWizard.findElement(By.xpath("//div[@title='Disclose Advanced search']"));
         collapseIcon.click();
         PegaWebElement email = newWizard.findElement(By.id(SEARCH_EMAIL_ID));
         email.sendKeys(emailId);
         PegaWebElement search = newWizard.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
         search.click();  
		
	}
	
	public String getTomorrowDate(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String newDate = format.format(cal.getTime());
		return newDate;
	}

	@Override
	public void scheduleActivity(String type, String account, String topic, String assign, String operator) {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
        newWizard  = pegaDriver.findWizard(frameId); 
		PegaWebElement activity = newWizard.findElement(By.xpath("//div[text()='Conference call']"));
		activity.click();
		PegaWebElement date = newWizard.findElement(By.id("StartDate"));
		date.sendKeys(getTomorrowDate());
		DropDown linkAccount = newWizard.findSelectBox(By.id("SelectedAccountNumber"));
		linkAccount.selectByValue(account);
		DropDown topicValue = newWizard.findSelectBox(By.id("Topic"));
		topicValue.selectByValue(topic);
		DropDown schedule = newWizard.findSelectBox(By.id("ScheduleFor"));
		schedule.selectByValue(assign);
		pegaDriver.waitForDocStateReady(1);
		DropDown opName = newWizard.findSelectBox(By.id("Operator"));
		opName.selectByValue(operator);
		DropDown otherPhone = newWizard.findSelectBox(By.id("TelephoneNumber"));
		otherPhone.selectByValue("Other");
		pegaDriver.waitForDocStateReady(1);
		PegaWebElement phnum = newWizard.findElement(By.xpath("//input[@id='OtherPhone']"));
		phnum.sendKeys("987654321");
						
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
        submitButton.click(false);
        pegaDriver.waitForDocStateReady(2);
        
        //PegaWebElement resolve = newWizard.findElement(By.xpath("//label[@for='ActionTakenResolve']"));
        //resolve.click();
        
        //submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
        //submitButton.click();
        /*pegaDriver.waitForDocStateReady(1);
        pegaDriver.handleWaits().waitForAlert();
    	pegaDriver.switchTo().alert().accept();*/
    		
        
	}

	@Override
	public void searchSSNNumber(String SSNNumber) {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
        newWizard  = pegaDriver.findWizard(frameId); 
        PegaWebElement collapseIcon = newWizard.findElement(By.xpath("//div[@title='Disclose Advanced search']"));
        collapseIcon.click();
		PegaWebElement ssnNumber = newWizard.findElement(By.id(SEARCH_SSN_ID));
		ssnNumber.sendKeys(SSNNumber);
		PegaWebElement search = newWizard.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();
		
	}
	
	@Override
	public void launchAddressChangeEditLink() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement editLink = newWizard.findElement(By.xpath("//a[@title='Edit account address']"));
		editLink.click();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
	}

	@Override
	public void modifyAccountLinks(String accNum, String role) {
		 //pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(2);
        frameId = pegaDriver.getActiveFrameId(false);
        newWizard  = pegaDriver.findWizard(frameId);
         PegaWebElement addButton = newWizard.findElement(By.xpath(ADD_NEW_ACCOUNT_ASSOCIATION_XPATH));
         addButton.click();
         pegaDriver.waitForDocStateReady(2);
         if(accNum.equalsIgnoreCase("1234500078963456")||accNum.equalsIgnoreCase("123450000")){
        	 
        	 //PegaWebElement account = pegaDriver.findElement(By.id("AccountNumber1"));
        	 AutoComplete dp= pegaDriver.findAutoComplete(By.xpath("//input[contains(@id,'AccountNumber')]"));
        	 dp.sendKeys(accNum);
          }
         
         else {
        	 AutoComplete dp= pegaDriver.findAutoComplete(By.xpath("//input[contains(@id,'AccountNumber')]"));
        	 dp.sendKeys(accNum);
		}
         
         pegaDriver.waitForDocStateReady(2);
         //DropDown roleType = newWizard.findSelectBox(By.xpath("//select[@id='RoleType' or @id='RoleId']"));
         /*DropDown roleType = newWizard.findSelectBox(By.xpath("//select[contains(@id,'RoleId')]"));
         roleType.click();
         //roleType = newWizard.findSelectBox(By.xpath("//select[@id='RoleType' or @id='RoleId']"));
         roleType = newWizard.findSelectBox(By.xpath("//select[contains(@id,'RoleId')]"));
         */
         Select roleType= new Select(pegaDriver.findElement(By.xpath("//select[contains(@name,'RoleId')]")));
         roleType.selectByVisibleText(role);
         pegaDriver.waitForDocStateReady(3);
         PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
         submitButton.click();
         pegaDriver.waitForDocStateReady(5);
	}



	/*@Override
	public void searchPreviousCaseId(String caseID) {
		pegaDriver.switchToActiveFrame();
		PegaWebElement collapseIcon = newWizard.findElement(By.xpath("//div[@title='Disclose Advanced search']"));
        collapseIcon.click();
		PegaWebElement prevCaseID = pegaDriver.findElement(By.id("SearchStringWorkID"));
		prevCaseID.sendKeys(caseID);
		PegaWebElement search = pegaDriver.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();
		
	}*/
	
	@Override
	public void enterMandatoryFieldsInContacts(String Fitstname, String lastname, String mailid) {
		Random rand = new Random();
		int r= rand.nextInt(1000)+1;
		String s = String.valueOf(r);
		String initialmail = mailid+"#number#@mail.com";
		String finalmail = new String(initialmail).replace("#number#", s);
		
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown prefix =newWizard.findSelectBox(By.xpath(NEW_CONTACT_PREFIX_XPATH));
		prefix.selectByValue("Mr.");
		PegaWebElement firstName = newWizard.findElement(By.xpath(NEW_CONTACT_FIRST_NAME_XPATH));
		firstName.sendKeys(Fitstname);
		PegaWebElement lastName = newWizard.findElement(By.xpath(NEW_CONTACT_LAST_NAME_XPATH));
		lastName.sendKeys(lastname);
		PegaWebElement homeEmail = newWizard.findElement(By.xpath(NEW_CONTACT_PRIMARY_MAIL_ID_XPATH));
		homeEmail.sendKeys(finalmail);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
							
	}
	
	@Override
	public void newContactWithMandatoryFields(String FirstName, String LastName, String MailId) {
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown prefix =newWizard.findSelectBox(By.xpath(NEW_CONTACT_PREFIX_XPATH));
		prefix.selectByValue("Mr.");
		PegaWebElement firstName = newWizard.findElement(By.xpath(NEW_CONTACT_FIRST_NAME_XPATH));
		firstName.sendKeys(FirstName);
		PegaWebElement lastName = newWizard.findElement(By.xpath(NEW_CONTACT_LAST_NAME_XPATH));
		lastName.sendKeys(LastName+timeStamp);
		PegaWebElement homeEmail = newWizard.findElement(By.xpath(NEW_CONTACT_PRIMARY_MAIL_ID_XPATH));
		homeEmail.sendKeys(MailId+timeStamp+"@mail.com");
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
							
	}
	@Override
	public void enterAllFieldsInContactCreation() {
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown Prefix = newWizard.findSelectBox(By.xpath(NEW_CONTACT_PREFIX_XPATH));
		Prefix.selectByVisibleText("Mr.");
		PegaWebElement firstName = newWizard.findElement(By.xpath(NEW_CONTACT_FIRST_NAME_XPATH));
		firstName.sendKeys("Test FN");
		PegaWebElement middleName = newWizard.findElement(By.xpath("//input[@id='MiddleName']"));
		middleName.sendKeys("Test MN");		
		PegaWebElement lastName = newWizard.findElement(By.xpath(NEW_CONTACT_LAST_NAME_XPATH));
		lastName.sendKeys("LN"+timeStamp);
		//PegaWebElement businessEmail = newWizard.findElement(By.xpath("//input[@id='ContactString' and @name = '$PAppQueryEmailParams$ppxResults$l2$pContactString']"));
		PegaWebElement businessEmail = newWizard.findElement(By.id("SecondaryEmail"));
		businessEmail.sendKeys("buss"+timeStamp+"@mail.com");
		//PegaWebElement homeEmail = newWizard.findElement(By.xpath("//input[@id='ContactString' and @name = '$PAppQueryEmailParams$ppxResults$l1$pContactString']"));
		PegaWebElement homeEmail = newWizard.findElement(By.xpath(NEW_CONTACT_PRIMARY_MAIL_ID_XPATH));
		homeEmail.sendKeys("home"+timeStamp+"@mail.com");
		//PegaWebElement homePhone = newWizard.findElement(By.xpath("//input[@id='ContactString' and @name = '$PAppQueryPhoneParams$ppxResults$l1$pContactString']"));
		PegaWebElement homePhone = newWizard.findElement(By.id("PrimaryPhoneNumber"));
		homePhone.sendKeys("1234567890");
		//PegaWebElement businessPhone = newWizard.findElement(By.xpath("//input[@id='ContactString' and @name = '$PAppQueryPhoneParams$ppxResults$l2$pContactString']"));
		PegaWebElement businessPhone = newWizard.findElement(By.id("SecondaryPhoneNumber"));
		businessPhone.sendKeys("0987654321");
		DropDown month = newWizard.findSelectBox(By.xpath("//select[contains(@title,'Month')]"));
		month.selectByIndex(2);
		DropDown day = newWizard.findSelectBox(By.xpath("//select[contains(@title,'Day')]"));
		day.selectByIndex(22);
		DropDown year = newWizard.findSelectBox(By.xpath("//select[contains(@title,'Year')]"));
		year.selectByIndex(10);
		
		//Home Address
		PegaWebElement homeAdrsline1 = newWizard.findElement(By.xpath("(//input[@data-test-id='2015052602433300441401'])[1]"));
		homeAdrsline1.sendKeys("123");
		PegaWebElement homeAdrsline2 = newWizard.findElement(By.xpath("(//input[@data-test-id='2015052602433300462870'])[1]"));
		homeAdrsline2.sendKeys("New Street");
		DropDown CountryCode = newWizard.findSelectBox(By.xpath("(//select[@data-test-id='20151104070027020222217'])[1]"));
		CountryCode.selectByValue("AUS");
		PegaWebElement zipCode = newWizard.findElement(By.xpath("(//input[@id='ZipCode'])[1]"));
		//zipCode.sendKeys("11001");
		PegaWebElement city = newWizard.findElement(By.xpath("(//input[@id='City'])[1]"));
		city.sendKeys("Sydney");
		//PegaWebElement state = newWizard.findElement(By.xpath("(//select[@id='StateCode'])[1]"));
		PegaWebElement state = newWizard.findElement(By.xpath("(//input[@id='StateCode'])[1]"));
		state.sendKeys("New South Wales");
		
		//Business Address
		PegaWebElement businsAdrsline1 = newWizard.findElement(By.xpath("(//input[@data-test-id='2015052602433300441401'])[2]"));
		businsAdrsline1.sendKeys("123");
		PegaWebElement businsAdrsline2 = newWizard.findElement(By.xpath("(//input[@data-test-id='2015052602433300462870'])[2]"));
		businsAdrsline2.sendKeys("New Street");
		DropDown bCountryCode = newWizard.findSelectBox(By.xpath("(//select[@data-test-id='20151104070027020222217'])[2]"));
		bCountryCode.selectByValue("AUS");
		PegaWebElement bZipCode = newWizard.findElement(By.xpath("(//input[@id='ZipCode'])[2]"));
		//input[@id='ZipCode']
		//bZipCode.sendKeys("11001");
		PegaWebElement bCity = newWizard.findElement(By.xpath("(//input[@id='City'])[2]"));
		bCity.sendKeys("Sydney");
		PegaWebElement bState = newWizard.findElement(By.xpath("(//input[@id='StateCode'])[2]"));
		bState.sendKeys("New South Wales");
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
		
		}
	
	@Override
	public void enterMandatoryFieldsInContactCreation() {
		Random rand = new Random();
		int r= rand.nextInt(50)+1;
		String s = String.valueOf(r);
		String initialmail = "test123#number#@mail.com";
		String finalmail = new String(initialmail).replace("#number#", s);
		
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement firstName = newWizard.findElement(By.xpath(NEW_CONTACT_FIRST_NAME_XPATH));
		firstName.sendKeys("Test FN");
		PegaWebElement lastName = newWizard.findElement(By.xpath(NEW_CONTACT_LAST_NAME_XPATH));
		lastName.sendKeys("Test LN");
		PegaWebElement homeEmail = newWizard.findElement(By.xpath("//input[@id='ContactString' and @name = '$PAppQueryEmailParams$ppxResults$l1$pContactString']"));
		homeEmail.sendKeys(finalmail);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
							
	}

	@Override
	public void submitthechangesforopenaccount() {
		pegaDriver.findElement(By.id("SecurityAnswer")).sendKeys("test");
		PegaWebElement submit = pegaDriver.findElement(By.xpath("//button[contains(.,'Submit')]"));
		submit.click();				
	}

	
	@Override
	public void modifyAccountLinksfornewcontact(String accNum, String role) {
		 //pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(2);
        frameId = pegaDriver.getActiveFrameId(false);
        newWizard  = pegaDriver.findWizard(frameId);
         PegaWebElement addButton = newWizard.findElement(By.xpath(ADD_NEW_ACCOUNT_ASSOCIATION_XPATH));
         addButton.click();
         pegaDriver.waitForDocStateReady(2);
         int accnum = pegaDriver.findElements(By.xpath("//input[contains(@name,'AccountNumber')]")).size();
         
         if(accnum>0 && accnum==1){
        	 AutoComplete dp= pegaDriver.findAutoComplete(By.xpath("//input[contains(@name,'AccountNumber')]"));
        	 dp.sendKeys(accNum); 
        	 
        	 pegaDriver.waitForDocStateReady(2);
             Select roleType= new Select(pegaDriver.findElement(By.xpath("//select[contains(@name,'RoleId')]")));
             roleType.selectByVisibleText(role);
             pegaDriver.waitForDocStateReady(3);
         }
         
        /* if(accNum.equalsIgnoreCase("1234500078963456")||accNum.equalsIgnoreCase("123450000")){
        	 
        	 //PegaWebElement account = pegaDriver.findElement(By.id("AccountNumber1"));
        	 AutoComplete dp= pegaDriver.findAutoComplete(By.xpath("//input[contains(@id,'AccountNumber')]"));
        	 dp.sendKeys(accNum);
          }*/
         
         else {
        	 AutoComplete dp= pegaDriver.findAutoComplete(By.xpath("//input[contains(@name,'AccountNumber')and contains(@name,'ppxResults$l2')]"));
        	 dp.sendKeys(accNum);
        	 pegaDriver.waitForDocStateReady();
        	 dp.sendKeys(Keys.DOWN);
        	 dp.sendKeys(Keys.DOWN);
        	 dp.sendKeys(Keys.ENTER);
        	 
        	 pegaDriver.waitForDocStateReady(2);
             Select roleType= new Select(pegaDriver.findElement(By.xpath("//select[contains(@name,'RoleId')and contains(@name,'ppxResults$l2')]")));
             roleType.selectByVisibleText(role);
             pegaDriver.waitForDocStateReady(3);
        	 
        }
         
         
         
	}
	
}
