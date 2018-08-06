package com.pega.sfa.workobjects.impl;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;
import com.pega.sfa.workobjects.Dataimportwizard;
import com.pega.sfa.workobjects.Tools;
import com.pega.sfa.workobjects.ToolsList;

public class ToolsListImpl extends WizardImpl implements ToolsList {
	
	public ToolsListImpl(WebElement elmt, String elmtId) {
		
		super(elmt, elmtId);
		// TODO Auto-generated constructor stub
	}
	
	  String Dataimportwizard_Button_xpath=UtilImpl.getButtonXpath("Data import wizard");
	  String Manageproducts_Button_xpath=UtilImpl.getButtonXpath("Products");
	  String Managecompetitors_Button_xpath=UtilImpl.getButtonXpath("Competitors");
	  String Managerelationtypes_Button_xpath=UtilImpl.getButtonXpath("Relationship types");
	  String Managetimeperiods_Button_xpath=UtilImpl.getButtonXpath("Time periods");
	  String PersonalizeMgrdashboard_Button_xpath=UtilImpl.getButtonXpath("Manager's dashboard");
	  String PersonalizeRepdashboard_Button_xpath=UtilImpl.getButtonXpath("Sales rep's dashboard");
	  String PersonalizeOpsdashboard_Button_xpath=UtilImpl.getButtonXpath("Sales ops' dashboard");
	  String Import_Button_xpath=UtilImpl.getButtonXpath("Import");
	@Override
	public Dataimportwizard Dataimportwizard() {
		pegaDriver.getActiveFrameId(true);
		 pegaDriver.findElement(By.xpath(Dataimportwizard_Button_xpath)).click();
		 
		 String frameId = pegaDriver.getActiveFrameId(false);
		 PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		 Dataimportwizard Di = new DataimportwizardImpl(framElmt, frameId);
		 Di._setEnvironment(testEnv, frameId);
		 System.out.println("Returning DI object:::::"+ Di);
		 return Di;
	}
	
	@Override
	public Tools ManageProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Tools ManageCompetitors() {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(Managecompetitors_Button_xpath)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Tools trr = new ToolsImpl(framElmt, frameId);
		trr._setEnvironment(testEnv, frameId);
		return trr;
	}
	@Override
	public Tools ManageRelationTypes() {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(Managerelationtypes_Button_xpath)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Tools trr = new ToolsImpl(framElmt, frameId);
		trr._setEnvironment(testEnv, frameId);
		return trr;	
	}
	@Override
	public Tools ManageTimePeriods() {
		// TODO Auto-generated method stub
		return null;
	}
	/*@Override
	public Tools PersonalizeMgrDashboard() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Tools PersonalizeRepDashboard() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Tools PersonalizeOpsDashboard() {
		// TODO Auto-generated method stub
		return null;
	}*/
	  
	/*@Override
	public boolean isDataImportButtonDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isManageProductsButtonDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isManageCompetitorsButtonDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isManageRelationTypesButtonDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isManageTimePeriodsButtonDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isPersonalizeMgrDashboardButtonDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isPersonalizeRepDashboardButtonDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isPersonalizeOpsDashboardDispayed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public IDataImport DataImport() {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(Dataimportwizard_Button_xpath)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		IDataImport di = new DataImportImpl(framElmt, frameId);
		di._setEnvironment(testEnv, frameId);
		return di;
	}
	@Override
	public Void ManageProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Void ManageCompetitors() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Void ManageRelationTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Void ManageTimePeriods() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Void PersonalizeMgrDashboard() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Void PersonalizeRepDashboard() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Void PersonalizeOpsDashboard() {
		// TODO Auto-generated method stub
		return null;
	}
	  */


}
	
