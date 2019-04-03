package com.pega.crm.salesautomation.workobjects;

import com.pega.ri.Wizard;

public interface OrganizationsList extends Wizard{
	
	void search();
	
	Organizations createOrganization();
	public void verifyOrgListpage();
	OrganizationsList searchOrganization(String orgName);
	Organizations openOrganization(String orgName);
	Organizations navigateOrganiztion();	
	Organizations openFirstOrganization();
	boolean isOrganizationListEmpty();	
}
