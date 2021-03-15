
package com.pe.workobjects.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pe.workobjects.JobApplication;
import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.impl.PegaWorkObject;

import org.testng.Assert;

@SuppressWarnings("unused")
public class JobApplicationImpl extends PegaWorkObject implements JobApplication {

	public JobApplicationImpl(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}

	@SuppressWarnings("unused")
	public boolean verifyCaseManager() {
		
		return(verifyElement(By.xpath("//*[text()='Summary for Pega Platform']")));
		
	}
	
	
	

	
}