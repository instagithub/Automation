package customerservice;

import customerservice.tiles.LeftNav;
import customerservice.tiles.TopNav;
import com.pega.page.Portal;

public interface CSPortal extends Portal{

	public String COPYRIGHT = "Copyright (c) 2018  Pegasystems Inc.";
	public String VERSION = "$Id: CSPortal.java 117333 2018-10-01 09:12:21Z JayaPrakash $";
	
	TopNav getTopNav();
	
	LeftNav getLeftNav();

	void deleteAlert();

	void newMessage();

	void cancelModifyAlertDailogue();

	void refreshAlertSection();

	void doubleClickAlert(String message);

	void modifyAlert(String string, String modifyingField);

	void createAlert(String startDate, String endDate, String title, String message);
	
	
	
}
