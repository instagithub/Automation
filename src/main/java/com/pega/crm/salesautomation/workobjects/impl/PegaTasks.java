package com.pega.crm.salesautomation.workobjects.impl;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.crm.salesautomation.workobjects.Tasks;
import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;

public class PegaTasks extends WizardImpl implements Tasks{
	
	
	

	public PegaTasks(WebElement elmt) {
		super(elmt);
		
	}

	
	public PegaTasks(WebElement elmt, String elmtId){
		super(elmt, elmtId);
	}


	@Override
	public void setSubject(String Subject) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(TaskSubject)).clear();
		pegaDriver.findElement(By.id(TaskSubject)).sendKeys(Subject);
		
	}


	@Override
	public void setTaskType(String taskType) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.xpath(TASK_TYPE_XPATH)).selectByVisibleText(taskType);
	}


	@Override
	public void setStartDate() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setDueDate() {
		 
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		pegaDriver.findElement(By.xpath("//span[contains(@id,'TaskDueDateSpan')]/..//img")).click();
		
		frameId = pegaDriver.getActiveFrameId(false);
		frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		PegaWebElement wb; 
		if(pegaDriver.verifyElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='31']")))
		{
			wb = pegaDriver.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='31']")); 
			wb .click();
		}
			
		else if(pegaDriver.verifyElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='30']")))
		{
			wb = pegaDriver.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='30']"));
			wb.click();
		}
		
		else if(pegaDriver.verifyElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='29']")))
		{
			wb = pegaDriver.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='29']"));
			wb.click();
		}
		
		else 
		{
			wb = pegaDriver.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='28']"));
			wb.click();
		}
			
			
	}


	@Override
	public void setTaskPriority(String taskPriority) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.id(TASK_PRIORITY_ID)).selectByVisibleText(taskPriority);
	}


	@Override
	public void setTaskStatus(String taskStatus) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.xpath(TASK_STATUS_XPATH)).selectByVisibleText(taskStatus);
	}


	@Override
	public void setTaskReminder(boolean Remind) {
		
		pegaDriver.getActiveFrameId(true);
		if(Remind)
		pegaDriver.findElement(By.id(TASK_REMINDER_ID)).click();
	}


	@Override
	public void setTaskNotifyReminder(String notifyReminder) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findSelectBox(By.id(notifyReminder)).selectByVisibleText(notifyReminder);
	}


	@Override
	public void setTaskComments(String comments) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(TASK_COMMENTS_ID)).sendKeys(comments);
		
	}	
	public void taskSubmit()
	{
		PegaUtil.clickCreate(pegaDriver);
		
	}


	@Override
	public String getSubject() {
	
		pegaDriver.getActiveFrameId(true);
		return (new String(pegaDriver.findElement(By.xpath(SUBJECT_VALUE_XPATH)).getAttribute("text")).trim()); 
	
	}


	@Override
	public String getTaskType() {
		
		pegaDriver.getActiveFrameId(true);
		return (new String(pegaDriver.findElement(By.xpath(TASK_VALUE_XPATH)).getAttribute("text")).trim()); 
	
	}


	@Override
	public String getDueDate() {
		
		System.out.println("Entered Taskimpl getduedate is invoked");
		pegaDriver.getActiveFrameId(true);
		String TaskDueDateFromreview = pegaDriver.findElement(By.xpath(TASK_DUEDATE_VALUE_XPATH)).getAttribute("text");
		System.out.println("TaskDueDateFromreview from taskimpl"+TaskDueDateFromreview);
		return (new String(pegaDriver.findElement(By.xpath(TASK_DUEDATE_VALUE_XPATH)).getAttribute("text")).trim()); 
	
	}


	@Override
	public String getPriority() {
		
		pegaDriver.getActiveFrameId(true);
		return (new String(pegaDriver.findElement(By.xpath(TASK_PRIORITY_VALUE_XPATH)).getAttribute("text")).trim()); 
	
	}


	@Override
	public String getStatus() {
		
		pegaDriver.getActiveFrameId(true);
		return (new String(pegaDriver.findElement(By.xpath(TASK_STATUS_VALUE_XPATH)).getAttribute("text")).trim());
		
	}


	@Override
	public String getRelatedTo(String workObject) {
		
		pegaDriver.getActiveFrameId(true);
		//"//span[text()='"+workObject+"']/following::div[@class='field-item dataValueRead']"
		
		return (new String(pegaDriver.findElement(By.xpath("//span[text()='"+workObject+"']/../..//a")).getAttribute("text")).trim()); 
	
	}


	@Override
	public String getComments() {
		
		pegaDriver.getActiveFrameId(true);
		
		return (new String(pegaDriver.findElement(By.xpath(TASK_COMMENTS_VALUE_XPATH)).getAttribute("text")).trim()); 
	
	}


	@Override
	public String getAssignedTo() {
		
		pegaDriver.getActiveFrameId(true);
		return (new String(pegaDriver.findElement(By.xpath(TASK_ASSIGNEDTO_VALUE_XPATH)).getAttribute("text")).trim());
		
	}
	@Override
	public String getAssignedToForOrg() {
		
		pegaDriver.getActiveFrameId(true);
		return (new String(pegaDriver.findElement(By.xpath("(//span[text()='Assigned to']/parent::*/div)[1]")).getAttribute("text")).trim());
		
	}
	
	
}