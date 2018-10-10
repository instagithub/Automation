package com.pega.crm.pegamarketing.impl.dialog;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.dialog.ButtonParametersDialog;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;

public class PegaButtonParametersDialog extends PegaImageCatalogDialog implements ButtonParametersDialog{

	TestEnvironment testEnv;
	PegaWebDriver pegaDriver;
	PegaWebElement elmt;
	String buttonImageURL;
	public PegaButtonParametersDialog(Frame elmt,TestEnvironment testenv) {
		super(elmt, testenv);
		this.elmt = elmt;
		this.testEnv = testenv;
		this.pegaDriver = testenv.getPegaDriver();
	}
	
	@Override
	public void verifyButtonPropertiesDialog() {
		elmt.findElement(BUTTON_PARAMETER_MODAL).isDisplayed();
	}
	@Override
	public void clickButtonImageCog() {
		elmt.findElement(BUTTON_IMAGE_COG).click();
		pegaDriver.waitForDocStateReady();		
	}
	@Override
	public void verifyImageDialog() {
		elmt.findElement(HEADER_IMAGE).isDisplayed();
	}
	@Override
	public void verifyButtonImageURL() {
		buttonImageURL = elmt.findElement(BUTTON_IMAGE_FIELD).getText();
		buttonImageURL.contains("http://");
	}
	@Override
	public void saveButtonParameters() {
		elmt.findElement(SAVE_BUTTON_PARAMETERS).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchTo().parentFrame();		
	}
	
	@Override
	public void clickAndOpenFolder() {
		//pegaDriver.handleWaits().waitForElementPresence(CLICK_IMAGE_FOLDER);
		elmt.findElement(CLICK_IMAGE_FOLDER).doubleClick();
		pegaDriver.waitForDocStateReady();
	}
	

}
