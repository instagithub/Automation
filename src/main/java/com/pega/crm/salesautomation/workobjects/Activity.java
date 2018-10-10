package com.pega.crm.salesautomation.workobjects;

import com.pega.ri.Wizard;


public interface Activity  extends Wizard {

	public void setSubject(String activitySubject);
	public void setDate();
	public void setCommunicationType(String communicationType);
	public void setRelatedToType(String WorkObjectType);
	public void setWorkObject(String WorkObjectName);
	public void setOutcome(String Outcome);
	public void activityCreate();

	
	public String getActivitySubject();
	public String getDate();
	public String getCommunicationType();
	public String getStatus();
	public String getWorkObject();
	public String getOutcome();
	public String getActivityOwner();
	public String getRelatedToTypeValue(String WOName);
	void clickCreate();
	
	void addExistingContacts(String contactName);
	void addInternalStaff(String StaffName);
	void addActivityTasks(String TaskSub,String DueDate,String AssignedTo,String TaskType);
	void addNewContact();
	
	public String getdefaultOrgvalue();
	
}
