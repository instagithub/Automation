package customerservice.tiles;

import salesautomation.workobjects.AccountList;
import salesautomation.workobjects.AppointmentList;
import salesautomation.workobjects.ClosePlans;
import salesautomation.workobjects.ContactList;
import salesautomation.workobjects.EngagementMaps;
import salesautomation.workobjects.Forecast;
import salesautomation.workobjects.HouseholdList;
import salesautomation.workobjects.LeadsList;
import salesautomation.workobjects.Login;
import salesautomation.workobjects.OperatorList;
import salesautomation.workobjects.OpportunityList;
import salesautomation.workobjects.OrganizationsList;
import salesautomation.workobjects.PartnersList;
import salesautomation.workobjects.Pulse;
import salesautomation.workobjects.PulseList;
import salesautomation.workobjects.QuickCreate;
import salesautomation.workobjects.TerritoriesList;
import salesautomation.workobjects.ToolsList;										   

public interface LeftNav {
	
	OrganizationsList getOrganizationList();
	OperatorList getOperatorsList();
	ContactList getContactList();
	AccountList getAccountList();
	OpportunityList getOpportunityList();
	PartnersList getPartnersList();
	HouseholdList getHouseholdList();
	LeadsList getLeadsList();
	AppointmentList getAppointmentsList();
	String getLatestRecent();
	TerritoriesList getTerritoriesList();
	ToolsList getToolsList();					   
	Login getDashboards();
	QuickCreate getQuickCreate();
	Pulse getPulseList();
	EngagementMaps getEngagementMaps();
	Forecast getForecast();
	ClosePlans getClosePlans();
}
