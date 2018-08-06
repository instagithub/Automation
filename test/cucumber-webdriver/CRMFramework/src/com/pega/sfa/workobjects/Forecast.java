package com.pega.sfa.workobjects;

import com.pega.ri.Wizard;

public interface Forecast extends Wizard{

	boolean isTerritoryDisplayed();
	boolean isOverrideLevelDisplayed();
	boolean isYearDisplayed();
	boolean isFilterDisplayed();
	boolean isAdvancedDisplayed();
	void setTerritory(String Territory);
	void clickFilter();
	void setYear(String year);
	String getQ1ValueClosed();
}
