package com.pega.crm.pegamarketing.impl.rules;

import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.rules.Treatment;
import com.pega.framework.PegaWebElement;

public class PegaTreatment extends PegaRuleInstance implements Treatment {

	public PegaTreatment(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public void setKeyCode(String keyCode) {
		findElement(KEY_CODE_TEXT_BOX).sendKeys(keyCode + Keys.TAB);
	}
	
	public void writeContent(String string) {
		PegaWebElement frameElement = findElement(TREATMENT_CONTENT_IFRAME);
		findFrame(frameElement);
		findElement(TREATMENT_BODY).clear();
		findElement(TREATMENT_BODY).sendKeys(string);
		pegaDriver.switchTo().parentFrame();
	}
}

