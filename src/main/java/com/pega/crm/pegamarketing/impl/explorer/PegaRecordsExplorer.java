package pegamarketing.impl.explorer;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import pegamarketing.explorer.RecordsExplorer;
import pegamarketing.impl.pages.PegaLandingPage;
import pegamarketing.impl.pages.PegaServiceRestRecords;
import pegamarketing.pages.LandingPage;


public class PegaRecordsExplorer implements RecordsExplorer{
	private PegaWebDriver pegaDriver = null;
	private TestEnvironment testEnv = null;
	
	public PegaRecordsExplorer(String frameId,TestEnvironment testEnv) {
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
			PegaWebElement category = pegaDriver.findElement(By.xpath(categXpath));
			pegaDriver.handleWaits().waitForElementClickable(By.xpath(categXpath));
			category.click();
		}
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("Developer");
		pegaDriver.handleWaits().waitForElementPresence(By.partialLinkText(path[path.length-1]));
		System.out.println("The xpath is " +path[path.length-1]);
		pegaDriver.findElement(By.partialLinkText(path[path.length-1])).click();
		pegaDriver.waitForDocStateReady();
		
		
	}
	private <T extends LandingPage> T createRightLandingPageObj(Class<T> type){
		T page = null;
		//String frameId = pegaDriver.getActiveFrameId(true);
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
		pegaDriver.switchTo().frame("Developer");
	}
}
