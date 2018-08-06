package com.pega.cs.interactions.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pega.cs.interactions.ChatInteraction;
import com.pega.cs.utils.CommonMethods;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.page.Search;
import com.pega.ri.Wizard;

import gherkin.formatter.Reporter;

public class ChatInteractionImpl extends InteractionsImpl implements ChatInteraction {

	public String frameId = null;
	public Wizard newWizard = null;
	public CommonMethods commonMethods = null;

	public ChatInteractionImpl(WebElement elmt, String frameId) {
		super(elmt, frameId);
		commonMethods = new CommonMethods(pegaDriver);
	}

	public ChatInteractionImpl(WebElement elmt) {
		super(elmt);

	}

	
	@Override
	public void acceptChatPop(PegaWebDriver pegaWebDriver) {
		//pegaDriver.waitForDocStateReady(3);
		pegaWebDriver.switchTo().defaultContent();
		//pegaWebDriver.handleWaits().waitForElementPresence(arg0);
		
			//Thread.sleep(3000);
			//new WebDriverWait(pegaWebDriver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Accept incoming chat request']")));
			//pegaWebDriver.handleWaits().waitForElementVisibility(By.xpath("//button[@title='Accept incoming chat request']"));
			//PegaWebElement acceptChat = pegaWebDriver.findElement(By.xpath("//button[@title='Accept incoming chat request']"));
			
			pegaWebDriver.handleWaits().waitForElementVisibility(By.xpath(ACCEPT_INCOMING_CHAT));
			PegaWebElement acceptChat = pegaWebDriver.findElement(By.xpath(ACCEPT_INCOMING_CHAT));
			
			//pegaWebDriver.findElement(By.xpath("//button[@title='Accept incoming chat request']")).click();
			acceptChat.click();
			
		//}catch (Exception e){
		//	System.out.println("Element not found");
		//}
		
		
		//pegaDriver.findElement(By.xpath("//div[@class=\'pzbtn-mid\' and contains(text(),\'Accept\')]")).click();
	}
	
	@Override
	public void acceptTransferredChatPop(PegaWebDriver pegaWebDriver) {
		    pegaWebDriver.switchTo().defaultContent();
			pegaWebDriver.handleWaits().waitForElementVisibility(By.xpath(ACCEPT_INCOMING_CHAT));
			PegaWebElement acceptTransferredChat = pegaWebDriver.findElement(By.xpath(ACCEPT_INCOMING_CHAT));
			
			//pegaWebDriver.findElement(By.xpath("//button[@title='Accept incoming chat request']")).click();
			acceptTransferredChat.click();
	}
			
	
	@Override
	public void declineChatPop(PegaWebDriver pegaWebDriver) {
		//pegaDriver.waitForDocStateReady(3);
		pegaWebDriver.switchTo().defaultContent();
		
			//Thread.sleep(3000);
			//new WebDriverWait(pegaDriver, 40).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Accept incoming chat request']")));
			pegaWebDriver.handleWaits().waitForElementVisibility(By.xpath(ACCEPT_CHAT_BUTTON));
			PegaWebElement declineChat = pegaWebDriver.findElement(By.xpath(DECLINE_CHAT));
			declineChat.click();
			
		//}catch (Exception e){
		//	System.out.println("Element not found");
		//}
		
		
		//pegaDriver.findElement(By.xpath("//div[@class=\'pzbtn-mid\' and contains(text(),\'Accept\')]")).click();
	}


	public void chatAgentLogout(PegaWebDriver pegaWebDriver) {
		pegaWebDriver.waitForDocStateReady(2);
		pegaWebDriver.switchTo().defaultContent();
		PegaWebElement statusIcon = pegaWebDriver.findElement(By.xpath("//*[@title='Agent is available']"));
		statusIcon.click();
		pegaWebDriver.waitForDocStateReady(2);
		pegaWebDriver.switchTo().defaultContent();
		PegaWebElement logout = pegaWebDriver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
		//*[@id='pyNavigation1498641557916']/li[3]/a/span[2]/span
		logout.click();

	}
	
