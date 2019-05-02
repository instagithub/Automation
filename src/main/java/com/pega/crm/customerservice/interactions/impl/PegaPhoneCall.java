package com.pega.crm.customerservice.interactions.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pega.TestEnvironment;
import com.pega.crm.customerservice.interactions.PhoneCall;
import com.pega.crm.customerservice.utils.CommonMethods;
import com.pega.framework.AutoComplete;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.ri.Wizard;

public class PegaPhoneCall extends PegaInteractions implements PhoneCall {

	public PegaPhoneCall(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
		commonMethods = new CommonMethods(pegaDriver);
	}


	public String frameId = null;
	public Wizard newWizard = null;
	public CommonMethods commonMethods = null;
	public static String timeStamp="";

	

	@Override
	public void searchByEmail(String emailId) {
		 pegaDriver.switchToActiveFrame();
		 frameId = pegaDriver.getActiveFrameId(false);
	     newWizard  = pegaDriver.findWizard(frameId);
	     PegaWebElement collapseIcon = newWizard.findElement(By.xpath("//div[@title='Disclose Advanced search']"));
         collapseIcon.click();
         PegaWebElement email = newWizard.findElement(By.id(SEARCH_EMAIL_ID));
         email.sendKeys(emailId);
         PegaWebElement search = newWizard.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
         search.click();  
		
	}
	
	public String getTomorrowDate(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		String newDate = format.format(cal.getTime());
		return newDate;
	}

	@Override
	public void scheduleActivity(String type, String account, String topic, String assign, String operator) {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
        newWizard  = pegaDriver.findWizard(frameId); 
		PegaWebElement activity = newWizard.findElement(By.xpath("//div[text()='Conference call']"));
		activity.click();
		PegaWebElement date = newWizard.findElement(By.id("StartDate"));
		date.sendKeys(getTomorrowDate());
		DropDown linkAccount = newWizard.findSelectBox(By.id("SelectedAccountNumber"));
		linkAccount.selectByValue(account);
		DropDown topicValue = newWizard.findSelectBox(By.id("Topic"));
		topicValue.selectByValue(topic);
		DropDown schedule = newWizard.findSelectBox(By.id("ScheduleFor"));
		schedule.selectByValue(assign);
		pegaDriver.waitForDocStateReady(1);
		DropDown opName = newWizard.findSelectBox(By.id("Operator"));
		opName.selectByValue(operator);
		DropDown otherPhone = newWizard.findSelectBox(By.id("TelephoneNumber"));
		otherPhone.selectByValue("Other");
		pegaDriver.waitForDocStateReady(1);
		PegaWebElement phnum = newWizard.findElement(By.xpath("//input[@id='OtherPhone']"));
		phnum.sendKeys("987654321");
						
		PegaWebElement submitButton = newWizard.findElement(By.xpath(SERVICECASE_SUBMIT_XPATH));
        submitButton.click(false);
        pegaDriver.waitForDocStateReady(2);
        
          		
        
	}

	
}
