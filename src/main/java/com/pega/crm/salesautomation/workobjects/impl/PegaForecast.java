package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.crm.salesautomation.workobjects.Forecast;
import com.pega.ri.WizardImpl;

public class PegaForecast extends WizardImpl implements Forecast{

	String TERRITORY_ID="crmForecastByTerritorySearchTerm";
	String OVERRIDE_ID="ForecastLevelTerritory";
	String YEAR_XPATH="//*[@data-test-id='2014120902580108421219']";
	String FILTERBUTTON_XPATH=PegaUtil.getButtonXpath("Filter");
	String ADVANCED_XPATH="//a[contains(@name,'FilterAdvanced')]";
	String Q1_CLOSED_XPATH="//div[@data-click='ForecastGadget.ForecastSummaryColumn(2).CategoryRow(2)']//div[@pyclassname='PegaCRM-Embed-SFA-ForecastGadget']//a";
	
	public PegaForecast(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isTerritoryDisplayed() {
		
		return pegaDriver.findElement(By.id(TERRITORY_ID)).isVisible();
	}

	@Override
	public boolean isOverrideLevelDisplayed() {
		
		return pegaDriver.findElement(By.id(OVERRIDE_ID)).isVisible();
	}

	@Override
	public boolean isYearDisplayed() {
		return pegaDriver.findElement(By.xpath(YEAR_XPATH)).isVisible();
	}

	@Override
	public boolean isFilterDisplayed() {
		return pegaDriver.findElement(By.xpath(FILTERBUTTON_XPATH)).isVisible();
	}

	@Override
	public boolean isAdvancedDisplayed() {
		return pegaDriver.findElement(By.xpath(ADVANCED_XPATH)).isVisible();
	}

	@Override
	public void setTerritory(String Territory) {
		pegaDriver.findElement(By.id(TERRITORY_ID)).sendKeys(PegaUtil.SelectAll);
		PegaUtil.autoComplete(pegaDriver, TERRITORY_ID, Territory);
		
	}

	@Override
	public void clickFilter() {
		pegaDriver.findElement(By.xpath(FILTERBUTTON_XPATH)).click();
	}

	@Override
	public void setYear(String year) {
		pegaDriver.waitForDocStateReady(true);
		pegaDriver.findSelectBox(By.xpath(YEAR_XPATH)).selectByVisibleText(year);
		
	}

	@Override
	public String getQ1ValueClosed() {
		pegaDriver.getActiveFrameId(true);
		return pegaDriver.findElement(By.xpath(Q1_CLOSED_XPATH)).getText();
	}

	

}
