package com.pega.crm.customerservice.interactions.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.interactions.ResearchInteraction;
import com.pega.crm.customerservice.tiles.TopNav;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;

public class PegaResearchInteraction extends PegaInteractions implements ResearchInteraction{
	
	public PegaResearchInteraction(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	public String frameId = null;
	public Wizard newWizard = null;
	
	private static final String CS_SOCIAL_OPERATORID_XPATH = "//span/a[contains(@data-click,'showMenu')]";
	private static final String CS_SOCIAL_IMPL_LOGOFF_XPATH = "//span[@class='menu-item-title' and text()='Log off' or @class='menu-item-title' and text()='Logout']";
	
@Override
	public void socialportallogout() {
		int windowsCount = pegaDriver.getWindowHandles().size();
		
		while (windowsCount > 1) {
			testEnv.getBrowser().switchToWindow(windowsCount);
			testEnv.getBrowser().close();
			windowsCount--;
			
		}
		testEnv.getBrowser().switchToWindow(windowsCount);
		findElement(By.xpath(CS_SOCIAL_OPERATORID_XPATH)).click(false);
		findElement(By.xpath(CS_SOCIAL_IMPL_LOGOFF_XPATH)).click(false);
	}
	

@Override
	public void selectLinkUnderShareandFeedback(String linkName) {
		String initialXPATH = "//a[text()='#sericecase#']";
		String finalXPath = new String(initialXPATH).replace("#sericecase#", linkName);
		PegaWebElement mailArticle = findElement(By.xpath(finalXPath));
		mailArticle.click();

	}

@Override
	public void selectandSearchResearchType(String searchType, String value) {
		DropDown selectType = findSelectBox(By.xpath(TopNav.SELECT_DATA_SOURCE_XPATH));
		selectType.selectByValue(searchType);

		findElement(By.xpath(TopNav.SEARCH_BOX_XPATH)).sendKeys(Keys.CLEAR);
		findElement(By.xpath(TopNav.SEARCH_BOX_XPATH)).sendKeys(value);
		findElement(By.xpath(TopNav.SEARCH_ITEM_XPATH)).click();

	}

	
	

}
