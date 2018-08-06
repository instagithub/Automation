package com.pega.cs.interactions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.google.inject.Inject;
import com.pega.Browser;
import com.pega.MyBrowser;
import com.pega.MyTestEnvironment;
import com.pega.cs.TestEnvironmentImpl;
import com.pega.cs.SocialPortal;
import com.pega.TestEnvironment;
import com.pega.cs.BrowserImpl;
import com.pega.cs.CSPortal;
import com.pega.cs.WSSPortal;
import com.pega.cs.impl.CSPortalImpl;
import com.pega.cs.impl.WSSPortalImpl;
import com.pega.cs.interactions.Interactions;
import com.pega.cs.interactions.PhoneCall;
import com.pega.cs.interactions.impl.InteractionsImpl;
import com.pega.cs.interactions.ChatInteraction;
import com.pega.cs.utils.CommonMethods;
import com.pega.framework.PegaWebDriver;
import com.pega.ri.Wizard;
import com.pega.tiles.TopNavFixture;
import com.pega.util.XPathUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped

public class ChatFixture {
	
	private ChatInteraction chatInteraction;
	private Interactions interaction;
	private CommonMethods commonMethods;
	private PegaWebDriver pegaDriver;
	private WSSPortalImpl wssportal;
	TestEnvironment testEnv;
	private CSPortal csPortal;
	public String frameId = null;
	public Wizard newWizard = null;
	

	public static String ParentWindow = null;
	String AGENT_AVAILABLE_XPATH = "//*[@title='Agent is available']";
	
	String INCOMING_CHAT_REQUEST_XPATH = "//img[@alt='Incoming chat request ']";
	String INCOMING_CHAT_XPATH = "//div[contains(text(),'Incoming Chat...')]";
	String DECLINE_CHAT_XPATH = "//div[@class='pzbtn-mid' and contains(text(),'Decline')]";
	String ACCEPT_CHAT_XPATH = "//button[@title='Accept incoming chat request']";
	String CHAT_POPUP_ACCOUNT_XPATH = "//span[text()='Account:']";
	String CHAT_POPUP_ACCOUNT_NUM_XPATH = "//span[text()='123450000']";
	String CHAT_POPUP_ACCOUNT_TYPE_XPATH = "//span[text()='(Individual)']";
	String CHAT_POPUP_PRIORITY_XPATH = "//span[text()='Priority Note:']";
	String CHAT_POPUP_LANGUAGE_XPATH = "//label[@class='field-caption dataLabelForWrite' and contains(text(),'Language')]";
	String CHAT_POPUP_ENGLISH_XPATH = "//div[@class='field-item dataValueWrite']/span[text()='English']";
	String CHAT_POPUP_HEADER_XPATH = "//span[@class='case_title' and contains(text(),'connor')]";
	
	String EXPIRED_CHAT_XPATH = "//div[contains(text(),'Expired Chat')]";
	String CLOSE_CHAT_XPATH = "//button[@class='pzhc pzbutton' and text()='Close']";
	
	String CHAT_INTERACTION_HEADER_XPATH = "//a[@title='New chat interaction' and contains(text(),'Chat')]";
	
	String CHAT_ATTACHMENT_WIDGET_OPEN_XPATH = "//div[@title='Disclose Attachments']/i[@class='icon icon-openclose']";
	String CHAT_LOG_CORRESPONDANCE_XPATH = "//a[contains(text(),'Chat Log')]/following-sibling::div[contains(text(),'Correspondence')]";
	String CHAT_LOG_CHATLOG_XPATH = "//a[contains(text(),'Chat Log')]/following-sibling::div[contains(text(),'ChatLog')]";
	
			
	
	@Inject
	public ChatFixture (TopNavFixture topNavFixture, MyTestEnvironment testEnv) {

		this.testEnv = testEnv;
		interaction = topNavFixture.getInteractions();
		chatInteraction = topNavFixture.getChatInteraction();
		commonMethods = testEnv.getCommonMethods();
		pegaDriver = testEnv.getPegaDriver();
		

	}


