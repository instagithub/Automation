package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Contacts;
import com.pega.crm.salesautomation.workobjects.Households;
import com.pega.crm.salesautomation.workobjects.Leads;
import com.pega.crm.salesautomation.workobjects.Opportunities;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;


public class PegaContact extends WizardImpl implements Contacts
{
	
	public PegaContact(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}
	
	String CON_SUBTABS_XPATH = "//div[@role='tab']//h2"; 
	
	public void setFirstName(StringBuffer FirstName)
	{
		  
		 findElement(By.id(CONT_FIRSTNAME_ID)).sendKeys(FirstName);
		 findElement(By.id(CONT_FIRSTNAME_ID)).sendKeys(Keys.TAB);
		
	}

	@Override
	public void setLastName(StringBuffer str) {
		
		 findElement(By.xpath(CONT_LASTNAME_XPATH)).click();
		  
		 findElement(By.xpath(CONT_LASTNAME_XPATH)).sendKeys(str);
		 findElement(By.xpath(CONT_LASTNAME_XPATH)).sendKeys(Keys.TAB);
	}

	@Override
	public void setOrganization(String str) {
		//  
		 findElement(By.id(CONT_ORG_ID)).click(false);
		PegaUtil.autoComplete(pegaDriver, CONT_ORG_ID, str);
		
	}

	@Override
	public void setSalutation(String str) {
		  
		 findSelectBox(By.xpath(CONT_SALUTATION_XPATH)).selectByVisibleText(str);
		
	}

	public void setCompany(String str) {
		  
		 findElement(By.xpath(CONT_LASTNAME_XPATH)).sendKeys(str);
		
	}

	@Override
	public void setDepartment(String str) {
		  
		 findElement(By.id(CONT_DEPARTMENT_ID)).sendKeys(str);
		
	}

	@Override
	public void setInfluence(String str) {
		  
		 findSelectBox(By.xpath(CONT_INFLUENCE_XPATH)).selectByVisibleText(str);
		
	}

	@Override
	public void setFavorability(String str) {
		  
		 findSelectBox(By.xpath(CONT_FAVORABILITY_XPATH)).selectByVisibleText(str);
		
	}
	
	@Override
	public void setWorkPhone(String str) {
		  
		 findElement(By.id(CONT_WORKPHONE_ID)).sendKeys(str);
		
	}

	@Override
	public void setWorkEmail(String str) {
		  
		 findElement(By.id(CONT_WORKEMAIL_ID)).sendKeys(str);
		
	}

	
	@Override
	public void setStreet(String str) {
		  
		 findElement(By.id(PegaUtil.STREET_ID)).sendKeys(str);
		
	}

	@Override
	public void setCity(String str) {
		  
		 findElement(By.id(PegaUtil.CITY_ID)).sendKeys(str);
		
	}

	@Override
	public void setState(String str) {
		  
		 findElement(By.id(PegaUtil.STATE_ID)).sendKeys(str);
		
	}

	@Override
	public void setPostalcode(String str) {
		  
		 findElement(By.id(PegaUtil.ZIPCODE_ID)).sendKeys(str);
		
	}

	@Override
	public void setCountry(String str) {
		  
		 findSelectBox(By.id(PegaUtil.COUNTRY_ID)).selectByVisibleText(str);
		
	}

	@Override
	public void setTerritory(String str) {
		  
		PegaUtil.autoComplete(pegaDriver, CONT_TERRIOTRY_ID, str);
		
	}
	public void setMaritalStatus(String str)
	{
		  
		 findSelectBox(By.xpath(CONT_MARITAL_XPATH)).selectByVisibleText(str);
	}
	
	public void setCloseComments(String str)
	{
		  
		 findElement(By.id(CONT_CLOSECOMMENTS_ID)).sendKeys(str);
	}
	@Override
	public Contacts createContact() {
		return null;
	}

	@Override
	public void clickCreate() {
		PegaUtil.clickCreate(pegaDriver);
		
	}
	public void clickEdit()
	{
		  
		PegaUtil.clickEdit(pegaDriver);
	}
	
