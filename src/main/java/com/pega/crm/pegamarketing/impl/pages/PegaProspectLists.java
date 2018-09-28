package pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import pegamarketing.impl.rules.PegaProspectImport;
import pegamarketing.pages.ProspectLists;
import pegamarketing.rules.ProspectImport;

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
