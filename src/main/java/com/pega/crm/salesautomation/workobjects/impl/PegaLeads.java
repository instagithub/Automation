package com.pega.crm.salesautomation.workobjects.impl;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Activity;
import com.pega.crm.salesautomation.workobjects.Leads;
import com.pega.crm.salesautomation.workobjects.Tasks;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;

public class PegaLeads extends WizardImpl implements Leads
{
	
	public PegaLeads(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	String LEAD_SUBTABS_XPATH = "//div[@role='tab']//h2";



	@Override
	public void setStage(String StageName) 
	{
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.findSelectBox(By.id(LEAD_STAGE_ID)).selectByVisibleText(StageName);
	}

	@Override
	public void setLastName(String LastName) {

		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(LEAD_LASTNAME_ID)).sendKeys(LastName);
	}

	@Override
	public void setCompany(String Company) 
	{
		pegaDriver.findElement(By.id(LEAD_COMPANY_ID)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.findElement(By.id(LEAD_COMPANY_ID)).sendKeys(Company);

	}

	@Override
	public void setIndustry(String Industry) 
	{
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.xpath(LEAD_INDUSTRY_XPATH)).selectByVisibleText(Industry);

	}
	
	@Override
	public void setTerritory(String str) {
		pegaDriver.getActiveFrameId(true);
		PegaUtil.autoComplete(pegaDriver,LEAD_TERRIOTRY_ID, str);
		
	}

	@Override
	public void clickOK() {
		
	
		PegaUtil.clickCreate(pegaDriver);
		

	}

	@Override
	public String getLastName() 
	{
		pegaDriver.getActiveFrameId(true);
		String name=pegaDriver.findElement(By.xpath(LEAD_NAME_VALUE_XPATH)).getText();
		return name;
	}
	
	@Override
	public String getLastNameForIndividual() {
		pegaDriver.getActiveFrameId(true);
		String name=pegaDriver.findElement(By.xpath(LEAD_NAME_INDIVIDUAL_VALUE_XPATH)).getText();
		return name;
	}

	@Override
	public void clickEdit() {
		pegaDriver.getActiveFrameId(true);
		PegaUtil.clickEdit(pegaDriver);
	}

	@Override
	public void clickSubmit() {
		PegaUtil.clickSubmit(pegaDriver);

	}

	@Override
	public String getStage() {
		pegaDriver.getActiveFrameId(true);
		String stage=pegaDriver.findElement(By.xpath(LEAD_STAGE_VALUE_XPATH)).getText();
		return stage;
	}

	@Override
	public String getCompany() {
		pegaDriver.getActiveFrameId(true);
		String company=pegaDriver.findElement(By.xpath(LEAD_COMPANY_VALUE_XPATH)).getText();
		return company;
	}

	@Override
	public String getIndustry() {
		String industry=pegaDriver.findElement(By.xpath(LEAD_INDUSTRY_VALUE_XPATH)).getText();
		return industry;
	}

	@Override
	public void closeLead() {
		pegaDriver.findElement(By.xpath(LEAD_CLOSE_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(PegaUtil.OPP_NEXTYEAR_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(LEAD_CLOSE_DATE_XPATH)).click();

	}

	@Override
	public void closeCommentLead() 
	{
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id("CloseComments")).sendKeys("Closed as part of autoamtion");
		//pegaDriver.findElement(By.id("submitButton")).click();
		PegaUtil.clickSubmit(pegaDriver);

	}

	@Override
	public String closeLeadAssert()
	{
		pegaDriver.getActiveFrameId(true);
		String Stage=pegaDriver.findElement(By.xpath(LEAD_CLOSE_ASSERT_XPATH)).getText();
		return Stage;

	}

	@Override
	public void clickClone()
	{
		pegaDriver.getActiveFrameId(true);
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Clone lead");

	}

	@Override
	public void setWorkPhone(String WorkPhone) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(LEAD_WORK_PHONE_ID)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.findElement(By.id(LEAD_WORK_PHONE_ID)).sendKeys(WorkPhone);

	}


	@Override
	public void setEmail(String Email) {
		pegaDriver.waitForDocStateReady(true);
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(LEAD_EMAIL_ID)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.findElement(By.id(LEAD_EMAIL_ID)).sendKeys(Email);

	}

	@Override
	public void setLeadFirstName(String FirstName) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(LEAD_FIRSTNAME)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.findElement(By.id(LEAD_FIRSTNAME)).sendKeys(FirstName);

	}

	@Override
	public void setLeadMobile(String Mobile) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(LEAD_MOBILE)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.findElement(By.id(LEAD_MOBILE)).sendKeys(Mobile);

	}

	@Override
	public void setLeadDesc(String Desc) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(LEAD_DESC)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.findElement(By.id(LEAD_DESC)).sendKeys(Desc);

	}

	@Override
	public String getWorkPhone() {
		pegaDriver.getActiveFrameId(true);
		String workPhone=pegaDriver.findElement(By.xpath(XPATH_WORKPHONE)).getText();

		return workPhone;
	}

	@Override
	public String getEMail() {
		pegaDriver.getActiveFrameId(true);
		String email=pegaDriver.findElement(By.xpath(XPATH_EMAIL)).getText();
		return email;
	}

	@Override
	public String getFirstName() {
		pegaDriver.getActiveFrameId(true);
		String firstName=pegaDriver.findElement(By.xpath(XPATH_FIRSTNAME)).getText();
		return firstName;
	}

	@Override
	public String getMobile() {
		pegaDriver.getActiveFrameId(true);
		String mobile=pegaDriver.findElement(By.xpath(XPATH_Mobile)).getText();
		return mobile;
	}

	@Override
	public String getDescription() {
		pegaDriver.getActiveFrameId(true);
		String desc=pegaDriver.findElement(By.xpath(XPATH_Description)).getText();
		return desc;
	}

	@Override
	public void setEmailBusiness(String Email) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(LEAD_EMAIL_ID)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.findElement(By.id(LEAD_EMAIL_ID)).sendKeys(Email);

		
	}

	@Override
	public String getEmailBusiness() {
		pegaDriver.getActiveFrameId(true);
		String email=pegaDriver.findElement(By.xpath(XPATH_EMAIL_BUSINESS)).getText();
		return email;
	}

	@Override
	public void clickClose() 
	{
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Close");
	}


	@Override
	public String getContact() {
		String contact=pegaDriver.findElement(By.xpath(CONTACT_VALUE_XPATH)).getText().trim();
		return contact;
	}

