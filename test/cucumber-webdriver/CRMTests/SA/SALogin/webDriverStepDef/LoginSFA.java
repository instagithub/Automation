package webDriverStepDef;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import com.pega.framework.PegaWebElement;

import com.google.inject.Inject;
import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.MyBrowser;
import com.pega.cs.SFAPortal;
import com.pega.sfa.workobjects.Login;

import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;



 

@ScenarioScoped
public class LoginSFA  {
	
	private SFAPortal sfaPortal =null;
	
	TestEnvironment testEnv;
	private MyBrowser browser;
	private Scenario scenario;
	private PegaWebDriver pegaDriver;
	private Login login;
	String Rep_LeftNav[]={"Dashboard","My Work","Pulse", "Organizations", "Households", "Accounts","Contacts", "Leads", "Opportunities", "Forecast", "Appointments", "Affinities", "Knowledge","Engagement Map"}; 
	String Manager_LeftNav[]={"Dashboard","My Work","Pulse", "Organizations", "Households", "Accounts","Contacts", "Leads", "Opportunities", "Forecast", "Appointments", "Affinities", "Knowledge","Engagement Map", "Reports"};
	String Ops_LeftNav[]={"Dashboard","My Work","Pulse", "Organizations", "Households", "Accounts","Contacts", "Leads", "Opportunities", "Forecast", "Appointments", "Affinities", "Knowledge","Territories","Partners","Operators","Tools","Reports"};
	//List<String> OPR_LEFTNAV;	
	List<String> OPS_OPR_LEFTNAV = new ArrayList<String>(Arrays.asList(Ops_LeftNav));
	List<String> REP_OPR_LEFTNAV = new ArrayList<String>(Arrays.asList(Rep_LeftNav));
	List<String> MANAGER_OPR_LEFTNAV = new ArrayList<String>(Arrays.asList(Manager_LeftNav));
	
	
	@Inject
	public LoginSFA(TestEnvironment testEnv, MyBrowser browser){
		this.testEnv = testEnv;
		this.browser=browser;
		pegaDriver=testEnv.getPegaDriver();
		sfaPortal = browser.getPortal(SFAPortal.class); 
		this.login=browser.login;
	}
	
	
	@Then("^User will have be logged into the portal with \"([^\"]*)\"$")
	public void user_will_have_be_logged_into_the_portal(String Title){
		login.validateOperator(Title);
	}

	@Then("^Verify Operator name1$")
	public void verify_Operator_name(){
	    
		
	}
	

	@Then("^Verify Left Nav links for \"([^\"]*)\"$")
	public void verify_Left_Nav_links(String UserName) throws Throwable {
			
		//login.validateLeftNav(UserName);
		ArrayList<String> LeftNav;
		if(UserName.equals("sfasalesops"))
		{
			
			LeftNav = login.validateLeftNav();
			Assert.assertEquals(LeftNav, OPS_OPR_LEFTNAV);
		}
		
		if(UserName.equals("tmason"))
		{
			LeftNav = login.validateLeftNav();
			Assert.assertEquals(LeftNav, REP_OPR_LEFTNAV);
		}
		
		if(UserName.equals("skendall"))
		{
				
			LeftNav = login.validateLeftNav();
			Assert.assertEquals(LeftNav, MANAGER_OPR_LEFTNAV);
		}
		
		
	}

	@Then("^Verify all other widgets1$")
	public void verify_all_other_widgets() throws Throwable {
		
		boolean PipelineGadget =pegaDriver.verifyElement(By.xpath("//div[@class='field-item dataLabelWrite heading_2_dataLabelWrite' and text()='Pipeline']"));
		boolean Leaderboards= pegaDriver.verifyElement(By.xpath("//div[@class='field-item dataLabelWrite heading_2_dataLabelWrite' and text()='Leaderboards']"));
		boolean QuotaAttainment=pegaDriver.verifyElement(By.xpath("//div[@class='field-item dataLabelWrite heading_2_dataLabelWrite' and text()='Quota Attainment']"));
		
		Assert.assertTrue(PipelineGadget);	
		Assert.assertTrue(Leaderboards);
		Assert.assertTrue(QuotaAttainment);
		
		pegaDriver.findElement(By.xpath("//div[@class='field-item dataLabelWrite heading_2_dataLabelWrite' and text()='Quota Attainment']")).scrollIntoView();
		
		boolean WinLossAnalysis=pegaDriver.verifyElement(By.xpath("//div[@class='field-item dataLabelWrite heading_2_dataLabelWrite' and text()='Win/Loss Analysis']"));
		boolean LeadtoOpportunityConversions=pegaDriver.verifyElement(By.xpath("//div[@class='field-item dataLabelWrite heading_2_dataLabelWrite' and text()='Lead to pportunity Conversions']"));
		boolean OpportunityRevenuebyIndustry=pegaDriver.verifyElement(By.xpath("//span[@class='field-caption dataLabelForRead heading_2_dataLabelForRead' and text()='Opportunity Revenue by Industry']"));
		boolean OpportunityConversionsbyStage=pegaDriver.verifyElement(By.xpath("//span[@class='field-caption dataLabelForRead heading_2_dataLabelForRead' and text()='Opportunity Conversions by Stage']"));
		boolean LeadsbySource=pegaDriver.verifyElement(By.xpath("//span[@class='field-caption dataLabelForRead heading_2_dataLabelForRead' and text()='Leads by Source']"));
		boolean OpportunitiesbyCompetitor=pegaDriver.verifyElement(By.xpath("//span[@class='field-caption dataLabelForRead heading_2_dataLabelForRead' and text()='Opportunities by Competitor']"));

			
		//Assert.assertEquals("Pipeline",pegaDriver.findElement(By.xpath("//div[@class='field-item dataLabelWrite heading_2_dataLabelWrite']").getText()));
		
		
		String frameId = pegaDriver.getActiveFrameId(false);
		
		
			PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
			System.out.println(frameId);
			pegaDriver.switchTo().frame(frameId);
			pegaDriver.waitForDocStateReady(5);
			
			System.out.println("--         --          --           --         --        -- ");
			Assert.assertTrue(WinLossAnalysis);
			Assert.assertTrue(LeadtoOpportunityConversions);
			Assert.assertTrue(OpportunityRevenuebyIndustry);
			Assert.assertTrue(OpportunityConversionsbyStage);
			Assert.assertTrue(LeadsbySource);
			Assert.assertTrue(OpportunitiesbyCompetitor);	    
	}

	
	@When("^logout of the portal1$")
	public void logout_of_the_portal() throws Throwable {
	  
	}
	@When("^user navigates to MyWork page$")
	public void user_navigates_to_myWork_page() {
	  login.clickMyWork();
	  
	}
	@Then("^user should see all the tabs$")
	public void user_should_see_all_the_tabs(){
		Assert.assertTrue(login.verifyWorkListSection());
		  Assert.assertTrue(login.verifyToDoList());
		  Assert.assertTrue(login.verifySuggestedVisits());
	  
	}
	
	

}