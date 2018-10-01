package salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.pega.ri.WizardImpl;
import salesautomation.workobjects.ClosePlans;

public class PegaClosePlans extends WizardImpl implements ClosePlans{

	String FILTERBY_ID="BaseFilterForLP";
	String APPLYBUTTON_XPATH=PegaUtil.getButtonXpath("Apply");
	String EXPORTBUTTON_XPATH=PegaUtil.getButtonXpath("Export");
	String CLOSEPLAN_OPPTY="//table[contains(@pl_prop_class,'Opportunity')]//tr[contains(@id,'1')]";
	String CLOSEPLAN_COMMETNS="//body[contains(@title,'This is a rich text')]";
	String ADDNEW_XPATH=PegaUtil.getStrongButtonXPath("Add new");
	public PegaClosePlans(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
	}

	@Override
	public boolean isFilterMenuDisplayed() {
		return pegaDriver.findElement(By.id(FILTERBY_ID)).isVisible();
	}

	@Override
	public boolean isApplyButtonDisplayed() {
		return pegaDriver.findElement(By.xpath(APPLYBUTTON_XPATH)).isVisible();
	}

	@Override
	public boolean isExportButtonDisplayed() {
		return pegaDriver.findElement(By.xpath(EXPORTBUTTON_XPATH)).isVisible();
	}

	@Override
	public void clickOppty() {
		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement(By.xpath(CLOSEPLAN_OPPTY)).click();
	}

	@Override
	public void enterClosePlans(String comments) {
		pegaDriver.getActiveFrameId(true);
		if(pegaDriver.verifyElement(By.xpath(ADDNEW_XPATH)))
			pegaDriver.findElement(By.xpath(ADDNEW_XPATH)).click();
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.getActiveFrameId(true);
		WebElement wb=pegaDriver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor')]")).getWebElement();
		pegaDriver.switchTo().frame(wb);
		pegaDriver.findElement(By.xpath(CLOSEPLAN_COMMETNS)).sendKeys(comments);
		
	}
	
	

}
