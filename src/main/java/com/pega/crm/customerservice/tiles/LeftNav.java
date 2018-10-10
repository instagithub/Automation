package com.pega.crm.customerservice.tiles;

import com.pega.crm.salesautomation.workobjects.AccountList;
import com.pega.crm.salesautomation.workobjects.AppointmentList;
import com.pega.crm.salesautomation.workobjects.ClosePlans;
import com.pega.crm.salesautomation.workobjects.ContactList;
import com.pega.crm.salesautomation.workobjects.EngagementMaps;
import com.pega.crm.salesautomation.workobjects.Forecast;
import com.pega.crm.salesautomation.workobjects.HouseholdList;
import com.pega.crm.salesautomation.workobjects.LeadsList;
import com.pega.crm.salesautomation.workobjects.Login;
import com.pega.crm.salesautomation.workobjects.OperatorList;
import com.pega.crm.salesautomation.workobjects.OpportunityList;
import com.pega.crm.salesautomation.workobjects.OrganizationsList;
import com.pega.crm.salesautomation.workobjects.PartnersList;
import com.pega.crm.salesautomation.workobjects.Pulse;
import com.pega.crm.salesautomation.workobjects.QuickCreate;
import com.pega.crm.salesautomation.workobjects.TerritoriesList;
import com.pega.crm.salesautomation.workobjects.ToolsList;										   

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
