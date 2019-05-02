package com.pega.crm.customerservice.interactions.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.PhoneCall;
import com.pega.crm.customerservice.utils.CommonMethods;
import com.pega.framework.AutoComplete;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;

public abstract class PegaInteractions extends WizardImpl implements Interactions {

	private WebDriver driver;

	public PegaInteractions(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
		commonMethods = new CommonMethods(pegaDriver);
		driver = pegaDriver.getDriver();
	}

	public static String CaseID = null;
	public String frameId = null;
	public Wizard newWizard = null;
	public CommonMethods commonMethods = null;
	boolean pop = false;

	public boolean isPop() {
		return pop;
	}

	public void setPop(boolean pop) {
		this.pop = pop;
	}




	



	

	@Override
	public void addTask() {
		pegaDriver.waitForDocStateReady(3);
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		PegaWebElement addTaskButton = pegaDriver.findElement(By.xpath(ADD_TASK_XPATH));
		pegaDriver.findElement(By.xpath(ADD_TASK_XPATH)).sendKeys(Keys.PAGE_UP);
		addTaskButton.click();
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//button[@title='Add Task']"));

	}

	

	

	
	

	@Override
	public void selectReasonForDispute() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown distributionDropDown = newWizard.findSelectBox(By.id("DisputeReason"));
		distributionDropDown.selectByValue("CreditAsDebit");
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}

	@Override
	public void confirmDisputeDetails() {
		PegaWebElement confirmButton = newWizard.findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

	}

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

	

	

	
	@Override
	public Wizard switchToFrame() {
		frameId = pegaDriver.getActiveFrameId(false);
		Wizard newWizard = pegaDriver.findWizard(frameId);
		return newWizard;
	}

	

	

	

	

	
	

	



	@Override
	public Set<String> clickCompositeLink(String headerName) {
		// TODO Auto-generated method stub
		PegaWebElement pegaWebElement = pegaDriver.findElement(By.xpath("//*[@title='" + headerName + "']"));
		pegaWebElement.click();
		Set<String> winObj = pegaDriver.getWindowHandles();
		System.out.println("Value for the Window Object are : : : :" + winObj);
		return winObj;
	}






	@Override
	public void selectDisputeTransaction(String tranName) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		pegaDriver.waitForDocStateReady(2);
		String TRANSACTION_ID_XPATH = "//input[@title='Select Dispute Transaction with ID #tranName#']";
		String finalXPath = new String(TRANSACTION_ID_XPATH).replace("#tranName#", tranName);

		PegaWebElement transLink = newWizard.findElement(By.xpath(finalXPath));
		transLink.click();
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

	}

	@Override
	public void selectReasonForDispute(String reason) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown distributionDropDown = newWizard.findSelectBox(By.xpath("//select[@data-test-id='2015031611430403041178']"));
		distributionDropDown.selectByValue(reason);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}


	@Override
	public void searchByCustomerNameAndAccountNo(String lastName, String accountNum) {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement pegaWebElement = pegaDriver.findElement(By.xpath(LAST_NAME_XPATH));
		pegaWebElement.clear();
		pegaWebElement.sendKeys(lastName);
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement searchButon = newWizard.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		searchButon.click();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//span[contains(text(),'" + lastName + "')]"));
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		pegaWebElement = pegaDriver.findElement(By.xpath(ACCOUNT_NO_XPATH));
		pegaWebElement.clear();
		pegaWebElement.sendKeys(accountNum);
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement search = newWizard.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();
	}

	@Override
	public void selectCustomer() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		List<WebElement> rows = pegaDriver
				.findElements(By.xpath("//tr[contains(@id,'PD_Search_Customer$ppxResults')]"));
		rows.get(rows.size() - 1).click();
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement submit = newWizard.findElement(By.xpath(CONTACT_RESULT_SUBMIT_XPATH));
		submit.click();

	}



	@Override
	public void contactVerificationWithTwoQuestions() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement verificationCheckBox1 = newWizard.findElement(By.id(CONTACT_VERIFICATION_1_ID));
		verificationCheckBox1.check();
		if (pegaDriver.verifyElement(By.id(CONTACT_VERIFICATION_2_ID))) {
			PegaWebElement verificationCheckBox2 = newWizard.findElement(By.id(CONTACT_VERIFICATION_2_ID));
			verificationCheckBox2.check();
		}
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement submit = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submit.click();
		pegaDriver.waitForDocStateReady(3);
	}

	

	@Override
	public void contactVerificationWithQuestions() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		int pageexists = pegaDriver.findElements(By.xpath("//span[contains(text(),'Contact Verification')]")).size();
		if (pageexists > 0) {
			int noOfQstns = pegaDriver.findElements(By.xpath("//input[contains(@id,'IsSecurityQuestionVerified')]"))
					.size();
			if (noOfQstns > 0) {
				for (int i = 1; i <= noOfQstns; i++) {
					pegaDriver.waitForDocStateReady(5);
					PegaWebElement chkBox = pegaDriver
							.findElement(By.xpath("(//input[contains(@id,'IsSecurityQuestionVerified')])[" + i + "]"));
					chkBox.check();
					pegaDriver.waitForDocStateReady(1);
					/*
					 * if(!chkBox.isSelected()){ chkBox.check(); }
					 */
				}
			}

			//String numberofquestext = pegaDriver.findElement(By.xpath("//div[@data-test-id='201802070240470255365646']")).getText();

			PegaWebElement submit = pegaDriver.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
			submit.click(false);
			pegaDriver.waitForDocStateReady(3);
		}
	}
	@Override
	public void contactVerificationQuestions() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		int pageexists = pegaDriver.findElements(By.xpath("//span[contains(text(),'Verify contact')]")).size();
		if (pageexists > 0) {
			int noOfQstns = pegaDriver.findElements(By.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]")).size();

			if (noOfQstns > 0) {
				for (int i = 1; i <= noOfQstns; i++) {
					pegaDriver.waitForDocStateReady(5);
					pegaDriver
					.findElements(By.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]")).get(i-1).click();

					pegaDriver.waitForDocStateReady(1);
					/*
					 * if(!chkBox.isSelected()){ chkBox.check(); }
					 */
				}
			}

			//String numberofquestext = pegaDriver.findElement(By.xpath("//div[@data-test-id='201802070240470255365646']")).getText();

			PegaWebElement submit = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
			submit.click(false);
			pegaDriver.waitForDocStateReady(3);
		}
	}






	@Override
	public void contactVerificationQuesforServiceCases() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		int pageexists = pegaDriver.findElements(By.xpath("//*[contains(text(),'Verify contact')]")).size();

		if (pageexists > 0) {
			int noOfQstns = pegaDriver.findElements(By.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]")).size();
			//String minques=pegaDriver.findElement(By.xpath("//span[@data-test-id='20180208090340000417548']")).getText();
			//String[] arrQues= minques.split("\\s");            
			//int minquestions = Integer.parseInt(arrQues[3]);
			if (noOfQstns > 0) {
				for (int i = 1; i <=noOfQstns; i++) {
					//pegaDriver.waitForDocStateReady(5);
					pegaDriver.waitForDocStateReady(1);

					pegaDriver.findElements(By.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]")).get(i-1).click();
					pegaDriver.waitForDocStateReady(4);


					try{
						PegaWebElement verification = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
						pegaDriver.waitForDocStateReady();
						if(verification.isEnabled())
						{
							pegaDriver.switchTo().defaultContent();
							pegaDriver.waitForDocStateReady();
							pegaDriver.switchToActiveFrame();
							pegaDriver.waitForDocStateReady();
							PegaWebElement submitButtons = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
							pegaDriver.waitForDocStateReady();
							submitButtons.click(false);
							pegaDriver.waitForDocStateReady();
							break;
						}
					}
					catch(Exception e) {
						pegaDriver.waitForDocStateReady(1);
						pegaDriver.switchToActiveFrame();
						PegaWebElement verification = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
						pegaDriver.waitForDocStateReady();
						if(verification.isEnabled())
						{
							pegaDriver.switchTo().defaultContent();
							pegaDriver.waitForDocStateReady();
							pegaDriver.switchToActiveFrame();
							pegaDriver.waitForDocStateReady();
							PegaWebElement submitButtons = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
							pegaDriver.waitForDocStateReady();
							submitButtons.click(false);
							pegaDriver.waitForDocStateReady();
							break;
						}
					}

					  

				}
			}

			

		}

		else
		{
			Assert.assertFalse("No Verification validated successfully", pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Verify contact')]")));
		}

	}






	
	

	

	@Override
	public void clickOnOtherActionsButton() {
		pegaDriver.waitForDocStateReady(1);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(2);
		try{
		PegaWebElement otherActions = pegaDriver.findElement(By.xpath("//button[@title='Other actions']"));
		otherActions.click(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		pegaDriver.waitForDocStateReady(2);

	}

	


	@Override
	public void changeAddress() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement changeAddress1 = newWizard.findElement(By.xpath(ADDRESS_LINE1_XPATH));
		changeAddress1.clear();
		changeAddress1.sendKeys("123");
		PegaWebElement changeAddress = newWizard.findElement(By.xpath(ADDRESS_LINE2_XPATH));
		changeAddress.clear();
		changeAddress.sendKeys("New Street");
		DropDown CountryCode = newWizard.findSelectBox(By.xpath(COUNTRY_CODE_XPATH));
		CountryCode.selectByValue("AUS");
		PegaWebElement zipCode = newWizard.findElement(By.xpath(POSTAL_CODE_XPATH));
		zipCode.clear();
		zipCode.sendKeys("11001 ");
		PegaWebElement city = newWizard.findElement(By.xpath(CITY_XPATH));
		city.clear();
		city.sendKeys("Sydney ");
		PegaWebElement HomePhone = newWizard.findElement(By.xpath(HOME_PHONE_XPATH));
		HomePhone.clear();
		HomePhone.sendKeys("12345659099 ");
		PegaWebElement CellPhone = newWizard.findElement(By.xpath(CELL_PHONE_XPATH));
		CellPhone.clear();
		CellPhone.sendKeys("2288909023 ");
		PegaWebElement Fax = newWizard.findElement(By.xpath(FAX_XPATH));
		Fax.clear();
		Fax.sendKeys("2288909023 ");
		PegaWebElement Email = newWizard.findElement(By.xpath(EMAIL_ID_XPATH));
		Email.clear();
		Email.sendKeys("test@pega.com ");
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
	}
	
	@Override
	public void confirmAddressChange() {
		pegaDriver.switchToActiveFrame();
		PegaWebElement confirmButton = pegaDriver.findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

	}


	@Override
	public String verifyCompletedTask(String serviceProcess) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		String SERVICE_PROCESS_XPATH = "//a[text()='#sericecase#' and (@class='Standard_task' or @class='Standard_offer')]";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#sericecase#", serviceProcess);
		return finalXPath;

	}

	@Override
	public void launchWrapup() {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement wrapUp = newWizard.findElement(By.xpath(WRAP_UP_XPATH));

		try {

			wrapUp.click();
		} catch (Exception e) {
			PegaWebElement wrapUp1 = newWizard.findElement(By.xpath("//i[@title='Wrap Up']"));
			wrapUp1.click();
			e.printStackTrace();
		}	
	}


	@Override
	public void completeWrapUp(String reason) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown disposition = newWizard.findSelectBox(By.xpath(REASON_FOR_INTERACTION_XPATH));
		disposition.selectByValue(reason);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		pegaDriver.switchToActiveFrame();

	}

	@Override
	public void completeWrapUpWithoutReason() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();

	}



	@Override
	public void changeAdditionalAddress() {
		//PegaWebElement checkBox = newWizard.findElement(By.id(ADDRESS_CHANGE_CHECKBOX_ID));
		PegaWebElement checkBox = newWizard.findElement(By.xpath(SELECT_ADDITIONAL_ACCOUNTS_XPATH));	
		checkBox.click();
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}

	@Override
	public void confirmFlow() {
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement confirmButton = newWizard.findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

	}

	@Override
	public void selectAProduct(String category, String product, String owner) {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown categoryDropdown = newWizard.findSelectBox(By.xpath(PRODUCT_CATEGORY_XPATH));
		categoryDropdown.selectByValue(category);

		pegaDriver.waitForDocStateReady(3);

		categoryDropdown = newWizard.findSelectBox(By.xpath(PRODUCT_ID_XPATH));
		categoryDropdown.sendKeys(Keys.TAB);

		pegaDriver.waitForDocStateReady(10);

		DropDown productDropdown = newWizard.findSelectBox(By.xpath(PRODUCT_ID_XPATH));
		productDropdown.click(false);

		pegaDriver.waitForDocStateReady(10);

		productDropdown = newWizard.findSelectBox(By.xpath(PRODUCT_ID_XPATH));
		productDropdown.selectByValue(product);

		pegaDriver.waitForDocStateReady(3);

		String finalXpath = new String(PRODUCTOWNER_XPATH).replace("#owner#", owner);
		pegaDriver.findElement(By.xpath(finalXpath)).click();

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

		pegaDriver.switchToActiveFrame();
		PegaWebElement secans = pegaDriver.findElement(By.xpath("//input[contains(@name,'SecurityAnswer')]"));
		secans.sendKeys("test");
	}

	public void enterAccountDetails() {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}

	public void launchCaseFromWorkbasket(String workBasket, String caseID) {
		System.out.println(caseID);

		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement workBasketTab = newWizard.findElement(By.xpath(WORKBASKET_LINK_XPATH));
		workBasketTab.click();
		DropDown workBasketSelect = newWizard.findSelectBox(By.xpath(WORKBASKET_XPATH));
		workBasketSelect.selectByValue(workBasket);
		String finalXpath = new String(WB_CASE_XPATH).replace("#id#", caseID);
		PegaWebElement launchCaseID = newWizard.findElement(By.xpath(finalXpath));
		System.out.println(finalXpath);
		launchCaseID.scrollIntoView();
		pegaDriver.waitForDocStateReady(5);
		launchCaseID.click();

	}

	@Override
	public void launchServiceProcess(String serviceProcess) {
		String SERVICE_PROCESS_XPATH = "//a[text()='#sericecase#' and @class='Add_task']";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#sericecase#", serviceProcess);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement serviceCase = newWizard.findElement(By.xpath(finalXPath));
		//PegaWebElement serviceCase = newWizard.findElement(By.xpath("//a[@data-test-id='2014123005242607302524']"));
		serviceCase.doubleClick();
	}

	@Override
	public void accountSelection(String acctNumber) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		// String finalXPath = new
		// String(ACCOUNT_VALUE_XPATH).replace("#accounNumber#", acctNumber);
		PegaWebElement accountSelection = newWizard
				.findElement(By.xpath("//*[contains(text(),'" + acctNumber + "')]/ancestor::tr[1]"));
		accountSelection.click();
		PegaWebElement submit = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submit.click(false);
		
	}

	@Override
	public void stolenCardAcknowledgement() {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement selectStatement = newWizard.findElement(By.xpath("//span[contains(@title,'disclosure')]"));//input[@id='pySelected']
		selectStatement.click(false);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
		pegaDriver.switchToActiveFrame();
	}


	@Override
	public void closeAccount(String reason, String comment) {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown reasonDropDown = newWizard.findSelectBox(By.id("Reason"));
		reasonDropDown.selectByValue(reason);
		PegaWebElement comments = newWizard.findElement(By.id("Comments"));
		comments.sendKeys(comment);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		pegaDriver.switchToActiveFrame();

	}


	@Override
	public void switchInteraction(String interactionItem) {
		pegaDriver.switchTo().defaultContent();
		//String InteractionTitle = "//a[contains(text(),'#interactionItem#')]";
		String InteractionTitle = "//*[contains(text(),'#interactionItem#')]/ancestor::span[contains(@class,'tab')]";
		String finalXPath = new String(InteractionTitle).replace("#interactionItem#", interactionItem);
		PegaWebElement interactionTitle = pegaDriver.findElement(By.xpath(finalXPath));
		interactionTitle.click();
	}

		
	@Override
	public String getCaseDetails() {

		PegaWebElement toolsButton = pegaDriver.findElement(By.xpath("//button[@title='Help' or @title='Other actions']"));
		toolsButton.click(false);
		PegaWebElement viewHistory = pegaDriver.findElement(By.xpath("(//span[text()='History and Attachments'])[2]"));
		viewHistory.click();
		pegaDriver.waitForDocStateReady(2);
		testEnv.getBrowser().switchToWindow(2);
		String idOfCase = pegaDriver.findElement(By.xpath("//span[contains(text(),'I-') or contains(text(),'S-') or contains(text(),'C-') or contains(text(),'Task-') or contains(text(),'IDS-') ]")).getText();
		testEnv.getBrowser().close();
		testEnv.getBrowser().switchToWindow(1);
		System.out.println(idOfCase);
		CaseID = idOfCase.trim();
		System.out.println(CaseID);
		return CaseID;
	}

	
	@Override
	public void datePicker() {
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement datePicker = pegaDriver.findElement(By.xpath("//input[@name='$PpyWorkPage$pCloseDate' or @name='$POpportunityPage$pCloseDate']"));
		datePicker.clear();
		datePicker.sendKeys("10/10/2022");
		
	}


	@Override
	public void updatePrimaryAddressInContactProfile() {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement newAddress = pegaDriver.findElement(By.xpath("//a[@title='Add a new address']"));
		newAddress.click();

		pegaDriver.waitForDocStateReady(3);
		PegaWebElement checkBox = pegaDriver.findElement(By.xpath("//input[@title='Check if primary']"));
		checkBox.click();
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement changeAddress1 = pegaDriver.findElement(By.xpath(ADDRESS_LINE1_XPATH));
		changeAddress1.sendKeys("123");
		PegaWebElement changeAddress = pegaDriver.findElement(By.xpath(ADDRESS_LINE2_XPATH));
		changeAddress.sendKeys("New Street");
		DropDown CountryCode = pegaDriver.findSelectBox(By.xpath(COUNTRY_CODE_XPATH));
		CountryCode.selectByValue("USA");// AUS
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement city = pegaDriver.findElement(By.xpath(CITY_XPATH));
		city.sendKeys("Alabama");// Sydney
		DropDown state = pegaDriver.findSelectBox(By.xpath("//select[@title='Select State']"));
		state.selectByValue("AL");
		PegaWebElement zipCode = pegaDriver.findElement(By.xpath(POSTAL_CODE_XPATH));
		zipCode.sendKeys("35006");
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement submitButton = pegaDriver.findElement(By.id("ModalButtonSubmit"));
		submitButton.click();
	}

	@Override
	public void userSwitchToTab(String tab) {
		pegaDriver.waitForDocStateReady(3);

		String Tab_XPATH = "//h3[@class='layout-group-item-title'][text()='#sericecase#']";
		String final_Tab_XPath = new String(Tab_XPATH).replace("#sericecase#", tab);

		PegaWebElement overview = pegaDriver.findElement(By.xpath(final_Tab_XPath));
		overview.click();
	}

	
	@Override
	public void verifyRecentCases() {

		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

		
		String SERVICE_PROCESS_XPATH = "//span[contains(@class,'smartInfoNew') and text()='#IdofCase#']";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#IdofCase#", CaseID);
		pegaDriver.waitForDocStateReady(3);
		Assert.assertTrue("case ID is not present", pegaDriver.verifyElement(By.xpath(finalXPath)));

	}



	@Override
	public void selectSingleserviceprocess(String serviceProcess) {
		String SERVICE_PROCESS_XPATH = "//a[text()='#sericecase#' and @class='Add_task']";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#sericecase#", serviceProcess);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement serviceCase = newWizard.findElement(By.xpath(finalXPath));
		serviceCase.click();

	}


	@Override
	public void closeInteraction() {
		pegaDriver.waitForDocStateReady(2);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement closeInteraction = newWizard.findElement(By.xpath(CLOSE_INTERACTION_XPATH));
		closeInteraction.scrollIntoView();
		closeInteraction.click(false);
	}


	@Override
	public void verifytheStatusForTheCase(String Status) {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

		System.out.println(CaseID);
		System.out.println(String.valueOf(CaseID));
		String SERVICE_PROCESS_XPATH = "//span[contains(text(),'"+ Status+"')]";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#IdofCase#", CaseID);

		pegaDriver.waitForDocStateReady(1);
		Assert.assertTrue("case Status is not present or incorrect", pegaDriver.verifyElement(By.xpath(finalXPath)));
	}

	@Override
	public void selectCaseFromCasesWidget() {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

		System.out.println(CaseID);
		System.out.println(String.valueOf(CaseID));

		String SERVICE_PROCESS_XPATH = "//span[contains(text(),'#IdofCase#')]/ancestor::div[1]/preceding-sibling::div[1]/span/a[contains(@title,'Review this service case')]";
		//span/a[contains(text(),'#IdofCase#')]
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#IdofCase#", CaseID);

		PegaWebElement selectCase = pegaDriver.findElement(By.xpath(finalXPath));
		selectCase.click();
	}

	

	@Override
	public void selectSubCaseFromTasks(String subCase) {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

		System.out.println(CaseID);
		System.out.println(String.valueOf(CaseID));

		String SERVICE_PROCESS_XPATH = "//div[contains(@class,'dataValueRead')]/a[contains(text(),'#CaseName#')]";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#CaseName#", subCase);

		PegaWebElement selectsubCase = pegaDriver.findElement(By.xpath(finalXPath));
		selectsubCase.click();
	}

	

	public String getTomorrowDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String newDate = format.format(cal.getTime());
		return newDate;
	}


	@Override
	public void CaptureCallReasonAndPlaceCall(String reason, String status) {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(2);
		DropDown reasonDropdown = newWizard.findSelectBox(By.xpath(OUTBOUND_REASON_XPATH));
		reasonDropdown.selectByValue(reason);
		pegaDriver.waitForDocStateReady(2);
		String finalXpath =  new String(OUTBOUND_STATUS_XPATH).replace("#status#", status);
		PegaWebElement rdbutton = newWizard.findElement(By.xpath(finalXpath));
		rdbutton.click();
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);


	}

		
}
