package salesautomation.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;						  
import com.pega.ri.WizardImpl;
import salesautomation.workobjects.Opportunity;
import salesautomation.workobjects.OpportunityList;

public class PegaOpportunityList extends WizardImpl implements OpportunityList {


	String OPP_BUSINESS_LIST_XPATH= PegaUtil.getSegmentedButtonXPath("Business");																		  
	String CREATE_OPP_BTN_XPATH = PegaUtil.getStrongButtonXPath("Create opportunity");
	String OPP_SEARCH_FIELD_ID = "FilterTermForOpportunity";
	String OPP_FILTER_PLACEHOLDER_XPATH = "//input[@placeholder='Filter opportunity']";
	String OPP_FILTERBUTTON_XPATH=PegaUtil.getButtonXpath("Filter");
	String OPP_NAME_XPATH="//table[@id='gridLayoutTable']//tr[@aria-rowindex='1']//a[1]";
	String OPP_ALL_BUTTON_XPATH=PegaUtil.getSegmentedButtonXPath("All");
	String OPP_INDIVIDUAL_BUTTON_XPATH=PegaUtil.getSegmentedButtonXPath("Individual");
	String OPP_BUSINESS_BUTTON_XPATH=PegaUtil.getSegmentedButtonXPath("Business");
	String OPP_EXPORT_BUTTON_XPATH="//i[contains(@class,'upload')]";
	String OPP_REFRESH_BUTTON_XPATH="//i[contains(@class,'refresh')]";
	String OPP_TABLE_HEADER_XPATH="//table[@id='bodyTbl_right']//th//div[@class='cellIn ']";
	String NO_OPPORTUNITIES_XPATH = "//tr[@id='Grid_NoResults']";
	String STAGE_VIEW_XPATH=PegaUtil.getSegmentedButtonXPath("Stage view");																	
	
	public PegaOpportunityList(WebElement elmt, String elmtId)
	{
		super(elmt, elmtId);
	}

	@Override
	public Opportunity createBusniessOpportunity() {
	
		PegaUtil.dropdown(pegaDriver, CREATE_OPP_BTN_XPATH, "Business");
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Opportunity opp = new PegaOpportunity(framElmt, frameId);
		opp._setEnvironment(testEnv, frameId);
		return opp;
	}

	@Override
	public Opportunity createIndividualOpportunity() {
		PegaUtil.dropdown(pegaDriver, CREATE_OPP_BTN_XPATH, "Individual");
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Opportunity opp = new PegaOpportunity(framElmt, frameId);
		opp._setEnvironment(testEnv, frameId);
		return opp;	
	}

	@Override
	public Opportunity navigateOpportunity(String opportunityName) 
	{
		
		pegaDriver.findElement(By.xpath(OPP_FILTER_PLACEHOLDER_XPATH)).sendKeys(opportunityName);
		pegaDriver.findElement(By.xpath(OPP_FILTERBUTTON_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(OPP_NAME_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Opportunity opp = new PegaOpportunity(framElmt, frameId);
		opp._setEnvironment(testEnv, frameId);
		return opp;	
	}

	@Override
	public boolean isCreateOpportunityButtonDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(CREATE_OPP_BTN_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isFilterTextBoxDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(OPP_FILTER_PLACEHOLDER_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isFilterButtonDisplayed() {
		pegaDriver.getActiveFrameId(true);
		boolean b= pegaDriver.findElement(By.xpath(OPP_FILTERBUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isAllOpptyButtonDisplayed() {
		
		boolean b= pegaDriver.findElement(By.xpath(OPP_ALL_BUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isIndividualButtonDisplayed() {
		
		boolean b= pegaDriver.findElement(By.xpath(OPP_INDIVIDUAL_BUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isBusinessButtonDisplayed() {
	
		boolean b= pegaDriver.findElement(By.xpath(OPP_BUSINESS_BUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isExportButtonDisplayed() {
		
		boolean b= pegaDriver.findElement(By.xpath(OPP_EXPORT_BUTTON_XPATH)).isVisible();
		return b;
	}

	@Override
	public boolean isRefreshButtonDisplayed() {
		
		boolean b= pegaDriver.findElement(By.xpath(OPP_REFRESH_BUTTON_XPATH)).isVisible();
		return b;
	}

	

	@Override
	public String getFilterPlaceHolder() {
		pegaDriver.getActiveFrameId(true);
		String b= pegaDriver.findElement(By.xpath(OPP_FILTER_PLACEHOLDER_XPATH)).getAttribute("placeholder");
		return b;
	}
	
	public ArrayList<String> getTableHeaders() {
		pegaDriver.getActiveFrameId(true);
		//System.out.println("In Table Headers");
		ArrayList<String> s= new ArrayList<String>();
		List<WebElement> wb=pegaDriver.findElements(By.xpath(OPP_TABLE_HEADER_XPATH));
		//System.out.println(wb.size());
		for(WebElement w:wb)
		{
			String s1=w.getText();
			System.out.println(s1);
			s.add(s1);
			//System.out.println(s.size());
		}
		return s;
	}
	
	@Override
	public Opportunity openFirstOpportunity() {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(OPP_NAME_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Opportunity opp = new PegaOpportunity(framElmt, frameId);
		opp._setEnvironment(testEnv, frameId);
		return opp;
	}

	@Override
	public boolean isOpportunityListEmpty() {
		pegaDriver.getActiveFrameId(true);
		try {
			findElement(By.xpath(NO_OPPORTUNITIES_XPATH));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
	@Override
	public void SwitchToBusinessTab() {
		pegaDriver.findElement(By.xpath(OPP_BUSINESS_LIST_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		
	}


	@Override
	public void dragAndDropToPropasal(String OppId) {
		String ID=OppId.toUpperCase();
		String frameId = pegaDriver.getActiveFrameId(false);
		Wizard wizard = pegaDriver.findWizard(frameId);
		PegaWebElement source = wizard.findElement(By.xpath("//div[contains(@data-inskey,'PEGACRM-WORK-SFA-OPPORTUNITY')]"));
		PegaWebElement target=wizard.findElement(By.xpath("//div[@id='Analysis']"));
		source.dragAndDrop(target);
	}
	
	@Override
	public void searchOpportunity(String opptyName) {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(OPP_FILTER_PLACEHOLDER_XPATH)).sendKeys(opptyName);
		pegaDriver.findElement(By.xpath(OPP_FILTERBUTTON_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
	}

	@Override
	public void switchToStageView() {
		//pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(STAGE_VIEW_XPATH)).click();
		
	}
	

}
