
package com.pega.crm.pegamarketing.rules;

import org.openqa.selenium.By;

import com.pega.crm.pegamarketing.dialog.ConfigureAudienceDialog;
import com.pega.crm.pegamarketing.dialog.ConfigureDialog;
import com.pega.crm.pegamarketing.dialog.ConfigureOfferDialog;
import com.pega.crm.pegamarketing.dialog.ModalDialog;
import com.pega.crm.pegamarketing.pages.Strategy;
import com.pega.crm.pegamarketing.utils.PMXPathUtil;

public interface MarketingStrategy extends RuleInstance {
	By STRATEGY_NAME_INPUT = By.xpath("//input[@data-test-id='2016111816494007041082699']");
	By CONFIGUE_OBJECTIVE_BUTTON = By.xpath("//a[contains(@data-click,'ConfigureStrategyBuilderObjective')]");
	By CONFIGUE_AUDIENCE_DRIVER_BUTTON = By.xpath("//a[contains(@data-click,'LaunchAudienceCardSelector')]");
	By ERROR_MESSAGE = By.xpath("//span[@id='ERRORMESSAGES_ALL']");
	By DESCRIPTION_INPUT = By.xpath("//input[@data-test-id='20151130101537089747559']");
	By BUSINESS_ISSUE_DROPDOWN = By.xpath("//*[@data-test-id='20150219170431021835250']");//  id("IssueClass");
	By CONFIGURE_PRIORITY_BUTTON = By.xpath("//a[contains(@data-click,'ConfigurePriorityCalculation')]");
	By PRIORITIZATION_DROPDOWN = By.xpath("//select[contains(@name,'PrioritizationType')]");
	By PROPERTY_NAME_INPUT = By.xpath("//input[contains(@name,'PropertyName')]");
	By ADD_TARGETING_APPROACH_LINK = By.xpath("//a[contains(@data-click,'LaunchConfigureTargetingModal')]");
	By ASSIGN_OFFERS_BUTTON = By.xpath("//a[contains(@data-click,'LaunchOfferCardSelector')]");
	By ACTIONS_BUTTON = By.xpath("//button[text()='Actions']");
	By OPEN_CANVAS_BUTTON = By.xpath(PMXPathUtil.getMenuItemXPath("Open canvas"));
	By SEARCHSTRATEGY = By.xpath("//*[@data-test-id='20160202134136053752179']");
	By VIEW_BTN = By.xpath("//*[@type='button'][contains(text(),'View')]");
	By ALLCATEGORIESLINK =By.xpath("//a[contains(text(),'All categories')]");

	/**
	 * It will open configure priority dialog
	 * 
	 * @return It will return Configure Priority Dialog
	 */
	ConfigurePriorityDialog configurePriority();

	/**
	 * This will edit prioritization with given prioritization name and
	 * prioritization value
	 * 
	 * @param prioritizationName
	 * @param prioritizationValue
	 */
	void editPrioritization(String prioritizationName, String prioritizationValue);

	/**
	 * It is used for getting reference of CofigureObjectiveDialog
	 * 
	 * @return It will return Configure Objective Dialog
	 */
	ConfigureObjectiveDialog configureObjective();

	/**
	 * This method is for entering strategy name
	 * 
	 * @param strategyName
	 */
	void setStrategyName(String strategyName);

	/**
	 * This method is for entering description
	 * 
	 * @param description
	 */
	void setDescription(String description);

	/**
	 * It is used to check the group checkbox with the name specifiedr
	 * 
	 * @param issueName
	 */
	void setIssue(String issueName);
	/**
	 * It is used to check the group checkbox with the name specifiedr
	 * 
	 * @param groupName
	 */
	void setGroup(String groupName);

	/**
	 * This method is used to open Configure Audience dialog
	 * 
	 * @return
	 */
	ConfigureAudienceDialog configureAudience();

	/**
	 * This methods is used to select Audience Driven as Targeting approach
	 */
	void addAudianceDrivenTargetingApproach();

	/**
	 * This method is used to open Configure Offer dialog
	 * 
	 * @return
	 */
	ConfigureOfferDialog assignOffers();

	/**
	 * This method is used to open canvas view for the strategy
	 * 
	 * @return
	 */
	Strategy openCanvas();

	public interface ConfigureObjectiveDialog extends ConfigureDialog {
		By PRIORITIZATION_ADD_BUTTON = By.xpath(
				"//div[@node_name='SimpleSelectorCardContent'][.//span[@class='mktcard_secondary_info' and text()='PRIORITIZATION']]//button[text()='Add']");
		By RANKED_ADD_BUTTON = By.xpath(
				"//div[@node_name='SimpleSelectorCardContent'][.//span[@class='mktcard_secondary_info' and text()='RANKED']]//button[text()='Add']");
		By RANKED_REMOVE_BUTTON = By.xpath(
				"//div[@node_name='SimpleSelectorCardContent'][.//span[@class='mktcard_secondary_info' and text()='RANKED']]//button[text()='Remove']");
		By RANKED_ADDED_LABEL = By.xpath(
				"//tr[contains(@id,'ComponentOverview_RANKED')]//a[text()='Offer targeting using Audiences and AI']");
		By PRIORITIZATION_DIVISON = By
				.xpath("//span[contains(text(),'PRIORITIZATION') and @class='mktcard_secondary_info']");

		MarketingStrategy applyPrioritizationOffer();

		void addPrioritizationOffer();

		/**
		 * It is used to add a ranked objective
		 */
		void addRankedObjective();

		/**
		 * it is used to verify if ranked is added in the modal dialog
		 * 
		 * @return
		 */
		boolean isRankedAdded();
	}

	public interface ConfigurePriorityDialog extends ConfigureDialog {
		static By RAWPROPPENSITY_DIV = By
				.xpath("//span[contains(text(),'RawPropensity') and @class='mktcard_secondary_info']");
		static By RAWPROPPENSITY_ADD = By.xpath(
				"//div[@node_name='SimpleSelectorCardContent'][.//span[@class='mktcard_secondary_info' and text()='RawPropensity']]//button[text()='Add']");

		/**
		 * This will apply priority to strategy
		 * 
		 * @return It will return Marketing Strategy page
		 */
		MarketingStrategy applyPriority();

		/**
		 * This will add priority
		 */
		void addPriority();

	}

	public interface AddTargetingDialog extends ModalDialog {
		By AUDIENCE_DRIVEN_RADIO = By.xpath("//label[@for='AudienceTargetingSEGMENTATION']");

		/**
		 * This will check Audience Driven option
		 */
		void checkAudienceDriven();
	}

	String getthenameofstrategy();

	void searchstrategies(String strategy1, String strategy2);

}
