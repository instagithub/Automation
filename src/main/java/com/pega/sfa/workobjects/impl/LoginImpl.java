package com.pega.sfa.workobjects.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.ri.WizardImpl;
import com.pega.sfa.workobjects.Login;

public class LoginImpl extends WizardImpl implements Login {
	public String Operator;
	String OPR_LEFTNAV = "//span[@class='menu-item-title-wrap']";
	

	public LoginImpl(WebElement elmt) {
		super(elmt);
	}
	
	public LoginImpl(WebElement elmt, String elmtId){
		super(elmt, elmtId);
	}

	@Override
	public void validateOperator(String Title) {
		pegaDriver.switchTo().defaultContent();
		Assert.assertEquals(Title, pegaDriver.findElement(By.xpath("//img[@alt='Show User Profile']|//i[@data-test-id='px-opr-image-ctrl']|//i[contains(@class, 'icons avatar name')]")).getAttribute("title").trim());		
	}

	
	@Override
	public ArrayList<String> validateLeftNav() {
	
		ArrayList<String> s= new ArrayList<String>();
		List<WebElement> wb=pegaDriver.findElements(By.xpath(OPR_LEFTNAV));
		for(WebElement w:wb)
		{
			String s1=w.getText();
			s.add(s1);
		}
		System.out.println(s.size());
		return s;
		
		
	}
	@Override
	public void clickMyWork() {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(MYWORK_LISTPAGE)).click();
	}

	@Override
	public boolean verifyWorkListSection() {
		pegaDriver.getActiveFrameId(true);
		return (pegaDriver.verifyElement(By.xpath(WORK_LIST_XPATH)));
	}

	@Override
	public boolean verifyToDoList() {
		return (pegaDriver.verifyElement(By.xpath(TO_DO_LIST_XPATH)));
	}

	@Override
	public boolean verifySuggestedVisits() {
		return (pegaDriver.verifyElement(By.xpath(SUGGESTED_VISITS_XPATH)));
	}


}
