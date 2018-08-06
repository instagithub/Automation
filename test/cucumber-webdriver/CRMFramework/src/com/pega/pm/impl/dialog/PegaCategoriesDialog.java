package com.pega.pm.dialog;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;

public class PegaCategoriesDialog extends PegaConfigureDialog implements CategoriesDialog{
	TestEnvironment testEnv;
	PegaWebDriver pegaDriver;
	PegaWebElement elmt;
	
	public PegaCategoriesDialog(Frame aElmt) {
		super(aElmt);
		elmt = aElmt;
	}

	
	public void Addcategories() {
		
	elmt.findElement(ADDCATEGORIES_LINK).click();
		
	}


	@Override
	public boolean verifycategory(String arg1) {
	boolean result =elmt.findElement(SELECTCATEGORYLIST).verifyElement(By.xpath("//*[text()='"+arg1+"']"));
		return result;
	}


	@Override
	public void addreqcategory(String arg1) {
	elmt.findElement(CREATENEW_LINK).click();
	elmt.findElement(CREATENEW_INPUT).sendKeys(arg1);
	elmt.findElement(By.xpath("//*[@aria-label='pzCreateCategory']//*[contains(text(),'OK')]")).click();
	elmt.findElement(SELECTCTGYOK_BTN).click();
	elmt.findElement(CLOSE_BTN).click();
		
	}


	@Override
	public void clickreqCategory(String arg1) {
		elmt.findElement(SELECTCATEGORYLIST).findElement(By.xpath("//*[text()='"+arg1+"']")).click();
		elmt.findElement(SELECTCTGYOK_BTN).click();
		elmt.findElement(CLOSE_BTN).click();
	}
	 

}
