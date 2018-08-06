package com.pega.pm.dialog;

import java.io.File;
import java.io.IOException;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;

public class PegaImageCatalogDialog extends PegaModalDialog implements ImageCatalogDialog {

	TestEnvironment testEnv;
	PegaWebDriver pegaDriver;
	PegaWebElement elmt;

	public PegaImageCatalogDialog(Frame elmt, TestEnvironment testEnv) {
		super(elmt);
		this.elmt = elmt;
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver();
	}

	@Override
	public void verifyImageModal() {
		elmt.findElement(IMAGE_URL_MODAL).isDisplayed();
	}

	@Override
	public void selectImage() {
		elmt.findElement(SELECT_FIRST_IMAGE).click();
		pegaDriver.waitForDocStateReady();
		elmt.findElement(SELECT_NEXT_BUTTON).click();
		pegaDriver.waitForDocStateReady();
		elmt.findElement(IMAGE_APPLY).click();
		pegaDriver.waitForDocStateReady();
	}

	@Override
	public void verifyURL() {
		elmt.findElement(IMAGE_URL_PROPERTY).getText().contains("http://");
	}

	@Override
	public void createFolder(String folderName) {
		pegaDriver.waitForDocStateReady();
		elmt.findElement(CREATE_FOLDER).click();
		pegaDriver.waitForDocStateReady();
		elmt.findElement(FOLDER_NAME_INPUT).sendKeys(folderName);
		pegaDriver.waitForDocStateReady();
		elmt.findElement(CREATE_AND_ADD).click();
		pegaDriver.waitForDocStateReady();
	}

	@Override
	public void searchFolder(String folderName) {
		elmt.findElement(SEARCH_IMAGE).sendKeys(folderName);
		elmt.findElement(SEARCH_ICON).click();
		pegaDriver.waitForDocStateReady();
	}

	@Override
	public void openFolder() {
		pegaDriver.handleWaits().waitForElementPresence(CLICK_FOLDER);
		elmt.findElement(CLICK_FOLDER).doubleClick();
		pegaDriver.waitForDocStateReady();
	}

	@Override
	public void uploadImage(String filename) {
		String path = System.getProperty("user.dir") + "//Data//" + filename;
		elmt.findElement(UPLOAD_BUTTON).sendKeys(path);
		pegaDriver.waitForDocStateReady();
	}

	@Override
	public void uploadImageWithAutoIT(String fileName) throws IOException {
		elmt.findElement(UPLOAD_BUTTON).doClickWithMouse();
		String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "Data"
				+ System.getProperty("file.separator") + fileName;
		System.out.println(filePath);
		pegaDriver.handleWaits().sleep(4);
		File autoItFilePath = new File("scripts\\AutoITScripts\\inputAFilePath.exe");
		String[] dialog = new String[] { autoItFilePath.getAbsolutePath(), filePath };
		Runtime.getRuntime().exec(dialog);
		pegaDriver.handleWaits().sleep(4);
	}

	@Override
	public void navigateTopFolder() {
		elmt.findElement(TOP_FOLDER).click();
		pegaDriver.waitForDocStateReady();
	}

	@Override
	public void deleteFolder() {
		elmt.findElement(DELETE_DROPDOWN).click();
		elmt.findElement(DELETE_MENU).click();
		pegaDriver.waitForDocStateReady();
		elmt.findElement(DELETE_CONFIRMATION).click();
		pegaDriver.waitForDocStateReady();
	}

	@Override
	public void cancelModalPopUp() {
		elmt.findElement(CANCEL_MODAL_POPUP).click();
	}

	@Override
	public void createFolderInImageLibrary(String folderName) {
		// pegaDriver.waitForDocStateReady();
		// elmt.findElement(CREATE_FOLDER).click();
		pegaDriver.waitForDocStateReady();
		elmt.findElement(FOLDER_NAME_INPUT).sendKeys(folderName);
		pegaDriver.waitForDocStateReady();
		elmt.findElement(CREATE_AND_ADD).click();
		pegaDriver.waitForDocStateReady();

	}

	@Override
	public void openImageLibraryFolder() {
		pegaDriver.handleWaits().waitForElementPresence(CLICK_IMAGE_LIB_FOLDER);
		elmt.findElement(CLICK_IMAGE_LIB_FOLDER).doubleClick();
		pegaDriver.waitForDocStateReady();

	}

	@Override
	public void deleteFolderImageLibrary() {
		elmt.findElement(DELETE_CHECKBOX).click();
		pegaDriver.waitForDocStateReady();
		elmt.findElement(DELETE_BUTTON).click();
		pegaDriver.waitForDocStateReady();
		elmt.findElement(DELETE_IMAGE_LIB_CONFIRM).click();
		pegaDriver.waitForDocStateReady();
	}

}
