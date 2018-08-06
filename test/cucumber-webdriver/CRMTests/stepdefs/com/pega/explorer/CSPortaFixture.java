package com.pega.explorer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.inject.Inject;
import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;

import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class CSPortaFixture {
	
	private PegaWebDriver pegaDriver;
	
	@Inject
	public CSPortaFixture(TestEnvironment testEnv){
		pegaDriver = testEnv.getPegaDriver();
	}
	
	
	@Then("^Verify Operator name$")
	public void verify_Operator_name() {
		pegaDriver.verifyElement(By.xpath("//div[@class='field-item dataValueWrite']/span/a[contains(@title,'CS CSR')]"));
	}
	
	@Then("^Verify Left Nav links$")
	public void verify_Left_Nav_links() throws Throwable {
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		pegaDriver.verifyElement(By.xpath("//a[@title='Dashboard']"));
		pegaDriver.verifyElement(By.xpath("//a[@title='My Reports']"));
		pegaDriver.verifyElement(By.xpath("//a[@title='Social']"));
		pegaDriver.verifyElement(By.xpath("//a[@title='Pulse']"));
	}
	
	
	@Then("^Verify all other widgets$")
	public void verify_all_other_widgets() throws Throwable {
		pegaDriver.verifyElement(By.xpath("//div[text()='Get Most Urgent']"));
			    
	}
	
	

}
