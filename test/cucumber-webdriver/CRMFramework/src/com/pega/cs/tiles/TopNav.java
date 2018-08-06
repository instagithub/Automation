package com.pega.cs.tiles;


import com.pega.cs.designerstudio.ApplicationWizard;
import com.pega.cs.interactions.CTI;
import com.pega.cs.interactions.ChatInteraction;
import com.pega.cs.interactions.Interactions;
import com.pega.cs.interactions.NewDemoInteraction;
import com.pega.cs.interactions.NewInboundInteraction;
import com.pega.cs.interactions.OutboundPhoneCall;
import com.pega.cs.interactions.PhoneCall;
import com.pega.cs.interactions.ResearchInteraction;
import com.pega.cs.interactions.SocialInteraction;

import cucumber.api.DataTable;

public interface TopNav{
	
	<T extends Interactions> T getDemoInteractionType(String value);
	<T extends Interactions> T getInteractionType(String value);
	<T extends Interactions> T returnInteractionType(String value);
	<T extends Interactions> T getDemoInteractionTypeAsManager(String value);
	//New Application
	String Link_AppType="//span[text()='TextValue']";
	String Chk_NewAppWiz="//label[text()='Close Account']/preceding-sibling::input[1]";
	String Link_AdvancedConfig="//a[text()='Advanced configuration']";
	String RBN_AppStructure="//label[text()='TextValue']";
	String Txt_AppId_Id="pyApplicationName";
	String Btn_Save="//button[text()='Save']";
	String Btn_Cancel="//button[text()='Cancel']";
	String Btn_CreateApp="//button[text()='Create application']";
	String CS_IMPL_OPERATOR_MENU_XPATH = "//*[@data-test-id='px-opr-image-ctrl' and @data-menuid='pyNavigation1531237118455']";
	String CS_IMPL_OPERATOR_XPATH = "//span[text()='Operator']";
	String CS_IMPL_LogOff_XPATH = "//span[text()='Log off']";
	String NewAppAccessGrp_Xpath = "//input[contains(@value,'Value')]";
	String RBN_NewAppAccessGrp_Xpath = "//input[contains(@value,'ReplaceValue')]/ancestor::td[2]/preceding-sibling::td[1]/descendant::input[@type='radio']";
	String RBN_CSAccessGrp_Xpath = "//a[contains(text(),'PegaCS')]/ancestor::td[2]/preceding-sibling::td[2]/descendant::input[@type='radio']";
	String Btn_RemoveNewAccessGrp_Xpath = "//input[contains(@value,'ReplaceValue')]/ancestor::td[2]/following-sibling::td/descendant::a[@data-test-id='20151125051921001622247']";
	String Btn_SwitchToNewApplication_Xpath = "//input[contains(@value,'ReplaceValue')]";
	String Link_DSMenuNav_Xpath="//span[text()='TextValue']/ancestor::li[@role='presentation']";
	String Link_DesignerStudio_Xpath="//a[contains(text(),'Designer Studio')]";
	String Tab_QuerySettings_Xpath="//*[contains(text(),'Query settings')]/ancestor::div[contains(@class,'Collapsed')]";
	//String Chk_Search_Xpath="//*[contains(text(),'TextValue')]/ancestor::td[1]/preceding-sibling::td/descendant::input[2]";
	String Chk_Search_Xpath="//input[@id='pyEnable3']";
	String Btn_Reindex="//*[contains(text(),'TextValue')]/ancestor::td[1]/following-sibling::td/descendant::button[contains(text(),'Re-index')]";
	String Btn_ReindexOk="//*[contains(text(),'OK')]/ancestor::button[1]";
	String Btn_CancelReindex="//button[text()='Cancel re-index']";
	String PHONE_ICON_XPATH= "//i[@name='PegaCallControlPanel_CTIPhone_1']";
	String LOGIN_BUTTON_XPATH="//button[text()='Login']";
	String SEARCH_BOX_XPATH="//input[@data-test-id='2015052504543705231680']";
	String SEARCH_ITEM_XPATH ="//i[@title='Search for an item']";
	String SELECT_DATA_SOURCE_XPATH= "//select[@data-test-id='201610190747440120129777']";
	
