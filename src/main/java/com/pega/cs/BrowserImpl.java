package com.pega.cs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pega.TestEnvironment;
import com.pega.cs.impl.CSPortalImpl;
import com.pega.cs.impl.SFAPortalImpl;
import com.pega.cs.interactions.ResearchInteraction;
import com.pega.cs.interactions.impl.ResearchInteractionImpl;
import com.pega.cs.tiles.TopNav;
import com.pega.explorer.DesignerStudioImpl;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.DropDown;
import com.pega.page.Portal;
import com.pega.pm.impl.PegaDesignerStudio;
import com.pega.pm.impl.PegaExpressPortal;
import com.pega.pm.impl.PegaPMPortal;
import com.pega.ri.Wizard;
//import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;

/**
 * @author Chanu
 * @since 11 Dec 2013
 */
public class BrowserImpl extends com.pega.BrowserImpl {

	@SuppressWarnings("unused")
	public String frameId = null;
	public Wizard newWizard = null;
	private static final String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	public static final String VERSION = "$Id: BrowserImpl.java 117333 2014-12-18 09:12:21Z SachinVellanki $";
	private static final String CS_IMPL_OPERATOR_MENU_XPATH = "//i[contains(@title,'CS') or contains(@title,'CA') or contains(@title,'Mike Jones') or contains(@title,'socialqa') or contains(@title,'SocialQAAdmin') or contains(@title,'Chat')]";
	private static final String CS_IP_OPERATOR_MENU_XPATH = "//*[contains(@data-click,'CPMInteractionPortalUserMenu')]/div/i";
	private static final String CS_IMPL_LOG_OFF_XPATH = "//*[contains(@data-click,'cpmLogOff')]//span[text()='Logout']";
	private static final String CS_IMPL_LOGIN_ID = "txtUserID";
	private PegaWebDriver pegaDriver = null;
	private static final String CS_SOCIAL_OPERATORID_XPATH = "//span/a[contains(@data-click,'showMenu')]";
	private static final String CS_SOCIAL_IMPL_LOGOFF_XPATH = "//span[@class='menu-item-title' and text()='Log off' or @class='menu-item-title' and text()='Logout']";
	private static final String CS_SOCIAL_OPERATOR_XPATH = "//i[@title='CA Sys Admin']";
	private static final String DAN_LOGOFF_XPATH = "//div/i[@title='Dan Percival']";

	// Research Interaction Xpaths
	private static final String RESEARCH_SEARCH_XPATH = "//button[@title='Search']";
	private static final String RESEARCH_CITY_XPATH = "//input[@title='Search city']";
	private static final String RESEARCH_STATE_XPATH = "//input[@title='Search state']";

	private static final String SA_PORTAL_CREATE_CONTACT_XPATH = "//button[@class='Strong pzhc pzbutton' and text()='Create Contact']";

	public static String CaseID = null;

	private TestEnvironment testEnv = null;
	String Txt_KMSearch_Id = "KMSearchText";
	String Btn_KMSearch_Xpath = "//i[@title='Search for Articles']";

	public BrowserImpl(TestEnvironment testEnv) {
		super(testEnv);
		this.testEnv = testEnv;
		this.pegaDriver = testEnv.getPegaDriver();

	}

	@Override
	public <T extends Portal> T getPortal(Class<T> type) {
		T portal = null;
		String className = type.getName();
		if (className.contains("CSPortal")) {
			portal = type.cast(new CSPortalImpl(testEnv));
		}
		/*if (className.contains("DesignerStudio")) {
			portal = type.cast(new DesignerStudioImpl(testEnv));
		}*/
		if (className.contains("SFAPortal")) {
			portal = type.cast(new SFAPortalImpl(testEnv));
		}
		if (className.contains("PMPortal")) {
			portal = type.cast(new PegaPMPortal(testEnv));
		} else if (className.contains("PegaExpressPortal")) {
			portal = type.cast(new PegaExpressPortal(testEnv));
		} else if (className.contains("DesignerStudio")) {
			portal = type.cast(new PegaDesignerStudio(testEnv));
		}
		return portal;
	}

