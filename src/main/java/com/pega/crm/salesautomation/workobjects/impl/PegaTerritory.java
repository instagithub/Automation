package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.crm.salesautomation.workobjects.Territories;
import com.pega.ri.WizardImpl;

public class PegaTerritory extends WizardImpl implements Territories
{

	
	public PegaTerritory(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
	}

	@Override
	public void setTerritoryName(String terrName) {
		pegaDriver.findElement((TRR_NAME_ID)).sendKeys(terrName);
		
	}

	@Override
	public void setOwner(String terrOwner) {
		
		//if(pegaDriver.verifyElement(By.xpath("//a[contains(@name,'crmBusinessTerritoryDisplay')]")))
			//pegaDriver.findElement(By.xpath("//a[contains(@data-click,'crmRemoveOwnerID')]")).click();
		pegaDriver.findElement(By.id("crmSearchOwner")).click();
		//[@id="crmSearchOwner"]
			
		PegaUtil.autoComplete(pegaDriver, TRR_OWNER_ID, terrOwner);
		
	}

	@Override
	public void setDelegate(String delgName) {
		PegaUtil.autoComplete(pegaDriver, TRR_DELEGATE_ID, delgName);
		
	}

	@Override
	public void setParentTerritory(String parentTerrName) {
		PegaUtil.autoComplete(pegaDriver, TRR_PARENT_TERRITORY_ID, parentTerrName);
		
	}

	@Override
	public void clickSubmit() {
		pegaDriver.getActiveFrameId(true);
		//pegaDriver.waitForDocStateReady(1);
		PegaUtil.clickSubmit(pegaDriver);
		
	}

	@Override
	public void navigateToTerritoryModelbox() {
		//Set<String> windowId = pegaDriver.getWindowHandles();
		/*for (String window : driver.getWindowHandles()) {
            if (!window.equals(parent)) {
                driver.switchTo().window(window);
                System.out.println("Modal dialog found");
                break;
            }*/
        /*Iterator<String> itererator = windowId.iterator();   
        String mainWinID = itererator.next();
        String  newAdwinID = itererator.next();
        pegaDriver.switchTo().window(newAdwinID);
		*/
		
	}

	@Override
	public String getTerritoryModelboxName() {
		//navigateToTerritoryModelbox();
		String title = pegaDriver.getTitle();
		return title;
	}

	@Override
	public void setReservedForPartner(String value) {
		//pegaDriver.waitForDocStateReady(1);
		if(value.equals("Yes"))
		{
			pegaDriver.waitForDocStateReady(1);
			pegaDriver.findElement((TRR_RESERVED_FOR_PARTNER_ID)).click();
		}
		
		
	}

	@Override
	public String getTerritoryName() 
	{
		String name = pegaDriver.findElement((TRR_NAME_ID)).getAttribute("Value");
		//System.out.println(name);
		return name;
	}

	@Override
	public String getTerritoryOwner() 
	{
		
		String Owner = pegaDriver.findElement((TRR_OWNER_VALUE_XPATH)).getText().trim();
		//System.out.println(Owner);
		return Owner;
	}

	@Override
	public String getParentTerritory() {
		String parent=pegaDriver.findElement((TRR_PARENTTERRITORY_VALUE_XPATH)).getText().trim();
		return parent;
	}
	
	@Override
	public boolean isTerritoryNameDisplayed() 
	{
		pegaDriver.waitForDocStateReady(1);
		if(pegaDriver.findElement((TRR_NAME_ID)).isDisplayed())
			return true;
		else
			return false;
	}

	@Override
	public boolean isSubmitDisplayed() 
	{
		//pegaDriver.waitForDocStateReady(1);
		if(pegaDriver.findElement(By.id(TRR_SUBMIT_ID)).isDisplayed())
			return true;
		else
			return false;
	}

	@Override
	public boolean isTerritoryNameEnabled() {
		pegaDriver.waitForDocStateReady(1);
		return(pegaDriver.findElement((TRR_NAME_ID)).isEnabled());

		
	}

	@Override
	public boolean isParentTerritoryEnabled() {
		pegaDriver.waitForDocStateReady(1);
		return(pegaDriver.findElement(By.id(TRR_OWNER_ID)).isEnabled());
	}

	@Override
	public boolean isDelegateEnabled() 
	{
		pegaDriver.waitForDocStateReady(1);
		return(pegaDriver.findElement(By.id(TRR_DELEGATE_ID)).isEnabled());
	}

	@Override
	public boolean isReservedForPartnerEnabled() {
		pegaDriver.waitForDocStateReady(1);
		return(elementPresent((TRR_RESERVED_FOR_PARTNER_ID)));
	}
	
	private boolean elementPresent(By by)
	{
		try{
			pegaDriver.findElement(by);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception caught");
			return false;
		}
	}

	@Override
	public void modifyOwner(String terrOwner) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement((TRR_EDIT_OWNER_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		setOwner(terrOwner);
	}

	@Override
	public void modifyPerentTerritory(String parentTerrName) {
		//pegaDriver.waitForDocStateReady(2);
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement((TRR_EDIT_PARENT_TERRITORY_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		setParentTerritory(parentTerrName);
		pegaDriver.waitForDocStateReady(1);
	}

	@Override
	public String getErrorMessageforName() {
		/*//clickSubmit();
		try{
			//pegaDriver.waitForDocStateReady(1);
			//Runtime.getRuntime().exec("V:\\SVNwc\\SFATests\\AutoItScripts\\popup.exe");
			pegaDriver.findElement(By.id(TRR_SUBMIT_ID)).click();
			Thread.sleep(1000);
			System.out.println("Getting Popup");
			
			
			//pegaDriver.switchTo().alert().accept();
		}
		catch(Exception e)
		{
			System.out.println("Error!!!!!");
		}*/
		
		pegaDriver.findElement((TRR_NAME_ID)).sendKeys(Keys.TAB);
		pegaDriver.waitForDocStateReady(1);
		String error=pegaDriver.findElement((TRR_ERROR_NAME_XPATH)).getText();
		return error;
	}

	@Override
	public String getErrorMessageforOwner() 

	{
		pegaDriver.findElement(By.id(TRR_OWNER_ID)).sendKeys(Keys.TAB);
		pegaDriver.waitForDocStateReady(1);
		String error=pegaDriver.findElement(By.xpath(TRR_ERROR_OWNER_XPATH)).getText();
		return error;
	}

	@Override
	public String getErrorMessageforParentTerritory() {
		clickSubmit();
		pegaDriver.waitForDocStateReady(1);
		String error=pegaDriver.findElement((TRR_ERROR_PARENTTERRITORY_XPATH)).getText();
		return error;
	}
	@Override
	public void clickOK() {
		pegaDriver.getActiveFrameId(true);
		//pegaDriver.waitForDocStateReady(1);
		//PegaUtil.clickOK(pegaDriver);
		By TerritorySubmitButton = By.xpath("//*[@data-test-id='20141009024905058525394']");
		pegaDriver.findElement(TerritorySubmitButton).click();
		
		
	}
	public void confirmchange() {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement(By.xpath("//label[@data-test-id='2015061908163100943143-Label']")).check();
		
		
	//	2015061908163100943143-Label
		
	}
	/*@Override
	public String getTerritoryPageHeader() {
		pegaDriver.getActiveFrameId(true);
		String trrHeader=pegaDriver.findElement(By.xpath(TRR_TERRITORY_PAGE_HEADER_XPATH)).getText();
		return trrHeader;
	}*/

}
