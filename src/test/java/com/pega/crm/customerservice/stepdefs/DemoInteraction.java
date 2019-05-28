package com.pega.crm.customerservice.stepdefs;

import com.google.inject.Inject;
import com.pega.CRMTestEnvironment;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.NewDemoInteraction;
import com.pega.crm.customerservice.utils.CommonMethods;
import com.pega.framework.PegaWebDriver;
import com.pega.ri.Wizard;

import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class DemoInteraction {

	private NewDemoInteraction demoInteraction;
	private CommonMethods commonMethods;
	private Interactions interaction;
	private PegaWebDriver pegaDriver;
	public String frameId = null;
	public Wizard newWizard = null;

	@Inject
	public DemoInteraction(NewTopNav topNavFixture, CRMTestEnvironment testEnv) {
		demoInteraction = topNavFixture.getDemoInteraction();
		interaction = topNavFixture.getInteractions();
		commonMethods = testEnv.getCommonMethods();
		pegaDriver = testEnv.getPegaDriver();
	}

}
