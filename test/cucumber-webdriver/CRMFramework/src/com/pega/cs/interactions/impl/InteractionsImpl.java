package com.pega.cs.interactions.impl;

import java.awt.Robot;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.pega.cs.interactions.Interactions;
import com.pega.cs.interactions.PhoneCall;
import com.pega.cs.utils.CommonMethods;
import com.pega.framework.AutoComplete;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;

public abstract class InteractionsImpl extends WizardImpl implements Interactions {

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

	public InteractionsImpl(WebElement elmt) {
		super(elmt);
	}

	public InteractionsImpl(WebElement elmt, String frameId) {
		super(elmt, frameId);
		commonMethods = new CommonMethods(pegaDriver);
	}

	@Override
	public void launchAddressChange() {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement addressChangeOption = newWizard.findElement(By.xpath(ADDRESS_CHANGE_XPATH));
		addressChangeOption.doubleClick();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
	}
	@Override
	public void validateFavorites(String contact)
	{
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		String RefreshButton = "//i[@class='icons pi pi-refresh pi-blue']";
		PegaWebElement Refresh = pegaDriver.findElement(By.xpath(RefreshButton));
		Refresh.click(false);
		pegaDriver.switchToActiveFrame();
		pegaDriver.verifyElement(By.xpath("//a[contains(text(),'"+contact+"')]"));

	}
	@Override
	public void addressChange() {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement addressChangeOption = newWizard.findElement(By.xpath(ADDRESS_CHANGE_XPATH));
		addressChangeOption.doubleClick();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
		PegaWebElement checkBox = newWizard.findElement(By.id(ADDRESS_CHANGE_CHECKBOX_ID));
		checkBox.click();
		submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
		PegaWebElement confirmButton = newWizard.findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);
	}

	@Override
	public void statementCopy() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement statementCopyOption = newWizard.findElement(By.xpath(STATEMENT_COPY_XPATH));
		statementCopyOption.doubleClick();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement statementCheckBox = newWizard.findElement(By.xpath(STATEMENT_COPY_STATEMENT_XPATH));
		statementCheckBox.check();
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		// testEnv.getScriptExecutor().click(submitButton);
		// submitButton.doClickWithMouse();
		submitButton.submit();
		DropDown distributionDropDown = newWizard.findSelectBox(By.xpath(DISTRIBUTION_DROPDOWN_XPATH));
		distributionDropDown.selectByValue("Mail");
		submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
		PegaWebElement confirmButton = newWizard.findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);
		// frameId = pegaDriver.getActiveFrameId(true);

	}

	@Override
	public void wrapUp() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement wrapUp = newWizard.findElement(By.xpath(WRAP_UP_XPATH));
		wrapUp.click();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);

	}

	@Override
	public void ShowdataLink(String LinkName) {
		//pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		if(LinkName.equalsIgnoreCase("Show Less")){
			PegaWebElement LinkButton = pegaDriver.findElement(By.xpath("//button[@title='Collapse header']"));
			LinkButton.click();
		}
		else if(LinkName.equalsIgnoreCase("Show More")){
			PegaWebElement LinkButton = pegaDriver.findElement(By.xpath("//button[@title='Expand header']"));
			LinkButton.click();
		}

		pegaDriver.waitForDocStateReady(3);

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
	public void lauchStatementCopyFromSuggestions() {

		/*
		 * frameId = pegaDriver.getActiveFrameId(false); newWizard =
		 * pegaDriver.findWizard(frameId);
		 */
		PegaWebElement statementCopySuggestion = newWizard
				.findElement(By.xpath("//a[@title='Suggested task         Statement Copy   ']"));
		statementCopySuggestion.click();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

	}

	@Override
	public void selectStatementForCopy() {

		PegaWebElement statementCheckBox = newWizard.findElement(By.xpath(STATEMENT_COPY_STATEMENT_XPATH));
		statementCheckBox.check();
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.submit();

	}

	@Override
	public void statementFee() {
		DropDown distributionDropDown = newWizard.findSelectBox(By.xpath(DISTRIBUTION_DROPDOWN_XPATH));
		distributionDropDown.selectByValue("Mail");
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}

	@Override
	public String StatementCopyID() {
		PegaWebElement sItem = newWizard
				.findElement(By.xpath("//div[@class='field-item dataValueRead']/span[contains(text(), 'S-')]"));
		return sItem.getText();
	}

	@Override
	public void confirmStatementFlow() {

		PegaWebElement confirmButton = newWizard.findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);

	}

	@Override
	public void launchStatementCopy() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement statementCopyOption = newWizard.findElement(By.xpath(STATEMENT_COPY_XPATH));
		statementCopyOption.doubleClick();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

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
	public void switchToDefault() {

		pegaDriver.switchTo().defaultContent();
	}

	@Override
	public void setDate(String dt) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement dateOfLastUse = newWizard.findElement(By.xpath(DATE_OF_LAST_USE_XPATH));
		dateOfLastUse.sendKeys(dt);

	}

	@Override
	public void checkbox(String xpth) {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement checkBox = newWizard.findElement(By.xpath(xpth));
		checkBox.click();

	}

	@Override
	public void setDates(String dt, By locator) {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement dateOfLastUse = newWizard.findElement(locator);
		dateOfLastUse.sendKeys(dt);

	}

	@Override
	public void launchChildInteraction() {
		// String childInteractionXpath = "//a[@title='Launch Interaction for
		// authorized contact #contact#']";
		// String finalXPath = new
		// String(childInteractionXpath).replace("#contact#", contact);
		pegaDriver.waitForDocStateReady(2);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement childInteraction = newWizard.findElement(By.xpath("//button[text()='Launch Interaction']"));
		childInteraction.click();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		/*
		 * PegaWebElement ele = pegaDriver.findElement( By.xpath(
		 * "//table[@id='bodyTbl_right' and @pl_prop_class='PegaCA-Interface-Contact']/tbody"
		 * )); int rowcount = ele.findElements(By.tagName("tr")).size();
		 * pegaDriver.switchToActiveFrame(); for (int i = 2; i <= rowcount; i++)
		 * { String act = pegaDriver.findElement( By.xpath(
		 * "//table[@id='bodyTbl_right' and @pl_prop_class='PegaCA-Interface-Contact']/tbody/tr["
		 * + i + "]/td[2]")) .getText(); if (text.equalsIgnoreCase(act)) {
		 * pegaDriver.findElement( By.xpath(
		 * "//table[@id='bodyTbl_right' and @pl_prop_class='PegaCA-Interface-Contact']/tbody/tr["
		 * + i + "]/td[5]/div/span/a")) .click(); break; } }
		 */

	}

	@Override
	public void launchChildInteraction(String contact) {
		String childInteractionXpath = "//a[@title='Launch Interaction for authorized contact #contact#']";
		String finalXPath = new String(childInteractionXpath).replace("#contact#", contact);
		pegaDriver.waitForDocStateReady(2);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement childInteraction = newWizard.findElement(By.xpath("//button[text()='Launch Interaction']"));
		childInteraction.click();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		/*
		 * PegaWebElement ele = pegaDriver.findElement( By.xpath(
		 * "//table[@id='bodyTbl_right' and @pl_prop_class='PegaCA-Interface-Contact']/tbody"
		 * )); int rowcount = ele.findElements(By.tagName("tr")).size();
		 * pegaDriver.switchToActiveFrame(); for (int i = 2; i <= rowcount; i++)
		 * { String act = pegaDriver.findElement( By.xpath(
		 * "//table[@id='bodyTbl_right' and @pl_prop_class='PegaCA-Interface-Contact']/tbody/tr["
		 * + i + "]/td[2]")) .getText(); if (text.equalsIgnoreCase(act)) {
		 * pegaDriver.findElement( By.xpath(
		 * "//table[@id='bodyTbl_right' and @pl_prop_class='PegaCA-Interface-Contact']/tbody/tr["
		 * + i + "]/td[5]/div/span/a")) .click(); break; } }
		 */

	}

	@Override
	public void scrollToBottomofpage() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");
	}

	@Override
	public void addressChangeB2B(String changeAddressText, String emailId, String faxNo) {

		PegaWebElement changeAddress = newWizard.findElement(By.xpath(ADDRESS_LINE2_XPATH));
		PegaWebElement changeEmail = newWizard.findElement(By.id("Email"));
		PegaWebElement changeFaxNo = newWizard.findElement(By.id("Fax"));
		changeAddress.clear();
		changeAddress.sendKeys(changeAddressText);
		changeEmail.clear();
		changeEmail.sendKeys(emailId);
		changeFaxNo.clear();
		changeFaxNo.sendKeys(faxNo);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
	}

	@Override
	public void changeToDifferentAccoutn(String accountNo, String selectAccountNo) {

		PegaWebElement element = newWizard.findElement(By.xpath("//a[@title='Open account '" + accountNo + "'']"));
		element.click();
	}

	@Override
	public Wizard switchToFrame() {
		frameId = pegaDriver.getActiveFrameId(false);
		Wizard newWizard = pegaDriver.findWizard(frameId);
		return newWizard;
	}

	@Override
	public void selectDropDownValue(String text) {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement ele = newWizard.findElement(By.xpath(DATE_DROPDOWN_XPATH));
		Select s = new Select(ele);
		s.selectByVisibleText(text);

	}

	@Override
	public void profileSubmitButton() {

		pegaDriver.waitForDocStateReady(3);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();

	}

	@Override
	public String getChildInteractionId() {
		String id = null;
		String mainwindow = driver.getWindowHandle();
		newWizard = switchToFrame();
		newWizard.findElement(By.xpath(TOOLS_MENU_XPATH_BUTTON)).click();
		newWizard = switchToFrame();
		newWizard.findElement(By.xpath(VIEW_HISTORY_MENU_XPATH_BUTTON)).click();
		pegaDriver.waitForDocStateReady(3);
		Set<String> allwindows = driver.getWindowHandles();
		for (String s : allwindows) {
			if (!s.equals(mainwindow)) {
				pegaDriver.switchTo().window(s);
				pegaDriver.switchTo().defaultContent();
				List<WebElement> allelements = pegaDriver.findElements(By.xpath(CHILD_INTERACTION_ID_XPATH));
				id = allelements.get(0).getText();
				pegaDriver.close();

			}
		}
		pegaDriver.switchTo().window(mainwindow);
		System.out.println(id);
		return id;
	}

	@Override
	public String getParentInteractionId() {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		PegaWebElement ele = pegaDriver.findElement(By.xpath(MAIN_INTERACTION_XPATH));
		ele.click();
		System.out.println("clicked");
		pegaDriver.waitForDocStateReady(3);
		// launchWrapup();
		String mainid = null;
		String mainwindow = driver.getWindowHandle();
		newWizard = switchToFrame();
		newWizard.findElement(By.xpath(TOOLS_MENU_XPATH_BUTTON)).click();
		newWizard = switchToFrame();
		pegaDriver.waitForDocStateReady(3);
		newWizard.findElement(By.xpath(VIEW_HISTORY_MENU_XPATH_BUTTON)).click();
		pegaDriver.waitForDocStateReady(3);
		Set<String> allwindows = driver.getWindowHandles();
		for (String s : allwindows) {
			if (!s.equals(mainwindow)) {
				pegaDriver.switchTo().window(s);
				pegaDriver.switchTo().defaultContent();
				List<WebElement> allelements = pegaDriver.findElements(By.xpath(CHILD_INTERACTION_ID_XPATH));
				mainid = allelements.get(0).getText();
				pegaDriver.close();

			}
		}
		pegaDriver.switchTo().window(mainwindow);
		System.out.println("**main id is *" + mainid);
		return mainid;

	}

	@Override
	public void completeWrapUpForInteractions(String interactionSelect, String feedback) {
		newWizard = switchToFrame();
		DropDown reason = newWizard.findSelectBox(By.xpath("//select[@id='ReasonForInteraction']"));
		reason.selectByValue(interactionSelect);
		newWizard = switchToFrame();
		DropDown disposition = newWizard.findSelectBox(By.xpath("//select[@id='ContactDisposition']"));
		disposition.selectByValue(feedback);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);

	}

	@Override
	public String getParentIDStatus(String id) {

		newWizard = switchToFrame();
		PegaWebElement elementvalue = newWizard.findElement(By.xpath(SEARCH_TEXTBOX_XPATH));
		elementvalue.sendKeys(id);
		newWizard = switchToFrame();
		PegaWebElement elementvalue1 = newWizard.findElement(By.xpath(SEARCH_ICON_XPATH));
		elementvalue1.click();
		pegaDriver.waitForDocStateReady(3);
		newWizard = switchToFrame();
		PegaWebElement elementvalue2 = newWizard.findElement(By.xpath(CASE_RESULT_XPATH));
		String value = elementvalue2.getText();
		System.out.println("*" + value);
		return value;

	}

	@Override
	public String getChildStatusValue(String childid) {

		newWizard = switchToFrame();
		PegaWebElement elementvaluec = newWizard.findElement(By.xpath(SEARCH_TEXTBOX_XPATH));
		elementvaluec.clear();

		newWizard = switchToFrame();
		PegaWebElement elementvalue = newWizard.findElement(By.xpath(SEARCH_TEXTBOX_XPATH));
		elementvalue.sendKeys(childid);
		newWizard = switchToFrame();
		PegaWebElement elementvalue1 = newWizard.findElement(By.xpath(SEARCH_ICON_XPATH));
		elementvalue1.click();
		pegaDriver.waitForDocStateReady(3);
		newWizard = switchToFrame();
		PegaWebElement elementvalue2 = newWizard.findElement(By.xpath(RECENT_WORK_XPATH));
		elementvalue2.click();

		newWizard = switchToFrame();
		PegaWebElement elementvalue3 = newWizard.findElement(By.xpath(CHILD_CASE_RESULT_XPATH));
		String value = elementvalue3.getText();
		System.out.println("***" + value);
		return value;
	}

	@Override
	public String getChildText() {
		pegaDriver.switchTo().defaultContent();
		String actualtext = pegaDriver.findElement(By.xpath(CHILD_INTERACTION_LINK_XPATH)).getText();
		return actualtext;

	}

	@Override
	public void checkContactVerification() {
		newWizard = switchToFrame();
		newWizard.findElement(By.xpath("//*[@id='IsSecurityQuestionVerified']")).click();
		newWizard.findElement(By.xpath("//*[@id='IsMotherMaidenVerified']")).click();
		// stolencardsubmitbutton();

	}

	@Override
	public void selectAccount() {
		newWizard = switchToFrame();
		newWizard.findElement(By.xpath(CHILD_INTERACTION_ACCOUNT_XPATH)).click();
		pegaDriver.waitForDocStateReady(3);
		// stolencardsubmitbutton();

	}

	@Override
	public void launchUpdateContactProfile() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement launchUpdateContactProfileoption = newWizard.findElement(By.xpath(UPDATE_CONTACTPROFILE_XPATH));
		launchUpdateContactProfileoption.doubleClick();
		pegaDriver.waitForDocStateReady(3);

	}

	@Override
	public void tabsCount() {
		pegaDriver.switchTo().defaultContent();
		List<WebElement> totalallvaues = pegaDriver.findElements(By.xpath(CHILDS_INTERACTION_LINK_XPATH));
		if (totalallvaues.size() > 0) {
			System.out.println("total elements are " + totalallvaues.size());
		} else {
			System.out.println("total tabs coiunt is zero");
		}

	}

	@Override
	public String tabName() {
		pegaDriver.switchTo().defaultContent();
		List<WebElement> totalallvaues = pegaDriver.findElements(By.xpath(MAIN_INTERACTION_LINK_XPATH));
		String actualtext = totalallvaues.get(0).getText();
		System.out.println(actualtext);
		return actualtext;
	}

	@Override
	public void changeToDifferentAccount(String accountNo, String selectAccountNo) {
		// TODO Auto-generated method stub
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		newWizard.findElement(By.xpath("//span/a[@title='Open account " + accountNo + "']")).click();
		newWizard.findElement(By.xpath("//*[contains(text(),'" + selectAccountNo + "')]")).click();
		pegaDriver.waitForDocStateReady(2);
	}

	@Override
	public void clickTab(String tabText) {
		// TODO Auto-generated method stub
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		newWizard.findElement(By.xpath("//h3[contains(text(),'" + tabText + "')]")).click();
	}

	@Override
	public String verifyBusinessUnitAddedToTask() {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		newWizard.findElement(By.xpath("//button[@title='Add Task']")).click();

		List<WebElement> webElements = newWizard.findElements(By.xpath("//*[@node_name='CPMLocalizedCategoryName']"));
		System.out.println("Size of the List is : : : :" + webElements.size());

		for (WebElement element : webElements) {
			if (element.getText().equalsIgnoreCase("Business Unit")) {

				return element.getText();
			}

		}
		System.out.println("The Element is not found");
		return null;
	}

	@Override
	public List<String> verifyListOfTaskUnderBusinessUnit() {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		List<WebElement> webElements = newWizard.findElements(
				By.xpath("//*[@uniqueid='SID1448880989478']/div[2]/div/div/div[@string_type='sub_section']"));
		List<String> values = new ArrayList<String>();

		for (WebElement element : webElements) {
			values.add(element.getText());

		}

		return values;
	}

	@Override
	public void clickCloseButton() {
		// TODO Auto-generated method stub
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		newWizard.findElement(By.xpath("//a[@class='iconClose']")).click();
	}

	@Override
	public void dropDownValueSelect(String text) {
		// TODO Auto-generated method stub
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement ele = newWizard.findElement(bylocator_DELIVERY_METHOD_XPATH);
		Select s = new Select(ele);
		s.selectByVisibleText(text);
		pegaDriver.waitForDocStateReady(3);

	}

	@Override
	public String getSecondValue() {
		newWizard = switchToFrame();
		List<WebElement> alleles = newWizard
				.findElements(By.xpath("//div[@id='DialogContent' and contains(text(), 'I')]"));
		System.out.println("**" + alleles.size());
		String textvalue = alleles.get(0).getText();
		System.out.println("***" + textvalue);
		return textvalue;
	}

	@Override
	public String addressChangeAndGetCaseID() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement addressChangeOption = newWizard.findElement(By.xpath(ADDRESS_CHANGE_XPATH));
		addressChangeOption.doubleClick();
		pegaDriver.waitForDocStateReady(3);

		PegaWebElement toolsButton = newWizard.findElement(By.xpath("//button[@title='Tools Menu']"));
		toolsButton.click(false);
		String caseID = null;
		// String parentHandle = driver.getWindowHandle();
		PegaWebElement viewHistory = newWizard.findElement(By.xpath(VIEW_HISTORY_MENU_XPATH_BUTTON));
		viewHistory.click();
		testEnv.getBrowser().switchToWindow(2);

		PegaWebElement id = newWizard.findElement(By.xpath("//span[contains(text(),'-')]"));
		caseID = id.getText();
		PegaWebElement closeButton = newWizard.findElement(By.xpath("//button[@title='Close this window']"));
		closeButton.click(false);
		testEnv.getBrowser().switchToWindow(1);

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
		PegaWebElement checkBox = newWizard.findElement(By.id(ADDRESS_CHANGE_CHECKBOX_ID));
		checkBox.click();
		submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
		PegaWebElement confirmButton = newWizard.findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.click(false);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

		return caseID;
	}

	@Override
	public String getSecondListValue() {
		pegaDriver.switchTo().defaultContent();
		List<WebElement> alleles = pegaDriver.findElements(
				By.xpath("//span[@class='field-caption dataLabelForRead' and text()='Potential value:']"));
		System.out.println("" + alleles.size());
		String textvalue = alleles.get(1).getText();
		System.out.println("*" + textvalue);
		return textvalue;
	}

	@Override
	public boolean verifyHomePage() {
		// TODO Auto-generated method stub

		// Verifying the count of the Tabs
		pegaDriver.switchTo().defaultContent();
		boolean result = pegaDriver.findElement(By.xpath("//img[@src='webwb/CPMCallInteractionInactiveIcon.png']"))
				.isDisplayed();
		return result;
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
	public boolean switchToCompositeWindow(String headerName) {
		// TODO Auto-generated method stub
		Set<String> winObj = clickCompositeLink(headerName);
		boolean status = false;
		for (String s : winObj) {
			pegaDriver.switchTo().window(s);
			if (pegaDriver.findElement(By.xpath("//*[contains(text(),'Refresh')]")).isVisible()) {
				status = true;
				return status;
			}
		}
		System.out.println("Element is not visible and returning false value");
		return status;
	}

	@Override
	public void windowClose() {
		// TODO Auto-generated method stub
		pegaDriver.findElement(By.xpath("//*[@title='Close this item ']")).click();
		System.out.println("Window is closed");
	}

	@Override
	public boolean switchToCompositeWindow(String header, By locator) {
		// TODO Auto-generated method stub
		Set<String> winObj = clickCompositeLink(header);
		boolean status = false;
		for (String s : winObj) {
			pegaDriver.switchTo().window(s);
			pegaDriver.switchTo().defaultContent();
			status = commonMethods.verifyVisibilityOfElement(locator, pegaDriver);
			if (status) {
				System.out.println("Inside the If condition for the setting the value for the status");
				System.out.println("The vlaue for the Status is  : :: : :" + status);
				System.out
				.println("Value for the PegaDriver after switching is  : : : " + pegaDriver.getWindowHandle());
				return status;
			}
		}

		return status;
	}

	@Override
	public String verifyCompositeWindowData() {
		// TODO Auto-generated method stub
		String titleValue = null;
		System.out.println("The value for the driver is  : : : :" + pegaDriver.getWindowHandle());
		titleValue = commonMethods.getText(By.xpath("//span[@class='report_title']"), pegaDriver);
		return titleValue;
	}

	@Override
	public void cancelWork() {
		// TODO Auto-generated method stub

		PegaWebElement element = pegaDriver.findElement(By.xpath("//button[@title='Other Actions']"));
		element.click();
		pegaDriver.switchToActiveFrame();
		element = pegaDriver.findElement(By.xpath("//li[@title='Cancel this work']/a"));
		element.click();
	}

	@Override
	public String verifyStatusForWork(String text, String verifyText) {
		// TODO Auto-generated method stub
		pegaDriver.switchToActiveFrame();
		commonMethods = new CommonMethods(pegaDriver);
		PegaWebElement webElement = pegaDriver.findElement(By.xpath("//a[@title and contains(text(),'" + text + "')]"));
		webElement.click();
		pegaDriver.switchToActiveFrame();
		String text1 = commonMethods.getText(By.xpath("//span[contains(text(),'Status')]/../div/span"), pegaDriver);
		return text1;
	}

	@Override
	public void refershExitInteraction(By xpathElement) {
		// TODO Auto-generated method stub
		PegaWebElement element = pegaDriver.findElement(By.xpath("//button[@title='Other Actions']"));
		element.click();
		pegaDriver.switchToActiveFrame();
		element = pegaDriver.findElement(xpathElement);
		element.click();
	}

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

	@Override
	public void searchCustomerByName(String lastName) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement lastNameElmt = newWizard.findElement(By.xpath(LAST_NAME_XPATH));
		lastNameElmt.sendKeys(lastName);
		PegaWebElement search = newWizard.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();

	}
	@Override
	public void searchCustomerByLastName(String lastName) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement lastNameElmt = newWizard.findElement(By.xpath(LAST_NAME_XPATH));
		lastNameElmt.sendKeys(lastName);
		PegaWebElement search = newWizard.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();

	}
	@Override
	public void searchCustomerByNameInbound(String lastName) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement lastNameElmt = newWizard.findElement(By.xpath(LAST_NAME_XPATH));
		lastNameElmt.sendKeys(lastName);
		PegaWebElement search = newWizard.findElement(By.xpath(INBOUND_SEARCH_XPATH));
		search.click();

	}

	@Override
	public void clickSearchButton() {
		// TODO Auto-generated method stub

		WebElement element = pegaDriver.findElement(By.xpath("//button[@title='Search']"));
		element.click();

		/*
		 * //Verify the Search Result table is displayed or not boolean result =
		 * pegaDriver.findElement(By.xpath("//table[@id='gridLayoutTable']")).
		 * isVisible(); commonMethods.verifyResult(result, true);
		 */
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
	public void selectDisputeTransactionwithOutsubmit(String tranName) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		String TRANSACTION_ID_XPATH = "//input[@title='Select Dispute Transaction with ID #tranName#']";
		String finalXPath = new String(TRANSACTION_ID_XPATH).replace("#tranName#", tranName);

		PegaWebElement transLink = newWizard.findElement(By.xpath(finalXPath));
		transLink.click();
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
	public void selectCustomerStatement() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		List<WebElement> transLink = pegaDriver.findElements(By.xpath(TRANSACTION_CHEKBOX_XPATH));
		transLink.get(0).click();
		
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
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
	public void selectBUCustomer() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		List<WebElement> rows = pegaDriver.findElements(By.xpath("//tr[contains(@id,'PD_BusinessUnit_Contacts')]"));
		rows.get(rows.size() - 1).click();
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement submit = newWizard.findElement(By.xpath(CONTACT_RESULT_SUBMIT_XPATH));
		submit.click();

	}

	@Override
	public void selectCustomerfromresult(String username) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		// PegaWebElement accountResult =
		// newWizard.findElement(By.id(SEARCH_RESULT_ID));
		// PegaWebElement accountResult =
		// newWizard.findElement(By.xpath(BTN_PHONECALL_SEARCH_XPATH));
		// accountResult.click();
		// Selects the recent (last record in the grid) record from
		// result-Prasanna Modugu
		// List<WebElement>
		// rows=pegaDriver.findElements(By.xpath("//tr[contains(@id,'PD_Search_Customer$ppxResults')]//span[contains(text(),'"+username+"')]"));
		// rows.get(rows.size()-1).click();
		PegaWebElement result = pegaDriver.findElement(By.xpath(
				"//tr[contains(@id,'PD_Search_Customer$ppxResults')]//span[contains(text(),'" + username + "')]"));
		result.click();
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement submit = newWizard.findElement(By.xpath(CONTACT_RESULT_SUBMIT_XPATH));
		submit.click();

	}

	@Override
	public void selectInboundCustomer() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement accountResult = newWizard.findElement(By.id(INBOUND_SEARCH_RESULT_ID));
		accountResult.click();
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement submit = newWizard.findElement(By.xpath(CONTACT_RESULT_SUBMIT_XPATH));
		submit.click();

	}

	@Override
	public void contactVerification() {
		PegaWebElement verificationCheckBox1 = pegaDriver.findElement(By.id(CONTACT_VERIFICATION_1_ID));
		verificationCheckBox1.check();
		PegaWebElement verificationCheckBox2 = pegaDriver.findElement(By.id(CONTACT_VERIFICATION_2_ID));
		verificationCheckBox2.check();
		PegaWebElement verificationCheckBox3 = pegaDriver
				.findElement(By.xpath("//tr[contains(@oaargs,'CONNOR&QuestionID=11')]//..//input[@type='checkbox']"));
		verificationCheckBox3.check();
		PegaWebElement submit = pegaDriver.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submit.submit();
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
	public void selectQuestionswithoutSubmit() {
		//PegaWebElement verificationCheckBox1 = pegaDriver.findElement(By.id(CONTACT_VERIFICATION_1_ID));
		//verificationCheckBox1.check();
		//PegaWebElement verificationCheckBox2 = pegaDriver.findElement(By.id(CONTACT_VERIFICATION_2_ID));
		//verificationCheckBox2.check();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		int pageexists = pegaDriver.findElements(By.xpath("//span[contains(text(),'Verify contact')]")).size();
		if (pageexists > 0) {
			int noOfQstns = pegaDriver.findElements(By.xpath("//label[contains(@for,'SecurityQuestionOutcomePass')]")).size();

			if (noOfQstns > 0) {
				for (int i = 1; i <= noOfQstns; i++) {
					pegaDriver.waitForDocStateReady(5);
					pegaDriver
					.findElements(By.xpath("//label[contains(@for,'SecurityQuestionOutcomePass')]")).get(i-1).click();

					pegaDriver.waitForDocStateReady(1);
					/*
					 * if(!chkBox.isSelected()){ chkBox.check(); }
					 */
				}
			}
		}
	}
	@Override
	public void submitWithoutSelectingQuestions() {

		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		pegaDriver.waitForDocStateReady(2);
		// PegaWebElement submitButton =
		// pegaDriver.findElement(By.xpath("//div[@class='pzbtn-mid' and
		// text()='Submit']"));
		PegaWebElement submitButton = pegaDriver.findElement(By.xpath("//button[contains(.,'Submit')]"));
		submitButton.click();
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
	public void clickContactNotVerified() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		int pageexists = pegaDriver.findElements(By.xpath("//span[contains(text(),'Verify contact')]")).size();
		if (pageexists > 0) {


			//String numberofquestext = pegaDriver.findElement(By.xpath("//div[@data-test-id='201802070240470255365646']")).getText();

			PegaWebElement submit = pegaDriver.findElement(By.xpath("//button[text()='Not Verified']"));
			submit.click(false);
			pegaDriver.waitForDocStateReady(3);
		}
	}

	@Override
	public void clickonContactNotVerifiedForInteractions() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		int pageexists = pegaDriver.findElements(By.xpath("//span[contains(text(),'Account verification')]")).size();
		if (pageexists > 0) {


			//String numberofquestext = pegaDriver.findElement(By.xpath("//div[@data-test-id='201802070240470255365646']")).getText();

			PegaWebElement submit = pegaDriver.findElement(By.xpath("//button[text()='Not Verified']"));
			submit.click(false);
			pegaDriver.waitForDocStateReady(3);
		}
	}


	@Override
	public void clickonContactNotVerified() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		int pageexists = pegaDriver.findElements(By.xpath("//label[contains(text(),'Verify contact')]")).size();
		if (pageexists > 0) {


			//String numberofquestext = pegaDriver.findElement(By.xpath("//div[@data-test-id='201802070240470255365646']")).getText();

			PegaWebElement submit = pegaDriver.findElement(By.xpath("//button[text()='Not Verified']"));
			submit.click(false);
			pegaDriver.waitForDocStateReady(3);
		}
	}
	@Override
	public void contactVerificationWithOneQuestions() {
		PegaWebElement verificationCheckBox1 = pegaDriver.findElement(By.id(CONTACT_VERIFICATION_1_ID));
		verificationCheckBox1.check();

		PegaWebElement submit = pegaDriver.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submit.submit();
	}
	@Override
	public void contactVerificationQuestionsforInteractions() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		int pageexists = pegaDriver.findElements(By.xpath("//span[contains(text(),'Account verification')]")).size();

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

					PegaWebElement verification = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
					if(verification.isEnabled())
					{
						pegaDriver.switchTo().defaultContent();
						pegaDriver.switchTo().frame("PegaGadget1Ifr");
						PegaWebElement submitButton = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
						submitButton.click();
						pegaDriver.waitForDocStateReady(3);
						break;

					}
					//String minscore=pegaDriver.findElement(By.xpath("//span[@data-test-id='20180516055556061450494']")).getText();
					//int minscorereq= Integer.parseInt(minscore);
					// String currentscore=pegaDriver.findElement(By.xpath("//span[@data-test-id='2018051606010007135234']")).getText();
					//int currentscorereq= Integer.parseInt(currentscore);

					// if(minscorereq>currentscorereq)
					// {
					// PegaWebElement submit = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
					//submit.click(false);
					//pegaDriver.waitForDocStateReady(3);
					// }
					//else
					//{
					//pegaDriver.waitForDocStateReady(1);
					//pegaDriver
					//.findElements(By.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]")).get(i-1).click();      

				}
			}

			/*
			 * if(!chkBox.isSelected()){ chkBox.check(); }
			 */

		}

		else
		{
			//String numberofquestext = pegaDriver.findElement(By.xpath("//div[@data-test-id='201802070240470255365646']")).getText();
			Assert.assertTrue("No Verification validated successfully", pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Account Verification')]")));
		}

		//PegaWebElement submit = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
		//submit.click(
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
	public void contactVerificationforContact() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		int pageexists = pegaDriver.findElements(By.xpath("//span[contains(text(),'Verify contact')]")).size();

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



					try{
						PegaWebElement verification = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
						if(verification.isEnabled())
						{
							pegaDriver.switchTo().defaultContent();
							pegaDriver.switchTo().frame("PegaGadget1Ifr");
							PegaWebElement submitButtons = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
							submitButtons.click(false);
							pegaDriver.waitForDocStateReady(3);
							break;
						}
					}
					catch(Exception e) {
						PegaWebElement verification = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
						if(verification.isEnabled())
						{
							pegaDriver.switchTo().defaultContent();
							pegaDriver.switchTo().frame("PegaGadget1Ifr");
							PegaWebElement submitButtons = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
							submitButtons.click(false);
							pegaDriver.waitForDocStateReady(3);
							break;
						}
					}

					//String minscore=pegaDriver.findElement(By.xpath("//span[@data-test-id='20180516055556061450494']")).getText();
					//int minscorereq= Integer.parseInt(minscore);
					// String currentscore=pegaDriver.findElement(By.xpath("//span[@data-test-id='2018051606010007135234']")).getText();
					//int currentscorereq= Integer.parseInt(currentscore);

					// if(minscorereq>currentscorereq)
					// {
					// PegaWebElement submit = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
					//submit.click(false);
					//pegaDriver.waitForDocStateReady(3);
					// }
					//else
					//{
					//pegaDriver.waitForDocStateReady(1);
					//pegaDriver
					//.findElements(By.xpath("//label[contains(@for,'Pass') and contains(@class,'rb_ rb_standard radioLabel')]")).get(i-1).click();      

				}
			}

			/*
			 * if(!chkBox.isSelected()){ chkBox.check(); }
			 */

		}

		else
		{
			//String numberofquestext = pegaDriver.findElement(By.xpath("//div[@data-test-id='201802070240470255365646']")).getText();
			Assert.assertTrue("No Verification validated successfully", pegaDriver.verifyElement(By.xpath("//label[contains(text(),'Verify contact')]")));
		}

		//PegaWebElement submit = pegaDriver.findElement(By.xpath("//button[text()='Verified']"));
		//submit.click(false);
		//pegaDriver.waitForDocStateReady(3);
	}




	@Override
	public void clickOnToolsMenuButton() {
		pegaDriver.waitForDocStateReady(1);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//button[@title='Tools Menu' or @title='Tools menu' or @title='Help' or @title='Other actions']"));
		PegaWebElement toolsMenu = pegaDriver
				.findElement(By.xpath("//button[@title='Tools Menu' or @title='Tools menu' or @title='Help' or @title='Other actions']"));
		//toolsMenu.scrollIntoView();
		pegaDriver.waitForDocStateReady(1);
		toolsMenu.click();
		pegaDriver.waitForDocStateReady(1);

	}

	@Override
	public void verifyOptionsInToolsMenu() {
		pegaDriver.waitForDocStateReady(1);
		/*Assert.assertTrue("Where Am I menu option is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Where am I?']")));
		Assert.assertTrue("History and Attachment option is not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='History and Attachments']")));
		Assert.assertTrue("Pulse option is not present", pegaDriver.verifyElement(By.xpath("//span[text()='Pulse']")));*/

	}

	@Override
	public void selectConfigTools() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.findElement(By.xpath(ConfigurationTools_Xpath)).click();

	}

	@Override
	public void selectTabAtConfigTools(String TabName) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath("//h3[text()='" + TabName + "']/ancestor::div[1]")).click();
		/*
		 * pegaDriver.findElement(By.xpath(
		 * "//h3[text()='Knowledge content']/ancestor::div[1]")).click();
		 * if(!TabName.equalsIgnoreCase("Knowledge content")){
		 * pegaDriver.switchTo().defaultContent();
		 * pegaDriver.switchTo().frame(IFrame2);
		 * pegaDriver.findElement(By.xpath("//h3[text()='"+TabName+
		 * "']/ancestor::div[1]")).click(); }
		 */
	}

	@Override
	public void deleteAllExistingDialogs() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		int noOfDialogs = pegaDriver.findElements(By.xpath(Btn_DeleteDialog_Xpath)).size();
		for (int i = 0; i < noOfDialogs; i++) {
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame(IFrame2);
			pegaDriver.findElement(By.xpath(Btn_DeleteDialog_Xpath + "[1]")).click();
		}
	}

	@Override
	public void deleteAllExistingCoachingTips() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		int noOfDialogs = pegaDriver.findElements(By.xpath(Btn_DeleteCoachingTip_Xpath)).size();
		for (int i = 0; i < noOfDialogs; i++) {
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame(IFrame2);
			pegaDriver.findElement(By.xpath(Btn_DeleteCoachingTip_Xpath + "[1]")).click();
		}
	}

	@Override
	public void deleteAllAssignedCoachingTips() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Tab_Assign_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		int noOfDialogs = pegaDriver.findElements(By.xpath(Btn_DeleteAssignedCoachingTip_Xpath)).size();
		for (int i = 0; i < noOfDialogs; i++) {
			pegaDriver.switchTo().defaultContent();
			pegaDriver.switchTo().frame(IFrame2);
			pegaDriver.findElement(By.xpath(Btn_DeleteAssignedCoachingTip_Xpath + "[1]")).click();
		}
	}

	@Override
	public void createNewCoachingTips(String CoachingTipName, String CoachingTip) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Link_AddNewCoachingTip_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Txt_EnterName_Xpath)).sendKeys(CoachingTipName);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Txt_EnterCoachingTip_Xpath)).sendKeys(CoachingTip);
	}

	@Override
	public void updateCoachingTips(String CoachingTipName, String CoachingTip) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Btn_EditCoachingTip_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		/*pegaDriver.findElement(By.xpath(Link_AddNewCoachingTip_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);*/
		pegaDriver.findElement(By.xpath(Txt_EnterName_Xpath)).clear();
		pegaDriver.findElement(By.xpath(Txt_EnterName_Xpath)).sendKeys(CoachingTipName);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Txt_EnterCoachingTip_Xpath)).clear();
		pegaDriver.findElement(By.xpath(Txt_EnterCoachingTip_Xpath)).sendKeys(CoachingTip);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Btn_CTSave)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.className(Btn_Close_CN)).click();
	}

	@Override
	public void assignCoachingTips(String CoachingTipName, String AssignTo, String AssignToValue, String FromDate,
			String ToDate) {
		/*
		 * pegaDriver.switchTo().defaultContent();
		 * pegaDriver.switchTo().frame(IFrame2);
		 * pegaDriver.findElement(By.xpath(Tab_Assign_Xpath)).click();
		 */
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Link_AssignTip_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		DropDown CoachingTipDDL = pegaDriver.findSelectBox(By.id(DDL_CoachingTip_Id));
		CoachingTipDDL.selectByVisibleText(CoachingTipName);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		DropDown EntityType = pegaDriver.findSelectBox(By.id(DDL_AssignTo_Id));
		EntityType.selectByVisibleText(AssignTo);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		DropDown Entity = pegaDriver.findSelectBox(By.id(DDL_AssignToValue_Id));
		Entity.selectByVisibleText(AssignToValue);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		Calendar date = Calendar.getInstance();
		date.setTime(new Date());
		SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(FromDate + "Start Date***");
		if (FromDate.equalsIgnoreCase("") || FromDate.equalsIgnoreCase(null)) {
			FromDate = f.format(date.getTime());
		}
		if (ToDate.equalsIgnoreCase("") || ToDate.equalsIgnoreCase(null)) {
			date.add(Calendar.YEAR, 5);
			ToDate = f.format(date.getTime());
		}
		System.out.println(ToDate + "End Date***");
		pegaDriver.findElement(By.xpath(Txt_StartDate_Xpath)).sendKeys(FromDate);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Txt_EndDate_Xpath)).sendKeys(ToDate);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Btn_CTSave)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.className(Btn_Close_CN)).click();
		/*
		 * pegaDriver.handleWaits().sleep(5);
		 * pegaDriver.switchTo().defaultContent();
		 * pegaDriver.switchTo().frame("PegaGadget2Ifr");
		 * pegaDriver.findElement(By.xpath(
		 * "//img[contains(@src,'coachingtipicon')]")).click();
		 */
	}

	@Override
	public void configureNewDialog(String Dialog) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Link_AddNew_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		DropDown When = pegaDriver.findSelectBox(By.xpath(DDL_When_Xpath));
		When.selectByVisibleText("Default");
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Txt_Dialog_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Txt_Dialog_Xpath)).sendKeys(Dialog);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Btn_Save)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.className(Btn_Close_CN)).click();
	}

	@Override
	public void updateDialog(String Dialog) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Btn_EditDialog_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		DropDown When = pegaDriver.findSelectBox(By.xpath(DDL_When_Xpath));
		When.selectByVisibleText("Default");
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Txt_Dialog_Xpath)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Txt_Dialog_Xpath)).clear();
		pegaDriver.findElement(By.xpath(Txt_Dialog_Xpath)).sendKeys(Dialog);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.xpath(Btn_Save)).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame(IFrame2);
		pegaDriver.findElement(By.className(Btn_Close_CN)).click();
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
	public void clickOnActionsitem(String buttonName) {
		pegaDriver.waitForDocStateReady(1);
		PegaWebElement otherActions = pegaDriver.findElement(By.xpath("//span[contains(text(),'" + buttonName + "')]"));
		otherActions.click();
		pegaDriver.waitForDocStateReady(1);

	}

	@Override
	public void exitInteractionwithcomment() {
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchToActiveFrame();
		PegaWebElement commentBox = pegaDriver.findElement(By.xpath("//textarea[@id='CancelNotes']"));
		commentBox.sendKeys("Exiting Interaction");
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchToActiveFrame();

		PegaWebElement submitbutton = pegaDriver.findElement(By.xpath(SUBMIT_BUTTON_XPATH));
		submitbutton.click();

	}
	@Override
	public void enterReasonAndClickSubmitButton() {
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchToActiveFrame();
		PegaWebElement commentBox = pegaDriver.findElement(By.xpath("//textarea[@id='BypassVerificationNotes']"));
		commentBox.sendKeys("ByPass Verification");
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchToActiveFrame();

		PegaWebElement submitbutton = pegaDriver.findElement(By.xpath(SUBMIT_BUTTON_XPATH));
		submitbutton.click();

	}

	@Override
	public void changeAddress() {
		/*Actions action = new Actions(pegaDriver.getDriver());
		action.sendKeys(Keys.ESCAPE).build().perform();*/
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
		// DropDown stateCode =
		// newWizard.findSelectBox(By.xpath("//select[@id='StateCode']"));
		// stateCode.selectByValue("CO");
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
	public void upDateAddress(String AdLn1, String AdLn2, String PCode, String Phone) {
		Actions action = new Actions(pegaDriver.getDriver());
		action.sendKeys(Keys.ESCAPE).build().perform(); 
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement changeAddress1 = newWizard.findElement(By.xpath(ADDRESS_LINE1_XPATH));
		changeAddress1.clear();
		changeAddress1.sendKeys(AdLn1);
		PegaWebElement changeAddress = newWizard.findElement(By.xpath(ADDRESS_LINE2_XPATH));
		changeAddress.clear();
		changeAddress.sendKeys(AdLn2);

		DropDown CountryCode = newWizard.findSelectBox(By.xpath(COUNTRY_CODE_XPATH));
		CountryCode.selectByValue("USA");

		PegaWebElement city = newWizard.findElement(By.xpath(CITY_XPATH));
		city.clear();
		city.sendKeys("London");

		PegaWebElement zipCode = newWizard.findElement(By.xpath(POSTAL_CODE_XPATH));
		zipCode.clear();
		zipCode.sendKeys(PCode);
		PegaWebElement HomePhone = newWizard.findElement(By.xpath(HOME_PHONE_XPATH));
		HomePhone.clear();
		HomePhone.sendKeys(Phone);

		/*
		 * PegaWebElement state =
		 * newWizard.findElement(By.xpath("//input[@id='NoState']"));
		 * state.clear(); state.sendKeys("New South Wales");
		 */

		DropDown state = newWizard.findSelectBox(By.xpath("//select[@id='StateCode']"));
		state.selectByValue("IL");

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
	public void confirmchange() {
		pegaDriver.switchToActiveFrame();
		PegaWebElement confirmButton = pegaDriver.findElement(By.xpath(BUTTON_OK_XPATH));
		confirmButton.click(false);
		pegaDriver.waitForDocStateReady(2);

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
	public void WrapUpInteraction() {

		/*frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		newWizard.findElement(By.xpath("//button[@title='Wrap Up' and contains(@data-dblclick,'DataTransform')]")).click();*/
		pegaDriver.switchTo().activeElement().sendKeys(Keys.chord(Keys.ALT,"W"));
	}
	@Override
	public void lauchQuickWrap() {
		PegaWebElement wrapUp = pegaDriver.findElement(By.xpath(WRAP_UP_XPATH));
		wrapUp.click();

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
		/*
		 * DropDown disposition = newWizard.findSelectBox(By.xpath(
		 * "//select[@id='ReasonForInteraction']"));
		 * disposition.selectByValue(reason);
		 */
		// Chat team will update the code
		/*PegaWebElement emailChatLog = newWizard.findElement(By.xpath(SERVICECASE_EMAILCHATLOG_XPATH));
		emailChatLog.click();*/
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();

	}

	@Override
	public void completeChatWrapUpWithoutReason() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		/*
		 * DropDown disposition = newWizard.findSelectBox(By.xpath(
		 * "//select[@id='ReasonForInteraction']"));
		 * disposition.selectByValue(reason);
		 */
		PegaWebElement emailChatLog = newWizard.findElement(By.xpath(SERVICECASE_EMAILCHATLOG_XPATH));
		emailChatLog.click();
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();

	}

	@Override
	public String hoverOnCoachingTip() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement coachingTip = newWizard
				.findElement(By.xpath("//i[@class='icons']/img[@alt='' and contains(@data-hover,'CPMCoachingTip')]"));
		coachingTip.mouseOver();
		PegaWebElement coachingTipText = newWizard
				.findElement(By.xpath("//i[@class='icons']/img[@alt='' and contains(@data-hover,'CPMCoachingTip')]"));
		return coachingTipText.getText();

	}

	@Override
	public List<WebElement> noChoachingTips() {
		List<WebElement> coahingTip = newWizard
				.findElements(By.xpath("//i[@class='icons']/img[@alt='' and contains(@data-hover,'CPMCoachingTip')]"));
		return coahingTip;
	}

	@Override
	public String noDialog() {
		String text = pegaDriver.findElement(By.xpath("//div[@rwa='CPMDisplayCoachingTip,']")).getText();
		return text;
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
	public void updateBUCommDetails() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		//PegaWebElement confirmButton = newWizard.findElement(By.xpath(SERVICECASE_CONFIRM_XPATH));
		//confirmButton.click(false);
		pegaDriver.switchToActiveFrame();
	}

	@Override
	public void addBUName(String name, String role) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		PegaWebElement addButton = pegaDriver.findElement(By.xpath(PLUS_BUTTON_XPATH));
		addButton.click();
		pegaDriver.waitForDocStateReady(2);
		AutoComplete nameobj = pegaDriver.findAutoComplete(By
				.xpath("//input[contains(@name, 'AccountOwner_BusinessUnits') and contains(@id, 'OrganizationName')]"));
		nameobj.sendKeys(name);
		/*
		 * PegaWebElement buName = pegaDriver.findElement(By.xpath(
		 * "//input[contains(@name, 'AccountOwner_BusinessUnits') and contains(@id, 'BusinessUnitName')]"
		 * )); buName.sendKeys(name);
		 */
		DropDown roleType = newWizard.findSelectBox(By.xpath("//select[contains(@id,'RoleId')]"));
		roleType.selectByVisibleText(role);
		pegaDriver.waitForDocStateReady(2);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		pegaDriver.switchToActiveFrame();

	}

	@Override
	public void confirmModifyBULinks() {
		pegaDriver.waitForDocStateReady(2);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		List<WebElement> confirmButton = newWizard.findElements(By.xpath(SERVICECASE_CONFIRM_XPATH));
		confirmButton.get(1).click();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

	}

	@Override
	public void openAuthorizedContacts() {
		// pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement authoriedContacts = newWizard.findElement(By.xpath("//h2[text()='Authorized contacts']"));
		authoriedContacts.click(false);

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
	public void closeChildInteraction() {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		PegaWebElement closeChildInteraction = pegaDriver
				.findElement(By.xpath("//span[@title='Close Tab' and @class='iconCloseSmall']"));
		closeChildInteraction.click();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
	}

	@Override
	public void closeParentInteractions() {
		pegaDriver.switchTo().defaultContent();
		PegaWebElement closeChildInteraction = pegaDriver
				.findElement(By.xpath("//span[@title='Close Tab' and @class='iconCloseSmall']"));
		closeChildInteraction.click();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
	}

	@Override
	public void selectInteraction(String contact) {
		pegaDriver.switchTo().defaultContent();
		String finalXPath = new String(INTERACTION_TITLE_XPATH).replace("#contact#", contact);
		PegaWebElement interactionTitle = pegaDriver.findElement(By.xpath(finalXPath));
		interactionTitle.click();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
	}

	@Override
	public void launchSuggestedTask(String suggestedTask) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		String finalXPath = new String(SUGGESTED_TASK_XPATH).replace("#suggestedTask#", suggestedTask);
		PegaWebElement accountSelection = newWizard.findElement(By.xpath(finalXPath));
		accountSelection.click();
	}

	@Override
	public void launchOffer(String suggestedOffer) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		String finalXPath = new String(SUGGESTED_OFFER_XPATH).replace("#suggestedOffer#", suggestedOffer);
		PegaWebElement accountSelection = newWizard.findElement(By.xpath(finalXPath));
		accountSelection.click();
	}

	@Override
	public void launchCaseFromInboundWorkbasket(String workBasket, String caseID) {
		System.out.println(caseID);

		// frameId = pegaDriver.getActiveFrameId(false);
		// newWizard = pegaDriver.findWizard(frameId);

		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement workBasketTab = newWizard.findElement(By.xpath(WORKBASKET_LINK_XPATH));
		workBasketTab.click();
		DropDown workBasketSelect = newWizard.findSelectBox(By.xpath(WORKBASKET_XPATH));
		workBasketSelect.selectByValue(workBasket);
		String finalXpath = new String("//a[text()='#id#']").replace("#id#", caseID);
		PegaWebElement launchCaseID = newWizard.findElement(By.xpath(finalXpath));
		System.out.println(finalXpath);
		launchCaseID.scrollIntoView();
		pegaDriver.waitForDocStateReady(5);
		launchCaseID.click();
		// System.out.println("Opening the Inbound Interaction");
		// frameId = pegaDriver.getActiveFrameId(false);
		// newWizard = pegaDriver.findWizard(frameId);
		// PegaWebElement submitButton =
		// newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		// submitButton.click();

	}

	@Override
	public void selectStatementForLostCard() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement selectStatement = newWizard.findElement(
				By.xpath("//tr[contains(@id,'$ppxResults$l1') and contains(@oaargs,'PegaCA-Interface-Account')]"));
		selectStatement.click();
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		pegaDriver.switchToActiveFrame();
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
	public void selectAddressForDelivery(String delivery) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		if (delivery.equalsIgnoreCase("Mail")) {
			DropDown deliveryOption = newWizard.findSelectBox(By.xpath(DELIVERY_METHOD_DROPDOWN_XPATH));
			deliveryOption.selectByValue(delivery);
		}

		else if (delivery.equalsIgnoreCase("Branch")) {
			DropDown deliveryOption = newWizard.findSelectBox(By.xpath(DELIVERY_METHOD_DROPDOWN_XPATH));
			deliveryOption.selectByValue(delivery);

			frameId = pegaDriver.getActiveFrameId(false);
			newWizard = pegaDriver.findWizard(frameId);

			newWizard.findElement(By.xpath("//*[contains(@title,'Populate the fields')]")).click();

		}

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
	public void closeAccountwithcomment(String comment) {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement comments = newWizard.findElement(By.id("Comments"));
		comments.sendKeys(comment);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		pegaDriver.switchToActiveFrame();

	}

	@Override
	public void negotiateRetention() {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Next >>']"));
		submitButton.click(false);

	}

	@Override
	public void removeItemFromOffer() {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement removeItem = newWizard.findElement(By.xpath("//i[contains(@title,'Remove from Cart	2 ')]"));
		removeItem.click(false);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement accept = newWizard.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Accept']"));
		accept.click(false);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		/*
		 * PegaWebElement nextButton = newWizard.findElement(By.xpath(
		 * "//div[@class='pzbtn-mid' and text()='Next']"));
		 * nextButton.click(false); PegaWebElement submitButton =
		 * newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		 * submitButton.click(false);
		 */

	}

	@Override
	public void acceptOrDeclainOffer(String type) {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(2);

		String Initial_Xpath = "//div[@class='pzbtn-mid' and text()='#sericecase#']";
		String finalXPath = new String(Initial_Xpath).replace("#sericecase#", type);

		PegaWebElement submitButton = pegaDriver.findElement(By.xpath(finalXPath));
		submitButton.click();

		pegaDriver.waitForDocStateReady(2);

	}

	@Override
	public void switchtoTabforUser(String tabName) {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(2);

		String Initial_Xpath = "//h3[contains(text(),'#sericecase#')]";
		String finalXPath = new String(Initial_Xpath).replace("#sericecase#", tabName);

		PegaWebElement switchTab = pegaDriver.findElement(By.xpath(finalXPath));
		switchTab.click();
		pegaDriver.waitForDocStateReady(2);
	}

	@Override
	public void learnMoreAndAcceptOffer() {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement learnMore = newWizard.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Learn More']"));
		learnMore.click(false);
		PegaWebElement accept = newWizard.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Accept']"));
		accept.click(false);
		PegaWebElement nextButton = newWizard.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Next']"));
		nextButton.click(false);

	}

	@Override
	public void deferOffer() {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement notNow = newWizard.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Not Now']"));
		notNow.click(false);
	}

	@Override
	public void declineOffer() {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement decline = newWizard.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Decline']"));
		decline.click(false);
	}

	@Override
	public void switchCase(String serviceProcess) {
		pegaDriver.waitForDocStateReady(2);
		String SERVICE_PROCESS_XPATH = "//a[contains(@title,'QueuedTask') or contains(@title,'InProgressTask')][contains(text(),'#sericecase#')]";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#sericecase#", serviceProcess);
		driver.switchTo().activeElement().findElement(By.xpath(finalXPath));
		PegaWebElement serviceCae = newWizard.findElement(By.xpath(finalXPath));
		serviceCae.click(false);
	}

	@Override
	public void selectComplaint() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement complaint = newWizard.findElement(By.xpath(COMPLAINT_XPATH));
		complaint.click();
	}

	@Override
	public void selectTypeAsIssueAs(String option, String type, String issueType) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown typeDropDown = newWizard.findSelectBox(By.xpath(TYPE_DROPDOWN_XPATH));
		typeDropDown.selectByValue(type);
		pegaDriver.waitForDocStateReady(2);
		DropDown issueDropDown = newWizard.findSelectBox(By.xpath(ISSUE_DROPDOWN_XPATH));
		issueDropDown.selectByValue(issueType);
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath(SERVICECASE_SUBMIT_XPATH));
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}

	/*
	 * @Override public void switchToInteraction(String interaction){
	 * pegaDriver.switchTo().defaultContent(); String InteractionTitle =
	 * "//a[contains(text(),'#interaction#')]"; String finalXPath = new
	 * String(InteractionTitle).replace("#serviceProcess#", interaction);
	 * PegaWebElement interactionTitle =
	 * newWizard.findElement(By.xpath(finalXPath)); interactionTitle.click();
	 * 
	 * }
	 */

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
	public void launchDisputeTranFromLink(String transId) {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		/*
		 * PegaWebElement transactions = newWizard.findElement(By.xpath(
		 * "//div[@title='Disclose Transactions']")); transactions.click();
		 */
		pegaDriver.waitForDocStateReady(1);
		String finalXPath = new String(TRANSACTION_ID_XPATH).replace("#transId#", transId);
		PegaWebElement transLink = newWizard.findElement(By.xpath(finalXPath));
		transLink.click();
		pegaDriver.switchToActiveFrame();

	}

	@Override
	public void cancelFlow() {
		PegaWebElement cancelItem = pegaDriver.findElement(By.xpath("//span[text()='Cancel this work']"));
		cancelItem.click(false);

	}

	@Override
	public void submitCancelFlow() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);

	}

	@Override
	public void submitFlow() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
	}

	@Override
	public void launchCreateContactFlow() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(CREATE_CONTACT_XPATH));
		submitButton.click(false);
	}

	@Override
	public String getCaseID() {
		//PegaWebElement toolsButton = pegaDriver.findElement(By.xpath("//button[@title='Other actions']"));
		PegaWebElement toolsButton = pegaDriver.findElement(By.xpath("//button[@title='Help' or @title='Other actions']"));
		toolsButton.click(false);

		// String caseId = null;
		// String parentHandle = driver.getWindowHandle();
		PegaWebElement viewHistory = pegaDriver.findElement(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH));
		viewHistory.click();
		pegaDriver.waitForDocStateReady(2);
		testEnv.getBrowser().switchToWindow(2);

		/*
		 * PegaWebElement id = pegaDriver.findElement(By .xpath(
		 * "//span[contains(text(),'I-') or contains(text(),'S-')]"));
		 */
		//String idOfCase = pegaDriver.findElement(By.xpath("//span[contains(text(),'I-') or contains(text(),'S-') or contains(text(),'C-') or contains(text(),'Task-')]")).getText();
		String idOfCase = pegaDriver.findElement(By.xpath("//span[contains(text(),'I-') or contains(text(),'S-') or contains(text(),'C-') or contains(text(),'Task-') or contains(text(),'IDS-') ]")).getText();
		// caseId = id.getText();
		// PegaWebElement closeButton =
		// pegaDriver.findElement(By.xpath("//td[@id='HeaderButtonIconsTDId']//*[@title='Cancel
		// ']"));
		// closeButton.click(false);
		////span[contains(text(),'I-') or contains(text(),'S-') or contains(text(),'C-')]
		testEnv.getBrowser().close();
		testEnv.getBrowser().switchToWindow(1);
		System.out.println(idOfCase);
		CaseID = idOfCase.trim();
		System.out.println(CaseID);
		return CaseID;
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
	public void verifyByPassVerificationinHistory() {
		//PegaWebElement toolsButton = pegaDriver.findElement(By.xpath("//button[@title='Other actions']"));

		pegaDriver.waitForDocStateReady(1);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//button[@title='Tools Menu' or @title='Tools menu' or @title='Help' or @title='Other actions']"));
		PegaWebElement toolsMenu = pegaDriver
				.findElement(By.xpath("//button[@title='Tools Menu' or @title='Tools menu' or @title='Help' or @title='Other actions']"));
		//toolsMenu.scrollIntoView();
		pegaDriver.waitForDocStateReady(2);
		toolsMenu.click();
		/*PegaWebElement toolsButton = pegaDriver.findElement(By.xpath("//button[@title='Help' or @title='Other actions']"));
		toolsButton.click(false);*/

		// String caseId = null;
		// String parentHandle = driver.getWindowHandle();
		pegaDriver.waitForDocStateReady(1);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement viewHistory = pegaDriver.findElement(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH));
		viewHistory.click();
		pegaDriver.waitForDocStateReady(2);
		testEnv.getBrowser().switchToWindow(2);

		/*
		 * PegaWebElement id = pegaDriver.findElement(By .xpath(
		 * "//span[contains(text(),'I-') or contains(text(),'S-')]"));
		 */
		//String idOfCase = pegaDriver.findElement(By.xpath("//span[contains(text(),'I-') or contains(text(),'S-') or contains(text(),'C-') or contains(text(),'Task-')]")).getText();
		pegaDriver.waitForDocStateReady(1);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		PegaWebElement history = pegaDriver.findElement(By.xpath("//td[@title='Disclose History']"));
		history.click();
		Assert.assertTrue("By Pass Verification Text not present", pegaDriver.verifyElement(By.xpath("//td[@class='tdLeftStyle' and contains(.,'Bypass verification')]")));
		// caseId = id.getText();
		// PegaWebElement closeButton =
		// pegaDriver.findElement(By.xpath("//td[@id='HeaderButtonIconsTDId']//*[@title='Cancel
		// ']"));
		// closeButton.click(false);
		////span[contains(text(),'I-') or contains(text(),'S-') or contains(text(),'C-')]
		testEnv.getBrowser().close();
		testEnv.getBrowser().switchToWindow(1);
	}

	@Override
	public void verifyNoQuestionsAvailable() {
		//PegaWebElement toolsButton = pegaDriver.findElement(By.xpath("//button[@title='Other actions']"));

		pegaDriver.waitForDocStateReady(1);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//button[@title='Tools Menu' or @title='Tools menu' or @title='Help' or @title='Other actions']"));
		PegaWebElement toolsMenu = pegaDriver
				.findElement(By.xpath("//button[@title='Tools Menu' or @title='Tools menu' or @title='Help' or @title='Other actions']"));
		//toolsMenu.scrollIntoView();
		pegaDriver.waitForDocStateReady(2);
		toolsMenu.click();
		/*PegaWebElement toolsButton = pegaDriver.findElement(By.xpath("//button[@title='Help' or @title='Other actions']"));
		toolsButton.click(false);*/

		// String caseId = null;
		// String parentHandle = driver.getWindowHandle();
		pegaDriver.waitForDocStateReady(1);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement viewHistory = pegaDriver.findElement(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH));
		viewHistory.click();
		pegaDriver.waitForDocStateReady(2);
		testEnv.getBrowser().switchToWindow(2);

		/*
		 * PegaWebElement id = pegaDriver.findElement(By .xpath(
		 * "//span[contains(text(),'I-') or contains(text(),'S-')]"));
		 */
		//String idOfCase = pegaDriver.findElement(By.xpath("//span[contains(text(),'I-') or contains(text(),'S-') or contains(text(),'C-') or contains(text(),'Task-')]")).getText();
		pegaDriver.waitForDocStateReady(1);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		PegaWebElement history = pegaDriver.findElement(By.xpath("//td[@title='Disclose History']"));
		history.click();
		Assert.assertTrue("By Pass Verification Text not present", pegaDriver.verifyElement(By.xpath("//td[@class='tdLeftStyle' and contains(.,'no questions available')]")));
		// caseId = id.getText();
		// PegaWebElement closeButton =
		// pegaDriver.findElement(By.xpath("//td[@id='HeaderButtonIconsTDId']//*[@title='Cancel
		// ']"));
		// closeButton.click(false);
		////span[contains(text(),'I-') or contains(text(),'S-') or contains(text(),'C-')]
		testEnv.getBrowser().close();
		testEnv.getBrowser().switchToWindow(1);
	}



	@Override
	public void validateSearchScreen() {
		pegaDriver.waitForDocStateReady(2);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		Assert.assertTrue("Search Text is not present", pegaDriver.verifyElement(By.xpath("//button[text()='Search']")));

	}


	@Override
	public String getCaseIDunderToolsmenu() {
		PegaWebElement toolsButton = pegaDriver
				.findElement(By.xpath("//button[@title='Tools Menu' or @title='Tools menu' or @title='Help']"));
		toolsButton.click(false);
		PegaWebElement viewHistory = pegaDriver.findElement(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH));
		viewHistory.click();
		testEnv.getBrowser().switchToWindow(2);

		String idOfCase = pegaDriver.findElement(By.xpath("//span[contains(text(),'I-') or contains(text(),'S-') or contains(text(),'C-') or contains(text(),'Task-') or contains(text(),'IDS-') ]")).getText();
		testEnv.getBrowser().close();
		testEnv.getBrowser().switchToWindow(1);
		System.out.println(idOfCase);
		CaseID = idOfCase.trim();
		System.out.println(CaseID);
		return CaseID;
	}


	//@Override

	/*public String searchCaseIdaftercompletion(String caseidtext) { 
			frameId = pegaDriver.getActiveFrameId(false); 
			newWizard = pegaDriver.findWizard(frameId);
			System.out.println(caseidtext); 
			PegaWebElement searchButton = newWizard.findElement(By.xpath("//span/i/img[@tabindex=0]")); 
			searchButton.click(); pegaDriver.waitForDocStateReady(1); 
			PegaWebElement myworkTAB = newWizard.findElement(By.xpath("//h3[contains(text(),'Recent work')]")); 
			myworkTAB.click(); 
			pegaDriver.waitForDocStateReady(1); 
			frameId = pegaDriver.getActiveFrameId(false); 
			newWizard = pegaDriver.findWizard(frameId); 
			PegaWebElement caseidStatus = newWizard.findElement(By.xpath("//tr[contains(@id,'$PD_RecentWork$')]/td[1]/descendant::a[contains(text(),'"+caseidtext+"')]/../../../../td[4]/descendant::Span[contains(.,'Resolved')][1]"));
			String status=caseidStatus.getText(); 
			System.out.println(status); 
			status=status.replaceAll(" ", ""); 
			System.out.println(status);
			return status;
		}
	 */


	@Override
	public void searchPreviousCaseId(String caseID) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		PegaWebElement collapseIcon = newWizard.findElement(By.xpath("//div[@title='Disclose Advanced search']"));
		collapseIcon.click();
		PegaWebElement prevCaseID = pegaDriver.findElement(By.id("SearchStringWorkID"));
		prevCaseID.sendKeys(CaseID);
		PegaWebElement search = pegaDriver.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();
	}

	@Override
	public void searchWithPreviousCaseId() {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		System.out.println(CaseID);
		System.out.println(String.valueOf(CaseID));

		PegaWebElement collapseIcon = newWizard.findElement(By.xpath("//div[@title='Disclose Advanced search']"));
		collapseIcon.click();
		PegaWebElement prevCaseID = pegaDriver.findElement(By.id("SearchStringWorkID"));
		prevCaseID.sendKeys(String.valueOf(CaseID));
		PegaWebElement search = pegaDriver.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();
	}

	@Override
	public String getFutureDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String newDate = format.format(cal.getTime());
		return newDate;
	}

	@Override
	public String getPastDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -10);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String newDate = format.format(cal.getTime());
		return newDate;
	}

	@Override
	public void datePicker() {
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement datePicker = pegaDriver.findElement(By.xpath("//input[@name='$PpyWorkPage$pCloseDate' or @name='$POpportunityPage$pCloseDate']"));
		datePicker.clear();
		datePicker.sendKeys("10/10/2022");
		/*PegaWebElement datePicker = pegaDriver.findElement(By.xpath("//input[@name='$PpyWorkPage$pCloseDate' or @name='$POpportunityPage$pCloseDate']"));
		datePicker.click();

		pegaDriver.waitForDocStateReady(2);
		PegaWebElement selectDate = pegaDriver.findElement(By.xpath("//a[@id='todayLink']"));
		selectDate.click();*/
	}

	@Override
	public void updateContactProfile(String DOB, String Gender, String status) {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		//changed below xpath due to DOM changes from //img[@title='Edit account information']to //img[@title='Edit contact information'] @Madhuri
		PegaWebElement editContact = pegaDriver.findElement(By.xpath("//a[@alt='Edit contact information']"));
		editContact.click();
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement dateOfBirth = pegaDriver.findElement(By.xpath("//input[@data-test-id='201512290434570892563861']"));
		dateOfBirth.sendKeys(DOB);
		PegaWebElement MiddleNmae = pegaDriver.findElement(By.xpath("//input[@data-test-id='201512290417350719208807' and @title='Middle Name']"));
		MiddleNmae.sendKeys("MN");
		
		DropDown gender = pegaDriver.findSelectBox(By.xpath("//select[@data-test-id='201512290710340197170376']"));
		gender.selectByValue(Gender);
		DropDown maritalStatus = pegaDriver.findSelectBox(By.xpath("//select[@data-test-id='20151229071034019817179']"));
		maritalStatus.selectByValue(status);
		PegaWebElement submit = pegaDriver.findElement(By.id("ModalButtonSubmit"));
		submit.click();
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
		//old Id "PrimaryAddress"
		PegaWebElement checkBox = pegaDriver.findElement(By.xpath("//input[@title='Check if primary']"));
		checkBox.click();
		pegaDriver.waitForDocStateReady(2);
		// DropDown addressType =
		// pegaDriver.findSelectBox(By.xpath("//select[@id='AddressType']"));
		// addressType.selectByValue("BUS");
		PegaWebElement changeAddress1 = pegaDriver.findElement(By.xpath(ADDRESS_LINE1_XPATH));
		changeAddress1.sendKeys("123");
		PegaWebElement changeAddress = pegaDriver.findElement(By.xpath(ADDRESS_LINE2_XPATH));
		changeAddress.sendKeys("New Street");
		DropDown CountryCode = pegaDriver.findSelectBox(By.xpath(COUNTRY_CODE_XPATH));
		CountryCode.selectByValue("USA");// AUS
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement city = pegaDriver.findElement(By.xpath(CITY_XPATH));
		city.sendKeys("Alabama");// Sydney
		// PegaWebElement state =
		// pegaDriver.findElement(By.xpath("//input[@id='StateCode']"));
		// state.sendKeys("New South Wales ");
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
	public void openNewAccountFlow(String category, String product, String owner) {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown productCategory = newWizard.findSelectBox(By.xpath("//select[@id='ProductType']"));
		productCategory.selectByValue(category);
		pegaDriver.waitForDocStateReady(2);
		/*
		 * DropDown productType =
		 * pegaDriver.findSelectBox(By.xpath("//select[@id='Product']"));
		 * productType.mouseOver(); pegaDriver.waitForDocStateReady(2);
		 */ pegaDriver.switchToActiveFrame();
		 if (owner.equalsIgnoreCase("Customer")) {
			 // PegaWebElement customerButton =
			 // newWizard.findElement(By.xpath("//input[@id='OwnerTypeCustomer'
			 // and @value='Customer']"));
			 PegaWebElement customerButton = newWizard.findElement(By.xpath("//label[contains(text(),'Customer')]"));
			 customerButton.click();
			 pegaDriver.waitForDocStateReady(2);
		 } else {
			 PegaWebElement customerButton = newWizard
					 .findElement(By.xpath("//input[@id='OwnerTypeContact' and @value='Contact']"));
			 customerButton.click(false);
			 pegaDriver.waitForDocStateReady(2);
		 }
		 try {
			 Thread.sleep(5000);
			 frameId = pegaDriver.getActiveFrameId(false);
			 newWizard = pegaDriver.findWizard(frameId);
			 DropDown productType = newWizard.findSelectBox(By.name("$PpyWorkPage$pProduct"));
			 testEnv.getScriptExecutor().mouseOver(productType);
			 productType.selectByVisibleText("Demand deposit account");
			 DropDown productType1 = newWizard.findSelectBox(By.name("$PpyWorkPage$pProduct"));
			 productType1.selectByVisibleText("Demand deposit account");
		 } catch (Exception e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 frameId = pegaDriver.getActiveFrameId(false);
			 newWizard = pegaDriver.findWizard(frameId);
			 DropDown productType = newWizard.findSelectBox(By.name("$PpyWorkPage$pProduct"));
			 testEnv.getScriptExecutor().mouseOver(productType);
			 productType.selectByVisibleText("Demand deposit account");
			 DropDown productType1 = newWizard.findSelectBox(By.name("$PpyWorkPage$pProduct"));
			 productType1.selectByVisibleText("Demand deposit account");
		 }
		 PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		 submitButton.click(false);

		 pegaDriver.switchToActiveFrame();
		 PegaWebElement secans = pegaDriver.findElement(By.xpath("//input[@id='SecurityAnswer']"));
		 secans.sendKeys("test");

	}

	@Override
	public void sendCorrespondanceFlow(String mailID, String subject) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		PegaWebElement toField = newWizard.findElement(By.xpath("//input[@title='Add To Recipients']"));
		toField.sendKeys(mailID);

		PegaWebElement mailSubject = newWizard.findElement(By.id("corrSubject"));
		mailSubject.sendKeys(subject);

		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement submitButton = newWizard.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Send']"));
		submitButton.click(false);

	}

	@Override
	public void completeWrapUpbyRating(int arg1) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		int argValue = arg1 + 1;
		String arg2 = Integer.toString(argValue);

		String rating_XPATH = "//a[contains(@title,'#rating#')]";
		String final_rating_XPath = new String(rating_XPATH).replace("#rating#", arg2);

		PegaWebElement overview = pegaDriver.findElement(By.xpath(final_rating_XPath));
		overview.click();

		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		pegaDriver.switchToActiveFrame();

	}

	@Override
	public void completeWrapUpbyreason(String reason) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		DropDown disposition = newWizard.findSelectBox(By.xpath("//select[@id='ReasonForInteraction']"));
		disposition.selectByValue(reason);

		PegaWebElement comment = pegaDriver.findElement(By.id("WrapUpComments"));
		comment.sendKeys("this is a Sample text entered in comment section");

		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		pegaDriver.switchToActiveFrame();

	}

	@Override
	public void verifyRecentInteractions() {

		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

		System.out.println(CaseID);
		System.out.println(String.valueOf(CaseID));

		String SERVICE_PROCESS_XPATH = "//div[contains(@class,' remove-top-spacing remove-bottom-spacing   dataValueRead flex flex-row ')]//span[text()='#IdofCase#']";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#IdofCase#", CaseID);

		pegaDriver.waitForDocStateReady(1);
		Assert.assertTrue("case ID is not present", pegaDriver.verifyElement(By.xpath(finalXPath)));

	}

	@Override
	public void verifyRecentCases() {

		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

		System.out.println(CaseID);
		System.out.println(String.valueOf(CaseID));

		// String SERVICE_PROCESS_XPATH = "//div[contains(@class,'content-item
		// content-field item-2 remove-top-spacing remove-bottom-spacing
		// dataValueRead flex flex-row
		// ')]/span[text()='#IdofCase#']";//div[contains(@class,'dataValueRead')]/span[text()='#IdofCase#']
		//String SERVICE_PROCESS_XPATH = "//div[contains(@class,' remove-top-spacing remove-bottom-spacing   dataValueRead flex flex-row ')]//span[text()='#IdofCase#']";
		String SERVICE_PROCESS_XPATH = "//span[contains(@class,'smartInfoNew') and text()='#IdofCase#']";
		//Commented below xpath as it is failing the script
		//String SERVICE_PROCESS_XPATH = "//span[@data-test-id='20150508042955037293496']/span[text()='#IdofCase#']";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#IdofCase#", CaseID);
		pegaDriver.waitForDocStateReady(3);
		Assert.assertTrue("case ID is not present", pegaDriver.verifyElement(By.xpath(finalXPath)));

	}
	@Override
	public void clickOtherActionsandByPassVerification() {

		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

		String otherActions = "//button[@title='Other actions']";
		PegaWebElement otherActionsButton= pegaDriver.findElement(By.xpath(otherActions));
		otherActionsButton.click();
		//Commented below xpath as it is failing the script
		//String SERVICE_PROCESS_XPATH = "//span[@data-test-id='20150508042955037293496']/span[text()='#IdofCase#']";
		pegaDriver.waitForDocStateReady(3);

		String byPass = "//span[text()='Bypass verification']";
		PegaWebElement byPassVerification= pegaDriver.findElement(By.xpath(byPass));
		byPassVerification.click(false);

	}



	@Override
	public void searchforRecentCasesinWidget() {

		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(2);
		System.out.println(CaseID);
		System.out.println(String.valueOf(CaseID));
		PegaWebElement searchBox = pegaDriver.findElement(By.xpath("//input[@id='SearchCaseText']"));
		searchBox.sendKeys(CaseID);
		Actions action = new Actions(pegaDriver.getDriver());

		// action.sendKeys(searchBox, Keys.ENTER).build().perform();;

		action.sendKeys(Keys.ENTER).build().perform();

		// PegaWebElement searchIcon =
		// pegaDriver.findElement(By.xpath("//i[contains(@class,'icons pi
		// pi-search-2')]"));

		// searchIcon.click();

	}

	@Override
	public void filterinRecentCasesWidget(String status) {

		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(2);

		PegaWebElement filterIcon = pegaDriver.findElement(By.xpath("//i[@title='Filter']"));
		filterIcon.click();

		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		PegaWebElement statusType = pegaDriver
				.findElement(By.xpath("//input[contains(@name,'Show"+status+"Cases') and @type='checkbox']/following-sibling::label"));
		statusType.click();
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
	public void selectAddTask() {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement serviceCase = newWizard.findElement(By.xpath(SERVICECASE_ADDTASK_BUTTON));
		serviceCase.click();

	}

	@Override
	public void searchForServiceProcess(String serviceName) {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement searchInteraction = newWizard.findElement(By.xpath("//input[@id='CPMTaskSearchInput']"));
		searchInteraction.sendKeys(serviceName);

		/*PegaWebElement searchIcon = pegaDriver.findElement(By.xpath("//img[@title='Search for Service Process ']"));
		searchIcon.click();*/

	}

	@Override
	public void clickOnSearchResult(String searchResult) {

		String SERVICE_PROCESS_XPATH = "//div[@class='field-item dataValueWrite']/span/a[contains(text(),'#sericecase#')]";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#sericecase#", searchResult);

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement selectService = newWizard.findElement(By.xpath(finalXPath));
		selectService.click();

	}

	@Override
	public void clickOnCollapseIcon() {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement collapseIcon = newWizard.findElement(By.xpath("//i[@title='Collpase driver ']"));
		collapseIcon.click();

	}

	@Override
	public void AddtaskFromCollapse() {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement addTaskButton = pegaDriver.findElement(By.xpath(ADD_TASK_COLLAPSE_XPATH));
		addTaskButton.click();

	}

	@Override
	public void launchWrapupFromCollapse() {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement wrapUp = newWizard.findElement(By.xpath(WRAP_UP_COLLAPSE_XPATH));
		wrapUp.click();
	}

	@Override
	public void selectIncludeprospects() {

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		PegaWebElement prospects = newWizard.findElement(By.xpath(INCLUDE_PROSPECTS_XPATH));
		prospects.click();
	}

	@Override
	public void selectresultfromprospects(String username) {

		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		String final_XPath = new String(PROSPECTS_USER_XPATH).replace("#Username#", username);

		PegaWebElement accountResult = pegaDriver.findElement(By.xpath(final_XPath));
		accountResult.click();
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement submit = pegaDriver.findElement(By.xpath(CONTACT_RESULT_SUBMIT_XPATH));
		submit.click();
	}

	@Override
	public void deleteAccountAssociation(String OrgName) {

		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		String initial_XPATH = "//span[text()='#sericecase#']";
		String final_XPath = new String(initial_XPATH).replace("#sericecase#", OrgName);

		String Delete_org_initial_XPATH = "//div/span[contains(text(),'#sericecase#')]/../../following-sibling::td/div/span/a[@title='Delete this row ']";
		String Delete_org_final_XPath = new String(Delete_org_initial_XPATH).replace("#sericecase#", OrgName);

		if (pegaDriver.findElement(By.xpath(final_XPath)).isDisplayed()) {

			PegaWebElement deleteOrganization = pegaDriver.findElement(By.xpath(Delete_org_final_XPath));
			deleteOrganization.click();
		}
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
	public void selectaccountfromaccountSummary(String AcNo) {
		String SERVICE_PROCESS_XPATH = "//div[@class='oflowDivM ']/span/a[text()='#sericecase#']";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#sericecase#", AcNo);

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement selectService = newWizard.findElement(By.xpath(finalXPath));
		selectService.click();
	}

	@Override
	public void clickAccountNumber() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		newWizard.findElement(By.xpath("//i[@class='pi pi-caret-down pi-link']")).click();
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
	public void selectMultiDisputeTranxFromCasesWidget() {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

		System.out.println(CaseID);
		System.out.println(String.valueOf(CaseID));

		String SERVICE_PROCESS_XPATH = "//span[contains(text(),'#IdofCase#')]/ancestor::div[1]/preceding-sibling::div[2]/span/a[contains(text(),'Dispute Transaction')]";
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

	@Override
	public void selectIdentificationType(String method) {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(3);

		DropDown verificationType = newWizard.findSelectBox(By.xpath("//select[@data-test-id='2016012806535805407982']"));
		verificationType.selectByValue(method);

		PegaWebElement submitButton = pegaDriver.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
	}

	@Override
	public void selectDistributionType(String method) {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(3);

		DropDown verificationType = newWizard.findSelectBox(By.id("CorrType"));
		verificationType.selectByValue(method);

		PegaWebElement submitButton = pegaDriver.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();
		pegaDriver.waitForDocStateReady(2);
	}

	@Override
	public void selectViewDetails() {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

		System.out.println(CaseID);
		System.out.println(String.valueOf(CaseID));

		String SERVICE_PROCESS_XPATH = "//tr[contains(@oaargs,'PEGACA-WORK #IdofCase#')]//..//span/i[@title='View Details ']";
		String finalXPath = new String(SERVICE_PROCESS_XPATH).replace("#IdofCase#", CaseID);

		PegaWebElement viewDetails = pegaDriver.findElement(By.xpath(finalXPath));
		viewDetails.click();

	}

	@Override
	public void enterResolveNotesandSubmit() {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(3);

		PegaWebElement comments = pegaDriver.findElement(By.xpath("//textarea[@id='ResolveNotes']"));
		comments.sendKeys("This case is approved");

		PegaWebElement submitButton = pegaDriver.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}

	@Override
	public void clickOnCasesButton() {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(3);

		PegaWebElement caseButton = pegaDriver.findElement(By.xpath("//button[@title='View Cases']"));
		caseButton.click();

	}

	@Override
	public void selectResolutionTypeforComplaint(String resolutionType) {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(3);

		PegaWebElement comments = pegaDriver.findElement(By.xpath("//textarea[@id='ResolveNotes']"));
		comments.sendKeys("Approved. Hence Resolving the case.");

		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(1);

		DropDown resolution = pegaDriver.findSelectBox(By.id("ActionTaken"));
		resolution.selectByValue(resolutionType);

	}

	@Override
	public void selectWorkResolutionforScheduleActivity(String workResolution) {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(3);

		PegaWebElement resolutionButton = pegaDriver.findElement(By.xpath("//label[contains(text(),'" + workResolution + "')]"));
		resolutionButton.click();

		/*
		 * PegaWebElement resolutiontext=
		 * pegaDriver.findElement(By.xpath("//textarea[@id='"+workResolution+
		 * "Notes']")); resolutiontext.sendKeys("Resolving the issue");
		 * pegaDriver.switchToActiveFrame(); pegaDriver.waitForDocStateReady(3);
		 */

	}

	public String getTomorrowDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String newDate = format.format(cal.getTime());
		return newDate;
	}

	@Override
	public void scheduleActivityAppointment(String type, String account, String topic, String assign, String operator) {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
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
		pegaDriver.waitForDocStateReady(2);
		DropDown PhNum = newWizard.findSelectBox(By.id("TelephoneNumber"));
		PhNum.selectByValue("Other");
		pegaDriver.waitForDocStateReady(1);
		newWizard.findElement(By.xpath("//input[@id='OtherPhone']")).sendKeys("7458236951");

		DropDown opName = newWizard.findSelectBox(By.id("Operator"));
		opName.selectByValue(operator);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		pegaDriver.waitForDocStateReady(2);

	}

	@Override
	public void scheduleAppointment(String subject) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		PegaWebElement subField = pegaDriver.findElement(By.xpath("//input[@id='Name']"));
		subField.sendKeys(subject);
		PegaWebElement date = pegaDriver.findElement(By.id("pyStartDateTime"));
		date.sendKeys(getTomorrowDate());
		PegaWebElement submitButton = pegaDriver.findElement(By.xpath(BUTTON_OK_XPATH));
		submitButton.click(false);
		pegaDriver.waitForDocStateReady(2);

	}

	@Override
	public void confirmAppointment() {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		PegaWebElement submitButton = pegaDriver.findElement(By.xpath(CONFIRM_APPOINTMENT_BUTTON_XPATH));
		submitButton.click(false);

	}

	@Override
	public void scheduleActivityEscalate(String assign, String operator) {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown schedule = newWizard.findSelectBox(By.id("ScheduleFor"));
		schedule.selectByValue(assign);

		if (assign.equalsIgnoreCase("Operator")) {
			pegaDriver.waitForDocStateReady(1);
			DropDown opName = newWizard.findSelectBox(By.id("Operator"));
			opName.selectByValue(operator);
		}

		else if (assign.equalsIgnoreCase("WorkBasket")) {
			pegaDriver.waitForDocStateReady(1);
			DropDown opName = newWizard.findSelectBox(By.id("WorkBasket"));
			opName.selectByValue(operator);
		}

	}

	@Override
	public void addbundle() {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(3);

		PegaWebElement addBundle = pegaDriver
				.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Add a bundle']"));
		addBundle.click(false);
	}

	@Override
	public void clickOnActionButton(String bundleName) {
		String Initial_Xpath = "//div/h2[contains(text(),'#salescase#')]/../span/nobr/span/a[contains(text(),'Actions ')]";
		String finalXPath = new String(Initial_Xpath).replace("#salescase#", bundleName);

		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(2);
		PegaWebElement actionButton = pegaDriver.findElement(By.xpath(finalXPath));
		actionButton.click(false);
	}

	@Override
	public void selectOptionsUnderActionButton(String option, String bundleName) {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(2);

		String Initial_Xpath = "//div/h2[contains(text(),'#salescase#')]/../span/nobr/span/a[contains(text(),'Actions ')]";
		String finalXPath = new String(Initial_Xpath).replace("#salescase#", bundleName);

		PegaWebElement actionButton = pegaDriver.findElement(By.xpath(finalXPath));
		actionButton.click(false);

		String Initial_option__Xpath = "//span[text()='#salescase#']";
		String final_option_XPath = new String(Initial_option__Xpath).replace("#salescase#", option);

		PegaWebElement optionButton = pegaDriver.findElement(By.xpath(final_option_XPath));
		optionButton.click();
	}

	@Override
	public void selectbundlefromDuplicate(String mergeType, String bundleName) {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(2);

		String Initial_Xpath = "//label[@for='BundleOperation#salescase#']";
		String finalXPath = new String(Initial_Xpath).replace("#salescase#", mergeType);

		PegaWebElement duplicateAction = pegaDriver.findElement(By.xpath(finalXPath));
		duplicateAction.click(false);

		if (bundleName.equalsIgnoreCase("Sara")) {
			PegaWebElement bundle1 = pegaDriver.findElement(By.xpath("//input[@id='pySelected1']"));
			bundle1.click(false);
		}

		else if (bundleName.equalsIgnoreCase("John")) {
			PegaWebElement bundle1 = pegaDriver.findElement(By.xpath("//input[@id='pySelected2']"));
			bundle1.click(false);
		}

		PegaWebElement submitButton = pegaDriver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		submitButton.click();

	}

	@Override
	public void launchCaseUnderMyWorkbasket(String workBasket) {

		System.out.println(CaseID);

		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement workBasketTab = newWizard.findElement(By.xpath(WORKBASKET_LINK_XPATH));
		workBasketTab.click();
		DropDown workBasketSelect = newWizard.findSelectBox(By.xpath(WORKBASKET_XPATH));
		workBasketSelect.selectByValue(workBasket);
		String finalXpath = new String(WORKBASKET_CASE_XPATH).replace("#id#", CaseID);
		PegaWebElement launchCaseID = newWizard.findElement(By.xpath(finalXpath));
		System.out.println(finalXpath);
		launchCaseID.scrollIntoView();
		pegaDriver.waitForDocStateReady(5);
		launchCaseID.click();

	}

	@Override
	public void enterComments() {
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(3);

		PegaWebElement comments = pegaDriver.findElement(By.xpath("//textarea[@id='ResolveNotes']"));
		comments.sendKeys("This case is resolved");

		pegaDriver.switchToActiveFrame();

	}

	@Override
	public void negotiateRetentionFlow(String reason, String provider, String rating) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		DropDown ReasonforLeaving = pegaDriver.findSelectBox(By.id("ReasonForCanceling"));
		ReasonforLeaving.selectByValue(reason);

		DropDown ServiceProvider = pegaDriver.findSelectBox(By.id("MovingTo"));
		ServiceProvider.selectByValue(provider);

		DropDown OverallRating = pegaDriver.findSelectBox(By.id("Rating"));
		OverallRating.selectByValue(rating);

	}

	@Override
	public void recentCasesSearchWithCaseID(String tabName) {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();

		System.out.println(CaseID);

		List<WebElement> search = pegaDriver.findElements(By.xpath("//input[@id='SearchCaseText']"));

		if (tabName.equalsIgnoreCase("Account")) {
			search.get(0).sendKeys(CaseID);
			search.get(0).sendKeys(Keys.ENTER);

		}

		else if (tabName.equalsIgnoreCase("Organization") || tabName.equalsIgnoreCase("Overview")) {
			search.get(1).sendKeys(CaseID);
			search.get(1).sendKeys(Keys.ENTER);

		}

	}

	@Override
	public void customerInquiry() {

		pegaDriver.switchToActiveFrame();
		PegaWebElement enquiry = pegaDriver.findElement(By.xpath("//div[@class='can-toggle__switch']"));
		enquiry.click();
		pegaDriver.waitForDocStateReady(3);

	}

	@Override
	public void selectrequiredBU(String required) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement buunit = newWizard.findElement(By.xpath("//span[contains(text(),'" + required + "')]/../../.."));
		buunit.click();
		PegaWebElement submit = newWizard.findElement(By.xpath("//button[contains(.,'Submit')]"));
		submit.click();
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

	@Override
	public void switchBetweenNewPhoneCallTabs(String tabName) {
		pegaDriver.waitForDocStateReady(3);
		String tabXPATH = "//h6[@class='layout-group-item-title'][text()='#sericecase#']";
		String final_tabXPATH = new String(tabXPATH).replace("#sericecase#", tabName);
		PegaWebElement tabToMove =  pegaDriver.findElement(By.xpath(final_tabXPATH));
		tabToMove.click();
	}

	@Override
	public void enterAnonymousFieldsAndSubmit(String type, String FirsTname, String LastName, String emailId) {
		Random rand = new Random();
		int r= rand.nextInt(1000)+1;
		String s = String.valueOf(r);
		String initialmail = emailId+"#number#@mail.com";
		String finalmail = new String(initialmail).replace("#number#", s);

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		DropDown prefix =newWizard.findSelectBox(By.xpath(NEW_CONTACT_PREFIX_XPATH));
		prefix.selectByValue("Mr.");
		PegaWebElement FirsTName = newWizard.findElement(By.xpath(NEW_CONTACT_FIRST_NAME_XPATH));
		FirsTName.sendKeys(FirsTname);
		PegaWebElement lastName = newWizard.findElement(By.xpath(NEW_CONTACT_LAST_NAME_XPATH));
		lastName.sendKeys(LastName);
		PegaWebElement homeEmail = newWizard.findElement(By.xpath(NEW_CONTACT_PRIMARY_MAIL_ID_XPATH));
		homeEmail.sendKeys(finalmail);
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click();

	}
	@Override
	public void reopenCase()
	{	
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		String clickCase="//a[@title='Open Work Object "+CaseID+"']";
		PegaWebElement clickCaseButton = pegaDriver.findElement(By.xpath(clickCase));
		clickCaseButton.click(false);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();
		String toolsMenu = "//i[@class='pi pi-more pi-blue pi-medium']";
		PegaWebElement toolsMenuButton = pegaDriver.findElement(By.xpath(toolsMenu));
		toolsMenuButton.click(false);
		pegaDriver.switchToActiveFrame();
		String reOpen= "//span[contains(text(),'Reopen')]";
		PegaWebElement reOpenButton =  pegaDriver.findElement(By.xpath(reOpen));
		reOpenButton.click(false);
	}


	@Override
	public void updateID(String source, String id) {

		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();

		pegaDriver.findElement(By.xpath("//a[@data-test-id='2017122805434102749ef719cc-3b2f-4ef2-8a99-00b9cb7548ee301']")).click();
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchToActiveFrame();

		String idXpath = "//input[@title='#source# ID']";
		String finalIDXpath = new String(idXpath).replace("#source#", source);
		pegaDriver.findElement(By.xpath(finalIDXpath)).clear();
		pegaDriver.findElement(By.xpath(finalIDXpath)).sendKeys(id);

		pegaDriver.findElement(By.xpath("//button[contains(.,'Submit')][@id='ModalButtonSubmit']")).click(false);

		pegaDriver.switchTo().defaultContent();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);

		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);

	}

	@Override
	public void createContactNote()
	{
		pegaDriver.switchTo().defaultContent();

		pegaDriver.findElement(By.xpath(CONTACTNOTE_XPATH)).click(false);

		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchTo().defaultContent();


	}
@Override
	public void completeAnonymouswrapup()
	{
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement yesButton = newWizard.findElement(By.xpath(YES_BUTTON_XPATH));
		yesButton.click(false);
	}

	@Override
	public void LaunchCaseFromMyCasesWidget() {

		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.findElement(By.xpath("//a[contains(@title,'Do you want to open the case?') and contains(text(),'"+CaseID+"')]")).click();

	}
	
	@Override
	public void LaunchCaseFromRecentWorkWidget() {

		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.findElement(By.xpath("//a[contains(@title,'Open Work Object') and contains(text(),'"+CaseID+"')]")).click();
		
	}
	
}
