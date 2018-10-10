package salesautomation.workobjects.impl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;
import salesautomation.workobjects.Operators;
import com.pega.util.XPathUtil;

public class PegaOperator extends WizardImpl implements Operators {

	By OPR_TEMPLATE_CHECKBOX = By.xpath("//*[@data-test-id='2015061908552707501789-Label']");
	By OPR_DEFAULT_ACCESS_CHECKBOX = By.xpath("//*[@data-test-id='2015061908551804351701603-Label']");
	public String OPR_NEXT_BUTTON = XPathUtil.getButtonPzBtnMidXPath("Next >>");
	public String OPR_NEXT_BUTTON_XPATH = "//button[@title='Complete this assignment']";
	public String OPR_FINISH_BUTTON = XPathUtil.getButtonPzBtnMidXPath("Finish");

	By OPERATORID_FIELD = By.xpath("//*[@data-test-id='2015061907451201505764']");
	By OPR_PWD_BUTTON = By.xpath("//*[@data-test-id='2015061907451201516753']");
	By OPR_PASSWORD = By.xpath("//*[@data-test-id='2016060907461503301103']");
	By OPR_CONFIRMPASSWORD = By.xpath("//*[@data-test-id='2016060907461503322518']");
	By OPR_FIRST_NAME = By.xpath("//*[@data-test-id='2015061907451201538216']");
	By OPR_LAST_NAME = By.xpath("//*[@data-test-id='201506190745120154953']");
	// By OPR_FULL_NAME = By.xpath("//*[@
	By OPR_POSTITION = By.xpath("//*[@data-test-id='20150619074512015511949']");
	By OPR_TELEPHONE = By.xpath("//*[@data-test-id='20150619074512015612288']");
	By OPR_EMAILADDRESS = By.xpath("//*[@data-test-id='20150619074512015713552']");
	String OPR_TIMEZONE = "pyDefaultTimeZone";
	By OPR_REPORTSTO = By.xpath("//*[@data-test-id='2015061907453203301225']");
	String OPR_TITLE = "pyTitle";
	String OPR_TYPE = "pyAccessGroup";
	String OPR_TERRITORY = "TerritoryID";
	//

	// Actions actionsDriver = new Actions();

	public PegaOperator(WebElement elmt, String elmtId) {
		super(elmt, elmtId);

	}

	@Override
	public void setOperatorID(String str) {

		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		PegaOperator Opr = new PegaOperator(frameElmt, frameId);
		Opr._setEnvironment(testEnv, frameId);
		Opr.findElement(OPERATORID_FIELD).click();
		Opr.findElement(OPERATORID_FIELD).sendKeys(str);

	}

	@Override
	public void setPassword(String str) {

		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Operators Opr = new PegaOperator(frameElmt, frameId);
		Opr._setEnvironment(testEnv, frameId);
		Opr.findElement(OPR_PWD_BUTTON).click();

		frameId = pegaDriver.getActiveFrameId(false);
		frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Opr = new PegaOperator(frameElmt, frameId);
		Opr._setEnvironment(testEnv, frameId);

		PegaWebElement pwe = Opr.findElement(By.xpath("//div[@id='modalContent']//input[@id='pyPwdNew']"));

		// pwe.findElement(By.id(OPR_PASSWORD)).click();
		// pwe.findElement(By.id(OPR_PASSWORD)).sendKeys(str);

		pwe.click();
		pwe.sendKeys(str);
		pwe = Opr.findElement(By.xpath("//div[@id='modalContent']//input[@id='pyPwdConfirmText']"));

		pwe.click();
		pwe.sendKeys(str);
		// pwe.findElement(By.id(OPR_CONFIRMPASSWORD)).click();
		// pwe.findElement(By.id(OPR_CONFIRMPASSWORD)).sendKeys(str);

		pwe = Opr.findElement(By.xpath("//div[@id='modalContent']//button[@id='ModalButtonSubmit']"));
		pwe.click();
		// pegaDriver.findElement(By.id("ModalButtonSubmit")).click();
	}