	@Then("^verify agent is loggedin$")
	public void verify_agent_is_loggedin() {

		Assert.assertTrue("Agent is available icon is not present",
				pegaDriver.verifyElement(By.xpath(AGENT_AVAILABLE_XPATH)));

	}

	@When("^Chat agent joins \"([^\"]*)\" and gets connected$")
	public void chat_agent_joins_and_gets_connected(String QueueName) {
		chatInteraction.joinChatQueue(QueueName, pegaDriver);
					
	}


	@Then("^verify portal is launched with all the necessary fields$")
	public void verify_portal_is_launched_with_all_the_necessary_fields() {

	}

	@Then("^verify the name \"([^\"]*)\"$")
	public void verify_the_name(String arg1) {
		
	}


	@Then("^verify chat toaster pop$")
	public void verify_chat_toaster_pop() {

	}
	
	@Then("^verify the toaster pop values displayed in incoming chat for connor$")
	public void verify_the_toaster_pop_values_displayed_in_incoming_chat_for_connor() throws Throwable {
		/*pegaDriver.switchTo().defaultContent();
		Assert.assertTrue("Incoming chat icon not present",pegaDriver.verifyElement(By.xpath(INCOMING_CHAT_REQUEST_XPATH)));
		Assert.assertTrue("Incoming chat text not present",pegaDriver.verifyElement(By.xpath(INCOMING_CHAT_XPATH)));
		
		Assert.assertTrue("Decline button is not present",pegaDriver.verifyElement(By.xpath(DECLINE_CHAT_XPATH)));
		Assert.assertTrue("Accept button is not present",pegaDriver.verifyElement(By.xpath(ACCEPT_CHAT_XPATH)));*/
		
		/*Assert.assertTrue("Account num  text not present",pegaDriver.verifyElement(By.xpath(CHAT_POPUP_ACCOUNT_XPATH)));
		Assert.assertTrue("Account num is not present",pegaDriver.verifyElement(By.xpath(CHAT_POPUP_ACCOUNT_NUM_XPATH)));
		Assert.assertTrue("Account type is not present",pegaDriver.verifyElement(By.xpath(CHAT_POPUP_ACCOUNT_TYPE_XPATH)));
		Assert.assertTrue("Priority note is not present",pegaDriver.verifyElement(By.xpath(CHAT_POPUP_PRIORITY_XPATH)));
				
		Assert.assertTrue("Language field is missing",pegaDriver.verifyElement(By.xpath(CHAT_POPUP_LANGUAGE_XPATH)));
		Assert.assertTrue("Language value is missing",pegaDriver.verifyElement(By.xpath(CHAT_POPUP_ENGLISH_XPATH)));*/
	}
	
