package com.pega.crm.pegamarketing.impl.explorer;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.explorer.RecordsExplorer;
import com.pega.crm.pegamarketing.impl.pages.PegaLandingPage;
import com.pega.crm.pegamarketing.impl.pages.PegaServiceRestRecords;
import com.pega.crm.pegamarketing.pages.LandingPage;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.page.TopDocumentImpl;


public class PegaRecordsExplorer extends TopDocumentImpl  implements RecordsExplorer{

private PegaWebDriver pegaDriver = null;
	private TestEnvironment testEnv = null;

	public PegaRecordsExplorer(String frameId,TestEnvironment testEnv) {
		super(testEnv);
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver();
	}
	public <T extends LandingPage> T openRecord(Class<T> t, String... path) {
		navigateTo(path);
		return createRightLandingPageObj(t);
	}
	public void navigateTo(String... path) {
		pegaDriver.switchTo().defaultContent();
		switchToDeveloperFrame();
		for(int i=0; i<path.length-1; i++)
		{
			String categXpath = "//div[@node_name='pzRulesExplorerTree']//table[@id='bodyTbl_gbl']//ul[.//span[contains(text(),'"+path[i]+"')]][contains(@class,'rowContent')]/li//a";
			PegaWebElement category = findElement(By.xpath(categXpath));
			pegaDriver.handleWaits().waitForElementClickable(By.xpath(categXpath));
			category.click();
		}
		pegaDriver.switchTo().defaultContent();
		findFrame("Developer");
		pegaDriver.handleWaits().waitForElementPresence(By.partialLinkText(path[path.length-1]));
		System.out.println("The xpath is " +path[path.length-1]);
		findElement(By.partialLinkText(path[path.length-1])).click();
		pegaDriver.waitForDocStateReady();
		
		
	}
	private <T extends LandingPage> T createRightLandingPageObj(Class<T> type){
		T page = null;
		String frameId="PegaGadget0Ifr";
		String className = type.getName();
		if(className.contains("ServiceRestRecord"))
		{
			page = type.cast(new PegaServiceRestRecords(frameId, testEnv));
		}	
		else
		{
			page = type.cast(new PegaLandingPage(frameId, testEnv));
		}
		return page;
	}
	public void switchToDeveloperFrame() {
		findFrame("Developer");
	}
}