	String CHAT_SERVER_XPATH= "//select[@data-test-id='2014121804320102541978']";
	String CHAT_SERVER_DISPLAY_NAME_XPATH= "//input[@data-test-id='2014121804320102584575']";
	
	String CTI_LINK_XPATH = "//select[@data-test-id='2014111308113202885473']";
	String EXTENSION_XPATH = "//input[@data-test-id='20141113081132029011795']";
	String CCTUSER_XPATH = "//input[@data-test-id='2015061000554601945820']";
	String CCTPASSWORD_XPATH = "//input[@data-test-id='2015061000554601968695']";
	String AGENT_XPATH = "//input[@data-test-id='20141113081132029320504']";
	String PASSWORD_XPATH = "//input[@data-test-id='20141113081132029523156']";
	String	ERROR_MESSAGE_XPATH= "//span[@data-test-id='20141113081132029941929' and contains(text(),'The passive terminal cannot be updated while the Agent')]";
	
	PhoneCall createNewPhoneCall();
	NewDemoInteraction createNewDemoPop();
	NewInboundInteraction startInboundCase();
	void searchPortal(String name);
	String getStatusOfCase();
	ResearchInteraction searchResult(String interactionType, String name);
	ResearchInteraction search(String name);
	CTI agentLogin(String CTIlink, String extension, String agentId, String password);
	void createNewDemoPop_BROWN();
	NewDemoInteraction Accept_NewDemoPop_BROWN();
	NewDemoInteraction NewDemoPop_BROWN();
	ChatInteraction chatAgentLogin(String serverName, String displayName);
	void modifyAccessGroup();
	void createNewCase(String caseName, String stageName);
	void createNewApplication(String builton, String type, String organization);
	ApplicationWizard createApplication(String name);
	OutboundPhoneCall createOutboundPhoneCall();
	ResearchInteraction searchDropDownresult(String result);
	ResearchInteraction closeInteraction();
	//DialogsAndCoachingTips ConfigDialog();
	ApplicationWizard launchNewAppWizard();
	ApplicationWizard createNewApplication(String appName, String appType, String caseTypes, String channels,
			Boolean cdh, String dataTypes);
	void selectApp(String AppName);
	void clickOnUseThisApp();
	void selectCaseTypes(String SelectAllFlag, DataTable CaseType);
	void selectChannels(String SelectAllFlag, DataTable Channel);
	void selectDataTypes(String SelectAllFlag, DataTable DataType);
	void selectCDH(String Flag);
	void selectAppStructure(String AppStructure);
	void advancedSettings();
	void clicksOnCreateApp();
	void modifyAccessGroupNew();
	void logOutDS();
	void selectNavigationFromDS(DataTable ListOfValues);
	void clickOnQuerySettingsTab();
	void checkSearch(String CheckBox);
	void Reindex(String ReindexOf);
	ResearchInteraction initiateACall(String result);
	SocialInteraction launchTwitterCase(String customerName);
	void startDataFlow();
//	void checkDataFlow();
	void socialLogOutDS();
	void stopDataFlow();
	void modifyAccessGroupToCS();
	SocialInteraction launchCaseViaGetMostUrgent();
	void clickSearchConfiguration();
	void selectDataSource();
	void selectAccountDataSourceFields(DataTable AccountFields);
	void selectContactDataSource();
	void selectOrganizationDataSource();
	void addDSMNode();
	void openLandingPage(String designerStudio, String decisioning, String infrastructure, String services, String dataflow);
	void SwitchToInteractionPortal();
	void addDSMNodesInDecisionDataStore();
	void addDSMNodesInAdaptiveDecisionManager();
	void addDSMNodesInDataFlow();
	void addDSMNodesInRealTimeDataGrid();
	void addDSMNodesInStream();
	void switchToDSMTabs(String tabName);
	void deletesNewAppAccessGroup();
	void switchToNewApplication();
	void launchServiceProcessExpress();
	void clicksAddTaskExpress();
	void enableToggleMode();
	void clickOnEditWorkArea();
	void deleteField(String field);
	void verifyDeletedField(String field);
	void launchWarpupExpress();
	void verifyWrapUpDialogExpress();
	void completeWrapUpExpress();
	void clickAddField();
	void addField(String field);
	void closeAddFieldWindow();
	void disableToggleMode();
	void closeTemplateWindow();
	
	
	
		
	
	
	
}
