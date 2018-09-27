package com.pega.explorer;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import com.google.inject.Inject;
import com.pega.Browser;
import com.pega.MyBrowser;
import com.pega.MyTestEnvironment;
import com.pega.TestEnvironment;
import com.pega.cs.CSPortal;
import com.pega.cs.interactions.Interactions;
import com.pega.cs.interactions.NewInboundInteraction;
import com.pega.cs.interactions.PhoneCall;
import com.pega.cs.tiles.TopNav;
import com.pega.cs.utils.CommonMethods;
import com.pega.framework.PegaWebDriver;
import com.pega.ri.Wizard;
import com.pega.tiles.TopNavFixture;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;


@ScenarioScoped

public class DesignerStudioFixture {
	
	private Browser browser;
	private TopNav topNav;
	private CommonMethods commonMethods;
	private PegaWebDriver pegaDriver;
	TestEnvironment testEnv;
	private CSPortal csPortal;
	public String frameId = null;
	public Wizard newWizard = null;
	private TopNav topnav;
	
	String filePath= "C:\\AutoItScript\\sample.exe";

	@Inject
	public DesignerStudioFixture(MyBrowser browser,MyTestEnvironment testEnv) {
		this.browser = browser;
		topnav = browser.getPortal(CSPortal.class).getTopNav();
		commonMethods = testEnv.getCommonMethods();
		pegaDriver = testEnv.getPegaDriver();
	}
	
	
	@Then("^User verifies following app types at new app wizard$")
	public void user_verifies_following_app_types_at_new_app_wizard(DataTable AppTypes) throws Throwable {
		List<List<String>> listOfFields = AppTypes.raw();
		for(List<String> row:listOfFields){
			pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//*[contains(text(),'"+row.get(0)+"')]"));
			Assert.assertTrue(row.get(0)+" App type is not available",
					pegaDriver.verifyElement(By.xpath("//*[contains(text(),'"+row.get(0)+"')]")));
		}
	}
	@Then("^User verifies fields at confirmation page$")
	public void user_verifies_fields_at_confirmation_page(DataTable Fields) throws Throwable {
		List<List<String>> listOfFields = Fields.raw();
		for(List<String> row:listOfFields){
			pegaDriver.switchToActiveFrame();
			Assert.assertTrue(row.get(0)+" Field is not available",
					pegaDriver.verifyElement(By.xpath("//button[contains(text(),'"+row.get(0)+"')]")));
		}
	}
	@Then("^User verifies case type selection page$")
	public void user_verifies_case_type_selection_page(DataTable CaseType) throws Throwable {
		List<List<String>> listOfFields = CaseType.raw();
		for(List<String> row:listOfFields){
			pegaDriver.switchToActiveFrame();
			Assert.assertTrue(row.get(0)+" Case Type is not available",
					pegaDriver.verifyElement(By.xpath("//*[contains(text(),'"+row.get(0)+"')]")));
		}
	  
	}
	@Then("^User verifies channel selection page$")
	public void user_verifies_channel_selection_page(DataTable CaseType) throws Throwable {
		List<List<String>> listOfFields = CaseType.raw();
		for(List<String> row:listOfFields){
			pegaDriver.switchToActiveFrame();
			Assert.assertTrue(row.get(0)+" Case Type is not available",
					pegaDriver.verifyElement(By.xpath("//*[contains(text(),'"+row.get(0)+"')]")));
		}
	}
	@Then("^User verifies CUSTOMER DECISION HUB page$")
	public void user_verifies_CUSTOMER_DECISION_HUB_page() throws Throwable {
		pegaDriver.switchToActiveFrame();
		Assert.assertTrue("Field not available",
				pegaDriver.verifyElement(By.xpath("//*[text()='Customer Decision Hub']")));
		
	}
	@Then("^User verifies data type page$")
	public void user_verifies_data_type_page(DataTable DataType) throws Throwable {
		List<List<String>> listOfFields = DataType.raw();
		for(List<String> row:listOfFields){
			pegaDriver.switchToActiveFrame();
			Assert.assertTrue(row.get(0)+" Data Type is not available",
					pegaDriver.verifyElement(By.xpath("//*[contains(text(),'"+row.get(0)+"')]")));
		}
	    
	}
	@Then("^user verifies advanced configuration page$")
	public void user_verifies_advanced_configuration_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	
	@Then("^User will verify the creation status$")
	public void user_will_verify_the_creation_status() throws Throwable {
		pegaDriver.handleWaits();
		pegaDriver.waitForDocStateReady();
		pegaDriver.switchToActiveFrame();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//*[text()='Congratulations!']"));
		Assert.assertTrue("New application creation unsuccessful",
				pegaDriver.verifyElement(By.xpath("//*[text()='Congratulations!']")));
	}
	
	@Then("^User verifies the button \"([^\"]*)\" is enabled$")
	public void user_verifies_the_button_is_enabled(String arg1) throws Throwable {
	   
	}
	
	@Then("^User verifies check box \"([^\"]*)\"$")
	public void user_verifies_check_box(String arg1) throws Throwable {
	   
	}

	@Then("^User ensures the reindex is completed$")
	public void user_ensures_the_reindex_is_completed() throws Throwable {
	   
	}

}
