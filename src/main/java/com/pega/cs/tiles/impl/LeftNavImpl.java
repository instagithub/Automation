package com.pega.cs.tiles.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.cs.tiles.LeftNav;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.sfa.workobjects.AccountList;
import com.pega.sfa.workobjects.impl.AccountListImpl;
import com.pega.sfa.workobjects.AppointmentList;
import com.pega.sfa.workobjects.ClosePlans;
import com.pega.sfa.workobjects.impl.AppointmentListImpl;
import com.pega.sfa.workobjects.impl.ClosePlansImpl;
import com.pega.sfa.workobjects.ContactList;
import com.pega.sfa.workobjects.EngagementMaps;
import com.pega.sfa.workobjects.Forecast;
import com.pega.sfa.workobjects.impl.ContactListImpl;
import com.pega.sfa.workobjects.impl.EngagementMapsImpl;
import com.pega.sfa.workobjects.impl.ForecastImpl;
import com.pega.sfa.workobjects.HouseholdList;
import com.pega.sfa.workobjects.impl.HouseholdListImpl;
import com.pega.sfa.workobjects.impl.OpportunityListImpl;
import com.pega.sfa.workobjects.impl.TerritoriesListImpl;
import com.pega.sfa.workobjects.impl.ToolsListImpl;
import com.pega.sfa.workobjects.LeadsList;
import com.pega.sfa.workobjects.impl.LeadsListImpl;
import com.pega.sfa.workobjects.Login;
import com.pega.sfa.workobjects.impl.LoginImpl;
import com.pega.sfa.workobjects.OperatorList;
import com.pega.sfa.workobjects.impl.OperatorListImpl;
import com.pega.sfa.workobjects.OpportunityList;

import com.pega.sfa.workobjects.impl.OrganizationsListImpl;
import com.pega.sfa.workobjects.OrganizationsList;
import com.pega.sfa.workobjects.Organization;
import com.pega.sfa.workobjects.impl.OrganizationImpl;
import com.pega.sfa.workobjects.Territories;
import com.pega.sfa.workobjects.PartnersList;
import com.pega.sfa.workobjects.Pulse;
import com.pega.sfa.workobjects.PulseList;
import com.pega.sfa.workobjects.QuickCreate;
import com.pega.sfa.workobjects.impl.PartnersListImpl;
import com.pega.sfa.workobjects.impl.PulseImpl;
import com.pega.sfa.workobjects.impl.PulseListImpl;
import com.pega.sfa.workobjects.impl.QuickCreateImpl;
import com.pega.sfa.workobjects.TerritoriesList;
import com.pega.sfa.workobjects.ToolsList;
//import com.pega.sfa.workobjects.impl.TerritoriesListImpl;
//import com.pega.sfa.workobjects.impl.IToolsList;
//import com.pega.sfa.workobjects.impl.ToolsListImpl;
import com.pega.sfa.workobjects.impl.UtilImpl;

public class LeftNavImpl implements LeftNav {

	public String COPYRIGHT = "Copyright(C)2014 Pegasystems Inc.";
	public String VERSION = "$Id: LeftNavImpl.java 117333 2014-12-18 09:12:21Z $";
	private PegaWebDriver pegaDriver = null;
	private TestEnvironment testEnv = null;
	String ORG_LIST_XPATH = "//span[text()='Organizations']";
	String OPR_DASHBOARD="//span[text()='Dashboard']";
	String OPR_LIST_XPATH = "//span[text()='Operators']";
	String CONT_LIST_XPATH ="//span[text()='Contacts']";
	String ACC_LIST_XPATH="//span[text()='Accounts']";
	String OPP_LIST_XPATH="//span[text()='Opportunities']";
	String LISTVIEW_XPATH=UtilImpl.getSegmentedButtonXPath("List view");
	String PART_LIST_XPATH="//span[text()='Partners']";
	String HHD_LIST_XPATH="//span[text()='Households']";
	String LEAD_LIST_XPATH="//span[text()='Leads']";
	String APP_LIST_XPATH="//span[text()='Appointments']";
	String TERR_LIST_XPATH="//span[text()='Territories']";
	String RECENTS_LATEST_XPATH = "//div[@node_name='RecentItem'][@index='1']//a";
	String OPP_ALL_BUTTON_XPATH=UtilImpl.getSegmentedButtonXPath("All");
	String TOOLS_LIST_XPATH="//span[text()='Tools']";
	String QUICK_CREATE_XPATH="//a[contains(@name,'SFAPortalLeftPanel')]";
	String PULSE_LIST_XPATH="//span[text()='Pulse']";
	String EGMAP_LIST_XPATH="//span[text()='Engagement Map']";
	String FORECAST_LIST_XPATH="//span[text()='Forecast']";
	String CLOSEPLANS_LIST_XPATH="//h3[text()='Close plans']";
	public LeftNavImpl(TestEnvironment testEnv) {
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver();
	}
	
	
	
