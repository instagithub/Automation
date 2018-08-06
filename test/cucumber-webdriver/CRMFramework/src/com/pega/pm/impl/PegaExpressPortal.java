package com.pega.pm;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.pm.pages.Channels;
import com.pega.pm.pages.ContextDictionary;
import com.pega.pm.pages.PegaChannels;
import com.pega.pm.pages.PegaContextDictionaryFrame;

public class PegaExpressPortal extends PegaPMPortal implements ExpressPortal {
	private PegaWebDriver pegaDriver = null;
	private TestEnvironment testEnv;
	private DesignerStudio designerStudio;
	public PegaExpressPortal(TestEnvironment testEnv) {
		super(testEnv);
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver();
	}

	public void openDataTypesExplorer() {
		pegaDriver.switchTo().defaultContent();
		findElement(DATATYPES_EXPLORER_BY).click();
		pegaDriver.waitForDocStateReady();

	}

	public void openUsersExplorer() {
		pegaDriver.switchTo().defaultContent();
		findElement(USERS_EXPLORER_BY).click();
		pegaDriver.waitForDocStateReady();

	}

	public void openSettingsExplorer() {
		pegaDriver.switchTo().defaultContent();
		findElement(SETTINGS_EXPLORER_BY).click(false);
		pegaDriver.waitForDocStateReady(false);

	}

	public DesignerStudio switchToDesignerStudio() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(SWITCH_TO_DESIGNER_STUDIO_MODE).click();
		pegaDriver.waitForDocStateReady(3);
		DesignerStudio designerStudio = new PegaDesignerStudio(testEnv);
		return designerStudio;
	}
	public void switchToDevStudio() {
		findElement(SWITCH_STUDIOS_ICON).click();
		findElement(DEV_STUDIO_LABEL).click();
	}

	public ContextDictionary openContextDictionary() {
		pegaDriver.switchTo().defaultContent();
		findElement(By.xpath(String.format(SETTINGS_SLIDER_MENU_ITEM_XPATH, "Context Dictionary"))).click();
		String activeFrameID = pegaDriver.getActiveFrameId(true);
		ContextDictionary contextDictionaryFrame = new PegaContextDictionaryFrame(null, activeFrameID);
		contextDictionaryFrame._setEnvironment(testEnv, activeFrameID);
		return contextDictionaryFrame;

	}

	public Channels openChannels() {
		pegaDriver.switchTo().defaultContent();
		findElement(By.xpath(String.format(SETTINGS_SLIDER_MENU_ITEM_XPATH, "Channels"))).click();
		String activeFrameID = pegaDriver.getActiveFrameId(true); 
		Channels channels = new PegaChannels(null, activeFrameID);
		channels._setEnvironment(testEnv, activeFrameID);
		return channels;
	}
	
	
	public DesignerStudio switchToDesignerStudioPortal() {
		return null;
	}

	

}
