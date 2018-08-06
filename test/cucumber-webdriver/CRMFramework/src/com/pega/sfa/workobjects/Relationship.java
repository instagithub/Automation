package com.pega.sfa.workobjects;

import com.pega.ri.Wizard;

public interface Relationship extends Wizard {
	String checkDefaults();
	void setRelationshipType(String RelationshipType);
	void setStartDate(String startDate);
	void setEndDate(String EndDate);
	void chooseContactType(String ContactType);
	void selectContactName(String ContactName);
	void setRelationshipDesc(String RelationshipDescription);
	void setNotes(String Notes);
	void clickCreate();
	
	
	String getRelationshipType();
	String getStartDate();
	String getEndDate();
	String CheckContactName();
	String getRelationshipDesc();
	String getNotes();
	Contact setNewContactName(String ContactName);
	Organization openOrganization(String OrgName);
	Accounts openAccount(StringBuffer name);
	Accounts openAccount(String name);
	Contact openContact(String ContactName);									   
	
}
