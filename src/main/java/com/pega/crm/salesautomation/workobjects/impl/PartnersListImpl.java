package salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;
import salesautomation.workobjects.Partners;
import salesautomation.workobjects.PartnersList;

public class PartnersListImpl extends WizardImpl implements PartnersList
{

	
	
	
	String CREATE_PTR_BTN_XPATH = "//button[text()='Create partner']";
	String PTR_SEARCH_FIELD_ID = "FilterTermForOrganization";
	String PTR_FILTER_PLACEHOLDER_XPATH = "//input[@placeholder='Filter partners']";
	String PTR_FILTERBUTTON_XPATH="//button[text()='Filter']";
	String PTR_NAME_XPATH="//table[@id='gridLayoutTable']//tr[@aria-rowindex='1']//a";
	String OPR_FILTER_ID="FilterTerm";
	String OPR_NAME_XPATH="//tr[contains(@id, 'OperatorAccessList')]/td[@data-attribute-name='Name']//span";
	String NO_PARTNERS_XPATH = "//div[text ='No partners']";
	
	
	
	public PartnersListImpl(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Partners createPartner() {
		findElement(By.xpath(CREATE_PTR_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Partners par = new PartnersImpl(framElmt, frameId);
		par._setEnvironment(testEnv, frameId);
		return par;	
	}

	@Override
	public Partners navigatePartner(String partnerName) {
		findElement(By.xpath(PTR_FILTER_PLACEHOLDER_XPATH)).sendKeys(partnerName);
		findElement(By.xpath(PTR_FILTERBUTTON_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		
		if(pegaDriver.verifyElement(By.xpath(PTR_NAME_XPATH)))
		findElement(By.xpath(PTR_NAME_XPATH)).click();
		else
		openFirstPartner();
		
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Partners ptr = new PartnersImpl(framElmt, frameId);
		ptr._setEnvironment(testEnv, frameId);
		return ptr;	
	}

	@Override
	public boolean searchOperator(String OperatorName) 
	{
		pegaDriver.getActiveFrameId(true);
		findElement(By.id(OPR_FILTER_ID)).sendKeys(UtilImpl.SelectAll);
		findElement(By.id(OPR_FILTER_ID)).sendKeys(OperatorName);
		findElement(By.xpath(PTR_FILTERBUTTON_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		String name=findElement(By.xpath(OPR_NAME_XPATH)).getText();
		if(name.equals(OperatorName))
		{
			return true;
		}
		else
			return false;
	}
	
	
	@Override
	public boolean isPartnerListEmpty() {
		pegaDriver.getActiveFrameId(true);
		if(verifyElement(By.xpath(NO_PARTNERS_XPATH)))
		return true;
		else
		return false;
	}

	@Override
	public Partners openFirstPartner() {
		
		pegaDriver.getActiveFrameId(true);
		findElement(By.xpath(PTR_FILTER_PLACEHOLDER_XPATH)).clear();
		findElement(By.xpath(PTR_FILTERBUTTON_XPATH)).click();
		findElement(By.xpath(PTR_NAME_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Partners ptr = new PartnersImpl(framElmt, frameId);
		ptr._setEnvironment(testEnv, frameId);
		return ptr;	
	}
	
	
}
