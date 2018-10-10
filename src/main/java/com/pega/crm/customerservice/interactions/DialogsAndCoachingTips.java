package com.pega.crm.customerservice.interactions;

import com.pega.ri.Wizard;

public interface DialogsAndCoachingTips extends Wizard{
	String ToolsMenu_Xpath="//button[@title='Tools Menu' or @title='Tools menu']";
	String ConfigurationTools_Xpath="//span[text()='Configuration tools']/ancestor::span[1]";
	String Tab_Dialogs_Xpath="(//h3[text()='Dialogs'])[2]";
	String Tab_CoachingTips_Xpath="//h3[text()='Coaching tips']";
	String Link_AddNew_Xpath="(//a[contains(text(),'Add new')])[1]";
	String Link_AddNewCoachingTip_Xpath="//a[contains(@name,'AddCoachingTip')]";
	String DDL_When_Xpath="//label[contains(text(),'When')]/following-sibling::div/descendant::select[1]";
	String Btn_EditDialog_Xpath="//i[contains(@class,'pencil') and contains(@name,'Dialog')]/ancestor::span[1]";
	String Btn_DeleteDialog_Xpath="//i[contains(@class,'trash') and contains(@name,'Dialog')]/ancestor::span[1]";
	String Txt_Dialog_Xpath="//label[contains(text(),'Dialog')]/following-sibling::div/div";
	String DDL_ReferTo_Xpath="//label[contains(text(),'Refer to')]/following-sibling::div/descendant::select[1]";
	String DDL_Attribute_Xpath="//label[contains(text(),'Attribute')]/following-sibling::div/descendant::select[1]";
	String Txt_EnterName_Xpath="//input[contains(@placeholder,'<Enter Name>')]";
	String Txt_EnterCoachingTip_Xpath="//input[contains(@placeholder,'<Enter Coaching Tip>')]";
	String Tab_Assign_Xpath="//h2[contains(text(),'Assign')]";
	String Link_AssignTip_Xpath="//a[contains(@title,'Assign Tip')]";
	String DDL_CoachingTip_Id="CoachingTip";
	String DDL_AssignTo_Id="EntityType";
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
	String Btn_Accept="//button[text()='Accept']";
	void ConfigureCoachingTip();
	void UnlockRuleSet(String RuleSetName, String RulesetVersion);
	void ConfigDialog();
	void selectConfigTools();
}