	@Override
	public Login getDashboards() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(OPR_DASHBOARD)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Login login = new LoginImpl(framElmt, frameId);
		login._setEnvironment(testEnv, frameId);
		return login;
	}
	
	@Override
	public OperatorList getOperatorsList() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(OPR_LIST_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		OperatorList oprList = new OperatorListImpl(framElmt, frameId);
		oprList._setEnvironment(testEnv, frameId);
		return oprList ;
	}
	

	@Override
	public OrganizationsList getOrganizationList() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(ORG_LIST_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		//OrganizationsList list = new OrganizationsListImpl(framElmt, frameId);
		OrganizationsList list = new OrganizationsListImpl(framElmt,frameId);
		list._setEnvironment(testEnv, frameId);
		return list;
	}

	
	public ContactList getContactList() {
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(CONT_LIST_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		ContactList contList = new ContactListImpl(framElmt, frameId);
		contList._setEnvironment(testEnv, frameId);
		return contList;
	}

	@Override
	public AccountList getAccountList() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(ACC_LIST_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		AccountList accList = new AccountListImpl(framElmt, frameId);
		accList._setEnvironment(testEnv, frameId);
		return accList;
	}

	@SuppressWarnings("finally")
	@Override
	public OpportunityList getOpportunityList() {
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(OPP_LIST_XPATH)).click();
		try
		{
			pegaDriver.getActiveFrameId(true);
			pegaDriver.findElement(By.xpath(LISTVIEW_XPATH)).click();
			pegaDriver.waitForDocStateReady(1);
			pegaDriver.findElement(By.xpath(OPP_ALL_BUTTON_XPATH)).click();
		}
		catch(Exception e)
		{
			System.out.println("Oppty page has only list view");
		}
		finally{
			String frameId = pegaDriver.getActiveFrameId(false);
			PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
			pegaDriver.switchTo().frame(frameId);
			OpportunityList oppList = new OpportunityListImpl(framElmt, frameId);
			oppList._setEnvironment(testEnv, frameId);
			return oppList;
		}
		
	}

	@Override
	public PartnersList getPartnersList() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(PART_LIST_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		PartnersList ptrList = new PartnersListImpl(framElmt, frameId);
		ptrList._setEnvironment(testEnv, frameId);
		return ptrList ;
	}
	public HouseholdList getHouseholdList() 
	{
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(HHD_LIST_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		HouseholdList hhList = new HouseholdListImpl(framElmt, frameId);
		hhList._setEnvironment(testEnv, frameId);
		return hhList;
	}

	@Override
	public LeadsList getLeadsList() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(LEAD_LIST_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		LeadsList leadList = new LeadsListImpl(framElmt, frameId);
		leadList._setEnvironment(testEnv, frameId);
		return leadList;
	}
	@Override
	public String getLatestRecent() 
	{
		pegaDriver.switchTo().defaultContent();
		return pegaDriver.findElement(By.xpath(RECENTS_LATEST_XPATH)).getText();
	}
	
	@Override
	public AppointmentList getAppointmentsList() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(APP_LIST_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(LISTVIEW_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		AppointmentList appList = new AppointmentListImpl(framElmt, frameId);
		appList._setEnvironment(testEnv, frameId);
		return appList;
	}
	@Override
	public TerritoriesList getTerritoriesList() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(TERR_LIST_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		TerritoriesList terrList = new TerritoriesListImpl(framElmt, frameId);
		terrList._setEnvironment(testEnv, frameId);
		return terrList;
	}
	
	@Override
	public ToolsList getToolsList() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(TOOLS_LIST_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		ToolsList toolsList= new ToolsListImpl(framElmt, frameId);
		toolsList._setEnvironment(testEnv, frameId);
		return toolsList;

	}



	@Override
	public QuickCreate getQuickCreate() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(QUICK_CREATE_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		QuickCreate quick= new QuickCreateImpl(framElmt, frameId);
		quick._setEnvironment(testEnv, frameId);
		return quick;
	}



	@Override
	public Pulse getPulseList() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(PULSE_LIST_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Pulse pulseList= new PulseImpl(framElmt, frameId);
		pulseList._setEnvironment(testEnv, frameId);
		return pulseList;
		
	}



	@Override
	public EngagementMaps getEngagementMaps() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(EGMAP_LIST_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		EngagementMaps egMaps= new EngagementMapsImpl(framElmt, frameId);
		egMaps._setEnvironment(testEnv, frameId);
		return egMaps;
	}



	@Override
	public Forecast getForecast() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(FORECAST_LIST_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Forecast forecast= new ForecastImpl(framElmt, frameId);
		forecast._setEnvironment(testEnv, frameId);
		return forecast;
	}



	@Override
	public ClosePlans getClosePlans() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(FORECAST_LIST_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(CLOSEPLANS_LIST_XPATH)).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		ClosePlans closeplans= new ClosePlansImpl(framElmt, frameId);
		closeplans._setEnvironment(testEnv, frameId);
		return closeplans;
		
	} 
	
}
