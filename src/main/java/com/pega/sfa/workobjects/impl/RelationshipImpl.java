package com.pega.sfa.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;
import com.pega.sfa.workobjects.Accounts;
import com.pega.sfa.workobjects.Contact;
import com.pega.sfa.workobjects.Organization;
import com.pega.sfa.workobjects.Relationship;

public class RelationshipImpl extends WizardImpl implements Relationship {
	
	String RelationType= "P2PRelationshipType";
	String ExistingContact = "//label[contains(@for, 'Choose Existing Contact')]";
	String NewContact = "//label[contains(@for, 'Create New Contact')]";
	String CONTACT_NAME="crmSearchTerm";
	String RelationDesc ="RelationshipDesc";
	String RelationNotes ="Notes";
	
	public RelationshipImpl(WebElement elmt) {
		super(elmt);
	}
	
	
	public RelationshipImpl(WebElement elmt, String elmtId){
		super(elmt, elmtId);
	}

	@Override
	public String checkDefaults() {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		return (pegaDriver.findElement(By.xpath("//div[@string_type='field']//a")).getAttribute("text").trim());
		
	}

	@Override
	public void setRelationshipType(String RelationshipType) {
		
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		relationship.findSelectBox(By.id(RelationType)).selectByVisibleText(RelationshipType);
	}

	@Override
	public void setStartDate(String startDate) {
		
		
		
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		
		relationship.findElement(By.xpath("//span[contains(@name,'StartDate')]|//span[contains(@id, 'StartDate')]//img")).click();
		
		PegaWebElement wb; 
		if(relationship.verifyElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='1']")))
		{
			wb = relationship.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='1']")); 
			wb .click();
		}
		
		/*pegaDriver.getActiveFrameId(true);
		PegaWebElement wb; 
		if(pegaDriver.verifyElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='1']")))
		{
			wb = pegaDriver.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='1']")); 
			wb .click();
		}
		*/
	}

	@Override
	public void setEndDate(String EndDate) {
		
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		relationship.findElement(By.xpath("//span[contains(@name,'EndDate')]|//span[contains(@id, 'EndDate')]//img")).click();
		PegaWebElement wb; 
		if(pegaDriver.verifyElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='30']"))) 
		{
	      wb = pegaDriver.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='30']"));
	      wb .click();
		}
		else if(pegaDriver.verifyElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='29']")))
		{
			wb = pegaDriver.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='29']"));
			wb .click();
		}
		{
			//wb = pegaDriver.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='28']"));
			//wb.click();
			}
		}

	@Override
	public void chooseContactType(String ContactType) {
		
		
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		
		if(ContactType.toLowerCase().contains("exist"))
			relationship.findElement(By.xpath(ExistingContact)).click();
		else
			relationship.findElement(By.xpath(NewContact)).click();
		
	}

	@Override
	public void selectContactName(String ContactName) {
		
	
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		pegaDriver.findElement(By.id(CONTACT_NAME)).click();
		UtilImpl.autoComplete(pegaDriver,CONTACT_NAME ,ContactName );
	}

	@Override
	public void setRelationshipDesc(String RelationshipDescription) {
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		relationship.findElement(By.id(RelationDesc)).sendKeys(RelationshipDescription);
	}

	@Override
	public void setNotes(String Notes) {
	
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		relationship.findElement(By.id(RelationNotes)).sendKeys(Notes);
	
	}


	@Override
	public void clickCreate() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		UtilImpl.clickCreate(pegaDriver);
		
	}


	@Override
	public String getRelationshipType() {
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		return relationship.findElement(By.xpath("//div[@string_type='field']//div[@class='RequiredField']")).getAttribute("text").trim();
	}


	@Override
	public String getStartDate() {
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		return relationship.findElement(By.xpath("//span[text()='Start date']/following::div[@class='field-item dataValueRead']//span")).getAttribute("text").trim();
	}


	@Override
	public String getEndDate() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		return relationship.findElement(By.xpath("//span[text()='End date']/following::div[@class='field-item dataValueRead']//span")).getAttribute("text").trim();
	
	}


	@Override
	public String CheckContactName() {
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		return relationship.findElement(By.xpath("//div[@class='field-item dataValueRead']//a[contains(@data-click,'ContactID')]")).getAttribute("text").trim();
	
	}


	@Override
	public String getRelationshipDesc() {


		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		return relationship.findElement(By.xpath("//span[contains(text(),'description')]/following-sibling::div//div")).getAttribute("text").trim();
		
	}


	@Override
	public String getNotes() {

		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationship= new RelationshipImpl(framElmt, frameId);
		relationship._setEnvironment(testEnv, frameId);
		return relationship.findElement(By.xpath("//span[contains(text(),'Notes')]/following-sibling::div")).getAttribute("text").trim();
		
	}
	
	@Override
	public Contact setNewContactName(String ContactName) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Contact contact= new ContactImpl(framElmt, frameId);
		contact._setEnvironment(testEnv, frameId);
		StringBuffer contname= new StringBuffer(ContactName);
		contact.setLastName(contname);
		return contact;
		
	}

	@Override
	public Organization openOrganization(String OrgName) {
		pegaDriver.getActiveFrameId(true);
		//pegaDriver.findElement(By.xpath("//a[title='Open "+OrgName+"']")).click();
		//("//a[contains(text(),'"+OrgName+"')]")))	
		pegaDriver.findElement(By.xpath("//a[contains(@title,'"+OrgName+"')]")).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organization org= new OrganizationImpl(framElmt, frameId);
		org._setEnvironment(testEnv, frameId);
		return org;
	}


	@Override
	public Accounts openAccount(StringBuffer name) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Accounts acc= new AccountsImpl(framElmt, frameId);
		acc._setEnvironment(testEnv, frameId);
		return acc;
	}
	
	@Override
	public Accounts openAccount(String name) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Accounts acc= new AccountsImpl(framElmt, frameId);
		acc._setEnvironment(testEnv, frameId);
		return acc;
	}

	@Override
	public Contact openContact(String ContactName) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//a[text()='"+ContactName+"']")).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Contact cont= new ContactImpl(framElmt, frameId);
		cont._setEnvironment(testEnv, frameId);
		return cont;
		
	}
	
}
