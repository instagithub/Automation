package com.pega.crm.salesautomation.workobjects;

import com.pega.ri.Wizard;

public interface EngagementMaps extends Wizard{
	boolean isViewByDisplayed();
	boolean isSellingModeDisplayed();
	boolean isProductCategoryDisplayed();
	boolean isApplyFiltersButtonDisplayed();
	boolean isClearFiltersButtonDisplayed();
	void setViewBy(String viewBy);
	void setSellingMode(String sellingMode);
	void setProductCategory(String productCategory);
	void clickApplyFilters();
	boolean isProductsDisplayed();
	//"//div[@pyclassname='PegaCRM-Data-Product']"
}
