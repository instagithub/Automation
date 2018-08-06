package com.pega.pm.pages;

import com.pega.TestEnvironment;
import com.pega.pm.rules.PegaRuleInstance;

public class PegaGeofence extends PegaRuleInstance implements Geofence {

	public PegaGeofence(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}
}


