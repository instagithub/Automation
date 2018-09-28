package salesautomation.workobjects;

import com.pega.ri.Wizard;

public interface QuickCreate extends Wizard{
	
	Organization clickOrganization();
	Opportunity clickOpportunity(String opptype);
	Appointment clickAppointment();
	Accounts clickAccount();
	Contact clickContact();
	Partners clickPartner();
	Leads clickLead(String LeadType);
	
}
