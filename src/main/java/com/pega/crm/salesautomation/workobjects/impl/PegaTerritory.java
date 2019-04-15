package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Territories;
import com.pega.ri.WizardImpl;

public class PegaTerritory extends WizardImpl implements Territories
{

	

	public PegaTerritory(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	@Override
	public void setTerritoryName(String terrName) {
		findElement((TRR_NAME_ID)).sendKeys(terrName);
		
	}

	@Override
	public void setOwner(String terrOwner) {
		
		//if(verifyElement(By.xpath("//a[contains(@name,'crmBusinessTerritoryDisplay')]")))
			//findElement(By.xpath("//a[contains(@data-click,'crmRemoveOwnerID')]")).click();
		findElement(By.id("crmSearchOwner")).click();
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
		
		//
		PegaUtil.clickSubmit(pegaDriver);
		
	}

	@Override
	public void navigateToTerritoryModelbox() {
		//Set<String> windowId = getWindowHandles();
		/*for (String window : driver.getWindowHandles()) {
            if (!window.equals(parent)) {
                driver.switchTo().window(window);
                System.out.println("Modal dialog found");
                break;
            }*/
        /*Iterator<String> itererator = windowId.iterator();   
        String mainWinID = itererator.next();
        String  newAdwinID = itererator.next();
        switchTo().window(newAdwinID);
		*/
		
	}

	@Override
	public String getTerritoryModelboxName() {
		//navigateToTerritoryModelbox();
		String title = getTitle();
		return title;
	}

	@Override
	public void setReservedForPartner(String value) {
		//
		if(value.equals("Yes"))
		{
			
			findElement((TRR_RESERVED_FOR_PARTNER_ID)).click();
		}
		
		
	}

	@Override
	public String getTerritoryName() 
	{
		String name = findElement((TRR_NAME_ID)).getAttribute("Value");
		//System.out.println(name);
		return name;
	}

	@Override
	public String getTerritoryOwner() 
	{
		
		String Owner = findElement((TRR_OWNER_VALUE_XPATH)).getText().trim();
		//System.out.println(Owner);
		return Owner;
	}

	@Override
	public String getParentTerritory() {
		String parent=findElement((TRR_PARENTTERRITORY_VALUE_XPATH)).getText().trim();
		return parent;
	}
	
	@Override
	public boolean isTerritoryNameDisplayed() 
	{
		
		if(findElement((TRR_NAME_ID)).isDisplayed())
			return true;
		else
			return false;
	}

	@Override
	public boolean isSubmitDisplayed() 
	{
		//
		if(findElement(By.id(TRR_SUBMIT_ID)).isDisplayed())
			return true;
		else
			return false;
	}

	@Override
	public boolean isTerritoryNameEnabled() {
		
		return(findElement((TRR_NAME_ID)).isEnabled());

		
	}

	@Override
	public boolean isParentTerritoryEnabled() {
		
		return(findElement(By.id(TRR_OWNER_ID)).isEnabled());
	}

	@Override
	public boolean isDelegateEnabled() 
	{
		
		return(findElement(By.id(TRR_DELEGATE_ID)).isEnabled());
	}

	@Override
	public boolean isReservedForPartnerEnabled() {
		
		return(elementPresent((TRR_RESERVED_FOR_PARTNER_ID)));
	}
	
	private boolean elementPresent(By by)
	{
		try{
			findElement(by);
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
		
		findElement((TRR_EDIT_OWNER_XPATH)).click();
		
		setOwner(terrOwner);
	}

	@Override
	public void modifyPerentTerritory(String parentTerrName) {
		//waitForDocStateReady(2);
		
		findElement((TRR_EDIT_PARENT_TERRITORY_XPATH)).click();
		
		setParentTerritory(parentTerrName);
		
	}

	@Override
	public String getErrorMessageforName() {
		/*//clickSubmit();
		try{
			//
			//Runtime.getRuntime().exec("V:\\SVNwc\\SFATests\\AutoItScripts\\popup.exe");
			findElement(By.id(TRR_SUBMIT_ID)).click();
			Thread.sleep(1000);
			System.out.println("Getting Popup");
			
			
			//switchTo().alert().accept();
		}
		catch(Exception e)
		{
			System.out.println("Error!!!!!");
		}*/
		
		findElement((TRR_NAME_ID)).sendKeys(Keys.TAB);
		
		String error=findElement((TRR_ERROR_NAME_XPATH)).getText();
		return error;
	}

	@Override
	public String getErrorMessageforOwner() 

	{
		findElement(By.id(TRR_OWNER_ID)).sendKeys(Keys.TAB);
		String error=findElement(By.xpath(TRR_ERROR_OWNER_XPATH)).getText();
		return error;
	}

	@Override
	public String getErrorMessageforParentTerritory() {
		clickSubmit();
		String error=findElement((TRR_ERROR_PARENTTERRITORY_XPATH)).getText();
		return error;
	}
	@Override
	public void clickOK() {
		
		//
		//PegaUtil.clickOK(pegaDriver);
		By TerritorySubmitButton = By.xpath("//*[@data-test-id='20141009024905058525394']");
		findElement(TerritorySubmitButton).click();
		
		
	}
	public void confirmchange() {
		findElement(By.xpath("//label[@data-test-id='2015061908163100943143-Label']")).check();
		
		
	}
	/*@Override
	public String getTerritoryPageHeader() {
		
		String trrHeader=findElement(By.xpath(TRR_TERRITORY_PAGE_HEADER_XPATH)).getText();
		return trrHeader;
	}*/

}
