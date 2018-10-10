package com.pega.crm.customerservice.interactions;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;

public interface Interactions extends Wizard{
	String PHONECALL_RESULT_SEARCH_XPATH = "//button[@title='Search']";
	String PHONECALL_RESULT_CLEAR_XPATH = "//button[@title='Clear']";
	String ACCOUNT_VALUE_XPATH = "//tr[contains(@oaargs, '#accounNumber#')]";
	String ADD_TASK_XPATH = "//button[@title='Add Task']";
	String ADDRESS_CHANGE_XPATH =  "//a[contains(@title,'Address Change' )  and  @class='Add_task']";
	String STATEMENT_COPY_XPATH = "//a[contains(text(),'Statement Copy') and @class='Add_task']";
	String STATEMENT_COPY_STATEMENT_XPATH = "//input[@title='Select statement']";
	String SERVICECASE_EMAILCHATLOG_XPATH = "//*[@data-test-id='201502110747090884855']";
	String SERVICECASE_SUBMIT_XPATH = "//button[contains(.,'Submit')]";//div[contains(text(),'Submit')]
	String DISTRIBUTION_DROPDOWN_XPATH = "//select[@id='CorrType']";
	//String SERVICECASE_CONFIRM_XPATH ="//button[@class='Strong pzhc pzbutton' and text()='Confirm']";
	String SERVICECASE_CONFIRM_XPATH ="//button[text()='Confirm']";
	String ADDRESS_CHANGE_CHECKBOX_ID = "pyTemplateCheckbox";
	String WRAP_UP_XPATH = "//button[@class='Wrap_up_button pzhc pzbutton' and @title='Wrap Up']";
	//String WRAP_UP_XPATH = "//i[contains(@class,'pcs-wrap-up')]";
	//String WRAP_UP_XPATH="//button[@class='Wrap_up_button pzhc pzbutton']";
	String LOST_OR_STOLENCARD_XPATH="//a[@class='Add_task' and text()='Lost or Stolen Card']";
	String DATE_OF_LAST_USE_XPATH = "//input[@id='LastUsedDate']";
	By byloc=By.xpath("//input[@id='LastUsedDate']");
	String LAST_USED_CHECKBOX_XPATH = "//input[@id='pySelected1']";
	String SUBMIT_BUTTON_XPATH = "//div[@class='pzbtn-mid' and text()='Submit']";
	String PLUS_BUTTON_XPATH = "//a[@title='Add a row ']";
	String BU_NAME_XPATH = "//input[@id='BusinessUnitName4']";
	String SERVICECASE_ADDTASK_BUTTON = "//button[@class='Strong pzhc pzbutton' and text()='Add tasks']";
	String ADD_TASK_COLLAPSE_XPATH = "//button[@class='Add_task_Collapsed pzhc pzbutton' and @title='Add Task']";	
	String WRAP_UP_COLLAPSE_XPATH = "//i[@title='Wrap Up']";
	//String OUTBOUND_REASON_ID = "OutboundCallReason";
	String OUTBOUND_REASON_XPATH = "//select[@data-test-id='20180725055154001963']";
	String OUTBOUND_STATUS_XPATH = "//label[contains(text(),'#status#')]";
	String CUSTOMER_ACKNOWLEDGE_CHECKBOX_XPATH= "//input[@id='pySelected']";
	String STOLENCARD_STREETADDRESS_XPATH="//*[@id='AddressLine1']";
	String STOLENCARD_CITY_XPATH="//*[@id='City']";
	String STOLENCARD_STATECODE_XPATH="//*[@id='StateCode']";
	String STOLENCARD_POSTALCODE_XPATH="//*[@id='ZipCode']";
	String STOLENCARD_COUNTRYCODE_DROPDOWN_XPATH="//select[@data-test-id='20151104070027020222217']";
	String STOLENCARD_CONFIRM_XPATH ="//*[@id='RULE_KEY']/div/div/div/div/div/div/span/button";
	String AUTHORIZED_CONTACT_XPATH="//*[@id='RULE_KEY']/div[2]/span[1]";
	By bylocator_AUTHORIZED_CONTACT_XPATH=By.xpath("//*[@id='RULE_KEY']/div[2]/span[1]");
	
