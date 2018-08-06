package com.pega.sfa.workobjects;


import com.pega.util.XPathUtil;

import java.util.ArrayList;
import java.util.List;				  
import com.pega.ri.Wizard;


public interface Organization  extends Wizard {
	
	String ORG_OPPTY_ROW_IDENTIFIER_XPATH="//tr[contains(@id, 'OpportunitiesInOrganizationList')]";																							
	Organization navigateOrganization();
	Boolean verifyOrgNewHarness();
	Organization editOrganization();
	Organization OrgList();
	Organization getOrganizationDetails();
	Organization changeOwner();
	Organization setNewOwner(String Owner);
	void setName(String name);
	void setWebsite(String name);
	void setTerritory(String territory);
	void setIndustry(String industry);
	void setPhoneNumber(String phoneNumber);
	void setShortName(String shortName);
	void setTickerSymbol(String ticker);
	void setEmployees(String employee);
	void setRevenue(String revenue);
	void setTarget(Boolean target);
	void setParentOrganization(String parentOrg);
	void setDescription(String description);
	void setDomains(String[] domains);
	void setAddress(String type, boolean primary);
	void setAddress();
	void changeTerritory(String newTerritory);
	void refresh();
	
	boolean checkMode(String str);
	
	String getName();
	String getTerritory();
	String getOwner();
	String getWebsite();
	String getIndustry();
	String getPhoneNumber();
	String getShortName();
	String getTickerSymbol();
	String getEmployees();
	String getRevenue();
	String getTarget();
	String getParentOrganization();
	String getDescription();
	String[] getDomains();
	String[] getAddress(String type);
	public ArrayList<String> verifySubTabs();
	boolean verifyOrgNews();
	boolean verifyTwitterIcon();
	boolean verifyFacebookIcon();
	boolean  verifyGoogleMapIcon();
	Organization changeHierarchy();
	Organization setHierarchy(String newParentOrg);
	Tasks addTask();
	Accounts AddAccount();
	boolean validateOrgTask(String orgTaskSubject,String orgTaskStatus,String DueDate,String OrgTaskAssignedTo,String orgTaskPriority);
	boolean validateOrgActivities(String Subject, String CommunicationType, String actDate, String CompletedBy, String RelatedTo,String RelatedType);
	boolean validateOrgAccounts(String AccountName,String AccountOwner,String AccountIndustry,String AccOpportunities,String AccountTotAmount,String AccountStatus);
	boolean validateOrgContacts(String ContactName,String RelationshipType,String RelationshipDescription,String StartDate,String EndDate);
	void navigeToOrgTab(String tabName);
	
	Activity addActivity();
	Relationship addContact();
	void getOpptySubTab();
	List<String> getOpptyValues(String opptyName);
	void getContactSubTab();
	void getLeadSubTab();
	List<String> getLeadRowValues(String companyName);
	void ClickToggletoConList();			   
	
	

	
	
	
	
	
	
	
	
	
}