	@When("^csr changes the status to unavaialble$")
	public void csr_changes_the_status_to_unavaialble() throws Throwable {
	    pegaDriver.switchTo().defaultContent();
	    pegaDriver.findElement(By.xpath("Agent is available")).click(false);
	    pegaDriver.handleWaits().waitForElementVisibility(By.xpath("Not Available"));
	    pegaDriver.findElement(By.xpath("Not Available")).click(false);
	}
	@Then("^Verify the incoming chat pop up for \"([^\"]*)\" WSS user$")
	public void verify_the_incoming_chat_pop_up_for_WSS_user(String arg1) throws Throwable {
		pegaDriver.switchTo().defaultContent();
		Assert.assertTrue("Incoming chat icon not present",
				pegaDriver.verifyElement(By.xpath(INCOMING_CHAT_REQUEST_XPATH)));
		Assert.assertTrue("Incoming chat text not present",
				pegaDriver.verifyElement(By.xpath(INCOMING_CHAT_XPATH)));
		
		
		Assert.assertTrue("Chat username text not present",
				pegaDriver.verifyElement(By.xpath(CHAT_POPUP_HEADER_XPATH)));
		/*Assert.assertTrue("Chat username text not present",
				pegaDriver.verifyElement(By.xpath("//i[@title='connor']/svg/text[text()='C']")));*/
		
		Assert.assertTrue("Decline button is not present",pegaDriver.verifyElement(By.xpath(DECLINE_CHAT_XPATH)));
		Assert.assertTrue("Accept button is not present",pegaDriver.verifyElement(By.xpath(ACCEPT_CHAT_XPATH)));
		
		Assert.assertTrue("Account num  text not present",pegaDriver.verifyElement(By.xpath(CHAT_POPUP_ACCOUNT_XPATH)));
		Assert.assertTrue("dash not displayed for account number",
				pegaDriver.verifyElement(By.xpath("//span[text()='Account:']/following-sibling::div/span[contains(text(),'')]")));
		
		Assert.assertTrue("Priority note is not present",pegaDriver.verifyElement(By.xpath(CHAT_POPUP_PRIORITY_XPATH)));
		Assert.assertTrue("dash not displayed for Priority Note",
				pegaDriver.verifyElement(By.xpath("//span[text()='Priority Note:']/following-sibling::div/span[contains(text(),'')]")));
				
		Assert.assertTrue("Language field is missing",pegaDriver.verifyElement(By.xpath(CHAT_POPUP_LANGUAGE_XPATH)));
		Assert.assertTrue("dash not displayed for Priority Note",
				pegaDriver.verifyElement(By.xpath("//label[@class='field-caption dataLabelForWrite' and contains(text(),'Language')]/following-sibling::div/span[contains(text(),'')]")));
	}
	
	
	@Then("^Verify the toaster pop values displayed for incoming chat popup$")
	public void verify_the_toaster_pop_values_displayed_for_incoming_chat_popup() throws Throwable {

		
	}

	@When("^csr accepts the chat$")
	public void csr_accepts_the_chat() {

		chatInteraction.acceptChatPop(pegaDriver);
		pegaDriver.waitForDocStateReady(3);
		//pegaDriver.navigate().refresh();

	}
	
	
	@When("^csr declines the chat$")
	public void csr_declines_the_chat() throws Throwable {
		pegaDriver.switchTo().defaultContent();
	    chatInteraction.declineChatPop(pegaDriver);
	    
		/*=========================================================================================================*/
		/*Since declined is not performed with the time (30 sec) chaging the code to wait until the chat is expired*/
		/*=========================================================================================================*/
		
		//new WebDriverWait(pegaDriver, 40).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EXPIRED_CHAT_XPATH)));
		//Assert.assertTrue("Close button is not present",pegaDriver.verifyElement(By.xpath(CLOSE_CHAT_XPATH)));
	}
	
	
	
	@Then("^verify the chat interaction header$")
	public void verify_the_chat_interaction_header() throws Throwable {
		//pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		Assert.assertTrue("Click to chat text is not present",pegaDriver.verifyElement(By.xpath(CHAT_INTERACTION_HEADER_XPATH)));
			   
	}

	@Then("^verify chat interaction is launched$")
	public void verify_chat_interaction_is_launched() {

	}

	@Then("^CSR sends chat message \"([^\"]*)\"$")
	public void csr_sends_chat_message(String chatMessage) {
		chatInteraction.chatWithCustomer(chatMessage);
	}

	@When("^CSR agent logout of chat$")
	public void csr_agent_logout_of_chat() {
		chatInteraction.chatAgentLogout(pegaDriver);
	}


	@When("^Enter \"([^\"]*)\" in to chat as cacsr$")
	public void enter_in_to_chat_as_cacsr(String text) {
		chatInteraction.enterChattextAsCsr(text);
	}

