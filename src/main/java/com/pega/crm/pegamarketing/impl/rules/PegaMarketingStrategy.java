package com.pega.crm.pegamarketing.impl.rules;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.dialog.ConfigureAudienceDialog;
import com.pega.crm.pegamarketing.dialog.ConfigureOfferDialog;
import com.pega.crm.pegamarketing.impl.dialog.PegaConfigureAudienceDialog;
import com.pega.crm.pegamarketing.impl.dialog.PegaConfigureDialog;
import com.pega.crm.pegamarketing.impl.dialog.PegaConfigureOfferDialog;
import com.pega.crm.pegamarketing.impl.dialog.PegaModalDialog;
import com.pega.crm.pegamarketing.impl.pages.PegaStrategy;
import com.pega.crm.pegamarketing.pages.Strategy;
import com.pega.crm.pegamarketing.rules.MarketingStrategy;
import com.pega.crm.pegamarketing.rules.MarketingStrategy.AddTargetingDialog;
import com.pega.crm.pegamarketing.rules.MarketingStrategy.ConfigureObjectiveDialog;
import com.pega.crm.pegamarketing.rules.MarketingStrategy.ConfigurePriorityDialog;
import com.pega.crm.pegamarketing.utils.ObjectsBean;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;

public class PegaMarketingStrategy extends PegaRuleInstance implements MarketingStrategy {

	public PegaMarketingStrategy(String frameID, TestEnvironment testEnv) {
		super(frameID, testEnv);
	}

	public ConfigureObjectiveDialog configureObjective() {
		findElement(CONFIGUE_OBJECTIVE_BUTTON).click();
		ConfigureObjectiveDialog configObjectiveDialog = new PegaConfigureObjectiveDialog(this);
		return configObjectiveDialog;
	}

	public void setStrategyName(String strategyName) {
		findElement(STRATEGY_NAME_INPUT).sendKeys(strategyName);
	}

	public void setDescription(String description) {
		findElement(DESCRIPTION_INPUT).sendKeys(description);
	}

	public void setIssue(String issueName) {
		pegaDriver.waitForDocStateReady();
		findSelectBox(BUSINESS_ISSUE_DROPDOWN).selectByVisibleText(issueName);
	}

	public void setGroup(String groupName) {
		pegaDriver.waitForDocStateReady();
		findElement(By.xpath("//label[text()='" + groupName + "']/preceding-sibling::input[1]")).click();
	}

	public void addAudianceDrivenTargetingApproach() {
		findElement(ADD_TARGETING_APPROACH_LINK).click();
		AddTargetingDialog addTargetingDialog = new PegaAddTargetingDialog(this);
		addTargetingDialog.checkAudienceDriven();
		addTargetingDialog.apply();
	}

	public void editStrategy(String strategyName, String description) {
		findElement(STRATEGY_NAME_INPUT).sendKeys(ObjectsBean.getTimeStampedValue(strategyName));
		findElement(DESCRIPTION_INPUT).sendKeys(description);
	}

	public void editPrioritization(String prioritizationName, String prioritizationValue) {
		findSelectBox(PRIORITIZATION_DROPDOWN).selectByValue(prioritizationName);
		findElement(PROPERTY_NAME_INPUT).sendKeys(prioritizationValue + Keys.TAB);

	}

	public ConfigurePriorityDialog configurePriority() {
		pegaDriver.waitForDocStateReady();
		findElement(CONFIGURE_PRIORITY_BUTTON).click();
		ConfigurePriorityDialog configObjectiveDialog = new PegaConfigurePriorityDialog(this);
		return configObjectiveDialog;

	}

	public ConfigureAudienceDialog configureAudience() {
		pegaDriver.waitForDocStateReady();
		findElement(CONFIGUE_AUDIENCE_DRIVER_BUTTON).click();
		ConfigureAudienceDialog configAudienceDialog = new PegaConfigureAudienceDialog(this);
		return configAudienceDialog;
	}

	public ConfigureOfferDialog assignOffers() {
		findElement(ASSIGN_OFFERS_BUTTON).click();
		return new PegaConfigureOfferDialog(this);
	}

	public Strategy openCanvas() {
		findElement(ACTIONS_BUTTON).click();
		findElement(OPEN_CANVAS_BUTTON).click();
		String frameId = pegaDriver.getActiveFrameId(true);
		Strategy strategy = new PegaStrategy(frameId, testEnv);
		return strategy;
	}

	public class PegaConfigureObjectiveDialog extends PegaConfigureDialog implements ConfigureObjectiveDialog {
		PegaWebElement elmt;
		PegaWebDriver pegaDriver;

