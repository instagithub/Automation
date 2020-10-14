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
import com.pega.crm.pegamarketing.utils.ObjectsBean;
import com.pega.framework.PegaWebDriver;
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
		findSelectBox(BUSINESS_ISSUE_DROPDOWN).selectByVisibleText(issueName);
	}

	public void setGroup(String groupName) {
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
		Frame frame;
		PegaWebDriver pegaDriver;

		public PegaConfigureObjectiveDialog(Frame aElmt) {
			super(aElmt);
			this.frame = aElmt;
			pegaDriver = frame.getTestEnvironment().getPegaDriver();
		}

		public void addRankedObjective() {
			findElement(RANKED_ADD_BUTTON).click();
			pegaDriver.handleWaits().sleep(15);
		}

		public MarketingStrategy applyPrioritizationOffer() {
			findElement(APPLY_BUTTON).click(false);
			String frameId = pegaDriver.getActiveFrameId(true);
			MarketingStrategy strategy = new PegaMarketingStrategy(frameId, testEnv);
			return strategy;
		}

		public void addPrioritizationOffer() {
			findElement(PRIORITIZATION_DIVISON).click();
			findElement(PRIORITIZATION_ADD_BUTTON).click();
		}

		public boolean isRankedAdded() {
			boolean isRemoveFound = verifyElement(RANKED_REMOVE_BUTTON);
			boolean isRankedObjectiveFound = verifyElement(RANKED_ADDED_LABEL);
			boolean isDeleteButtonFound = verifyElement(DELETE_ICON);
			return isRemoveFound && isRankedObjectiveFound && isDeleteButtonFound;
		}

	}

	public class PegaConfigurePriorityDialog extends PegaConfigureDialog implements ConfigurePriorityDialog {
		Frame frame;
		PegaWebDriver pegaDriver;

		public PegaConfigurePriorityDialog(Frame aElmt) {
			super(aElmt);
			this.frame = aElmt;
			pegaDriver = frame.getTestEnvironment().getPegaDriver();
		}

		public MarketingStrategy applyPriority() {
			findElement(APPLY_BUTTON).click(false);
			String frameId = pegaDriver.getActiveFrameId(true);
			MarketingStrategy strategy = new PegaMarketingStrategy(frameId, testEnv);
			return strategy;
		}

		public void addPriority() {
			findElement(RAWPROPPENSITY_DIV).click();
			findElement(RAWPROPPENSITY_DIV).click();
		}

	}

	public class PegaAddTargetingDialog extends PegaModalDialog implements AddTargetingDialog {
		Frame frame;
		PegaWebDriver pegaDriver;

		public PegaAddTargetingDialog(Frame aElmt) {
			super(aElmt);
			this.frame = aElmt;
			pegaDriver = frame.getTestEnvironment().getPegaDriver();
		}

		public void checkAudienceDriven() {
			frame.findElement(AUDIENCE_DRIVEN_RADIO).click();
		}
	}

	public String getthenameofstrategy() {
		String reqstring = findElement(By.xpath("//*[@data-test-id='2015051516314605466788']")).getText();
		return reqstring;
	}

	public void selectcategoryLP() {
		findElement(ALLCATEGORIESLINK).click();
		findElement(By.xpath("//div[contains(@datasource,'MKTFilter')]//span[contains(text(),'Sales')]")).click();
	}

	public void searchstrategies(String strategy1, String strategy2) {
		System.out.println("The strategy names are as below:");
		System.out.println(strategy1 + strategy2);
		pegaDriver.handleWaits().waitForElementPresence(SEARCHSTRATEGY);
		selectcategoryLP();
		findElement(SEARCHSTRATEGY).sendKeys(strategy1);
		findElement(VIEW_BTN).click();
		findElement(SEARCHSTRATEGY).clear();
		findElement(SEARCHSTRATEGY).sendKeys(strategy2);
		findElement(VIEW_BTN).click();

	}

}
