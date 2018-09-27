package com.pega.pm.impl.pages;

import com.pega.TestEnvironment;
import com.pega.pm.impl.rules.PegaProspectImport;
import com.pega.pm.pages.ProspectLists;
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
