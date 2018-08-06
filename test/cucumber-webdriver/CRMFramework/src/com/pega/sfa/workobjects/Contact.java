package com.pega.sfa.workobjects;

import java.util.ArrayList;
import java.util.List;				  
import org.openqa.selenium.Keys;
import com.pega.ri.Wizard;
import com.pega.sfa.workobjects.impl.UtilImpl;

public interface Contact extends Wizard
{

	
	String SELECTALL=Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE);
	String CONT_CREATECONTACT_XPATH="//*[text()='Create Contact']";
	String CONT_ACTIONMENU_XPATH="//div[@role='button']";
	String CONT_FIRSTNAME_ID="FirstName";
	String CONT_LASTNAME_XPATH="//*[contains(@id, 'LastName')]";
	String CONT_ORG_ID="crmSearchTerm";
	String CONT_COMAPANY_ID="Company";
	String CONT_SALUTATION_XPATH="//select[contains(@name, 'Salutation')]";
	String CONT_DEPARTMENT_ID="Department";
	String CONT_INFLUENCE_XPATH="//select[contains(@id, 'InfluenceRating')]";
	String CONT_MARITAL_XPATH="//select[contains(@id, 'MaritalStatus')]|//select[contains(@name, 'MaritalStatus')]";
	String CONT_FAVORABILITY_XPATH="//select[contains(@id, 'FavorabilityRating')]";
	String CONT_WORKPHONE_ID="OfficePhone";
	String CONT_WORKEMAIL_ID="WorkEmail";
	String CONT_RESPONSIBILITY_ID="ResponsibilityDescription";
	String CONT_OKBUTTON_XPATH="//button[contains(@data-click,'doFormSubmit')]//*[text()='OK']";
	String CONT_TERRIOTRY_ID="crmTerritorySearch";
	String CONT_FULLNAME_XPATH="//*[text()='Primary Individual Account']/..//div/span";
	String CONT_SUBMIT_BUTTON_ID="submitButton";
	
	String CONT_MARITALSTATUS_VALUE_XPATH="//span[text()='Marital status']/..//div";
	
	String CONT_INFLUENCE_VALUE_XAPTH="//span[text()='Influence rating']/..//div";
	String CONT_CLOSEPAGE_HEADER_XPATH="//*[@class='assignment_title']";
	String CONT_CLOSECOMMENTS_ID="CloseComments";
	String CONT_PRIMARY_CONTACT_XPATH="//*[text()='Primary contact']/..//div/span";
	String CONT_C2A_LIST_XPATH="//tr[contains(@oaargs, 'LINK-ENTITY-C2A')]";
	String CONT_ADD_LEAD_XPATH=UtilImpl.getButtonXpath("Add Lead") +"|" + UtilImpl.getButtonXpathWithIcon("Add Lead");
	String CONT_ADD_OPPTY_XPATH=UtilImpl.getButtonXpath("Add opportunity") + "|" + UtilImpl.getButtonXpathWithIcon("Add Opportunity");
	String LEADS_ROWS_XPATH="//tr[contains(@oaargs, 'UPLUS-SAPLUS-WORK-LEAD')]";
	String LEAD_ROWS_NAME_XPATH="//td[@data-attribute-name= 'Name']//a";
	String OPP_ROWS_XPATH="//tr[contains(@id, 'OpportunitiesByContact')] | //tr[contains(@oaargs, 'UPLUS-SAPLUS-WORK-OPPORTUNITY')]";
	String OPP_ROWS_NAME_XPATH="//td[@data-importance='primary']//a";	
	String Opp_Name_in_Acnt_Org = "//*[@data-test-id='20150105032822096321935']";

	String CONT_C2A_RELATIONSHIP_XPATH="" + CONT_C2A_LIST_XPATH + "//td[@data-attribute-name= 'Relationship type']//div";
	String CONT_C2A_ACCOUNT_NAME_XPATH="" + CONT_C2A_LIST_XPATH + "//td[@data-attribute-name= 'Account name']//div/span/a";
	String CONT_FOLLOWSCROLLING_XPATH ="//h2[text()='Following']";
	String CONT_FOLLOWTESTING_XPATH = "//*[@data-test-id='201506190811420995362']";
	//String CONT_FOLLOWTESTING_XPATH = "//div[@pyclassname='Index-WorkPartyUri']//a";
	String FOLLOWTESTING_XPATH = "//div[contains(@param_name,'Favorites')]";
	//String CONT_FOLLOWTESTING_XPATH = "//div[contains(@param_name,'Favorites')]//a";
	String CONT_UNFOLLOW_XPATH=UtilImpl.getButtonXpath("Unfollow");
	String CONT_FOLLOW_XPATH=UtilImpl.getButtonXpath("Follow");
	String CONT_FIRST_NAME_VALUE_XPATH="//*[text()='First name']/../div/span";
	String CONT_LAST_NAME_VALUE_XPATH="//*[text()='Last name']/../../div/span";
	String LEAD_ROWS_XPATH="//tr[contains(@id, 'LeadsRelatedToContact')]";
	String CONT_ACTIVITY_ROW_IDENTIFIER_XPATH = "//tr[contains(@id, 'crmGetRelatedActivitiesListByContact')]";
	String CONT_TASK_ROW_IDENTIFIER_XPATH= "//tr[contains(@oaargs, 'UPLUS-SAPLUS-WORK-TASK')]";	
	String RELATIONSHIP_ADD_BUTTON=UtilImpl.getButtonXpath("Add") + "|" + UtilImpl.getButtonXpathWithIcon("Add");
	String CONT_HOUSEHOLD_XPATH="//button[contains(@title,'Add contact to household')]" +"|" + UtilImpl.getButtonXpathWithIcon("Add contact to household");;
	String ADD_HOUSEHOLD_MEMBER_BTN = "//*[@data-test-id='2015031214541608808172']";
	String ADD_CONTACT_TO_HOUSEHOLD = "//*[@data-test-id='2015061908563207831294']";
			
	Contact createContact();
	void setFirstName(StringBuffer str);
	void setLastName(StringBuffer str);
	void setOrganization(String str);
	void setSalutation(String str);
	void setDepartment(String str);
	void setInfluence(String str);
	void setMaritalStatus(String str);
	void setFavorability(String str);
	void setWorkPhone(String str);
	void setWorkEmail(String str);
	void setStreet(String str);
	void setCity(String str);
	void setState(String str);
	void setPostalcode(String str);
	void setCountry(String str);
	void setTerritory(String str);
	void setCloseComments(String str);
	void setAddress();
	
	
	void clickCreate();
	void clickEdit();
	void clickClose();
	void clickSubmitButton();
	void navigateToTab(String tabName);								
	void clickOnRelationshipsTab();
	Households selectExistingHousehold();
	Households selectNewHousehold();								  
	void clickFollow();
	void clickUnFollow();
	String houseHoldExists(String HouseholdName);
	void clickHousehold(String HouseholdName);										  
	Activity addActivity();									   
	String getFirstName();
	String getLastName();
	String getFullname();
	String getMaritalStatus();
	String getInfluenceRating();
	String getClosePageHeader();
	List<String> getFollowedWOName();
	boolean isActionItemValuePresent(String dropDownValue);
	String getAddressType();
	String getPrimaryContactName();
	String getC2ARelationShipName();
	boolean isFollowingListEmpty();
	Leads clickBusinessLead();
	void getLeadSubTab();
	boolean getLeadNameFromSubtab(String name);
	Leads clickIndividualLead();
	void getOpptySubTab();
	Opportunity clickOpptyFromSubtab(String opptype);
	boolean getOpptyNameFromSubtab(StringBuffer opptyname);
	boolean getOpptyNameFromSubtab(String opptyname);
	List<String> getLeadRowValues(String leadName);
	void getActivitiesSubTab();
	List<String> getActivityValues(String subject);
	Tasks clickAddTask();
	List<String> getTaskValues(String RowName);
	Relationship clickOnAddContact();
	void NavigateToHouseholdMembers();
	boolean householdAssociated();
	ArrayList<String> getSubTabs();
	//String getContactRelationshipName();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																					
}
