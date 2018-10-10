package com.pega.crm.salesautomation.workobjects;

import com.pega.ri.Wizard;

public interface Tasks extends Wizard{
	
	public String TaskSubject =  "TaskSubject";
	public String TASK_PRIORITY_ID = "Priority";
	public String TASK_REMINDER_ID = "NotifyEmail";
	public String notifyReminder = "NotifyReminder";
	public String TASK_TYPE_XPATH="//select[contains(@name,'TaskType')]";
	public String TASK_COMMENTS_ID = "Comments";
	public String TASK_STATUS_XPATH="//select[contains(@id,'TaskStatus')]";
	public String SUBJECT_VALUE_XPATH="//span[text()='Subject']/following::div[@class='field-item dataValueRead']";
	public String TASK_VALUE_XPATH="//span[text()='Type']/following::div[@class='field-item dataValueRead']";
	public String TASK_DUEDATE_VALUE_XPATH="//span[text()='Due date']/following::div[@class='field-item dataValueRead']";
	public String TASK_PRIORITY_VALUE_XPATH="//span[text()='Priority']/following::div[@class='field-item dataValueRead']";
	public String TASK_STATUS_VALUE_XPATH="//span[text()='Status']/following-sibling::strong[contains(text(),'Required')]/following::div[@class='field-item dataValueRead']|(//span[text()='Status'])[2]/../..//div/div";
	public String TASK_COMMENTS_VALUE_XPATH="//span[text()='Comments']/../div/div";
	public String TASK_ASSIGNEDTO_VALUE_XPATH="//span[text()='Assigned to']/following::div[@class='field-item dataValueRead']";
	
	
	  public void setSubject(String Subject);
	  public void setTaskType(String taskType);
	  public void setStartDate();
	  public void setDueDate();
	  public void setTaskPriority(String taskPriority);
	  public void setTaskStatus(String taskStatus);
	  public void setTaskReminder(boolean Remind);
	  public void setTaskNotifyReminder(String notifyReminder);
	  public void setTaskComments(String comments);
	  public void taskSubmit();
	  
	  
	  
	 public String getSubject();
	 public String getTaskType();
	 public String getDueDate();
	 public String getAssignedTo();
	 public String getPriority();
	 public String getStatus();
	 public String getRelatedTo(String workObject);
	 public String getComments();
	String getAssignedToForOrg();
	  
}