	String CHILD_INTERACTION_LINK_XPATH ="//a[@title='Call Interaction with Ms. Biggs']";
	
	
	String CHILDS_INTERACTION_LINK_XPATH ="//div[@id='CT' and @class='content-item content-sub_section item-2   ']";
	String MAIN_INTERACTION_LINK_XPATH ="//div[@id='CT' and @class='content-item content-sub_section item-1   ']";
	String MAIN_INTERACTION_XPATH ="//a[@title='Call Interaction with Mr.  Brown']";
	String CHILD_INTERACTION_ACCOUNT_XPATH ="//table[@class='gridTable ']/tbody/tr[2]/td[1]";
	String UPDATE_CONTACTPROFILE_XPATH="//a[@class='Add_task' and text()='Update Contact Profile']";
	String DATE_DROPDOWN_XPATH="//*[@id='$PpyWorkPage$pContact$pDateOfBirthMoSel']";
	String PROFILE_INFORMATION_SUBMIT_BUTTON_XPATH="//button[@type='button' and @title='Complete this assignment']";
	String TOOLS_MENU_XPATH_BUTTON="//button[@type='button' and @title='Tools Menu']";
	String VIEW_HISTORY_MENU_XPATH_BUTTON="//div[@class='menu-panel-wrapper']/ul/li[3]/a";
	
	String CHILD_INTERACTION_ID_XPATH="//span[contains(text(), '-')]";
	//String ADDRESSCHANGE_INTERACTION_ID_XPATH="//span[contains(text(), 'S-')]";
	String SEARCH_TEXTBOX_XPATH="//*[@id='CPMAssignmentsSearchText']";
	String STATUS_ID_NUMBER_XPATH="//table[@class='gridTable ' and @pl_prop_class='CPM-Search-Result']/tbody/tr[2]/td[1]";
	String STATUS_STATUS_NUMBER_XPATH="//table[@class='gridTable ' and @pl_prop_class='CPM-Search-Result']/tbody/tr[2]/td[3]";
	String SEARCH_ICON_XPATH="//img[@name='CPMSearchMyWork_pyDisplayHarness_2' and @title='Search for a Case ']";
	String CASE_RESULT_XPATH="//table[@pl_prop_class='Assign-Worklist' and @pl_prop='pgRepPgSubSectionpyUserWorkListB.pxResults']/tbody/tr[2]/td[1]";
	String RECENT_WORK_XPATH="//div[@id='RULE_KEY']/div/div/div/div[4]/div[1]/h3";
	String CHILD_CASE_RESULT_XPATH="//table[@pl_prop_class='PegaCA-Work' and @pl_prop='pgRepPgSubSectionCPMMyRecentWorkB.pxResults']/tbody/tr[2]/td[4]";
	By bylocator_DELIVERY_METHOD_XPATH=By.xpath("//select[@id='CPMCardDeliveryMethod']");
	//String LAST_NAME_ID = "SearchStringLastName";
	String LAST_NAME_XPATH = "//input[@data-test-id='2015052601072500441291']";
	//String  ACCOUNT_NO_ID ="SearchStringAcctNum";
	String  ACCOUNT_NO_XPATH ="//input[@data-test-id='2015052601072500473750']";
	String SEARCH_RESULT_ID = "$PD_Search_Customer$ppxResults$l1";
	//String SEARCH_RESULT_ID = "201705190611150979789-R1";
	String INBOUND_SEARCH_RESULT_ID = "$PD_ContactList_Search$ppxResults$l1";
	String CONTACT_RESULT_SUBMIT_XPATH = "//button[@title='Complete this assignment']";
	String 	CONTACT_VERIFICATION_1_ID = "IsSecurityQuestionVerified1";
	String 	CONTACT_VERIFICATION_2_ID = "IsSecurityQuestionVerified2";
	String REASON_FOR_INTERACTION_XPATH = "//select[@data-test-id='2014111404305809923288']";
	
	
	
	String PRODUCTOWNER_XPATH = "//label[contains(., '#owner#')]";
	String PRODUCT_CATEGORY_XPATH ="//select[@data-test-id='2016050903195606153521']";
	String PRODUCT_ID_XPATH= "//select[@data-test-id='2016050903195606154325']";
	
