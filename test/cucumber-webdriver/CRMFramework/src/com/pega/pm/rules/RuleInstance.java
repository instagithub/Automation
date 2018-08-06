package com.pega.pm.rules;

import org.openqa.selenium.By;

import com.pega.framework.elmt.Frame;
import com.pega.pm.dialog.CategoriesDialog;
import com.pega.pm.utils.PMXPathUtil;
import com.pega.util.XPathUtil;

public interface RuleInstance extends Frame {

	static By RULE_HEADER_LINK = By.xpath("//a[@title='Click to edit' and @class='workarea_header_highlight']");
	static By SAVE_BUTTON = By.xpath("//button[text()='Save'][not(./ancestor::*[contains(@style,'display:none')])]");
	static By RUN_BUTTON = By.xpath("//button[text()='Run']");
	static By SAVEAS_BTN = By.xpath("//button[text()='Save as']");
	static By CLOSE_ICON = By.xpath("//i[contains(@class,'pi pi-close-circle')]");
	static By CREATE_AND_OPEN_BUTTON = By.xpath(PMXPathUtil.getButtonPzBtnMidXPath("Create and open"));
	static By DELETE_BUTTON = By.xpath(PMXPathUtil.getButtonPzhcBtnXPath("Delete"));
	static By EDIT_BUTTON = By.xpath("//button[contains(@class,'pzhc pzbutton') and contains(text(),'Edit')]");
	static By CHECKOUT_BUTTON = By.xpath(PMXPathUtil.getButtonStrongPzhcPzBtnXPath("Check out"));
	static By RULE_NAME_TEXT_BOX = By.id("pyLabel");
	static By ISSUE_SELECT_BOX = By.xpath("//select[@id='IssueClass']|//select[@id='Issue']|//select[@id='pyIssue']");
	static By GROUP_SELECT_BOX = By.xpath("//select[@id='GroupClass']|//select[@id='Group']|//select[@id='pyGroup']");
	static By CUTOMER_RADIO_BUTTON = By.id("c255bd03Customer");
	static By PROSPECT_RADIO_BUTTON = By.id("c255bd03Prospect");
	static By CRITERIA_RADIO_BUTTON = By.xpath("//*[@value='Criteria-based']");
	static By LIST_RADIO_BUTTON = By.xpath("//*[@value='List']");
	static By ANALYSIS_PROJECT_SELECT_BOX = By.id("AnalysisProjectName");
	static By DEV_BRANCH_SELECT_BOX = By.id("pySelectedBranchIdentifier");
	static By CREATE_AND_OPEN_SELECT_BOX = By.xpath(XPathUtil.getButtonPzBtnMidXPath("Create and open"));
	static By SUBMIT_BUTTON = By.xpath(XPathUtil.getButtonStrongPzhcPzBtnXPath("Submit"));
	static By BUDGET_INPUT_BOX = By.xpath("//input[@id='Budget']");
	static By CREATE_BUTTON = By.xpath(PMXPathUtil.getButtonStrongPzhcPzBtnXPath("Create")); 
	static By ACTION_BUTTON = By.xpath(PMXPathUtil.getButtonpzButtonXpath("Actions") + "|" + PMXPathUtil.getButtonPzBtnMidXPath("Actions")) ;
	static By RUN_LINK = By.xpath("//ul[contains(@style,'block')]//span[text()='Run']|//div[@class='pzbtn-mid' and text()='Run']");
	static By CATEGORY_LINK = By.xpath("//a[contains(text(),'View Categories ')]");
	/**
	 * this method will save the rule
	 */
	void save();
	/**
	 * this method will edit the rule
	 * @return 
	 */
	CategoriesDialog clickoncategory();
	/**
	 * this method will click on category link
	 */
	void edit();
	
	/**
	 * this method will be useful to submit any page which is a type of rule
	 * instance
	 * 
	 */
	void submit();

	/**
	 * this method will be useful to switch among the tabs in Edit Segment page
	 * 
	 * @param tabName
	 *            is the tab name to which you want to switch
	 */
	void switchTab(String tabName);

	/**
	 * this method will create and open the rule
	 */
	public void createAndOpen();

	/**
	 * this method sets the given issue in Rule configuration
	 * 
	 * @param issue
	 *            issue to be set in Rule
	 */
	void setIssue(String issue);

	/**
	 * this method sets the given group in Rule configuration
	 * 
	 * @param group
	 *            group to be set in Rule
	 */
	void setGroup(String group);

	/**
	 * It is to set the rule name
	 * 
	 * @param name
	 */
	void setRuleName(String name);

	/**
	 * selects the given Dev branch in Rule configuration page
	 * 
	 * @param devBranch
	 *            branch to be selected
	 */
	void selectDevBranch(String devBranch);

	/**
	 * It is used to checkout the rule instance
	 */
	void checkout();

	/**
	 * It is used to checkin the rule instance with the given comment
	 * 
	 * @param comment
	 */
	void checkin(String comment);

	/**
	 * closes rule
	 * 
	 */
	void close();
	/**
	 *  it is used to set given budget 
	 * @param budget
	 */
	void setBudget(String budget);
	/**
	 * It is used to create Rule
	 */
	void create();
	/**
	 * runs rule
	 * 
	 */
	void run();

}
