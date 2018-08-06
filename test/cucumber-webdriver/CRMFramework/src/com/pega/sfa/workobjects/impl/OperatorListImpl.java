package com.pega.sfa.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;
import com.pega.sfa.workobjects.Operator;
import com.pega.sfa.workobjects.OperatorList;
//import com.pega.sfa.workobjects.impl.OperatorImpl;
import com.pega.util.XPathUtil;


public class OperatorListImpl extends WizardImpl implements OperatorList {
	

String OPERATORS_TAB = new String("//span[text()='Operators']");

String OPR_FILTER_PLACEHOLDER = "//input[@placeholder='Filter operators']";

String CREATE_OPR_BTN_XPATH = "//button[@class='Strong pzhc pzbutton' and text()='Create operator']";
String OPR_SEARCH_FIELD = "FilterTerm";

String refreshButton = "//button[@class='pzhc pzbutton' and text()='Refresh']";
String filterButton = "//button[@class='pzhc pzbutton' and text()='Filter']";

// Operator LIst columns

/* Verify the columns on the Organization list page
By OPR_NAMECOLUMN = By.xpath("//table[@pl_prop_class='Data-Admin-Operator-ID']//th[@role='columnheader']//div[contains(text(),'Name')]";
String OPR_TYPECOLUMN = "//table[@pl_prop_class='Data-Admin-Operator-ID']//th[@role='columnheader']//div[contains(text(),'Operator type')]";
String OPR_PRIMARYTERRITORYCOLUMN = "//table[@pl_prop_class='Data-Admin-Operator-ID']//th[@role='columnheader']//div[contains(text(),'Primary territory')]";
String OPR_REPORTSTOCOLUMN = "//table[@pl_prop_class='Data-Admin-Operator-ID']//th[@role='columnheader']//div[contains(text(),'Reports to')]";
String OPR_ISACTIVECOLUMN = "//table[@pl_prop_class='Data-Admin-Operator-ID']//th[@role='columnheader']//div[contains(text(),'Is active')]";
String OPR_JOBTITLECOLUMN = "//table[@pl_prop_class='Data-Admin-Operator-ID']//th[@role='columnheader']//div[contains(text(),'Job title')]";
String NO_OPERATORS_XPATH = "//div[text()='No operators']";
String OPERATOR_NAME_XPATH = "//table[@id='gridLayoutTable']//tr[@pl_index='1']//td[@data-attribute-name='Name']//span";
*/


By OPR_NAMECOLUMN = By.xpath("//*[@data-test-id='201804100347110194172-th-0']//div[contains(text(),'Name')]");
By OPR_TYPECOLUMN = By.xpath("//*[@data-test-id='201804100347110194172-th-1']//div[contains(text(),'Operator type')]");
By OPR_PRIMARYTERRITORYCOLUMN = By.xpath("//*[@data-test-id='201804100347110194172-th-2']//div[contains(text(),'Primary territory')]");
By OPR_REPORTSTOCOLUMN = By.xpath("//*[@data-test-id='201804100347110194172-th-3']//div[contains(text(),'Reports to')]");
By OPR_ISACTIVECOLUMN = By.xpath("//*[@data-test-id='201804100347110194172-th-4']//div[contains(text(),'Is active')]");
By OPR_JOBTITLECOLUMN = By.xpath("//*[@data-test-id='201804100347110194172-th-5']//div[contains(text(),'Job title')]");
String NO_OPERATORS_XPATH = "//div[text()='No operators']";
String OPERATOR_NAME_XPATH = "//table[@id='gridLayoutTable']//tr[@aria-rowindex='1']//td[@data-attribute-name='Name']//span";


public OperatorListImpl(WebElement elmt) {
	super(elmt);
	// TODO Auto-generated constructor stub
}

public OperatorListImpl(PegaWebElement framElmt, String frameId) {
	super(framElmt,frameId);
}

@Override
public Operator creasteOperator() {
	
	findElement(By.xpath(CREATE_OPR_BTN_XPATH)).click();
	pegaDriver.waitForDocStateReady(2);
	String frameId = pegaDriver.getActiveFrameId(false);
	PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
	pegaDriver.switchTo().frame(frameId);
	Operator org = new OperatorImpl(framElmt, frameId);
	org._setEnvironment(testEnv, frameId);
	return org;	
}

@Override
public OperatorList searchOperator(String oprName) {
	
	findElement(By.id(OPR_SEARCH_FIELD)).sendKeys(oprName);
	findElement(By.id(OPR_SEARCH_FIELD)).sendKeys(Keys.ENTER);
	pegaDriver.waitForDocStateReady(2);
	String frameId = pegaDriver.getActiveFrameId(false);
	PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
	pegaDriver.switchTo().frame(frameId);
	OperatorList oprList= new OperatorListImpl(framElmt, frameId);
	oprList._setEnvironment(testEnv, frameId);
	return oprList;
}

@Override
public Operator navigateOperator() {
	
	pegaDriver.waitForDocStateReady(2);
	String frameId = pegaDriver.getActiveFrameId(false);
	PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
	pegaDriver.switchTo().frame(frameId);
	Operator Opr = new OperatorImpl(framElmt, frameId);
	Opr._setEnvironment(testEnv, frameId);
	return Opr;
}

@Override
public boolean isOperatorListEmpty() {
	pegaDriver.getActiveFrameId(true);
	try {
		findElement(By.xpath(NO_OPERATORS_XPATH));
	} catch (Exception ex) {
		return false;
	}
	return true;
}

@Override
public Operator openFirstOperator() {
	pegaDriver.getActiveFrameId(true);
	findElement(By.xpath(OPERATOR_NAME_XPATH)).click();
	pegaDriver.waitForDocStateReady(1);
	String frameId = pegaDriver.getActiveFrameId(false);
	PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
	pegaDriver.switchTo().frame(frameId);
	Operator operator = new OperatorImpl(framElmt, frameId);
	operator._setEnvironment(testEnv, frameId);
	return operator;
}
	@Override
	public boolean verifyOperatorListPage()
	{
	
		
		String frameId = pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		System.out.println("entered");
		
		//Assert.assertTrue(pegaDriver.verifyElement(By.xpath(CREATE_OPR_BTN_XPATH)));
		//Assert.assertTrue(pegaDriver.verifyElement(By.id(OPR_SEARCH_FIELD)));
		
		//Assert.assertTrue(pegaDriver.verifyElement(By.xpath(refreshButton)));
		//Assert.assertTrue(pegaDriver.verifyElement(By.xpath(filterButton)));
		
		if(pegaDriver.verifyElement(By.xpath(CREATE_OPR_BTN_XPATH)) && 
		   pegaDriver.verifyElement(By.id(OPR_SEARCH_FIELD)) &&
				pegaDriver.verifyElement(By.xpath(refreshButton)) &&
				pegaDriver.verifyElement(By.xpath(filterButton)) &&
				pegaDriver.verifyElement(OPR_NAMECOLUMN) &&
				pegaDriver.verifyElement(OPR_TYPECOLUMN) &&
				pegaDriver.verifyElement(OPR_PRIMARYTERRITORYCOLUMN) &&
				pegaDriver.verifyElement(OPR_REPORTSTOCOLUMN) &&
				pegaDriver.verifyElement(OPR_JOBTITLECOLUMN) &&
				pegaDriver.verifyElement(OPR_JOBTITLECOLUMN) &&
				pegaDriver.verifyElement(OPR_NAMECOLUMN)) 
		return true;
		else 
		return false;
			
		
		
	}

