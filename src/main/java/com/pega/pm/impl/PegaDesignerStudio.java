package com.pega.pm.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.pm.DesignerStudio;
import com.pega.pm.PMPortal;
import com.pega.pm.explorer.RecordsExplorer;
import com.pega.pm.impl.explorer.PegaRecordsExplorer;

public class PegaDesignerStudio extends PegaPMPortal implements DesignerStudio {
	private RecordsExplorer recordsExplorer = null;

	public PegaDesignerStudio(TestEnvironment testEnv) {
		super(testEnv);
	}

	public PMPortal launchPegaMarketingPortal() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("Developer");
		pegaDriver.handleWaits().waitForElementVisibility(LAUNCH_PORTAL_LINK);
		pegaDriver.handleWaits().waitForElementClickable(LAUNCH_PORTAL_LINK);
		findElement(LAUNCH_PORTAL_LINK).click(false);
		findElement(PEGA_MARKETING_PORTAL).click();
		pegaDriver.handleWaits().sleep(5);
		testEnv.getBrowser().switchToWindow(2);
		pegaDriver.handleWaits().sleep(30);
		pegaDriver.handleWaits().waitTillTitleContains("Pega Marketing");
		return new PegaPMPortal(testEnv);
	}

	public void search(String searchtext) {

	}

	public void switchTab(Tabs tab) {
		pegaDriver.waitForDocStateReady(false);
		pegaDriver.switchTo().frame("Developer");
		pegaDriver.findElement(By.xpath("//div[@role='tab']//*[contains(text(),'" + tab.getId() + "')]")).click();
		pegaDriver.waitForDocStateReady();
	}

	public void switchToDeveloperFrame() {
		pegaDriver.switchTo().frame("Developer");
	}

	public RecordsExplorer getRecordsExplorer() {
		switchTab(Tabs.Records);
		String frameId = pegaDriver.getActiveFrameId(true);
		if (recordsExplorer == null) {
			recordsExplorer = new PegaRecordsExplorer(frameId, testEnv);
		}
		return recordsExplorer;
	}
}
