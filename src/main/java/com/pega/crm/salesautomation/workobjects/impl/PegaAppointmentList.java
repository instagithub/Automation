package com.pega.crm.salesautomation.workobjects.impl;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.Appointment;
import com.pega.crm.salesautomation.workobjects.AppointmentList;
import com.pega.ri.WizardImpl;

public class PegaAppointmentList extends WizardImpl implements AppointmentList {

	
	public PegaAppointmentList(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}



	public Appointment createAppointment() {
		findElement((CREATE_APP_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		String frameId= pegaDriver.getActiveFrameId(false);
		Appointment app =  new PegaAppointment(frameId, testEnv);
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
	Appointment app =  new PegaAppointment(frameId, testEnv);
	return  app;
}
	
}
