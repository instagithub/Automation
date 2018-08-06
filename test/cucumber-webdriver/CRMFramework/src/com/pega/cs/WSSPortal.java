package com.pega.cs;

import org.openqa.selenium.By;

import com.pega.cs.tiles.LeftNav;
import com.pega.cs.tiles.TopNav;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.page.Portal;
import com.pega.Browser;

public interface WSSPortal extends Portal{

	Browser browser = null;
	String WSS_USER_NAME = "//select[@title='Select a contact']";
	String WSS_LOGIN_BUTTON = "//button[@title='Click to Login']";
	String QUICK_LINKS = "//select[@class='wss_quick_links']";
	String SIGN_OUT= "//td[@id='ItemMiddle' and text()='Sign Out']";
	String CONFORM_BUTTON_XPATH ="//div[@class='pzbtn-mid' and text()='Close']";
	String SAVE_BUTTON_XPATH ="//div[@class='pzbtn-mid' and text()='Save']";
	String WSS_SUBMIT_BUTTON_XPATH = "//div[@class='pzbtn-mid' and text()='Submit']";
	
	void loginByShortUrl(String appName);
	void loginByContact(String userId);
		
	void loginToWSS();
	void initiateChat();
	void sendChatMessage(String chatMessage);
	void logout();
	//void loginByContact(String userId);
	void addTask(String caseName);
	void wssLogout(String userName);
	void conform();
	void changeAddressinWssPortal();
	void selectFlowAction(String option);
	void selectAdditionalAccounts();
	void ConformChanges(String FlowType);
	void selectIssueAndIssueType(String type, String issueType);
	void selectTrancation();
	void updateProfile();
	void selectProfileLink();
	void verifyLoggedUser(String usrName, PegaWebDriver pegaWebDriver);

}
