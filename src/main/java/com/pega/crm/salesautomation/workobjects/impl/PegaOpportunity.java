package com.pega.crm.salesautomation.workobjects.impl;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Opportunities;
import com.pega.crm.salesautomation.workobjects.Organizations;
import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;
import com.pega.util.XPathUtil;

public class PegaOpportunity extends WizardImpl implements Opportunities {

	public PegaOpportunity(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	String OPP_SERACHBUTTON_XPATH=PegaUtil.getButtonXpath("Search");
	String OPP_ACTIVITY_ROW_IDENTIFIER_XPATH = "//tr[contains(@id, 'ctivities')]";
	String OPP_TERRIROTRY_VALUE_XPATH = "//span[text()='Territory']/../div";
	String OPP_SHORTNAME_VALUE_XPATH = "//span[text()='Short name']/../div";
	String OPP_SOURCE_VALUE_XPATH = "//span[text()='Source']/../div";
	String OPP_WIN_VALUE_XPATH = "//span[text()='Must win']/../div";
	String OPP_CLOSEDATE_VALUE_XPATH="//span[text()='Close date']/../../div/span";
	String OPP_CHANGE_STAGE_XPATH=PegaUtil.getButtonXpath("Change stage");
	String OPP_AMOUNT_ID="OpportunityAmount";
	String OPP_CALANDER_XPATH="//span[contains(@id, 'CloseDateSpan')]/span | //img[contains(@data-ctl,'DatePicker')]";
	//String OPP_NEXTYEAR_="nextYear";
	String OPP_DAY_XPATH="//*[@data-day='1']";
	String OPP_NAME_ID="Name";
	String OPP_TERRITORY_ID="crmTerritorySearch";
	String OPP_CONTACT_ID="crmSearchRelatedAccount";
	String OPP_FORECASTCATEGORY_ID="ForecastCategory";
	String OPP_SOURCE_ID="OpportunitySource";
	By OPP_MUSTWIN_ID = By.xpath("//*[@data-test-id='20141218032601036332861']");	
	String OPP_DESCRIPTION_ID="pyDescription";
	String OPP_CREATE_XPATH=PegaUtil.getStrongButtonXPath("Create");
	String OPP_SHORTNAME_ID="OpportunityShortName";
	String OPP_TASK_ROW_IDENTIFIER_XPATH= "//tr[contains(@oaargs, 'WORK-TASK')]";
	
	String OPP_OK_BUTTON_XPATH="//button[contains(@data-click,'doFormSubmit')]"+XPathUtil.getButtonPzBtnMidXPath("OK");
	String OPP_STAGE_ID="OpportunityStage";
	String OPP_NAME_VALUE_XPATH="//*[text()='Name']/../../div/span";
	String OPP_SUBTABS_XPATH="//div[@role='tab']//h2";
	String OPP_SUBMIT_BUTTON_ID="submitButton";
	String OPP_AMOUNT_VALUE_XPATH="//*[text()='Amount']/../../div/span/span";
	String OPP_FORECAST_VALUE_XPATH="//*[text()='Forecast category']/../div";
	String OPP_SECTION_VALUE_XPATH="//span[@class='assignment_title']";
	String OPP_OPPTY_CUSTOM_SECTION_VALUE_XPATH="//*[text()='Opportunity']";
	String OPP_SWITCH_TO_EDIT_MODE_XPATH="//*[contains(@title, 'Switch to edit mode')]";
	String OPP_CHANGEOWNER_ID="crmSearchOwner";
	String OPP_CLEARCHANGEOWNER_ID="pyOwnerUserID";
	String OPP_CHANGEREASON_ID="ChangeReason";
	String OPP_OWNER_VALUE_XPATH="//*[text()='Owner']/../div";
	String OPP_CLOSEREASON_XPATH="//select[contains(@name, 'CloseReason')]";
	String OPP_CLOSECOMMENTS_ID="CloseComments";
	String OPP_STAGE_BUSINESS_VALUE_XPATH="//label[text()='Stage']/..//div|//span[text()='Stage']/../div/span";
	String OPP_STAGE_INDIVIDUAL_VALUE_XPATH="//span[text()='Stage']/../div/span|//label[text()='Stage']/..//div";
	String OPP_FILTER_ID="FilterTermForOpportunity";
	String OPP_SUBJECT_ID="TaskSubject";
	String OPP_TYPE_XPATH="//select[contains(@id, 'TaskType')]";
	String OPP_DUEDATE_XPATH="//span[contains(@name, 'TaskDueDate')]";
	String OPP_STATUS_XPATH="//select[contains(@name, 'TaskStatus')]";
	String OPP_ADDROW_XPATH="//*[contains(text(),'Add contact')]";
	String OPP_SEARCH_CONTACT_ID="ContactName";
	String OPP_PRIMARY_CONTACT_ID="IsPrimaryContact1";
	String OPP_CONTACTNAME_SUBTAB_XPATH="//td[@data-importance='primary']//a";
	String OPP_UPDATE_CONTACT_HEADER_XPATH="//label[@class='actionTitleBarLabelStyle']";
	String OPP_SELECTDUPLICATE_CONTACT_XPATH="//input[@type='radio']";
	String OPP_NEXT_BUTTON_XPATH=PegaUtil.getStrongButtonXPath("Next");
	String OPP_SELECTCHECKBOX_FOR_DESCRIPTION_XPATH="//tr[@pl_index='1']//div[@section_index='1']//input[contains(@name,'SelectedNew')]/..//label";
	String OPP_DESCRIPTION_WHILEMERGE_ID="pyDescription1";
	String OPP_SELECT_CHECKBOX_OPPTY_MUST_WIN_XPATH="//tr[@pl_index='9']//div[@section_index='1']//input[contains(@name,'SelectedNew')]/..//label";
	String OPP_SELECT_OPPTY_MUST_WIN_ID="OpportunityMustWintrue";
	String OPP_AFFINITIESSCROLLING_XPATH="//span[text()='Affinities']";
	String OPP_RECENTSSCROLLING_XPATH="//h2[text()='Recent']";
	String OPP_FOLLOWSCROLLING_XPATH = "//h2[text()='Following']";
	//String OPP_FOLLOWTESTING_XPATH = "//div[@pyclassname='Index-WorkPartyUri']//a";
	String OPP_FOLLOWTESTING_XPATH = "//div[contains(@param_name,'Favorites')]//a";
	String OPP_UNFOLLOW_XPATH=PegaUtil.getButtonXpath("Unfollow");
	String OPP_FOLLOW_XPATH=PegaUtil.getButtonXpath("Follow");
	String OPP_TECHINALSECTION_EXPAND="//div[@aria-label='Disclose Technical information']";
	String OPP_STATUS_VALUE_XPATH="//span[text()='Status']/..//div/span";
	
	String OPP_FILTER_PLACEHOLDER_XPATH = "//input[@placeholder='Filter opportunity']";
	String OPP_FILTERBUTTON_XPATH=PegaUtil.getButtonXpath("Filter");																				
	String defaultAcc= "//label[@for='Name']/following-sibling::div//a";
	String TECHINICAL_INFORMATION="//div[@title='Disclose Technical information']";
	//String ORGANIZATION_BREADCRUMB_XPATH="//a[@title='Organization' and @class='Breadcrumbs']";
	String ORGANIZATION_BREADCRUMB_XPATH="//a[@title='Organization' and contains(@name,'BreadCrumbs')]";
	String OPP_MOVE_TO_NEXT_STAGE_XPATH="//div[@data-node-id='NextStageProbability']";
	String OPP_WIN_PROBABILITY_XPATH="//div[@data-node-id='WinProbability']";
	String OPP_CLOSE_DATE_XPATH="//div[@data-node-id='CloseDateAnalysis']";
	String OPP_NEXT_BEST_ACTIONS_XPATH="//div[@data-node-id='CloseDateAnalysis']";		
	String OPP_STAGES[]={"Qualification","Analysis","Proposal","Decision","Negotiation"};
	List<String> OPPSTAGES = new ArrayList<String>(Arrays.asList(OPP_STAGES));
	
	
	@Override
	public void setAmount(String oppAmount) {
		
		findElement(By.id(OPP_AMOUNT_ID)).sendKeys(PegaUtil.SelectAll);
		findElement(By.id(OPP_AMOUNT_ID)).sendKeys(oppAmount);
		
		
	}

	@Override
	public void setDate() 
	{
		PegaUtil.setDate(pegaDriver, OPP_CALANDER_XPATH);
	}

	@Override
	public void setName(String oppName) 
	{
		
		findElement(By.id(OPP_NAME_ID)).sendKeys(PegaUtil.SelectAll);
		findElement(By.id(OPP_NAME_ID)).sendKeys(oppName);
		
	}

	@Override
	public void setTerritory(String oppTerritory) {
		
		PegaUtil.autoComplete(pegaDriver, OPP_TERRITORY_ID, oppTerritory);
	}

	@Override
	public void setContact(String oppContact) {
		PegaUtil.autoComplete(pegaDriver, OPP_CONTACT_ID, oppContact);
		
	}

	@Override
	public void setForecastCategory(String oppforecastcategory) {
		
		findSelectBox(By.id(OPP_FORECASTCATEGORY_ID)).selectByVisibleText(oppforecastcategory);
		
	}

	
	@Override
	public String setStage(String oppStage) {
		StringBuffer selectedStage=new StringBuffer(oppStage);

		
		selectedStage=new StringBuffer(findSelectBox(By.id(OPP_STAGE_ID)).getFirstSelectedOption().getText());
		if(selectedStage.equals("Select..."))
		{
			selectedStage=new StringBuffer(OPPSTAGES.get(0));
			/*int i=OPPSTAGES.indexOf(oppStage);
			if(i==4)
				NewStage=new StringBuffer(OPPSTAGES.get(i-1));
			else
				NewStage=new StringBuffer(OPPSTAGES.get(i+1));
			findSelectBox(By.id(OPP_STAGE_ID)).selectByVisibleText(NewStage.toString());*/
		}
		return selectedStage.toString();
	}

	@Override
	public void clickOK() 
	{
		
		Wizard wizard=findWizard(getActiveFrameId(false));
		wizard.findElement(By.xpath(OPP_OK_BUTTON_XPATH)).scrollIntoView();
		//findElement(By.xpath(OPP_OK_BUTTON_XPATH)).scrollIntoView();
		findElement(By.xpath(OPP_OK_BUTTON_XPATH)).click();
		
	}

	@Override
	public String getName() {
		
		String oppname=findElement(By.xpath(OPP_NAME_VALUE_XPATH)).getText();
		return oppname;
	}

	@Override
	public ArrayList<String> getSubTabs() {
		ArrayList<String> s= new ArrayList<String>();
		List<WebElement> wb=findElements(By.xpath(OPP_SUBTABS_XPATH));
		System.out.println(wb.size());
		for(WebElement w:wb)
		{
			String s1=w.getText();
			s.add(s1);
		}
		System.out.println(s.size());
		return s;
	}

	@Override
	public void clickEdit() {
		
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, 1);
		
	}

