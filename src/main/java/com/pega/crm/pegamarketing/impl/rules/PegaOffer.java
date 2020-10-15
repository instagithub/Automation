package com.pega.crm.pegamarketing.impl.rules;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.dialog.ImageCatalogDialog;
import com.pega.crm.pegamarketing.elmt.Connector;
import com.pega.crm.pegamarketing.elmt.OfferShape;
import com.pega.crm.pegamarketing.impl.dialog.PegaImageCatalogDialog;
import com.pega.crm.pegamarketing.impl.dialog.PegaModalDialog;
import com.pega.crm.pegamarketing.impl.elmt.PegaConnector;
import com.pega.crm.pegamarketing.impl.elmt.PegaOfferShape;
import com.pega.crm.pegamarketing.rules.Offer;
import com.pega.crm.pegamarketing.utils.GlobalRepository;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;

public class PegaOffer extends PegaRuleInstance implements Offer {

	public static final By START_CONNECTOR = By.xpath("//*[contains(@style,'visible')]/*[@d][2]");

	public PegaOffer(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	protected String shapeName1;
	protected String shapeName2;

	public OfferShape dragShape(Shape shape) {
		return dragShape(shape, null, 0, 0);
	}

	public OfferShape dragShape(Shape shape, int xEnd, int yEnd) {
		return dragShape(shape, null, xEnd, yEnd);
	}

	public OfferShape dragShape(Shape shape, String shapeName) {
		return dragShape(shape, shapeName, 0, 0);
	}

	public void switchTab(String tabName) {
		String elmtXpath = "//*[contains(@aria-label,'" + tabName + "')]//*[contains(text(),'" + tabName + "')]";
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath(elmtXpath));
		findElement(By.xpath(elmtXpath)).scrollIntoView();
		pegaDriver.handleWaits().sleep(2);
		findElement(By.xpath(elmtXpath)).click();
	}

