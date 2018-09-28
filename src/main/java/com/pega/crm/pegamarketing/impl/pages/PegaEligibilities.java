package pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import pegamarketing.impl.rules.PegaPropositionFilter;
import pegamarketing.impl.rules.PegaWhenRule;
import pegamarketing.pages.Eligibilities;
import pegamarketing.rules.PropositionFilter;
import pegamarketing.rules.WhenRule;

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