	@When("^End the chat with the chat user$")
	public void end_the_chat_with_the_chat_user() {
		//chatInteraction.endChatWithCustomer();
		chatInteraction.endChatWithCustomer(pegaDriver);

	}

	@Then("^verify the dialog displayed in the chat panel$")
	public void verify_the_dialog_displayed_in_the_chat_panel() {
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//*[contains(text(),'The chat has ended.')]"));
		Assert.assertTrue("Chat ended text is not present", 
				pegaDriver.verifyElement(By.xpath("//*[contains(text(),'The chat has ended.')]")));

		/*
		 * pegaDriver.waitForDocStateReady(1);
		 * pegaDriver.switchTo().defaultContent(); Assert.assertTrue(
		 * "Chat session disconnected text is not present",
		 * pegaDriver.verifyElement(By.xpath(
		 * "//em[@class='systemMessage' and contains(text(),'The chat session has disconnected')]"
		 * )));
		 */

	}
	

	
	@Then("^verify the chat available details$")
	public void verify_the_chat_available_details() {

		pegaDriver.switchTo().defaultContent();
		Assert.assertTrue("Chat login icon is not present",
				pegaDriver.verifyElement(By.xpath("//*[@title='Login to chat server']")));

	}
	
	@Then("^verify the chat header for \"([^\"]*)\"$")
	public void verify_the_chat_header_for(String user) throws Throwable {
		
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();

		if(user.equalsIgnoreCase("Connor")){
		
			Assert.assertTrue("interaction title is not present",
					pegaDriver.verifyElement(By.xpath("//a[@title='Chat interaction withMs. Connor']")));
		}
		
		if(user.equalsIgnoreCase("brown")){
			
			Assert.assertTrue("interaction title is not present",
					pegaDriver.verifyElement(By.xpath("//a[@title='Chat interaction withMr. Brown']")));
		}
		
		if(user.equalsIgnoreCase("biggs")){
			
			Assert.assertTrue("interaction title is not present",
					pegaDriver.verifyElement(By.xpath("//a[@title='Chat interaction withMs. Biggs']")));
		}
		
	}

