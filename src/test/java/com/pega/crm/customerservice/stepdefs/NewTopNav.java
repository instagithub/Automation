package com.pega.crm.customerservice.stepdefs;

import org.openqa.selenium.By;

import com.google.inject.Inject;
import com.pega.Browser;
import com.pega.CRMBrowser;
import com.pega.CRMObjectsBean;
import com.pega.crm.customerservice.CSPortal;
import com.pega.crm.customerservice.designerstudio.ApplicationWizard;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.NewDemoInteraction;
import com.pega.crm.customerservice.interactions.NewInboundInteraction;
import com.pega.crm.customerservice.interactions.OutboundPhoneCall;
import com.pega.crm.customerservice.interactions.PhoneCall;
import com.pega.crm.customerservice.interactions.ResearchInteraction;
import com.pega.crm.customerservice.tiles.TopNav;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class NewTopNav {

	private CSPortal csPortal;
	private Browser browser;
	private NewDemoInteraction demoInteraction;
	private PhoneCall phoneCall;
	private ResearchInteraction researchInteraction;
	private NewInboundInteraction inboundInteraction;
	private OutboundPhoneCall outboundPhoneCall;
	private TopNav topNav;
	public String[] caseStatus = new String[10];
	private ApplicationWizard applicationWizard;
	private Interactions interactions;
	//private DesignerStudio designerStudio;

	@Inject
	public NewTopNav(CRMBrowser browser) {
		this.browser = browser;
		csPortal = browser.getPortal(CSPortal.class);
		topNav = browser.getPortal(CSPortal.class).getTopNav();
	}

	@When("^Demo Interaction for Sara Connor is started$")
	public void demo_Interaction_for_Sara_Connor_is_started() throws Throwable {
		
		demoInteraction = topNav.getInteractionType("Demo Pop - CONNOR");
		interactions = demoInteraction;
	}

	@When("^CSR Accpets the Interaction$")
	public void csr_Accpets_the_Interaction() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		demoInteraction = topNav.returnInteractionType("Accept");
		interactions = demoInteraction;
	}
	
	@When("^CSR launched the New Phone Interaction$")
	public void csr_launched_the_New_Phone_Interaction() throws Throwable {
		
		phoneCall = topNav.getInteractionType("Phone Call");// c
																			// changed
																			// to
																			// C
		interactions = phoneCall;
	}

	@When("^CSR launches Demo Interaction for \"([^\"]*)\"$")
	public void csr_launches_Demo_Interaction_for(String demoInteraction) throws Throwable {
		
		this.demoInteraction = topNav.getDemoInteractionType(demoInteraction);
		interactions = this.demoInteraction;

	}
	
	
	@When("^CSR launches Demo Interaction for \"([^\"]*)\" and accepts the call$")
	public void csr_launches_Demo_Interaction_for_and_accepts_the_call(String demoInteraction) throws Throwable {
		
		this.demoInteraction = topNav.getDemoInteractionType(demoInteraction);
		interactions = this.demoInteraction;
	}
	
	@When("^User launches demo interaction \"([^\"]*)\"$")
	public void user_launches_demo_interaction(String demoInteraction) throws Throwable {
		
		this.demoInteraction = topNav.getDemoInteractionType(demoInteraction);
		interactions = this.demoInteraction;
	}
	@When("^User launches demo interaction as manager \"([^\"]*)\"$")
	public void user_launches_demo_interaction_as_manager(String demoInteraction) throws Throwable {
		
		this.demoInteraction = topNav.getDemoInteractionTypeAsManager(demoInteraction);
		interactions = this.demoInteraction;
	}

	

	@When("^CSR launches Inbound Interaction$")
	public void csr_launches_Inbound_Interaction() {
		
		inboundInteraction = topNav.startInboundCase();
		interactions = inboundInteraction;
	}

	@When("^User places an outbound phone call$")
	public void user_places_an_outbound_phone_call() {
		
		outboundPhoneCall = topNav.getInteractionType("Outbound Phone Call");
		System.out.println(outboundPhoneCall);
		interactions = outboundPhoneCall;
	}

	@Then("^CSR launches Outbound Demo Interaction for \"([^\"]*)\"$")
	public void csr_launches_Outbound_Demo_Interaction_for(String outboundSimulationText) {
		
		outboundPhoneCall = topNav.getDemoInteractionType(outboundSimulationText);
		interactions = outboundPhoneCall;
	}
	
	@Then("^capture outbound interaction ID$")
	public void capture_outbound_interaction_ID() {
		
		String outboundInteractionText = csPortal.findElement(By.xpath("//div[contains(@pyclassname,'PegaCA-Work-Outbound')]/descendant::div[contains(@class,'dataLabelWrite')]")).getText();
		
		int p=outboundInteractionText.indexOf("OC-");
		int q=outboundInteractionText.lastIndexOf("is");
		String caseID = outboundInteractionText.substring(p, q);
		//caseID = outboundInteractionText.substring(14,19);
		caseID=caseID.trim();
		CRMObjectsBean.putObjectNames("CaseID", caseID);
		csPortal.findElement(By.xpath("//button[contains(@data-click,'closeContainer')]/descendant::div[text()='Close']")).click();
	    
	}

	@When("^CSR launches \"([^\"]*)\" research interaction \"([^\"]*)\"$")
	public void csr_launches_research_interaction(String interactionType, String searchText) {

		
		researchInteraction = topNav.searchResult(interactionType, searchText);
		interactions = researchInteraction;
	}

	@When("^CSR searches for \"([^\"]*)\" from search portal$")
	public void csr_searches_for_from_search_portal(String searchString) {
		
		researchInteraction = topNav.search(searchString);
		interactions = researchInteraction;
	}


	
	@Then("^Verify the research object$")
	public void verify_the_research_object() throws Throwable {
		
		researchInteraction = topNav.setResearchInteraction();
		interactions = researchInteraction;
	}
	
	@When("^Select \"([^\"]*)\" and serach for \"([^\"]*)\"$")
	public void select_and_serach_for(String searchType, String value) {
		
		researchInteraction = topNav.selectandSearchResearchType(searchType, value);
		interactions = researchInteraction;
		
	}
	
	
	@When("^Click on Favorites$")
	public void click_on_Favorites()  {
		
		
		
		researchInteraction = topNav.ClickFavourite();
		interactions = researchInteraction;
		
	}
	
	
	@When("^Select the Account \"([^\"]*)\" for Initiate a Call displayed$")
	public void select_the_Account_for_Initiate_a_Call_displayed(String result)  {
	    // Write code here that turns the phrase above into concrete actions
		
		researchInteraction = topNav.initiateACall(result);
		interactions = researchInteraction;
	}

	@When("^close the research interaction flow$")
	public void close_the_research_interaction_flow() {
		
		researchInteraction = topNav.closeInteraction();
		interactions = researchInteraction;

	}
	
	

	
	public NewDemoInteraction getDemoInteraction() {
		return demoInteraction;
	}

	public PhoneCall getPhoneCall() {
		return phoneCall;
	}



	public ResearchInteraction getResearchInteraction() {

		return researchInteraction;
	}

	public NewInboundInteraction getInboundInteraction() {
		return inboundInteraction;
	}



	public Interactions getInteractions() {
		return interactions;
	}

	public OutboundPhoneCall getOutboundPhoneCall() {
		return outboundPhoneCall;
	}

	public ApplicationWizard getApplicationWizard() {

		return applicationWizard;
	}
	


	
		
	@Then("^Admin check for the dataflow status$")
	public void admin_check_for_the_dataflow_status() {
	   
//		
//		topNav.checkDataFlow();
		
	}
	
	
	
	
	@When("^switch to Interaction of \"([^\"]*)\"$")
	public void switch_to_Interaction_of(String interactionItem) {
		
		researchInteraction = topNav.switchInteraction(interactionItem);
		interactions = researchInteraction;
	}
	
	
	
		
	
	

}
	

	

