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

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;

public class PegaConfigureDialog extends PegaModalDialog implements ConfigureDialog {
	PegaWebDriver pegaDriver;
	TestEnvironment testEnv;
	protected PegaWebElement elmt;

	public PegaConfigureDialog(Frame aElmt) {
		super(aElmt);
		this.elmt = aElmt;
		this.testEnv = elmt.getTestEnvironment();
		pegaDriver = testEnv.getPegaDriver();
	}
	public void addRule(String ruleName) {
		elmt.findElement(ADD_BUTTON).click();
	}

	
	public void search(String searchText) {
		elmt.findElement(SEARCH_INPUT).sendKeys(searchText);
		elmt.findElement(SEARCH_ICON).click();
	}
	public boolean isSegmentAdded() {
		pegaDriver.switchToActiveFrame();
		boolean isRemoveFound = elmt.verifyElement(REMOVE_BUTTON);
		boolean isDeleteButtonFound = elmt.verifyElement(DELETE_ICON);
		return isRemoveFound && isDeleteButtonFound;
	}
}
