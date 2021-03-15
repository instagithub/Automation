package com.pega.crm.customerservice.tiles;

import org.openqa.selenium.By;

import com.pe.workobjects.JobApplication;
import com.pe.workobjects.MyWorkListPE;
import com.pega.crm.salesautomation.workobjects.AccountList;
import com.pega.crm.salesautomation.workobjects.ClosePlans;
import com.pega.crm.salesautomation.workobjects.ContactList;
import com.pega.crm.salesautomation.workobjects.Forecast;
import com.pega.crm.salesautomation.workobjects.HouseholdList;
import com.pega.crm.salesautomation.workobjects.LeadsList;
import com.pega.crm.salesautomation.workobjects.OperatorList;
import com.pega.crm.salesautomation.workobjects.OpportunityList;
import com.pega.crm.salesautomation.workobjects.OrganizationsList;
import com.pega.crm.salesautomation.workobjects.PartnersList;
import com.pega.crm.salesautomation.workobjects.TerritoriesList;										   

public interface LeftNav {
	By PERSONAL_DETAILS = By.xpath("//*[text()='Personal Details']");
	By PROFESSIONAL_EXPERIENCE = By.xpath("//*[text()='Professional Experience']");
	By SKILLSET = By.xpath("//*[text()='Skillset']");
	By APPLICANT_NAME = By.name("$PpyWorkPage$pApplicantName");
	By DATE_OF_BIRTH = By.name("$PpyWorkPage$pDateOfBirth");
	By MOBILE_INPUT = By.name("$PpyWorkPage$pMobile");
	By ADDRESS_INPUT = By.name("$PpyWorkPage$pAddress");
	By CONTINUE_BUTTON = By.xpath("//*[text()='Continue' and @title='Click here to submit']");
	By TOTAL_EXPERIENCE = By.name("$PpyWorkPage$pTotalExperience");
	By PREVIOUS_ORGANIZATION = By.name("$PpyWorkPage$pPreviousOrganization");
	By CURRENT_JOB_ROLE = By.name("$PpyWorkPage$pCurrentJobRole");
	By JOB_TYPE = By.name("$PpyWorkPage$pJobType");
	By AREA_OF_EXPERTISE = By.name("$PpyWorkPage$pPrimarySkill");
	By SECONDARY_SKILLS = By.name("$PpyWorkPage$pSecondarySkills");
	By SUBMIT_BUTTON = By.xpath("//*[text()='Submit' and @title='Click here to submit']");
	By REVIEW_TEXT = By.xpath("//*[text()='I declare that the information provide is true and contains all facts to the best of my knowledge']");
	By APPLICANT_NAME_TEXT = By.xpath("//*[@name='Applicant Name']//following-sibling::div/span");
	By STATUS = By.xpath("//*[text()='Resolved-Completed'][2]");
	
	By DEPARTMENT_ID = By.name("$PpyWorkPage$pDepartmentID");
	By DEPARTMENT_INPUT = By.xpath("//*[text()='Engineering']");
	By PROJECT_MANAGER = By.name("$PpyWorkPage$pProjectManager");
	By EXPENSE_DETAILS = By.xpath("//*[text()='Expense Details']");
	By CATEGORY_INPUT = By.xpath("//*[text()='Referral Bonuses']");
	By AMOUNT_INPUT = By.name("$PpyWorkPage$pExpenseAmount");
	By INCURRED_DATE = By.name("$PpyWorkPage$pIncurredDate");
	By NOTES_INPUT = By.name("$PpyWorkPage$pNotes");
	By ADD_TASK = By.xpath("//*[text()='Add a task']");
	By TASK_INSTRUCTIONS = By.name("$PTempAdhocWork$pAdHocProcess$l1$pTasks$l1$ppyLabel");
		
	OrganizationsList getOrganizationList();
	OperatorList getOperatorsList();
	ContactList getContactList();
	AccountList getAccountList();
	OpportunityList getOpportunityList();
	PartnersList getPartnersList();
	HouseholdList getHouseholdList();
	LeadsList getLeadsList();
	String getLatestRecent();
	TerritoriesList getTerritoriesList();
	Forecast getForecast();
	ClosePlans getClosePlans();
	MyWorkListPE getWorkList();
	void launchJobApplication();
	void launchExpenseReport();
	void enterDetails();
	void enterExpenseDetails();
	void reviewDetails();
	void reviewExpenseDetails();
	
}
