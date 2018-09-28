package pegamarketing.pages;

import org.openqa.selenium.By;

import pegamarketing.dialog.ImageCatalogDialog;

public interface ImageLibrary extends LandingPage{
	By IMAGE_LIBRARY_HEADER = By.xpath("//*[text()='Image Library'][@class='workarea_header_titles']");
	By CREATE_FOLDER_BUTTON = By.xpath("//*[text()='Create Folder']");

	void verifyImageLibraryHeader();
	
	ImageCatalogDialog clickCreateFolder();

}
