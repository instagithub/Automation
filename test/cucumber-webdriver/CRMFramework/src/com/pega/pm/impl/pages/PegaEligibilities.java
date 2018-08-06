package com.pega.pm.pages;

import com.pega.TestEnvironment;
import com.pega.pm.rules.PegaPropositionFilter;
import com.pega.pm.rules.PegaWhenRule;
import com.pega.pm.rules.PropositionFilter;
import com.pega.pm.rules.WhenRule;

public class PegaEligibilities extends PegaLandingPage implements Eligibilities {

	public PegaEligibilities(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public WhenRule createWhenRule() {
		findElement(CREATE_BUTTON).click();
		findElement(CREATE_WHEN_CONDITION_OPTION).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		WhenRule when = new PegaWhenRule(frameId, testEnv);
		return when;
	}

	public PropositionFilter createPropositionFilter() {
		findElement(CREATE_BUTTON).click();
		findElement(CREATE_PROPOSTION_FILTER_OPTION).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		PropositionFilter propositionFilter = new PegaPropositionFilter(frameId, testEnv);
		return propositionFilter;
	}

}
