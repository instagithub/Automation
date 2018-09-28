package pegamarketing.impl.pages;

import com.pega.TestEnvironment;
import pegamarketing.impl.rules.PegaEmailTreatment;
import pegamarketing.impl.rules.PegaSMSTreatment;
import pegamarketing.pages.Treatments;
import pegamarketing.rules.EmailTreatment;
import pegamarketing.rules.SMSTreatment;

public class PegaTreatments extends PegaLandingPage implements Treatments {

	public PegaTreatments(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public void create() {
		findElement(CREATE_BUTTON).click();
	}

	public EmailTreatment createEmailTreatment() {
		findElement(CREATE_EMAIL_SPAN).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		EmailTreatment email = new PegaEmailTreatment(frameId, testEnv);
		return email;
	}

	@Override
	public SMSTreatment createSMSTreatment() {
		findElement(CREATE_SMS_SPAN).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		SMSTreatment sms = new PegaSMSTreatment(frameId, testEnv);
		return sms;
	}
}
