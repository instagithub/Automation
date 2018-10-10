package com.pega.crm.salesautomation.workobjects.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.crm.salesautomation.workobjects.Activity;
import com.pega.crm.salesautomation.workobjects.Tasks;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;
import com.pega.ri.Wizard;
import com.pega.util.XPathUtil;

public  class PegaUtil
{

	public static String STREET_ID="pyStreet";
	public static String ADDRESSLINE2_ID="AddressLine2";
	public static String CITY_ID="pyCity";
	public static String STATE_ID="pyState";
	public static String ZIPCODE_ID="pyPostalCode";
	public static String COUNTRY_ID="pyCountry";
	public static String HOMEPHONE_ID="HomePhone";
	public static String HOMEEMAIL_ID="HomeEmail";
	public static String MOBILE_ID="MobilePhone";
	public static String FAX_ID="FaxNumber";
	public static String SUBMIT_XPATH="//button[@id='ModalButtonSubmit']"+"|"+ XPathUtil.getButtonPzBtnMidXPath("Submit") + "|" + PegaUtil.getStrongButtonXPath("Submit");
	public static String ADDRESSTYPE_XPATH="//select[contains(@id,'AddressType')]";
	public static String SUBTABS_XPATH="//div[@role='tablist']//div[contains(@class, 'count')]//h2";
	public static String NO_ITEM_XPATH="//tr[@id='Grid_NoResults']" + "|" + "//div[text()='No cases are being followed']";
	public static String ACTION_BUTTON_XPATH=PegaUtil.getButtonXpath("Actions");
	public static String OK_BUTTON_XPATH="//button[contains(@data-click,'doFormSubmit')]"+"|"+ XPathUtil.getButtonPzBtnMidXPath("OK") + "|" + "//button[@id='ModalButtonSubmit']";
	public static String SECTION_VALUE_XPATH="//span[@class='assignment_title']|//div[contains(@class, 'dataLabelRead')]";
	public static String ACC_EDIT_XPATH=PegaUtil.getButtonXpath("Edit");
	public static String CREATE_XPATH=PegaUtil.getStrongButtonXPath("Create");
	public static String DISCARD_XPATH=PegaUtil.getSimpleButtonXPath("Discard");
	public static String STREET="Build 12A";
	public static String ADDRESSLINE2="Raheja IT Park";
	public static String CITY="Hyderabad";
	public static String STATE="Telangana";
	public static String ZIPCODE="500019";
	public static String COUNTRY="India";
	public static String HOMEPHONE="040-56984026";
	public static String HOMEEMAIL="HomeEmail@pega.com";
	public static String MOBILE="9874662315";
	public static String FAX="040-5698745";
	public static String SelectAll=Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE);
	public static String[] s = new String[25];
	//public static String OPP_NEXTYEAR_XPATH="//span[@id='yearSpinner']//button[contains(@class, 'spin-button spin-down')]";
	public static String OPP_NEXTYEAR_XPATH="//span[@id='yearSpinner']//button[@class='spin-button spin-up']"; /*changing to class equals* by Raghu*/
	public static int DATE= (new Date().getDate())+1;
	public static String OPP_DAY_XPATH="//*[@data-day='1']";
	public static String DAY_XPATH="//*[@data-day='" + DATE + "']";
	public static String NEWADDRESS_XPATH="//a[contains(@name,'crmAddressList')]";
	public static String RECENT_WO_XPATH="//div[@node_name='RecentItem']";
	public static String REFRESH_XPATH=PegaUtil.getButtonXpath("Refresh") + "|//i[@alt='Refresh']|//i[@title='Refresh']";

	/*public static String ACTIVITY_REFRESH_XPATH = "//i[@title='Refresh' and contains(@name,'Activities')]";
	public static String TASK_REFRESH_XPATH="//button[contains(@name, 'crmTasks')][text()='Refresh'] |//i[contains(@name, 'crmTasks')][@title='Refresh']";
	public static String OPP_CONTACT_REFRESH_XPATH="//button[contains(@name,'crmOpportunityContactsTab')][text()='Refresh']" +"|"+ PegaUtil.getButtonXpathWithIcon("Refresh");
*/
	/*public static String ACTIVITY_REFRESH_XPATH = "//button[contains(@name, 'crmActivitiesList')][text()='Refresh'] | //i[contains(@name, 'crmActivitiesList')][@title='Refresh']";
	public static String TASK_REFRESH_XPATH="//button[contains(@name, 'crmTasks')][text()='Refresh'] |//i[contains(@name, 'crmTasks')][@title='Refresh']";
	public static String OPP_CONTACT_REFRESH_XPATH="//button[contains(@name,'crmOpportunityContactsTab')][text()='Refresh']" +"|"+ PegaUtil.getButtonXpathWithIcon("Refresh");
*/
	public static String ACTIVITY_REFRESH_XPATH = "//button[contains(@name, 'ctivities')][text()='Refresh'] | //i[contains(@name, 'ctivities')][@title='Refresh']|//i[contains(@name, 'ctivities')][contains(@class,'refresh')]";

	public static String TASK_REFRESH_XPATH="//i[@title='Refresh'][contains(@name,'ask')]|//i[contains(@name, 'ask')][contains(@class,'refresh')]";

	public static String OPP_CONTACT_REFRESH_XPATH="//button[contains(@name,'crmOpportunityContactsTab')][text()='Refresh']" +"|"+ PegaUtil.getButtonXpathWithIcon("Refresh")+"|"+"//i[contains(@name, 'contacts')][contains(@class,'refresh')]";

	public static String CALANDER_XPATH="//span[contains(@id, 'CloseDateSpan')]/span | //img[contains(@data-ctl,'DatePicker')]";
	public static void dropdown(PegaWebDriver pegaDriver, String Locator, int index) 
	{
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(Locator)).click();
		pegaDriver.getActiveFrameId(true);
		List <WebElement> dropdownlist= pegaDriver.findElements(By.xpath("//*[@role='menu']/li"));
		if(dropdownlist.size()==0)
		{
			dropdownlist= pegaDriver.findElements(By.xpath("//*[@role='menu']/tr"));
		}
		dropdownlist.get((index-1)).click();
		
	}
	
	public static void dropdown(PegaWebDriver pegaDriver, String Locator, String  dropDownValue) 
	{
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(Locator)).click();
		pegaDriver.getActiveFrameId(true);
		List <WebElement> dropdownlist= pegaDriver.findElements(By.xpath("//*[@role='menu']/li"));
		if(dropdownlist.size()==0)
		{
			dropdownlist= pegaDriver.findElements(By.xpath("//*[@role='menu']/tr"));
		}
		int j=0;
		for(WebElement w:dropdownlist)
		{
			s[j]=w.getText();
			j++;
		}
		
		for(int i=0; i < dropdownlist.size(); i++)
		{
			if(s[i].equals(dropDownValue))
			{
				dropdownlist.get(i).click();
				
			}
			
		}
		
	}
	
	public static void refresh(PegaWebDriver pegaDriver) {
		pegaDriver.findElement(By.xpath("//div[@string_type='field']//button[text()='Actions']")).click();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		pegaDriver.findElement(By.xpath("//span[text()='Refresh']")).click();
	}
	
	public static void autoComplete(PegaWebDriver pegaDriver, String locator, String Value)
	{
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(locator)).sendKeys(Value);
		pegaDriver.waitForDocStateReady(1);
		//pegaDriver.findElement(By.id(locator)).sendKeys(Keys.ARROW_DOWN);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.getActiveFrameId(true);
		
		List <WebElement> autolist=pegaDriver.findElements(By.xpath("//span[@class='match-highlight']"));
		for(WebElement w : autolist)
		{
			String matchContent= w.getText();
			String totalContent =w.findElement(By.xpath("./..")).getText();
			System.out.println("Matching Content::::" + matchContent + "::::::::::Total Content::::::::" + totalContent);
			if((totalContent.toString()).equals(Value))
			{
				pegaDriver.getTestEnv().getDriverActions().moveToElement(w).click().perform();
				//w.click();
				
				break;
			}
		}																						   						 
		/*pegaDriver.findElement(By.id(locator)).sendKeys(Keys.ARROW_DOWN);
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.findElement(By.id(locator)).sendKeys(Keys.ARROW_DOWN);
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement(By.id(locator)).sendKeys(Keys.TAB); */
	}

	public static boolean isActionItemValuePresent(PegaWebDriver pegaDriver, String Locator, String dropDownValue) 
	{
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(Locator)).click();
		pegaDriver.getActiveFrameId(true);
		List <WebElement> dropdownlist= pegaDriver.findElements(By.xpath("//*[@role='menu']/li"));
		if(dropdownlist.size()==0)
		{
			dropdownlist= pegaDriver.findElements(By.xpath("//*[@role='menu']/tr"));
		}
		int j=0;
		for(WebElement w:dropdownlist)
		{
			s[j]=w.getText();
			j++;
		}
		
		for(int i=0; i < dropdownlist.size(); i++)
		{
			if(s[i].equals(dropDownValue))
			{
				return true;
			}
			
		}
		return false;
	}

	public static void setDate(PegaWebDriver pegaDriver, String Locator) {
		
		pegaDriver.findElement(By.xpath(Locator)).click();
		//pegaDriver.findElement(By.id(Locator)).click(); /* changed  to find element by id*/
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(OPP_NEXTYEAR_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(OPP_DAY_XPATH)).click();
		
	}

	public static void setDate(PegaWebDriver pegaDriver, int Date) {
		
		//pegaDriver.findElement(By.xpath(CALANDER_XPATH)).click();
		//pegaDriver.findElement(By.id(Locator)).click(); /* changed  to find element by id*/
		pegaDriver.getActiveFrameId(true);
		//pegaDriver.findElement(By.xpath(OPP_NEXTYEAR_XPATH)).click();
		//pegaDriver.getActiveFrameId(true);
		//DATE = Date+1;
		//pegaDriver.findElement(By.xpath(DAY_XPATH)).click();
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		pegaDriver.findElement(By.xpath(CALANDER_XPATH)).click();
				
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


	public static void clickSubmit(PegaWebDriver pegaDriver) {
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		
		wizard.findElement(By.xpath(SUBMIT_XPATH)).scrollIntoView();
		//pegaDriver.findElement(By.xpath(SUBMIT_XPATH)).scrollIntoView();
		wizard.findElement(By.xpath(SUBMIT_XPATH)).click();
		
	}


	public static void setAddress(PegaWebDriver pegaDriver) 
	{
		
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		
		
		try{
			wizard.findElement(By.xpath("//*[contains(@id,'"+CITY_ID+"')]")).scrollIntoView();
			wizard.findElement(By.xpath("//*[contains(@id,'"+CITY_ID+"')]")).sendKeys(CITY);
			wizard.findElement(By.xpath("//*[contains(@id,'"+STREET_ID+"')]")).sendKeys(STREET);
			wizard.findElement(By.xpath("//*[contains(@id,'"+ADDRESSLINE2_ID+"')]")).sendKeys(ADDRESSLINE2);
			wizard.findElement(By.xpath("//*[contains(@id,'"+STATE_ID+"')]")).sendKeys(STATE);
			wizard.findElement(By.xpath("//*[contains(@id,'"+ZIPCODE_ID+"')]")).sendKeys(ZIPCODE);
			wizard.findSelectBox(By.xpath("//*[contains(@id,'"+COUNTRY_ID+"')]")).selectByVisibleText(COUNTRY);
		}
		catch(Exception e)
		{
			wizard.findElement(By.xpath(NEWADDRESS_XPATH)).scrollIntoView();
			System.out.println("Clicking on Add Address");
			wizard.findElement(By.xpath(NEWADDRESS_XPATH)).click();
			pegaDriver.waitForDocStateReady(1);
			wizard.findElement(By.xpath("//*[contains(@id,'"+CITY_ID+"')]")).scrollIntoView();
			wizard.findElement(By.xpath("//*[contains(@id,'"+CITY_ID+"')]")).sendKeys(CITY);
			wizard.findElement(By.xpath("//*[contains(@id,'"+STREET_ID+"')]")).sendKeys(STREET);
			wizard.findElement(By.xpath("//*[contains(@id,'"+ADDRESSLINE2_ID+"')]")).sendKeys(ADDRESSLINE2);
			wizard.findElement(By.xpath("//*[contains(@id,'"+STATE_ID+"')]")).sendKeys(STATE);
			wizard.findElement(By.xpath("//*[contains(@id,'"+ZIPCODE_ID+"')]")).sendKeys(ZIPCODE);
			wizard.findSelectBox(By.xpath("//*[contains(@id,'"+COUNTRY_ID+"')]")).selectByVisibleText(COUNTRY);
		}
		
		/*try{
			wizard.findElement(By.id(CITY_ID)).scrollIntoView();
			wizard.findElement(By.id(CITY_ID)).sendKeys(CITY);
			wizard.findElement(By.id(STREET_ID)).sendKeys(STREET);
			wizard.findElement(By.id(ADDRESSLINE2_ID)).sendKeys(ADDRESSLINE2);
			wizard.findElement(By.id(STATE_ID)).sendKeys(STATE);
			wizard.findElement(By.id(ZIPCODE_ID)).sendKeys(ZIPCODE);
			wizard.findSelectBox(By.id(COUNTRY_ID)).selectByVisibleText(COUNTRY);
		}
		catch(Exception e)
		{
			wizard.findElement(By.xpath(NEWADDRESS_XPATH)).scrollIntoView();
			System.out.println("Clicking on Add Address");
			wizard.findElement(By.xpath(NEWADDRESS_XPATH)).click();
			pegaDriver.waitForDocStateReady(1);
			wizard.findElement(By.id(STREET_ID)).sendKeys(STREET);
			wizard.findElement(By.id(ADDRESSLINE2_ID)).sendKeys(ADDRESSLINE2);
			wizard.findElement(By.id(CITY_ID)).sendKeys(CITY);
			wizard.findElement(By.id(STATE_ID)).sendKeys(STATE);
			wizard.findElement(By.id(ZIPCODE_ID)).sendKeys(ZIPCODE);
			wizard.findSelectBox(By.id(COUNTRY_ID)).selectByVisibleText(COUNTRY);
		}*/
		
	}
	
	public static void setAddress(PegaWebDriver pegaDriver, String AddressType) 
	{
		try{
			pegaDriver.findElement(By.id(CITY_ID)).sendKeys(CITY);
		}
		catch(Exception e)
		{
			System.out.println("Clicking on Add Address");
			pegaDriver.findElement(By.xpath(NEWADDRESS_XPATH)).click();
			pegaDriver.waitForDocStateReady(1);
			pegaDriver.findSelectBox(By.xpath(ADDRESSTYPE_XPATH)).selectByVisibleText(AddressType);
			pegaDriver.findElement(By.id(STREET_ID)).sendKeys(STREET);
			pegaDriver.findElement(By.id(ADDRESSLINE2_ID)).sendKeys(ADDRESSLINE2);
			pegaDriver.findElement(By.id(CITY_ID)).sendKeys(CITY);
			pegaDriver.findElement(By.id(STATE_ID)).sendKeys(STATE);
			pegaDriver.findElement(By.id(ZIPCODE_ID)).sendKeys(ZIPCODE);
			pegaDriver.findSelectBox(By.id(COUNTRY_ID)).selectByVisibleText(COUNTRY);
		}
		
	}

	


	public static String getAddressType(PegaWebDriver pegaDriver) 
	{
		String addressType= pegaDriver.findSelectBox(By.xpath(ADDRESSTYPE_XPATH)).getFirstSelectedOption().getText();
		return addressType;
	}

	
	public static List<WebElement> getSubTabs(PegaWebDriver pegaDriver) {
		//ArrayList<WebElement> s= new ArrayList<WebElement>();
		List<WebElement> wb=pegaDriver.findElements(By.xpath(SUBTABS_XPATH));
		return wb;
	}
	public static void getSubTab(PegaWebDriver pegaDriver, String subtabName) {
														 
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.getActiveFrameId(true);
		//pegaDriver.findElement(By.xpath(SUBTABS_XPATH)).scrollIntoView();
		Wizard wiz = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		wiz.findElement(By.xpath(SUBTABS_XPATH)).scrollIntoView();
		List<WebElement> wb=pegaDriver.findElements(By.xpath(SUBTABS_XPATH));
		for(WebElement w:wb)
		{
			String s1=w.getText();
			if(s1.equalsIgnoreCase(subtabName))
			{
				w.click();
				pegaDriver.waitForDocStateReady(4);
				pegaDriver.getActiveFrameId(true);
				
				break;
			}
		}
			  
	}


	public static boolean isListEmpty(PegaWebDriver pegaDriver) 
	{
		pegaDriver.switchTo().defaultContent();
		try
		{
			pegaDriver.navigate().refresh();
			pegaDriver.findElement(By.xpath(NO_ITEM_XPATH));
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}


	public static String openWO(PegaWebDriver pegaDriver, String WOName) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	public static String getSectionHeader(PegaWebDriver pegaDriver) {
		pegaDriver.getActiveFrameId(true);
		String ownerHeader=pegaDriver.findElement(By.xpath(SECTION_VALUE_XPATH)).getText();
		return ownerHeader;
	}
	
	public static void clickEdit(PegaWebDriver pegaDriver)
	{
		pegaDriver.findElement(By.xpath(ACC_EDIT_XPATH)).click();
	}
	public static void clickCreate(PegaWebDriver pegaDriver)
	{
		
		
		/*pegaDriver.waitForDocStateReady(1);
		//pegaDriver.findElement(By.xpath(CREATE_XPATH)).scrollIntoView();
		pegaDriver.findElement(By.xpath(CREATE_XPATH)).click();*/
		
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		
		wizard.findElement(By.xpath(CREATE_XPATH)).scrollIntoView();
		//pegaDriver.findElement(By.xpath(SUBMIT_XPATH)).scrollIntoView();
		wizard.findElement(By.xpath(CREATE_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		
	}
	
	public static void clickDiscard(PegaWebDriver pegaDriver)
	{
		
		pegaDriver.findElement(By.xpath(DISCARD_XPATH)).click();
	}
	public static void clickOK(PegaWebDriver pegaDriver)
	{
		pegaDriver.getActiveFrameId(true);
		//pegaDriver.findElement(By.xpath(OK_BUTTON_XPATH)).scrollIntoView();
		pegaDriver.findElement(By.xpath(OK_BUTTON_XPATH)).click();
		
	}

	public static String getSimpleButtonXPath(String buttonText) {
		return "//button[contains(@class, 'Simple pzhc pzbutton') and contains(text(), '" + buttonText + "')]";
	}
	

	public static String getButtonXpath(String buttonText) {
		
		return "//button[contains(@class, 'pzhc pzbutton') and contains(text(),'" + buttonText + "')]";
	}


	public static String getStrongButtonXPath(String buttonText) {
		return "//button[contains(@class, 'Strong pzhc pzbutton') and contains(text(), '" + buttonText + "')]";
	}
	public static String getSegmentedButtonXPath(String buttonText) {
		return "//button[contains(@class, 'Segmented pzhc pzbutton') and contains(text(), '" + buttonText + "')]";
	}
	public static String getButtonXpathWithIcon(String buttonText){
		return "//i[contains(@title, '"+buttonText+"')]";
	}
	public static void clickRefresh(PegaWebDriver pegaDriver)
	{
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.getActiveFrameId(true);
		//pegaDriver.findElement(By.xpath(REFRESH_XPATH)).scrollIntoView();
		pegaDriver.findElement(By.xpath(REFRESH_XPATH)).click();
	}	
	public static void clickRefresh(PegaWebDriver pegaDriver, String tabName)
	{
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.getActiveFrameId(true);
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		wizard.findElement(By.xpath("//i[@title='Refresh'][contains(@name,'"+ tabName+"')]")).scrollIntoView();
		//pegaDriver.findElement(By.xpath(REFRESH_XPATH)).scrollIntoView();
		pegaDriver.findElement(By.xpath("//i[@title='Refresh'][contains(@name,'"+ tabName+"')]")).click();
	}	
	public static void navigateToRecentItem(PegaWebDriver pegaDriver, String WOName)
	{
		pegaDriver.findElement(By.xpath(RECENT_WO_XPATH + "//a[text()='" + WOName +"']")).click();
	}
  public static boolean isRowValuePresent(PegaWebDriver pegaDriver, String RowIdentifier, String ColumnIdentifier, String RowValue)
	{
		pegaDriver.getActiveFrameId(true);
		List<WebElement> wb =pegaDriver.findElements(By.xpath(RowIdentifier));

		for(WebElement w : wb)
		{
			WebElement s = w.findElement(By.xpath("." + ColumnIdentifier));
			String name= s.getText();
			if(name.equals(RowValue))
			{
				return true;
			}
		}
		return false;
	}
  
  public static void openRowWithDoubleClick(PegaWebDriver pegaDriver, String RowIdentifier, String ColumnIdentifier, String RowValue)
	{
	  String frameId = pegaDriver.getActiveFrameId(false);
		Frame frame = pegaDriver.findWizard(frameId);
		List<WebElement> wb =pegaDriver.findElements(By.xpath(RowIdentifier));

		for(WebElement w : wb)
		{
			WebElement s = w.findElement(By.xpath("." + ColumnIdentifier));
			String name= s.getText();
			System.out.println("::::::::::::::::::::::::"+name);
			if(name.equals(RowValue))
			{
				System.out.println("in final condition");
				PegaWebElement pwb=pegaDriver.convertToPegaWebElmt(s, By.xpath(RowIdentifier), frame);
				pwb.doubleClick();
			}
		}
		
	}

	
	public static List<String> getRowValues(PegaWebDriver pegaDriver,String RowIdentifier, String rowName) {
		List<String> ColumnValues= new ArrayList<String>();
		
		
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		wizard.findElement(By.xpath(RowIdentifier)).scrollIntoView();
		
		List<WebElement> wb =wizard.findElements(By.xpath(RowIdentifier));

		for(WebElement w : wb)
		{
			
			
			WebElement RowIdentifer = w.findElement(By.xpath("."+ "//td[1]/div"));
			String name= RowIdentifer.getText();
			System.out.println("Row Values::::::" + name);
			if(name.equals(rowName))
			{
				List<WebElement> columnIdentifiers=w.findElements(By.xpath("."+ "//td/div"));
				for(WebElement s: columnIdentifiers)
				{
					String temp = s.getText();
					System.out.println("Column Values::::::::" + temp);
					ColumnValues.add(temp);
				}
				pegaDriver.getActiveFrameId(true);
				return ColumnValues;
			}
		}
		pegaDriver.getActiveFrameId(true);
		return null;
	}

	public static Tasks addTask(PegaWebDriver pegaDriver) {
		pegaDriver.getActiveFrameId(true);
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Add task");
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Tasks tasksDetails = new PegaTasks(framElmt, frameId);
		tasksDetails._setEnvironment((pegaDriver.getTestEnv()),frameId);
		return tasksDetails;
		
	}

	public static Activity addActivity(PegaWebDriver pegaDriver) {
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Add activity");
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Activity ActivityDetails = new PegaActivity(framElmt, frameId);
		ActivityDetails._setEnvironment((pegaDriver.getTestEnv()), frameId);
		return ActivityDetails;
	}
	
	public static List<String> getRowValues(PegaWebDriver pegaDriver,String RowIdentifier, String columValue1, String columValue2){
		List<String> ColumnValues= new ArrayList<String>();
		pegaDriver.getActiveFrameId(true);
		List<WebElement> wb =pegaDriver.findElements(By.xpath(RowIdentifier));

		for(WebElement w : wb)
		{
			//WebElement RowIdentifer = w.findElement(By.xpath("."+ "//td[@data-importance='primary']/div"));
			WebElement RowIdentifer = w.findElement(By.xpath("."+ "//td[1]/div"));
			String name= RowIdentifer.getText();
			System.out.println("Row Values::::::" + name);
			if(name.contains(columValue1))
			{
				WebElement RowIdentifer1 = w.findElement(By.xpath("."+ "//td[2]/div"));
				String name1= RowIdentifer1.getText();
				if(name1.contains(columValue2))
				{
					List<WebElement> columnIdentifiers=w.findElements(By.xpath("."+ "//td/div"));
					for(WebElement s: columnIdentifiers)
					{
						String temp = s.getText();
						System.out.println("Column Values::::::::" + temp);
						ColumnValues.add(temp);
					}
					return ColumnValues;
				}
				
			}
		}
		return null;
	}
	public static String getDateFormatter(String date, String Format)
	{
		Date dt = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(Format);
		try {
			dt=formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String strDate= formatter.format(dt);
		return strDate;
	}
}
