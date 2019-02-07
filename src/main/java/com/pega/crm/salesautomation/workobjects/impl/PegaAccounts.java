
package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.crm.salesautomation.workobjects.Accounts;
import com.pega.crm.salesautomation.workobjects.Activity;
import com.pega.crm.salesautomation.workobjects.Opportunities;
import com.pega.crm.salesautomation.workobjects.Relationship;
import com.pega.crm.salesautomation.workobjects.Tasks;
import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;




public class PegaAccounts extends WizardImpl implements Accounts{
	//String ACC_TASK_REFRESH_XPATH = "//button[contains(@name, 'crmTasks')][text()='Refresh']";
	
	String ACC_ADD_INDOPPTY = "//*[@data-test-id='2015061908563207831294']";
	String ACC_TERRITORY_VALUE_XPATH = "//span[text()='Territory']/..//div";
	String ACC_INDUSTRY_VALUE_XPATH = "//span[text()='Industry']/..//div";
	String ACC_EMPLOYEES_VALUE_XPATH = "//span[text()='Employees']/..//div";
	String ACC_TICKER_VALUE_XPATH = "//span[text()='Ticker symbol']/..//div";
	String ACC_REVENUE_VALUE_XPATH = "//*[@data-test-id='20141204045038028826931']"; 
	String ACC_DESCRIPTION_VALUE_XPATH = "//span[text()='Description']/..//div";
	String ACC_ACCOUNT_PAGE_HEADER_XPATH="//*[text()='Business Account']";
	String ACC_NAME_ID="//input[@data-test-id='20141204045038027511854']";
	String ACC_TERRIORTY_ID="crmTerritorySearch";
	String ACC_ORG_ID="crmSearchOrg";
	String ACC_DESCRIPTION_ID="pyDescription";
	String ACC_INDUSTRY_XPATH="//select[contains(@id, 'Industry')]";
	String ACC_PHONENUMBER_ID="PhoneNumber";
	String ACC_CREATE_XPATH=PegaUtil.getStrongButtonXPath("Create");
	String ACC_WEBSITE_ID="Website";
	String ACC_TICKER_ID= "Ticker";
	String ACC_REVENUE_ID ="Revenue";
	String ACC_EMPLOYEES_ID= "EmployeeCount";
	
	String ACC_CLOSE_HEADER_XPATH="//span[@class='assignment_title']";
	String ACC_CHANGEOWNER_HEADER_XPATH="//span[@class='assignment_title']";
	String ACC_SECTION_HEADER_XPATH="//span[@class = 'assignment_title']";
	String ACC_OWNER_ID="crmSearchOwner";
	String ACC_CHANGEREASON_ID="ChangeReason";
	String ACC_OWNER_VALUE_XPATH="//span[text()='Owner']/..//div";	
	//String ACC_CLOSE_HEADER_XPATH="//*[@class='dataValueRead']//label";
	String ACC_COMMENTS_ID="CloseComments";
	//String ACC_OK_BUTTON_XPATH="//button[contains(@data-click,'doFormSubmit')]//*[text()='OK']";
	String ACC_NAME_VALUE_XPATH="//span[text()='Name']/../../div/span";
	String ACC_PHONENUMBER_VALUE_XPATH="//*[text()='Phone number']/..//div/span";
	String ACC_ORGANIZATION_VALUE_XPATH = "//span[text()='Organization']/..//a";
	
	String ACC_FOLLOW_XPATH=PegaUtil.getButtonXpath("Follow");
	String ACC_FOLLOWSCROLLING_XPATH = "//div[contains(@param_name,'Favorites')]//a";
	String ACC_FOLLOWTESTING_XPATH = "//div[contains(@param_name,'Favorites')]//a";
	String ACC_UNFOLLOW_XPATH=PegaUtil.getButtonXpath("Unfollow");
	
