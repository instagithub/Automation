package com.pega.pm.pages;

import com.pega.TestEnvironment;
import com.pega.pm.rules.PegaRuleInstance;

public class PegaRealTimeContainer extends PegaRuleInstance implements RealTimeContainer {

	public PegaRealTimeContainer(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

}