		public void clickSubmitButton()
	{
		  
		// findElement(By.id(CONT_RESPONSIBILITY_ID)).scrollIntoView();
		PegaUtil.clickSubmit(pegaDriver);
	}
		
	public String getFullname()
	{
		String fullname;
		  
		String firstname=getFirstName();
		String lastname=getLastName();
		if(firstname.length()==0)
		{
			 fullname =lastname;
		}
		else
		{
			fullname = firstname +" " + lastname;
			
		}
		
		return fullname;
	}
	public String getMaritalStatus()
	{
		  
		String marital= findElement(By.xpath(CONT_MARITALSTATUS_VALUE_XPATH)).getText();
		return marital;
		
	}
	public String getInfluenceRating()
	{
		
		  
		String influence= findElement(By.xpath(CONT_INFLUENCE_VALUE_XAPTH)).getText();
		return influence;
	}
	/*public void clickEdit()
	{
		  
		//PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, 1);
		PegaUtil.clickEdit(pegaDriver);
		
	
	}*/
	
	public void clickClose()
	{
		  
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Close");
	}
	
/*	public void clickSubmitButton()
	{
		  
		PegaUtil.clickSubmit(pegaDriver);
		  
		 findElement(By.id(CONT_SUBMIT_BUTTON_ID)).scrollIntoView();
		 findElement(By.id(CONT_SUBMIT_BUTTON_ID)).click();
	}*/
	public String getClosePageHeader()
	{
		  
		String sectionname= findElement(By.xpath(CONT_CLOSEPAGE_HEADER_XPATH)).getText();
		return sectionname;
	}
	public boolean isActionItemValuePresent(String dropDownValue)
	{
		return (PegaUtil.isActionItemValuePresent(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, dropDownValue));
	}

	@Override
	public void setAddress() {
		PegaUtil.setAddress(pegaDriver);
		
	}

	@Override
	public String getAddressType() {
		String addressType=PegaUtil.getAddressType(pegaDriver);
		return addressType;
	}

	@Override
	public String getPrimaryContactName() {
		String primaryContact =  findElement(By.xpath(CONT_PRIMARY_CONTACT_XPATH)).getText();
		return primaryContact;
	}

	@Override
	public void clickOnRelationshipsTab() 
	{
		PegaUtil.getSubTab(pegaDriver, "Relationships");
		PegaUtil.clickRefresh(pegaDriver);						
	}

	@Override
	public String getC2ARelationShipName() {
		pegaDriver.getActiveFrameId(true);
		// findElement(By.xpath(CONT_C2A_LIST_XPATH)).scrollIntoView();
		List<WebElement> wb =  findElements(By.xpath(CONT_C2A_LIST_XPATH));
		System.out.println("Sizeee" + wb.size());
		for(WebElement w : wb)
		{
			String RelationType =  findElement(By.xpath(CONT_C2A_RELATIONSHIP_XPATH)).getText().trim();
			System.out.println("Relationship type is" + RelationType);
			if(RelationType.equals("Primary-Individual"))
			{
				String AccountName =  findElement(By.xpath(CONT_C2A_ACCOUNT_NAME_XPATH)).getText().trim();
				System.out.println("*******" +AccountName);
				return AccountName;
			}
		}
		return null;
	}
	
	public void clickFollow()
	{
		 findElement(By.xpath(CONT_FOLLOW_XPATH)).click();
		
	}
	public void clickUnFollow()
	{
		 findElement(By.xpath(CONT_UNFOLLOW_XPATH)).click();
	}
	
	@Override
	public List<String> getFollowedWOName() {
		List<String> ColumnValues= new ArrayList<String>();
		 //switchTo().defaultContent();
		 findElement(By.xpath(CONT_FOLLOWSCROLLING_XPATH)).scrollIntoView();
		List<WebElement> followedItems =  findElements(By.xpath(CONT_FOLLOWTESTING_XPATH));
		for(WebElement w : followedItems) {
			ColumnValues.add(w.getText());
		}
		return ColumnValues;	
	}

