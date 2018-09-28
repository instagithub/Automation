package pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import pegamarketing.impl.rules.PegaRuleInstance;
import pegamarketing.pages.Geofence;

public class PegaGeofence extends PegaRuleInstance implements Geofence {

	public PegaGeofence(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}
}


