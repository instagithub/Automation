package com.pega.crm.customerservice.stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.google.inject.Inject;
import com.pega.CRMTestEnvironment;
import com.pega.crm.customerservice.interactions.Interactions;
import com.pega.crm.customerservice.interactions.NewDemoInteraction;
import com.pega.crm.customerservice.utils.CommonMethods;
import com.pega.framework.PegaWebDriver;
import com.pega.ri.Wizard;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

	@Then("^verify the toaster pop values for connor$")
	public void verify_the_toaster_pop_values_for_connor() throws Throwable {
		pegaDriver.switchTo().defaultContent();
		Assert.assertTrue("Incoming call icon not present",
				pegaDriver.verifyElement(By.xpath("//i[@class='cursordefault  icons cti-status pcti-phone cti-status-smart']")));
		Assert.assertTrue("Incoming call text not present",
				pegaDriver.verifyElement(By.xpath("//div[text()='Incoming call...']")));
		Assert.assertTrue("Sara name text not present", pegaDriver.verifyElement(By.xpath("//span[text()='Sara']")));
		Assert.assertTrue("Connor name text not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='Connor']")));
		Assert.assertTrue("phone num text not present",
				pegaDriver.verifyElement(By.xpath("//span[text()='617-374-9637']")));
		Assert.assertTrue("Decline button not visible",
				pegaDriver.verifyElement(By.xpath("//button[@title='Decline the call']")));

	}
		
		
	@When("^CSR accepts the demo call$")
	public void csr_accepts_the_demo_call() {
	    demoInteraction.acceptCall();
		
	}

	
	@When("^user navigates to \"([^\"]*)\" tab$")
	public void user_navigates_to_tab(String tabname) {

		demoInteraction.switchToTab(tabname);

	}
	
}
