package com.pega.crm.pegamarketing.impl.pages;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.pages.ServiceRestInstance;
import com.pega.crm.pegamarketing.pages.ServiceRestRecords;


public class PegaServiceRestRecords extends PegaLandingPage implements ServiceRestRecords{

	public PegaServiceRestRecords(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
		
	}

	public ServiceRestInstance OpenInstance(String uriTemplate) {
		pegaDriver.switchTo().defaultContent();
		findFrame("Developer");
		findFrame("getActiveFrameId");
		findElement(By.xpath("//table[@id='bodyTbl_right']//tr//td[3]//*[contains(text(),'"+uriTemplate+" ')]")).click(false);
		String frameId ="PegaGadget1Ifr";
		ServiceRestInstance serviceRestInstance = new PegaServiceRestInstance(frameId, this.testEnv);
		return serviceRestInstance;
	}

}
