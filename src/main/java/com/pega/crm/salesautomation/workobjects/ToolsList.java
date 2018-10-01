package salesautomation.workobjects;



import com.pega.ri.Wizard;
import salesautomation.workobjects.impl.PegaUtil;

public interface ToolsList extends Wizard {
  String Dataimportwizard_Button_xpath=PegaUtil.getButtonXpath("Data import wizard");
  String Manageproducts_Button_xpath=PegaUtil.getButtonXpath("Manage products");



  String Managecompetitors_Button_xpath=PegaUtil.getButtonXpath("Competitors");
  String Managerelationtypes_Button_xpath=PegaUtil.getButtonXpath("Relationship types");
  String Managetimeperiods_Button_xpath=PegaUtil.getButtonXpath("Time periods");
  String PersonalizeMgrdashboard_Button_xpath=PegaUtil.getButtonXpath("Manager's dashboard");
  String PersonalizeRepdashboard_Button_xpath=PegaUtil.getButtonXpath("Sales rep's dashboard");
  String PersonalizeOpsdashboard_Button_xpath=PegaUtil.getButtonXpath("Sales ops' dashboard");
  String Import_Button_xpath=PegaUtil.getButtonXpath("Import");
  
 
   
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
