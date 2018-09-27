/*
 * $Id$
 *
 * Copyright (c) 2018  Pegasystems Inc.
 * All rights reserved.
 *
 * This  software  has  been  provided pursuant  to  a  License
 * Agreement  containing  restrictions on  its  use.   The  software
 * contains  valuable  trade secrets and proprietary information  of
 * Pegasystems Inc and is protected by  federal   copyright law.  It
 * may  not be copied,  modified,  translated or distributed in  any
 * form or medium,  disclosed to third parties or used in any manner
 * not provided for in  said  License Agreement except with  written
 * authorization from Pegasystems Inc.
*/

package com.pega.pm.dialog;

import org.openqa.selenium.By;

public interface ConfigureDialog extends ModalDialog {


	By SEARCH_INPUT = By.xpath("//input[@id='pyValue']");
	By SEARCH_ICON = By.xpath("//*[contains(@class,'pi-search')]");
	By DIALOG_HEADER = By.xpath("//span[contains(@id,'modaldialog_hd')]");
	By ADD_BUTTON = By.xpath("//button[text()='Add']");
	By REMOVE_BUTTON=By.xpath("//button[@class='MKTSelected pzhc pzbutton' and text()='Remove']");
	By FIRST_ADD_BUTTON = By
			.xpath("(//div[contains(@data-repeat-source,'MultiSelectCardSelector')]//button[text()='Add'])[1]");
	By STRATEGY_SEARCH_RESULT = By.xpath("//span[contains(@class,'primary_info')]");
	By STRATEGY_LINK = By.xpath("//a[@data-ctl = 'Link' and contains(@name,'ListCardGroup')]");
	By DELETE_ICON = By.xpath("//a[(@class='iconDelete')]");
	By ISSUE_GROUP_DETAILS_TEXT = By.xpath("//span[(@class='strong')]");

	/**
	 * this method adds given rule (like segment,strategy,etc) from search
	 * results
	 * 
	 * @param ruleName(like
	 *            segment,strategy,etc)
	 */

	void addRule(String ruleName);

	/**
	 * this method searches for the rule that contains given search text
	 * 
	 * @param searchText
	 *            is a char sequence used to search
	 */
	void search(String searchText);
	/**
	 * this will verify whether segment is added successfully
	 * 
	 * @return it will return true if remove button and delete button is
	 *         present
	 */
	boolean isSegmentAdded();
	
}