	//My Work Gadget
	String WORKBASKET_LINK_XPATH = "//h3[@class ='layout-group-item-title'][text()='My workbaskets']"; 
	String WORKBASKET_ID = "//select[@data-test-id='2015021706395105541298']";
	String WORKBASKET_XPATH = "//select[@data-test-id='2015021706395105541298']";
//	String WB_CASE_XPATH = "//a[text()='#id#']";
	String WB_CASE_XPATH = "//table[contains(@pl_prop_class,'Assign-WorkBasket')][contains(@pl_prop, 'CPMMyWorkBasketListBBB')]/descendant::tr[contains(@oaargs,'#id#')]/descendant::a[text()='#id#']";
	String INTERACTION_TITLE_XPATH = "//a[@title='Call interaction with Ms. #contact#']";
	String SUGGESTED_TASK_XPATH = "//a[contains(@title,'Suggested task') and contains(text(),'#suggestedTask#')]";
	String SUGGESTED_OFFER_XPATH = "//a[@class='Standard_offer' and text()='#suggestedOffer#']";
	String COMPLAINT_XPATH="//div[contains(text(),'Complaint')]";
	String TRANSACTION_ID_XPATH = "//a[@title='Launch  Dispute for Transaction ID #transId#']";
	String INBOUND_SEARCH_XPATH = "//div[text()='Search']";
	String CREATE_CONTACT_XPATH = "//button[@title='Create new contact']";
	String CS_IMPL_OPERATOR_SWITCH_XPATH = "//div[@class='field-item dataValueWrite']/span/a[contains(@title,'CS') or contains(@title,'CA') or contains(@title,'mikejones')]";
	String INCLUDE_PROSPECTS_XPATH ="//input[@id='IncludeProspects']";
	String PROSPECTS_USER_XPATH = "//tr[@class='oddRow cellCont']/td/div/span[contains(text(),'#Username#')]";
	String DELETE_ORGANIZATION_XPATH ="//tr[@class='evenRow cellCont']/td[7]/div/span/a[@title='Delete this row ']";
	String CLOSE_INTERACTION_XPATH = "//*[contains(@class,'Wrap_up') and contains(@title,'Close')]";//xpath updated from //a[@class='Wrap_up' and text()='Close']-Prasanna Modugu
	String BUTTON_OK_XPATH = "//div[@class='pzbtn-mid' and text()='OK']";
	String CONFIRM_APPOINTMENT_BUTTON_XPATH = "//div[@class='pzbtn-mid' and text()='Close']";
	String WORKBASKET_CASE_XPATH = "//table[contains(@pl_prop_class,'Assign-WorkBasket')]/descendant::tr[contains(@oaargs,'#id#')]/descendant::a[text()='#id#']";
	
