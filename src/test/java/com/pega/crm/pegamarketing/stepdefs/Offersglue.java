package com.pega.crm.pegamarketing.stepdefs;

import org.testng.Assert;

import pegamarketing.pages.Offers;
import pegamarketing.rules.Offer;
import pegamarketing.utils.ObjectsBean;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Offersglue {

	@Then("^Offers landing Page should be displayed$")
	public void treatment_Landing_Page_should_be_displayed() {
		Offers offers = ObjectsBean.getOffers();
		Assert.assertTrue(offers.verifyElement(Offers.OFFERS_PAGE_HEADER),
				"Offers landing page is not opened..!!");
	}

	@When("^User creates offer$")
	public void user_creates_offer() {
		Offers offers = ObjectsBean.getOffers();
		Offer offer= offers.create();
		ObjectsBean.setOffer(offer);
	}

}
