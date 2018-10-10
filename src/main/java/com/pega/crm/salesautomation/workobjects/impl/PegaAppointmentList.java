package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.crm.salesautomation.workobjects.Appointment;
import com.pega.crm.salesautomation.workobjects.AppointmentList;
import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;

public class PegaAppointmentList extends WizardImpl implements AppointmentList {

	
	public PegaAppointmentList(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
	}
	
	public Appointment createAppointment() {
		findElement((CREATE_APP_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId= pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Appointment app =  new PegaAppointment(framElmt, frameId);
		app._setEnvironment(testEnv, frameId);
		return  app;
	}
	


@Override
public Appointment navigatToAppointment(String  appName) {
  // findElement(By.xpath(LISTVIEW)).click();
	findElement((FILTER_TEXT_XPATH)).sendKeys(appName);
	findElement((FILTER_BUTTON_XPATH)).click();
	pegaDriver.getActiveFrameId(true);
	findElement(By.xpath(APP_NAME_XPATH)).click();
	pegaDriver.waitForDocStateReady(1);
	String frameId= pegaDriver.getActiveFrameId(false);
	PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
	pegaDriver.switchTo().frame(frameId);
	Appointment app =  new PegaAppointment(framElmt, frameId);
	app._setEnvironment(testEnv, frameId);
	return  app;
}
	
}
