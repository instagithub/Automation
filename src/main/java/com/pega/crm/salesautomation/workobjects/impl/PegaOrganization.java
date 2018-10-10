package com.pega.crm.salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.crm.salesautomation.workobjects.Accounts;
import com.pega.crm.salesautomation.workobjects.Activity;
import com.pega.crm.salesautomation.workobjects.Organizations;
import com.pega.crm.salesautomation.workobjects.Relationship;
import com.pega.crm.salesautomation.workobjects.Tasks;
import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;
import com.pega.util.XPathUtil;

public class PegaOrganization extends WizardImpl implements Organizations {
	
	public String CreateOrganizationButton = new String("//button[@title='Create organization']");
	String ORG_SEARCH_FIELD = "//input[@placeholder='Filter Organizations']";
	public String EDIT_BUTTON = new String("//button[text()='Edit']");	
	String ORGANIZATIONS_TAB = new String("//span[contains(text(),'Organizations')]");
	String NEW_ORG_TITLE_XPATH = "//a[@title='New Organization']";
	String ORG_TERRIORTY_ID ="crmTerritorySearch";
	String ParentOrg = "crmSearchOrg";
	String ActionsButton = "//button[text()='Actions']";
	String LEAD_ROWS_XPATH="//tr[contains(@oaargs, 'UPLUS-SAPLUS-WORK-LEAD')]"; 
	String ORG_ACTIONS_XPATH = XPathUtil.getButtonPzBtnMidXPath("Actions ");
	String listviewtoggle_xpath="//i[contains(@title,'Toggle to list mode')]";
	String ORG_SUBTABS_XPATH = "//div[@role='tab']//h2";
	public PegaOrganization(WebElement elmt) {
		super(elmt);
	}
	
	public PegaOrganization(WebElement elmt, String elmtId){
		super(elmt, elmtId);
	}
	 
