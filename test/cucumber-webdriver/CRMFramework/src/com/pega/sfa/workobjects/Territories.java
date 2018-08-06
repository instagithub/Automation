package com.pega.sfa.workobjects;

import org.openqa.selenium.By;

import com.pega.ri.Wizard;

public interface Territories  extends Wizard
{
	
	By TRR_NAME_ID=By.xpath("//*[@data-test-id='2014122410590805191288']");
	By TRR_STATUS_ID=By.xpath("//*[@data-test-id='2014122410590805202470']");
	// We are not using this element anywhere
	String TRR_OWNER_ID="crmSearchOwner";
	//Auto Complete dont change
	String TRR_DELEGATE_ID="crmSearchTerm";
	//Auto Complete dont change
	String TRR_PARENT_TERRITORY_ID="crmTerritorySearch";
	//Auto Complete dont change
	By TRR_RESERVED_FOR_PARTNER_ID=By.xpath("//*[@data-test-id='20141224105908052919419-Label']");
	//By TRR_SUBMIT_ID=By.xpath("//*[@data-test-id='20141009024905058525394']");
	String TRR_SUBMIT_ID="ModalButtonSubmit";
	//Button missing data-test-id
	//By TRR_OWNER_VALUE_XPATH=By.xpath("//*[@data-test-id='2014122410590805214120']");
	By TRR_OWNER_VALUE_XPATH=By.xpath("//*[@data-test-id='20180118150550065856']//div[@class='field-item dataValueRead']");
	By TRR_PARENTTERRITORY_VALUE_XPATH=By.xpath("//*[@data-test-id='20180118150550066087']//div[@class='field-item dataValueRead']");
	//String TRR_EDIT_OWNER_XPATH="//*[text()='Owner']/../../following-sibling::div//a";
	//String TRR_EDIT_OWNER_XPATH="//span[text()='Forecast manager']/../div";
	By TRR_EDIT_OWNER_XPATH=By.xpath("//a[@data-test-id='2014122410590805237178']");
	// //*[@id="RULE_KEY"]/div[2]/div/div/div[2]/div/div/div/div/div[2]/div/div/span/a
	
	//$x("//a[@data-test-id='2014122410590805237178']");

	By TRR_EDIT_PARENT_TERRITORY_XPATH=By.xpath("//*[@data-test-id='20141224105908052817290']");
	By TRR_ERROR_NAME_XPATH=By.xpath("//*[@data-test-id='2014122410590805191288']");
	String TRR_ERROR_OWNER_XPATH="//div[contains(@id, 'OwnerError')]//span";
	//Territory Owner is no longer required
	By TRR_ERROR_PARENTTERRITORY_XPATH=By.xpath("//*[@data-test-id='20141224105908052614689']");
	
	
	void setTerritoryName(String terrName);
	void setOwner(String terrOwner);
	void setDelegate(String delgName);
	void setParentTerritory(String parentTerrName);
	void setReservedForPartner(String value);
	public void clickOK();
	public void confirmchange();
	void clickSubmit();
	void navigateToTerritoryModelbox();
	void modifyOwner(String terrOwner);
	void modifyPerentTerritory(String parentTerrName);
	
	
	String getTerritoryModelboxName();
	String getTerritoryName();
	String getTerritoryOwner();
	String getParentTerritory();
	String getErrorMessageforName();
	String getErrorMessageforOwner();
	String getErrorMessageforParentTerritory();

	
	
	boolean isTerritoryNameDisplayed();
	boolean isSubmitDisplayed();
	boolean isTerritoryNameEnabled();
	boolean isParentTerritoryEnabled();
	boolean isDelegateEnabled();
	boolean isReservedForPartnerEnabled();
	
	
	
	//String getTerritoryPageHeader();
	
	
}
