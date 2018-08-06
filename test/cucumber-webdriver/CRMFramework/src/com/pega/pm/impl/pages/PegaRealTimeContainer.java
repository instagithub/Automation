package com.pega.pm.impl.pages;

import com.pega.TestEnvironment;
import com.pega.pm.impl.rules.PegaRuleInstance;
import com.pega.pm.pages.RealTimeContainer;

public class PegaRealTimeContainer extends PegaRuleInstance implements RealTimeContainer {

	public PegaRealTimeContainer(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

}
