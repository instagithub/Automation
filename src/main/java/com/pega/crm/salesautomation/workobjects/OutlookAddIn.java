package salesautomation.workobjects;

import java.util.List;
import com.pega.ri.Wizard;

public interface OutlookAddIn{

	void loginToOutlook(String username, String pwd); 
	void acessMailbox();
	void sendEmail(String sendToMail, String subject, String messageBody); 
	void selectRecentMail(String MailSubject);
	void loginToAddin(String SalesRepUserName, String SalesRepPassword);
	boolean verifyContactHeader();
}
