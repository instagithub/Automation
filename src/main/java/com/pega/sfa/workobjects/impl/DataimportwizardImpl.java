package com.pega.sfa.workobjects.impl;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;
import com.pega.sfa.workobjects.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.ri.WizardImpl;

import com.pega.util.XPathUtil;




public class DataimportwizardImpl extends WizardImpl implements Dataimportwizard {
	
	public DataimportwizardImpl(WebElement elmt, String elmtId) {
		
		super(elmt, elmtId);
	
	}
	String Dataimportwizard_Button_xpath=UtilImpl.getButtonXpath("Data import wizard");
    String wotype;
    String templatetype;
    String Uploadtype_ID = "WorkTypeName";
    String Import_Button_xpath = UtilImpl.getButtonXpath("Import");
    String ChooseFile_Button_xpath = "//input[contains(@id,'pyFilePath')]";
    String FinalImport_Button_xpath = XPathUtil.getButtonPzBtnMidXPath("Import");
    String Importfile_Next_Button_xpath = XPathUtil.getButtonPzBtnMidXPath("Next >>");
    String ImportPurpose_ID = "pyImportPurpose";
    String Templatetype_ID = "pySelectedTemplateName";
    String FinishImport_Button_ID = "submitButton";
    String Startvalidation_Button_xpath=UtilImpl.getStrongButtonXPath("Start validation");
    String Skiprunning_validaterules_ID="pyUseDefaultValidation";
    String Apply_Button_xpath="(//button[contains(@class, 'pzhc pzbutton') and contains(text(),'Apply')])[2]";
    String DefaultDateformat_textbox_id="pyDateTimeFormat";
    
    
    		
    
    @Override
	public void SelectUploadtype(String Loader) {
		pegaDriver.getActiveFrameId(true);
        pegaDriver.findSelectBox(By.id(Uploadtype_ID)).selectByVisibleText(Loader);
		
	}
    
    @Override
   	public void Uploadtypeopp(String Loader) {
   		pegaDriver.getActiveFrameId(true);
           pegaDriver.findSelectBox(By.id(Uploadtype_ID)).selectByVisibleText(Loader);
           
   		
   	}
	@Override
	public void Clickimport() {
		  pegaDriver.findElement(By.xpath(Import_Button_xpath)).click();
		
	}

	@Override
	public void Choosefile(String Loadercsv) {
		 pegaDriver.getActiveFrameId(true);
	        pegaDriver.findElement(By.xpath(ChooseFile_Button_xpath)).click();
	        try {
	            ClassLoader classLoader = this.getClass().getClassLoader();
	            String filePath = new File(classLoader.getResource(Loadercsv).getFile()).getAbsolutePath();
	            Runtime.getRuntime().exec(".\\AutoItfiles\\FileSetup.exe  " + filePath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void Selectpurpose(String Purpose) {
		
		 pegaDriver.getActiveFrameId(true);
	     pegaDriver.findSelectBox(By.id(ImportPurpose_ID)).selectByVisibleText(Purpose);
	}

	@Override
	public void ClickCancel() {
		
	}

	@Override
	public void ClickNext() {
		pegaDriver.getActiveFrameId(true);
        pegaDriver.findElement(By.xpath(Importfile_Next_Button_xpath)).click();
		
	}

	@Override
	public void Selecttemplate(String LoaderTemplate) {
		
		pegaDriver.getActiveFrameId(true);
        pegaDriver.findSelectBox(By.id(Templatetype_ID)).selectByVisibleText(LoaderTemplate);
	}

	@Override
	public void ClickBack() {
		
	}

	@Override
	public void Nameforthisimport() {
		
		
	}

	@Override
	public boolean Saveimportsettings_as_a_template() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Templatename() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Skiprunning_validaterules() {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id( Skiprunning_validaterules_ID)).click();
		return false;
	}
	
	@Override
	public void setDateformat(){
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(DefaultDateformat_textbox_id)).sendKeys("yyyymmdd");
		pegaDriver.findElement(By.xpath(Apply_Button_xpath)).click();	
		}

	@Override
	public void Clickstartvalidation() {
		// TODO Auto-generated method stub
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(Startvalidation_Button_xpath)).click();
		
	}

	@Override
	public void Clickcontinueimport() {
		// TODO Auto-generated method stub	
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(UtilImpl.SUBMIT_XPATH)).click();
		
	}
	@Override
	public void Clickfinish() {
		pegaDriver.getActiveFrameId(true);
	   pegaDriver.handleWaits().waitForTextPresence(By.xpath("//span[contains(@id,'Percentage')]"), "100%");
	
	   //String message=  pegaDriver.findElement(By.xpath("//div[@class='field-item dataLabelWrite']")).getText();
	//Assert.assertFalse(message.contains("Error"));
	
	pegaDriver.getActiveFrameId(true);
	pegaDriver.findElement(By.id(FinishImport_Button_ID)).click();
	
	}
}