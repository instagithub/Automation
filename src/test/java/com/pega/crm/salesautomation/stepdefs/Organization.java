package com.pega.crm.salesautomation.stepdefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.CRMBrowser;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.SFAPortal;
import com.pega.crm.salesautomation.workobjects.Organizations;
import com.pega.crm.salesautomation.workobjects.OrganizationsList;
import com.pega.framework.PegaWebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class Organization
{

	
	private SFAPortal sfaPortal =null;
	private TestEnvironment testEnv;
	private CRMBrowser browser;
	private PegaWebDriver pegaDriver;
	Organizations organization, org;
	OrganizationsList orgList,organizationList,orgResult;
	public static String Subject=null; 
	
	@Inject
	public Organization(TestEnvironment testEnv, CRMBrowser browser){
		this.testEnv = testEnv;
		this.browser = browser;
		pegaDriver=testEnv.getPegaDriver();
		sfaPortal = browser.getPortal(SFAPortal.class);
	}
	
	
	/* 
	 * 
	 * *************************************************************************
	 * 
	 * 			Organization Creation
	 * 
	 * *************************************************************************
	 * 
 	 */
	
	
	public String website = new String("www.pega.com");
	public String OrgphoneNo = new String("12354789");
	public String OrgIndustry= new String("Financial Services");
	public String OrgShortName= new String("Org Short Name");
	public String OrganizationWOName = "Automation Org";
	public StringBuffer OrganizatonName;
	public String CurrentOrganization;
	public String OrganizationTerritory= "Global";
	public String OrgEmployeeCount = new String("10");
	public String OrgTicker = new String("Pega");
	public String OrgRevenue = new String("100");
	public String AcntRevenue = new String("100.00");
	public boolean	OrgTarget = true;
	public String parentOrg = "Wellmark";
	public String NewParentOrg = "APW Technologies Corp";
	public String OrgDescription = "The Acme Corporation is a fictional corporation that "
									+ "features prominently in the Road Runner/Wile E. "
									+ "Coyote cartoons as a running gag featuring outlandish "
									+ "products that fail or backfire catastrophically at the worst possible times. "
									+ "The name is also used as a generic title in many cartoons, "
									+ "films, TV series, commercials and comic strips. "
									+ "It is used also as an organization's placeholder name.";
	public static int rand= (new Random()).nextInt(100);
    public String[] domains= {new String((rand)+"pega.com"),new String((rand)+"in.pega.com")};
	public String OrgStreet = new String("Raheja IT Park"); 
	public String OrgCity = new String("Hyderabad");
	public String OrgState = new String("Telangana");
	public String OrgPostalCode = new String("500019");
	public String OrgCountry = new String("India");
	String Org_SubTabs [] =  {"Pulse","Details","Accounts","Opportunities","Contacts","Leads","Trends","Activities","Attachments"};
	List<String> ORG_WO_SUBTABS = new ArrayList<String>(Arrays.asList(Org_SubTabs));
	
	
	
	
	@When("^SalesOps navigates to Organization tab to Create Org$")
	public void naivgateToOrgTab()  {
		
	}

	@Then("^Verify that user navigates to Organization tab$")
	public void verifyOrgTab()  {
		organizationList= browser.orgList;
		organizationList.verifyOrgListpage();
	}

	@When("^SalesOps clicks on Create Oranization button$")
	public void createOrg()  {
		
		organizationList= browser.orgList;
		
		try {
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		
		organization = organizationList.createOrganization();
	}

	@Then("^verify that Organization New harness is displayed$")
	public void verifyNewHarnessIsDisplayed()  {
	    
	    Assert.assertTrue(organization.verifyOrgNewHarness());
	}

	@When("^SalesOps enters the data and submits$")
	public void salesmanager_enters_the_data_and_submits()  {
		
		organization.setWebsite(website);
		
		organization.setPhoneNumber(OrgphoneNo);
		organization.setIndustry(OrgIndustry);
		organization.setShortName(OrgShortName);
		organization.setTickerSymbol(OrgTicker);
		organization.setEmployees(OrgEmployeeCount);
		organization.setRevenue(OrgRevenue);		
		organization.setTarget(OrgTarget);
		organization.setParentOrganization(parentOrg);
		organization.setDescription(OrgDescription);
		organization.setName(OrganizationWOName);
		organization.setAddress();
		organization.setDomains(domains);
		organization.submit();
	}

	
	
	@Then("^verify that Organization Wo is created$")
	public void verify_that_Organization_Wo_is_created()  {
	
		Assert.assertEquals(OrganizationWOName,(organization.getName()));		
		Assert.assertEquals(website,(organization.getWebsite()));
		Assert.assertEquals((OrgIndustry.toLowerCase()),(organization.getIndustry().toLowerCase()));
		Assert.assertEquals(OrgphoneNo,(organization.getPhoneNumber()));
		Assert.assertEquals(OrgShortName,(organization.getShortName()));
		Assert.assertEquals(OrgTicker,(organization.getTickerSymbol()));
		Assert.assertEquals(OrgEmployeeCount,(organization.getEmployees()));
		Assert.assertTrue(((organization.getRevenue())).contains(OrgRevenue));
		if(organization.getTarget()== "Yes")
			Assert.assertTrue(OrgTarget);		
		Assert.assertTrue(parentOrg.equals(organization.getParentOrganization()));
		organization.getDescription();
		Assert.assertTrue(organization.verifyOrgNews());
		//Verify the Organization WO tabs
		organization.verifySubTabs();
	}

	@When("^SalesOps navigates to Orgaization tab again$")
	public void salesmanager_navigates_to_Orgaization_tab_again()  {
		organizationList= browser.orgList;
		organizationList.verifyOrgListpage();
		
	}

	@Then("^SaleOps search for the Organization$")
	public void saleops_search_for_the_Organization() throws Throwable {

	organizationList= browser.orgList;

	orgResult = organizationList.searchOrganization(OrganizationWOName);
	organization = orgResult.openOrganization(OrganizationWOName);
	     
	}

	@When("^SaleOps Opens the Organization WO(\\d+)$")
	public void saleops_Opens_the_Organization_WO(int arg1) throws Throwable {
	    
		CurrentOrganization = organization.getName();
		
	}

	@Then("^SaleOps validates the Organization work object details$")
	public void saleops_validates_the_Organization_work_object_details() throws Throwable {
	    
		
		Assert.assertEquals(OrganizationWOName,(organization.getName()));
		//Assert.assertEquals(OrganizationTerritory,(organization.getTerritory().trim()));
		Assert.assertEquals(website,(organization.getWebsite()));
		Assert.assertEquals(OrgIndustry.toLowerCase(),(organization.getIndustry().toLowerCase()));
		Assert.assertEquals(OrgphoneNo,(organization.getPhoneNumber()));
		Assert.assertEquals(OrgShortName,(organization.getShortName()));
		Assert.assertEquals(OrgTicker,(organization.getTickerSymbol()));
		Assert.assertEquals(OrgEmployeeCount,(organization.getEmployees()));
		Assert.assertTrue((organization.getRevenue()).contains(OrgRevenue));
		if(organization.getTarget()== "Yes")
			Assert.assertTrue(OrgTarget);		
		Assert.assertEquals(parentOrg,organization.getParentOrganization());
		Assert.assertTrue(organization.verifyOrgNews());
		
		//Verify the Organization WO tabs
		ArrayList<String> subTabs= organization.verifySubTabs();
		Assert.assertEquals(subTabs, ORG_WO_SUBTABS);
	     
	}
	}

		
	