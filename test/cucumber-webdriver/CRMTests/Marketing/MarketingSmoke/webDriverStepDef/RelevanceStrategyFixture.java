package com.pega.pm.fixtures;

import org.testng.Assert;

import com.google.inject.Inject;
import com.pega.pm.MyBrowser;
import com.pega.pm.PMPortal;
import com.pega.pm.dialog.CategoriesDialog;
import com.pega.pm.dialog.ConfigureAudienceDialog;
import com.pega.pm.dialog.ConfigureOfferDialog;
import com.pega.pm.pages.Strategy;
import com.pega.pm.rules.MarketingStrategy;
import com.pega.pm.rules.MarketingStrategy.ConfigureObjectiveDialog;
import com.pega.pm.utils.ObjectsBean;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class RelevanceStrategyFixture {

	private PMPortal pmPortal;
	private MarketingStrategy marketingStrategy;
	ConfigureObjectiveDialog objectiveDialog;
	ConfigureAudienceDialog audienceDialog;
	ConfigureOfferDialog offerDialog;
	CategoriesDialog categoriesdailog;
	Strategy strategy;
	String name;
	String value;
    String Strategy1,Strategy2;

	@Inject
	public RelevanceStrategyFixture(MyBrowser browser) {
		pmPortal = browser.getPMPortal();
	}

	@When("^User enters strategy name and description as \"([^\"]*)\"$")
	public void user_enters_strategy_name_and_description_as(String name) {
		marketingStrategy = ObjectsBean.getStrategy();
		marketingStrategy.setStrategyName(ObjectsBean.putTimeStampedValue(name));
		marketingStrategy.setDescription(ObjectsBean.getTimeStampedValue(name));
	}

	@When("^User configures the Objective of strategy as Ranked$")
	public void user_configures_the_Objective_of_strategy_as_Ranked() {
		objectiveDialog = marketingStrategy.configureObjective();
		objectiveDialog.addRankedObjective();
	}

	@Then("^User verfies Ranked Objective is added$")
	public void user_verfies_Ranked_Objective_is_added() {
		Assert.assertTrue(objectiveDialog.isRankedAdded());
	}

	@When("^User applies configure modal dialog$")
	public void user_clicks_on_apply_of_configure_modal_dialog() {
		objectiveDialog.apply();
	}

	@Then("^User selects Business Issue as \"([^\"]*)\"$")
	public void user_selects_Business_Issue_as(String issueName) {
		marketingStrategy = ObjectsBean.getStrategy();
		marketingStrategy.setIssue(issueName);
	}

	@Then("^User selects Group as \"([^\"]*)\"$")
	public void user_selects_Group_as(String groupName) {
		marketingStrategy.setGroup(groupName);
	}

	@When("^User selects Audience Driven targeting approach$")
	public void user_selects_Audience_Driven_targeting_approach() {
		marketingStrategy.addAudianceDrivenTargetingApproach();
	}

	@When("^User configure Audience and add segment with name as \"([^\"]*)\"$")
	public void user_configure_Audience_and_add_segment_with_name_as(String segmentName) {
		audienceDialog = marketingStrategy.configureAudience();
		audienceDialog.search(segmentName);
		audienceDialog.addSegment(segmentName);
	}

	@Then("^User verifies that segment is added$")
	public void user_verifies_that_segment_is_added() {
		Assert.assertTrue(audienceDialog.isSegmentAdded());
	}

	@When("^User assigns an offer with name as \"([^\"]*)\"$")
	public void user_assigns_an_offer_with_name_as(String offerName) {
		offerDialog = marketingStrategy.assignOffers();
		offerName = ObjectsBean.getTimeStampedValue(offerName);
		offerDialog.search(offerName);
		offerDialog.addOffer(offerName);
	}

	@Then("^Verify that offer is added$")
	public void verify_that_offier_is_added() {
		Assert.assertTrue(offerDialog.isSegmentAdded());
	}

	@When("^User saves the strategy$")
	public void user_saves_the_strategy() {
		marketingStrategy.save();
	}
	
}
