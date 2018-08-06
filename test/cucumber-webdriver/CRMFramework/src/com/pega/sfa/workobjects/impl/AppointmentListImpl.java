package com.pega.sfa.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.ri.WizardImpl;
import com.pega.sfa.workobjects.Appointment;
import com.pega.sfa.workobjects.AppointmentList;

public class AppointmentListImpl extends WizardImpl implements AppointmentList {

	
	public AppointmentListImpl(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
	}
	
	public Appointment createAppointment() {
		findElement((CREATE_APP_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId= pegaDriver.getActiveFrameId(false);
		PegaWebElement framElmt = pegaDriver.findElement(By.id(frameId));
		pegaDriver.switchTo().frame(frameId);
		Appointment app =  new AppointmentImpl(framElmt, frameId);
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
	Appointment app =  new AppointmentImpl(framElmt, frameId);
	app._setEnvironment(testEnv, frameId);
	return  app;
}
	
}
