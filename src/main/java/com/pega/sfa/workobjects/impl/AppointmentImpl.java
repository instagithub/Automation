package com.pega.sfa.workobjects.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.framework.PegaWebElement;
import com.pega.ri.Wizard;
import com.pega.ri.WizardImpl;
import com.pega.sfa.workobjects.Appointment;

public class AppointmentImpl extends WizardImpl implements Appointment{

	public AppointmentImpl(WebElement elmt, String elmtId){
		super(elmt, elmtId);
	}

	
	@Override
	public void setAppointmentSubject(String subject) {

		pegaDriver.getActiveFrameId(true);
		pegaDriver.findElement((APP_SUBJECT_ID)).sendKeys(subject);
	}

	@Override
	public void setLocation(String location) {

		pegaDriver.findElement((APP_LOCATION_ID)).sendKeys(location);
	}

	@Override
	public void setBody(String body) {
		//pegaDriver.findElement(By.id(APP_BODY_ID)).sendKeys(body);
		pegaDriver.findElement(By.xpath("//body[contains(@title,'This is a rich text editor control')]/p")).sendKeys("Test to body");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setappStartDateTime() {

		/*pegaDriver.findElement(By.id(APP_STARTDATE_ID)).sendKeys(dt);*/
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		
		
		
		//String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm").format(Calendar.getInstance().getTime());
	
		//System.out.println("timeStamp***"+timeStamp);
		//pegaDriver.findElement(By.xpath("//input[@data-test-id='20150622012913004612135']")).sendKeys(timeStamp);
		//pegaDriver.switchTo().activeElement().sendKeys(Keys.TAB);
	//	pegaDriver.switchTo().activeElement().sendKeys(Keys.TAB);
		
		String appCALANDER_XPATH="//span[contains(@id, 'CloseDateSpan')]/span | //img[contains(@data-ctl,'DatePicker')]";
		pegaDriver.findElement(By.xpath(appCALANDER_XPATH)).click();
		pegaDriver.getActiveFrameId(true);
		PegaWebElement wb;
		pegaDriver.verifyElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='30']"));
		
			wb = pegaDriver.findElement(By.xpath("//table[@id='Pega_Cal_Cont']//a[@data-day='30']"));
			wb.click();
			pegaDriver.waitForDocStateReady(1);
		
		//UtilImpl.setDate(pegaDriver, new Date().getDate());
	}

	@Override
	public void setEndDateTime(String dt) {
		pegaDriver.findElement((APP_ENDTDATE_ID)).sendKeys(dt);
		pegaDriver.waitForDocStateReady(1);
	}

