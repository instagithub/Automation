package com.pega.crm.customerservice.tiles.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.tiles.LeftNav;
import com.pega.crm.salesautomation.workobjects.AccountList;
import com.pega.crm.salesautomation.workobjects.ClosePlans;
import com.pega.crm.salesautomation.workobjects.ContactList;
import com.pega.crm.salesautomation.workobjects.Forecast;
import com.pega.crm.salesautomation.workobjects.HouseholdList;
import com.pega.crm.salesautomation.workobjects.LeadsList;
import com.pega.crm.salesautomation.workobjects.OperatorList;
import com.pega.crm.salesautomation.workobjects.OpportunityList;
import com.pega.crm.salesautomation.workobjects.OrganizationsList;
import com.pega.crm.salesautomation.workobjects.PartnersList;
import com.pega.crm.salesautomation.workobjects.TerritoriesList;
import com.pega.crm.salesautomation.workobjects.impl.PegaAccountList;
import com.pega.crm.salesautomation.workobjects.impl.PegaClosePlans;
import com.pega.crm.salesautomation.workobjects.impl.PegaContactList;
import com.pega.crm.salesautomation.workobjects.impl.PegaForecast;
import com.pega.crm.salesautomation.workobjects.impl.PegaHouseholdList;
import com.pega.crm.salesautomation.workobjects.impl.PegaLeadsList;
import com.pega.crm.salesautomation.workobjects.impl.PegaOperatorList;
import com.pega.crm.salesautomation.workobjects.impl.PegaOpportunityList;
import com.pega.crm.salesautomation.workobjects.impl.PegaOrganizationsList;
import com.pega.crm.salesautomation.workobjects.impl.PegaPartnersList;
import com.pega.crm.salesautomation.workobjects.impl.PegaTerritoriesList;
import com.pega.crm.salesautomation.workobjects.impl.PegaUtil;
import com.pega.framework.PegaWebDriver;
import com.pega.page.TopDocumentImpl;

public class PegaLeftNav extends TopDocumentImpl implements LeftNav {

	public String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public String VERSION = "$Id: PegaLeftNav.java 117333 2018-10-01 09:12:21Z $";
	
	private PegaWebDriver pegaDriver = null;
	private TestEnvironment testEnv = null;
	String ORG_LIST_XPATH = "//span[text()='Organizations']";
	String OPR_DASHBOARD="//span[text()='Dashboard']";
	String OPR_LIST_XPATH = "//span[text()='Operators']";
	String CONT_LIST_XPATH ="//span[text()='Contacts']";
	String ACC_LIST_XPATH="//span[text()='Accounts']";
	String OPP_LIST_XPATH="//span[text()='Opportunities']";
	String LISTVIEW_XPATH=PegaUtil.getSegmentedButtonXPath("List view");
	String PART_LIST_XPATH="//span[text()='Partners']";
	String HHD_LIST_XPATH="//span[text()='Households']";
	String LEAD_LIST_XPATH="//span[text()='Leads']";
	String APP_LIST_XPATH="//span[text()='Appointments']";
	String TERR_LIST_XPATH="//span[text()='Territories']";
	String RECENTS_LATEST_XPATH = "//div[@node_name='RecentItem'][@index='1']//a";
	String OPP_ALL_BUTTON_XPATH=PegaUtil.getSegmentedButtonXPath("All");
	String TOOLS_LIST_XPATH="//span[text()='Tools']";
	String QUICK_CREATE_XPATH="//a[contains(@name,'SFAPortalLeftPanel')]";
	String PULSE_LIST_XPATH="//span[text()='Pulse']";
	String EGMAP_LIST_XPATH="//span[text()='Engagement Map']";
	String FORECAST_LIST_XPATH="//span[text()='Forecast']";
	String CLOSEPLANS_LIST_XPATH="//h3[text()='Close plans']";
	public PegaLeftNav(TestEnvironment testEnv) {
		super(testEnv);
		
	}
	
	
	

	@Override
	public OperatorList getOperatorsList() {
		findElement(By.xpath(OPR_LIST_XPATH)).click();
		
		String frameId = getActiveFrameId(false);
		OperatorList oprList = new PegaOperatorList(frameId,testEnv);
		return oprList ;
	}
	

	@Override
	public OrganizationsList getOrganizationList() {
		
		findElement(By.xpath(ORG_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
		//OrganizationsList list = new OrganizationsListImpl(framElmt, frameId);
		OrganizationsList list = new PegaOrganizationsList(frameId,testEnv);
		return list;
	}

	
	public ContactList getContactList() {
		
		
		findElement(By.xpath(CONT_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
		ContactList contList = new PegaContactList(frameId, testEnv);
		return contList;
	}

	@Override
	public AccountList getAccountList() {
		
		findElement(By.xpath(ACC_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
		AccountList accList = new PegaAccountList(frameId, testEnv);
		return accList;
	}

	@SuppressWarnings("finally")
	@Override
	public OpportunityList getOpportunityList() {
		
		
		findElement(By.xpath(OPP_LIST_XPATH)).click();
		try
		{
			
			findElement(By.xpath(LISTVIEW_XPATH)).click();
			
			findElement(By.xpath(OPP_ALL_BUTTON_XPATH)).click();
		}
		catch(Exception e)
		{
			System.out.println("Oppty page has only list view");
		}
		finally{
			String frameId = getActiveFrameId(false);
			OpportunityList oppList = new PegaOpportunityList(frameId, testEnv);
			return oppList;
		}
		
	}

	@Override
	public PartnersList getPartnersList() {
		
		findElement(By.xpath(PART_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
		PartnersList ptrList = new PegaPartnersList(frameId, testEnv);
		return ptrList ;
	}
	public HouseholdList getHouseholdList() 
	{
		
		findElement(By.xpath(HHD_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
		HouseholdList hhList = new PegaHouseholdList(frameId, testEnv);
		return hhList;
	}

	@Override
	public LeadsList getLeadsList() {
		findElement(By.xpath(LEAD_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
		LeadsList leadList = new PegaLeadsList(frameId, testEnv);
		return leadList;
	}
	@Override
	public String getLatestRecent() 
	{
		return findElement(By.xpath(RECENTS_LATEST_XPATH)).getText();
	}
	
	
	@Override
	public TerritoriesList getTerritoriesList() {
		findElement(By.xpath(TERR_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
		TerritoriesList terrList = new PegaTerritoriesList(frameId, testEnv);
		return terrList;
	}



	@Override
	public Forecast getForecast() {
		findElement(By.xpath(FORECAST_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
		Forecast forecast= new PegaForecast(frameId, testEnv);
		return forecast;
	}



	@Override
	public ClosePlans getClosePlans() {
		findElement(By.xpath(FORECAST_LIST_XPATH)).click();
		findElement(By.xpath(CLOSEPLANS_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
		ClosePlans closeplans= new PegaClosePlans(frameId, testEnv);
		return closeplans;
		
	} 
	
}
