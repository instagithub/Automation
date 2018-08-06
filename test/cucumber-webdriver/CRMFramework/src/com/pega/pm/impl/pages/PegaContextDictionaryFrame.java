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

package com.pega.pm.impl.pages;


import org.openqa.selenium.WebElement;

import com.pega.framework.elmt.FrameImpl;
import com.pega.pm.pages.ContextDictionary;
import com.pega.pm.rules.RuleInstance;

public class PegaContextDictionaryFrame  extends FrameImpl implements ContextDictionary{
	
	

	public PegaContextDictionaryFrame(WebElement elmt, String elmtId) {
		super(elmt, elmtId);
	}

	public PegaContextDictionaryFrame(WebElement elmt) {
		super(elmt);
	}

	public void save() {
		findElement(RuleInstance.SAVE_BUTTON).click();
		
	}

	public void close() {
		findElement(CLOSE_BUTTON).click(false);
		
		
	}
	
	

}
