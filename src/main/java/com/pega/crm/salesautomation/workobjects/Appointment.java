package com.pega.crm.salesautomation.workobjects;

import org.openqa.selenium.By;

import com.pega.ri.Wizard;
import com.pega.util.XPathUtil;


public interface Appointment extends Wizard {
	By APP_APPOINTMENT_PAGE_HEADER_XPATH=By.xpath("//*[@data-test-id='20150619090201056211544']");
	By APP_SUBJECT_ID=By.xpath("//*[@data-test-id='2015062201291300455727']");
	By APP_LOCATION_ID=By.xpath("//*[@data-test-id='2015062201291300456149']");
	String APP_BODY_ID="Body";
	//No data test ID
	String APP_TODAY_BTN_ID= "Year";
	//Element not being use anywhere
	//No data test ID
	String APP_DAILY_BTN_ID= "Day";
	//Element not being use anywhere
	//No data test ID
	String APP_WEEKLY_BTN_ID = "Week";
	//Element not being use anywhere
	//No data test ID
	String APP_MONTHLY_BTN_ID= "Month";
	//Element not being use anywhere
	//No data test ID
	By APP_STARTDATE_ID =By.xpath("//*[@data-test-id='20150622012913004612135']");
	By APP_ENDTDATE_ID =By.xpath("//*[@data-test-id='20150622012913004614558']");
	By APP_PREVIOUS_BTN_XPATH =By.xpath("//*[@data-test-id='20170522033336073146738']");
	//Element not being use anywhere
	By APP_NEXT_BTN_XPATH =By.xpath("//*[@data-test-id='20141202044424036812321']");
	//Element not being use anywhere
	By APP_ADDINTERNALSTAFF_BTN_XPATH =By.xpath("//*[@data-test-id='20141202044424037626220']");
	By APP_ADDCONTACTS_BTN_XPATH =By.xpath("//*[@data-test-id='20160721092326035219972']");
	By APP_ADDEXPERTS_BTN_XPATH =By.xpath("//*[@data-test-id='20141202044424037928625']");
	By APP_SAVE_BTN_XPATH =By.xpath("//*[@data-test-id='20150622012918047594800']");
	String APP_SEND_BTN_XPATH = XPathUtil.getButtonPzBtnMidXPath("Send");
	//No Data test ID for the Send button
	By APP_DISCARD_BTN_XPATH =By.xpath("//*[@data-test-id='20151202132606008411636']");
	String APP_SEARCH_BTN_XPATH = XPathUtil.getButtonPzBtnMidXPath("Search");
	//No data test ID
	String APP_ADD_MODAL_XPATH_ID= "//td/button[@id='ModalButtonSubmit']";
	//No data test ID
	By APP_FIRSTNAME_ID =By.xpath("//*[@data-test-id='2015061907460709335264']");
	String APP_LASTNAME_ID= "pyLastName";
	//Element not being use anywhere
	String APP_STAFF_ID="crmIgnoreField";
	//AutoComplete so no change data test ID
	String APP_CONTACT_ID="crmIgnoreField";
	//AutoComplete so no change data test ID
	By APP_EDIT_BTN_XPATH=By.xpath("//*[@data-test-id='20161114115750012327945']");
	By APP_EXPERT_CHECKBOX=By.xpath("//*[@data-test-id='20150619074607093991909']");
	String APP_STATUS_XPATH="//span[text()='Status']/../div/span";
	//No data test ID
	By APP_SUBJECT_XPATH=By.xpath("//*[@data-test-id='20141216000609003113944']");
	By APP_LOCATION_XAPTH=By.xpath("//*[@data-test-id='20141216000609003314577']");
	By APP_START_TIME_XPATH=By.xpath("//*[@data-test-id='20141216000609003821744']");
	By APP_END_TIME_XPATH=By.xpath("//*[@data-test-id='20141216000609003922406']");
	String APP_BODY_XPATH="//div[@node_name='pyWorkSummary']//div[@string_type='paragraph']/div";
	//No data test ID

	
	String getAppointmentPageHeader();
	void setAppointmentSubject(String subject);
	void setLocation(String location);
	void setBody(String body);
	void setStartDateTime(String dt);
	void setEndDateTime(String dt);
	void clickAddInternalStaff(String s);
	void clickAddContacts(String s);
	void clickAddExperts(String s);
	void clickSave();
	void clickEdit();
	void clickSend();
	void clickDiscard();
	String getStatus();
	String getSubject();
	String getMeetingLocation();
	String getStartTime();
	String getEndtime();
	String getBody();
	String getEditButton();
    void updateLocation(String updatedlocation);
    Boolean isSubjectEnabled();
    Boolean isLocationEnabled();
    Boolean isBodyEnabled();
    Boolean isStartTimeEnabled();
    Boolean isEndTimeEnabled();
	void setappStartDateTime();
	
	
}
