package com.pega.sfa.workobjects;

import org.openqa.selenium.By;

import com.pega.ri.Wizard;
import com.pega.sfa.workobjects.impl.UtilImpl;

public interface AppointmentList extends Wizard {
	By CREATE_APP_BTN_XPATH =By.xpath("//*[@data-test-id='2015061907543208826357']");
	String LISTVIEW=UtilImpl.getSegmentedButtonXPath("List view");
	// We are not using this element anywhere
	By FILTER_TEXT_XPATH=By.xpath("//*[@data-test-id='201707200456290126208971']");
	By FILTER_BUTTON_XPATH=By.xpath("//*[@data-test-id='201707200456290126209349']");
	String APP_NAME_XPATH="//table[@id='gridLayoutTable']//tr[@pl_index='1']//a[1]";
	
    Appointment createAppointment();
	Appointment navigatToAppointment(String App);
}
