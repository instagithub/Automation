package com.pega.crm.salesautomation.workobjects.impl;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.crm.salesautomation.workobjects.Partners;
import com.pega.ri.WizardImpl;

public class PegaPartners extends WizardImpl implements Partners {
	
	
	
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
	

	public PegaPartners(WebElement elmt, String elmtId) 
	{
		super(elmt, elmtId);
	}
	
	@Override
	public void setWebSite(String WebSite) {
		
		pegaDriver.waitForDocStateReady(1);
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(WEBSITE_ID)).sendKeys(PegaUtil.SelectAll);
		
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(WEBSITE_ID)).sendKeys(WebSite);
		
	}

	@Override
	public void setPhone(String Phone) {
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PHONE_ID)).sendKeys(PegaUtil.SelectAll);
		
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PHONE_ID)).sendKeys(Phone);
	}

	@Override
	public void setPartnerName(String Partner) {
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PATNER_NAME_ID)).sendKeys(PegaUtil.SelectAll);
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PATNER_NAME_ID)).sendKeys(Partner);
		
	}
	
	@Override
	public void setPartnerID(String PartnerID) {
		pegaDriver.waitForDocStateReady(1);
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PARTNER_ID)).sendKeys(PegaUtil.SelectAll);
		
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PARTNER_ID)).sendKeys(PartnerID);
	}

	@Override
	public void setPartnerTaxID(String TaxID) {
		pegaDriver.waitForDocStateReady(1);
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PARTNER_TAXID)).sendKeys(PegaUtil.SelectAll);
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PARTNER_TAXID)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.findElement(By.id(PARTNER_TAXID)).sendKeys(TaxID);
	}

	@Override
	public void setPartnerWorkFax(String WorkFax) {
		/*pegaDriver.waitForDocStateReady(1);
		pegaDriver.getActiveFrameId(true);
		PegaWebElement wb =pegaDriver.findElement(By.id(PARTNER_WORKFAX));
		String selectAll= Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE);
		wb.sendKeys(selectAll);
		wb.sendKeys(Keys.TAB);
		pegaDriver.getActiveFrameId(true);*/
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement(By.id(PARTNER_WORKFAX)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.findElement(By.id(PARTNER_WORKFAX)).sendKeys(WorkFax);
	}
	

	@Override
	public void setEmail(String Email)
	{
		pegaDriver.waitForDocStateReady(1);
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(EMAIL_ID)).sendKeys(PegaUtil.SelectAll);
		
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(EMAIL_ID)).sendKeys(Email);
		
	}

	@Override
	public void setPartnerType(String PartnerType) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.id(PARTNER_TYPE)).selectByVisibleText(PartnerType);
		
	}

	@Override
	public void setSFAAccess() 
	{
		pegaDriver.waitForDocStateReady(2);
		/*//pegaDriver.getActiveFrameId(true);
		Wizard wizrd = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		wizrd.findElement(By.id(SFA_ACCESS_TYPE_ID)).doClickWithMouse();
		//testEnv.getScriptExecutor().click(pegaDriver.findElement(By.id(SFA_ACCESS_TYPE_ID)));*/
		//pegaDriver.findElement(By.id(SFA_ACCESS_TYPE_ID)).click();
		/*pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(SFA_ACCESS_TYPE_ID)).click();
*/		//pegaDriver.findElement(By.id(SFA_ACCESS_TYPE_ID)).sendKeys((Keys.SPACE));
		
	//	pegaDriver.waitForDocStateReady(2);
		
		int counter=0;
		
		breakWhile:
		while(counter==0)
			{
			
				System.out.println("Entered while : "+counter);
				pegaDriver.getActiveFrameId(true);
				pegaDriver.findElement(SFA_ACCESS_TYPE_ID).click();;
				pegaDriver.getActiveFrameId(true);
				if(pegaDriver.verifyElement(By.id(TERRITORY_FIELD_ID)))
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
		pegaDriver.waitForDocStateReady(1);
		PegaUtil.autoComplete(pegaDriver, TERRITORY_FIELD_ID, TerritoryName);
		
	}

	@Override
	public void clickcreateTerritory()
	{
		pegaDriver.findElement(By.xpath(CREATE_TERRITORY_XPATH)).click();
		
	}

	@Override
	public void setTerritoryName(String TerritoryName) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(TERRITORYNAME_ID)).sendKeys(TerritoryName);
		
	}

	@Override
	public void setOwner(String OwnerName) {
		pegaDriver.getActiveFrameId(true);
		PegaUtil.autoComplete(pegaDriver, TERRITORY_OWNER_ID, OwnerName);
		
	}

	@Override
	public void setParentTerritory(String ParentTerritory) {
		PegaUtil.autoComplete(pegaDriver, PARENT_TERRITORY_ID, ParentTerritory);
		
	}

	@Override
	public void clickSubmitTerritoryScreen() {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(TERRITORY_SUBMIT_ID)).click();
		
	}

	@Override
	public void SubmitPartner() {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(CREATE_BUTTON_XPATH)).click();
		
	}

	@Override
	public void setAddress() {
		PegaUtil.setAddress(pegaDriver);
		
	}

	@Override
	public String getWebSite() 
	{
		pegaDriver.getActiveFrameId(true);
		String website=pegaDriver.findElement(By.xpath(WEBSITE_VALUE_XPATH)).getText();
		return website;
	}
	
	
	@Override
	public String getPartnerID()
	{
		pegaDriver.getActiveFrameId(true);
		String partnerID=pegaDriver.findElement(By.xpath(ID_VALUE_PATH)).getText();
		return partnerID;
	}
	
	@Override
	public String getPartnerWorkFax() {
		
		pegaDriver.getActiveFrameId(true);
		String partnerfax=pegaDriver.findElement(By.xpath(WORK_FAX_VALUE_PATH)).getText();
		return partnerfax;
	}

	@Override
	public String getPartnerTaxID() {
		
		pegaDriver.getActiveFrameId(true);
		String partnertaxId=pegaDriver.findElement(By.xpath(TAX_ID_VALUE_PATH)).getText();
		return partnertaxId;
	}
	
	
	
	

	@Override
	public String getPhone() {
		pegaDriver.getActiveFrameId(true);
		String phone = pegaDriver.findElement(By.xpath(PHONE_VALUE_XPATH)).getText();
		return phone;
	}

	@Override
	public String getPartnerName() {
		pegaDriver.getActiveFrameId(true);
		String PartnerName = pegaDriver.findElement(By.xpath(NAME_VALUE_XPATH)).getText();
		return PartnerName;
	}

	@Override
	public String getEmail() {
		pegaDriver.getActiveFrameId(true);
		String Email = pegaDriver.findElement(By.xpath(EMAIL_VALUE_XPATH)).getText();
		return Email;
	}

	@Override
	public String getPartnerType() {
		String PartnerType = pegaDriver.findElement(By.xpath(PARTNERTYPE_VALUE_XPATH)).getText();
		return PartnerType;
	}

	@Override
	public void updatePhone(String UpdatedPhone) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(PHONE_ID)).sendKeys(PegaUtil.SelectAll);
		pegaDriver.findElement(By.id(PHONE_ID)).sendKeys(UpdatedPhone);
		
	}

	@Override
	public void updateEmail(String UpdatedEmail) {
		//pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(EMAIL_ID)).sendKeys(PegaUtil.SelectAll);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//pegaDriver.findElement(By.id(EMAIL_ID)).sendKeys(Keys.TAB);
		pegaDriver.findElement(By.id(EMAIL_ID)).sendKeys(UpdatedEmail);
		
		
	}

	@Override
	public void clickEdit() {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//button[text()='Edit']")).click();
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.getActiveFrameId(true);		
	}

	@Override
	public void clickSubmitReviewScreen() 
	{
		
		pegaDriver.findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();
		
	}

	@Override
	public void clickOperatorsSubtab() {
		PegaUtil.getSubTab(pegaDriver, "Operators");
		PegaUtil.clickRefresh(pegaDriver);
		
		
	}

	@Override
	public List<String> getOperators() 
	{
		ArrayList<String> s= new ArrayList<String>();
		pegaDriver.getActiveFrameId(true);
		List<WebElement> wb=pegaDriver.findElements(By.xpath(OPERATORS_VALUES_XPATH));
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
