package com.pega.crm.customerservice.tiles.impl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.pe.workobjects.JobApplication;
import com.pe.workobjects.MyWorkListPE;
import com.pe.workobjects.impl.JobApplicationImpl;
import com.pe.workobjects.impl.MyWorkListPEImpl;
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
import com.pega.page.TopDocumentImpl;

public class PegaLeftNav extends TopDocumentImpl implements LeftNav {

	public String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public String VERSION = "$Id: PegaLeftNav.java 117333 2018-10-01 09:12:21Z $";

	String ORG_LIST_XPATH = "//span[text()='Organizations']";
	String OPR_DASHBOARD = "//span[text()='Dashboard']";
	String OPR_LIST_XPATH = "//span[text()='Operators']";
	String CONT_LIST_XPATH = "//span[text()='Contacts']";
	String ACC_LIST_XPATH = "//span[text()='Accounts']";
	String OPP_LIST_XPATH = "//span[text()='Opportunities']";
	String LISTVIEW_XPATH = PegaUtil.getSegmentedButtonXPath("List view");
	String PART_LIST_XPATH = "//span[text()='Partners']";
	String HHD_LIST_XPATH = "//span[text()='Households']";
	String LEAD_LIST_XPATH = "//span[text()='Leads']";
	String APP_LIST_XPATH = "//span[text()='Appointments']";
	String TERR_LIST_XPATH = "//span[text()='Territories']";
	String RECENTS_LATEST_XPATH = "//div[@node_name='RecentItem'][@index='1']//a";
	String OPP_ALL_BUTTON_XPATH = PegaUtil.getSegmentedButtonXPath("All");
	String TOOLS_LIST_XPATH = "//span[text()='Tools']";
	String QUICK_CREATE_XPATH = "//a[contains(@name,'SFAPortalLeftPanel')]";
	String PULSE_LIST_XPATH = "//span[text()='Pulse']";
	String EGMAP_LIST_XPATH = "//span[text()='Engagement Map']";
	String FORECAST_LIST_XPATH = "//span[text()='Forecast']";
	String CLOSEPLANS_LIST_XPATH = "//h3[text()='Close plans']";
	
	String Name = "Jason";
	String DOB = "1/1/1990";
	String Mobile = "6060609090";
	String Address = "California, USA";

	public PegaLeftNav(TestEnvironment testEnv) {
		super(testEnv);

	}

	@Override
	public OperatorList getOperatorsList() {
		findElement(By.xpath(OPR_LIST_XPATH)).click();

		String frameId = getActiveFrameId(false);
		OperatorList oprList = new PegaOperatorList(frameId, testEnv);
		return oprList;
	}