	//Configuration Tools
	String ConfigurationTools_Xpath="//span[text()='Configuration tools']/ancestor::span[1]";
	String Tab_Dialogs_Xpath="(//h3[text()='Dialogs'])[2]";
	String Tab_CoachingTips_Xpath="//h3[text()='Coaching tips']";
	String Link_AddNew_Xpath="(//a[contains(text(),'Add new')])[1]";
	String Link_AddNewCoachingTip_Xpath="//a[contains(@name,'AddCoachingTip')]";
	String DDL_When_Xpath="//label[contains(text(),'When')]/following-sibling::div/descendant::select[1]";
	String Btn_EditDialog_Xpath="//i[contains(@class,'pencil') and contains(@name,'Dialog')]/ancestor::span[1]";
	String Btn_EditCoachingTip_Xpath="//i[contains(@class,'pencil') and contains(@title,'Edit Coaching Tip ')]/ancestor::span[1]";
	String Btn_DeleteDialog_Xpath="(//i[contains(@class,'trash') and contains(@name,'Dialog')])";
	String Txt_Dialog_Xpath="//label[contains(text(),'Dialog')]/following-sibling::div/div";
	String DDL_ReferTo_Xpath="//label[contains(text(),'Refer to')]/following-sibling::div/descendant::select[1]";
	String DDL_Attribute_Xpath="//label[contains(text(),'Attribute')]/following-sibling::div/descendant::select[1]";
	String Txt_EnterName_Xpath="//input[contains(@placeholder,'<Enter Name>')]";
	String Txt_EnterCoachingTip_Xpath="//input[contains(@placeholder,'<Enter Coaching Tip>')]";
	String Tab_Assign_Xpath="//h2[contains(text(),'ASSIGN') or contains(text(),'Assign')]";
	String Link_AssignTip_Xpath="//a[contains(@title,'Assign Tip')]";
	String DDL_CoachingTip_Id="CoachingTip";
	String DDL_AssignTo_Id="EntityType";
	String DDL_AssignToValue_Id="Entity";
	String Txt_StartDate_Xpath="//input[contains(@id,'StartAssignDate')]";
	String Txt_EndDate_Xpath="//input[contains(@id,'EndAssignDate')]";
	String Menu_Launch_Xpath="//a[@aria-label='menu Launch']";
	String SubMenu_InteractionPortal_Xpath="//*[text()='Interaction Portal']";
	String RESEARCH_STATE_Xpath="//input[@title='Search state']";
	//String Btn_AddTask_Xpath="(//button[@title='Add Task'])[2]";
	String Btn_AddTask_Xpath="//button[contains(text(),'Add')]/descendant::u[text()='T']/ancestor::button";
	String Link_AddressChange_Xpath="//a[text()='Address change']";
	String Btn_AddTasks_Xpath="//button[text()='Add tasks']";
	//String Btn_AddTasks_Xpath="//textarea[contains(@name,'Dialog') and (@id='display1')]
	String Text_EditDialog_Id="display1";
	String Btn_Save="//button[text()='Save' and contains(@name,'Dialog')]/ancestor::span[1]";
	String Btn_Close_CN="iconClose";
	String Btn_CTSave="//button[text()='Save' and contains(@name,'CTSave')]";
	String IFrame0="PegaGadget0Ifr";
	String IFrame1="PegaGadget1Ifr";
	String IFrame2="PegaGadget2Ifr";
	String Btn_DeleteCoachingTip_Xpath="(//i[contains(@alt,'Delete Coaching Tip')])";//"(//i[contains(@class,'trash') and contains(@name,'CoachingTip')])";
	String Btn_DeleteAssignedCoachingTip_Xpath="(//i[contains(@class,'trash') and contains(@title,'Delete Association Tip')])";
	
	String CONTACTNOTE_XPATH = "//i[@title='Show contact notes']";
	
	String CLOSE_ACCOUNT_XPATH= "//a[contains(text(),'Close Account' )and @class='Add_task']";
	String MODIFY_CONTACT_LINKS_XPATH=	"//a[contains(text(),'Modify Contact Links') and @class='Add_task']";
	String DISPUTE_TRANSACTION_XPATH= "//a[contains(text(),'Dispute Transaction' )and @class='Add_task']";
	String LOST_OR_STOLEN_XPATH= "//a[contains(text(),'Lost or Stolen Card') and @class='Add_task']";
	String MODIFY_ACCOUNT_LINKS_XPATH= "//a[contains(text(),'Modify Account Links') and @class='Add_task']";
	String MODIFY_CONTACT_TO_ORG_LINKS_XPATH= "//a[contains(text(),'Modify Contact to Organization Links') and @class='Add_task']";
	String UPDATE_CONTACT_PROFILE_XPATH= "//a[contains(text(),'Update Contact Profile') and @class='Add_task']";
	String MODIFY_ORGANIZATION_LINKS_XPATH= "//a[contains(text(),'Modify Organization Links') and @class='Add_task']";
	String COMPLAINT_OR_COMPLIMENT_XPATH= "//a[contains(text(),'Complaint or Compliment' )and @class='Add_task']";
	String SEND_CORRESPONDENCE_XPATH= "//a[contains(text(),'Send Correspondence') and @class='Add_task']";
	String GENERAL_SERVICE_REQUEST_XPATH= "//a[contains(text(),'General Service Request') and @class='Add_task']";
	String MAKE_OFFER_XPATH= "//a[text()='Make offer' and @class='Add_task']";
	String OFFER_NEGOTIATOR_XPATH= "//a[text()='Offer negotiator' and @class='Add_task']";
	String ADD_NEW_ORGANIZATION_XPATH= "//a[contains(text(),'Add New Organization') and @class='Add_task']";
	String LOG_SALES_OPPORTUNITY_XPATH= "//a[text()='Log sales opportunity' and @class='Add_task']";
	String SCHEDULE_ACTIVITY_XPATH= "//a[contains(text(),'Schedule Activity') and @class='Add_task']";
	String OPEN_NEW_ACCOUNT_XPATH= "//a[contains(text(),'Open New Account') and @class='Add_task']";
	String SEARCH_INPUT_BOX_XPATH= "//input[@data-test-id='2015052704442407161656']";
	String ADD_TASKS_HEADER_XPATH= "//span[text()='Add Tasks']";
	String ACCOUNT_HEADER_XPATH= "//span[text()='Account']";
	String CONTACT_HEADER_XPATH= "//div[@class='layout layout-none']//span[text()='Contact']";
	String GENERAL_HEADER_XPATH= "//div[@class='layout layout-none']//span[text()='General']";
	String ADD_TASKS_BUTTON_XPATH= "//button[@title='Add Task' and text()='Add tasks']";
	String CANCEL_BUTTON_XPATH= "//button[@title='Cancel']";
	
