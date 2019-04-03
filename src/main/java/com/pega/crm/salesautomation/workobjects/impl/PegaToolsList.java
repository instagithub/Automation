package com.pega.crm.salesautomation.workobjects.impl;


import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Dataimportwizard;
import com.pega.crm.salesautomation.workobjects.Tools;
import com.pega.crm.salesautomation.workobjects.ToolsList;
import com.pega.ri.WizardImpl;

public class PegaToolsList extends WizardImpl implements ToolsList {
	
	  public PegaToolsList(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}
	String Dataimportwizard_Button_xpath=PegaUtil.getButtonXpath("Data import wizard");
	  String Manageproducts_Button_xpath=PegaUtil.getButtonXpath("Products");
	  String Managecompetitors_Button_xpath=PegaUtil.getButtonXpath("Competitors");
	  String Managerelationtypes_Button_xpath=PegaUtil.getButtonXpath("Relationship types");
	  String Managetimeperiods_Button_xpath=PegaUtil.getButtonXpath("Time periods");
	  String PersonalizeMgrdashboard_Button_xpath=PegaUtil.getButtonXpath("Manager's dashboard");
	  String PersonalizeRepdashboard_Button_xpath=PegaUtil.getButtonXpath("Sales rep's dashboard");
	  String PersonalizeOpsdashboard_Button_xpath=PegaUtil.getButtonXpath("Sales ops' dashboard");
	  String Import_Button_xpath=PegaUtil.getButtonXpath("Import");
	@Override
	public Dataimportwizard Dataimportwizard() {
		pegaDriver.getActiveFrameId(true);
		 pegaDriver.findElement(By.xpath(Dataimportwizard_Button_xpath)).click();
		 
		 String frameId = pegaDriver.getActiveFrameId(false);
		 Dataimportwizard Di = new PegaDataimportwizard(frameId, testEnv);
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
		Tools trr = new PegaTools(frameId, testEnv);
		return trr;
	}
	@Override
	public Tools ManageRelationTypes() {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(Managerelationtypes_Button_xpath)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		Tools trr = new PegaTools(frameId, testEnv);
		return trr;	
	}
	@Override
	public Tools ManageTimePeriods() {
		return null;
	}
}
	