	@Override
	public void clickAddInternalStaff(String s) {

		pegaDriver.waitForDocStateReady(2);
		pegaDriver.findElement((APP_ADDINTERNALSTAFF_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(2);
		UtilImpl.autoComplete(pegaDriver, APP_STAFF_ID, s);
	}

	@Override
	public void clickAddContacts(String s) {

		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement((APP_ADDCONTACTS_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		UtilImpl.autoComplete(pegaDriver, APP_CONTACT_ID, s);
		pegaDriver.waitForDocStateReady(1);
	}

	@Override
	public void clickAddExperts(String s) {

	
		pegaDriver.findElement((APP_ADDEXPERTS_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement((APP_FIRSTNAME_ID)).sendKeys(s);   
		pegaDriver.findElement(By.xpath(APP_SEARCH_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement((APP_EXPERT_CHECKBOX)).click();
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement(By.xpath(APP_ADD_MODAL_XPATH_ID)).click();

	}

	@Override
	public void clickSave() {
	
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.findElement((APP_SAVE_BTN_XPATH)).click();
	}

	@Override
	public void clickSend() {
		//pegaDriver.getTestEnv().getScriptExecutor().executeJavaScript("window.scrollTo(0,document.body.scrollHeight)");
		Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
		wizard.findElement(By.xpath("//select[contains(@id, 'RemindBefore')]")).scrollIntoView();
		//pegaDriver.findElement(By.xpath("//select[contains(@id, 'RemindBefore')]")).scrollIntoView();
		wizard.findElement(By.xpath("//a[text()='Add contact']")).scrollIntoView();
	//	pegaDriver.findElement(By.xpath("//a[text()='Add contact']")).scrollIntoView();
		wizard.findElement(By.xpath("//h2[text()='Recent attachments']")).scrollIntoView();
	// Currently there is a bug open because the sub tab change from "Attachments" to "Recent attachments" 
		//pegaDriver.findElement(By.xpath("//h2[text()='Attachments']")).scrollIntoView();
		//pegaDriver.findElement(By.xpath(APP_SEND_BTN_XPATH)).scrollIntoView();
		pegaDriver.findElement(By.xpath(APP_SEND_BTN_XPATH)).click();
	}

	@Override
	public void clickDiscard() {
	
		pegaDriver.findElement((APP_DISCARD_BTN_XPATH)).click();
	}
     
	@Override
	public String getAppointmentPageHeader() {
	
		pegaDriver.getActiveFrameId(true);
		String appHeader = pegaDriver.findElement((APP_APPOINTMENT_PAGE_HEADER_XPATH)).getText();
		return appHeader;
	}

	@Override
	public String getStatus() {
		pegaDriver.waitForDocStateReady(2);
		String status= pegaDriver.findElement(By.xpath(APP_STATUS_XPATH)).getText();
		return status;
	}

	@Override
	public String getSubject() {
	
		String subject= pegaDriver.findElement((APP_SUBJECT_XPATH)).getText();
		return subject;
	}

	@Override
	public String getMeetingLocation() {
		
		String location= pegaDriver.findElement((APP_LOCATION_XAPTH)).getText();
		return location;
	}

	@Override
	public String getStartTime() {
		
		String starttime= pegaDriver.findElement((APP_START_TIME_XPATH)).getText();
		return starttime;
	}

	@Override
	public String getEndtime() {

		String endtime= pegaDriver.findElement((APP_END_TIME_XPATH)).getText();
		return endtime;
			}

	@Override
	public String getBody() {
		
         String body = pegaDriver.findElement(By.xpath(APP_BODY_XPATH)).getText();
		 return body;
	}

	@Override
	public String getEditButton() {
	
		String editbutton = pegaDriver.findElement((APP_EDIT_BTN_XPATH)).getText();
		 return editbutton;
	}

	@Override
	public void clickEdit() {
	
		
		pegaDriver.findElement((APP_EDIT_BTN_XPATH)).click();
		pegaDriver.waitForDocStateReady(1);
	}

	@Override
	public void updateLocation(String updatedlocation) {
		
		pegaDriver.findElement((APP_LOCATION_ID)).sendKeys(UtilImpl.SelectAll);
		pegaDriver.findElement((APP_LOCATION_ID)).sendKeys(updatedlocation);
	}

	@Override
	public Boolean isSubjectEnabled() {
		pegaDriver.getActiveFrameId(true);
	
		Boolean bool= pegaDriver.findElement((APP_SUBJECT_ID)).isEnabled();
		return bool;
	}

	@Override
	public Boolean isLocationEnabled() {
	
		Boolean bool= pegaDriver.findElement((APP_LOCATION_ID)).isEnabled();
		return bool;
	}

	@Override
	public Boolean isBodyEnabled() {
	
		Boolean bool= pegaDriver.findElement(By.id(APP_BODY_ID)).isEnabled();
		return bool;
	}

	@Override
	public Boolean isStartTimeEnabled() {
		
		Boolean bool= pegaDriver.findElement((APP_STARTDATE_ID)).isEnabled();
		return bool;
	}

	@Override
	public Boolean isEndTimeEnabled() {
		
		Boolean bool= pegaDriver.findElement((APP_ENDTDATE_ID)).isEnabled();
		return bool;
	}


	@Override
	public void setStartDateTime(String dt) {
		// TODO Auto-generated method stub
		
	}
	
  
}