	String ADDRESS_LINE1_XPATH= "//input[@data-test-id='2015052602433300441401' or @title='Enter address line1']";
	String ADDRESS_LINE2_XPATH= "//input[@data-test-id='2015052602433300462870' or @title='Enter address line 2']";
	String COUNTRY_CODE_XPATH="//select[@data-test-id='20151104070027020222217' or @title='Select country']";
	String POSTAL_CODE_XPATH= "//input[@data-test-id='2015052602510103723409' or @title='Enter Postal Code']";
	String CITY_XPATH= "//input[@data-test-id='2015052602510103701860' or @title='Enter City']";
	String HOME_PHONE_XPATH= "//input[@data-test-id='2015052602582605511213']"; 
	String CELL_PHONE_XPATH= "//input[@data-test-id='2015052602582605522350']";
	String FAX_XPATH= "//input[@data-test-id='2015052602582605533172']";
	String EMAIL_ID_XPATH= "//input[@data-test-id='2015052602582605554739']";
	String SELECT_ADDITIONAL_ACCOUNTS_XPATH= "//input[@title='Select All Additional Accounts']//parent::div[contains(@class,'cellIn')]";
	String SELECT_REASON_XPATH ="//select[@title='Select a Reason']";
	String TRANSACTION_CHEKBOX_XPATH = "//input[@title='Select statement']/following-sibling::label[1]";
	
	String DELIVERY_METHOD_DROPDOWN_XPATH= "//select[@data-test-id='2015050614281007181624']";
	String TYPE_DROPDOWN_XPATH="//select[@data-test-id='2015030914570607663709']";
	String ISSUE_DROPDOWN_XPATH="//select[@data-test-id='2015030914570607674620']";
	
	String NEW_CONTACT_PREFIX_XPATH= "//select[@data-test-id='2016083006123006123591']";
	String NEW_CONTACT_FIRST_NAME_XPATH= "//input[contains(@name,'FirstName')]";
	String NEW_CONTACT_LAST_NAME_XPATH= "//input[@data-test-id='201608300621560952518983' and contains(@name,'LastName')]";
	String NEW_CONTACT_PRIMARY_MAIL_ID_XPATH= "//input[@data-test-id='201704190553530597142991' and contains(@name,'PrimaryEmail')]";
	String YES_BUTTON_XPATH = "//button[contains(.,'Yes')]";
	void addTask();
	void launchAddressChange();
	void addressChange();
	void launchStatementCopy();
	void lauchStatementCopyFromSuggestions();
	void selectStatementForCopy();
	void statementFee();
	String StatementCopyID();
	void confirmStatementFlow();
	void statementCopy();
	void wrapUp();
	
	void selectReasonForDispute();
	void confirmDisputeDetails();
	String checkCaseStatus(String caseId);
	
	Wizard switchToFrame();
	void switchToDefault();
	void setDate(String dt);
	void setDates(String dt,By locator);
	void checkbox(String xpath);
	
	void scrollToBottomofpage();
	void addressChangeB2B(String changeAddressText , String emailId , String faxNo);
    void changeToDifferentAccoutn(String accountNo,String selectAccountNo);	
    