		public PegaConfigureObjectiveDialog(Frame aElmt) {
			super(aElmt);
			this.elmt = aElmt;
			pegaDriver = elmt.getTestEnvironment().getPegaDriver();
		}

		public void addRankedObjective() {
			pegaDriver.findElement(RANKED_ADD_BUTTON).click();
		}

		public MarketingStrategy applyPrioritizationOffer() {
			pegaDriver.findElement(APPLY_BUTTON).click(false);
			String frameId = pegaDriver.getActiveFrameId(true);
			MarketingStrategy strategy = new PegaMarketingStrategy(frameId, testEnv);
			return strategy;
		}

		public void addPrioritizationOffer() {
			pegaDriver.findElement(PRIORITIZATION_DIVISON).click(false);
			pegaDriver.waitForDocStateReady(2);
			pegaDriver.findElement(PRIORITIZATION_ADD_BUTTON).click(false);
			pegaDriver.waitForDocStateReady(2);
		}

		public boolean isRankedAdded() {
			pegaDriver.switchToActiveFrame();
			boolean isRemoveFound = pegaDriver.verifyElement(RANKED_REMOVE_BUTTON);
			boolean isRankedObjectiveFound = pegaDriver.verifyElement(RANKED_ADDED_LABEL);
			boolean isDeleteButtonFound = pegaDriver.verifyElement(DELETE_ICON);
			return isRemoveFound && isRankedObjectiveFound && isDeleteButtonFound;
		}

	}

	public class PegaConfigurePriorityDialog extends PegaConfigureDialog implements ConfigurePriorityDialog {
		PegaWebElement elmt;
		PegaWebDriver pegaDriver;

		public PegaConfigurePriorityDialog(Frame aElmt) {
			super(aElmt);
			this.elmt = aElmt;
			pegaDriver = elmt.getTestEnvironment().getPegaDriver();
		}

		public MarketingStrategy applyPriority() {
			pegaDriver.findElement(APPLY_BUTTON).click(false);
			String frameId = pegaDriver.getActiveFrameId(true);
			MarketingStrategy strategy = new PegaMarketingStrategy(frameId, testEnv);
			return strategy;
		}

		public void addPriority() {
			pegaDriver.findElement(RAWPROPPENSITY_DIV).click(false);
			pegaDriver.waitForDocStateReady();
			pegaDriver.findElement(RAWPROPPENSITY_ADD).click(false);
			pegaDriver.waitForDocStateReady(2);
		}

	}

	public class PegaAddTargetingDialog extends PegaModalDialog implements AddTargetingDialog {
		PegaWebElement elmt;
		PegaWebDriver pegaDriver;

		public PegaAddTargetingDialog(Frame aElmt) {
			super(aElmt);
			this.elmt = aElmt;
			pegaDriver = elmt.getTestEnvironment().getPegaDriver();
		}

		public void checkAudienceDriven() {
			elmt.findElement(AUDIENCE_DRIVEN_RADIO).click();
		}
	}

	public String getthenameofstrategy() {
		String reqstring = pegaDriver.findElement(By.xpath("//*[@data-test-id='2015051516314605466788']")).getText();
		return reqstring;
	}

	public void selectcategoryLP() {
		pegaDriver.findElement(ALLCATEGORIESLINK).click();
		// pegaDriver.handleWaits().waitForElementPresence(By.xpath("//div[contains(@datasource,'MKTFilter')]//span[contains(text(),'Sales')]"));
		pegaDriver.waitForDocStateReady();
		pegaDriver.findElement(By.xpath("//div[contains(@datasource,'MKTFilter')]//span[contains(text(),'Sales')]"))
				.click();
	}

	public void searchstrategies(String strategy1, String strategy2) {
		System.out.println("The strategy names are as below:");
		System.out.println(strategy1 + strategy2);
		pegaDriver.handleWaits().waitForElementPresence(SEARCHSTRATEGY);
		selectcategoryLP();
		// pegaDriver.findElement(SEARCHSTRATEGY).click();
		pegaDriver.findElement(SEARCHSTRATEGY).sendKeys(strategy1);
		pegaDriver.findElement(VIEW_BTN).click();
		pegaDriver.waitForDocStateReady();
		pegaDriver.findElement(SEARCHSTRATEGY).clear();
		pegaDriver.findElement(SEARCHSTRATEGY).sendKeys(strategy2);
		pegaDriver.findElement(VIEW_BTN).click();

	}

}
