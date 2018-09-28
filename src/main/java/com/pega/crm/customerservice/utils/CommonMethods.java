package customerservice.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;

public class CommonMethods {
	public PegaWebDriver pegaDriver;
	// Browser browser = null;
	protected WebDriver driver;
	public String frameId = null;
	public Wizard newWizard = null;

	public CommonMethods(PegaWebDriver webDriver) {
		// TODO Auto-generated constructor stub
		System.out.println("Value in Constructor : : : :" + webDriver);
		pegaDriver = webDriver;
		System.out.println("Value in Constructor : : : :" + pegaDriver);
	}

	public void launchChildInteraction(String text) {
		PegaWebElement ele = pegaDriver.findElement(
				By.xpath("//table[@id='bodyTbl_right' and @pl_prop_class='PegaCA-Interface-Contact']/tbody"));
		int rowcount = ele.findElements(By.tagName("tr")).size();
		pegaDriver.switchToActiveFrame();
		for (int i = 2; i <= rowcount; i++) {
			String act = pegaDriver.findElement(
					By.xpath("//table[@id='bodyTbl_right' and @pl_prop_class='PegaCA-Interface-Contact']/tbody/tr[" + i
							+ "]/td[2]"))
					.getText();
			if (text.equalsIgnoreCase(act)) {
				pegaDriver.findElement(
						By.xpath("//table[@id='bodyTbl_right' and @pl_prop_class='PegaCA-Interface-Contact']/tbody/tr["
								+ i + "]/td[5]/div/span/a"))
						.click();
				break;
			}
		}

	}

	public void verifyResult(String actualValue, String expectedValue) {

		System.out.println("The Actual Value is  : : : :" + actualValue);
		System.out.println("The Expected Value is : : : :" + expectedValue);
		if (actualValue.trim().equalsIgnoreCase(expectedValue.trim())) {

			System.out.println("Inside the If Condition");
			assert true;
		}

		else {
			System.out.println("The values are not equal");
			System.out.println("The Actual Value  ::: " + actualValue + " is not Equal to Expected Value ::: "
					+ expectedValue + ". Hence the Result is FALSE");
			assert false;
		}
	}

	public void verifyResult(boolean actualValue, boolean expectedValue) {

		if (actualValue == expectedValue) {

			System.out.println("Inside the If Condition");
			assert true;
		}

		else {
			System.out.println("The values are not equal");
			System.out.println("The Actual Value  ::: " + actualValue + " is not Equal to Expected Value ::: "
					+ expectedValue + ". Hence the Result is FALSE");
			assert false;
		}
	}

	public String getText(By element, PegaWebDriver pegaWebDriver) {
		String text = pegaWebDriver.findElement(element).getText();
		return text;
	}

	public String getTextForSpecificElement(By element, int indexNo, PegaWebDriver pegaWebDriver) {

		String text = pegaWebDriver.findElements(element).get(indexNo).getText();

		return text;
	}