	@Override
	public OrganizationsList getOrganizationList() {

		findElement(By.xpath(ORG_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
		OrganizationsList list = new PegaOrganizationsList(frameId, testEnv);
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

		String frameId = getActiveFrameId(false);
		OpportunityList oppList = new PegaOpportunityList(frameId, testEnv);
		try {

			oppList.findElement(By.xpath(LISTVIEW_XPATH)).click();

			oppList.findElement(By.xpath(OPP_ALL_BUTTON_XPATH)).click();
		} catch (Exception e) {
			System.out.println("Oppty page has only list view");
		}
		return oppList;

	}

	@Override
	public PartnersList getPartnersList() {

		findElement(By.xpath(PART_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
		PartnersList ptrList = new PegaPartnersList(frameId, testEnv);
		return ptrList;
	}

	public HouseholdList getHouseholdList() {

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
	public String getLatestRecent() {
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
		Forecast forecast = new PegaForecast(frameId, testEnv);
		return forecast;
	}

	@Override
	public ClosePlans getClosePlans() {
		findElement(By.xpath(FORECAST_LIST_XPATH)).click();
		String frameId = getActiveFrameId(false);
		ClosePlans closeplans = new PegaClosePlans(frameId, testEnv);
		closeplans.findElement(By.xpath(CLOSEPLANS_LIST_XPATH)).click();
		return closeplans;

	}

	@Override
	public MyWorkListPE getWorkList() {
		// TODO Auto-generated method stub
		findElement(By.xpath("//*[@data-test-id='201804190311430750141' and text()='My WorkList']")).click();
		String frameId = getActiveFrameId(false);
		MyWorkListPE list = new MyWorkListPEImpl(frameId, testEnv);
		return list;
	}
	
	public void launchJobApplication() {
		
		findElement(By.xpath("//*[@title='New']")).click();
		pegaDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		findElement(By.xpath("//*[@title='Job Application']")).click();
		pegaDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//String frameId = getActiveFrameId(false);
		//JobApplication link = new JobApplicationImpl(frameId, testEnv);
		//return link;
	}
	
public void launchExpenseReport() {
		
		findElement(By.xpath("//*[@title='New']")).click();
		pegaDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		findElement(By.xpath("//*[@title='Expense Report']")).click();
		pegaDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//String frameId = getActiveFrameId(false);
		//JobApplication link = new JobApplicationImpl(frameId, testEnv);
		//return link;
	}
	
	public void enterDetails() {
		
		verifyElement(PERSONAL_DETAILS);
		verifyElement(PROFESSIONAL_EXPERIENCE);
		verifyElement(SKILLSET);
		findElement(APPLICANT_NAME).sendKeys(Name);
		findElement(DATE_OF_BIRTH).sendKeys(DOB);
		findElement(MOBILE_INPUT).sendKeys(Mobile);
		findElement(ADDRESS_INPUT).sendKeys(Address);
		findElement(CONTINUE_BUTTON).click();
		pegaDriver.waitForDocStateReady();
		findElement(TOTAL_EXPERIENCE).sendKeys("10");
		findElement(PREVIOUS_ORGANIZATION).sendKeys("TESLA");
		findElement(CURRENT_JOB_ROLE).sendKeys("LEAD");
		findSelectBox(JOB_TYPE).selectByIndex(2);
		findElement(CONTINUE_BUTTON).click();
		pegaDriver.waitForDocStateReady();
		findElement(AREA_OF_EXPERTISE).sendKeys("Robotics");
		findElement(SECONDARY_SKILLS).sendKeys("AI");
		findElement(SUBMIT_BUTTON).click();
		pegaDriver.waitForDocStateReady();
						
	}
	
	public void reviewDetails() {
		verifyElement(REVIEW_TEXT);
		findElement(SUBMIT_BUTTON).click();
		pegaDriver.waitForDocStateReady();
		//String Applicant = findElement(APPLICANT_NAME_TEXT).getText();
		//Assert.assertEquals(Name, Applicant);
		verifyElement(STATUS);
	}
	
public void enterExpenseDetails() {
		
		verifyElement(EXPENSE_DETAILS);
		findElement(DEPARTMENT_ID).sendKeys("D-20");
		findElement(DEPARTMENT_INPUT).click();
		findElement(PROJECT_MANAGER).sendKeys("Karl Maxon");
		findElement(CONTINUE_BUTTON).click();
		pegaDriver.waitForDocStateReady();
		findElement(CATEGORY_INPUT).click();
		findElement(AMOUNT_INPUT).sendKeys("20000");
		findElement(INCURRED_DATE).sendKeys("1/1/2021");
		findElement(SUBMIT_BUTTON).click();
		pegaDriver.waitForDocStateReady();
								
	}
	
	public void reviewExpenseDetails() {
	
		findElement(ADD_TASK).click();
		pegaDriver.waitForDocStateReady();
		findElement(TASK_INSTRUCTIONS).sendKeys("Expense report for referral bonuses submitted");
		findElement(SUBMIT_BUTTON).click();
		pegaDriver.waitForDocStateReady();
		verifyElement(STATUS);
	}

}