	@Override
	public boolean validateListPage() {
		pegaDriver.getActiveFrameId(true);
		return pegaDriver.verifyElement(By.xpath(OPR_FILTER_PLACEHOLDER));
		
		
	}

	@Override
	public boolean validateOprListPage() {
	
	if(!pegaDriver.verifyElement(By.xpath(OPR_FILTER_PLACEHOLDER)))
	{
		System.out.println("*************1");
		return false;
	}
		
	else if(!pegaDriver.verifyElement(By.xpath(CREATE_OPR_BTN_XPATH)))
	{
		System.out.println("*************2");
		return false;
	}
	else if(!pegaDriver.verifyElement(By.xpath(refreshButton)))
	{
		System.out.println("*************3");
		return false;
	}
	else if(!pegaDriver.verifyElement(By.xpath(filterButton)))
	{
		System.out.println("*************4");
		return false;
	}
	// operator List Columns
	else if(!pegaDriver.verifyElement(OPR_NAMECOLUMN))
	{
		System.out.println("*************5");
		return false;
	}
	else if(!pegaDriver.verifyElement(OPR_PRIMARYTERRITORYCOLUMN))
	{
		System.out.println("*************6");
		return false;
	}
	else if(!pegaDriver.verifyElement(OPR_REPORTSTOCOLUMN))
	{
		System.out.println("*************7");
		return false;
	}
	else if(!pegaDriver.verifyElement(OPR_JOBTITLECOLUMN))
	{
		System.out.println("*************8");
		return false;
	}
	else if(!pegaDriver.verifyElement(OPR_JOBTITLECOLUMN))
		return false;
	else if(!pegaDriver.verifyElement(OPR_NAMECOLUMN))
	{
		System.out.println("*************9");
		return false;
	}
	
	else return true;
	
	}

}
