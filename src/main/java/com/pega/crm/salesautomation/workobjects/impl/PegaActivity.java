package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.crm.salesautomation.workobjects.Activity;
import com.pega.crm.salesautomation.workobjects.Organizations;
import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;



public class PegaActivity extends WizardImpl implements Activity{

	public String ActivitySubject = "TaskSubject";
	public String ActivityCommunicationType = "//select[contains(@name,'CommunicationType')]";
	public String WOType = "ListRelatedTo";
	public String WOName = "RelatedToName";
	public String ActivityOutcome = "Outcome";
	String ACTIVITY_CREATE_XPATH=PegaUtil.getStrongButtonXPath("Create");
	By AddExistingContacts = By.xpath("//*[@data-test-id='201412050548470928176275']");

	public String ContactSearchTerm = "crmSearchTerm";
			
	public PegaActivity(WebElement elmt) {
		super(elmt);
		// TODO Auto-generated constructor stub
	} 
	
	public PegaActivity(WebElement elmt, String elmtId){
		super(elmt, elmtId);
	}

	@Override
	public void setSubject(String activitySubject) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(ActivitySubject)).clear();
		pegaDriver.findElement(By.id(ActivitySubject)).sendKeys(activitySubject);
		
	}

	@Override
	public void setDate() {
		//pegaDriver.getActiveFrameId(true);
		//pegaDriver.findElement(By.xpath(ActivitySubject)).sendKeys(activitySubject);
	}

	@Override
	public void setCommunicationType(String communicationType) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.xpath(ActivityCommunicationType)).selectByVisibleText(communicationType);
		
	}

	@Override
	public void setRelatedToType(String WorkObjectType) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.id(WOType)).selectByValue(WorkObjectType);
		
	}

	@Override
	public void setWorkObject(String WorkObjectName) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(WOName)).clear();
		pegaDriver.findElement(By.id(WOName)).sendKeys(WorkObjectName);
		
	}

	@Override
	public void setOutcome(String Outcome) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(ActivityOutcome)).sendKeys(Outcome);
	}

	@Override
	public void activityCreate(){
		
		String frameId = pegaDriver.getActiveFrameId(false);
		pegaDriver.switchTo().frame(frameId);
		
		if(pegaDriver.verifyElement(By.xpath("//button[@title='Create this item']")))
		pegaDriver.findElement(By.xpath("//button[@title='Create this item']")).click();
		if(pegaDriver.verifyElement(By.xpath("//button[@title='Complete this assignment']")))
			pegaDriver.findElement(By.xpath("//button[@title='Complete this assignment']")).click();	
		//pegaDriver.findElement(By.xpath(PegaUtil.getStrongButtonXPath("Create"))).click();
		pegaDriver.getActiveFrameId(true);
	}

	@Override
	public String getActivitySubject() {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		pegaDriver.getActiveFrameId(true);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Subject']/following::div[@class='field-item dataValueRead']//span")).getAttribute("text")).trim()); 
	
	}

	@Override
	public String getDate() {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Date']/following::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	
	}

	@Override
	public String getCommunicationType() {
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Communication type']/following::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	

	}

	@Override
	public String getStatus() {
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Status']/following::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	
		
	}

	@Override
	public String getWorkObject() {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Organization']/following::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	
	}

	@Override
	public String getOutcome() {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='What was the outcome?']/following::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	
	}
	
	
	
	@Override
	public String getActivityOwner() {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Owner']/following::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	
	}
	
	@Override
	public void clickCreate() 
	{
		PegaUtil.clickCreate(pegaDriver);
		
	}

	@Override
	public String getdefaultOrgvalue() {
		pegaDriver.getActiveFrameId(true);
		return (new String(pegaDriver.findElement(By.xpath("//label[text()='Organization']/following-sibling::div//input")).getAttribute("value")).trim());
				
	}
	public String getRelatedToTypeValue(String WOName)
	{
		pegaDriver.getActiveFrameId(true);
		return(pegaDriver.findElement(By.xpath("//span[text()='"+ WOName+"']/../div//a")).getText().trim());
	}
	@Override
	public void addExistingContacts(String contactName) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(AddExistingContacts).click();
		pegaDriver.getActiveFrameId(true);
		//pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Contacts')]//input")).sendKeys(contactName);
		PegaUtil.autoComplete(pegaDriver,ContactSearchTerm, contactName);
		
	}

	@Override
	public void addInternalStaff(String StaffName) {
		pegaDriver.getActiveFrameId(true);
		
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		
		wizard.findElement(By.xpath("//a[@data-test-id='20151130064041055566255']")).scrollIntoView();
		
		pegaDriver.findElement(By.xpath("//div[@id='PEGA_GRID1']//div[@id='RULE_KEY']//a")).click();
		
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'InternalStaff')]//input")).sendKeys(StaffName);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'InternalStaff')]//input")).sendKeys(Keys.DOWN);
		pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'InternalStaff')]//input")).sendKeys(Keys.DOWN);
		pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'InternalStaff')]//input")).sendKeys(Keys.ENTER);
		
		//PegaUtil.autoComplete(pegaDriver,StaffSearchTerm, StaffName);
		
	}

	@Override
	public void addActivityTasks(String TaskSub, String DueDate,String AssignedTo, String TaskType) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//div[@id='PEGA_GRID2']//div[@id='RULE_KEY']//a")).click();
			
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id("TaskSubject1")).sendKeys(TaskSub);
		
		pegaDriver.findElement(By.xpath("//span[contains(@id,'TaskDueDateSpan')]//img[@role='button']")).click();
		pegaDriver.getActiveFrameId(true);
		PegaWebElement wb; 
		if(pegaDriver.verifyElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='31']")))
		{
			wb = pegaDriver.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='31']")); 
			wb .click();
		}
			
		else if(pegaDriver.verifyElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='30']")))
		{
			wb = pegaDriver.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='30']")); 
			wb .click();
		}
		else if(pegaDriver.verifyElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='29']")))
		{
			wb = pegaDriver.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='29']")); 
			wb .click();
		}
		/*else if(pegaDriver.verifyElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='28']")))
		{
			wb = pegaDriver.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='28']"));
			wb.click();
		}
		*/
		
		
		pegaDriver.getActiveFrameId(true);
		PegaUtil.autoComplete(pegaDriver, "AssignedTo1", AssignedTo);
		//pegaDriver.findElement(By.id("AssignedTo1")).sendKeys(AssignedTo);
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.id("TaskType")).sendKeys(TaskType);
		
		
	}

	@Override
	public void addNewContact() {
		// TODO Auto-generated method stub
		
	}

	
	
	

	
}