    String getChildText();
	void checkContactVerification();
	void contactVerificationWithTwoQuestions();
	void selectAccount();
	void launchUpdateContactProfile();
	void tabsCount();
	String tabName();
	void selectDropDownValue(String text);
	void profileSubmitButton();
	String getChildInteractionId();
	String getParentInteractionId();
	void completeWrapUpForInteractions(String text1, String text2);
	String getParentIDStatus(String parentid);
	String getChildStatusValue(String parentid);
	
	
	void changeToDifferentAccount(String accountNo,String selectAccountNo);	
	void clickTab(String tabText);
    String verifyBusinessUnitAddedToTask();
	List<String> verifyListOfTaskUnderBusinessUnit();
	void clickCloseButton();
	void dropDownValueSelect(String text);
	String getSecondValue();
	String addressChangeAndGetCaseID();
	String getSecondListValue();
	boolean verifyHomePage();
	Set<String> clickCompositeLink(String headerName);
	boolean switchToCompositeWindow(String headerName);
	String verifyCompositeWindowData();
	void windowClose();
	boolean switchToCompositeWindow(String header, By locator);
	void cancelWork();
	String verifyStatusForWork(String text,String verifyText);
	void refershExitInteraction(By xpathElement);
	void searchCustomerByName(String lastName);
	void searchCustomerByLastName(String lastName);
	void clickSearchButton();
	Map<String,String> verifySearchResult(PegaWebDriver webDriver);
	void selectCustomerStatement();
	void selectReasonForDispute(String reason);
	void selectDisputeTransaction(String tranName);
	void searchByCustomerNameAndAccountNo(String lastName, String accountNum);
	void selectCustomer();
	void selectBUCustomer();
	void contactVerification();
	void confirmAddressChange();
	void clickOnOtherActionsButton();
	void clickOnToolsMenuButton();
	void changeAddress();
	String verifyCompletedTask(String serviceProcess);
	void launchWrapup();
	void WrapUpInteraction();
	void completeWrapUp(String reason);
	void completeWrapUpWithoutReason();
	void completeChatWrapUpWithoutReason();
	String hoverOnCoachingTip();
	void changeAdditionalAddress();
	void confirmFlow();
	
	//Open New Account methods
	void selectAProduct(String category, String product, String owner);
	void enterAccountDetails();
	
	void launchCaseFromWorkbasket(String workBasket, String caseID);
	void launchServiceProcess(String serviceProcess);
	void confirmModifyBULinks();
	void addBUName(String name, String role);
	void updateBUCommDetails();
	void openAuthorizedContacts();
	void accountSelection(String acctNumber);
	void closeChildInteraction();
	
	void closeParentInteractions();
	void launchCaseFromInboundWorkbasket(String workBasket, String id);
	void selectInteraction(String contact);
	void launchSuggestedTask(String suggestedTask);
	void selectStatementForLostCard();
	void stolenCardAcknowledgement();
	void selectAddressForDelivery(String delivery);
	void closeAccount(String reason, String comment);
	void negotiateRetention();
	void removeItemFromOffer();
	void learnMoreAndAcceptOffer();
	void deferOffer();
	void declineOffer();
	void switchCase(String serviceProcess);
	void selectComplaint();
	void selectTypeAsIssueAs(String option, String type, String issueType);
	
	//void switchToInteraction(String interaction);
	void switchInteraction(String interaction);
	
	void launchDisputeTranFromLink(String transId);
	void cancelFlow();
	void submitCancelFlow();
	
	void lauchQuickWrap();
	
	//Driver Changes methods
	List<WebElement> noChoachingTips();
	String noDialog();
	void launchOffer(String suggestedOffer);
	void submitFlow();
	void searchCustomerByNameInbound(String lastName);
	
	//inbound
	void selectInboundCustomer();
	
