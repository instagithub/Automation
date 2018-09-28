package pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import pegamarketing.impl.rules.PegaRuleInstance;
import pegamarketing.pages.RealTimeContainer;

public class PegaRealTimeContainer extends PegaRuleInstance implements RealTimeContainer {

	public PegaRealTimeContainer(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

}
