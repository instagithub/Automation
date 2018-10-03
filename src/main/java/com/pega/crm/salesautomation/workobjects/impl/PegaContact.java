package salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;
import salesautomation.workobjects.Activity;
import salesautomation.workobjects.Contact;
import salesautomation.workobjects.Households;
import salesautomation.workobjects.Leads;
import salesautomation.workobjects.Opportunity;
import salesautomation.workobjects.Relationship;
import salesautomation.workobjects.Tasks;


public class PegaContact extends WizardImpl implements Contact
{
	
	String CON_SUBTABS_XPATH = "//div[@role='tab']//h2"; 
	public PegaContact(WebElement elmt, String elmtId) 
	{
		super(elmt, elmtId);
		
	}
	public PegaContact(WebElement elmt) {
		super(elmt);
	}								  
	
	public void setFirstName(StringBuffer FirstName)
	{
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement(By.id(CONT_FIRSTNAME_ID)).sendKeys(FirstName);
		pegaDriver.findElement(By.id(CONT_FIRSTNAME_ID)).sendKeys(Keys.TAB);
		
	}

	@Override
	public void setLastName(StringBuffer str) {
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.findElement(By.xpath(CONT_LASTNAME_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(CONT_LASTNAME_XPATH)).sendKeys(str);
		pegaDriver.findElement(By.xpath(CONT_LASTNAME_XPATH)).sendKeys(Keys.TAB);
	}

	@Override
	public void setOrganization(String str) {
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(CONT_ORG_ID)).click(false);
		PegaUtil.autoComplete(pegaDriver, CONT_ORG_ID, str);
		
	}

	@Override
	public void setSalutation(String str) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.xpath(CONT_SALUTATION_XPATH)).selectByVisibleText(str);
		
	}

	public void setCompany(String str) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(CONT_LASTNAME_XPATH)).sendKeys(str);
		
	}

	@Override
	public void setDepartment(String str) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(CONT_DEPARTMENT_ID)).sendKeys(str);
		
	}

	@Override
	public void setInfluence(String str) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.xpath(CONT_INFLUENCE_XPATH)).selectByVisibleText(str);
		
	}

	@Override
	public void setFavorability(String str) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.xpath(CONT_FAVORABILITY_XPATH)).selectByVisibleText(str);
		
	}
	
	@Override
	public void setWorkPhone(String str) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(CONT_WORKPHONE_ID)).sendKeys(str);
		
	}

	@Override
	public void setWorkEmail(String str) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(CONT_WORKEMAIL_ID)).sendKeys(str);
		
	}

	
	@Override
	public void setStreet(String str) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PegaUtil.STREET_ID)).sendKeys(str);
		
	}

	@Override
	public void setCity(String str) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PegaUtil.CITY_ID)).sendKeys(str);
		
	}

	@Override
	public void setState(String str) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PegaUtil.STATE_ID)).sendKeys(str);
		
	}

	@Override
	public void setPostalcode(String str) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PegaUtil.ZIPCODE_ID)).sendKeys(str);
		
	}

	@Override
	public void setCountry(String str) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.id(PegaUtil.COUNTRY_ID)).selectByVisibleText(str);
		
	}

	@Override
	public void setTerritory(String str) {
		pegaDriver.getActiveFrameId(true);
		PegaUtil.autoComplete(pegaDriver, CONT_TERRIOTRY_ID, str);
		
	}
	public void setMaritalStatus(String str)
	{
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.xpath(CONT_MARITAL_XPATH)).selectByVisibleText(str);
	}
	
	public void setCloseComments(String str)
	{
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(CONT_CLOSECOMMENTS_ID)).sendKeys(str);
	}
	@Override
	public Contact createContact() {
		return null;
	}

	@Override
	public void clickCreate() {
		PegaUtil.clickCreate(pegaDriver);
		
	}
	public void clickEdit()
	{
		pegaDriver.getActiveFrameId(true);
		PegaUtil.clickEdit(pegaDriver);
	}
	
		public void clickSubmitButton()
	{
		pegaDriver.getActiveFrameId(true);
		//pegaDriver.findElement(By.id(CONT_RESPONSIBILITY_ID)).scrollIntoView();
		PegaUtil.clickSubmit(pegaDriver);
	}
		
	public String getFullname()
	{
		String fullname;
		pegaDriver.getActiveFrameId(true);
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
		pegaDriver.getActiveFrameId(true);
		String marital=pegaDriver.findElement(By.xpath(CONT_MARITALSTATUS_VALUE_XPATH)).getText();
		return marital;
		
	}
	public String getInfluenceRating()
	{
		
		pegaDriver.getActiveFrameId(true);
		String influence=pegaDriver.findElement(By.xpath(CONT_INFLUENCE_VALUE_XAPTH)).getText();
		return influence;
	}
	/*public void clickEdit()
	{
		pegaDriver.getActiveFrameId(true);
		//PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, 1);
		PegaUtil.clickEdit(pegaDriver);
		
	
	}*/
	
	public void clickClose()
	{
		pegaDriver.getActiveFrameId(true);
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Close");
	}
	
