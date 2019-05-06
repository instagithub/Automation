package com.pega.crm.customerservice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.impl.PegaCSPortal;
import com.pega.crm.customerservice.impl.PegaSFAPortal;
import com.pega.crm.customerservice.interactions.ResearchInteraction;
import com.pega.crm.customerservice.interactions.impl.PegaResearchInteraction;
import com.pega.crm.customerservice.tiles.TopNav;
import com.pega.crm.pegamarketing.impl.PegaDesignerStudio;
import com.pega.crm.pegamarketing.impl.PegaExpressPortal;
import com.pega.crm.pegamarketing.impl.PegaPMPortal;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.page.Portal;
import com.pega.ri.Wizard;

/**
 * @author Chanu
 * @since 11 Dec 2013
 */
public class PegaBrowser extends com.pega.BrowserImpl {

	@SuppressWarnings("unused")
	public String frameId = null;
	public Wizard newWizard = null;
	private static final String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public static final String VERSION = "$Id: PegaBrowser.java 117333 2018-10-01 09:12:21Z SachinVellanki $";
	
	

	public static String CaseID = null;

	private TestEnvironment testEnv = null;
	String Txt_KMSearch_Id = "KMSearchText";
	String Btn_KMSearch_Xpath = "//i[@title='Search for Articles']";

	public PegaBrowser(TestEnvironment testEnv) {
		super(testEnv);
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver();

	}

	@Override
	public <T extends Portal> T getPortal(Class<T> type) {
		T portal = null;
		String className = type.getName();
		if (className.contains("CSPortal")) {
			portal = type.cast(new PegaCSPortal(testEnv));
		}
		/*if (className.contains("DesignerStudio")) {
			portal = type.cast(new DesignerStudioImpl(testEnv));
		}*/
		if (className.contains("SFAPortal")) {
			portal = type.cast(new PegaSFAPortal(testEnv));
		}
		if (className.contains("PMPortal")) {
			portal = type.cast(new PegaPMPortal(testEnv));
		} else if (className.contains("PegaExpressPortal")) {
			portal = type.cast(new PegaExpressPortal(testEnv));
		} else if (className.contains("DesignerStudio")) {
			portal = type.cast(new PegaDesignerStudio(testEnv));
		}
		return portal;
	}

	
}

