package com.pega.sfa.workobjects;

import com.pega.ri.Wizard;

public interface ClosePlans extends Wizard{
	boolean isFilterMenuDisplayed();
	boolean isApplyButtonDisplayed();
	boolean isExportButtonDisplayed();
	void clickOppty();
	void enterClosePlans(String comments);
	

}