	@Override

	public void logout() {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(CS_IMPL_OPERATOR_MENU_XPATH)).click(false);
		// pegaDriver.findElement(By.xpath(CS_IP_OPERATOR_MENU_XPATH)).click(false);
		pegaDriver.switchTo().defaultContent();
		// List<WebElement> list =
		// pegaDriver.findElements(By.xpath(CS_IMPL_LOG_OFF_XPATH));
		pegaDriver.findElement(By.xpath(CS_IMPL_LOG_OFF_XPATH)).click(false);
		// list.get(list.size() - 1).click();
		try {
			// pegaDriver.waitForDocStateReady(1);
			
			pegaDriver.handleWaits().waitForAlert();
			pegaDriver.switchTo().alert().accept();
			
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		// pegaDriver.handleWaits().waitForElementVisibility(By.id(CS_IMPL_LOGIN_ID));

	}

	


	public void switchBetweenPortal(String portal) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchTo().defaultContent();

		if (portal.equalsIgnoreCase("Pega Sales Automation Sample Application")) {
			pegaDriver.findElement(By.xpath(CS_IMPL_OPERATOR_MENU_XPATH)).click(false);
		}
		else if (portal.equalsIgnoreCase("Customer Service")) {
			pegaDriver.findElement(By.xpath("//div/i[@title='Mike Jones']")).click(false);

		}
		pegaDriver.switchTo().defaultContent();
		PegaWebElement element = pegaDriver
				.findElement(By.xpath("//span[@class='menu-item-title' and contains(text(),'Switch apps')]"));
		testEnv.getScriptExecutor().mouseOver(element);
		pegaDriver.findElement(By.xpath("//span[contains(text(),'" + portal + "')]")).click();

	}

	public void clickOnMessageButton() {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);
		PegaWebElement message = pegaDriver.findElement(By.xpath("//span/a[@title='Create new Alert Message']"));
		message.click();
	}

	public void switchToTab(String tabname) {
		pegaDriver.switchToActiveFrame();
		frameId = pegaDriver.getActiveFrameId(false);
		newWizard = pegaDriver.findWizard(frameId);

		String InitialXPATH = "//h2[@class='layout-group-item-title' and text()='#replaceString#']";
		String FinalXPATH = new String(InitialXPATH).replace("#replaceString#", tabname);
		pegaDriver.waitForDocStateReady(3);
		PegaWebElement switchToTab = pegaDriver.findElement(By.xpath(FinalXPATH));
		switchToTab.click();
	}

	public void selectUserFromSearch(String name) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		PegaWebElement searchBox = pegaDriver.findElement(By.xpath("//input[@data-test-id='201412051240450752263510']"));
		searchBox.sendKeys(name);

		PegaWebElement filterButton = pegaDriver.findElement(By.xpath("//button[@data-test-id='20141205124045075426774']"));
		filterButton.click();
		pegaDriver.waitForDocStateReady(2);

		String InitialXPATH = "//span/a[contains(text(),'#namestring#')]";
		String FinalXPATH = new String(InitialXPATH).replace("#namestring#", name);

		PegaWebElement userName = pegaDriver.findElement(By.xpath(FinalXPATH));
		userName.click();
	}

	public void unFollowCase(String unfollow) {
		pegaDriver.waitForDocStateReady(3);

		String XPath = "//span/a[contains(text(),'#count#')]";
		String finalXPath = new String(XPath).replace("#count#", unfollow);

		PegaWebElement unfollowCase = pegaDriver.findElement(By.xpath(finalXPath));
		unfollowCase.click();
	}

	public void openKnowledgeContent() {
		pegaDriver.switchTo().defaultContent();

		PegaWebElement knowledgeIcon = pegaDriver
				.findElement(By.xpath("(//i[contains(@data-click,'CSToggleKMUI')])[2]"));// Removed
																							// space
																							// at
																							// end
		if (knowledgeIcon.isVisible()) {
			knowledgeIcon.click();
		} else {
			pegaDriver.findElement(By.xpath("(//i[contains(@data-click,'CSToggleKMUI')])[1]")).click();
		}
	}

	public void selectRatedArticle(String name) {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		String XPath = "//a[text()='#count#']";
		String finalXPath = new String(XPath).replace("#count#", name);
		pegaDriver.handleWaits().waitForElementVisibility(By.xpath(finalXPath));
		PegaWebElement articleName = pegaDriver.findElement(By.xpath(finalXPath));
		articleName.click();
	}

	public void searchKMArticle(String ArticleName) {
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.id("KMSearchText")).click();
		pegaDriver.findElement(By.id("KMSearchText")).sendKeys(ArticleName);
		pegaDriver.switchTo().activeElement().sendKeys(Keys.ENTER);
		// pegaDriver.findElement(By.xpath("//i[@title='Search for
		// Articles']")).click();

	}

	public void clickOnIconsinKM(String iconName) {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();

		String XPath = "//i[@title='#count# article']";
		String finalXPath = new String(XPath).replace("#count#", iconName);
		PegaWebElement articleName = pegaDriver.findElement(By.xpath(finalXPath));
		if (articleName.isVisible()) {
			articleName.click();
		} else {
			pegaDriver.findElement(By.xpath("//i[@title='" + iconName + "d article']"));
		}
	}

	public void clickOnPopoutIcon() {
		PegaWebElement popOutButton = pegaDriver.findElement(By.xpath("//i[@title='Pop out the article']"));
		popOutButton.click(false);
		testEnv.getBrowser().switchToWindow(2);
	}

	public void shareArticle() {
		WebDriverWait wait = new WebDriverWait(pegaDriver, 30);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='Cancel']")));

		PegaWebElement cancelShare = pegaDriver.findElement(By.xpath("//button[@id='Cancel']"));
		cancelShare.click();
	}

	public void submitFeedback() {
		PegaWebElement comments = pegaDriver.findElement(By.id("SuggestedContentNote"));
		comments.sendKeys("This is Feedback to the article.");

		PegaWebElement sendFeedback = pegaDriver.findElement(By.xpath("//button[@id='ModalButtonSubmit']"));
		sendFeedback.click();
	}

	public void selectLinkUnderShareandFeedback(String linkName) {
		String initialXPATH = "//a[text()='#sericecase#']";
		String finalXPath = new String(initialXPATH).replace("#sericecase#", linkName);
		PegaWebElement mailArticle = pegaDriver.findElement(By.xpath(finalXPath));
		mailArticle.click();

	}

	public void selectandSearchResearchType(String searchType, String value) {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		pegaDriver.switchTo().defaultContent();
		
		

		DropDown selectType = pegaDriver
				.findSelectBox(By.xpath(TopNav.SELECT_DATA_SOURCE_XPATH));
		selectType.selectByValue(searchType);

		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(TopNav.SEARCH_BOX_XPATH)).sendKeys(Keys.CLEAR);
		pegaDriver.findElement(By.xpath(TopNav.SEARCH_BOX_XPATH)).sendKeys(value);
		pegaDriver.findElement(By.xpath(TopNav.SEARCH_ITEM_XPATH)).click();

	}

	public void filterwithInitialValues(String searchBox, String searchString) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		String initialXPath = "//input[@title='Search #Issue#']";
		String finalXPath = new String(initialXPath).replace("#Issue#", searchBox);

		PegaWebElement searchtype = pegaDriver.findElement(By.xpath(finalXPath));
		searchtype.sendKeys(searchString);

		pegaDriver.waitForDocStateReady(10);
		pegaDriver.switchToActiveFrame();

		if (searchString.equalsIgnoreCase("123450000")) {
			PegaWebElement searchButton = pegaDriver.findElement(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.click();
		} else if (searchString.equalsIgnoreCase("Acme Software")) {
			PegaWebElement searchButton = pegaDriver.findElement(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.click();
		} else if (searchString.equalsIgnoreCase("Rebecca")) {
			List<WebElement> searchButton = pegaDriver.findElements(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.get(0).click();
		} else if (searchString.equalsIgnoreCase("Credit Card Fees & Charges")) {
			PegaWebElement searchButton = pegaDriver.findElement(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.click();
		} else if (searchString.equalsIgnoreCase("12457890")) {
			PegaWebElement searchButton = pegaDriver.findElement(By.xpath(RESEARCH_SEARCH_XPATH));
			searchButton.click();
		}

	}

	public void clearFilter() {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		PegaWebElement clearButton = pegaDriver.findElement(By.xpath("//button[@title='Clear']"));
		clearButton.click();

		pegaDriver.waitForDocStateReady(3);

	}

	public void filterWithAllForAccount(String AcNo, String Type, String Status, String OwnerName) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		PegaWebElement accountNumber = pegaDriver.findElement(By.xpath("//input[@title='Search account number']"));
		accountNumber.sendKeys(AcNo);

		PegaWebElement accountType = pegaDriver.findElement(By.xpath("//input[@title='Search account type']"));
		accountType.sendKeys(Type);

		PegaWebElement accountStatus = pegaDriver.findElement(By.xpath("//input[@title='Search status']"));
		accountStatus.sendKeys(Status);

		PegaWebElement accountOwner = pegaDriver.findElement(By.xpath("//input[@title='Search owner first name']"));
		accountOwner.sendKeys(OwnerName);

		pegaDriver.waitForDocStateReady(10);
		pegaDriver.switchToActiveFrame();

		PegaWebElement searchButton = pegaDriver.findElement(By.xpath(RESEARCH_SEARCH_XPATH));
		searchButton.click();

	}

	public void filterWithAllValuesForOrganization(String Name, String Type, String TaxID, String Industry,
			String Country, String City, String State) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		PegaWebElement orgName = pegaDriver.findElement(By.xpath("//input[@title='Search organization name']"));
		orgName.sendKeys(Name);

		//PegaWebElement orgType = pegaDriver.findElement(By.xpath("//input[@title='Search organization type']"));
		//orgType.sendKeys(Type);

		PegaWebElement orgInd = pegaDriver.findElement(By.xpath("//input[@title='Search industry']"));
		orgInd.sendKeys(Industry);

		PegaWebElement orgCountry = pegaDriver.findElement(By.xpath("//input[@title='Search country']"));
		orgCountry.sendKeys(Country);

		PegaWebElement orgCity = pegaDriver.findElement(By.xpath(RESEARCH_CITY_XPATH));
		orgCity.sendKeys(City);

		PegaWebElement orgState = pegaDriver.findElement(By.xpath(RESEARCH_STATE_XPATH));
		orgState.sendKeys(State);

		PegaWebElement orgTaxId = pegaDriver.findElement(By.xpath("//input[@title='Search taxonomy Id']"));
		orgTaxId.sendKeys(TaxID);

		pegaDriver.waitForDocStateReady(10);
		pegaDriver.switchToActiveFrame();
		PegaWebElement searchButton = pegaDriver.findElement(By.xpath(RESEARCH_SEARCH_XPATH));
		searchButton.click();

	}

	public void filterWithAllValuesForIndividual(String Fname, String Lname, String mail,
			String City, String State) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		PegaWebElement firstName = pegaDriver.findElement(By.xpath("//input[@title='Search first name']"));
		firstName.sendKeys(Fname);

		PegaWebElement lastName = pegaDriver.findElement(By.xpath("//input[@title='Search last name']"));
		lastName.sendKeys(Lname);

		//PegaWebElement OrgName = pegaDriver.findElement(By.xpath("//input[@title='Search organization name']"));
		//OrgName.sendKeys(Org);

		//PegaWebElement phoneNumber = pegaDriver.findElement(By.xpath("//input[@title='Search Phone number']"));
		//phoneNumber.sendKeys(PhNo);

		PegaWebElement mailId = pegaDriver.findElement(By.xpath("//input[@title='Search Email']"));
		mailId.sendKeys(mail);

		PegaWebElement indState = pegaDriver.findElement(By.xpath(RESEARCH_STATE_XPATH));
		indState.sendKeys(State);

		PegaWebElement indCity = pegaDriver.findElement(By.xpath(RESEARCH_CITY_XPATH));
		indCity.sendKeys(City);

		pegaDriver.waitForDocStateReady(10);
		pegaDriver.switchToActiveFrame();
		List<WebElement> searchButton = pegaDriver.findElements(By.xpath(RESEARCH_SEARCH_XPATH));
		searchButton.get(0).click();

	}

	public void filterWithAllValuesForContent(String article, String Content, String Average, String Views) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		PegaWebElement articleTitle = pegaDriver.findElement(By.xpath("//input[@title='Search content title']"));
		articleTitle.sendKeys(article);

		PegaWebElement contentType = pegaDriver.findElement(By.xpath("//input[@title='Search content type']"));
		contentType.sendKeys(Content);

		PegaWebElement averageRating = pegaDriver
				.findElement(By.xpath("//input[@title='Search average rating greater than']"));
		averageRating.sendKeys(Average);

		PegaWebElement contentViews = pegaDriver
				.findElement(By.xpath("//input[@title='Search content views greater than']"));
		contentViews.sendKeys(Views);

		pegaDriver.waitForDocStateReady(10);
		pegaDriver.switchToActiveFrame();

		PegaWebElement searchButton = pegaDriver.findElement(By.xpath(RESEARCH_SEARCH_XPATH));
		searchButton.click();

	}

	public String CaseIDOfInteraction() {
		/*
		 * PegaWebElement toolsButton = pegaDriver.findElement(By.xpath(
		 * "//button[@title='Tools Menu']")); toolsButton.click(false); //String
		 * caseId = null; // String parentHandle = driver.getWindowHandle();
		 * PegaWebElement viewHistory = pegaDriver.findElement(By.xpath(
		 * "//span[text()='History and Attachments']")); viewHistory.click();
		 * testEnv.getBrowser().switchToWindow(2);
		 * 
		 * /*PegaWebElement id = pegaDriver.findElement(By.xpath(
		 * "//span[contains(text(),'I-') or contains(text(),'S-')]"));
		 */
		/*
		 * String idOfCase = pegaDriver.findElement(By .xpath(
		 * "//span[contains(text(),'I-') or contains(text(),'S-')]")).getText();
		 * //caseId = id.getText(); //PegaWebElement closeButton =
		 * pegaDriver.findElement(By.xpath(
		 * "//td[@id='HeaderButtonIconsTDId']//*[@title='Cancel ']"));
		 * //closeButton.click(false); testEnv.getBrowser().close();
		 * testEnv.getBrowser().switchToWindow(1); System.out.println(idOfCase);
		 * CaseID = idOfCase.trim(); System.out.println(CaseID); return CaseID;
		 */

		// Open history pop and get case id -START

		/*PegaWebElement toolsButton = pegaDriver
				.findElement(By.xpath("//button[@title='Tools Menu' or @title='Tools menu' or @title='Help']"));
		toolsButton.click(false);
		PegaWebElement viewHistory = pegaDriver.findElement(By.xpath("//span[text()='History and Attachments']"));
		viewHistory.click();
		testEnv.getBrowser().switchToWindow(2);

		String idOfCase = pegaDriver
				.findElement(
						By.xpath("//span[contains(text(),'I-') or contains(text(),'S-') or contains(text(),'C-')]"))
				.getText();
		testEnv.getBrowser().close();
		testEnv.getBrowser().switchToWindow(1);
		System.out.println(idOfCase);
		CaseID = idOfCase.trim();

		return CaseID;*/

		// Open history pop and get case id -END

		
		frameId = pegaDriver.getActiveFrameId(false); newWizard =
				 pegaDriver.findWizard(frameId);
				 
		String followCaseID =pegaDriver.findElement(By.xpath("//span[@data-test-id='20160210082412023111408']")).getText();
				 System.out.println(followCaseID);
				 CaseID = followCaseID.substring(1, followCaseID.length() - 1); 
				 
				  CaseID= CaseID.trim(); 
				  System.out.println(CaseID); return CaseID;
				 
	}
	public String CaseIDOfChatInteraction() {
		frameId = pegaDriver.getActiveFrameId(false); 
		 newWizard = pegaDriver.findWizard(frameId);
		 
		//pegaDriver.switchTo().frame(pegaDriver.findElement(By.id("PegaGadget0Ifr")));
		  
		 newWizard.findElement(By.xpath("//h3[@class='layout-group-item-title' and text()='Recent work']")).click();
		 List<WebElement> list =newWizard.findElements(By.xpath("//*[@href='#' and contains(@title,'Open Work Object') and contains(text(),'I-')]"));
		 String followCaseID =list.get(0).getText();
		 System.out.println(followCaseID);
		//CaseID = followCaseID.substring(1, followCaseID.length() - 1); 
		  CaseID=followCaseID;
		  CaseID= CaseID.trim(); 
		  System.out.println(CaseID); 
		  return CaseID;
	
	}
	
	public String CaseIDOfInteractionfromHistory() {
		/*
		 * PegaWebElement toolsButton = pegaDriver.findElement(By.xpath(
		 * "//button[@title='Tools Menu']")); toolsButton.click(false); //String
		 * caseId = null; // String parentHandle = driver.getWindowHandle();
		 * PegaWebElement viewHistory = pegaDriver.findElement(By.xpath(
		 * "//span[text()='History and Attachments']")); viewHistory.click();
		 * testEnv.getBrowser().switchToWindow(2);
		 * 
		 * /*PegaWebElement id = pegaDriver.findElement(By.xpath(
		 * "//span[contains(text(),'I-') or contains(text(),'S-')]"));
		 */
		/*
		 * String idOfCase = pegaDriver.findElement(By .xpath(
		 * "//span[contains(text(),'I-') or contains(text(),'S-')]")).getText();
		 * //caseId = id.getText(); //PegaWebElement closeButton =
		 * pegaDriver.findElement(By.xpath(
		 * "//td[@id='HeaderButtonIconsTDId']//*[@title='Cancel ']"));
		 * //closeButton.click(false); testEnv.getBrowser().close();
		 * testEnv.getBrowser().switchToWindow(1); System.out.println(idOfCase);
		 * CaseID = idOfCase.trim(); System.out.println(CaseID); return CaseID;
		 */

		
		// Open history pop and get case id -START
		
		PegaWebElement toolsButton = pegaDriver
				.findElement(By.xpath("//button[@title='Other actions' or @title='Help']"));
		toolsButton.click(false);
		
		/*List<WebElement> listElements = pegaDriver.findElements(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH));

		for (WebElement element : listElements){

		    if(element.isDisplayed() && element.isEnabled()){

		    	//pegaDriver.handleWaits().waitForElementClickable(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH));
		        WebDriverWait wait = new WebDriverWait(pegaDriver, 2); 
		        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PhoneCall.HISTORY_ATTACHMENTS_XPATH)));
		        element.click();
		    }
		}*/

		
		PegaWebElement viewHistory = pegaDriver.findElement(By.xpath("//span[text()='History and Attachments']"));
		viewHistory.click();
		testEnv.getBrowser().switchToWindow(2);

		
		String idOfCase = pegaDriver
				.findElement(
						By.xpath("//span[contains(text(),'I-') or contains(text(),'S-') or contains(text(),'C-')]"))
				.getText();
		testEnv.getBrowser().close();
		testEnv.getBrowser().switchToWindow(1);
		System.out.println(idOfCase);
		CaseID = idOfCase.trim();

		return CaseID;

		// Open history pop and get case id -END

		/*
		 * frameId = pegaDriver.getActiveFrameId(false); newWizard =
		 * pegaDriver.findWizard(frameId);
		 * 
		 * String followCaseID =
		 * pegaDriver.findElement(By.xpath("//div[@id='CT']/span")).getText();
		 * System.out.println(followCaseID);
		 * CaseID = followCaseID.substring(1, followCaseID.length() - 1); 
		 * 
		 * CaseID= CaseID.trim(); System.out.println(CaseID); return CaseID;
		 */
	}

	public void searchCaseswithPreviousCaseID(String searchType) {
		pegaDriver.waitForDocStateReady(90);
		pegaDriver.switchTo().defaultContent();

		DropDown selectType = pegaDriver.findSelectBox(By.xpath(TopNav.SELECT_DATA_SOURCE_XPATH));
		selectType.selectByValue(searchType);

		pegaDriver.waitForDocStateReady(90);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(TopNav.SEARCH_BOX_XPATH)).clear();
		pegaDriver.findElement(By.xpath(TopNav.SEARCH_BOX_XPATH)).sendKeys(CaseID);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath(TopNav.SEARCH_ITEM_XPATH)).click();
		

	}

	public void filterusingPreviousCaseID() {
		pegaDriver.waitForDocStateReady(90);
		pegaDriver.switchToActiveFrame();

		PegaWebElement articleTitle = pegaDriver.findElement(By.xpath("//input[@title='Search case ID']"));
		articleTitle.sendKeys(CaseID);

		pegaDriver.waitForDocStateReady(80);
		pegaDriver.switchToActiveFrame();

		List<WebElement> searchButton = pegaDriver.findElements(By.xpath(RESEARCH_SEARCH_XPATH));
		searchButton.get(0).click();

	}

	public ResearchInteraction selectthePreviousCaseID() {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		//PegaWebElement selectAccount = pegaDriver.findElement(By.xpath("//span[contains(text(),'" + CaseID + "')]"));
		//selectAccount.click();
		PegaWebElement selectAccount = pegaDriver.findElement(By.xpath("//span[contains(text(),'"+CaseID+"')]/../../../td[@class=' gridCell ']//*[@aria-haspopup='true' and contains(@data-click,'CPMSearchResultMenu')]"));
		selectAccount.click(false);
		PegaWebElement startresearch=pegaDriver.findElement(By.xpath("//span[contains(text(),'Start research')]"));
		startresearch.click();
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		ResearchInteraction researchInteraction = new ResearchInteractionImpl(frameElmt, frameId);
		researchInteraction._setEnvironment(testEnv, frameId);
		return researchInteraction;

	}

	public void searchWithAllUsingCaseID(String interactionType) {

		pegaDriver.switchTo().defaultContent();
		pegaDriver.waitForDocStateReady(90);
		pegaDriver.switchTo().defaultContent();
		// pegaDriver.findElement(By.xpath("//input[@id='pySearchText']")).sendKeys(Keys.CLEAR);
		PegaWebElement searchdropdown = pegaDriver.findElement(By.xpath("//select[@title='Search results for']"));
		List<WebElement> options = searchdropdown.findElements(By.tagName("option"));
		options.get(5).click();

		/*// Open history pop and get case id -START

		PegaWebElement toolsButton = pegaDriver
				.findElement(By.xpath("//button[@title='Tools Menu' or @title='Tools menu' or @title='Help']"));
		toolsButton.click(false);
		PegaWebElement viewHistory = pegaDriver.findElement(By.xpath("//span[text()='History and Attachments']"));
		viewHistory.click();
		testEnv.getBrowser().switchToWindow(2);

		String idOfCase = pegaDriver
				.findElement(
						By.xpath("//span[contains(text(),'I-') or contains(text(),'S-') or contains(text(),'C-')]"))
				.getText();
		testEnv.getBrowser().close();
		testEnv.getBrowser().switchToWindow(1);
		System.out.println(idOfCase);
		String cID = idOfCase.trim();

		// Open history pop and get case id -END
*/
		pegaDriver.findElement(By.xpath(TopNav.SEARCH_BOX_XPATH)).sendKeys(CaseID);
		pegaDriver.waitForDocStateReady(90);
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(By.xpath("//i[@title='Search for an item'][@class='icons pi pi-search-2 pi-regular']")).click();
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		//PegaWebElement searchTypeTab = pegaDriver.findElement(By.xpath("//h3[@class='layout-group-item-title'][text()='" + interactionType + "']"));
		//searchTypeTab.click();

	}

	public void filterWithAllValuesForCases(String desc, String AcNo, String CName, String Status) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();

		PegaWebElement articleTitle = pegaDriver.findElement(By.xpath("//input[@title='Search case ID']"));
		articleTitle.sendKeys(CaseID);

		PegaWebElement caseDescription = pegaDriver.findElement(By.xpath("//input[@title='Search description']"));
		caseDescription.sendKeys(desc);

		PegaWebElement caseAcNo = pegaDriver.findElement(By.xpath("//input[@title='Search account number']"));
		caseAcNo.sendKeys(AcNo);

		PegaWebElement caseCustName = pegaDriver.findElement(By.xpath("//input[@title='Search customer name']"));
		caseCustName.sendKeys(CName);

		PegaWebElement caseStatus = pegaDriver.findElement(By.xpath("//input[@title='Search status']"));
		caseStatus.sendKeys(Status);

		List<WebElement> searchButton = pegaDriver.findElements(By.xpath(RESEARCH_SEARCH_XPATH));
		searchButton.get(3).click();

	}

	public void clickCreateContactSAPortal() {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		PegaWebElement createContact = pegaDriver.findElement(By.xpath(SA_PORTAL_CREATE_CONTACT_XPATH));
		createContact.click();

	}

	public void CreateContactMandatoryDetailsSAPortal(String FirstName, String LastName) {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		PegaWebElement FN = pegaDriver.findElement(By.xpath("//input[@id='FirstName']"));
		FN.sendKeys(FirstName);

		PegaWebElement LN = pegaDriver.findElement(By.xpath("//input[@id='LastName']"));
		LN.sendKeys(LastName);

		PegaWebElement submitButton = pegaDriver
				.findElement(By.xpath("//button[@class='Strong pzhc pzbutton' and text()='Create']"));
		submitButton.click();

	}
	
	public void forPreviousCaseID() {
		pegaDriver.waitForDocStateReady(3);
		pegaDriver.switchToActiveFrame();
		//PegaWebElement selectAccount = pegaDriver.findElement(By.xpath("//span[contains(text(),'" + CaseID + "')]"));
		//selectAccount.click();
		PegaWebElement selectAccount = pegaDriver.findElement(By.xpath("//span[contains(text(),'"+CaseID+"')]/../../../td[@class=' gridCell ']//*[@aria-haspopup='true' and contains(@data-click,'CPMSearchResultMenu')]"));
		selectAccount.click(false);
		PegaWebElement initiatecall=pegaDriver.findElement(By.xpath("//span[contains(text(),'Initiate a call')]"));
		initiatecall.click();
		String frameId = pegaDriver.getActiveFrameId(false);
		WebElement frameElmt = pegaDriver.findElement(By.id(frameId)).getWebElement();
		pegaDriver.switchTo().frame(frameElmt);
		ResearchInteraction researchInteraction = new ResearchInteractionImpl(frameElmt, frameId);
		researchInteraction._setEnvironment(testEnv, frameId);
		

	}

	public void selectorgFromSearch(String name) {
		pegaDriver.waitForDocStateReady(2);
		pegaDriver.switchToActiveFrame();
		PegaWebElement searchBox = pegaDriver.findElement(By.xpath("//input[@data-test-id='20141222052109006713340']"));
		searchBox.sendKeys(name);

		PegaWebElement filterButton = pegaDriver.findElement(By.xpath("//button[@data-test-id='201412220521090069137274']"));
		filterButton.click();
		pegaDriver.waitForDocStateReady(2);

		String InitialXPATH = "//span/a[contains(text(),'#namestring#') and @title='Organization name']";
		String FinalXPATH = new String(InitialXPATH).replace("#namestring#", name);

		PegaWebElement orgName = pegaDriver.findElement(By.xpath(FinalXPATH));
		orgName.click();
	}
	
}