	@Override
	public void setTitle(String str) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Operators Opr = new PegaOperator(frameElmt, frameId);
		Opr._setEnvironment(testEnv, frameId);
		Opr.findElement(By.id(OPR_TITLE)).click();
		Opr.findElement(By.id(OPR_TITLE)).sendKeys(str);

	}

	@Override
	public void setFirstName(String str) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Operators Opr = new PegaOperator(frameElmt, frameId);
		Opr._setEnvironment(testEnv, frameId);
		Opr.findElement(OPR_FIRST_NAME).click();
		Opr.findElement(OPR_FIRST_NAME).sendKeys(str);

	}

	@Override
	public void setLastName(String str) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Operators Opr = new PegaOperator(frameElmt, frameId);
		Opr._setEnvironment(testEnv, frameId);
		Opr.findElement(OPR_LAST_NAME).click();
		Opr.findElement(OPR_LAST_NAME).sendKeys(str);

	}

	@Override
	public void setFullName(String str) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Operators Opr = new PegaOperator(frameElmt, frameId);
		Opr._setEnvironment(testEnv, frameId);
		// Opr.findElement(OPR_FULL_NAME).click();
		// Opr.findElement(OPR_FULL_NAME).sendKeys(str);

	}

	@Override
	public void setPostition(String str) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Operators Opr = new PegaOperator(frameElmt, frameId);
		Opr._setEnvironment(testEnv, frameId);
		Opr.findElement(OPR_POSTITION).click();
		Opr.findElement(OPR_POSTITION).sendKeys(str);

	}

	@Override
	public void setPhone(String str) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Operators Opr = new PegaOperator(frameElmt, frameId);
		Opr._setEnvironment(testEnv, frameId);
		Opr.findElement(OPR_TELEPHONE).click();
		Opr.findElement(OPR_TELEPHONE).sendKeys(str);

	}

	@Override
	public void setEmail(String str) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Operators Opr = new PegaOperator(frameElmt, frameId);
		Opr._setEnvironment(testEnv, frameId);
		Opr.findElement(OPR_EMAILADDRESS).click();
		Opr.findElement(OPR_EMAILADDRESS).sendKeys(str);

	}

	@Override
	public void setTimeZone(String str) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Operators Opr = new PegaOperator(frameElmt, frameId);
		Opr._setEnvironment(testEnv, frameId);
		Opr.findSelectBox(By.id(OPR_TIMEZONE)).selectByValue(str);

	}

	@Override
	public void setReportTo(String str) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Operators Opr = new PegaOperator(frameElmt, frameId);
		Opr._setEnvironment(testEnv, frameId);
		Opr.findElement(OPR_REPORTSTO).click();
		Opr.findElement(OPR_REPORTSTO).sendKeys(str);
		Opr.findElement(OPR_REPORTSTO).sendKeys(Keys.DOWN);
		Opr.findElement(OPR_REPORTSTO).sendKeys(Keys.DOWN);
		Opr.findElement(OPR_REPORTSTO).sendKeys(Keys.ENTER);

	}

	@Override
	public void setOperatorType(String str) {

		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.id("pyAccessGroup")).selectByVisibleText(str);
	}

	@Override
	public void setTerritory(String str) {

		PegaUtil.autoComplete(pegaDriver, "TerritoryID", str);

	}

	@Override
	public Operators navigateOperator() {
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Operators Opr = new PegaOperator(framElmt, frameId);
		Opr._setEnvironment(testEnv, frameId);
		return Opr;
	}

	@Override
	public String getOperatorId() {

		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.findElement(By.xpath("//label[@for='pyUserIdentifier']/following-sibling::Div/span"))
				.getAttribute("text");
	}

	@Override
	public String getTitle() {

		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.findElement(By.xpath("//label[@for='pyTitle']/following-sibling::Div/span"))
				.getAttribute("text");
	}

	@Override
	public String getFirstName() {

		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.findElement(By.xpath("//label[@for='pyFirstName']/following-sibling::Div/span"))
				.getAttribute("text");

	}

	@Override
	public String getLastName() {

		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.findElement(By.xpath("//label[@for='pyLastName']/following-sibling::Div/span"))
				.getAttribute("text");
	}

	@Override
	public String getFullName() {

		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.findElement(By.xpath("//*[text()='Full Name']/../../div/span")).getAttribute("text");
	}

	@Override
	public String getPostition() {

		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.findElement(By.xpath("//label[@for='pyPosition']/following-sibling::Div/span"))
				.getAttribute("text");
	}

	@Override
	public String getPhone() {

		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.findElement(By.xpath("//label[@for='pyTelephone']/following-sibling::Div/span"))
				.getAttribute("text");
	}

	@Override
	public String getEmail() {

		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.findElement(By.xpath("//label[@for='pyEmailAddress']/following-sibling::Div/span"))
				.getAttribute("text");
	}

	@Override
	public String getTimeZone() {

		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.findElement(By.xpath("//label[@for='pyDefaultTimeZone']/following-sibling::Div"))
				.getAttribute("text");
	}

	@Override
	public String getReportsTo() {

		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.findElement(By.xpath("//label[@for='pyReportTo']/following-sibling::Div"))
				.getAttribute("text");
	}

	@Override
	public String getOperatorType() {
		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.findElement(By.xpath("//label[@for='pyAccessGroup']/following-sibling::Div/span"))
				.getAttribute("text");
	}

	@Override
	public String getTerritory() {
		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.findElement(By.xpath("//label[contains(text(),'Territory')]/following-sibling::Div"))
				.getAttribute("text");

	}

	@Override
	public void defaultSalesRepAccess() {

		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);

		// Verify for Organization Read Permissions at Territory and Child level
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID1']//table[@class='gridTable ']//td[@headers='a2']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID1']//table[@class='gridTable ']//td[@headers='a6']//img[@alt='Checked']"));

		// Verify for Account Read Permission at territory and Child level
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID2']//table[@class='gridTable ']//td[@headers='a2']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID2']//table[@class='gridTable ']//td[@headers='a6']//img[@alt='Checked']"));

		// Verify for Contact Read, update and Create permissions at territory and child
		// levels
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@headers='a2']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@headers='a3']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@headers='a4']//img[@alt='Checked']"));

		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@headers='a6']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@headers='a7']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID3']//table[@class='gridTable ']//td[@headers='a8']//img[@alt='Checked']"));

		// Verify for Lead Read, update and Create permissions at territory and child
		// levels
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@headers='a2']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@headers='a3']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@headers='a4']//img[@alt='Checked']"));

		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@headers='a6']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@headers='a7']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID4']//table[@class='gridTable ']//td[@headers='a8']//img[@alt='Checked']"));

		// Verify for Opportunity Read, update and Create permissions at territory and
		// child levels
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@headers='a2']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@headers='a3']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@headers='a4']//img[@alt='Checked']"));

		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@headers='a6']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@headers='a7']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID5']//table[@class='gridTable ']//td[@headers='a8']//img[@alt='Checked']"));

		// Verify for Task Read, update and Create permissions at territory and child
		// levels
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@headers='a2']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@headers='a3']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@headers='a4']//img[@alt='Checked']"));

		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@headers='a6']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@headers='a7']//img[@alt='Checked']"));
		pegaDriver.verifyElement(By
				.xpath("//div[@id='PEGA_GRID6']//table[@class='gridTable ']//td[@headers='a8']//img[@alt='Checked']"));

	}

	@Override
	public void navigateToAccessAndPermissionsTab() {

		pegaDriver.waitForDocStateReady();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		pegaDriver.findElement(By.xpath("//div[@role='tab']/h3[contains(text(),'Access & Permissions')]")).click();
	}

	public boolean verifyOprNewHarness() {

		String frameId = pegaDriver.getActiveFrameId(false);
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.verifyElement(OPR_TEMPLATE_CHECKBOX);
	}

	@Override
	public void clickNext() {

		String frameId = pegaDriver.getActiveFrameId(false);
		pegaDriver.switchTo().frame(frameId);
		pegaDriver.findElement(By.xpath(OPR_NEXT_BUTTON_XPATH)).click();

	}

	@Override
	public boolean verifyOprAccessScreen() {

		String frameId = pegaDriver.getActiveFrameId(false);
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.verifyElement(OPR_DEFAULT_ACCESS_CHECKBOX);

	}

	@Override
	public boolean verifyOprSalesGoalsScreen() {

		String frameId = pegaDriver.getActiveFrameId(false);
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.verifyElement(By.xpath("//table[@id='bodyTbl_right']"));

	}

	@Override
	public void clickFinish() {
		String frameId = pegaDriver.getActiveFrameId(false);
		pegaDriver.switchTo().frame(frameId);
		pegaDriver.findElement(By.xpath(OPR_NEXT_BUTTON_XPATH)).click();

		pegaDriver.getActiveFrameId(true);
		if (pegaDriver.verifyElement(By.xpath("//button[@title='Complete this assignment']//div[text()='Finish']")))
			pegaDriver.findElement(By.xpath("//button[@title='Complete this assignment']//div[text()='Finish']"))
					.click();

	}

}
