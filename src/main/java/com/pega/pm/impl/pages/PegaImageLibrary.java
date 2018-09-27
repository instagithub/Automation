package com.pega.pm.impl.pages;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.pm.dialog.ImageCatalogDialog;
import com.pega.pm.impl.dialog.PegaImageCatalogDialog;
import com.pega.pm.pages.ImageLibrary;

public class PegaImageLibrary extends PegaLandingPage implements ImageLibrary{
	TestEnvironment testEnv;
	PegaWebDriver pegaDriver;
	PegaWebElement elmt;
	public PegaImageLibrary(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
		//this.elmt = elmt;
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver(); 
	}

	@Override
	public void verifyImageLibraryHeader() {
		pegaDriver.findElement(IMAGE_LIBRARY_HEADER).isDisplayed();
	}

	@Override
	public ImageCatalogDialog clickCreateFolder() {
		pegaDriver.findElement(CREATE_FOLDER_BUTTON).click();
		ImageCatalogDialog imageCatalogDialog = new PegaImageCatalogDialog(this,testEnv);
		return imageCatalogDialog;
	}

}