	//create contact
	void launchCreateContactFlow();
	void launchChildInteraction();
	void launchChildInteraction(String contact);
	String getCaseID();
	void searchPreviousCaseId(String caseID);
	void contactVerificationWithOneQuestions();
	void contactVerificationWithQuestions();
	void verifyOptionsInToolsMenu();
	String getFutureDate();
	String getPastDate();
	void datePicker();
	void updateContactProfile(String DOB, String Gender, String status);
	void updatePrimaryAddressInContactProfile();
	void userSwitchToTab(String tab);
	void openNewAccountFlow(String category, String product, String owner);
	void sendCorrespondanceFlow(String mailID, String subject);
	void searchWithPreviousCaseId();
	void completeWrapUpbyRating(int arg1);
	void completeWrapUpbyreason(String reason);
	void verifyRecentInteractions();
	void selectSingleserviceprocess(String serviceProcess);
	void selectAddTask();
	void searchForServiceProcess(String serviceName);
	void clickOnSearchResult(String searchResult);
	void clickOnCollapseIcon();
	void AddtaskFromCollapse();
	void launchWrapupFromCollapse();
	void selectIncludeprospects();
	void deleteAccountAssociation(String orgName);
	void verifyRecentCases();
	void closeInteraction();
	void selectaccountfromaccountSummary(String AcNo);
	void clickAccountNumber();
	void upDateAddress(String AdLn1, String AdLn2, String PCode, String Phone);
	void verifytheStatusForTheCase(String Status);
	void selectCaseFromCasesWidget();
	void selectSubCaseFromTasks(String subCase);
	void selectIdentificationType(String method);
	void selectDistributionType(String method);
	void selectViewDetails();
	void enterResolveNotesandSubmit();
	void clickOnCasesButton();
	void selectDisputeTransactionwithOutsubmit(String tranName);
	void selectResolutionTypeforComplaint(String resolutionType);
	void selectWorkResolutionforScheduleActivity(String workResolution);
	void scheduleActivityAppointment(String type, String account, String topic, String assign, String operator);
	void scheduleActivityEscalate(String assign, String operator);
	void acceptOrDeclainOffer(String type);
	void switchtoTabforUser(String tabName);
	void addbundle();
	void clickOnActionButton(String bundleName);
	void selectOptionsUnderActionButton(String option, String bundleName);
	void selectbundlefromDuplicate(String mergeType, String bundleName);
	void scheduleAppointment(String subject);
	void confirmAppointment();
	void launchCaseUnderMyWorkbasket(String workBasket);
	void enterComments();
	void negotiateRetentionFlow(String reason, String provider, String rating);
	void recentCasesSearchWithCaseID(String Tab);
	void selectresultfromprospects(String username);
	void selectQuestionswithoutSubmit();
	void submitWithoutSelectingQuestions();
	void closeAccountwithcomment(String comment);
	void clickOnActionsitem(String buttonName);
	void exitInteractionwithcomment();
	void customerInquiry();
	void searchforRecentCasesinWidget();
	void filterinRecentCasesWidget(String status);
	void selectConfigTools();
	void selectTabAtConfigTools(String tabName);
	void deleteAllExistingDialogs();
	void configureNewDialog(String dialog);
	void updateDialog(String Dialog);
	void deleteAllExistingCoachingTips();
	void deleteAllAssignedCoachingTips();
	void createNewCoachingTips(String CoachingTipName, String CoachingTip);
	void assignCoachingTips(String CoachingTipName, String AssignTo, String AssignToValue, String FromDate,
			String ToDate);
	void updateCoachingTips(String CoachingTipName, String CoachingTip);
	void selectrequiredBU(String required);
	void confirmchange();
	void selectCustomerfromresult(String username);
	String getCaseIDunderToolsmenu();
	void ShowdataLink(String LinkName);
	void selectMultiDisputeTranxFromCasesWidget();
	void CaptureCallReasonAndPlaceCall(String reason, String status);
	void switchBetweenNewPhoneCallTabs(String tabName);
	void enterAnonymousFieldsAndSubmit(String type, String firstName, String lastName, String emailId);
	void validateFavorites(String contact);
	void reopenCase();
	
	
	void updateID(String source, String id);
	void createContactNote();
	void contactVerificationQuestions();
	void clickContactNotVerified();
	void contactVerificationQuesforServiceCases();
	void clickonContactNotVerified();
	void clickOtherActionsandByPassVerification();
	void enterReasonAndClickSubmitButton();
	void verifyByPassVerificationinHistory();
	//void validateStatusofCase();
	void contactVerificationQuestionsforInteractions();
	void validateSearchScreen();
	void clickonContactNotVerifiedForInteractions();
	void contactVerificationforContact();
	void verifyNoQuestionsAvailable();
	String getCaseDetails();
	void LaunchCaseFromMyCasesWidget();
	void LaunchCaseFromRecentWorkWidget();
	void completeAnonymouswrapup();

	
}
