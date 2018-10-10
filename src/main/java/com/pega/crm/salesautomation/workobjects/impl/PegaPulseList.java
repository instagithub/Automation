package com.pega.crm.salesautomation.workobjects.impl;

import com.pega.crm.salesautomation.workobjects.PulseList;
import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;

public class PegaPulseList extends WizardImpl implements PulseList{

	

	public PegaPulseList(PegaWebElement framElmt, String frameId) {
		super(framElmt, frameId);
	}

	

}
