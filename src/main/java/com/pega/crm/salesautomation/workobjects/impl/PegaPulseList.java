package salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;
import salesautomation.workobjects.PulseList;

public class PegaPulseList extends WizardImpl implements PulseList{

	

	public PegaPulseList(PegaWebElement framElmt, String frameId) {
		super(framElmt, frameId);
	}

	

}