	@Override
	public boolean isFollowingListEmpty()
	{
		//Wizard wizard =  findWizard("PegaGadget0Ifr");
		// findElement(By.xpath(CONT_FOLLOWSCROLLING_XPATH)).scrollIntoView();
		return(PegaUtil.isListEmpty(pegaDriver));
		
	}
	
	@Override
	public boolean householdAssociated()
	{
		Wizard wizard =  findWizard( getActiveFrameId(false));
	    wizard.findElement(By.xpath(ADD_CONTACT_TO_HOUSEHOLD)).scrollIntoView();
		return  verifyElement(By.xpath("//*[@data-test-id = '20141217082112010923768']"));
	}

	@Override
	public String getFirstName() 
	{
		 
		String firstname=new String( findElement(By.xpath(CONT_FIRST_NAME_VALUE_XPATH)).getText());
		 return firstname;
		
	}

	@Override
	public String getLastName() 
	{
		  
		String lastname=new String( findElement(By.xpath(CONT_LAST_NAME_VALUE_XPATH)).getText());
		 return lastname;
	}
	@Override
	public Leads clickBusinessLead() {
		
		PegaUtil.dropdown(pegaDriver, CONT_ADD_LEAD_XPATH, "Business");
		  
		String frameId =  getActiveFrameId(false);
		Leads lead = new PegaLeads(frameId, testEnv);
		return lead;	
		
		
	}

	@Override
	public void getLeadSubTab() {
		PegaUtil.getSubTab(pegaDriver, "Leads");
		  
		 findElement(By.xpath("//div[@role='tablist']//div[contains(@class, 'count')]//h2[text()='Leads']")).click();
		PegaUtil.clickRefresh(pegaDriver);
	}
	@Override
	public boolean getLeadNameFromSubtab(String LeadName) {
		return(PegaUtil.isRowValuePresent(pegaDriver, LEADS_ROWS_XPATH, LEAD_ROWS_NAME_XPATH, LeadName));
	}

	@Override
	public Leads clickIndividualLead() {
		PegaUtil.dropdown(pegaDriver, CONT_ADD_LEAD_XPATH, "Individual");
		String frameId =  getActiveFrameId(false);
		Leads lead = new PegaLeads(frameId, testEnv);
		return lead;
	}

	@Override
	public void getOpptySubTab() {
		PegaUtil.getSubTab(pegaDriver, "Opportunities");
		
	}

	@Override
	public void NavigateToHouseholdMembers(){
		 
		PegaUtil.getSubTab(pegaDriver, "Members");
		Wizard wizard =  findWizard( getActiveFrameId(false));
	    wizard.findElement(By.xpath(ADD_HOUSEHOLD_MEMBER_BTN)).scrollIntoView();
	}
	
	@Override
	public Opportunities clickOpptyFromSubtab(String opptype) {
		PegaUtil.dropdown(pegaDriver, CONT_ADD_OPPTY_XPATH, opptype);
		String frameId =  getActiveFrameId(false);
		Opportunities opp = new PegaOpportunity(frameId, testEnv);
		return opp;	
	}

	@Override
	public boolean getOpptyNameFromSubtab(String opptyname) {
		return(PegaUtil.isRowValuePresent(pegaDriver, OPP_ROWS_XPATH, OPP_ROWS_NAME_XPATH, opptyname));
	}
	
	@Override
	public boolean getOpptyNameFromSubtab(StringBuffer opptyname) {
		String opp= opptyname.toString();
		return(PegaUtil.isRowValuePresent(pegaDriver, OPP_ROWS_XPATH, OPP_ROWS_NAME_XPATH, opp));
	}
	


	@Override
	public void navigateToTab(String tabName) {
		//PegaUtil.getSubTab(pegaDriver, "Households");
		//div[@role='tablist']//div[contains(@class, 'count')]//h3";
		//  
		 findElement(By.xpath("//h2[contains(text(),'"+tabName+"')]")).click();
		 
	}