	@Override
	public void chatWithCustomer(String chatText) {
		pegaDriver.switchTo().defaultContent();
		new WebDriverWait(pegaDriver, 40).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@title='Enter Chat Text' and @id='TabChatEntry']")));
		PegaWebElement chatTextBox =  pegaDriver.findElement(By.xpath("//textarea[@title='Enter Chat Text' and @id='TabChatEntry']"));
		chatTextBox.sendKeys(chatText);
		chatTextBox.sendKeys(Keys.ENTER);
		pegaDriver.switchTo().defaultContent();
	}
	
	@Override
	public void endChatWithCustomer(PegaWebDriver pegaWebDriver) {
		pegaDriver.waitForDocStateReady(1);
		PegaWebElement  otherActions =  pegaWebDriver.findElement(By.xpath("//*[@title='Other actions' and contains(@name,'CPMChatLiveWrapper')]"));
		otherActions.click();
		pegaDriver.waitForDocStateReady(1);
		PegaWebElement endChat = pegaWebDriver.findElement(By.xpath("//span[contains(text(),'End Chat')]"));
		endChat.click();
		pegaWebDriver.waitForDocStateReady(2);;
		PegaWebElement endchatpopup = pegaWebDriver.findElement(By.xpath("//button[contains(.,'End chat')]"));
		endchatpopup.click();
		pegaDriver.waitForDocStateReady(1);
	}
	
	
	@Override
	public void logintoWSSPortal(String userId,PegaWebDriver pegaWebDriver) {
		Select contactname = new Select(pegaWebDriver.findElement(By.xpath(WSS_USER_NAME)));
		contactname.selectByValue(userId);
		pegaWebDriver.waitForDocStateReady(1);
		pegaWebDriver.findElement(By.xpath(WSS_LOGIN_BUTTON)).click(false);
      }
	
	
	
	@Override
	public void initiateCoBrowse() {
		pegaDriver.switchTo().defaultContent();
		PegaWebElement  otherActions =  pegaDriver.findElement(By.xpath("//*[@title='Other actions']"));
		otherActions.click();
		PegaWebElement CoBrowse = pegaDriver.findElement(By.xpath("//span[contains(text(),'Co-Browse')]"));
		CoBrowse.click();
				
		pegaDriver.switchTo().defaultContent();
	}
	
	
	@Override
	public void enterChattextAsCsr(String text) {
		pegaDriver.waitForDocStateReady(5);
		//pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(ENTER_CHAT_TEXTBOX)).sendKeys(text);
		pegaDriver.findElement(By.xpath(SEND_BUTTON)).click();
		pegaDriver.waitForDocStateReady(1);
		pegaDriver.switchTo().defaultContent();

	}
	
	
	
	@Override
	public void joinChatQueue(String QueueName, PegaWebDriver pegaWebDriver) {
		pegaWebDriver.waitForDocStateReady(2);
		pegaWebDriver.switchTo().defaultContent();
		pegaWebDriver.findElement(By.xpath(JOIN_QUEUE_XPATH)).click(false);
		pegaWebDriver.waitForDocStateReady(3);
		pegaWebDriver.switchTo().defaultContent();
		//pegaWebDriver.findElement(By.xpath("//div[@class='oflowDivM ']/span[contains(text(),'"+QueueName+"')]/ancestor::td[1]/preceding-sibling::td/descendant::input[@class='checkbox chkBxCtl']")).click();
		pegaWebDriver.findElement(By.xpath("//*[contains(@class,'content-item')]/span[text()='"+QueueName+"']/parent::div/preceding-sibling::div/input[contains(@class,'checkbox chkBxCtl')]/following-sibling::label")).click();
		pegaWebDriver.findElement(By.xpath(CONNECT_QUEUE_XPATH)).click();
		pegaWebDriver.waitForDocStateReady(5);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath("//*[@title='Agent is available']"));
		pegaWebDriver.switchTo().defaultContent();
	}
	
	@Override
	public void getSearchTextFromChat(String searchType) {
		
		pegaDriver.switchTo().defaultContent();
		String username = pegaDriver.findElement(By.xpath(CHAT_USERNAME)).getText();
		System.out.println(username);
		pegaDriver.switchToActiveFrame();
		pegaDriver.waitForDocStateReady(3);
		//pegaDriver.switchTo().defaultContent();
		
		if(searchType.equalsIgnoreCase("Last name")){
		
		PegaWebElement lastNameElmt = pegaDriver.findElement(By.xpath(LAST_NAME_XPATH));
		lastNameElmt.sendKeys(username);
		}
				
		PegaWebElement search = pegaDriver.findElement(By.xpath(PHONECALL_RESULT_SEARCH_XPATH));
		search.click();

	}
	
	@Override
	public void closeExpiredChat() {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		
		
		PegaWebElement closeChat = pegaDriver.findElement(By.xpath(CLOSE_EXPIRED_CHAT_BUTTON));
		closeChat.click();

	}
	
	@Override
	public void clickOnChatIcon(PegaWebDriver pegaWebDriver) {
		pegaWebDriver.findElement(By.xpath(CHAT_WITH_REP)).click();

	}
	
	@Override
	public void selectQueueFromChat(String value, PegaWebDriver pegaWebDriver) {
		new WebDriverWait(pegaWebDriver, 40).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Thanks for choosing us! To get started, please answer a few questions.')]")));
		
		DropDown DropDownList = pegaWebDriver.findSelectBox(By.xpath("//div[@class='queueSelector']/select"));
		DropDownList.selectByValue(value);

	}
	
	

}
