package pegamarketing.impl.rules;

import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebElement;
import pegamarketing.rules.Treatment;

public class PegaTreatment extends PegaRuleInstance implements Treatment {

	public PegaTreatment(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public void setKeyCode(String keyCode) {
		findElement(KEY_CODE_TEXT_BOX).sendKeys(keyCode + Keys.TAB);
	}
	
	public void writeContent(String string) {
		pegaDriver.waitForDocStateReady();
		PegaWebElement frameElement = findElement(TREATMENT_CONTENT_IFRAME);
		pegaDriver.switchTo().frame(frameElement.getWebElement());
		findElement(TREATMENT_BODY).clear();
		findElement(TREATMENT_BODY).sendKeys(string);
		pegaDriver.switchTo().parentFrame();
	}
}