	String defaultOrg = "//label[@for='Name']/following-sibling::div/span/a";
	String ACC_TASK_ROW_IDENTIFIER_XPATH= "//tr[contains(@oaargs, 'WORK-TASK')]";
	String LEAD_ROWS_XPATH="//tr[contains(@oaargs, 'UPLUS-SAPLUS-WORK-LEAD')]";
	String ACC_FOLLOWERS_XPATH="//*[@data-layout-id='201803010631100623']";
	String ACC_FOLLOWER_ROW_IDENTIFIER_XPATH="//*[@data-test-id = '201710100436480270133']";
	String ACC_CONTACT_ROW_IDENTIFIER_XPATH="//tr[contains(@oaargs, 'UPLUS-SAPLUS-LINK-ENTITY-C2A')]";
	public String WO_NAME=null;
	String ACC_SUBTABS_XPATH = "//div[@role='tab']//h2";
	
	
	public PegaAccounts(WebElement elmt, String elmtId) 
	{
		super(elmt, elmtId);
	}
	
	
	@Override
	public void setAccountName(StringBuffer accountName) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(ACC_NAME_ID)).sendKeys(accountName);
	}

	@Override
	public void setTerritory(String TerritoryName) 
	{
		
		PegaUtil.autoComplete(pegaDriver, ACC_TERRIORTY_ID, TerritoryName);
		
	}

	@Override
	public void setOrganization(String OrganizationName) 
	{
		PegaUtil.autoComplete(pegaDriver, ACC_ORG_ID, OrganizationName);
	}

	@Override
	public void setIndustry(String IndustryName) {
		pegaDriver.findSelectBox(By.xpath(ACC_INDUSTRY_XPATH)).selectByVisibleText(IndustryName);
		
	}
	public void setPhoneNumber(String PhoneNumber)
	{
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(ACC_PHONENUMBER_ID)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.findElement(By.id(ACC_PHONENUMBER_ID)).sendKeys(PhoneNumber);
	}
	@Override
	public void setDescription(String Description) {
		pegaDriver.findElement(By.id(ACC_DESCRIPTION_ID)).sendKeys(Description);
		
	}

	@Override
	public String getAccountPageHeader() {
		pegaDriver.getActiveFrameId(true);
		String accHeader=pegaDriver.findElement(By.xpath(ACC_ACCOUNT_PAGE_HEADER_XPATH)).getText();
		return accHeader;
	}

	@Override
	public void clickCreate() 
	{
		PegaUtil.clickCreate(pegaDriver);
		
	}
	public void clickEdit()
	{
		PegaUtil.clickEdit(pegaDriver);
	}
	public void clickSubmit()
	{
		
		pegaDriver.getActiveFrameId(true);
		PegaUtil.clickSubmit(pegaDriver);
		
		//pegaDriver.findElement(By.id(ACC_SUBMIT_ID)).click();
	}
	@Override
	public String getAccountName() {
		pegaDriver.getActiveFrameId(true);
		String accName=pegaDriver.findElement(By.xpath(ACC_NAME_VALUE_XPATH)).getText();
		return accName;
		
	}

	@Override
	public Boolean isNameEnabled()
	{
		pegaDriver.getActiveFrameId(true);
		Boolean bool= pegaDriver.findElement(By.xpath(ACC_NAME_ID)).isEnabled();
		return bool;
		
	}

	@Override
	public Boolean isPhoneNumberEnabled() {
		Boolean bool= pegaDriver.findElement(By.id(ACC_PHONENUMBER_ID)).isEnabled();
		return bool;
	}

	@Override
	public Boolean isCityEnabled() {
		Boolean bool= pegaDriver.findElement(By.xpath("//*[contains(@id,'"+PegaUtil.CITY_ID+"')]")).isEnabled();
		return bool;
		
	}

	@Override
	public String getPhoneNumber() {
		pegaDriver.getActiveFrameId(true);
		String phone=pegaDriver.findElement(By.xpath(ACC_PHONENUMBER_VALUE_XPATH)).getText();
		return phone;
	}

	@Override
	public void clickChangeOwner() {
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Change owner");
		
	}

	@Override
	public String getChangeOwnerHeader() {
		pegaDriver.getActiveFrameId(true);
		String header=pegaDriver.findElement(By.xpath(ACC_CHANGEOWNER_HEADER_XPATH)).getText();
		return header;
	}
	
	public void setOwner(String ownerName)
	{
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement(By.id(ACC_OWNER_ID)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.waitForDocStateReady(1);
		PegaUtil.autoComplete(pegaDriver, ACC_OWNER_ID, ownerName);
	}
	
	public void setReason(String reason)
	{
		pegaDriver.findElement(By.id(ACC_CHANGEREASON_ID)).sendKeys(reason);
	}

	@Override
	public String getOwner() {
		pegaDriver.getActiveFrameId(true);
		String owner=pegaDriver.findElement(By.xpath(ACC_OWNER_VALUE_XPATH)).getText();
		return owner;
	}

	@Override
	public void clickClose() {
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Close");	
	}

	@Override
	public String getCloseOwnerHeader() {
		pegaDriver.getActiveFrameId(true);
		String close=pegaDriver.findElement(By.xpath(ACC_CLOSE_HEADER_XPATH)).getText();
		return close;
	}
	public void setCloseComments(String comments)
	{
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(ACC_COMMENTS_ID)).sendKeys(comments);
	}

	@Override
	public boolean isActionItemValuePresent(String dropDownValue) {
		return(PegaUtil.isActionItemValuePresent(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, dropDownValue));
	}

	@Override
	public void setAddress() {
		PegaUtil.setAddress(pegaDriver);
	}
	
	public void clickFollow()
	{
		pegaDriver.findElement(By.xpath(ACC_FOLLOW_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
	}
	public void clickUnFollow()
	{
		if(pegaDriver.verifyElement(By.xpath(ACC_UNFOLLOW_XPATH)))
			pegaDriver.findElement(By.xpath(ACC_UNFOLLOW_XPATH)).click();
		else
		{
			clickFollow();
			pegaDriver.getActiveFrameId(true);
			pegaDriver.waitForDocStateReady(4);
			pegaDriver.findElement(By.xpath(ACC_UNFOLLOW_XPATH)).click();
		}
			
		pegaDriver.waitForDocStateReady(2);
	}
	
	@Override
	public String getFollowedWOName() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.navigate().refresh();
		String followedItems = pegaDriver.findElement(By.xpath(ACC_FOLLOWTESTING_XPATH)).getText();
		return followedItems;	
	}

	@Override
	public Boolean isFollowingListEmpty() 
	{
		pegaDriver.switchTo().defaultContent();
		//findElement(By.xpath(ACC_FOLLOWSCROLLING_XPATH)).scrollIntoView();
		return(PegaUtil.isListEmpty(pegaDriver));
	}


	@Override
	public void setWebSite(String website) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(ACC_WEBSITE_ID)).sendKeys(website);
		
	}

	
	@Override
	public void setEmployees(String employees) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(ACC_EMPLOYEES_ID)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.findElement(By.id(ACC_EMPLOYEES_ID)).sendKeys(employees);
	}


	@Override
	public void setTickerSymbol(String ticker) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(ACC_TICKER_ID)).sendKeys(ticker);
	}


	@Override
	public void setRevenue(String revenue) {
		
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(ACC_REVENUE_ID)).sendKeys(revenue);
		
	}


	@Override
	public String getOrganization() {
		
		pegaDriver.getActiveFrameId(true);
		String org=pegaDriver.findElement(By.xpath(ACC_ORGANIZATION_VALUE_XPATH)).getText();
		return org;
	}


	@Override
	public String getTerritory() {
		pegaDriver.getActiveFrameId(true);
		String territory=pegaDriver.findElement(By.xpath(ACC_TERRITORY_VALUE_XPATH)).getText();
		return territory;
	}


	@Override
	public String getIndustry() {
		pegaDriver.getActiveFrameId(true);
		String industry=pegaDriver.findElement(By.xpath(ACC_INDUSTRY_VALUE_XPATH)).getText();
		return industry;
	}


	@Override
	public String getEmployees() {
		pegaDriver.getActiveFrameId(true);
		String industry=pegaDriver.findElement(By.xpath(ACC_EMPLOYEES_VALUE_XPATH)).getText();
		return industry;
	}


	@Override
	public String getTicker() {
		pegaDriver.getActiveFrameId(true);
		String ticker=pegaDriver.findElement(By.xpath(ACC_TICKER_VALUE_XPATH)).getText();
		return ticker;
	}


	@Override
	public String getRevenue() {
		String revenueFormat=null;
		String revenue=pegaDriver.findElement(By.xpath(ACC_REVENUE_VALUE_XPATH)).getText();
		revenue = revenue.replaceAll("[^0-9.]", "");
		return revenue;
	}


	@Override
	public String getDescription() {
		pegaDriver.getActiveFrameId(true);
		String desc=pegaDriver.findElement(By.xpath(ACC_DESCRIPTION_VALUE_XPATH)).getText();
		return desc;
	}


	@Override
	public String getdefaultOrg() {
		
		pegaDriver.getActiveFrameId(true);
		String desc;
		//if(pegaDriver.verifyElement(By.xpath(defaultOrg)))
		desc= pegaDriver.findElement(By.xpath(defaultOrg)).getText().trim();
		return desc;
		
	}

	@Override
	public void clickOrgLink() {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//span[@class='field-caption dataLabelForRead' and text()='Organization']/following-sibling::div/span/a")).click();
	}


	@Override
	public Opportunities addOpportunity() {
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		if(pegaDriver.verifyElement(By.xpath(ACTION_BUTTON_XPATH))) {
			PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Add opportunity");
		} else {
			pegaDriver.getActiveFrameId(true);
			pegaDriver.findElement(By.xpath("//div[@class='header']//h2[contains(text(),'Opportunities')]")).click();
			pegaDriver.getActiveFrameId(true);
			pegaDriver.findElement(By.xpath(ACC_ADD_INDOPPTY)).click();
			
		}
		
				
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Opportunities newOppty= new PegaOpportunity(framElmt, frameId);
		newOppty._setEnvironment(testEnv, frameId);
		return newOppty;
	}


	@Override
	public void navigateToTab(String tabName) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//div[@class='header']//h2[contains(text(),'"+tabName+"')]")).click();
		
		
	}



	
	@Override
	public Tasks addTask() {
		return(PegaUtil.addTask(pegaDriver));
		
	}


	@Override
	public void getActivitiesSubTab() {
		PegaUtil.getSubTab(pegaDriver, "Activities");
		
	}


	@Override
	public List<String> getTaskValues(String taskSubject) {
		findElement(By.xpath(PegaUtil.TASK_REFRESH_XPATH)).scrollIntoView();
		pegaDriver.findElement(By.xpath(PegaUtil.TASK_REFRESH_XPATH)).click();
		return(PegaUtil.getRowValues(pegaDriver, ACC_TASK_ROW_IDENTIFIER_XPATH, taskSubject));
	}


	@Override
	public Activity addActivity() {
PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Add activity");
		
		//pegaDriver.findElement(By.xpath("//div[@string_type='field']//button[text()='Actions ']")).click();
		
		//String frameId = pegaDriver.getActiveFrameId(false);
		//PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		//pegaDriver.switchTo().frame(frameId);
		
		//pegaDriver.findElement(By.xpath("//li[@role='presentation']//span[text()='Add activity']")).click();
				
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Activity ActivityDetails = new PegaActivity(framElmt, frameId);
		ActivityDetails._setEnvironment(testEnv, frameId);
		return ActivityDetails;	
	}
	
	@Override
	public boolean validateAccOpportunities(String opptyName,
			String opptyStage, String opptyCloseReason, String opptyOwner,
			String opptyAmount,String oppCloseDate, String opptyMustWin, String opptyTerritory) {
		
		
		pegaDriver.getActiveFrameId(true);
		
		List<WebElement> AccOpptys;
		AccOpptys = pegaDriver.findElements(By.xpath("//table[contains(@pl_prop_class,'PegaCRM-Work-SFA-Opportunity')]//tr[contains(@oaargs,'UPLUS-SAPLUS-WORK-OPPORTUNITY')]"));
		//AccOpptys = pegaDriver.findElements(By.xpath("//*[@data-test-id='20150105032822096321935']"));
		
		int rows = AccOpptys.size();
		WebElement RowData;
		
		for (int i = 1;i<=rows;i++)
			{
			//RowData = pegaDriver.findElement(By.xpath()); pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i+1)+"']"));
			pegaDriver.getActiveFrameId(true);
			
			if(opptyName.equals(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop_class,'PegaCRM-Work-SFA-Opportunity')]//tr[@pl_index='"+(i)+"']//a[contains(@data-test-id,'20150105032822096321935')]")).getAttribute("text").trim()))
				{	
			    	
					if(opptyOwner.contains(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop_class,'PegaCRM-Work-SFA-Opportunity')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Owner']//div")).getAttribute("text").trim()) && 
					opptyAmount.contains((pegaDriver.findElement(By.xpath("//table[contains(@pl_prop_class,'PegaCRM-Work-SFA-Opportunity')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Amount']//div")).getAttribute("text").trim()).replaceAll("[^0-9.]","")) &&
					opptyTerritory.equals(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop_class,'PegaCRM-Work-SFA-Opportunity')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Territory']//div")).getAttribute("text").trim()))
						
					return true;
				}
			}
		return false;
		}


	@Override
	public boolean validateAccActivities(String Subject,
			String CommunicationType, String actDate, String CompletedBy) {
		
		
	
	pegaDriver.getActiveFrameId(true);
		
		List<WebElement> OrgActivities;
		OrgActivities = pegaDriver.findElements(By.xpath("//table[contains(@pl_prop,'crmActivities')]/tbody/tr[contains(@class,'Row')]"));
		int rows = OrgActivities.size();
		WebElement RowData;
		
		for (int i = 0;i<rows;i++)
			{
				RowData = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"+(i+1)+"']"));
				if(Subject.equals(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"+(i+1)+"']//a[@title='Click to Open the Related Task']")).getAttribute("text").trim()))
				{
					/*System.out.println(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"+(i+1)+"']//td[@data-attribute-name='Communication type']//div")).getAttribute("text").trim());
					System.out.println(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"+(i+1)+"']//td[@data-attribute-name='Date']//span")).getAttribute("text").trim());
					System.out.println(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"+(i+1)+"']//td[@data-attribute-name='Completed by']//span")).getAttribute("text").trim());
					System.out.println(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a5']//span//a")).getAttribute("text").trim());
					System.out.println(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a6']//span")).getAttribute("text").trim());*/
					
					if(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"+(i+1)+"']//td[@data-attribute-name='Communication type']//div")).getAttribute("text").trim().contains(CommunicationType) &&
					actDate.equals(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"+(i+1)+"']//td[@data-attribute-name='Date']//span")).getAttribute("text").trim()) && 
					CompletedBy.equals(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"+(i+1)+"']//td[@data-attribute-name='Completed by']//span")).getAttribute("text").trim()))
					//RelatedTo.equals(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a5']//span//a")).getAttribute("text").trim()) &&
					//RelatedType.equals(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'crmActivities')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a5']//span")).getAttribute("text").trim())
					return true;
									
				}
			}
		return false;
	
	}


	@Override
	public void getLeadSubTab() {
		PegaUtil.getSubTab(pegaDriver, "Leads");
		//PegaUtil.clickRefresh(pegaDriver,"Leads");
	}


	@Override
	public List<String> getLeadRowValues(String leadName) {
		//PegaUtil.clickRefresh(pegaDriver);
		return (PegaUtil.getRowValues(pegaDriver, LEAD_ROWS_XPATH, leadName));
	}


	@Override
	public void getSalesTeamSubTab() {	
		//PegaUtil.getSubTab(pegaDriver, "Sales team");
		pegaDriver.getActiveFrameId(true);
		//pegaDriver.findElement(By.xpath(ACC_FOLLOWERS_XPATH)).click();
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
	    wizard.findElement(By.xpath(ACC_FOLLOWERS_XPATH)).scrollIntoView();	
	}
	
	@Override
	public void refresh() {
		PegaUtil.refresh(pegaDriver);
	}

	@Override
	public boolean isAccountFollowed() {
		pegaDriver.getActiveFrameId(true);
		return(pegaDriver.verifyElement(By.xpath(ACC_FOLLOW_XPATH)));
		
	}


	@Override
	public List<String> getFollowers(String Follower) {
		
		List<String> ColumnValues= new ArrayList<String>();
		List<WebElement> followedItems = pegaDriver.findElements(By.xpath(ACC_FOLLOWER_ROW_IDENTIFIER_XPATH));
		for(WebElement w : followedItems) {
			ColumnValues.add(w.getText());
		}
		return ColumnValues;
	}


	@Override
	public Relationship clickContact() {
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Add contact");
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relation = new PegaRelationship(framElmt, frameId);
		relation._setEnvironment(testEnv, frameId);
		return relation;
	}


	@Override
	public void getContactSubTab() {
		PegaUtil.getSubTab(pegaDriver, "Contacts");
		//PegaUtil.clickRefresh(pegaDriver,"Contact");
	}


	@Override
	public List<String> getContactValues(String contactRelationship) {
		
		return(PegaUtil.getRowValues(pegaDriver, ACC_CONTACT_ROW_IDENTIFIER_XPATH, contactRelationship));
	}


	@Override
	public ArrayList<String> getSubTabs() {
		ArrayList<String> s= new ArrayList<String>();
		List<WebElement> wb=pegaDriver.findElements(By.xpath(ACC_SUBTABS_XPATH));
		
		for(WebElement w:wb)
		{
			String s1=w.getText();
			s.add(s1);
		}
		System.out.println(s.size());
		return s;
	}
	}