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

package com.pega.crm.pegamarketing.impl.dialog;

import org.openqa.selenium.By;

import com.pega.TestEnvironment;
import com.pega.crm.pegamarketing.dialog.ConfigureAudienceDialog;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;

public class PegaConfigureAudienceDialog extends PegaConfigureDialog implements ConfigureAudienceDialog {
	TestEnvironment testEnv;
	PegaWebDriver pegaDriver;
	PegaWebElement elmt;

	public PegaConfigureAudienceDialog(Frame aElmt) {
		super(aElmt);
		elmt = aElmt;
	}

	public void selectFirstSearchResult() {
		elmt.findElement(FIRST_SEARCH_RESULT).click(false);
		
	}
	
	public void addFirstSegment() {
		elmt.findElement(FIRST_ADD_BUTTON).click();
	}


	public void selectFromFirstSearchResult() {
		elmt.findElement(FIRST_SEARCH_RESULT_LABEL).click(false);
		
	}

	public void addSegment(String segmentName) {
		elmt.findElement(By.xpath("//div[@node_name='SimpleMultiselectorCardContent'][.//span[text()='"+segmentName+"']]//button[text()='Add']")).click();
	}

	

}