	public void scrollToBottomofpage() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");
	}

	public Wizard switchToFrame() {
		frameId = pegaDriver.getActiveFrameId(false);
		Wizard newWizard = pegaDriver.findWizard(frameId);
		return newWizard;
	}

	public void setDates(String dt, By locator) {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement dateOfLastUse = newWizard.findElement(locator);
		dateOfLastUse.sendKeys(dt);

	}

	public Map<String, String> assertTopHeaderFields(String callerName) {

		// Switching the Context to the Default Content i.e Top Window
		System.out.println("The value for the driver inside the method is :  : : : :" + pegaDriver);
		pegaDriver.switchTo().defaultContent();

		Map<String, String> fieldHeaderAndValue = new HashMap<String, String>();

		// Validating Churn Risk
		String text = getText(
				By.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'Churn risk')]"),
				this.pegaDriver);
		verifyResult(text, "Churn risk");
		String textValue = getText(By.xpath("//span[@class='rounded_border_wine']"), this.pegaDriver);
		fieldHeaderAndValue.put(text, textValue);

		// Validating the CustomerValue Header
		text = getText(
				By.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'Lifetime value')]"),
				this.pegaDriver);
		verifyResult(text, "Lifetime value");
		textValue = getText(By.xpath("//span[@class='rounded_border_blue']"), pegaDriver);
		fieldHeaderAndValue.put(text, textValue);

		// Verifying Influence
		text = getText(By.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'Influence')]"),
				this.pegaDriver);
		verifyResult(text, "Influence");
		textValue = getTextForSpecificElement(By.xpath("//span[@class='rounded_border_grey']"), 0, this.pegaDriver);
		fieldHeaderAndValue.put(text, textValue);

		// Verifying Customer Since
		/*
		 * text = getText(By.xpath(
		 * "//div[@class='field-item dataLabelWrite instruction_dataLabelWrite' and text()='Customer Since']"
		 * ),this.pegaDriver); verifyResult(text,"Customer since"); textValue =
		 * getTextForSpecificElement(By.xpath(
		 * "//div[@class='field-item dataValueRead']/span"),0,this.pegaDriver);
		 * fieldHeaderAndValue.put(text, textValue);
		 */

		// Verifying Interaction Goal
		text = getText(
				By.xpath("//span[@class='field-caption dataLabelForRead' and contains(text(),'Interaction goal')]"),
				this.pegaDriver);
		verifyResult(text, "Interaction Goal");
		textValue = getTextForSpecificElement(By.xpath("//span[@class='rounded_border_grey']"), 1, this.pegaDriver);
		fieldHeaderAndValue.put(text, textValue);

		// Verifying the Caller Name
		text = getText(By.xpath("//span[@class='interaction_header_title' and contains(text(),'" + callerName + "')]"),
				this.pegaDriver);
		verifyResult(text, callerName);

		/*
		 * boolean result =
		 * pegaDriver.findElement(By.id("timerIcon")).isDisplayed();
		 * System.out.println("Value for the Result is : : : :"+result);
		 * verifyResult(result,true);
		 */

		// Verifying the Customer Status
		/*
		 * text = getText(By.xpath(
		 * "//*[@class='field-caption dataLabelForRead']/span[contains(text(),'Focus on the customer')]"
		 * ),this.pegaDriver); verifyResult(text,"Focus on the customer");
		 * fieldHeaderAndValue.put("CustomerStatus",text);
		 */

		// Returning the Control to the Current Frame
		this.pegaDriver.switchToActiveFrame();

		return fieldHeaderAndValue;
	}

	public String currentDateTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
		System.out.println(dateFormat.format(date.getTime()));
		return dateFormat.format(date.getTime()).toString();
	}

	public String getTextByAttribute(By locator, String attributeValue) {
		String textValue = pegaDriver.findElement(locator).getAttribute(attributeValue);
		System.out.println("The value received from the Attriute Value is : : : : " + textValue);
		return textValue;
	}



	public String getCurrentTime() {
		return (new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
	}

	
	
	public boolean verifyElementIsVisible(By locator, PegaWebDriver pegaWebDriver) {
		WebDriverWait driverWait = new WebDriverWait(pegaWebDriver, 10);
		boolean status = true;
		for (int i = 0; i < 5; i++) {
			System.out.println("Inside the For Loop : : : :" + i);
			driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
			if (i >= 5) {
				status = false;
				System.out.println("Value for the Status when verifying the Element : : : : " + pegaWebDriver);
				break;
			}
		}
		return status;
	}
	
	public boolean verifyVisibilityOfElement(By locator, PegaWebDriver pegaDriver) {
		System.out.println("Inside the visibility Method");
		boolean status;
		status = verifyElementIsVisible(locator, pegaDriver);
		return status;
	}
	
	
	public void waitUntillElementClickble(By locator,int time){
		WebDriverWait wait = new WebDriverWait(pegaDriver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	

	/*
	 * @sendTextToElement
	 * 
	 * @parameter : it will take one parameter of type By(element) and other
	 * parameter as String(text)
	 * 
	 * 
	 * @functionality :it enters the text in to text box that matched by given
	 * parameter value.
	 * 
	 */
	public void sendTextToElement(By element, String text) {

		pegaDriver.findElement(element).clear();

		pegaDriver.findElement(element).sendKeys(text);

	}

	/*
	 * @clearText
	 * 
	 * @parameter : it will take one parameter of type By
	 * 
	 * @functionality :it clears the text present in text box that matched by
	 * given parameter value.
	 * 
	 */

	public void clearText(By element) throws Exception {

		pegaDriver.findElement(element).clear();
	}

	/*
	 * @selectFromDropdownUsingValue
	 * 
	 * @parameter : it will take one parameter of type By(element) and other as
	 * String(value)
	 * 
	 * @functionality :it selects a value from dropdown that matched by given
	 * parameter value.
	 * 
	 */

	public void selectFromDropdownUsingValue(By element, String value) {

		DropDown DropDownList = pegaDriver.findSelectBox(element);
		DropDownList.selectByValue(value);

	}

	/*
	 * @selectFromDropdownUsingVisibleText
	 * 
	 * @parameter : it will take one parameter of type By(element) and other as
	 * String(text)
	 * 
	 * @functionality :it selects a value from dropdown that matched by given
	 * parameter value.
	 * 
	 */

	public void selectFromDropdownUsingVisibleText(By element, String text) {

		DropDown DropDownList = pegaDriver.findSelectBox(element);
		DropDownList.selectByVisibleText(text);

	}

	/*
	 * @selectFromDropdownUsingIndex
	 * 
	 * @parameter : it will take one parameter of type By(element) and other as
	 * integer(index)
	 * 
	 * @functionality :it selects a value from dropdown that matched by given
	 * parameter value.
	 * 
	 */

	public void selectFromDropdownUsingIndex(By element, int index) {

		DropDown DropDownList = pegaDriver.findSelectBox(element);
		DropDownList.selectByIndex(index);

	}

	/*
	 * @selectRadioButton
	 * 
	 * @parameter : it will take one parameter of type By(element)
	 * 
	 * @functionality :it selects the radio button that is matched by given
	 * parameter value.
	 * 
	 */

	public void selectRadioButton(By element) {

		PegaWebElement radioButton = pegaDriver.findElement(element);
		radioButton.click();

	}

	/* Selecting a checkbox by Verifying if it is already selected */
	public void selectCheckBox(By element) {

		if (!pegaDriver.findElement(element).isSelected()) {
			PegaWebElement checkbox = pegaDriver.findElement(element);
			checkbox.click();
		}
	}

	/* Un Selecting a checkbox by Verifying if it is already selected */
	public void unSelectCheckBox(By element) {
		boolean checkstatus;
		checkstatus = pegaDriver.findElement(element).isSelected();
		if (checkstatus == true) {
			PegaWebElement checkbox = pegaDriver.findElement(element);
			checkbox.click();
		}
	}


}
