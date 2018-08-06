package com.pega.cs;

import com.pega.cs.tiles.LeftNav;
import com.pega.cs.tiles.TopNav;
import com.pega.page.Portal;

public interface CSPortal extends Portal{

	String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	String VERSION = "$Id: CSPortalImpl.java 117333 2015-06-18 09:12:21Z MuraliKondapally $";
	
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
