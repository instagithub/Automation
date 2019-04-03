package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.EngagementMaps;
import com.pega.ri.WizardImpl;

public class PegaEngagementMaps extends WizardImpl implements EngagementMaps{

	public PegaEngagementMaps(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	String EGMAPS_VIEWBY_ID="ViewType";
	String EGMAPS_SELLINGMODE_ID="EngagementMapSellingModes";
	String EGMAPS_PRODUCTCATEGORY_ID="FamilyCategory";
	String EGMAPS_APPLYFILTERS_BUTTON_XPATH=PegaUtil.getButtonXpath("Apply filters");
	String EGMPAS_CLEARFILTERS_BUTTON_XPATH="//a[text()='Clear filters']";
	String EGMAPS_PRODUCTS_XPATH="//div[@pyclassname='PegaCRM-Data-Product']";
	

	@Override
	public boolean isViewByDisplayed() {
		pegaDriver.getActiveFrameId(true);
		return pegaDriver.findElement(By.id(EGMAPS_VIEWBY_ID)).isVisible();
	}

	@Override
	public boolean isSellingModeDisplayed() {
		//pegaDriver.getActiveFrameId(true);
		return pegaDriver.findElement(By.id(EGMAPS_SELLINGMODE_ID)).isVisible();
	}

	@Override
	public boolean isProductCategoryDisplayed() {
		//pegaDriver.getActiveFrameId(true);
		return pegaDriver.findElement(By.id(EGMAPS_PRODUCTCATEGORY_ID)).isVisible();
	}

	@Override
	public boolean isApplyFiltersButtonDisplayed() {
		return pegaDriver.findElement(By.xpath(EGMAPS_APPLYFILTERS_BUTTON_XPATH)).isVisible();
	}

	@Override
	public boolean isClearFiltersButtonDisplayed() {
		// EGMPAS_CLEARFILTERS_BUTTON_XPATH
		return pegaDriver.findElement(By.xpath(EGMPAS_CLEARFILTERS_BUTTON_XPATH)).isVisible();
	}

	@Override
	public void setViewBy(String viewBy) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.id(EGMAPS_VIEWBY_ID)).selectByVisibleText(viewBy);
	}

	@Override
	public void setSellingMode(String sellingMode) {
		pegaDriver.findSelectBox(By.id(EGMAPS_SELLINGMODE_ID)).selectByVisibleText(sellingMode);
	}

	@Override
	public void setProductCategory(String productCategory) {
		pegaDriver.findSelectBox(By.id(EGMAPS_PRODUCTCATEGORY_ID)).selectByVisibleText(productCategory);
	}

	@Override
	public void clickApplyFilters() {
		pegaDriver.findElement(By.xpath(EGMAPS_APPLYFILTERS_BUTTON_XPATH)).click();
		pegaDriver.waitForDocStateReady(4);
	}

	@Override
	public boolean isProductsDisplayed() {
		return pegaDriver.findElement(By.xpath(EGMAPS_PRODUCTS_XPATH)).isVisible();
	}

}
