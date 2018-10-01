package customerservice.interactions.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;
import customerservice.interactions.ResearchInteraction;
import customerservice.tiles.impl.PegaTopNav;

public class PegaResearchInteraction extends PegaInteractions implements ResearchInteraction{
	
	public String frameId = null;
	public Wizard newWizard = null;
	
	public PegaResearchInteraction(WebElement elmt, String frameId) {
		super(elmt, frameId);
		// TODO Auto-generated constructor stub
	}
	
	public PegaResearchInteraction(WebElement elmt) {
		super(elmt);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void launchUpdateContactProfile() {
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard  = pegaDriver.findWizard(frameId);
		PegaWebElement updateContactProfile = newWizard.findElement(By.linkText("Update Contact Profile"));
		updateContactProfile.doubleClick();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		
	}

	@Override
	public void updateContactProfile() {
		PegaWebElement occupation = newWizard.findElement(By.xpath(OCCUPATION_XPATH));
		occupation.sendKeys("HR");
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
		submitButton.click(false);
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		
	}


	
	@Override
	public String checkCaseStatus(String caseId) {
		
		PegaWebElement searchBox = findElement(By.xpath("//input[@id='pySearchText']"));
		searchBox.sendKeys(caseId);
		PegaWebElement searchIcon = findElement(By.xpath("//img[@title='Search for an Item ']"));
		searchIcon.sendKeys(Keys.ENTER);
		PegaWebElement status = findElement(By.xpath("//span[contains(text(),'Resolved')]"));
		String caseStatus = status.getText();
		return caseStatus;
	}
	
	@Override
	public void searchCaseStatus(String searchType, String value) {
		
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		
		DropDown selectType = pegaDriver.findSelectBox(By.xpath("//select[@name='$PpyDisplayHarness$pSelectedDataSource']"));
		selectType.selectByValue(searchType);
		
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.findElement(By.xpath("//input[@id='pySearchText']")).sendKeys(Keys.CLEAR);
		pegaDriver.findElement(By.xpath("//input[@id='pySearchText']")).sendKeys(value);
		pegaDriver.findElement(By.xpath("//i[@name='CPMSearch_pyDisplayHarness_3']")).click();
	}
	

	


}
