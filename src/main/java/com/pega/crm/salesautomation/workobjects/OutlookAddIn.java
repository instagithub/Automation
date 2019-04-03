package com.pega.crm.salesautomation.workobjects;

public interface OutlookAddIn{

	void loginToOutlook(String username, String pwd); 
	void acessMailbox();
	void sendEmail(String sendToMail, String subject, String messageBody); 
	void selectRecentMail(String MailSubject);
	void loginToAddin(String SalesRepUserName, String SalesRepPassword);
	boolean verifyContactHeader();
}
