package com.pega.pm.pages;

import org.openqa.selenium.By;

import com.pega.pm.rules.EmailTreatment;
import com.pega.pm.rules.SMSTreatment;
import com.pega.util.XPathUtil;

public interface Treatments extends LandingPage {

	By TREATMENTS_PAGE_HEADER = By.xpath("//span[text()='Treatments' and @class='workarea_header_titles']");
	By ISSUE_GROUP_DIV = By.xpath("//div[contains(@data-click,'ShowIssueGroupOverlay')]");
	By SEARCH_INPUT_BOX = By.xpath(XPathUtil.getDataTestIDXpath("20160202134136053752179"));
	By EMAILS_TAB = By.xpath("//span[text()='Emails']");
	By SMS_TAB = By.xpath("//span[text()='SMS']");
	By SECTIONS_TAB = By.xpath("//span[text()='Sections']");
	By PARAGRAPHS_TAB = By.xpath("//span[text()='Paragraphs']");
	By CREATE_EMAIL_SPAN = By.xpath("//span[text()='Create email']");
	By CREATE_SMS_SPAN = By.xpath("//span[text()='Create SMS']");

	/**
	 * this method just clicks on create method
	 */
	void create();

	/**
	 * this method clicks on Create email link
	 * 
	 * @return Create Email Treatment page
	 */
	EmailTreatment createEmailTreatment();

	SMSTreatment createSMSTreatment();
}
