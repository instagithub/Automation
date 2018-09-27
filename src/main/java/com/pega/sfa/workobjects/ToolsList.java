package com.pega.sfa.workobjects;



import com.pega.ri.Wizard;
import com.pega.sfa.workobjects.impl.UtilImpl;

public interface ToolsList extends Wizard {
  String Dataimportwizard_Button_xpath=UtilImpl.getButtonXpath("Data import wizard");
  String Manageproducts_Button_xpath=UtilImpl.getButtonXpath("Manage products");



  String Managecompetitors_Button_xpath=UtilImpl.getButtonXpath("Competitors");
  String Managerelationtypes_Button_xpath=UtilImpl.getButtonXpath("Relationship types");
  String Managetimeperiods_Button_xpath=UtilImpl.getButtonXpath("Time periods");
  String PersonalizeMgrdashboard_Button_xpath=UtilImpl.getButtonXpath("Manager's dashboard");
  String PersonalizeRepdashboard_Button_xpath=UtilImpl.getButtonXpath("Sales rep's dashboard");
  String PersonalizeOpsdashboard_Button_xpath=UtilImpl.getButtonXpath("Sales ops' dashboard");
  String Import_Button_xpath=UtilImpl.getButtonXpath("Import");
  
 
   
  Dataimportwizard Dataimportwizard();
  Tools ManageProducts();
  Tools ManageCompetitors();
  Tools ManageRelationTypes();
  Tools ManageTimePeriods();
  
 /* Tools PersonalizeMgrDashboard();
  Tools PersonalizeRepDashboard();
  Tools PersonalizeOpsDashboard();
 */ 
}
