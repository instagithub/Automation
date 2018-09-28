package com.pega.cs.interactions;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import com.pega.MyTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.ri.Wizard;
import com.pega.tiles.TopNavFixture;
import customerservice.CSPortal;
import customerservice.interactions.Interactions;
import customerservice.interactions.NewDemoInteraction;
import customerservice.interactions.PhoneCall;
import customerservice.utils.CommonMethods;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;


@ScenarioScoped

public class ChildInteractionFixture {

	private PhoneCall phoneInteraction;
	private NewDemoInteraction demoInteraction;
	private Interactions interaction;
	private CommonMethods commonMethods;
	private PegaWebDriver pegaDriver;
	TestEnvironment testEnv;
	private CSPortal csPortal;
	public String frameId = null;
	public Wizard newWizard = null;
	public List<String> caseId = new ArrayList();
	

	@Inject
	public ChildInteractionFixture(TopNavFixture topNavFixture, MyTestEnvironment testEnv) {
		demoInteraction = topNavFixture.getDemoInteraction();
		interaction = topNavFixture.getInteractions();
		commonMethods = testEnv.getCommonMethods();
		pegaDriver = testEnv.getPegaDriver();
	}

	@When("^click on Authorized Contacts to open child interactions$")
	public void click_on_Authorized_Contacts_to_open_child_interactions()  {
	    interaction.openAuthorizedContacts();
	}

	@Then("^verify child interactions$")
	public void verify_child_interactions()  {
	   
	}

		
	@When("^launch child interaction for sara$")
	public void launch_child_interaction_for_sara() {
		interaction.launchChildInteraction();
	}
	
	
	@When("^close the child interaction using the close icon$")
	public void close_the_child_interaction_using_the_close_icon() {
	    interaction.closeChildInteraction();
	}

	@Then("^verify that Parent interaction is focused$")
	public void verify_that_Parent_interaction_is_focused() {
	    
	}
	
	@When("^close the parent interaction using the close icon$")
	public void close_the_parent_interaction_using_the_close_icon() {
	    interaction.closeParentInteractions();
	}

	@When("^select the parent interaction \"([^\"]*)\"$")
	public void select_the_parent_interaction(String contact) {
		interaction.selectInteraction(contact);
	   
	}
	
	@When("^launch child interaction for \"([^\"]*)\"$")
	public void launch_child_interaction_for(String contact) {
		interaction.launchChildInteraction(contact);
	}
	    
}
