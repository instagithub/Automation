package com.pe;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import com.google.inject.Inject;
import com.pe.workobjects.JobApplication;
import com.pe.workobjects.DesignerStudioPE;
import com.pe.workobjects.impl.DesignerStudioPEImpl;
import com.pega.CRMBrowser;
import com.pega.CRMTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.crm.customerservice.SFAPortal;
import com.pega.crm.salesautomation.workobjects.AccountList;
import com.pega.crm.salesautomation.workobjects.Accounts;
import com.pega.crm.salesautomation.workobjects.ClosePlans;
import com.pega.crm.salesautomation.workobjects.ContactList;
import com.pega.crm.salesautomation.workobjects.Contacts;
import com.pega.crm.salesautomation.workobjects.Leads;
import com.pega.crm.salesautomation.workobjects.LeadsList;
import com.pega.crm.salesautomation.workobjects.Opportunities;
import com.pega.crm.salesautomation.workobjects.OpportunityList;
import com.pega.crm.salesautomation.workobjects.Organizations;
import com.pega.crm.salesautomation.workobjects.OrganizationsList;
import com.pega.framework.PegaWebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class NewJobApplication {

	private SFAPortal sfaPortal = null;
	private TestEnvironment testEnv;
	private CRMBrowser browser;
	PegaWebDriver pegaDriver;
	JobApplication jobApplication;
	
	@Inject
	public NewJobApplication(CRMTestEnvironment testEnv, CRMBrowser browser) {
		this.testEnv = testEnv;
		this.browser = browser;
		pegaDriver = testEnv.getPegaDriver();
		sfaPortal = browser.getPortal(SFAPortal.class);
		
	}

	/*
	 * 
	 * Personal edition
	 * 
	 */
	
	@Given("^user verifies CaseManager$")
	public void user_verifies_CaseManager() {
		Assert.assertTrue(jobApplication.verifyCaseManager());
	}
	/*
	@Then("^user enters Application details")
	public void user_enters_Application_details() {
		jobApplication.enterDetails();
	}
	
	@Then("^user Reviews Application")
	public void user_Reviews_Application() {
		jobApplication.reviewDetails();
	}*/
	
	
}