	String selectAll=Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE);
	
	@Override
	public Organizations getOrganizationDetails( ) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations orgDetails = new PegaOrganization(framElmt, frameId);
		orgDetails._setEnvironment(testEnv, frameId);
		return orgDetails;	
	}
	
	public Organizations editOrganization()
	
	{
		pegaDriver.getActiveFrameId(true);
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		pegaDriver.findElement(By.xpath(EDIT_BUTTON)).click();		
		frameId = pegaDriver.getActiveFrameId(false);
		frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations editOrg = new PegaOrganization(frameElmt, frameId);
		editOrg._setEnvironment(testEnv, frameId);
		return editOrg;
	}

	@Override
	public Organizations changeOwner() {
		
		pegaDriver.findElement(By.xpath("//div[@string_type='field']//button[text()='Actions']")).click();
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		pegaDriver.findElement(By.xpath("//li[@title='Assign to a new owner']")).click();
		//PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Change owner");	
		
		 frameId = pegaDriver.getActiveFrameId(false);
		 frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		//Org.findElement(By.xpath("//button[@type='button' and @role='button']")).click();
		//Org.findElement(By.xpath("//div[@class='menuBarSub']//td[@title='Assign to a New Owner']")).click();
	    return Org;
	}
	
	@Override
	public Organizations changeHierarchy()
	{
		/*pegaDriver.findElement(By.xpath("//div[@string_type='field']//button[text()='Actions ']")).click();
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		pegaDriver.findElement(By.xpath("//li[@title='Change parent organization']")).click();
		*/
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Change hierarchy");	
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		frameId = pegaDriver.getActiveFrameId(false);
		frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
	    return Org;
	}
	
	
	@Override
	public Organizations setNewOwner(String owner) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//a[@title='Switch to edit mode']")).click();
		
		String frameId= pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
	
		
		/*pegaDriver.waitForDocStateReady(1);
		frameId = pegaDriver.getActiveFrameId(false);
		frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		pegaDriver.findElement(By.id("crmSearchOwner")).sendKeys(selectAll);
		pegaDriver.findElement(By.id("crmSearchOwner")).sendKeys(owner);
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement(By.id("crmSearchOwner")).sendKeys(Keys.DOWN);
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement(By.id("crmSearchOwner")).sendKeys(Keys.DOWN);
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement(By.id("crmSearchOwner")).sendKeys(Keys.ENTER);
		pegaDriver.waitForDocStateReady(2);*/
		PegaUtil.autoComplete(pegaDriver, "crmSearchOwner",owner);
		
		pegaDriver.findElement(By.id("ChangeReason")).sendKeys("Change Owner Flow");
		pegaDriver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		return Org;		
	}
	
	
	@Override
	public Organizations setHierarchy(String newParentOrg)
	{
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
	
		if(pegaDriver.findElement(By.xpath("//a[@title='Switch to edit mode']")).isDisplayed())	
		pegaDriver.findElement(By.xpath("//a[@title='Switch to edit mode']")).click();
		/*pegaDriver.waitForDocStateReady(1);
		frameId = pegaDriver.getActiveFrameId(false);
		frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		

		
		pegaDriver.findElement(By.id("crmSearchTerm")).sendKeys(newParentOrg);
		pegaDriver.waitForDocStateReady(1);
		/*pegaDriver.findElement(By.id("crmSearchTerm")).sendKeys(selectAll);
		pegaDriver.findElement(By.id("crmSearchTerm")).sendKeys(newParentOrg);
		pegaDriver.waitForDocStateReady(1);
		
		pegaDriver.findElement(By.id("crmSearchTerm")).sendKeys(Keys.DOWN);
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement(By.id("crmSearchTerm")).sendKeys(Keys.DOWN);
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement(By.id("crmSearchTerm")).sendKeys(Keys.ENTER);*/
		PegaUtil.autoComplete(pegaDriver, "crmSearchTerm", newParentOrg);
		pegaDriver.waitForDocStateReady(2);		
		pegaDriver.findElement(By.xpath("//button[text()='Submit']")).click();
		return Org;	
	}
	

	@Override
	public void setName(String name)   {
		
		pegaDriver.findElement(By.id("Name")).clear();
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		pegaDriver.findElement(By.id("Name")).sendKeys(name);
		pegaDriver.waitForDocStateReady(5);
		
	}

	@Override
	public void setTerritory(String territory) 
	{
		
		/*pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//a[contains(@name,'TerritoryID')")).click();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.id(ORG_TERRIORTY_ID)).clear();
		pegaDriver.getActiveFrameId(true);*/
		PegaUtil.autoComplete(pegaDriver, ORG_TERRIORTY_ID, territory);	
	}

	@Override
	public Organizations OrgList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Organizations navigateOrganization() {
		return null;
	}

	@Override
	public Boolean verifyOrgNewHarness() {
		
		String frameId = pegaDriver.getActiveFrameId(false);
		pegaDriver.switchTo().frame(frameId);
		return pegaDriver.verifyElement(By.xpath("//div[text()='Organization']"));
	}


	@Override
	public void setWebsite(String name) {
		
		pegaDriver.getActiveFrameId(true);
		PegaWebElement wb;
		wb= pegaDriver.findElement(By.id("Website"));
		wb.clear();
		wb.sendKeys(name);		
	}
	
	@Override
	public void setIndustry(String industry) {
		
		pegaDriver.findSelectBox(By.id("Industry")).selectByValue(industry);
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		
		//
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		PegaWebElement wb;
		pegaDriver.getActiveFrameId(true);
		wb= pegaDriver.findElement(By.id("PhoneNumber"));
		pegaDriver.waitForDocStateReady(5);
		wb.clear();
		wb.sendKeys(phoneNumber);
	}


	@Override
	public void setShortName(String shortName) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		pegaDriver.findElement(By.id("ShortName")).clear();	
		PegaWebElement wb;
		wb = pegaDriver.findElement(By.id("ShortName"));
		wb.sendKeys(shortName);
	}


	@Override
	public void setTickerSymbol(String ticker) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		pegaDriver.findElement(By.id("Ticker")).clear();
		PegaWebElement wb;
		wb= pegaDriver.findElement(By.id("Ticker"));
		wb.sendKeys(ticker); 
	}


	@Override
	public void setEmployees(String employee) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		pegaDriver.findElement(By.id("EmployeeCount")).clear();
		pegaDriver.findElement(By.id("EmployeeCount")).sendKeys(employee);
	}


	@Override
	public void setRevenue(String revenue) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		pegaDriver.findElement(By.id("Revenue")).clear();
		pegaDriver.findElement(By.id("Revenue")).sendKeys(revenue);
	}


	@Override
	public void setTarget(Boolean target) {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		if (target)
			pegaDriver.findElement(By.xpath("//*[@data-test-id='2014120404484200106347']")).click();
	}


	@Override
	public void setParentOrganization(String parentOrg) {
		
		pegaDriver.getActiveFrameId(true);
		PegaUtil.autoComplete(pegaDriver, ParentOrg, parentOrg);
		
		/*String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		pegaDriver.findElement(By.id(ParentOrg)).sendKeys(parentOrg);
		pegaDriver.findElement(By.id(ParentOrg)).clear();
		
		frameId = pegaDriver.getActiveFrameId(false);
		frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		pegaDriver.findElement(By.id(ParentOrg)).sendKeys(parentOrg);

		pegaDriver.findElement(By.id(ParentOrg)).sendKeys(Keys.ARROW_DOWN);
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.findElement(By.id(ParentOrg)).sendKeys(Keys.ARROW_DOWN);
		pegaDriver.findElement(By.id(ParentOrg)).sendKeys(Keys.ENTER); */
	}


	@Override
	public void setDescription(String description) {
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		pegaDriver.findElement(By.id("pyDescription")).clear();
		pegaDriver.findElement(By.id("pyDescription")).sendKeys(description);		
	}


	
	@Override
	public void setDomains(String[] domains) {
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		//pegaDriver.findElement(By.xpath("//a[text()='Add domain']")).click();
		int domainCount;
		domainCount = domains.length;
		System.out.println("Domain Count is ---"+domainCount);
		//pegaDriver.findElement(By.xpath("//a[text()='Add domain']")).click();
		
		
				
		for (int i = 1; i<=domainCount;i++) {
			frameId = pegaDriver.getActiveFrameId(false);
			pegaDriver.switchTo().frame(frameId);
			Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
			
			wizard.findElement(By.xpath("//a[text()='Add domain']")).scrollIntoView();
			//pegaDriver.findElement(By.xpath(SUBMIT_XPATH)).scrollIntoView();
			//wizard.findElement(By.xpath(CREATE_XPATH)).click();
			
			wizard.findElement(By.xpath("//a[text()='Add domain']")).click();
			
			frameId = pegaDriver.getActiveFrameId(false);
			pegaDriver.switchTo().frame(frameId);
			pegaDriver.findElement(By.id("Domain"+i)).clear();
			pegaDriver.findElement(By.id("Domain"+i)).sendKeys(domains[i-1]);
		}
	}
	
	
	public void submit()
	{
		/*String frameId = pegaDriver.getActiveFrameId(false);
		//PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);*/
		pegaDriver.getActiveFrameId(true);
		
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		if(wizard.verifyElement(By.xpath("//button[@title='Create this item']")))
		{
			wizard.findElement(By.xpath("//button[@title='Create this item']")).scrollIntoView();
			wizard.findElement(By.xpath("//button[@title='Create this item']")).click();
		}
		else
		{
			wizard.findElement(By.xpath("//button[@title='Complete this assignment']")).scrollIntoView();
			wizard.findElement(By.xpath("//button[@title='Complete this assignment']")).click();
		}
			
		//pegaDriver.findElement(By.xpath(SUBMIT_XPATH)).scrollIntoView();
		/*wizard.findElement(By.xpath("//button[@title='Create this item']"))
		
		if(pegaDriver.verifyElement(By.xpath("//button[@title='Create this item']")))
		pegaDriver.findElement(By.xpath("//button[@title='Create this item']")).click();
		if(pegaDriver.verifyElement(By.xpath("//button[@title='Complete this assignment']")))
			pegaDriver.findElement(By.xpath("//button[@title='Complete this assignment']")).click();	
		//pegaDriver.findElement(By.xpath(PegaUtil.getStrongButtonXPath("Create"))).click();
		*/
		pegaDriver.getActiveFrameId(true);
	}

	
	public void setAddress(){
		PegaUtil.setAddress(pegaDriver);
		
	}
	
	

	@Override
	public void setAddress(String type, boolean primary) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@Override
	public String getName() {
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		//"//span[@class='workarea_header_titles']"
		return (new String(Org.findElement(By.xpath("//span[@class='field-caption dataLabelForRead']/span[text()='Name']/following::div/span")).getAttribute("text")).trim()); 
	}


	@Override
	public String getTerritory() {
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Territory']/following-sibling::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	
		
		
	}
	
	
	@Override
	public String getWebsite() {
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Website']/following-sibling::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	}


	@Override
	public String getIndustry() {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Industry']/following-sibling::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	
	}


	@Override
	public String getPhoneNumber() {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Phone number']/following-sibling::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	
	}


	@Override
	public String getShortName() {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Short name']/following-sibling::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	
	}


	@Override
	public String getTickerSymbol() {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Ticker symbol']/following-sibling::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	
	}


	@Override
	public String getEmployees() {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Employees']/following-sibling::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	
	}


	@Override
	public String getRevenue() {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
				 
		return (((new String(Org.findElement(By.xpath("//span[text()='Revenue']/following-sibling::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()).replaceAll(",","")));
	}


	@Override
	public String getTarget() {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		
		return (new String(Org.findElement(By.xpath("//span[text()='Target']/following-sibling::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	
	}


	@Override
	public String getParentOrganization() {
		String ParentOrg_xpath="//a[contains(@name,'ShowParentOrganization')]";
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		Org.verifyElement(By.xpath("//a[text()='Show Organization Hierarchy']"));
		
		//return (Org.findElement(By.xpath("//a[@data-test-id='20150622013402096797241']"))).getText();		
		
		return (Org.findElement(By.xpath(ParentOrg_xpath))).getText();
		
	}


	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String[] getDomains() {
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		PegaWebElement table =  pegaDriver.findElement(By.xpath("//table[@pl_prop_class='PegaCRM-Embed-Domain']"));
		String Domains[] = {" "," "};
		return  Domains;
	
	}


	@Override
	public String[] getAddress(String type) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean verifyTwitterIcon() {
		
		pegaDriver.getActiveFrameId(true);
		
		return pegaDriver.verifyElement(By.xpath("//i[@title='Twitter']"));
	}


	@Override
	public boolean verifyFacebookIcon() {
		
		pegaDriver.switchTo().defaultContent();
		String frameId = pegaDriver.getActiveFrameId(false);
		pegaDriver.switchTo().frame(frameId);
		
		return pegaDriver.verifyElement(By.xpath("//i[@title='Facebook']"));
		
	}


	@Override
	public boolean verifyGoogleMapIcon() {

		pegaDriver.switchTo().defaultContent();
		String frameId = pegaDriver.getActiveFrameId(false);
		pegaDriver.switchTo().frame(frameId);
		
		return pegaDriver.verifyElement(By.xpath("//i[@title='Google Map']"));
	}


	@Override
	public boolean verifyOrgNews() {
		
		pegaDriver.switchTo().defaultContent();
		String frameId = pegaDriver.getActiveFrameId(false);
		pegaDriver.switchTo().frame(frameId);
		
		return pegaDriver.verifyElement(By.xpath("//div[@data-node-id='crmNewsFeeds']//div[text()='Org news']"));
		
	}


	@Override
	public ArrayList<String> verifySubTabs() {
		
		pegaDriver.switchTo().defaultContent();
		String frameId = pegaDriver.getActiveFrameId(false);
		pegaDriver.switchTo().frame(frameId);
		
		ArrayList<String> s= new ArrayList<String>();
		List<WebElement> wb=pegaDriver.findElements(By.xpath(ORG_SUBTABS_XPATH));
		
		for(WebElement w:wb)
		{
			String s1=w.getText();
			s.add(s1);
		}
		System.out.println(s.size());
		return s;
	}


	@Override
	public boolean checkMode(String str) {
		
		pegaDriver.switchTo().defaultContent();
		String frameId = pegaDriver.getActiveFrameId(false);
		pegaDriver.switchTo().frame(frameId);
		
		//pegaDriver.findElement(By.xpath("//span[text()='Edit']")).getAttribute("text");
		return str.equals(pegaDriver.findElement(By.xpath("//span[text()='"+str+"']")).getAttribute("text"));
		
	}


	@Override
	public void changeTerritory(String newTerritory) {
		
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.findElement(By.xpath("//a[@title='Switch to edit mode']")).click();
		setTerritory(newTerritory);
			
	}


	@Override
	public String getOwner() {
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Organizations Org = new PegaOrganization(frameElmt, frameId);
		Org._setEnvironment(testEnv, frameId);
		Org.verifyElement(By.xpath("//a[text()='Show Organization Hierarchy']"));
		return (new String(Org.findElement(By.xpath("//span[text()='Owner']/following-sibling::div[@class='field-item dataValueRead']")).getAttribute("text")).trim()); 
	}
	
	
	
	@Override
	public Tasks addTask() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		
		pegaDriver.findElement(By.xpath("//div[@string_type='field']//button[text()='Actions']")).click();
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		pegaDriver.findElement(By.xpath("//li[@role='presentation']//span[text()='Add task']")).click();
				
		frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Tasks tasksDetails = new PegaTasks(framElmt, frameId);
		tasksDetails._setEnvironment(testEnv, frameId);
		return tasksDetails;	
	}


	@Override
	public boolean validateOrgTask(String orgTaskSubject, String orgTaskStatus, String DueDate,String OrgTaskAssignedTo, String orgTaskPriority) {
		
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		wizard.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]/tbody/tr[contains(@class,'Row')]")).scrollIntoView();
		
		List<WebElement> OrgTasks;
		OrgTasks = pegaDriver.findElements(By.xpath("//table[contains(@pl_prop,'Tasks')]/tbody/tr[contains(@class,'Row')]"));
		int rows = OrgTasks.size();
		System.out.println("Task List size is" + rows);
		WebElement RowData;
		
		//pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]")).scrollIntoView();
		
		for (int i = 1;i<=rows;i++)
			{
				RowData = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i)+"']"));
				System.out.println("Expected  org Task Due date value is "+ DueDate);
				System.out.println("Actual org Task  Due date value is " +pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Due date']//span")).getAttribute("text").trim());
				
				
				if(orgTaskSubject.equals(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i)+"']//a[contains(@name,'Tasks')]")).getAttribute("text").trim()))
				{
					String Taskname=pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i)+"']//a[contains(@name,'Tasks')]")).getAttribute("text");
					System.out.println("code passed upto tasks name");
					String ActualTaskStatus=pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Progress']//div")).getAttribute("text");
					System.out.println("Actual status from screen scrapping should be empty" + ActualTaskStatus);
					System.out.println("Expected Task Status" + orgTaskStatus);
					String ActualDueDate=pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Due date']//span")).getAttribute("text");
					System.out.println("Actual value of  Due date" +ActualDueDate);
					System.out.println("Expected  value  of Due date" +DueDate);
					String ActualAssignedTo=pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Assigned to']//span")).getAttribute("text");
					String ActualTaskPriority=pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Priority']//span")).getAttribute("text");
					System.out.println("Actual value of AssignedTo"+ ActualAssignedTo);
					System.out.println("Actual value of Priority"+ ActualTaskPriority);
					System.out.println("Expected value of AssignedTo"+ OrgTaskAssignedTo);
					System.out.println("Expected value of Priority"+ orgTaskPriority);
					if((pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Progress']//div")).getAttribute("text").trim().contains(orgTaskStatus)) &&
					//pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Due date']//span")).getAttribute("text").trim().contains(DueDate) && 
					pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Assigned to']//span")).getAttribute("text").trim().contains(OrgTaskAssignedTo) &&
					pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Tasks')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Priority']//span")).getAttribute("text").trim().contains(orgTaskPriority))
					{	

						System.out.println("**********conditions are met***************entered if and if and this retruns true");

						
						
						System.out.println(Taskname);
						return true;
					}
					
					}
			}
		return false;
	}


	@Override
	public void navigeToOrgTab(String tabName) {
		
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		wizard.findElement(By.xpath("//div[@class='header']//h2[contains(text(),'"+tabName+"')]")).scrollIntoView();
		
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath("//div[@class='header']//h2[contains(text(),'"+tabName+"')]")).click();
	}

	
	@Override
	public Accounts AddAccount() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		
		pegaDriver.findElement(By.xpath("//div[@string_type='field']//button[text()='Actions']")).click();
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		
		pegaDriver.findElement(By.xpath("//li[@role='presentation']//span[text()='Add account']")).click();
				
		frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Accounts AccountNewHarnessDetails = new PegaAccounts(framElmt, frameId);
		AccountNewHarnessDetails._setEnvironment(testEnv, frameId);
		return AccountNewHarnessDetails;	
		
	}


	@Override
	public boolean validateOrgAccounts(String AccountName, String AccountOwner, String AccountIndustry, 
									   String AccOpportunities, String AccountTotAmount, String AccountStatus) {

		
		//validate the expected account values 
		System.out.println("Expected Values are");
		System.out.println(AccountName + "****   "+ AccountOwner+" ****"+AccountIndustry +"******"+AccOpportunities +"******" +AccountTotAmount +"*******"+AccountStatus);
	  //  Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		//wizard.findElement(By.xpath("//span[@data-test-id='20150106035042083712546']")).scrollIntoView();
	    // PegaUtil.clickRefresh(pegaDriver,"Accounts");
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		
		List<WebElement> OrgAccounts;
		OrgAccounts = pegaDriver.findElements(By.xpath("//table[contains(@pl_prop,'Accounts')]/tbody/tr[contains(@class,'Row')]"));
		int rows = OrgAccounts.size();
		WebElement RowData;
		System.out.println( "accounts list count is   " + rows);
		
		for (int i = 1;i<=rows;i++)
			{	
	pegaDriver.getActiveFrameId(true);
	String ActualAccountname=pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='"+(i)+"']//a[contains(@name,'Accounts')]")).getAttribute("text");
	String Actualamount=pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='"+i+"' and contains(@id,'InOrg')]//td[@data-attribute-name='Total amount']")).getAttribute("text");
	String Actualowner= pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='"+i+"' and contains(@id,'InOrg')]//td[@data-attribute-name='Owner']")).getAttribute("text");
	String Actualindustry=pegaDriver.findElement(By.xpath("//table[@id='bodyTbl_right']//tr[@pl_index='"+i+"' and contains(@id,'InOrg')]//td[@headers='a3']")).getAttribute("text");
	String ActualOppno=pegaDriver.findElement(By.xpath("//table[@id='bodyTbl_right']//tr[@pl_index='"+i+"' and contains(@id,'InOrg')]//td[@data-attribute-name='Opportunities']")).getAttribute("text");
	String ActualStatus=pegaDriver.findElement(By.xpath("//table[@id='bodyTbl_right']//tr[@pl_index='"+i+"' and contains(@id,'InOrg')]//td[@headers='a6']")).getAttribute("text");
				
			
	System.out.println("Actual Values in row number "+ i + "are");
	System.out.println(ActualAccountname + "****"+ Actualowner+" ****"+Actualindustry +"******"+ActualOppno+"******" +Actualamount +"*******"+ActualStatus);
			
				if(AccountName.equals(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='"+(i)+"']//a[contains(@name,'Accounts')]")).getAttribute("text").trim()))
				
			
					{
					if(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='"+i+"' and contains(@id,'InOrg')]//td[@data-attribute-name='Owner']")).getAttribute("text").trim().contains(AccountOwner) &&
					   pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='"+i+"' and contains(@id,'InOrg')]//td[@headers='a3']")).getAttribute("text").trim().contains(AccountIndustry) && 
					   pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='"+i+"' and contains(@id,'InOrg')]//td[@data-attribute-name='Opportunities']")).getAttribute("text").trim().contains(AccOpportunities) &&
					   pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='"+i+"' and contains(@id,'InOrg')]//td[@data-attribute-name='Total amount']")).getAttribute("text").trim().contains(AccountTotAmount) &&
					   pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'Accounts')]//tr[@pl_index='"+i+"' and contains(@id,'InOrg')]//td[@headers='a6']")).getAttribute("text").trim().contains(AccountStatus))
					{
						System.out.println("*************************entered if and if");
						return true;
					}
					
					}
			}
		return false;
		
	
	}


	@Override
	public Activity addActivity() {
	
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Add activity");
		
		//pegaDriver.findElement(By.xpath("//div[@string_type='field']//button[text()='Actions ']")).click();
		
		//String frameId = pegaDriver.getActiveFrameId(false);
		//PegaWebElement frameElmt = pegaDriver.findElement(By.id(frameId));
		//pegaDriver.switchTo().frame(frameId);
		
		//pegaDriver.findElement(By.xpath("//li[@role='presentation']//span[text()='Add activity']")).click();
				
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Activity ActivityDetails = new PegaActivity(framElmt, frameId);
		ActivityDetails._setEnvironment(testEnv, frameId);
		return ActivityDetails;
		
	}


	@Override
	public boolean validateOrgActivities(String Subject,
			String CommunicationType, String actDate, String CompletedBy,
			String RelatedTo, String RelatedType) {
		
		
		pegaDriver.getActiveFrameId(true);
		
		List<WebElement> OrgActivities;
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
	    wizard.findElement(By.xpath("//table[contains(@pl_prop,'ActivitiesList')]//tr[contains(@class,'Row')]")).scrollIntoView();
		OrgActivities = pegaDriver.findElements(By.xpath("//table[contains(@pl_prop,'ActivitiesList')]//tr[contains(@class,'Row')]"));
		int actrows = OrgActivities.size();
		System.out.println("Activity List count is " + actrows);
		WebElement RowData;
		
		for (int i = 1;i<actrows;i++)
			{
			
			System.out.println("Expected Values are " +Subject + CommunicationType + actDate + CompletedBy + RelatedTo + RelatedType );
				RowData = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"+(i)+"']"));
				if(Subject.equals(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"+(i)+"']//a[@title='Click to Open the Related Task']")).getAttribute("text").trim()))
				{  
					System.out.println("entered 1st IF");
					System.out.println("Actual Values are");
					System.out.println(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Communication type']//div")).getAttribute("text"));
					System.out.println(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Date']//span")).getAttribute("text"));
					System.out.println(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Completed by']//span")).getAttribute("text"));
					System.out.println(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"+(i)+"']//td[@headers='a5']//span//a")).getAttribute("text"));
					System.out.println(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"+(i)+"']//td[@headers='a6']//span")).getAttribute("text"));
					
					if(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Communication type']//div")).getAttribute("text").trim().contains(CommunicationType) &&
					pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Date']//span")).getAttribute("text").trim().contains(actDate) && 
					pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"+(i)+"']//td[@data-attribute-name='Completed by']//span")).getAttribute("text").trim().contains(CompletedBy) &&
					pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"+(i)+"']//td[@headers='a5']//span//a")).getAttribute("text").trim().contains(RelatedTo) &&
					pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'OrgRelatedActivities')]//tr[@pl_index='"+(i)+"']//td[@headers='a5']//span")).getAttribute("text").trim().contains(RelatedType))
						System.out.println("entered 2nd if");
						return true;
				
					
					}
			}
		return false;
		
	}

	@Override
	public Relationship addContact() {
		
		pegaDriver.switchTo().defaultContent();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.waitForDocStateReady(2);
		PegaUtil.dropdown(pegaDriver, PegaUtil.ACTION_BUTTON_XPATH, "Add contact");
				
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Relationship relationShip= new PegaRelationship(framElmt, frameId);
		relationShip._setEnvironment(testEnv, frameId);
		return relationShip;
	}


	@Override
	public boolean validateOrgContacts(String ContactName,
			String RelationshipType, String RelationshipDescription,
			String StartDate, String EndDate) {
		
		
		
		pegaDriver.getActiveFrameId(true);
		
		System.out.println("Expected Values are" + ContactName + RelationshipType+RelationshipDescription+StartDate+EndDate);
		List<WebElement> OrgContacts;
		OrgContacts= pegaDriver.findElements(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]/tbody/tr[contains(@class,'Row')]"));
		int rows = OrgContacts.size();
		System.out.println("org contact row" + rows );
		
		WebElement RowData;
		System.out.println("Started for loop***********");
		
		for (int i = 0;i<rows;i++)
			{
				RowData = pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"+(i+1)+"']"));
				if(ContactName.equals(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//a[contains(text(),'"+ContactName+"')]")).getText()))
					
				{  String acontactname=pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//a[contains(text(),'"+ContactName+"')]")).getText();
				
					System.out.println(" entered if " + i + "time" );
					
					String ActualRelationshiptype=pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a2']//div")).getAttribute("text");
					String  rdesc=pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a3']//div")).getAttribute("text");
					String startdate=pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a4']//div")).getAttribute("text");
					String Enddate=pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a5']//div")).getAttribute("text");
					System.out.println("*********** print values**************");
					System.out.println(acontactname + ActualRelationshiptype + rdesc + startdate +Enddate);
					if(pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a2']//div")).getAttribute("text").trim().contains(RelationshipType) &&
					pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a3']//div")).getAttribute("text").trim().contains(RelationshipDescription))  
					//pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a4']//div")).getAttribute("text").trim().contains(StartDate) &&
					//pegaDriver.findElement(By.xpath("//table[contains(@pl_prop,'ContactsInOrg')]//tr[@pl_index='"+(i+1)+"']//td[@headers='a5']//div")).getAttribute("text").trim().contains(EndDate))
					return true;
					
					}
			}
		return false;
		
	}	
	@Override
	public void getOpptySubTab() {
		PegaUtil.getSubTab(pegaDriver, "Opportunities");
		
	}																																																   
	@Override
	public List<String> getOpptyValues(String opptyName) {
		//pegaDriver.findElement(By.xpath(PegaUtil.REFRESH_XPATH)).scrollIntoView();
		//pegaDriver.findElement(By.xpath(PegaUtil.REFRESH_XPATH)).click();
		
	Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		wizard.findElement(By.xpath(ORG_OPPTY_ROW_IDENTIFIER_XPATH)).scrollIntoView();
		//wizard.findElement(By.xpath(PegaUtil.REFRESH_XPATH)).click();
		
		return(PegaUtil.getRowValues(pegaDriver, ORG_OPPTY_ROW_IDENTIFIER_XPATH, opptyName));
		
	}

	@Override
	public void getContactSubTab() {
		PegaUtil.getSubTab(pegaDriver, "Contacts");
		//PegaUtil.clickRefresh(pegaDriver,"contact");
	}
	
	@Override
	public void refresh() {
		PegaUtil.refresh(pegaDriver);
	}
 
	@Override
	public void ClickToggletoConList() {
		
		pegaDriver.waitForDocStateReady();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(listviewtoggle_xpath)).click();		
		
	}

	@Override
	public void getLeadSubTab() {
		
		PegaUtil.getSubTab(pegaDriver, "Leads");
		PegaUtil.clickRefresh(pegaDriver,"leads");
		
	}

	@Override
	public List<String> getLeadRowValues(String companyName) {
		PegaUtil.clickRefresh(pegaDriver,"leads");
		
		return (PegaUtil.getRowValues(pegaDriver, LEAD_ROWS_XPATH, companyName));
	}		  
}