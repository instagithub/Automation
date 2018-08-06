package com.pega.pm.impl.pages;

import com.pega.TestEnvironment;
import com.pega.pm.impl.rules.PegaRuleInstance;
import com.pega.pm.pages.Geofence;

public class PegaGeofence extends PegaRuleInstance implements Geofence {

	public PegaGeofence(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}
}


