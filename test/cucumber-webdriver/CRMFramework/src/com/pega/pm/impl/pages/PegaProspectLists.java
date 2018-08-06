package com.pega.pm.pages;

import com.pega.TestEnvironment;
import com.pega.pm.rules.PegaProspectImport;
import com.pega.pm.rules.ProspectImport;

public class PegaProspectLists extends PegaLandingPage implements ProspectLists {

	public PegaProspectLists(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	@Override
	public ProspectImport createNewPrspectImport() {
	findElement(NEW_BUTTON_XPATH).click();
	String frameId = pegaDriver.getActiveFrameId(true);
	ProspectImport prospectImport = new PegaProspectImport(frameId, testEnv);
	return prospectImport;
	}

}
