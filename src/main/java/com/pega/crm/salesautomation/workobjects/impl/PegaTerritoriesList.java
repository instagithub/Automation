package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Territories;
import com.pega.crm.salesautomation.workobjects.TerritoriesList;
import com.pega.ri.WizardImpl;

public class PegaTerritoriesList extends WizardImpl implements TerritoriesList {

	public PegaTerritoriesList(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
		// TODO Auto-generated constructor stub
	}

	String TERR_PARENT_HANDLE;
	

	
	@Override
	public Territories createTerritory() {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement((CREATE_TERR_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		Territories trr = new PegaTerritory(frameId, testEnv);
		return trr;	
		
	}

	@Override
	public Territories navigateTerritory(String territoryName) 
	{
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement((TRR_FILTER_PLACEHOLDER_XPATH)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.findElement((TRR_FILTER_PLACEHOLDER_XPATH)).sendKeys(territoryName);
		findElement((TRR_FILTERBUTTON_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		findElement((TRR_NAME_XPATH)).doubleClick();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		Territories trr = new PegaTerritory(frameId, testEnv);
		return trr;
		
	}
	public String getTerritoryID(String territoryName)
	{
		pegaDriver.findElement((TRR_FILTER_PLACEHOLDER_XPATH)).sendKeys(territoryName);
		findElement((TRR_FILTERBUTTON_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(1);
		String territoryId= pegaDriver.findElement(By.xpath(TRR_TERRIOTRYID_XPATH)).getText();
		return territoryId;
		
	}
	@Override
	public String getTerritoryPageHeader() {
		pegaDriver.getActiveFrameId(true);
		String trrHeader=pegaDriver.findElement((TRR_TERRITORY_PAGE_HEADER_XPATH)).getText();
		return trrHeader;
	}

	@Override
	public boolean isCreateTerritoryButtonDisplayed() {
		pegaDriver.getActiveFrameId(true);
		return (pegaDriver.findElement((CREATE_TERR_BTN_XPATH)).isVisible());
	}

	@Override
	public boolean isFilterTextBoxDisplayed() {
		pegaDriver.getActiveFrameId(true);
		return (pegaDriver.findElement((TRR_SEARCH_FIELD_ID)).isVisible());
	}

	@Override
	public String getFilterPlaceHolder() {
		pegaDriver.getActiveFrameId(true);
		return (pegaDriver.findElement((TRR_FILTER_PLACEHOLDER_XPATH)).getAttribute("placeholder"));
	}

	@Override
	public boolean isRefreshIconDisplayed() {
		pegaDriver.getActiveFrameId(true);
		return (pegaDriver.findElement((TRR_REFRESH_XPATH)).isVisible());
	}

	@Override
	public boolean isHistoryIconDisplayed() {
		pegaDriver.getActiveFrameId(true);
		return (pegaDriver.findElement((TRR_HISTORY_XPATH)).isVisible());
	}

	@Override
	public boolean isTreeViewIconDisplayed() {
		pegaDriver.getActiveFrameId(true);
		return (pegaDriver.findElement((TRR_TREEVIEW_XPATH)).isVisible());
	}

	@Override
	public ArrayList<String> getTableHeaders() {
		pegaDriver.getActiveFrameId(true);
		ArrayList<String> s= new ArrayList<String>();
		List<WebElement> wb=pegaDriver.findElements(By.xpath(TRR_TABLE_HEADER_XPATH));
		for(WebElement w:wb)
		{
			String s1=w.getText();
			System.out.println(s1);
			s.add(s1);
		}
		return s;
	}

}
