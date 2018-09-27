package com.pega.pm.pages;

import org.openqa.selenium.By;

import com.pega.pm.dialog.ImageCatalogDialog;

public interface ImageLibrary extends LandingPage{
	By IMAGE_LIBRARY_HEADER = By.xpath("//*[text()='Image Library'][@class='workarea_header_titles']");
	By CREATE_FOLDER_BUTTON = By.xpath("//*[text()='Create Folder']");

	void verifyImageLibraryHeader();
	
	ImageCatalogDialog clickCreateFolder();

}