	@Override
	public Households selectExistingHousehold() {
		
		  
		PegaUtil.dropdown(pegaDriver,CONT_HOUSEHOLD_XPATH , "Exisiting" );
		String frameId =  getActiveFrameId(false);
		Households HouseholdDetails = new PegaHouseholds(frameId, testEnv);
		return HouseholdDetails;
	}

	@Override
	public List<String> getLeadRowValues(String leadName) {
		PegaUtil.clickRefresh(pegaDriver);
		return (PegaUtil.getRowValues(pegaDriver, LEAD_ROWS_XPATH, leadName));
	}

	@Override
	public String houseHoldExists(String HouseholdName) {
		String HHName = HouseholdName;
		  
		List<String> houseHoldAttributes = PegaUtil.getRowValues(pegaDriver, "//tr[contains(@oaargs, 'UPLUS-SAPLUS-WORK-TASK')]", HouseholdName);
		System.out.println("before houseHoldAttributes");
		if(houseHoldAttributes.size()>0){
			System.out.println("In If");
			return HHName;
		}
		else return null;
		//"//tr[contains(@oaargs, 'UPLUS-SAPLUS-WORK-TASK')]"
		//return  findElement(By.xpath("//table[contains(@pl_prop_class,'Household')]//tr[contains(@id,'HouseholdListByContact')]//a")).getAttribute("text");
		//return  findElement(By.xpath("//table[contains(@oaargs,'UPLUS-SAPLUS-WORK-RELATIONSHIPGROUP-HOUSEHOLD')]//tr[contains(@id,'HouseholdListByContact')]//a")).getAttribute("text");
	}
	

	@Override
	public void clickHousehold(String HouseholdName) {
		  
		 findElement(By.xpath("//button[contains(@name,'Households')]")).click();
		if( verifyElement(By.xpath("//table[contains(@pl_prop_class,'Household')]//tr[contains(@id,'HouseholdListByContact')]//a[contains(@text(),'"+HouseholdName+"')]")))
		{
			 findElement(By.xpath("//table[contains(@pl_prop_class,'Household')]//tr[contains(@id,'HouseholdListByContact')]//a[contains(@text(),'"+HouseholdName+"')]")).click();
		}	
	}
		
	@Override
	public Households selectNewHousehold() {

		  
		PegaUtil.dropdown(pegaDriver, CONT_HOUSEHOLD_XPATH, "New" );
		String frameId =  getActiveFrameId(false);
		Households HouseholdDetails = new PegaHouseholds(frameId, testEnv);
		return HouseholdDetails;
		
	}
	@Override
	public void getActivitiesSubTab() {
		
		PegaUtil.getSubTab(pegaDriver, "Activities");
	}
	@Override
	public List<String> getActivityValues(String ActivityName) {
		// findElement(By.xpath(PegaUtil.ACTIVITY_REFRESH_XPATH)).scrollIntoView();
		 findElement(By.xpath(PegaUtil.ACTIVITY_REFRESH_XPATH)).click();
		
		return(PegaUtil.getRowValues(pegaDriver, CONT_ACTIVITY_ROW_IDENTIFIER_XPATH, ActivityName));
	}

	@Override
	public List<String> getTaskValues(String RowName) {
		// findElement(By.xpath(PegaUtil.TASK_REFRESH_XPATH)).scrollIntoView();
		 findElement(By.xpath(PegaUtil.TASK_REFRESH_XPATH)).click();
		
		return(PegaUtil.getRowValues(pegaDriver, CONT_TASK_ROW_IDENTIFIER_XPATH, RowName));
		
	}
	
	@Override
	public ArrayList<String> getSubTabs() {
			ArrayList<String> s= new ArrayList<String>();
			List<WebElement> wb= findElements(By.xpath(CON_SUBTABS_XPATH));
			
			for(WebElement w:wb)
			{
				String s1=w.getText();
				s.add(s1);
			}
			System.out.println(s.size());
			return s;
		}
	
}