@Override
	public void clickChangeOwner() {
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Change owner" );
		
	}


	@Override
	public String getSectionHeader() {
		pegaDriver.getActiveFrameId(true);
		String ownerHeader=pegaDriver.findElement(By.xpath(LEAD_SECTION_VALUE_XPATH)).getText();
		return ownerHeader;
	}


	@Override
	public void setOwner(String LEAD_UPDATEDOWNER) {
		pegaDriver.getActiveFrameId(true);
		/*pegaDriver.findElement(By.xpath(LEAD_SWITCH_TO_EDIT_MODE_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		*/
		pegaDriver.findElement(By.id(LEAD_CHANGEOWNER_ID)).sendKeys(PegaUtil.SelectAll);
		PegaUtil.autoComplete(pegaDriver, LEAD_CHANGEOWNER_ID, LEAD_UPDATEDOWNER);
		
	}


	@Override
	public void setReason(String CHANGEREASON) {
		pegaDriver.findElement(By.id(LEAD_CHANGEREASON_ID)).sendKeys(CHANGEREASON);
		
	}


	@Override
	public void clickSubmitButton() {
		PegaUtil.clickSubmit(pegaDriver);
		
	}


	@Override
	public String getOwner() {
		pegaDriver.getActiveFrameId(true);
		String owner=pegaDriver.findElement(By.xpath(LEAD_OWNER_VALUE_XPATH)).getText().trim();
		return owner;
	}


	@Override
	public void getActivitiesSubTab() {
		PegaUtil.getSubTab(pegaDriver, "Activities");
		
	}


	@Override
	public List<String> getTaskValues(String LeadName) {
		//pegaDriver.findElement(By.xpath(LEAD_TASK_REFRESH_XPATH)).scrollIntoView();
		pegaDriver.findElement(By.xpath(LEAD_TASK_REFRESH_XPATH)).click();
		
		return(PegaUtil.getRowValues(pegaDriver, LEAD_TASK_ROW_IDENTIFIER_XPATH, LeadName));
	}


	@Override
	public Tasks clickAddTask() {
		return(PegaUtil.addTask(pegaDriver));
	}


	@Override
	public Activity clickAddActivity() {
		return(PegaUtil.addActivity(pegaDriver));
	}


	@Override
	public List<String> getActivityValues(String ActivityName) {
		
		//pegaDriver.findElement(By.xpath(PegaUtil.ACTIVITY_REFRESH_XPATH)).scrollIntoView();
		pegaDriver.findElement(By.xpath(PegaUtil.ACTIVITY_REFRESH_XPATH)).click();

		return(PegaUtil.getRowValues(pegaDriver, LEAD_ACTIVITY_ROW_IDENTIFIER_XPATH, ActivityName));
	}


	@Override
	public void setContact(String ContactName) {
		
		PegaUtil.autoComplete(pegaDriver, LEAD_CONTACT_ID, ContactName);
		
	}


	@Override
	public String getCreatedDate() {
		pegaDriver.getActiveFrameId(true);

		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		String details_xpath="//div[@aria-label='Details']";
				
		wizard.findElement(By.xpath(details_xpath)).scrollIntoView();
		
		pegaDriver.findElement(By.xpath(details_xpath)).click();
		
		pegaDriver.getActiveFrameId(true);
		wizard.findElement(By.xpath(TECHINICAL_INFORMATION)).scrollIntoView();
		
		pegaDriver.findElement(By.xpath(TECHINICAL_INFORMATION)).click();
		pegaDriver.getActiveFrameId(true);
		String LEAD_CREATED_DATE_XPATH="//*[text()='Created on']/../div/span";
		return (pegaDriver.findElement(By.xpath(LEAD_CREATED_DATE_XPATH)).getText());
	}


	@Override
	public void navigateToLeadFromBreadCrumb() {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//a[@class='Breadcrumbs']")).click();
		
	}
	
	@Override
	public ArrayList<String> getSubTabs() {
		ArrayList<String> s= new ArrayList<String>();
		List<WebElement> wb=pegaDriver.findElements(By.xpath(LEAD_SUBTABS_XPATH));
		
		for(WebElement w:wb)
		{
			String s1=w.getText();
			s.add(s1);
		}
		System.out.println(s.size());
		return s;
	}


	
	

}