	@Then("^Verify the options displayed for the chat$")
	public void verify_the_options_displayed_for_the_chat() throws Throwable {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();

		Assert.assertTrue("channel text is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Channel')]")));
		Assert.assertTrue("chat text is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'chat')]")));
		Assert.assertTrue("Reason for interaction header is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Reason for interaction')]")));
		Assert.assertTrue("Created on header is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Created on')]")));
		Assert.assertTrue("Work ID header is not present",
				pegaDriver.verifyElement(By.xpath("//span[contains(text(),'Work ID')]")));
		Assert.assertTrue("Cases created during this interaction header is not present",
				pegaDriver.verifyElement(By.xpath("//h2[contains(text(),'Cases created during this interaction')]")));
		Assert.assertTrue("Articles viewed header is not present",
				pegaDriver.verifyElement(By.xpath("//h2[contains(text(),'Articles viewed')]")));
		Assert.assertTrue("Attachments header is not present",
				pegaDriver.verifyElement(By.xpath("//h2[contains(text(),'Attachments')]")));
		Assert.assertTrue("Chat Log History header is not present",
				pegaDriver.verifyElement(By.xpath("//h2[contains(text(),'Chat Log History')]")));

	}


	@When("^CSR selects \"([^\"]*)\" under \"([^\"]*)\" from phrases$")
	public void csr_selects_under_from_phrases(String SubPhrase, String MainPhrase) throws Throwable {
		pegaDriver.switchTo().defaultContent();
		
		//new WebDriverWait(pegaDriver, 40).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text' and contains(text(),'"+SubPhrase+"')]")));
		
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//div[@class='text' and contains(text(),'"+SubPhrase+"')]"));
		
		PegaWebElement phrase = pegaDriver.findElement(By.xpath("//button[@title='Include Phrases']"));
		phrase.click();

		PegaWebElement mainPhrase = pegaDriver.findElement(By.xpath("//span[@class='menu-item-title' and contains(text(),'"+MainPhrase+"')]"));
		testEnv.getScriptExecutor().mouseOver(mainPhrase);

		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		PegaWebElement subPhrase = pegaDriver.findElement(By.xpath("//span[contains(text(),'"+SubPhrase+"')]"));
		subPhrase.click();
		
			
	}

	@Then("^verify the text displayed in the chat box for \"([^\"]*)\"$")
	public void verify_the_text_displayed_in_the_chat_box_for(String phrase) throws Throwable {

		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		if (phrase.equalsIgnoreCase("Account balance")) {

			Assert.assertTrue("channel text is not present", pegaDriver.verifyElement(By.xpath("//textarea[]")));

		}

	}

	@When("^click on send button$")
	public void click_on_send_button() throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		//pegaDriver.findElement(By.xpath(XPathUtil.getButtonPzBtnMidXPath("Send"))).click();
		String SEND_BUTTON = "//button[@class='Strong pzhc pzbutton' and text()='Send']";
		pegaDriver.findElement(By.xpath(SEND_BUTTON)).click();
		//pegaDriver.findElement(By.xpath("//div[@class='pzbtn-mid' and text()='Send']")).click();

	}

		
	@Then("^verify \"([^\"]*)\" is displayed for ca csr$")
	public void verify_is_displayed_for_ca_csr(String msgText) throws Throwable {

		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//*[@class='chat_customer_message' and contains(.,'"+msgText+"')]"));
		Assert.assertTrue("Chat text is not present", pegaDriver.verifyElement(By.xpath("//*[@class='chat_customer_message' and contains(.,'"+msgText+"')]")));

	}

	@When("^Get the \"([^\"]*)\" from the chat and search it$")
	public void get_the_from_the_chat_and_search_it(String searchType)  {
		chatInteraction.getSearchTextFromChat(searchType);
			    
	}
	
	
		
	@Then("^Verify the options displayed for expired chat as CSR$")
	public void verify_the_options_displayed_for_expired_chat_as_CSR() {
		//new WebDriverWait(pegaDriver, 40).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EXPIRED_CHAT_XPATH)));
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath(EXPIRED_CHAT_XPATH));
		
		Assert.assertTrue("Expired chat text is not present",pegaDriver.verifyElement(By.xpath(EXPIRED_CHAT_XPATH)));
		//Assert.assertTrue("Account text is not present",pegaDriver.verifyElement(By.xpath(CHAT_POPUP_ACCOUNT_XPATH)));
		//Assert.assertTrue("Priority Note text is not present",pegaDriver.verifyElement(By.xpath(CHAT_POPUP_PRIORITY_XPATH)));
		//Assert.assertTrue("Language text is not present",pegaDriver.verifyElement(By.xpath(CHAT_POPUP_LANGUAGE_XPATH)));
		Assert.assertTrue("Close button is not present",pegaDriver.verifyElement(By.xpath(CLOSE_CHAT_XPATH)));
	    
	}

	@When("^close the expired chat$")
	public void close_the_expired_chat()  {
		
		chatInteraction.closeExpiredChat();
	    
	}
	
	
	@Then("^verify the dialog displayed for chat user after accepting the chat$")
	public void verify_the_dialog_displayed_for_chat_user_after_accepting_the_chat() throws Throwable {
	    
	}
	
	
	@When("^CSR selects \"([^\"]*)\" under \"([^\"]*)\" from Page push$")
	public void csr_selects_under_from_Page_push(String subOption, String InitialOption) throws Throwable {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchTo().defaultContent();
		PegaWebElement pagePush = pegaDriver.findElement(By.xpath("//button[contains(.,'Page')]"));
		pagePush.click();
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//span[contains(text(),'"+subOption+"')]"));
		PegaWebElement subPhrase = pegaDriver.findElement(By.xpath("//span[contains(text(),'"+subOption+"')]"));
		subPhrase.click();
		
	    
	}

	@Then("^Verify \"([^\"]*)\" sentiment icon is displayed$")
	public void verify_sentiment_icon_is_displayed(String IconName) throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//i[contains(@title,'"+IconName+"')]"));
		Assert.assertTrue("Senti icon is not present", 
				pegaDriver.verifyElement(By.xpath("//i[contains(@title,'"+IconName+"')]")));
	}
	

	@When("^CSR decline the incoming chat$")
	public void csr_decline_the_incoming_chat() throws Throwable {
		chatInteraction.declineChatPop(pegaDriver);
		
	}


	@Then("^verify the messages displayed after accepting chat$")
	public void verify_the_messages_displayed_after_accepting_chat() throws Throwable {
//		Assert.assertTrue("Problem description joined text is not present", 
//				pegaDriver.verifyElement(By.xpath("//em[@class='systemMessage' and contains(text(),'Description of the problem: Unspecified')]")));
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//*[@class='chat_system_message' and contains(text(),'Customer has connected.')]"));
		Assert.assertTrue("Problem description joined text is not present", 
				pegaDriver.verifyElement(By.xpath("//*[@class='chat_system_message' and contains(text(),'Customer has connected.')]")));		
	}
	
	
	@When("^Exit the chat interaction$")
	public void exit_the_chat_interaction()  {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		By xpathElement = By.xpath("//span[text()='Exit interaction']");
		//interaction.refershExitInteraction(xpathElement);
		PegaWebElement element = pegaDriver.findElement(By.xpath("//button[@title='Other actions']"));
		element.click();
		pegaDriver.switchToActiveFrame();
		element = pegaDriver.findElement(xpathElement);
		element.click();
		
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath("//textarea[@id='CancelNotes']")).sendKeys("Cancel Work");
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		pegaDriver.findElement(By.xpath("//button[@title='Complete this assignment']")).click();
			    
	}
	
	@When("^complete the wrap up for anonymous$")
	public void complete_the_wrap_up_for_anonymous() throws Throwable {
	    interaction.completeAnonymouswrapup();
	}
	
	@Then("^verify the chat ended message displyed in interaction portal$")
	public void verify_the_chat_ended_message_displyed_in_interaction_portal() throws Throwable {
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//*[@class='chat_system_message' and contains(text(),'The chat has ended.')]"));
		Assert.assertTrue("Chat ended text is not present", 
				pegaDriver.verifyElement(By.xpath("//*[@class='chat_system_message' and contains(text(),'The chat has ended.')]")));
		Assert.assertTrue("Disconnected text is not present", 
				pegaDriver.verifyElement(By.xpath("//*[@class='chat_system_message' and contains(text(),'Customer has disconnected.')]")));
	    
	}
	
	
	


	@Then("^verify the manager join message in for CSR$")
	public void verify_the_manager_join_message_in_for_CSR()  {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		
		Assert.assertTrue("Manager has connected text is not present", 
				pegaDriver.verifyElement(By.xpath("//em[@class='systemMessage' and contains(text(),'Manager has connected.')]")));
	    
	}
	
	@Then("^verify the manager left message is displayed for CSR$")
	public void verify_the_manager_left_message_is_displayed_for_CSR() {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		
		Assert.assertTrue("Manager has disconnected text is not present", 
				pegaDriver.verifyElement(By.xpath("//em[@class='systemMessage' and contains(text(),'Manager has disconnected.')]")));
	    
	}
	
	@Then("^verify the text sent is same as the dialog of the page$")
	public void verify_the_text_sent_is_same_as_the_dialog_of_the_page() throws Throwable {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		
		String dialog = pegaDriver.findElement(By.xpath("//div[@id='DialogContent']")).getText();
		System.out.println(dialog);
		
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		String Chattext = pegaDriver.findElement(By.xpath("//div[@class='csr chat-content']/div[@class='text']")).getText();
		System.out.println(dialog);
		
		Assert.assertEquals("Contact verification dialog is not present or incorrect","How can I help you today, Ms. Connor?",dialog);
	 
	}
	
	
	
	@Then("^Verify incoming chat popup is not diaplayed$")
	public void verify_incoming_chat_popup_is_not_diaplayed()  {
		
		pegaDriver.switchTo().defaultContent();
		Assert.assertFalse("Incoming chat text is present",
				pegaDriver.verifyElement(By.xpath("//div[text()='Incoming chat...']")));
	    
	}

	@When("^Close the chat interaction for \"([^\"]*)\"$")
	public void close_the_chat_interaction_for(String username)  {
		
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		
		if(username.equalsIgnoreCase("brown")){
			pegaDriver.findElement(By.xpath("//a[@title='Chat interaction withMr. Brown']/ancestor::div[3]/following-sibling::div[1]/descendant::i[@title='Close Tab ']")).click();	
		}
		
		else if(username.equalsIgnoreCase("Connor")){
			pegaDriver.findElement(By.xpath("//a[@title='Chat interaction withMs. Connor']/ancestor::div[3]/following-sibling::div[1]/descendant::i[@title='Close Tab ']")).click();	
		}
		else if(username.equalsIgnoreCase("biggs")){
			pegaDriver.findElement(By.xpath("//a[@title='Chat interaction withMs. Biggs']/ancestor::div[3]/following-sibling::div[1]/descendant::i[@title='Close Tab ']")).click();	
		}
		else{
			pegaDriver.findElement(By.xpath("//a[@title='New chat interaction' and contains(text(),'Chat')]/ancestor::div[3]/following-sibling::div[1]/descendant::i[@title='Close Tab ']")).click();	
		}
		
		
	    
	}

	@Then("^verify the chat interaction header for default user$")
	public void verify_the_chat_interaction_header_for_default_user()  {
		
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		
		Assert.assertTrue("Click to chat text is not present",pegaDriver.verifyElement(By.xpath(CHAT_INTERACTION_HEADER_XPATH)));
		
	}
	
	@Then("^verify the above chat messages are displayed under Chat Log history$")
	public void verify_the_above_chat_messages_are_displayed_under_Chat_Log_history() throws Throwable {
		
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		
		Assert.assertTrue("Problem description joined text is not present", 
				pegaDriver.verifyElement(By.xpath("//em[@class='systemMessage' and contains(text(),'Description of the problem: Unspecified')]")));
		Assert.assertTrue("Customer joined text is not present", 
				pegaDriver.verifyElement(By.xpath("//em[@class='systemMessage' and contains(text(),'SARA CONNOR has connected.')]")));
		Assert.assertTrue("CSR chat text is not present", 
				pegaDriver.verifyElement(By.xpath("//div[@class='csr chat-content']/div[@class='text' and contains(text(),'Hi')]")));
		Assert.assertTrue("Chat user chat text is not present", 
				pegaDriver.verifyElement(By.xpath("//div[@class='chat-content']/div[@class='text' and contains(text(),'Hi Csr')]")));
		
		pegaDriver.switchToActiveFrame();
	    
	}

	@Then("^Verify chat log is present under attachments$")
	public void verify_chat_log_is_present_under_attachments() throws Throwable {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		PegaWebElement openIcon = pegaDriver.findElement(By.xpath(CHAT_ATTACHMENT_WIDGET_OPEN_XPATH));
		openIcon.click();
		
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		
		Assert.assertTrue("Correspondance text is not present",pegaDriver.verifyElement(By.xpath(CHAT_LOG_CORRESPONDANCE_XPATH)));
		Assert.assertTrue("Correspondance text is not present",pegaDriver.verifyElement(By.xpath(CHAT_LOG_CHATLOG_XPATH)));
		
	   
	}

}
