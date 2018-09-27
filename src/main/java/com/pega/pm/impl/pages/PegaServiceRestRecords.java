package com.pega.pm.impl.pages;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.pm.pages.ServiceRestInstance;
import com.pega.pm.pages.ServiceRestRecords;


public class PegaServiceRestRecords extends PegaLandingPage implements ServiceRestRecords{

	public PegaServiceRestRecords(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
		
	}

	public ServiceRestInstance OpenInstance(String uriTemplate) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.switchTo().frame("Developer");
		pegaDriver.switchTo().frame("PegaGadget0Ifr");
		pegaDriver.findElement(By.xpath("//table[@id='bodyTbl_right']//tr//td[3]//*[contains(text(),'"+uriTemplate+" ')]")).click(false);
		//String frameId = pegaDriver.getActiveFrameId(true);
		String frameId ="PegaGadget1Ifr";
		ServiceRestInstance serviceRestInstance = new PegaServiceRestInstance(frameId, this.testEnv);
		return serviceRestInstance;
	}

}