	@Override
	public boolean isStageEnabled() {
		
		boolean b=findElement(By.id(OPP_STAGE_ID)).isEnabled();
		return b;
		
	}

	@Override
	public boolean isCloseDateEnabled() {
		
		boolean b=findElement(By.xpath(OPP_CALANDER_XPATH)).isEnabled();
		return b;
	}

	@Override
	public boolean isAmountEnabled() {
		
		boolean b=findElement(By.id(OPP_AMOUNT_ID)).isEnabled();
		return b;
		
	}

	@Override
	public void clickSubmitButton() {
		/*
		findElement(By.xpath(OPP_SUBMIT_BUTTON_ID)).click();*/
		PegaUtil.clickSubmit(pegaDriver);
	}

	@Override
	public String getAmount() {
		String s[]= null;
		String amount=findElement(By.xpath(OPP_AMOUNT_VALUE_XPATH)).getText();
		try {
			amount=NumberFormat.getCurrencyInstance(Locale.US).parse(amount).toString();
			 s = amount.split(":");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		return s[0];
	}

	@Override
	public String getForecast() {
		String forecast=findElement(By.xpath(OPP_FORECAST_VALUE_XPATH)).getText().trim();
		return forecast;
	}

	@Override
	public void clickChangeOwner() {
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Change owner");
		
	}

	@Override
	public String getSectionHeader() {
		
		String ownerHeader=findElement(By.xpath(OPP_SECTION_VALUE_XPATH)).getText();
		return ownerHeader;
	}

	@Override
	public void setOwner(String changeOwner) {
		
		//findElement(By.xpath(OPP_SWITCH_TO_EDIT_MODE_XPATH)).click();
		
		findElement(By.id(OPP_CHANGEOWNER_ID)).sendKeys(PegaUtil.SelectAll);
		PegaUtil.autoComplete(pegaDriver, OPP_CHANGEOWNER_ID, changeOwner);
		
	}

	@Override
	public void setReason(String reason) {
		findElement(By.id(OPP_CHANGEREASON_ID)).sendKeys(reason);
		
	}

	@Override
	public String getOwner() {
		
		String owner=findElement(By.xpath(OPP_OWNER_VALUE_XPATH)).getText().trim();
		return owner;
	}

	@Override
	public void clickCloseForBusiness() 
	{
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Close");
		
	}

	@Override
	public void clickCloseForIndividual() 
	{
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Close");
		
	}

	@Override
	public void setCloseReason(String closeReason) {
		
		findSelectBox(By.xpath(OPP_CLOSEREASON_XPATH)).selectByVisibleText(closeReason);
		
	}

	@Override
	public void setCloseComments(String closeComments) {
		findElement(By.id(OPP_CLOSECOMMENTS_ID)).sendKeys(closeComments);
		
	}

	@Override
	public boolean isActionItemValuePresent(String dropDownValue) {
		return(PegaUtil.isActionItemValuePresent(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, dropDownValue));
		
	}

	@Override
	public void clickUpdateStage() {
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Change stage");
	}

	@Override
	public String getStageForBusiness() 
	{
		
		String stage=findElement(By.xpath(OPP_STAGE_BUSINESS_VALUE_XPATH)).getText();
		return stage;
	}

	@Override
	public String getStageForIndividual() 
	{
		
		String stage=findElement(By.xpath(OPP_STAGE_INDIVIDUAL_VALUE_XPATH)).getText();
		return stage;
	}

	@Override
	public void clickCloneOpportunity() {
		
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Clone opportunity");
		
	}

	@Override
	public String getSectionCustomHeader() {
		
		String CloneHeader=findElement(By.xpath(OPP_OPPTY_CUSTOM_SECTION_VALUE_XPATH)).getText();
		return CloneHeader;
		
	}

	@Override
	public void setSubject(String subject) {
		
		findElement(By.id(OPP_SUBJECT_ID)).sendKeys(subject);
		
	}

	

	@Override
	public void setDueDate() {
		PegaUtil.setDate(pegaDriver, OPP_DUEDATE_XPATH);
		
	}

	@Override
	public void setType(String type) 
	{
		
		findSelectBox(By.xpath(OPP_TYPE_XPATH)).selectByVisibleText(type);
		
	}

	@Override
	public void setStatus(String status) 
	{
		
		findSelectBox(By.xpath(OPP_STATUS_XPATH)).selectByVisibleText(status);
		
	}

	@Override
	public void addRow() {
		//WebDriver driver = (WebDriver)pegaDriver;
		
	/*	Actions ac = new Actions(pegaDriver);
		System.out.println("In Add row" + ac);*/
		
		/*ac.moveToElement(findElement(By.xpath(OPP_ADDROW_XPATH))).click();
		*/
		PegaWebElement wb=
				findElement(By.xpath(OPP_ADDROW_XPATH));
		wb.sendKeys(Keys.ENTER);
		
	}

	@Override
	public void clickUpdateContacts() 
	{
		
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Update contacts");
		
	}

	@Override
	public void enterContact(String contactName)
	{
		
		/*findElement(By.id(OPP_SEARCH_CONTACT_ID)).sendKeys(contactName);
		findElement(By.id(OPP_SEARCH_CONTACT_ID)).sendKeys(Keys.TAB);*/
		PegaUtil.autoComplete(pegaDriver, OPP_SEARCH_CONTACT_ID, contactName);
	}

	@Override
	public void setPrimaryContact() 
	{
		findElement(By.id(OPP_PRIMARY_CONTACT_ID)).click();
		
	}

	@Override
	public void clickContactSubtab() 
	{
		PegaUtil.getSubTab(pegaDriver, "Contacts");
		
		//wizard.findElement(By.xpath(PegaUtil.OPP_CONTACT_REFRESH_XPATH)).scrollIntoView();
		//wizard.findElement(By.xpath(PegaUtil.OPP_CONTACT_REFRESH_XPATH)).click();
		//PegaUtil.clickRefresh(pegaDriver);
		
		
	}
	
	@Override
	public void clickCloseplanSubtab() 
	{
		System.out.println("Inside Function");
		
		PegaUtil.getSubTab(pegaDriver, "Close plans");
		//findElement(By.xpath("//h3[contains(text(),'Close plans')]")).click();
		
		PegaWebElement wb;
		PegaWebElement wb1;
		wb1 = findElement(By.xpath("//div[@node_name='ClosePlanButtons']"));
		
		wb = wb1.findElement(By.xpath("//button[text()='Add new']"));
		int i= 1;
		boolean re;
		
		
		while (!(verifyElement(By.id("PEGA_GRID18"))))
		{
			
			System.out.println("i value is : " + i);
			//getTestEnv().getDriverActions().moveToElement(wb).click().perform();
			wb1.findElement(By.xpath("//button[text()='Add new']")).click();
			i++;
			
		}
		
	}
	
	

	@Override
	public String getContactNameInSubtab() {
		
		String name=findElement(By.xpath(OPP_CONTACTNAME_SUBTAB_XPATH)).getText();
		return name;
	}

	@Override
	public String getUpdateContactsHeader() {
		
		String header=findElement(By.xpath(OPP_UPDATE_CONTACT_HEADER_XPATH)).getText();
		return header;
	}

	@Override
	public void clickMegeOpportunity() 
	{
		
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Merge opportunity");
		
	}

	@Override
	public void selectOpportunuty()
	{
		
		findElement(By.xpath(OPP_SELECTDUPLICATE_CONTACT_XPATH)).click();
		
	}
	@Override
	public void selectOpportunitytoMerge(String opptyName)
	{
		
		findElement(By.id(OPP_NAME_ID)).sendKeys(opptyName);
		findElement(By.xpath(OPP_SERACHBUTTON_XPATH)).click();
		
		findElement(By.xpath(OPP_SELECTDUPLICATE_CONTACT_XPATH)).click();
	}

	@Override
	public void clickNext() 
	{
		
		findElement(By.xpath(OPP_NEXT_BUTTON_XPATH)).click();
		
	}

	@Override
	public void setDescrptionWhileMerge(String Description) 
	{
		
		findElement(By.xpath(OPP_SELECTCHECKBOX_FOR_DESCRIPTION_XPATH)).click();

		findElement(By.id(OPP_DESCRIPTION_WHILEMERGE_ID)).sendKeys(Description);
		
	}

	@Override
	public void setOpptyMustWinWhileMerge() 
	{
		
		findElement(By.xpath(OPP_SELECT_CHECKBOX_OPPTY_MUST_WIN_XPATH)).click();
		findElement(By.id(OPP_SELECT_OPPTY_MUST_WIN_ID)).click();
		
	}	
	
	public void clickFollow()
	{
		findElement(By.xpath(OPP_FOLLOW_XPATH)).click();
	}
	public void clickUnFollow()
	{
		if(verifyElement(By.xpath(OPP_UNFOLLOW_XPATH)))
			findElement(By.xpath(OPP_UNFOLLOW_XPATH)).click();
		else
		{
			clickFollow();
			
			findElement(By.xpath(OPP_UNFOLLOW_XPATH)).click();
		}

	}
	
	@Override
	public String getFollowedWOName() {
		
		String accName=findElement(By.xpath(OPP_FOLLOWTESTING_XPATH)).getText();
		System.out.println(":::::::::::::::::::::::::::::Followed opptyName:::::::::::"+accName);
		return accName;
		
	}
	@Override
	public boolean isFollowingListEmpty()
	{
		/*Wizard wizard=findWizard(getActiveFrameId(false));
		wizard.findElement(By.xpath(OPP_FOLLOWSCROLLING_XPATH)).scrollIntoView();*/
		return(PegaUtil.isListEmpty(pegaDriver));
		
	}


	@Override
	public void setSource(String Source) {
		findSelectBox(By.id(OPP_SOURCE_ID)).selectByValue(Source);
	}


	@Override
	public void setShotName(String shortname) {
		findElement(By.id(OPP_SHORTNAME_ID)).sendKeys(shortname);		
	}


	@Override
	public void setOpptyMustWin() {
		findElement(OPP_MUSTWIN_ID).click();
		
	}


	@Override
	public void setDescrption(String Description) {
		
		findElement(By.id(OPP_DESCRIPTION_ID)).sendKeys(Description);
	}


	@Override
	public void clickSubmit() {
		PegaUtil.clickCreate(pegaDriver);
		
	}


	@Override
	public String getClosedate() {
		
		
		String closedate = findElement(By.xpath(OPP_CLOSEDATE_VALUE_XPATH)).getText();
		return closedate;
	}


	@Override
	public String getTerritory() {

		String territory = findElement(By.xpath(OPP_TERRIROTRY_VALUE_XPATH)).getText();
		return territory;
	}


	@Override
	public String getShortName() {

		String shortname= findElement(By.xpath(OPP_SHORTNAME_VALUE_XPATH)).getText();
		return shortname;
	}


	@Override
	public String getSource() {

		String source = findElement(By.xpath(OPP_SOURCE_VALUE_XPATH)).getText();
		return source;
	}


	@Override
	public String getWin() {
		String win = findElement(By.xpath(OPP_WIN_VALUE_XPATH)).getText();
		return win;
	}


	@Override
	public void clickCreate() {
		PegaUtil.clickCreate(pegaDriver);
		
	}


	@Override
	public void navigateToRecentOppty(String cloneopptyname) {
		PegaUtil.navigateToRecentItem(pegaDriver, cloneopptyname);
		
	}


	@Override
	public String getOpptyStatus() {
		
		
		findElement(By.xpath(OPP_TECHINALSECTION_EXPAND)).click();
	
		String opptystatus= findElement(By.xpath(OPP_STATUS_VALUE_XPATH)).getText().trim();
		return opptystatus;
	}


	@Override
	public void getActivitiesSubTab()
	{
		
		PegaUtil.getSubTab(pegaDriver, "Activities");
		
		
	}


	@Override
	public List<String> getTaskValues(String RowName) {
		//findElement(By.xpath(PegaUtil.ACTIVITY_REFRESH_XPATH)).scrollIntoView();
		findElement(By.xpath(PegaUtil.TASK_REFRESH_XPATH)).click();
		
		return(PegaUtil.getRowValues(pegaDriver, OPP_TASK_ROW_IDENTIFIER_XPATH, RowName));
		
	}


	@Override
	public List<String> getActivityValues(String ActivityName) {
		Wizard wizard=findWizard(getActiveFrameId(false));
		wizard.findElement(By.xpath(PegaUtil.ACTIVITY_REFRESH_XPATH)).scrollIntoView();
		//findElement(By.xpath()).scrollIntoView();
		findElement(By.xpath(PegaUtil.ACTIVITY_REFRESH_XPATH)).click();
		
		return(PegaUtil.getRowValues(pegaDriver, OPP_ACTIVITY_ROW_IDENTIFIER_XPATH, ActivityName));
	}


	@Override
	public void clickUpdateStagefromSubtab() {
		
		findElement(By.xpath(OPP_CHANGE_STAGE_XPATH)).click();
	}
	@Override
	public boolean isMovetoNextStageAvailable() {
		
		Wizard wizard=findWizard(getActiveFrameId(false));
		wizard.findElement(By.xpath(OPP_MOVE_TO_NEXT_STAGE_XPATH)).scrollIntoView();
		return (wizard.findElement(By.xpath(OPP_MOVE_TO_NEXT_STAGE_XPATH)).isDisplayed());
	}


	@Override
	public boolean isWinProvavilityAvailable() {
		
		return (findElement(By.xpath(OPP_WIN_PROBABILITY_XPATH)).isDisplayed());
	}


	@Override
	public boolean isCloseDateAvailable() {
		return (findElement(By.xpath(OPP_CLOSE_DATE_XPATH)).isDisplayed());
	}


	@Override
	public boolean isNextBestActionAvailable() {
		return (findElement(By.xpath(OPP_NEXT_BEST_ACTIONS_XPATH)).isDisplayed());
	}


	@Override
	public String getDefaultAccount() {
		
		String desc;
		//if(verifyElement(By.xpath(defaultOrg)))
		desc= findElement(By.xpath(defaultAcc)).getAttribute("text").trim();		
		return desc;
		
	}
@Override
	public String getOppID() {
		
		//findElement(By.xpath(TECHINICAL_INFORMATION)).scrollIntoView();
		findElement(By.xpath(TECHINICAL_INFORMATION)).click();
		
		return (findElement(By.xpath("//span[text()='ID']/..//div/span")).getText());
	}

	
	@Override
	public Organizations navigateToOrgFromBreadCrumb() {
		
		findElement(By.xpath(ORGANIZATION_BREADCRUMB_XPATH)).click();
		String frameId = getActiveFrameId(false);
		Organizations org = new PegaOrganization(frameId, testEnv);
		return org;
		
	}


	@Override
	public void clearNameinMergeOppty() {
		
		findElement(By.id(OPP_NAME_ID)).sendKeys(PegaUtil.SelectAll);
	}


	@Override
	public void clearAccountinMergeOppty() {
		
		findElement(By.id(OPP_CONTACT_ID)).sendKeys(PegaUtil.SelectAll);
	}


	@Override
	public void clearOwnerinMergeOppty() {
		
		findElement(By.id(OPP_CLEARCHANGEOWNER_ID)).sendKeys(PegaUtil.SelectAll);
	}


	@Override
	public void clickSearch() {
		findElement(By.xpath(OPP_SERACHBUTTON_XPATH)).click();
	}


	@Override
	public void setCloseplanupdates() {
		findElement(By.id("cke_1_contents")).click();
		
		findElement(By.id("cke_1_contents")).sendKeys("Testing");	
		//findElement(By.xpath("")).sendKeys("");
		//findElement(By.xpath("")).sendKeys("");
		
	}


	@Override
	public void clickSalesTeamSubtab() {
		
		
		findElement(By.xpath("//h2[contains(text(),'Sales team')]")).click();
		
		findElement(By.xpath("//i[contains(@name,'crmSalesTeam')]")).click();
	}


	@Override
	public void addTeamMember(String operator) {
		
		
		PegaUtil.autoComplete(pegaDriver, OPP_SEARCH_CONTACT_ID, operator);
		
		findSelectBox(By.xpath("//select[contains(@id,'TeamMemberRole')]")).selectByVisibleText("Sales Rep");
		//findElement(By.id("crmSearchTerm")).sendKeys("operator");
		findElement(By.id("ModalButtonSubmit")).click();
		
		
	}
	
	@Override
	public boolean isTeamMemberAdded(String opr, String Role)
	{
		
		if(verifyElement(By.xpath("//a[contains(@class,'Strong') and text()='"+opr+"']")))
			if(verifyElement(By.xpath("//table[@pl_prop_class='PegaCRM-Party-TeamMember']//td//div[contains(text(),'"+Role+"')]")))
				return true;
		else 
		{
			System.out.println("Failed second");
			return false;
		}
			else 
		{
			System.out.println("Failed first");
			return false;
		}
	}
	
	
}
