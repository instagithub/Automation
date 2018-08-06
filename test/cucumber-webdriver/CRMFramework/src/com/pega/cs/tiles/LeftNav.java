package com.pega.cs.tiles;

import com.pega.sfa.workobjects.AccountList;
import com.pega.sfa.workobjects.AppointmentList;
import com.pega.sfa.workobjects.ClosePlans;
import com.pega.sfa.workobjects.ContactList;
import com.pega.sfa.workobjects.EngagementMaps;
import com.pega.sfa.workobjects.Forecast;
import com.pega.sfa.workobjects.HouseholdList;
import com.pega.sfa.workobjects.LeadsList;
import com.pega.sfa.workobjects.Login;
import com.pega.sfa.workobjects.OperatorList;
import com.pega.sfa.workobjects.OpportunityList;
import com.pega.sfa.workobjects.OrganizationsList;
import com.pega.sfa.workobjects.PartnersList;
import com.pega.sfa.workobjects.Pulse;
import com.pega.sfa.workobjects.PulseList;
import com.pega.sfa.workobjects.QuickCreate;
import com.pega.sfa.workobjects.TerritoriesList;
import com.pega.sfa.workobjects.ToolsList;										   

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
