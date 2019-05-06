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
		PegaWebElement addTaskButton = findElement(By.xpath(ADD_TASK_XPATH));
		findElement(By.xpath(ADD_TASK_XPATH)).sendKeys(Keys.PAGE_UP);
		addTaskButton.click();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//button[@title='Add Task']"));

	}

	

	@Override
	public void selectReasonForDispute() {
		DropDown distributionDropDown = findSelectBox(By.id("DisputeReason"));
		distributionDropDown.selectByValue("CreditAsDebit");
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}

	@Override
	public void confirmDisputeDetails() {
		PegaWebElement confirmButton = findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);
		

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
		frameId = getActiveFrameId(false);
		Wizard newWizard = findWizard(frameId);
		return newWizard;
	}


	@Override
	public Set<String> clickCompositeLink(String headerName) {
		// TODO Auto-generated method stub
		PegaWebElement pegaWebElement = findElement(By.xpath("//*[@title='" + headerName + "']"));
		pegaWebElement.click();
		Set<String> winObj = pegaDriver.getWindowHandles();
		System.out.println("Value for the Window Object are : : : :" + winObj);
		return winObj;
	}






	@Override
	public void selectDisputeTransaction(String tranName) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		pegaDriver.waitForDocStateReady(2);
		String TRANSACTION_ID_XPATH = "//input[@title='Select Dispute Transaction with ID #tranName#']";
		String finalXPath = new String(TRANSACTION_ID_XPATH).replace("#tranName#", tranName);

		PegaWebElement transLink = findElement(By.xpath(finalXPath));
		transLink.click();
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		

	}

	@Override
	public void selectReasonForDispute(String reason) {
		DropDown distributionDropDown = findSelectBox(By.xpath("//select[@data-test-id='2015031611430403041178']"));
		distributionDropDown.selectByValue(reason);
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}


	@Override
	public void searchByCustomerNameAndAccountNo(String lastName, String accountNum) {
		PegaWebElement pegaWebElement = findElement(By.xpath(LAST_NAME_XPATH));
		pegaWebElement.clear();
		pegaWebElement.sendKeys(lastName);
		
		PegaWebElement searchButon = findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		searchButon.click();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//span[contains(text(),'" + lastName + "')]"));
		
		pegaWebElement = findElement(By.xpath(ACCOUNT_NO_XPATH));
		pegaWebElement.clear();
		pegaWebElement.sendKeys(accountNum);
		
		PegaWebElement search = findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();
	}

	@Override
	public void selectCustomer() {
		
		List<WebElement> rows = findElements(By.xpath("//tr[contains(@id,'PD_Search_Customer$ppxResults')]"));
		rows.get(rows.size() - 1).click();
		
		PegaWebElement submit = findElement(By.xpath(CONTACT_RESULT_SUBMIT_XPATH));
		submit.click();

	}


	@Override
	public void contactVerificationWithTwoQuestions() {
		
		PegaWebElement verificationCheckBox1 = findElement(By.id(CONTACT_VERIFICATION_1_ID));
		verificationCheckBox1.check();
		if (verifyElement(By.id(CONTACT_VERIFICATION_2_ID))) {
			PegaWebElement verificationCheckBox2 = findElement(By.id(CONTACT_VERIFICATION_2_ID));
			verificationCheckBox2.check();
		}
		
		PegaWebElement submit = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submit.click();
	
	}

	

	@Override
	public void contactVerificationWithQuestions() {
		
		int pageexists = findElements(By.xpath("//span[contains(text(),'Contact Verification')]")).size();
		if (pageexists > 0) {
			int noOfQstns = findElements(By.xpath("//input[contains(@id,'IsSecurityQuestionVerified')]")).size();
			if (noOfQstns > 0) {
				for (int i = 1; i <= noOfQstns; i++) {
					
					PegaWebElement chkBox = findElement(By.xpath("(//input[contains(@id,'IsSecurityQuestionVerified')])[" + i + "]"));
					chkBox.check();
					
				}
			}

			
			PegaWebElement submit = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
			submit.click(false);
			
		}
	}
	@Override
	public void contactVerificationQuestions() {
		
		int pageexists = findElements(By.xpath("//span[contains(text(),'Verify contact')]")).size();
		if (pageexists > 0) {
			int noOfQstns = findElements(By.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]")).size();

			if (noOfQstns > 0) {
				for (int i = 1; i <= noOfQstns; i++) {
					
					findElements(By.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]")).get(i-1).click();

				
				}
			}

			PegaWebElement submit = findElement(By.xpath("//button[text()='Verified']"));
			submit.click(false);
			
		}
	}


	@Override
	public void contactVerificationQuesforServiceCases() {
		
		int pageexists = findElements(By.xpath("//*[contains(text(),'Verify contact')]")).size();

		if (pageexists > 0) {
			int noOfQstns = findElements(By.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]")).size();
			if (noOfQstns > 0) {
				for (int i = 1; i <=noOfQstns; i++) {
					
					findElements(By.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]")).get(i-1).click();
			

					try{
						PegaWebElement verification = findElement(By.xpath("//button[text()='Verified']"));
						
						if(verification.isEnabled())
						{
							
							PegaWebElement submitButtons = findElement(By.xpath("//button[text()='Verified']"));
							submitButtons.click(false);
							break;
						}
					}
					catch(Exception e) {
						PegaWebElement verification =findElement(By.xpath("//button[text()='Verified']"));
						if(verification.isEnabled())
						{
							PegaWebElement submitButtons = findElement(By.xpath("//button[text()='Verified']"));
							submitButtons.click(false);
							break;
						}
					}

					  

				}
			}

			

		}

		else
		{
			Assert.assertFalse("No Verification validated successfully", verifyElement(By.xpath("//label[contains(text(),'Verify contact')]")));
		}

	}



	@Override
	public void clickOnOtherActionsButton() {
		
		frameId = getActiveFrameId(false);
		newWizard = findWizard(frameId);
		
		try{
		PegaWebElement otherActions = findElement(By.xpath("//button[@title='Other actions']"));
		otherActions.click(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	


	@Override
	public void changeAddress() {
		PegaWebElement changeAddress1 = findElement(By.xpath(ADDRESS_LINE1_XPATH));
		changeAddress1.clear();
		changeAddress1.sendKeys("123");
		PegaWebElement changeAddress = findElement(By.xpath(ADDRESS_LINE2_XPATH));
		changeAddress.clear();
		changeAddress.sendKeys("New Street");
		DropDown CountryCode = findSelectBox(By.xpath(COUNTRY_CODE_XPATH));
		CountryCode.selectByValue("AUS");
		PegaWebElement zipCode = findElement(By.xpath(POSTAL_CODE_XPATH));
		zipCode.clear();
		zipCode.sendKeys("11001 ");
		PegaWebElement city = findElement(By.xpath(CITY_XPATH));
		city.clear();
		city.sendKeys("Sydney ");
		PegaWebElement HomePhone = findElement(By.xpath(HOME_PHONE_XPATH));
		HomePhone.clear();
		HomePhone.sendKeys("12345659099 ");
		PegaWebElement CellPhone = findElement(By.xpath(CELL_PHONE_XPATH));
		CellPhone.clear();
		CellPhone.sendKeys("2288909023 ");
		PegaWebElement Fax = findElement(By.xpath(FAX_XPATH));
		Fax.clear();
		Fax.sendKeys("2288909023 ");
		PegaWebElement Email = findElement(By.xpath(EMAIL_ID_XPATH));
		Email.clear();
		Email.sendKeys("test@pega.com ");
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
	}
	
	@Override
	public void confirmAddressChange() {
		PegaWebElement confirmButton = findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);
	}


	@Override
	public String verifyCompletedTask(String serviceProcess) {
		
		String SERVICE_PROCESS_XPATH = "//a[text()='#sericecase#' and (@class='Standard_task' or @class='Standard_offer')]";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#sericecase#", serviceProcess);
		return finalXPath;

	}

	@Override
	public void launchWrapup() {

		PegaWebElement wrapUp = findElement(By.xpath(WRAP_UP_XPATH));

		try {

			wrapUp.click();
		} catch (Exception e) {
			PegaWebElement wrapUp1 = findElement(By.xpath("//i[@title='Wrap Up']"));
			wrapUp1.click();
			e.printStackTrace();
		}	
	}


	@Override
	public void completeWrapUp(String reason) {
		
		DropDown disposition = findSelectBox(By.xpath(REASON_FOR_INTERACTION_XPATH));
		disposition.selectByValue(reason);
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		

	}

	@Override
	public void completeWrapUpWithoutReason() {
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		
	}



	@Override
	public void changeAdditionalAddress() {
		
		PegaWebElement checkBox = findElement(By.xpath(SELECT_ADDITIONAL_ACCOUNTS_XPATH));	
		checkBox.click();
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}

	@Override
	public void confirmFlow() {
		
		PegaWebElement confirmButton = findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);
		

	}

	@Override
	public void selectAProduct(String category, String product, String owner) {

		
		DropDown categoryDropdown = findSelectBox(By.xpath(PRODUCT_CATEGORY_XPATH));
		categoryDropdown.selectByValue(category);

		
		categoryDropdown = findSelectBox(By.xpath(PRODUCT_ID_XPATH));
		categoryDropdown.sendKeys(Keys.TAB);
		

		DropDown productDropdown = findSelectBox(By.xpath(PRODUCT_ID_XPATH));
		productDropdown.click(false);

	

		productDropdown = findSelectBox(By.xpath(PRODUCT_ID_XPATH));
		productDropdown.selectByValue(product);

	

		String finalXpath = new String(PRODUCTOWNER_XPATH).replace("#owner#", owner);
		findElement(By.xpath(finalXpath)).click();

		
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

		
		PegaWebElement secans = findElement(By.xpath("//input[contains(@name,'SecurityAnswer')]"));
		secans.sendKeys("test");
	}

	public void enterAccountDetails() {

		
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}

	public void launchCaseFromWorkbasket(String workBasket, String caseID) {
		
		PegaWebElement workBasketTab = findElement(By.xpath(WORKBASKET_LINK_XPATH));
		workBasketTab.click();
		DropDown workBasketSelect = findSelectBox(By.xpath(WORKBASKET_XPATH));
		workBasketSelect.selectByValue(workBasket);
		String finalXpath = new String(WB_CASE_XPATH).replace("#id#", caseID);
		PegaWebElement launchCaseID = findElement(By.xpath(finalXpath));
		launchCaseID.scrollIntoView();
		launchCaseID.click();

	}

	@Override
	public void launchServiceProcess(String serviceProcess) {
		String SERVICE_PROCESS_XPATH = "//a[text()='#sericecase#' and @class='Add_task']";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#sericecase#", serviceProcess);
		PegaWebElement serviceCase = findElement(By.xpath(finalXPath));
		serviceCase.doubleClick();
	}

	@Override
	public void accountSelection(String acctNumber) {
		PegaWebElement accountSelection = findElement(By.xpath("//*[contains(text(),'" + acctNumber + "')]/ancestor::tr[1]"));
		accountSelection.click();
		PegaWebElement submit = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submit.click(false);
		
	}

	@Override
	public void stolenCardAcknowledgement() {
		PegaWebElement selectStatement = findElement(By.xpath("//span[contains(@title,'disclosure')]"));//input[@id='pySelected']
		selectStatement.click(false);
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
	
	}


	@Override
	public void closeAccount(String reason, String comment) {
		DropDown reasonDropDown = findSelectBox(By.id("Reason"));
		reasonDropDown.selectByValue(reason);
		PegaWebElement comments = findElement(By.id("Comments"));
		comments.sendKeys(comment);
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		

	}


	@Override
	public void switchInteraction(String interactionItem) {
		String InteractionTitle = "//*[contains(text(),'#interactionItem#')]/ancestor::span[contains(@class,'tab')]";
		String finalXPath = new String(InteractionTitle).replace("#interactionItem#", interactionItem);
		PegaWebElement interactionTitle = findElement(By.xpath(finalXPath));
		interactionTitle.click();
	}

		
	@Override
	public String getCaseDetails() {

		PegaWebElement toolsButton = findElement(By.xpath("//button[@title='Help' or @title='Other actions']"));
		toolsButton.click(false);
		PegaWebElement viewHistory = findElement(By.xpath("(//span[text()='History and Attachments'])[2]"));
		viewHistory.click();
		testEnv.getBrowser().switchToWindow(2);
		String idOfCase = findElement(By.xpath("//span[contains(text(),'I-') or contains(text(),'S-') or contains(text(),'C-') or contains(text(),'Task-') or contains(text(),'IDS-') ]")).getText();
		testEnv.getBrowser().close();
		testEnv.getBrowser().switchToWindow(1);
		System.out.println(idOfCase);
		CaseID = idOfCase.trim();
		return CaseID;
	}

	
	@Override
	public void datePicker() {
		PegaWebElement datePicker = findElement(By.xpath("//input[@name='$PpyWorkPage$pCloseDate' or @name='$POpportunityPage$pCloseDate']"));
		datePicker.clear();
		datePicker.sendKeys("10/10/2022");
		
	}


	@Override
	public void updatePrimaryAddressInContactProfile() {
		
		PegaWebElement newAddress = findElement(By.xpath("//a[@title='Add a new address']"));
		newAddress.click();

		
		PegaWebElement checkBox = findElement(By.xpath("//input[@title='Check if primary']"));
		checkBox.click();
		
		PegaWebElement changeAddress1 = findElement(By.xpath(ADDRESS_LINE1_XPATH));
		changeAddress1.sendKeys("123");
		PegaWebElement changeAddress = findElement(By.xpath(ADDRESS_LINE2_XPATH));
		changeAddress.sendKeys("New Street");
		DropDown CountryCode = findSelectBox(By.xpath(COUNTRY_CODE_XPATH));
		CountryCode.selectByValue("USA");// AUS
		
		PegaWebElement city = findElement(By.xpath(CITY_XPATH));
		city.sendKeys("Alabama");// Sydney
		DropDown state = findSelectBox(By.xpath("//select[@title='Select State']"));
		state.selectByValue("AL");
		PegaWebElement zipCode = findElement(By.xpath(POSTAL_CODE_XPATH));
		zipCode.sendKeys("35006");
		
		PegaWebElement submitButton = findElement(By.id("ModalButtonSubmit"));
		submitButton.click();
	}

	@Override
	public void userSwitchToTab(String tab) {
	
		String Tab_XPATH = "//h3[@class='layout-group-item-title'][text()='#sericecase#']";
		String final_Tab_XPath = new String(Tab_XPATH).replace("#sericecase#", tab);

		PegaWebElement overview = findElement(By.xpath(final_Tab_XPath));
		overview.click();
	}

	
	@Override
	public void verifyRecentCases() {
		
		String SERVICE_PROCESS_XPATH = "//span[contains(@class,'smartInfoNew') and text()='#IdofCase#']";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#IdofCase#", CaseID);
		Assert.assertTrue("case ID is not present", verifyElement(By.xpath(finalXPath)));

	}



	@Override
	public void selectSingleserviceprocess(String serviceProcess) {
		String SERVICE_PROCESS_XPATH = "//a[text()='#sericecase#' and @class='Add_task']";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#sericecase#", serviceProcess);
		PegaWebElement serviceCase = findElement(By.xpath(finalXPath));
		serviceCase.click();

	}


	@Override
	public void closeInteraction() {
		PegaWebElement closeInteraction = findElement(By.xpath(CLOSE_INTERACTION_XPATH));
		closeInteraction.scrollIntoView();
		closeInteraction.click(false);
	}


	@Override
	public void verifytheStatusForTheCase(String Status) {
		String SERVICE_PROCESS_XPATH = "//span[contains(text(),'"+ Status+"')]";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#IdofCase#", CaseID);

		Assert.assertTrue("case Status is not present or incorrect", verifyElement(By.xpath(finalXPath)));
	}

	@Override
	public void selectCaseFromCasesWidget() {
		String SERVICE_PROCESS_XPATH = "//span[contains(text(),'#IdofCase#')]/ancestor::div[1]/preceding-sibling::div[1]/span/a[contains(@title,'Review this service case')]";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#IdofCase#", CaseID);

		PegaWebElement selectCase = findElement(By.xpath(finalXPath));
		selectCase.click();
	}

	

	@Override
	public void selectSubCaseFromTasks(String subCase) {
		String SERVICE_PROCESS_XPATH = "//div[contains(@class,'dataValueRead')]/a[contains(text(),'#CaseName#')]";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#CaseName#", subCase);

		PegaWebElement selectsubCase = findElement(By.xpath(finalXPath));
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

		DropDown reasonDropdown = findSelectBox(By.xpath(OUTBOUND_REASON_XPATH));
		reasonDropdown.selectByValue(reason);
		
		String finalXpath =  new String(OUTBOUND_STATUS_XPATH).replace("#status#", status);
		PegaWebElement rdbutton = findElement(By.xpath(finalXpath));
		rdbutton.click();
		
		PegaWebElement submitButton = findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);


	}

		
}
