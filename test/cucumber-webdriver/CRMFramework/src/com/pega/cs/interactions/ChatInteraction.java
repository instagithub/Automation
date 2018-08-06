package com.pega.cs.interactions;

import java.util.Map;

import com.pega.framework.PegaWebDriver;

public interface ChatInteraction extends Interactions{
	
	
	String JOIN_QUEUE_XPATH = "//span[contains(text(),'Join Queues')]";
	String CONNECT_QUEUE_XPATH = "//button[contains(@class,'pzbutton') and text()='Connect']" ;
	String WSS_USER_NAME = "//select[@title='Select a contact']";
	String WSS_LOGIN_BUTTON = "//button[@title='Click to Login']";
	String ACCEPT_INCOMING_CHAT = "//div[contains(@class,'content-item')]/span/button[@title='Accept incoming chat request']";
	//String ACCEPT_TRANSFERRED_CHAT = "//div[contains(@class,'content-item')]/span/button[@title='Accept incoming chat request']";
	String DECLINE_CHAT = "//button[@class='pzhc pzbutton' and contains(text(),'Decli')]";
	String ACCEPT_CHAT_BUTTON = "//button[@title='Accept incoming chat request']";
	String CHAT_WITH_REP = "//img[contains(@src,'img/chatAssets/chat-badge-outline.png')]"; 
			//"//div[contains(text(),'Click here to chat with a representative.')]";
	
	
	String CLOSE_BUTTON = "//div[@class='pzbtn-mid' and text()='Close']";
	String CLOSE_EXPIRED_CHAT_BUTTON="//button[@class='pzhc pzbutton' and text()='Close']";
	String SEND_BUTTON = "//button[contains(.,'Send')]";
	String ENTER_CHAT_TEXTBOX ="//textarea[contains(@id,'TabChatEntry')]";
	String CHAT_USERNAME ="//div[@class='chat-content']/div[@class='text']";
	
	//void chatAgentLogin();
	void chatWithCustomer(String chatText);
	void enterChattextAsCsr(String text);
	//void joinChatQueue(String QueueName);
	void getSearchTextFromChat(String searchType);
	void closeExpiredChat();
	//void declineChatPop();
	void chatAgentLogout(PegaWebDriver pegaWebDriver);
	void initiateCoBrowse();
	void endChatWithCustomer(PegaWebDriver pegaWebDriver);
	void logintoWSSPortal(String userId, PegaWebDriver pegaWebDriver);
	void clickOnChatIcon(PegaWebDriver pegaWebDriver);
	void selectQueueFromChat(String value, PegaWebDriver pegaWebDriver);
	void acceptChatPop(PegaWebDriver pegaWebDriver);
	void declineChatPop(PegaWebDriver pegaWebDriver);
	void joinChatQueue(String QueueName, PegaWebDriver pegaWebDriver);
	void acceptTransferredChatPop(PegaWebDriver pegaWebDriver);
}
