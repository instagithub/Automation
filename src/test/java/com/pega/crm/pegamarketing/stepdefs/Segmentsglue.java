package com.pega.crm.pegamarketing.stepdefs;

import org.openqa.selenium.By;
import org.testng.Assert;

import pegamarketing.pages.Segments;
import pegamarketing.rules.RuleInstance;
import pegamarketing.rules.Segment;
import pegamarketing.utils.ObjectsBean;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class Segmentsglue {

	private Segments segments;

	@When("^User creates segment by clicking on Create button$")
	public void user_creates_segment_by_clicking_on_Create_button() {
		segments = ObjectsBean.getSegments();
		Segment segment = segments.createSegment();
		ObjectsBean.setSegment(segment);
	}

	@Then("^Verifies the newly created segment rule \"([^\"]*)\" in Audiences landing page$")
	public void verifies_the_newly_created_segment_rule_in_Audiences_landing_page(String segmentName) throws Throwable {
		String actualSegName = ObjectsBean.getTimeStampedValue(segmentName);
		Assert.assertTrue(segments.verifyElement(By.linkText(actualSegName)),
				"Newly create segment could not be found in Segments landing page..!!");
	}

	@Then("^Open and verifies the newly created segment rule \"([^\"]*)\"$")
	public void open_and_verifies_the_newly_created_segment_rule(String segName) {
		Segment segment = segments.openSegmentRule(ObjectsBean.getTimeStampedValue(segName));
		Assert.assertTrue(segment.verifyElement(RuleInstance.SAVEAS_BTN),
				" Segment rule is not saved successfully..!!");
	}
	
}
