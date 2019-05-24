package com.pega.crm.salesautomation.workobjects.impl;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Partners;

public class PegaPartners extends PegaWorkObject implements Partners {
	
	
	
	public PegaPartners(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	String WEBSITE_ID="Website";
	String PHONE_ID="OfficePhone";
	String PATNER_NAME_ID="Name";
	String EMAIL_ID="WorkEmail";
	String PARTNER_TYPE="PartnerType";
	String PARTNER_ID="crmPartnerID";
	String PARTNER_WORKFAX="FaxNumber";
	String PARTNER_TAXID="crmTaxID";
	
	
	By SFA_ACCESS_TYPE_ID =By.xpath("//*[@data-test-id='2014121209505008752769-Label']");
	String CREATE_BUTTON_XPATH= "//button[text()='Create']";
	String TERRITORY_FIELD_ID="crmTerritorySearch";
	String CREATE_TERRITORY_XPATH="//*[@data-test-id='2015061908592800982262']";
	String TERRITORYNAME_ID="Name";
	String TERRITORY_OWNER_ID="crmSearchOwner";
	String PARENT_TERRITORY_ID="crmTerritorySearch";
	String TERRITORY_SUBMIT_ID="ModalButtonSubmit";
	String WEBSITE_VALUE_XPATH="//span[text()='Website']/..//div/span";
	
	String ID_VALUE_PATH = "//span[text()='ID']/..//div/span";
	String TAX_ID_VALUE_PATH = "//span[text()='Tax ID']/..//div/span";
	String WORK_FAX_VALUE_PATH = "//span[text()='Work fax']/..//div/span";
	
	
	String PHONE_VALUE_XPATH="//span[text()='Phone']/..//div/span";
	String NAME_VALUE_XPATH="//span[text()='Name']/../../div/span";
	String EMAIL_VALUE_XPATH="//span[text()='Email']/..//div/span";
	String PARTNERTYPE_VALUE_XPATH="//*[@data-test-id='20151119034237023588315']";
	String SUBMIT_BUTTON_XPATH="//button[text()='Submit']";
	String OPERATORS_VALUES_XPATH="//tr[contains(@id, 'crmOperatorsInPartnerList')]//td[@data-importance='primary']//span";
	

	
	
	@Override
	public void setWebSite(String WebSite) {
		
		findElement(By.id(WEBSITE_ID)).sendKeys(SELECT_ALL);
	
		findElement(By.id(WEBSITE_ID)).sendKeys(WebSite);
		
	}

	@Override
	public void setPhone(String Phone) {
		
		findElement(By.id(PHONE_ID)).sendKeys(SELECT_ALL);
	
		findElement(By.id(PHONE_ID)).sendKeys(Phone);
	}

	@Override
	public void setPartnerName(String Partner) {

		findElement(By.id(PATNER_NAME_ID)).sendKeys(SELECT_ALL);
		findElement(By.id(PATNER_NAME_ID)).sendKeys(Partner);
		
	}
	
	@Override
	public void setPartnerID(String PartnerID) {
		
		findElement(By.id(PARTNER_ID)).sendKeys(SELECT_ALL);
		
		findElement(By.id(PARTNER_ID)).sendKeys(PartnerID);
	}

	@Override
	public void setPartnerTaxID(String TaxID) {
		
		findElement(By.id(PARTNER_TAXID)).sendKeys(SELECT_ALL);
		
		
		findElement(By.id(PARTNER_TAXID)).sendKeys(SELECT_ALL);
		findElement(By.id(PARTNER_TAXID)).sendKeys(TaxID);
	}

	@Override
	public void setPartnerWorkFax(String WorkFax) {
		
		findElement(By.id(PARTNER_WORKFAX)).sendKeys(SELECT_ALL);
		findElement(By.id(PARTNER_WORKFAX)).sendKeys(WorkFax);
	}
	

	@Override
	public void setEmail(String Email)
	{
		findElement(By.id(EMAIL_ID)).sendKeys(SELECT_ALL);
		findElement(By.id(EMAIL_ID)).sendKeys(Email);
		
	}

	@Override
	public void setPartnerType(String PartnerType) {
		
		findSelectBox(By.id(PARTNER_TYPE)).selectByVisibleText(PartnerType);
		
	}

	@Override
	public void setSFAAccess() 
	{
		
		
		int counter=0;
		
		breakWhile:
		while(counter==0)
			{
			
				System.out.println("Entered while : "+counter);
				
				findElement(SFA_ACCESS_TYPE_ID).click();;
				
				if(verifyElement(By.id(TERRITORY_FIELD_ID)))
					{
						System.out.println("Entered If");
						counter++;
						break breakWhile;
					}
			
			}
		
	}

	@Override
	public void setTerritory(String TerritoryName)
	{
		findAutoComplete(By.id(TERRITORY_FIELD_ID)).setValue(TerritoryName);
	}

	@Override
	public void clickcreateTerritory()
	{
		findElement(By.xpath(CREATE_TERRITORY_XPATH)).click();
		
	}

	@Override
	public void setTerritoryName(String TerritoryName) {
		
		findElement(By.id(TERRITORYNAME_ID)).sendKeys(TerritoryName);
		
	}

	@Override
	public void setOwner(String OwnerName) {
		findAutoComplete(By.id(TERRITORY_OWNER_ID)).setValue(OwnerName);	
	}

	@Override
	public void setParentTerritory(String ParentTerritory) {
		findAutoComplete(By.id(PARENT_TERRITORY_ID)).setValue(ParentTerritory);
	}

	@Override
	public void clickSubmitTerritoryScreen() {
		
		findElement(By.id(TERRITORY_SUBMIT_ID)).click();
		
	}

	@Override
	public void SubmitPartner() {
		
		findElement(By.xpath(CREATE_BUTTON_XPATH)).click();
		
	}

	@Override
	public void setAddress() {
		setAddress();
		
	}

	@Override
	public String getWebSite() 
	{
		
		String website=findElement(By.xpath(WEBSITE_VALUE_XPATH)).getText();
		return website;
	}
	
	
	@Override
	public String getPartnerID()
	{
		
		String partnerID=findElement(By.xpath(ID_VALUE_PATH)).getText();
		return partnerID;
	}
	
	@Override
	public String getPartnerWorkFax() {
		
		
		String partnerfax=findElement(By.xpath(WORK_FAX_VALUE_PATH)).getText();
		return partnerfax;
	}

	@Override
	public String getPartnerTaxID() {
		
		
		String partnertaxId=findElement(By.xpath(TAX_ID_VALUE_PATH)).getText();
		return partnertaxId;
	}
	
	
	
	

	@Override
	public String getPhone() {
		
		String phone = findElement(By.xpath(PHONE_VALUE_XPATH)).getText();
		return phone;
	}

	@Override
	public String getPartnerName() {
		
		String PartnerName = findElement(By.xpath(NAME_VALUE_XPATH)).getText();
		return PartnerName;
	}

	@Override
	public String getEmail() {
		
		String Email = findElement(By.xpath(EMAIL_VALUE_XPATH)).getText();
		return Email;
	}

	@Override
	public String getPartnerType() {
		String PartnerType = findElement(By.xpath(PARTNERTYPE_VALUE_XPATH)).getText();
		return PartnerType;
	}

	@Override
	public void updatePhone(String UpdatedPhone) {
		
		findElement(By.id(PHONE_ID)).sendKeys(SELECT_ALL);
		findElement(By.id(PHONE_ID)).sendKeys(UpdatedPhone);
		
	}

	@Override
	public void updateEmail(String UpdatedEmail) {
		//
		findElement(By.id(EMAIL_ID)).sendKeys(SELECT_ALL);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//findElement(By.id(EMAIL_ID)).sendKeys(Keys.TAB);
		findElement(By.id(EMAIL_ID)).sendKeys(UpdatedEmail);
		
		
	}

	@Override
	public void clickEdit() {
		
		
		findElement(By.xpath("//button[text()='Edit']")).click();
				
	}

	@Override
	public void clickSubmitReviewScreen() 
	{
		
		findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();
		
	}

	@Override
	public void clickOperatorsSubtab() {
		getSubTab("Operators");
		clickRefresh();
		
		
	}

	@Override
	public List<String> getOperators() 
	{
		ArrayList<String> s= new ArrayList<String>();
		
		List<WebElement> wb=findElements(By.xpath(OPERATORS_VALUES_XPATH));
		for(WebElement w:wb)
		{
			String s1=w.getText();
			System.out.println(s1);
			s.add(s1);
		}
		return s;
	}

	@Override
	public List<String> trimOperators(List<String> operators) 
	{
		ArrayList<String> s= new ArrayList<String>();
		for(String op:operators)
		{
			String parts[]=op.split("for");
			s.add(parts[0].trim());
			System.out.println(s);
		}
		return s;
	}

	@Override
	public void clickOK() {
		// TODO Auto-generated method stub
		
	}



	

	
	
}