	public OfferShape dragShape(Shape shape, String shapeName, int xEnd, int yEnd) {
		String str2 = shape.getName();
		String shapeText = str2;
		Reporter.log("Shape you are dragging: " + shapeText, true);
		pegaDriver.waitForDocStateReady(3);
		testEnv.getMouse().moveTo(1200, 800);
		this.findElement(By.xpath("//*[@id='PALLETE-BUTTON']")).click();
		shapeText = handleSmartAndAdvancedShapes(shapeText);
		PegaWebElement shapeElement = this
				.findElement(By.xpath("//*[@role='menuitem' and text()='" + shapeText + "']"));

		PegaWebElement pmViewer = this.findElement(By.id(getPalleteID()));
		shapeElement.dragAndDrop(pmViewer, xEnd, yEnd);

		By byShapeXpath = null;

		if (shapeName != null) {
			String draggedShapeLocator = null;
			String defaultShapeName = shapeText;
			String renamedshapeElementLocator = null;
			String renamedShapeName = shapeName;

			if (shapeText.equals("End")) {
				draggedShapeLocator = "//*[@id='shapeLabel']//*[text()='End']";
			}
			if (null == draggedShapeLocator) {
				draggedShapeLocator = "//*[@id='shapeLabel'][.//*[contains(text(),'" + defaultShapeName
						+ "')]]/preceding-sibling::*[@transform]";
			}

			if (null == renamedshapeElementLocator) {
				renamedshapeElementLocator = "//*[@id='shapeLabel'][.//*[contains(text(),'" + renamedShapeName
						+ "')]]/preceding-sibling::*[@transform]";
			}
			PegaWebElement shapeTextElmt = null;

			shapeTextElmt = this.findElement(By.xpath(draggedShapeLocator));
			shapeTextElmt.doDoubleClickWithMouse();
			// actions.doubleClick(shapeTextElmt.getWebElement()).build().perform();
			pegaDriver.waitForDocStateReady(3);
			PegaWebElement moName = this.findElement(By.xpath(MONAME_XPATH));
			scriptExecutor.sendKeys(moName, shapeName);
			pegaDriver.waitForDocStateReady(1);
			this.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click(true);
			byShapeXpath = By.xpath(renamedshapeElementLocator);
		} else {
			byShapeXpath = By.xpath("//*[@id='shapeLabel'][.//*[contains(text(),'" + shape.getName()
					+ "')]]/preceding-sibling::*[@transform]");
		}
		WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
		OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, shapeName);
		flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument(), this.getFramesSet());
		return flowShapeObj;
	}

	public String getPalleteID() {
		return "pmviewer_graph";
	}

	protected String handleSmartAndAdvancedShapes(String shapeText) {
		if (shapeText.startsWith("Smart Shapes:")) {
			PegaWebElement smartShapes = this
					.findElement(By.xpath("//*[@role='menuitem' and contains(text(),'Smart Shapes')]"));
			scriptExecutor.mouseOver(smartShapes);
		} else if (shapeText.startsWith("Advanced:")) {
			PegaWebElement smartShapes = this
					.findElement(By.xpath("//*[@role='menuitem' and contains(text(),'Advanced Shapes')]"));
			scriptExecutor.mouseOver(smartShapes);
		} else {
			PegaWebElement smartShapes = this.findElement(
					By.xpath("//*[@role='menuitem' and contains(text(),'" + shapeText.split(":")[0] + "')]"));
			scriptExecutor.mouseOver(smartShapes);
		}
		shapeText = shapeText.substring(shapeText.indexOf(":") + 1);
		return shapeText;
	}

	public OfferShape findShape(String shapeName) {
		By byShapeXpath = null;

		byShapeXpath = By.xpath(
				"//*[@id='shapeLabel'][.//*[contains(text(),'" + shapeName + "')]]/preceding-sibling::*[@style]");

		testEnv.getPegaDriver().waitForDocStateReady(2);
		WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
		OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, shapeName);
		flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument(), this.getFramesSet());
		return flowShapeObj;
	}

	public OfferShape findStartShape() {
		By byShapeXpath = By.xpath("//*[@id='shapeLabel']//*[text()='Start']");
		WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
		OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, "Start");
		flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument(), this.getFramesSet());
		return flowShapeObj;
	}

	public OfferShape findEndShape() {
		By byShapeXpath = By.xpath("//*[@id='shapeLabel']//*[text()='End']");
		testEnv.getPegaDriver().waitForDocStateReady(2);
		WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
		OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, "End");
		flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument(), this.getFramesSet());
		return flowShapeObj;
	}

	public OfferShape findEndShape(String label) {
		By byShapeXpath = By.xpath("//*[@id='shapeLabel']//*[text()='" + label + "']");
		testEnv.getPegaDriver().waitForDocStateReady(2);
		WebElement shapeElmt = findElement(byShapeXpath).getWebElement();
		OfferShape flowShapeObj = new PegaOfferShape(shapeElmt, this, "End");
		flowShapeObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument(), this.getFramesSet());
		return flowShapeObj;
	}

	public void setEndShapeName(String shapeName) {
		By byShapeXpath = By.xpath("//*[@id='shapeLabel']//*[text()='End']");
		testEnv.getPegaDriver().waitForDocStateReady(2);
		PegaWebElement shapeElmt = findElement(byShapeXpath);
		shapeElmt.doDoubleClickWithMouse();
		PegaWebElement moName = this.findElement(By.xpath(MONAME_XPATH));
		scriptExecutor.sendKeys(moName, shapeName);
		this.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click(true);
	}

	public void renameEndShape(String oldName, String newName) {
		By byShapeXpath = By.xpath("//*[@id='shapeLabel']//*[text()='" + oldName + "']");
		testEnv.getPegaDriver().waitForDocStateReady(2);
		PegaWebElement shapeElmt = findElement(byShapeXpath);
		shapeElmt.doDoubleClickWithMouse();
		PegaWebElement moName = this.findElement(By.xpath(MONAME_XPATH));
		scriptExecutor.sendKeys(moName, newName);
		this.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click(true);

	}

	public void setConnectorName(By by, String connectorName) {
		testEnv.getPegaDriver().waitForDocStateReady(4);
		PegaWebElement connectorElmt = this.findElement(by);
		connectorElmt.doDoubleClickWithMouse();
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement moName = this.findElement(By.xpath(Offer.MONAME_XPATH));
		scriptExecutor.clear(moName);
		moName.sendKeys(connectorName);
		this.findElement(By.xpath(GlobalRepository.SUBMIT_BUTTON_XPATH)).click(true);
		pegaDriver.handleWaits().waitForNoThrobber();
	}

	public void setStartConnName(String startConnName) {
		setConnectorName(By.xpath("//*[contains(@style,'visible')]/*[@d][2]"), startConnName);
		if (testEnv.getBrowser().isFirefox()) {
			save();
		}
	}

	public Connector findConnector(String connName) {
		By byShapeXpath = By
				.xpath("//*[name()='path']/../following-sibling::*[name()='g']//*[text()='" + connName + "']");
		WebElement connElem = findElement(byShapeXpath).getWebElement();
		Connector connObj = new PegaConnector(connElem, this, connName);
		connObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument(), this.getFramesSet());
		return connObj;
	}

	public Connector findConnector(By byShapeXpath) {
		WebElement connElem = findElement(byShapeXpath).getWebElement();
		Connector connObj = new PegaConnector(connElem, this);
		connObj._setEnvironment(testEnv, byShapeXpath, getFrameDocument(), this.getFramesSet());
		return connObj;
	}

	protected class PegaShapeProperties extends PegaModalDialog implements ShapeProperties {
		public PegaShapeProperties(Frame frame) {
			super(frame);
		}
		
		
		public void specifyTreatment() {
			findElement(SPECIFY_TREATMENT_RADIO).check();
			pegaDriver.handleWaits().sleep(3);
					}


		public void setTreatmentName(String treatmentName) {
			PegaWebElement treatmentNameElmt = findElement(SendEmailShapeProperties.TREATMENT_NAME);
			treatmentNameElmt.clear();
			treatmentNameElmt.sendKeys(treatmentName + Keys.TAB);
			//treatmentNameElmt.sendKeys(treatmentName);
			pegaDriver.handleWaits().sleep(10);
			
		}

		public void setShapeName(String shapeName) {
			PegaWebElement moName = findElement(By.xpath(MONAME_XPATH));
			scriptExecutor.sendKeys(moName, shapeName);
			pegaDriver.waitForDocStateReady(1);
		}

	}

	public class PegaSendEmailShapeProperties extends PegaShapeProperties implements SendEmailShapeProperties {
		public PegaSendEmailShapeProperties(Frame frame) {
			super(frame);
		}

		public void setEmailAccount(String emailAccount) {
			if (verifyElement(ICON_EXPAND_EMAIL_ACCOUNT)) {
				findElement(ICON_EXPAND_EMAIL_ACCOUNT).click();
			}
			PegaWebElement specifyEmailAccountElmt = findElement(SendEmailShapeProperties.SPECIFY_EMAIL_ACCOUNT_RD_BTN);
			specifyEmailAccountElmt.click();

			PegaWebElement emailAccountElmt = findElement(SendEmailShapeProperties.EMAIL_ACCOUNT_INPUT);
			emailAccountElmt.clear();
			emailAccountElmt.sendKeys(emailAccount + Keys.TAB);
			//emailAccountElmt.sendKeys(emailAccount);
			
			pegaDriver.handleWaits().sleep(10);
		}
	}

	public class PegaSendSMSShapeProperties extends PegaShapeProperties implements SendSMSShapeProperties {
		public PegaSendSMSShapeProperties(Frame frame) {
			super(frame);
		}

		@Override
		public void setSMSAccount(String smsAccount) {
			if (verifyElement(ICON_EXPAND_SMS_ACCOUNT)) {
				findElement(ICON_EXPAND_SMS_ACCOUNT).click();
			}
			PegaWebElement specifyEmailAccountElmt = findElement(SendSMSShapeProperties.SPECIFY_SMS_ACCOUNT_RD_BTN);
			specifyEmailAccountElmt.click();

			PegaWebElement smsAccountElmt = findElement(SendSMSShapeProperties.SMS_ACCOUNT_INPUT);
			smsAccountElmt.clear();
			smsAccountElmt.sendKeys(smsAccount + Keys.TAB);
		}
	}

	public ShapeProperties getShapeProperties() {
		ShapeProperties props = new PegaShapeProperties(this);
		return props;

	}

	public ShapeProperties getShapeProperties(Shape shape) {
		ShapeProperties props = null;
		switch (shape) {
		case SEND_EMAIL:
			props = new PegaSendEmailShapeProperties(this);
			break;
		case SEND_SMS:
			props = new PegaSendSMSShapeProperties(this);
			break;
		default:
			props = new PegaShapeProperties(this);
			break;
		}
		return props;
	}

	@Override
	public void setSeedList(String seedlist) {
		findElement(SEED_LIST).clear();
		findElement(SEED_LIST).sendKeys(seedlist);
	}

	@Override
	public void selectStartingPoint(String startingPoint) {
		findSelectBox(STARTING_POINT).selectByVisibleText(startingPoint);
	}

	@Override
	public void selectChannel(String channel) {
		findSelectBox(CHANNEL).selectByVisibleText(channel);
	}

	@Override
	public void setDirection(String direction) {
		if (direction.trim().equalsIgnoreCase("outbound")) {
			findElement(DIRECTION_OUTBOUND).click();
		} else if (direction.trim().equalsIgnoreCase("inbound")) {
			findElement(DIRECTION_INBOUND).click();
		}

	}

	@Override
	public void refreshTrackResults() {
		findElement(REFRESH_TRACK_RESULTS).click();
	}

	@Override
	public void testOffer() {
		findElement(TEST_OFFER).click();
	}

	@Override
	public void clickDetails() {
		findElement(DETAILS_TAB).click();
		// pegaDriver.waitForDocStateReady();

	}

	@Override
	public ImageCatalogDialog clickImageURLCog() {
		findElement(IMAGE_URL_COG).click();
		ImageCatalogDialog imageCatalogDialog = new PegaImageCatalogDialog(this, testEnv);
		return imageCatalogDialog;

	}

	@Override
	public void DeleteMenuClick() {
		findElement(DELETE_MENU).click();
		
	}

}
