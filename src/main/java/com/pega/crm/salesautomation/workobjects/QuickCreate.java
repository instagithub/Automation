package com.pega.crm.salesautomation.workobjects;

import com.pega.ri.Wizard;

public interface QuickCreate extends Wizard{
	
	Organizations clickOrganization();
	Opportunities clickOpportunity(String opptype);
	Appointment clickAppointment();
	Accounts clickAccount();
	Contacts clickContact();
	Partners clickPartner();
	Leads clickLead(String LeadType);
	
}