/*	public void clickSubmitButton()
	{
		pegaDriver.getActiveFrameId(true);
		PegaUtil.clickSubmit(pegaDriver);
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(CONT_SUBMIT_BUTTON_ID)).scrollIntoView();
		pegaDriver.findElement(By.id(CONT_SUBMIT_BUTTON_ID)).click();
	}*/
	public String getClosePageHeader()
	{
		pegaDriver.getActiveFrameId(true);
		String sectionname=pegaDriver.findElement(By.xpath(CONT_CLOSEPAGE_HEADER_XPATH)).getText();
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
		String primaryContact = pegaDriver.findElement(By.xpath(CONT_PRIMARY_CONTACT_XPATH)).getText();
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
		//pegaDriver.findElement(By.xpath(CONT_C2A_LIST_XPATH)).scrollIntoView();
		List<WebElement> wb = driver.findElements(By.xpath(CONT_C2A_LIST_XPATH));
		System.out.println("Sizeee" + wb.size());
		for(WebElement w : wb)
		{
			String RelationType = driver.findElement(By.xpath(CONT_C2A_RELATIONSHIP_XPATH)).getText().trim();
			System.out.println("Relationship type is" + RelationType);
			if(RelationType.equals("Primary-Individual"))
			{
				String AccountName = driver.findElement(By.xpath(CONT_C2A_ACCOUNT_NAME_XPATH)).getText().trim();
				System.out.println("*******" +AccountName);
				return AccountName;
			}
		}
		return null;
	}
	
	public void clickFollow()
	{
		pegaDriver.findElement(By.xpath(CONT_FOLLOW_XPATH)).click();
		
	}
	public void clickUnFollow()
	{
		pegaDriver.findElement(By.xpath(CONT_UNFOLLOW_XPATH)).click();
	}
	
	@Override
	public List<String> getFollowedWOName() {
		List<String> ColumnValues= new ArrayList<String>();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(CONT_FOLLOWSCROLLING_XPATH)).scrollIntoView();
		List<WebElement> followedItems = pegaDriver.findElements(By.xpath(CONT_FOLLOWTESTING_XPATH));
		for(WebElement w : followedItems) {
			ColumnValues.add(w.getText());
		}
		return ColumnValues;	
	}

	@Override
	public boolean isFollowingListEmpty()
	{
		pegaDriver.switchTo().defaultContent();
		Wizard wizard = pegaDriver.findWizard("PegaGadget0Ifr");
		
		//pegaDriver.findElement(By.xpath(CONT_FOLLOWSCROLLING_XPATH)).scrollIntoView();
		return(PegaUtil.isListEmpty(pegaDriver));
		
	}
	
	@Override
	public boolean householdAssociated()
	{
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
	    wizard.findElement(By.xpath(ADD_CONTACT_TO_HOUSEHOLD)).scrollIntoView();
		return pegaDriver.verifyElement(By.xpath("//*[@data-test-id = '20141217082112010923768']"));
	}

	@Override
	public String getFirstName() 
	{
		pegaDriver.getActiveFrameId(true);
		String firstname=new String(pegaDriver.findElement(By.xpath(CONT_FIRST_NAME_VALUE_XPATH)).getText());
		 return firstname;
		
	}

	@Override
	public String getLastName() 
	{
		pegaDriver.getActiveFrameId(true);
		String lastname=new String(pegaDriver.findElement(By.xpath(CONT_LAST_NAME_VALUE_XPATH)).getText());
		 return lastname;
	}
	@Override
	public Leads clickBusinessLead() {
		
		PegaUtil.dropdown(pegaDriver, CONT_ADD_LEAD_XPATH, "Business");
		pegaDriver.getActiveFrameId(true);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Leads lead = new PegaLeads(framElmt, frameId);
		lead._setEnvironment(testEnv, frameId);
		return lead;	
		
		
	}

	@Override
	public void getLeadSubTab() {
		PegaUtil.getSubTab(pegaDriver, "Leads");
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//div[@role='tablist']//div[contains(@class, 'count')]//h2[text()='Leads']")).click();
		PegaUtil.clickRefresh(pegaDriver);
	}
	@Override
	public boolean getLeadNameFromSubtab(String LeadName) {
		return(PegaUtil.isRowValuePresent(pegaDriver, LEADS_ROWS_XPATH, LEAD_ROWS_NAME_XPATH, LeadName));
	}

	@Override
	public Leads clickIndividualLead() {
		PegaUtil.dropdown(pegaDriver, CONT_ADD_LEAD_XPATH, "Individual");
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Leads lead = new PegaLeads(framElmt, frameId);
		lead._setEnvironment(testEnv, frameId);
		return lead;
	}

	@Override
	public void getOpptySubTab() {
		PegaUtil.getSubTab(pegaDriver, "Opportunities");
		
	}

	@Override
	public void NavigateToHouseholdMembers(){
		 
		PegaUtil.getSubTab(pegaDriver, "Members");
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
	    wizard.findElement(By.xpath(ADD_HOUSEHOLD_MEMBER_BTN)).scrollIntoView();
	}
	
	@Override
	public Opportunity clickOpptyFromSubtab(String opptype) {
		PegaUtil.dropdown(pegaDriver, CONT_ADD_OPPTY_XPATH, opptype);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Opportunity opp = new PegaOpportunity(framElmt, frameId);
		opp._setEnvironment(testEnv, frameId);
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
	public Activity addActivity() {
		return(PegaUtil.addActivity(pegaDriver));
		
	}

	@Override
	public void navigateToTab(String tabName) {
		//PegaUtil.getSubTab(pegaDriver, "Households");
		//div[@role='tablist']//div[contains(@class, 'count')]//h3";
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//h2[contains(text(),'"+tabName+"')]")).click();
		 
	}

	@Override
	public Households selectExistingHousehold() {
		
		pegaDriver.getActiveFrameId(true);
		PegaUtil.dropdown(pegaDriver,CONT_HOUSEHOLD_XPATH , "Exisiting" );
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Households HouseholdDetails = new PegaHouseholds(framElmt, frameId);
		HouseholdDetails._setEnvironment(testEnv, frameId);
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
		pegaDriver.getActiveFrameId(true);
		List<String> houseHoldAttributes = PegaUtil.getRowValues(pegaDriver, "//tr[contains(@oaargs, 'UPLUS-SAPLUS-WORK-TASK')]", HouseholdName);
		System.out.println("before houseHoldAttributes");
		if(houseHoldAttributes.size()>0){
			System.out.println("In If");
			return HHName;
		}
		else return null;
		//"//tr[contains(@oaargs, 'UPLUS-SAPLUS-WORK-TASK')]"
		//return pegaDriver.findElement(By.xpath("//table[contains(@pl_prop_class,'Household')]//tr[contains(@id,'HouseholdListByContact')]//a")).getAttribute("text");
		//return pegaDriver.findElement(By.xpath("//table[contains(@oaargs,'UPLUS-SAPLUS-WORK-RELATIONSHIPGROUP-HOUSEHOLD')]//tr[contains(@id,'HouseholdListByContact')]//a")).getAttribute("text");
	}
	

	@Override
	public void clickHousehold(String HouseholdName) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//button[contains(@name,'Households')]")).click();
		if(pegaDriver.verifyElement(By.xpath("//table[contains(@pl_prop_class,'Household')]//tr[contains(@id,'HouseholdListByContact')]//a[contains(@text(),'"+HouseholdName+"')]")))
		{
			pegaDriver.findElement(By.xpath("//table[contains(@pl_prop_class,'Household')]//tr[contains(@id,'HouseholdListByContact')]//a[contains(@text(),'"+HouseholdName+"')]")).click();
		}	
	}
		
	@Override
	public Households selectNewHousehold() {

		pegaDriver.getActiveFrameId(true);
		PegaUtil.dropdown(pegaDriver, CONT_HOUSEHOLD_XPATH, "New" );
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Households HouseholdDetails = new PegaHouseholds(framElmt, frameId);
		HouseholdDetails._setEnvironment(testEnv, frameId);
		return HouseholdDetails;
		
	}
	@Override
	public void getActivitiesSubTab() {
		
		PegaUtil.getSubTab(pegaDriver, "Activities");
	}
	@Override
	public List<String> getActivityValues(String ActivityName) {
		//pegaDriver.findElement(By.xpath(PegaUtil.ACTIVITY_REFRESH_XPATH)).scrollIntoView();
		pegaDriver.findElement(By.xpath(PegaUtil.ACTIVITY_REFRESH_XPATH)).click();
		
		return(PegaUtil.getRowValues(pegaDriver, CONT_ACTIVITY_ROW_IDENTIFIER_XPATH, ActivityName));
	}
	@Override
	public Tasks clickAddTask() {
		return(PegaUtil.addTask(pegaDriver));
	}
	@Override
	public List<String> getTaskValues(String RowName) {
		//pegaDriver.findElement(By.xpath(PegaUtil.TASK_REFRESH_XPATH)).scrollIntoView();
		pegaDriver.findElement(By.xpath(PegaUtil.TASK_REFRESH_XPATH)).click();
		
		return(PegaUtil.getRowValues(pegaDriver, CONT_TASK_ROW_IDENTIFIER_XPATH, RowName));
		
	}
	@Override
	public Relationship clickOnAddContact() {
		pegaDriver.getActiveFrameId(true);
		PegaUtil.dropdown(pegaDriver, RELATIONSHIP_ADD_BUTTON, "Contact");
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship rr = new PegaRelationship(framElmt, frameId);
		rr._setEnvironment(testEnv, frameId);
		return rr;
		
	}
	/*@Override
	public String getContactRelationshipName() {
		PegaUtil.isRowValuePresent(pegaDriver,)
		return null;
	}*/
	@Override
	public ArrayList<String> getSubTabs() {
			ArrayList<String> s= new ArrayList<String>();
			List<WebElement> wb=pegaDriver.findElements(By.xpath(CON_SUBTABS_XPATH));
			
			for(WebElement w:wb)
			{
				String s1=w.getText();
				s.add(s1);
			}
			System.out.println(s.size());
			return s;
		}
	
}