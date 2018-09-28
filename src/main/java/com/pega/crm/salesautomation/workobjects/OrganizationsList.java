package salesautomation.workobjects;

import com.pega.ri.Wizard;
import com.pega.util.XPathUtil;

public interface OrganizationsList extends Wizard{
	
	void search();
	
	Organization createOrganization();
	public void verifyOrgListpage();
	OrganizationsList searchOrganization(String orgName);
	Organization openOrganization(String orgName);
	Organization navigateOrganiztion();	
	Organization openFirstOrganization();
	boolean isOrganizationListEmpty();	
}
